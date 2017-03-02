package com.github.alexandrenavarro.javafxbootsample.statusbar;

import javafx.scene.control.Button;
import javafx.scene.control.builder.ButtonBuilder;
import lombok.Getter;
import org.controlsfx.control.StatusBar;
import org.controlsfx.control.builder.StatusBarBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by anavarro on 25/02/17.
 */
@Component
public class BottomStatusBarView {

    @Getter
    private final StatusBar view;

    @Getter
    private final Button taskInProgressButton = ButtonBuilder.create()
            .text("Tasks in Progress")
            .build();

    public BottomStatusBarView() {
        view = StatusBarBuilder.create()
                .rightItems(taskInProgressButton)
                .build();
    }

}
