package org.centrale.domain.tourniquet;

public class EtatBloque implements State {

    @Override
    public State insererTicketValide() {
        return new EtatOuvert();
    }

    @Override
    public State insererTicketInvalide() {
        return this;
    }

    @Override
    public State tourner() {
        return this;
    }

    @Override
    public String getName() {
        return "Etat bloqué";
    }
}
