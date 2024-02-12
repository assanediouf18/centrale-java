package org.centrale.api.controller;

import org.centrale.api.entity.PlayerEntity;
import org.centrale.api.entity.ShifumiEntity;
import org.centrale.api.repository.PlayerRepository;
import org.centrale.api.repository.ShifumiEntityManager;
import org.centrale.api.repository.ShifumiRepository;
import org.centrale.api.service.GameManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class ShifumiController {
    private final PlayerRepository playerRepository;
    private final ShifumiRepository shifumiRepository;
    private final ShifumiEntityManager manager;

    public ShifumiController(
            PlayerRepository playerRepository,
            ShifumiRepository shifumiRepository,
            ShifumiEntityManager entityManager
            ) {
        this.playerRepository = playerRepository;
        this.shifumiRepository = shifumiRepository;
        this.manager = entityManager;
    }

    @PostMapping("/play")
    public String play(
            @RequestParam int player1Id,
            @RequestParam int player2Id,
            @RequestParam String handPlayer1,
            @RequestParam String handPlayer2
            ) throws Exception
    {
        Optional<PlayerEntity> query1 = playerRepository.findById(player1Id);
        if(query1.isEmpty()) {
            return "Aucun utilisateur ne correspond à l'id " + player1Id;
        }
        Optional<PlayerEntity> query2 = playerRepository.findById(player2Id);
        if(query2.isEmpty()) {
            return "Aucun utilisateur ne correspond à l'id " + player2Id;
        }

        PlayerEntity player1 = query1.get();
        PlayerEntity player2 = query2.get();
        GameManager gameManager = this.buildGameManager(player1, player2, handPlayer1, handPlayer2);
        int result = gameManager.playRound();
        if(result == 400) return "Une erreur est survenue";

        ShifumiEntity game = this.getShifumiEntity(player1, player2, gameManager);
        shifumiRepository.save(game);
        return game.isEqual() ? "Egalité" : game.getWinner().getName() + " gagne";

    }

    @PostMapping("/player")
    public String addPlayer(@RequestParam String name)
    {
        PlayerEntity newPlayer = new PlayerEntity();
        newPlayer.setName(name);
        playerRepository.save(newPlayer);
        return "Bienvenue " + name + "(id = " + newPlayer.getId() + ")";
    }

    @GetMapping("/player/{id}")
    public String getPlayer(@PathVariable int id)
    {
        Optional<PlayerEntity> query = playerRepository.findById(id);
        if(query.isEmpty())
        {
            return "Cet utilisateur n'existe pas";
        }
        return query.get().getName();
    }

    @GetMapping("/game-stats")
    public String getStats(@RequestParam int playerId1)
    {
        Optional<PlayerEntity> query1 = playerRepository.findById(playerId1);
        if(query1.isEmpty()) {
            return "Aucun utilisateur ne correspond à l'id " + playerId1;
        }
        PlayerEntity player1 = query1.get();
        int victories = this.manager.getWinCount(player1);
        int defeat = this.manager.getLoseCount(player1);
        List<PlayerEntity> ennemy = this.manager.getWorstEnnemy(player1);
        return victories + " victoires, " + defeat + " défaites." +
                (ennemy.isEmpty() ? "" : ennemy.get(0).getName() + " est votre pire adversaire.");
    }

    private ShifumiEntity getShifumiEntity(PlayerEntity player1, PlayerEntity player2, GameManager gameManager) {
        ShifumiEntity game = new ShifumiEntity();
        if(gameManager.getPlayerScore(player1) > gameManager.getPlayerScore(player2)) {
            game.setWinner(player1);
            game.setLoser(player2);
        }
        else {
            game.setLoser(player1);
            game.setWinner(player2);
        }
        game.setEqual(Objects.equals(gameManager.getPlayerScore(player2), gameManager.getPlayerScore(player1)));
        return game;
    }

    private GameManager buildGameManager(
            PlayerEntity player1,
            PlayerEntity player2,
            String handPlayer1,
            String handPlayer2) throws Exception
    {
        GameManager gameManager = new GameManager();
        gameManager.addPlayer(player1);
        gameManager.addPlayer(player2);
        gameManager.setPlayerHand(player1, handPlayer1);
        gameManager.setPlayerHand(player2, handPlayer2);
        return gameManager;
    }
}
