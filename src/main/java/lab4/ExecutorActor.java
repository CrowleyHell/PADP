package lab4;


import akka.actor.AbstractActor;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ExecutorActor extends AbstractActor {
    private static final String NAME = "eName";
    private static final String SUCCESS = "true";
    private static final String FAIL = "false";
    public Receive createReceive(){
        return receiveBuilder().match(UnitT.class, m -> {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName(NAME);
            engine.eval(m.getJsScript());
            Invocable invocable = (Invocable) engine;
            Object result = invocable.invokeFunction(m.getFunctionName(), m.getParams().toArray().toString());
            if (result.equals(m.getExpectedResult())) {
                sender().tell(new TestResult(m.getPackageID(),m.getTestName(), SUCCESS), self());
            } else {
                sender().tell(new TestResult(m.getPackageID(),m.getTestName(), FAIL), self());
            }
        }).build();
    }


}
