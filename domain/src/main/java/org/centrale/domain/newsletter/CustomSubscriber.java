package org.centrale.domain.newsletter;

public class CustomSubscriber implements ISubscriber{

    private final String name;
    private final String reaction;

    public CustomSubscriber(String name, String reaction)
    {
        this.name = name;
        this.reaction = reaction;
    }

    @Override
    public void update(String emailObject) {
        System.out.println(name + " : " + reaction + " (objet: " + emailObject + ")");
    }
}
