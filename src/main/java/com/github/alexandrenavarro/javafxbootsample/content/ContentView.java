package com.github.alexandrenavarro.javafxbootsample.content;

import javafx.scene.control.TitledPane;
import javafx.scene.control.builder.TitledPaneBuilder;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.builder.StackPaneBuilder;
import lombok.Getter;
import org.controlsfx.control.MaskerPane;
import org.controlsfx.control.builder.MaskerPaneBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by anavarro on 04/03/17.
 */
@Component
public class ContentView {

    @Getter
    private final MaskerPane maskerPane = MaskerPaneBuilder.create().visible(false).build();

    @Getter
    private final StackPane content = StackPaneBuilder.create()
            .children(
                    maskerPane
            )
            .build();

    @Getter
    private TitledPane view = TitledPaneBuilder.create()
            .collapsible(false)
            .text("")
            .maxHeight(Double.MAX_VALUE)
            .content(content)
            .build();


    public ContentView() {

    }


}
