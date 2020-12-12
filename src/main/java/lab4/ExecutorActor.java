package lab4;


import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ExecutorActor extends AbstractActor {
    private static final NAME = 
    public Receive createReceive(){
        return receiveBuilder().match(UnitT.class, m -> {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("eName");
            engine.eval(m.getJsScript());
            Invocable invocable = (Invocable) engine;
            Object result = invocable.invokeFunction(m.getFunctionName(), m.getParams().toArray().toString());
            if (result.equals(m.getExpectedResult())) {
                sender().tell(new TestResult(m.getPackageID(),m.getTestName(), "true"), self());
            } else {
                sender().tell(new TestResult(m.getPackageID(),m.getTestName(), "false"), self());
            }
        }).build();
    }


}
