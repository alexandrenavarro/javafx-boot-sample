package com.github.alexandrenavarro.javafxbootsample.core;

import org.controlsfx.control.StatusBar;
import org.controlsfx.control.builder.StatusBarBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by anavarro on 25/02/17.
 */
@Component
public class BottomStatusBarView {

    private final  StatusBar statusBar;

    public BottomStatusBarView() {
        statusBar = StatusBarBuilder.create().build();
    }

    public StatusBar getStatusBar() {
        return statusBar;
    }
}
