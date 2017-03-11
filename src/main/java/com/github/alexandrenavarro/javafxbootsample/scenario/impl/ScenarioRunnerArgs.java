package com.github.alexandrenavarro.javafxbootsample.scenario.impl;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anavarro on 11/03/17.
 */

@ConfigurationProperties("")
@Data
public class ScenarioRunnerArgs {

    private List<String> inputFiles = new ArrayList<>();
    private List<String> inputDirectories = new ArrayList<>();

    private String outputFile = "./target/scenario-results";
    private ScenarioOutputType outputType = ScenarioOutputType.CSV;

}
