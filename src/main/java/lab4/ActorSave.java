package lab4;


import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.HashMap;
import java.util.Map;


public class ActorSave extends AbstractActor {
    private Map<String, Map<Integer, String>> store = new HashMap<>();

    private Result IDoutput(String id){
        return new Result(id, store.get(id));
    }
    @Override
    public Receive createReceive(){
        return ReceiveBuilder.create()
                .match(TestResult.class, m -> {
                    System.out.println("Message received" + m.getName());
                    store.putIfAbsent(m.getID(), new HashMap<>());
                    store.put(m.getID(), )})
                .match(String.class, id -> {
                    sender().tell(IDoutput(id), self());
        }).build();
    }

}
