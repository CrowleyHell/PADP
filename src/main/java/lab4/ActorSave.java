package lab4;


import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.HashMap;
import java.util.Map;

public class ActorSave extends AbstractActor {
    private Map<String, String> store = new HashMap<>();
    @Override
    public Receive createReceive(){
        return ReceiveBuilder.create()
    }

}
