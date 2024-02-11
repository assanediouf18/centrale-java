package org.centrale.api.service;

import org.centrale.api.entity.PlayerEntity;
import org.centrale.domain.shifumi.Hand;
import org.centrale.domain.shifumi.HandFactory;
import org.centrale.domain.shifumi.Shifumi;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameManager {
    private final Shifumi jeu;
    private List<PlayerEntity> players;
    private List<Integer> scores;
    private List<Hand> roundHands;

    private int handsTillNextRound = 2;

    public GameManager() {
        jeu = new Shifumi();
        players = new ArrayList<PlayerEntity>();
        scores = new ArrayList<Integer>();
        roundHands = new ArrayList<Hand>();
    }

    public Shifumi getJeu() {
        return jeu;
    }

    public List<PlayerEntity> getPlayers() {
        return players;
    }

    public void addPlayer(PlayerEntity player)
    {
        if(players.size() >= 2) {
            return;
        }
        players.add(player);
        scores.add(0);
        roundHands.add(null);
    }

    public void setPlayerHand(PlayerEntity player, String hand) throws Exception {
        int index = players.indexOf(player);
        if(index < 0) throw new Exception("Le joueur renseigné est introuvable");
        roundHands.set(index, HandFactory.from(hand));
        int sum = 0;
        for(int i = 0; i < players.size(); i++) {
            if(roundHands.get(i) == null) {
                sum++;
            }
        }
        handsTillNextRound = sum;
    }

    public void setPlayerScore(PlayerEntity player, int score)
    {
        int index = players.indexOf(player);
        scores.set(index, score);
    }

    public Integer getPlayerScore(PlayerEntity player)
    {
        int index = players.indexOf(player);
        return scores.get(index);
    }

    public List<String> getCurrentHands()
    {
        List<String> response = new ArrayList<String>();
        for(int i = 0; i < roundHands.size(); i++)
        {
            Hand hand = roundHands.get(i);
            if(hand != null) {
                response.add(players.get(i) + " a joué " + hand.getHandName());
            } else {
                response.add(players.get(i) + " n'a pas encore joué");
            }
        }
        return response;
    }

    public int playRound()
    {
        if(handsTillNextRound == 0) {
            switch (jeu.playRound(roundHands.get(0), roundHands.get(1))) {
                case 1:
                    scores.set(0, scores.get(0) + 1);
                    break;
                case -1:
                    scores.set(1, scores.get(1) + 1);
                    break;
                default:
                    break;
            }
            handsTillNextRound = 2;
            roundHands.replaceAll(ignored -> null);
            return 0;
        }
        return 400;
    }

    public List<Integer> getScores()
    {
        return scores;
    }
}
