package org.centrale.domain.newsletter;

public class FanBoySubscriber implements ISubscriber{
    @Override
    public void update(String emailObject) {
        System.out.println("FanBoy : Oh super ! J'ai reçu un nouveau mail trop cool ! Regarde, l'objet est : " + emailObject);
    }
}
