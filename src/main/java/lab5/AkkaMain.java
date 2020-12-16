package lab5;

import akka.actor.ActorSystem;

import java.io.IOException;

public class AkkaMain {
    public static void main(String[] args) throws IOException{
        System.out.println("start");
        ActorSystem actorSystem = ActorSystem.create("routes");
        
    }
}
