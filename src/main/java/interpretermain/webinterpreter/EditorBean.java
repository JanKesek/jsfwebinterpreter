package interpretermain.webinterpreter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;


@NoArgsConstructor
@Component
@ComponentScan
@Scope("view")
@Log
@Getter
@Setter
public class EditorBean {

    private InterpreterService interpreterService;
    private InterpreterMenu interpreterMenu;

    @Autowired
    public EditorBean(InterpreterService interpreterService, InterpreterMenu interpreterMenu) {
        this.interpreterService = interpreterService;
        this.interpreterMenu = interpreterMenu;
    }


    private String value = "This editor is provided by PrimeFaces";
    private String selectedEngine;


    public void interpret() {
        if (selectedEngine == null) {
            log.info(".intepreter did not choose intepreter");
            return;
        }
        value = ParseUtils.stripHtml(value);
        value = interpreterService.printInterpret(value, interpreterMenu.getEngineByViewName(selectedEngine));
        log.info(".interpreter complete " + value);
    }

    public List<String> interpreterMenu() {
        return interpreterMenu.getViewInterpreterMenu();
    }
}