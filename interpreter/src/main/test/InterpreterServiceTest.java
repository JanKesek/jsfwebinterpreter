import interpretermain.interpreterengines.JavascriptNashornEngine;
import org.assertj.core.api.Assertions;
import interpretermain.webinterpreter.InterpreterService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterpreterServiceTest {
    InterpreterService interpreterService = new InterpreterService();

    @Test
    void testJavascriptPrint() {
        Assertions.assertThat(interpreterService.printInterpret(new JavascriptNashornEngine(), "print(5+2)"))
            .isEqualToIgnoringWhitespace("7");
    }

    @Test
    void testJavascriptNumber() {

        Assertions.assertThat(interpreterService.printInterpret(new JavascriptNashornEngine(), "7"))
            .isEqualToIgnoringWhitespace("7");
    }

    @Test
    void testPrintNumberHtml() {
        Assertions.assertThat(interpreterService.printInterpret(new JavascriptNashornEngine(), "<p>print(5+2);</p> "))
            .isEqualToIgnoringWhitespace("7");
    }

}
