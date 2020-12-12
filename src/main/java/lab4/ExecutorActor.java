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
            int response = -1;
            if (result.equals(m.getExpectedResult())) {
                response = 1;
            } else {
                response = 0;
            }
            
        })

    }


}
