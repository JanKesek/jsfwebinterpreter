package interpretermain.interpreterengines;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import interpretermain.webinterpreter.InterpreterMenu;

import java.util.Arrays;
import java.util.List;

@Configuration("interpreterFactory")
public class InterpreterFactory {
    @Bean
    public InterpreterMenu getInterpreterMenu() {
        return new InterpreterMenu();
    }
    @Bean
    public List<InterpreterEngine> engineList() {
        return Arrays.asList(new JavascriptNashornEngine());
    }
}
