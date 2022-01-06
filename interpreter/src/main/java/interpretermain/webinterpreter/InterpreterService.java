package interpretermain.webinterpreter;

import interpretermain.interpreterengines.InterpreterEngine;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.StringWriter;

@Service
@Log
public class InterpreterService {

   // private CasterService casterService;

    public InterpreterService() {}

    private String interpret(InterpreterEngine engine, String sourceCode) {
        try {
            String result = (String) engine.evaluate(sourceCode);
            log.info(".interpret resull " + result);
            return result;
        }
        catch (ScriptException se) {
            return se.getMessage();
        }
    }

    public String printInterpret(InterpreterEngine engine, String sourceCode) {
        log.info(".printInterpreter " + sourceCode);
        String deleteHTML = ParseUtils.stripHtml(sourceCode);
        return interpret(engine, deleteHTML);
    }
}
