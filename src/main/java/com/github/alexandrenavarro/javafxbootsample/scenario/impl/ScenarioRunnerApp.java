package com.github.alexandrenavarro.javafxbootsample.scenario.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.inject.Inject;

/**
 * Created by anavarro on 11/03/17.
 */
@SpringBootApplication
@EnableConfigurationProperties(value = {ScenarioRunnerArgs.class})
@Slf4j
public class ScenarioRunnerApp implements CommandLineRunner {


    @Inject
    private ScenarioRunner scenarioRunner;

    @Override
    public void run(String... args) {
        scenarioRunner.run();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ScenarioRunnerApp.class, args);
    }

    // TODO grammar, maybe add a scenario name (or file name)
    // Repackage in one jar
    // Parse file
    // Improve Scenario View (Open file / Save File)
    // Improve Generic Task
}
