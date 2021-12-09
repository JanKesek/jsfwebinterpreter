import org.assertj.core.api.Assertions;
import interpretermain.webinterpreter.InterpreterService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterpreterServiceTest {
    InterpreterService interpreterService = new InterpreterService();

    @Test
    void testJavascriptPrint() {
        Assertions.assertThat(interpreterService.printInterpret("print(5+2)", "nashorn"))
            .isEqualToIgnoringWhitespace("7");
    }

    @Test
    void testJavascriptNumber() {

        Assertions.assertThat(interpreterService.printInterpret("7", "nashorn"))
            .isEqualToIgnoringWhitespace("7");
    }

}
