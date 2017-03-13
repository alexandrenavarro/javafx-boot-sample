package com.github.alexandrenavarro.javafxbootsample.scenario.model;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by anavarro on 11/03/17.
 */
@Component
@Slf4j
public class ScenarioRunner {

    private final ScenarioRunnerArgs scenarioRunnerArgs;
    private final List<Path> scenarioFileList = new ArrayList<>();

    public ScenarioRunner(final ScenarioRunnerArgs scenarioRunnerArgs) {
        this.scenarioRunnerArgs = scenarioRunnerArgs;
    }

    @PostConstruct
    public void init() {

        try {
            for (final String directory : scenarioRunnerArgs.getInputDirectories()) {
                Files.newDirectoryStream(Paths.get(directory),
                        path -> path.toString().endsWith(".sco"))
                        .forEach(e -> {
                            scenarioFileList.add(e.getFileName());
                        });
            }
            for (final String s : scenarioRunnerArgs.getInputFiles()) {
                scenarioFileList.add(Paths.get(s));
            }
        } catch (IOException e) {
            log.warn("ERROR e:{}", e);
        }
    }


    public void run() {
        log.info("ScenarioRunner is started with these arguments {} and {} scenario.", scenarioRunnerArgs, scenarioFileList.size());

        final List<ScenarioResult> scenarioResultList = new ArrayList<>(scenarioFileList.size());

        long start = System.currentTimeMillis();
        long stop = System.currentTimeMillis();
        for (final Path scenarioFile : scenarioFileList) {
            start = System.currentTimeMillis();
            // TODO Parse scenario

            // TODO Run it and save in
            stop = System.currentTimeMillis();
            scenarioResultList.add(ScenarioResult.builder().scenarioName(scenarioFile.getFileName().toString()).scenarioStatus(ScenarioStatus.OK).scenarioError("No Error").scenarioDurationInMs(stop - start).build());
        }

        generateScenarioResults(scenarioRunnerArgs.getOutputFile(), scenarioRunnerArgs.getOutputType(), scenarioResultList);

        // TODO Generate an output
        log.info("ScenarioRunner is finished.");

    }


    public boolean generateScenarioResults(final String fileNameWithExtention, final ScenarioOutputType scenarioOutputType, final List<ScenarioResult> scenarioResults) {
        log.info("generateScenarioResults starting ...");
        final Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("scenarioResults", scenarioResults);
        try (final Writer writer = new FileWriter(fileNameWithExtention + "." + scenarioOutputType.name().toLowerCase())) {
            final DefaultMustacheFactory mf = new DefaultMustacheFactory();
            final Mustache mustache = mf.compile(scenarioOutputType.name().toLowerCase() + ".mustache");
            mustache.execute(writer, paramMap);
            writer.flush();
            log.info("generateScenarioResults is finished.");
            return true;
        } catch (final IOException e) {
            log.error("ERROR e:{}", e);
            return false;
        }
    }

}
