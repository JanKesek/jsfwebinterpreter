import webinterpreter.EditorBean;
import webinterpreter.InterpreterService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditorBeanTest {
    EditorBean editorBean = new EditorBean(new InterpreterService(), "test");
    @Test
    void testEditor() {
        assertEquals("This editor is provided by PrimeFaces",editorBean.getValue());
    }
}
