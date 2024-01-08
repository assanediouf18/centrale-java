package org.centrale.domain.tourniquet;

public interface State {
    public State insererTicketValide();
    public State insererTicketInvalide();

    public String getName();
}
