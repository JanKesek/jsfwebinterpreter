import interpretermain.interpreterengines.JavascriptNashornEngine;
import interpretermain.webinterpreter.EditorBean;
import interpretermain.webinterpreter.InterpreterMenu;
import interpretermain.webinterpreter.InterpreterService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EditorBeanTest {
    EditorBean editorBean;
    @Mock
    private InterpreterMenu interpreterMenu;

    @BeforeEach
    void initialize() {
        MockitoAnnotations.openMocks(this);
        editorBean = new EditorBean(new InterpreterService(), interpreterMenu);

    }

    @Test
    void stripHTML() {
        when(interpreterMenu.getEngineByViewName(anyString())).thenReturn(new JavascriptNashornEngine());
        editorBean.setValue("<p>print(2+5);</p>");
        editorBean.setSelectedEngine("nashorn");
        editorBean.interpret();
        Assertions.assertThat(editorBean.getValue()).isEqualTo("7");
    }
}
