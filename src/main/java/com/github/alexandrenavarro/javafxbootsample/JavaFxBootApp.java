package com.github.alexandrenavarro.javafxbootsample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by anavarro on 25/02/17.
 */
@SpringBootApplication
//@EnableFeignClients(basePackageClasses = {CountryResource.class})
@Slf4j
public class JavaFxBootApp extends Application {

    private ConfigurableApplicationContext applicationContext;
    private static String[] args;

    @Override
    public void init() throws Exception {
        this.applicationContext = SpringApplication.run(getClass(), args);
        this.applicationContext.getAutowireCapableBeanFactory().autowireBean(this);
//        Parent root;
//        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample.fxml"));
//        fxmlLoader.setControllerFactory(applicationContext::getBean);
//        root = fxmlLoader.load();
    }

    @Override
    public void start(final Stage stage) {
        setUserAgentStylesheet(STYLESHEET_MODENA);
        stage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        stage.setScene(new Scene(root, 300, 250));
        stage.show();

        //TODO animation menu
        // TODO add shortcut menu
        // TODO Splash screen

    }


    @Override
    public void stop() throws Exception {
        this.applicationContext.close();
    }

    public static void main(String[] anArgs) {
        args = anArgs;
        launch(args);
    }
}
