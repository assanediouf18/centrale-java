package org.centrale.domain.tourniquet;

public class EtatOuvert implements State {
    @Override
    public State insererTicketValide() {
        return this;
    }

    @Override
    public State insererTicketInvalide() {
        return new EtatBloque();
    }

    @Override
    public State tourner() {
        return new EtatBloque();
    }

    @Override
    public String getName() {
        return "Etat débloqué";
    }
}
