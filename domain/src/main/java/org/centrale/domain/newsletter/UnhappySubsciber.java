package org.centrale.domain.newsletter;

public class UnhappySubsciber implements ISubscriber{
    @Override
    public void update(String emailObject) {
        System.out.println("Unhappy subscriber : Mais pourquoi je me suis inscrit à cette newsletter déjà ? Regarde moi cet objet de mail : " + emailObject);
    }
}
