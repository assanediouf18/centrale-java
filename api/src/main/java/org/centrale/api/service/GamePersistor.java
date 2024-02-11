package org.centrale.api.service;

import org.centrale.api.entity.ShifumiEntity;
import org.centrale.api.repository.ShifumiRepository;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class GamePersistor {
    ShifumiRepository gameRepository;

    public GamePersistor(ShifumiRepository repo) {
        gameRepository = repo;
    }

    public GameManager getGameManager(Integer id) throws Exception {
        Optional<ShifumiEntity> query = gameRepository.findById(id);
        if(query.isEmpty()) {
            return createShifumiEntity();
        }

        ShifumiEntity game = query.get();
        GameManager gameManager = new GameManager();
        insertPlayerData(game.getPlayer1(), game.getHand1(), game.getScore1(), gameManager);
        insertPlayerData(game.getPlayer2(), game.getHand2(), game.getScore2(), gameManager);
        return gameManager;
    }

    private GameManager createShifumiEntity() {
        ShifumiEntity game = new ShifumiEntity();
        game.setId((int) gameRepository.count() + 1);
        gameRepository.save(game);
        return new GameManager();
    }

    private static void insertPlayerData(String playerName, String hand, int score, GameManager gameManager) throws Exception {
        if(!Objects.equals(playerName, "")) {
            gameManager.addPlayer(playerName);
            gameManager.setPlayerScore(playerName, score);
            if(!Objects.equals(hand, "")) {
                gameManager.setPlayerHand(playerName, hand);
            }
        }
    }
}
