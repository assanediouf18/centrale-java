package org.centrale.domain.tourniquet;

public interface State {
    public State insererTicketValide();
    public State insererTicketInvalide();
    public State tourner();

    public String getName();
}
