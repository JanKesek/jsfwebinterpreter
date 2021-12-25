package interpretermain.interpreterengines;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface InterpreterEngine {
    String getEngineName();
    String getEngineNameView();
}
