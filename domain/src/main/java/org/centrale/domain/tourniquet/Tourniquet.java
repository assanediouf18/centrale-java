package org.centrale.domain.tourniquet;

import java.util.Objects;

public class Tourniquet {
    State etat = new EtatBloque();

    public String etatActuel() {
        return etat.getName();
    }

    public void tourner(String ticket) {
        if(ticket.equalsIgnoreCase("Java")) {
            etat = etat.insererTicketValide();
        } else {
            etat = etat.insererTicketInvalide();
        }
    }
}
