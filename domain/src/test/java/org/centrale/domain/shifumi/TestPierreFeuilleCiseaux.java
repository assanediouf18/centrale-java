package org.centrale.domain.shifumi;

import org.centrale.domain.shifumi.Ciseaux;
import org.centrale.domain.shifumi.Feuille;
import org.centrale.domain.shifumi.Hand;
import org.centrale.domain.shifumi.Pierre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPierreFeuilleCiseaux {

    @Test 
    public void jeuEgalite(){
        Hand p = new Pierre();
        Hand f = new Feuille();
        Hand c = new Ciseaux();
        Assertions.assertEquals(p.playWith(new Pierre()), 0);
        Assertions.assertEquals(f.playWith(new Feuille()), 0);
        Assertions.assertEquals(c.playWith(new Ciseaux()), 0);
    }

    @Test
    public void mainsFonctionnelles(){
        Hand p = new Pierre();
        Hand f = new Feuille();
        Hand c = new Ciseaux();
        //WIN
        Assertions.assertEquals(p.playWith(new Ciseaux()), 1);
        Assertions.assertEquals(f.playWith(new Pierre()), 1);
        Assertions.assertEquals(c.playWith(new Feuille()), 1);
        //LOSE
        Assertions.assertEquals(p.playWith(new Feuille()), -1);
        Assertions.assertEquals(f.playWith(new Ciseaux()), -1);
        Assertions.assertEquals(c.playWith(new Pierre()), -1);
    }

}
