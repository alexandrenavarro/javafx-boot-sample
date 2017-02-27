package com.github.alexandrenavarro.javafxbootsample.referential;

import javafx.scene.Node;
import javafx.scene.layout.builder.StackPaneBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by anavarro on 25/02/17.
 */
@Component
public class UnderlyingView {

    public Node getView() {
        return StackPaneBuilder.create().build();
    }
}
