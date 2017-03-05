package com.github.alexandrenavarro.javafxbootsample.splashscreen;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.builder.LabelBuilder;
import javafx.scene.control.builder.ProgressBarBuilder;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.builder.VBoxBuilder;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.Getter;

/**
 * Created by anavarro on 05/03/17.
 */
public class SplashScreenView {

    private static final String SPLASH_IMAGE =
            "/logo.png";

    public static final int SPLASH_WIDTH = 676;
    public static final int SPLASH_HEIGHT = 227;


    @Getter
    private final ProgressBar loadProgressBar = ProgressBarBuilder.create()
            .prefWidth(SPLASH_WIDTH - 20).build();

    @Getter
    private final Label progressLabel = LabelBuilder.create()
            .text("Starting ...").build();

    private final ImageView splashImageView = new ImageView(new Image(SPLASH_IMAGE));

    @Getter
    private final VBox view;


    public SplashScreenView() {
        view = VBoxBuilder.create()
                .children(splashImageView, loadProgressBar, progressLabel)
                .alignment(Pos.CENTER)
                .style("-fx-padding: 5; " +
                        "-fx-background-color: cornsilk; " +
                        "-fx-border-width:5; " +
                        "-fx-border-color: " +
                        "linear-gradient(" +
                        "to bottom, " +
                        "chocolate, " +
                        "derive(chocolate, 50%)" +
                        ");")
                .effect(new DropShadow())
                .build();
    }

    public void initSplashScreenScene(final Stage initStage) {
        final Scene splashScene = new Scene(this.view, Color.TRANSPARENT);
        final Rectangle2D bounds = Screen.getPrimary().getBounds();
        initStage.setScene(splashScene);
        initStage.setX(bounds.getMinX() + bounds.getWidth() / 2 - SplashScreenView.SPLASH_WIDTH / 2);
        initStage.setY(bounds.getMinY() + bounds.getHeight() / 2 - SplashScreenView.SPLASH_HEIGHT / 2);
        initStage.initStyle(StageStyle.TRANSPARENT);
        initStage.setAlwaysOnTop(true);
        //initStage.show();
    }


}
