package org.centrale.domain.shifumi;

public class HandFactory {

    public static Hand from(String hand){
        return switch (hand) {
            case "Pierre" -> new Pierre();
            case "Feuille" -> new Feuille();
            default -> new Ciseaux();
        };
    }

}
