package lab5;

import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.japi.Pair;
import akka.pattern.Patterns;
import akka.stream.ActorMaterializer;


import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import akka.stream.javadsl.Flow;
import akka.stream.javadsl.Keep;
import akka.stream.javadsl.Sink;

import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.stream.javadsl.Source;
import org.asynchttpclient.AsyncHttpClient;

import static java.lang.Integer.parseInt;
import static org.asynchttpclient.Dsl.asyncHttpClient;

import static java.lang.Float.parseFloat;

public class AkkaMain {
    public static void main(String[] args) throws IOException{
        System.out.println("start");
        ActorSystem actorSystem = ActorSystem.create("routes");
        ActorRef actorRef = actorSystem.actorOf(Props.create(MainActor.class));
        final Http http = Http.get(actorSystem);
        final ActorMaterializer actorMaterializer = ActorMaterializer.create(actorSystem);
        final Flow<HttpRequest, HttpResponse, NotUsed> flow = actorFlow(http, actorMaterializer, actorRef);
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


    private static Flow<HttpRequest, HttpResponse, NotUsed> actorFlow(Http http, ActorMaterializer actorMaterializer, ActorRef actorRef){
        return Flow.of(HttpRequest.class).map(h->{
            String url = h.getUri().query().get("test").get();
            String count = h.getUri().query().getOrElse("Counter", "1");
            Integer countFloat = parseInt(count);
            return new Pair<>(url, countFloat);
        })
                .mapAsync(2, (Pair<String, Integer> pair) ->
                        Patterns.ask(actorRef, pair.first(), Duration.ofSeconds(40)).thenCompose((Object o)->{
                    if((float) o >= 0){
                        return CompletableFuture.completedFuture(new Pair<String, Integer>(pair.first(), (int)o));
                    }
                    Flow<Pair<String, Integer>, Long, NotUsed> floatNotUsedFlow = Flow.<Pair<String, Integer>>create()
                            .mapConcat(param -> new ArrayList<>(Collections.nCopies(param.second(), param.first())))
                            .mapAsync(pair.second(), (String r) -> {
                                AsyncHttpClient asyncHttpClient = asyncHttpClient();
                                long start = System.currentTimeMillis();
                                asyncHttpClient.prepareGet(r).execute();
                                return CompletableFuture.completedFuture(System.currentTimeMillis() - start);
                            });
                    return Source.single(pair)
                            .via(floatNotUsedFlow)
                            .toMat(Sink.fold(0L, Long::sum), Keep.right())
                            .run(actorMaterializer)
                            .thenApply(sum -> new Pair<>(pair.first(), (int)(sum/pair.second())));
                    }))
                .map((par) -> {
                    actorRef.tell(new MessageStore(par.first(), par.second()), ActorRef.noSender());
                    return 

                        }

    })
}
