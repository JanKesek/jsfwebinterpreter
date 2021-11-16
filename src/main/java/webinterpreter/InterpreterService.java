package webinterpreter;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.Serializable;
import java.io.StringWriter;

@Stateless
@Dependent
public class InterpreterService {

   // private CasterService casterService;

    public InterpreterService() {}

    private String interpret(ScriptEngine engine, String sourceCode) {
        try {
            return (String)engine.eval(sourceCode);
        }
        catch (ScriptException se) {
            return se.getMessage();
        }
    }

    private ScriptEngine getEngine(String engineName) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName(engineName);
        return engine;
    }

    public String printInterpret(String sourceCode, String engineName) {
        System.out.println("printInterpret");
        StringWriter writer = new StringWriter();
        ScriptEngine engine = getEngine(engineName);
        engine.getContext().setWriter(writer);
        interpret(engine, sourceCode);
        return writer.toString();
    }
}
