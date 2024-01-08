package org.centrale.domain.shifumi;

import lombok.NoArgsConstructor;

@NoArgsConstructor // cf https://projectlombok.org
public class Pierre implements Hand {


    @Override
    public int playWith(Hand h) {
        return -h.playWithPierre(this);
    }

    @Override
    public int playWithPierre(Pierre p) {
        return 0;
    }

    @Override
    public int playWithCiseaux(Ciseaux c) {
        return 1;
    }

    @Override
    public int playWithFeuille(Feuille f) {
        return -1;
    }

    @Override
    public String getHandName() {
        return "Pierre";
    }
}
