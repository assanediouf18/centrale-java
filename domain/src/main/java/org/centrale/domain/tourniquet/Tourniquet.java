package org.centrale.domain.tourniquet;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Tourniquet {
    State etat = new EtatBloque();

    public String etatActuel() {
        return etat.getName();
    }

    public void insererTicket(String ticket) {
        if(ticket.equalsIgnoreCase("Java")) {
            etat = etat.insererTicketValide();
        } else {
            etat = etat.insererTicketInvalide();
        }
    }

    public void tourner() {
        etat = etat.tourner();
    }

}
