package com.github.alexandrenavarro.javafxbootsample.scenario.model;

import lombok.Builder;
import lombok.Data;

/**
 * Created by anavarro on 11/03/17.
 */
@Data
@Builder
public class ScenarioResult {

    private String scenarioName = "UnknownScenarioName";
    private ScenarioStatus scenarioStatus = ScenarioStatus.UNKNOWN;
    private String scenarioError = ""; // Fill if there is an scenarioError
    private long scenarioDurationInMs = 0;

}
