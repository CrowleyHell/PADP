package lab4;

import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.Http;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AkkaMain {
    public static void main() throws Exception{
        ActorSystem actorSystem =  ActorSystem.create("Akka");
        Props props1 = Props.create(Router.class);
        ActorRef actorRef = actorSystem.actorOf(props1);

        final Http http = Http.get(actorSystem);
        ActorMaterializer actorMaterializer = ActorMaterializer.create(actorSystem);
        AkkaMain sample = new AkkaMain();
        Flow<HttpRequest, HttpResponse, NotUsed>
    }
}
