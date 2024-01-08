package org.centrale.domain.shifumi;

public interface Hand {

    int playWith(Hand h);

    int playWithPierre(Pierre p);

    int playWithCiseaux(Ciseaux c);

    int playWithFeuille(Feuille f);

    String getHandName();

}
