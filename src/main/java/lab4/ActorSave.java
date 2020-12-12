package lab4;


import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.HashMap;
import java.util.Map;

public class ActorSave extends AbstractActor {
    private Map<Integer, String> store = new HashMap<>();
    @Override
    public Receive createReceive(){
        return ReceiveBuilder.create().match(TestResult.class, m -> {
            System.out.println("Message received" + m.getName());
            store.put(m.getID(), )
        })
    }

}
