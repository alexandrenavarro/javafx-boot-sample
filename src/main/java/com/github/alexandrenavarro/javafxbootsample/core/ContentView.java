package com.github.alexandrenavarro.javafxbootsample.core;

import javafx.scene.Node;
import org.springframework.stereotype.Component;

/**
 * Created by anavarro on 25/02/17.
 */
@Component
public class ContentView {

    private Node content;

    public Node getContent() {
        return content;
    }

    public void setContent(final Node content) {
        this.content = content;
    }
}
