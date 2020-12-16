package lab5;

import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.japi.Pair;
import akka.pattern.Patterns;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;

import java.io.IOException;
import java.util.concurrent.CompletionStage;
import java.util.regex.Pattern;

import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;

import static java.lang.Float.parseFloat;

public class AkkaMain {
    private final ActorRef actorRef;
    public static void main(String[] args) throws IOException{
        System.out.println("start");
        ActorSystem actorSystem = ActorSystem.create("routes");
        final Http http = Http.get(actorSystem);
        final ActorMaterializer actorMaterializer = ActorMaterializer.create(actorSystem);
        final Flow<HttpRequest, HttpResponse, NotUsed> flow = actorFlow(http, actorMaterializer, actorSystem);
        final CompletionStage<ServerBinding> bindingCompletionStage = http.bindAndHandle(
                flow,
                ConnectHttp.toHost("localhost", 8040),
                actorMaterializer
        );
        System.out.println("localhost:8040");
        System.in.read();
        bindingCompletionStage.thenCompose(ServerBinding::unbind)
                .thenAccept(u->actorSystem.terminate());
    }

    public AkkaMain(ActorSystem actorSystem) {
        this.actorRef = actorSystem.actorOf(actorRef);
    }

    private static Flow<HttpRequest, HttpResponse, NotUsed> actorFlow(Http http, ActorMaterializer actorMaterializer, ActorSystem actorSystem){
        return Flow.of(HttpRequest.class).map(h->{
            String url = h.getUri().query().get("test").get();
            String count = h.getUri().query().getOrElse("Counter", "1");
            Float countFloat = parseFloat(count);
            return new Pair<String, Float>(url, countFloat);
        })
                .mapAsync(1, (Pair<String, Float> pair) -> Patterns.ask())
    }
}
