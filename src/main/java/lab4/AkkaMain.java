package lab4;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class AkkaMain {
    public static void main() throws Exception{
        ActorSystem actorSystem =  ActorSystem.create("Akka");
        Props props1 = 
        ActorRef actorRef = actorSystem.actorOf()
    }
}
