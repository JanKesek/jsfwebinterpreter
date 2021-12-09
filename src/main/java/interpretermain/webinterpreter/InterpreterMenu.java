package interpretermain.webinterpreter;

import interpretermain.interpreterengines.InterpreterEngine;
import interpretermain.interpreterengines.JavascriptNashornEngine;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@NoArgsConstructor
@Component
public class InterpreterMenu {
    @Autowired
    List<InterpreterEngine> engines;

    public List<String> getViewInterpreterMenu() {
        return engines.stream().map(InterpreterEngine::getEngineNameView).collect(Collectors.toList());
    }

    public String getEngineByViewName(String engineNameView) {
        InterpreterEngine engineToEvaluate = engines.stream()
            .filter(e -> engineNameView.equals(e.getEngineNameView()))
            .findFirst().orElse(new JavascriptNashornEngine());
        return engineToEvaluate.getEngineName();
    }
}
