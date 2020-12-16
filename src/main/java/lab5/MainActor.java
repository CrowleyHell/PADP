package lab5;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.HashMap;
import java.util.Map;

public class MainActor extends AbstractActor {
    private final Map<String, Float> store = new HashMap<>();
    public Receive createReceive(){
        return ReceiveBuilder.create()
                .match(String.class, s -> {
                    sender().tell(store.getOrDefault(s, float(-1.0)));
                })
    }
}
