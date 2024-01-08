package org.centrale.domain.tourniquet;

public class EtatBloque implements State {

    @Override
    public State insererTicketValide() {
        return new EtatOuvert();
    }

    @Override
    public State insererTicketInvalide() {
        return new EtatBloque();
    }

    @Override
    public String getName() {
        return "Etat bloqué";
    }
}
