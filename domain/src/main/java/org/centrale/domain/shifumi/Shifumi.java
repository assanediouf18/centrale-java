package org.centrale.domain.shifumi;

import java.util.Random;

public class Shifumi {
    int score = 0;
    int roundCound = 0;

    public int playRound(Hand playerHand, Hand aiHand) {
        int outcome = playerHand.playWith(aiHand);
        score += outcome;
        roundCound++;
        return outcome;
    }

    public boolean isOver() {
        return roundCound >= 3;
    }

    public boolean didPlayerWin() {
        return score > 0;
    }

    public Hand getRandomHand() {
        Random r = new Random();
        return switch(r.nextInt(3)) {
            case 0 -> HandFactory.from("Pierre");
            case 1 -> HandFactory.from("Feuille");
            default -> HandFactory.from("Ciseaux");
        };
    }
}
