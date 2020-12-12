package lab4;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.Http;

public class AkkaMain {
    public static void main() throws Exception{
        ActorSystem actorSystem =  ActorSystem.create("Akka");
        Props props1 = Props.create(Router.class);
        ActorRef actorRef = actorSystem.actorOf(props1);

        final Http http = http.get(actorSystem);
        
    }
}
