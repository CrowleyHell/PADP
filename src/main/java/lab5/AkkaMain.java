package lab5;

import akka.actor.ActorSystem;
import akka.http.javadsl.Http;

import java.io.IOException;

public class AkkaMain {
    public static void main(String[] args) throws IOException{
        System.out.println("start");
        ActorSystem actorSystem = ActorSystem.create("routes");
        final Http http = Http.get(actorSystem);
        
    }
}
