import webinterpreter.InterpreterService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterpreterServiceTest {
    InterpreterService interpreterService = new InterpreterService();

    @Test
    void testJavascriptPrint() {
        assertEquals("7\n",interpreterService.printInterpret("print(5+2)", "nashorn"));
    }
    @Test
    void testJavascriptNumber() {
        assertEquals("7\n",interpreterService.printInterpret("7", "nashorn"));
    }

}
