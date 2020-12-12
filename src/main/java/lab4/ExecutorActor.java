package lab4;


import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ExecutorActor extends AbstractActor {
    public Receive createReceive(){
        return receiveBuilder().match(UnitT.class, m -> {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("eName");
            engine.eval(m.getJsScript());
            Invocable invocable = (Invocable) engine;
            Object result = invocable.invokeFunction(m.getFunctionName(), m.getParams().toArray().toString());
            String response;
            if (result.equals(m.getExpectedResult())) {
                response = ;
            } else {
                response = 0;
            }
            sender().tell(new Result(m.getPackageID(), m.getTestName(), response), );
        }).build();
    }


}
