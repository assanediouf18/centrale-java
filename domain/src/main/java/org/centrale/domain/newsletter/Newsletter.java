package org.centrale.domain.newsletter;

import java.util.ArrayList;
import java.util.List;

public class Newsletter {
    public List<ISubscriber> subscribers;

    public Newsletter()
    {
        subscribers = new ArrayList<ISubscriber>();
    }

    public void sendEmail(String object)
    {
        for(int i = 0; i < subscribers.size(); i++)
        {
            subscribers.get(i).update(object);
        }
    }

    public void addSubscriber(ISubscriber subscriber)
    {
        subscribers.add(subscriber);
    }
}
