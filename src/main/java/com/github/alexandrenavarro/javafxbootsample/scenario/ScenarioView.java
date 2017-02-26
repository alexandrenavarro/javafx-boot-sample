package com.github.alexandrenavarro.javafxbootsample.scenario;

import com.github.alexandrenavarro.javafxbootsample.View;
import org.fxmisc.richtext.CodeArea;
import org.springframework.stereotype.Component;

/**
 * Created by anavarro on 26/02/17.
 */
@Component
public class ScenarioView implements View {

    private final CodeArea codeArea = new CodeArea();

    public ScenarioView() {
    }


    @Override
    public CodeArea getView() {
        return codeArea;
    }
}
