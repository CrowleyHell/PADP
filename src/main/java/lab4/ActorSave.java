package lab4;


import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.regex.Pattern;

public class ActorSave extends AbstractActor {
    private Map<Integer, Map<Integer, String>> store = new HashMap<>();

    private Result IDoutput(int id){
        return new Result(id, store.get(id));
    }
    @Override
    public Receive createReceive(){
        return ReceiveBuilder.create().match(TestResult.class, m -> {
            System.out.println("Message received" + m.getName());
            store.put(m.getID(), new HashMap<>());
        }).match(Integer.class, id -> {

            sender().tell(IDoutput(id), self());
        }).build()
    }

}
