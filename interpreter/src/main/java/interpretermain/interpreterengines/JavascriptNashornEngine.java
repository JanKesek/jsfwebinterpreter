package interpretermain.interpreterengines;

import interpretermain.webinterpreter.InterpreterEnginePreparation;

import javax.annotation.Resource;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.io.StringWriter;

@Resource(name = "javascriptNashornEngine")
public class JavascriptNashornEngine extends InterpreterEnginePreparation implements InterpreterEngine {
    @Override
    public String getEngineName() {
        return "nashorn";
    }

    @Override
    public String getEngineNameView() {
        return "JavaScript";
    }

    @Override
    public String evaluate(String sourceCode) throws ScriptException {
        ScriptEngine engine = prepareEngine(getEngineName());
        StringWriter writer = prepareWriter(engine);
        StringBuilder resultBuilder = new StringBuilder();
        engine.getContext().setWriter(writer);
        for (String line : sourceCode.split("\n")) {
            if (line.contains("print")) {
                engine.eval(line);
                resultBuilder.append(writer.toString());
            } else {
                resultBuilder.append(engine.eval(line));
                resultBuilder.append("\n");
            }
        }
        return resultBuilder.toString();
    }
}
