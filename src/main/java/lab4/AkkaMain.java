package lab4;

import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.server.Route;
import akka.pattern.Patterns;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import akka.util.Timeout;

import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletionStage;

import scala.concurrent.Future;
import static akka.http.javadsl.server.Directives.*;

public class AkkaMain {
    public static void main() throws Exception{
        ActorSystem actorSystem =  ActorSystem.create("Akka");
        Props props1 = Props.create(RouterActor.class);
        ActorRef actorRef = actorSystem.actorOf(props1);

        final Http http = Http.get(actorSystem);
        final ActorMaterializer actorMaterializer = ActorMaterializer.create(actorSystem);
        Flow<HttpRequest, HttpResponse, NotUsed> flow = myRoute(actorRef).flow(actorSystem, actorMaterializer);
        final CompletionStage<ServerBinding> bindingCompletionStage = http.bindAndHandle(
                flow,
                ConnectHttp.toHost("localhost", 8084),
                actorMaterializer
        );
        System.out.println("localhost: 8084");
        System.in.read();
        bindingCompletionStage.thenCompose(ServerBinding::unbind).thenAccept(m->actorSystem.terminate());
    }

    private static Route myRoute(ActorRef router){
        return route(
                post(()->entity(Jackson.unmarshaller(JSONContainer.class), j -> {
                    router.tell(j, ActorRef.noSender());
                    return complete("true");
                })),
                get(()-> parameter("packageId", j->{
                    Future<Object> future = Patterns.ask(router, j.toString(), Timeout.create(Duration.ofSeconds(40)));
                    return completeOKWithFuture(future, Jackson.marshaller());
                })));
    }
}
