package com.github.alexandrenavarro.javafxbootsample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.inject.Inject;

/**
 * Created by anavarro on 25/02/17.
 */
@SpringBootApplication
//@EnableFeignClients(basePackageClasses = {CountryResource.class})
@Slf4j
public class JavaFxBootApp extends Application {

    private ConfigurableApplicationContext applicationContext;
    private static String[] args;

    @Inject
    private MainView mainView;

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

        // TODO animation menu
        // TODO Splash screen

        stage.setScene(new Scene(mainView.getView(), 1200, 1000));
        stage.show();

        // TODO Preference


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
