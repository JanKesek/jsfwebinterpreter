package interpretermain.webinterpreter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.StringWriter;

public abstract class InterpreterEnginePreparation {
    public ScriptEngine prepareEngine(String engineName) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName(engineName);
        return engine;
    }

    public StringWriter prepareWriter(ScriptEngine engine) {
        StringWriter writer = new StringWriter();
        engine.getContext().setWriter(writer);
        return writer;
    }
}
