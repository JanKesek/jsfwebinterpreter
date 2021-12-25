package interpretermain.interpreterengines;

import javax.annotation.Resource;

@Resource
public class JavascriptNashornEngine implements InterpreterEngine {
    @Override
    public String getEngineName() {
        return "nashorn";
    }

    @Override
    public String getEngineNameView() {
        return "JavaScript";
    }
}