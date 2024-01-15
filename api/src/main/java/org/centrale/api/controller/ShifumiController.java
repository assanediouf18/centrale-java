package org.centrale.api.controller;

import org.centrale.api.service.GameManager;
import org.centrale.domain.shifumi.HandFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ShifumiController {
    GameManager gameManager;

    public ShifumiController(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @PostMapping("/play")
    public List<String> play(@RequestParam String playerName, @RequestParam String hand) throws Exception {
        gameManager.setPlayerHand(playerName, hand);
        int result = gameManager.playRound();
        if(result == 400) return gameManager.getCurrentHands();
        return gameManager.getScores();
    }

    @PostMapping("/player")
    public List<String> addPlayer(@RequestParam String name)
    {
        gameManager.addPlayer(name);
        return gameManager.getPlayers();
    }

    @GetMapping("/hands")
    public List<String> getCurrentHands()
    {
        return gameManager.getCurrentHands();
    }

    @GetMapping("/scores")
    public List<String> getScores()
    {
        return gameManager.getScores();
    }
}
