package com.github.alexandrenavarro.javafxbootsample;

import com.github.alexandrenavarro.javafxbootsample.splashscreen.SplashScreenView;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.CompletableFuture;

/**
 * Created by anavarro on 25/02/17.
 */
@SpringBootApplication
//@EnableFeignClients(basePackageClasses = {CountryResource.class})
@Slf4j
public class JavaFxBootApp extends Application {

    private ConfigurableApplicationContext applicationContext;
    private static String[] args;

    private SplashScreenView splashScreenView;


    @Override
    public void init() throws Exception {
        splashScreenView = new SplashScreenView();
    }

    @Override
    public void start(final Stage stage) {
        final Task task = new Task() {
            @Override
            protected Object call() throws Exception {
                // TODO add all the stuff you want to do in background before showing the main stage
                // TODO add progress based on number of bean created
                JavaFxBootApp.this.applicationContext = SpringApplication.run(JavaFxBootApp.class, args);
                return null;
            }
        };

        // Show splashScreen
        showSplashScreenStage(stage);

        // Task Init
        splashScreenView.getProgressLabel().textProperty().bind(task.messageProperty());
        splashScreenView.getLoadProgressBar().progressProperty().bind(task.progressProperty());
        task.setOnSucceeded(e -> {
            splashScreenView.getLoadProgressBar().progressProperty().unbind();
            splashScreenView.getProgressLabel().textProperty().unbind();

            // Hide SplashScreen
            hideSplashScreenStage(stage);

            // Show Main Stage
            showMainStage(stage);
        });

        CompletableFuture.runAsync(() -> task.run());

        // TODO add builder for all Javafx
        // TODO animation menu
        // TODO logs view


    }

    private void hideSplashScreenStage(final Stage stage) {
        stage.hide();
    }

    private void showSplashScreenStage(final Stage stage) {
        this.splashScreenView.initSplashScreenScene(stage);
        stage.show();
    }

    private void showMainStage(Stage stage) {
        final Stage mainStage = new Stage(StageStyle.DECORATED);
        setUserAgentStylesheet(STYLESHEET_MODENA);
        mainStage.setScene(new Scene(this.applicationContext.getBean(MainView.class).getView(), 1200, 1000));
        stage = mainStage;
        stage.show();
    }


    @Override
    public void stop() throws Exception {
        this.applicationContext.close();
    }

    public static void main(String[] anArgs) {
        args = anArgs;
        launch(anArgs);
    }

}
