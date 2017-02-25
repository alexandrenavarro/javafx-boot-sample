package com.github.alexandrenavarro.javafxbootsample.core;

import javafx.scene.Node;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by anavarro on 25/02/17.
 */
@Component
public class MainView  {

    private final MenuView menuView;
    private final TopStatusBarView topStatusBarView;
    private final BottomStatusBarView bottomStatusBarView;
    private final ContentView contentView;

    @Inject
    public MainView(MenuView menuView, TopStatusBarView topStatusBarView, BottomStatusBarView bottomStatusBarView, ContentView contentView) {
        this.menuView = menuView;
        this.topStatusBarView = topStatusBarView;
        this.bottomStatusBarView = bottomStatusBarView;
        this.contentView = contentView;

    }
}
