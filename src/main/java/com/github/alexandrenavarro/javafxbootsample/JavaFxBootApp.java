package com.github.alexandrenavarro.javafxbootsample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
    }

    @Override
    public void start(final Stage stage) {
        setUserAgentStylesheet(STYLESHEET_MODENA);
        stage.setScene(new Scene(this.applicationContext.getBean(MainView.class).getView(), 1200, 1000));
        stage.show();

        // TODO Menu shortcut
        // TODO Preference (fix problem ioc)
        // TODO add builder for all ControlfX (Inset)
        // TODO add builder for all RichText
        // TODO animation menu
        // TODO Splash screen

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
