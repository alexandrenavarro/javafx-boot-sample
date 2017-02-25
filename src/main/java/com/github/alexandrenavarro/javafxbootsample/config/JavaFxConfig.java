package com.github.alexandrenavarro.javafxbootsample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by anavarro on 25/02/17.
 */
@Configuration
public class JavaFxConfig {

    @Bean
    public ExecutorService executorService() {
        return Executors.newFixedThreadPool(8, r -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t ;
        });
    }
}
