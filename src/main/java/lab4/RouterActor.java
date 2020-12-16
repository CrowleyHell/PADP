package lab4;

import akka.actor.*;
import akka.japi.pf.ReceiveBuilder;
import akka.routing.ActorRefRoutee;
import akka.routing.RoundRobinRoutingLogic;
import akka.routing.Routee;
import akka.routing.Router;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;

public class RouterActor extends AbstractActor {
    private ActorRef store;
    private Router router;
    private static final int TRIES = 5;
    private static final Duration TIMEOUT = Duration.ofSeconds(40);
    private SupervisorStrategy supervisorStrategy = new OneForOneStrategy(
            TRIES, TIMEOUT, Collections.singletonList(Exception.class)
    );

    @Override
    public SupervisorStrategy supervisorStrategy() {
        return super.supervisorStrategy();
    }


    public RouterActor(){
        store = getContext().actorOf(Props.create(ActorSave.class));
        ArrayList<Routee> routees = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            ActorRef actorRef = getContext().actorOf(Props.create(ExecutorActor.class));
            getContext().watch(actorRef);
            routees.add(new ActorRefRoutee(actorRef));
        }
        router = new Router(new RoundRobinRoutingLogic(), routees);
    }

    public Receive createReceive(){
        return ReceiveBuilder.create()
                .match(JSONContainer.class, m->{
                    
                }).build();
    }

}
