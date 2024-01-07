package org.centrale.domain;

public class HandFactory {

    public static Hand from(String hand){
        return switch (hand) {
            case "Pierre" -> new Pierre();
            case "Feuille" -> new Feuille();
            default -> new Ciseaux();
        };
    }

}
