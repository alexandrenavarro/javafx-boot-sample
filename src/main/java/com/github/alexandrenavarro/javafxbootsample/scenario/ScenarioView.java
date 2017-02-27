package com.github.alexandrenavarro.javafxbootsample.scenario;

import org.fxmisc.richtext.CodeArea;
import org.springframework.stereotype.Component;

/**
 * Created by anavarro on 26/02/17.
 */
@Component
public class ScenarioView {

    private final CodeArea codeArea = new CodeArea();

    public ScenarioView() {
    }


    public CodeArea getView() {
        return codeArea;
    }
}
