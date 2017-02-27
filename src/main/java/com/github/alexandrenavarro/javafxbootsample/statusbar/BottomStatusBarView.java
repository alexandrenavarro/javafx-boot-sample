package com.github.alexandrenavarro.javafxbootsample.statusbar;

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

    public BottomStatusBarView() {
        view = StatusBarBuilder.create().build();
    }

}
