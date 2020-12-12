package lab4;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.http.javadsl.server.Route;

public class Router {
    private Route RouteCreate(ActorSystem actorSystem, ActorRef actorRef){
        return bind(get(() -> ))
    }

}
