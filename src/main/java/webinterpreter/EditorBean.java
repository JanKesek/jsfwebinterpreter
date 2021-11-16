package webinterpreter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class EditorBean implements Serializable {

    private InterpreterService interpreterService;

    @Inject
    public EditorBean(InterpreterService interpreterService) {
        this.interpreterService = interpreterService;
    }

	private String value = "This editor is provided by PrimeFaces";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	public void interpret() {
        System.out.println("editorBean.interpret");
        value = interpreterService.printInterpret(value,"nashorn");
    }
}