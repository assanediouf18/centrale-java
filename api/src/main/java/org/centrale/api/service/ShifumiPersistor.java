package org.centrale.api.service;

import org.centrale.api.entity.PlayerEntity;
import org.centrale.api.entity.ShifumiEntity;
import org.centrale.api.repository.ShifumiRepository;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class ShifumiPersistor {
    ShifumiRepository shifumiRepository;

    public ShifumiPersistor(ShifumiRepository repo) {
        shifumiRepository = repo;
    }

    public GameManager getGameManager(Integer id) throws Exception {
        Optional<ShifumiEntity> query = shifumiRepository.findById(id);
        if(query.isEmpty()) {
            return createShifumiEntity();
        }

        ShifumiEntity game = query.get();
        GameManager gameManager = new GameManager();
        insertPlayerData(game.getPlayer1(), game.getScore1(), gameManager);
        insertPlayerData(game.getPlayer2(), game.getScore2(), gameManager);
        return gameManager;
    }

    private GameManager createShifumiEntity() {
        ShifumiEntity game = new ShifumiEntity();
        game.setId((int) shifumiRepository.count() + 1);
        shifumiRepository.save(game);
        return new GameManager();
    }

    private static void insertPlayerData(PlayerEntity player, int score, GameManager gameManager) throws Exception {
        gameManager.addPlayer(player);
        gameManager.setPlayerScore(player, score);
    }
}
