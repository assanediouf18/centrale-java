package org.centrale.api.controller;

import org.centrale.api.entity.GameEntity;
import org.centrale.api.repository.GameRepository;
import org.centrale.api.service.PlayerDBService;
import org.centrale.domain.shifumi.Hand;
import org.centrale.domain.shifumi.HandFactory;
import org.centrale.domain.shifumi.Shifumi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class ExampleController {

    final PlayerDBService playerDBService;
    final GameRepository gameRepository;

    public ExampleController(PlayerDBService playerDBService, GameRepository gameRepository) {
        this.playerDBService = playerDBService;
        this.gameRepository = gameRepository;
    }

    @GetMapping("test")
    public String play(@RequestParam String coup){
        if(Objects.equals(coup, "?")) {
            return "Ecris \"Pierre\", \"Feuille\" ou \"Ciseaux\" pour jouer";
        }
        Shifumi jeu = new Shifumi();
        Hand playerHand = HandFactory.from(coup);
        String response = "Tu joues " + playerHand.getHandName();
        Hand randomHand = jeu.getRandomHand();
        response += ". Le programme joue " + randomHand.getHandName();
        switch(jeu.playRound(playerHand, randomHand)) {
            case 1:
                response += ". Bravo ! Tu as gagné !";
                break;
            case -1:
                response += ". Dommage, tu as perdu";
                break;
            default:
                response += ". Egalité";
        };
        return response;
    }

    @PostMapping("/add")
    public void addPlayer(@RequestParam Integer id, @RequestParam String name) {
        playerDBService.addPlayer(id, name);
    }

    @PostMapping("/addgame")
    public void addGame(@RequestParam Integer id, @RequestParam String description) {
        GameEntity game = new GameEntity();
        game.setId(id);
        game.setDescription(description);
        gameRepository.save(game);
    }
}
