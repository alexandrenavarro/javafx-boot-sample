package com.github.alexandrenavarro.javafxbootsample.referential;

import com.github.alexandrenavarro.javafxbootsample.View;
import javafx.scene.Node;
import javafx.scene.layout.builder.StackPaneBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by anavarro on 25/02/17.
 */
@Component
public class UnderlyingView implements View {

    public Node getView() {
        return StackPaneBuilder.create().build();
    }
}
