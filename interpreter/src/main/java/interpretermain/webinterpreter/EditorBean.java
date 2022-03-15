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


    private String value = "";
    private String outputValue = "";
    private String selectedEngine;


    public void interpret() {
        if (selectedEngine == null) {
            log.info(".intepreter did not choose intepreter");
            return;
        }
        value = ParseUtils.stripHtml(value);
        outputValue = interpreterService.printInterpret(interpreterMenu.getEngineByViewName(selectedEngine), value);
        log.info(".interpreter complete " + outputValue);
    }

    public List<String> interpreterMenu() {
        return interpreterMenu.getViewInterpreterMenu();
    }
}