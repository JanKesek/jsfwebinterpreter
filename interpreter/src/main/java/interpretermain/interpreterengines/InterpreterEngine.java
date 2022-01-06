package interpretermain.interpreterengines;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.script.ScriptException;

public interface InterpreterEngine {
    String getEngineName();
    String getEngineNameView();

    String evaluate(String sourceCode) throws ScriptException;
}
