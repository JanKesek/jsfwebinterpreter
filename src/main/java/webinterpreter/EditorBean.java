package webinterpreter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Map;


@AllArgsConstructor
@NoArgsConstructor
@Component
@Scope("view")
public class EditorBean {

    @Autowired
    private InterpreterService interpreterService;
    @Getter
    @Setter
    private String value = "This editor is provided by PrimeFaces";

    public void interpret() {
        System.out.println("editorBean.interpret");
        value = interpreterService.printInterpret(value,"nashorn");
    }
}