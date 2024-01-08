package org.centrale.domain.tourniquet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTourniquet {

    @Test
    public void testInsererTicket()
    {
        Tourniquet tourniquet = new Tourniquet();

        //Etat bloque
        tourniquet.setEtat(new EtatBloque());
        tourniquet.insererTicket("ticket");
        Assertions.assertInstanceOf(EtatBloque.class, tourniquet.getEtat());
        tourniquet.insererTicket("java");
        Assertions.assertInstanceOf(EtatOuvert.class, tourniquet.getEtat());

        //Etat ouvert
        tourniquet.setEtat(new EtatOuvert());
        tourniquet.insererTicket("java");
        Assertions.assertInstanceOf(EtatOuvert.class, tourniquet.getEtat());
        tourniquet.insererTicket("ticket");
        Assertions.assertInstanceOf(EtatBloque.class, tourniquet.getEtat());
    }

    @Test
    public void testTourner()
    {
        Tourniquet tourniquet = new Tourniquet();

        Assertions.assertInstanceOf(EtatBloque.class, tourniquet.getEtat());
        tourniquet.tourner();
        Assertions.assertInstanceOf(EtatBloque.class, tourniquet.getEtat());

        tourniquet.insererTicket("java");
        Assertions.assertInstanceOf(EtatOuvert.class, tourniquet.getEtat());
        tourniquet.tourner();
        Assertions.assertInstanceOf(EtatBloque.class, tourniquet.getEtat());
    }
}
