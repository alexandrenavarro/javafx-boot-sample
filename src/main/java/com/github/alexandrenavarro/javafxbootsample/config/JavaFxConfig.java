package com.github.alexandrenavarro.javafxbootsample.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.alexandrenavarro.javafxbootsample.preferences.UserPref;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import javax.inject.Inject;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by anavarro on 25/02/17.
 */
@Configuration
@Slf4j
public class JavaFxConfig {

    static String outputFileName = System.getProperty("user.home") + File.separatorChar
            + ".onx" + File.separatorChar + "text.txt";

    //@Inject
    //UserPref userPreferences;

    @Inject
    ObjectMapper mapper;

    @Bean
    ObjectMapper mapper() {
        return new ObjectMapper();
    }

    @Bean
    UserPref userPref(ObjectMapper mapper) {
        File f = new File(outputFileName);
        UserPref pref = null;
//        if (f.exists()) {
//            FileInputStream inputStream = null;
//            try {
//                inputStream = new FileInputStream(outputFileName);
//                pref = mapper.readValue(inputStream, UserPref.class);
//                log.info("Read from: {}, userPref: ", outputFileName, pref);
//                return pref;
//            } catch (IOException e) {
//                log.scenarioError("Failed to load user pref", e);
//            }
//        }

        pref = new UserPref();
        return pref;
    }

    @PreDestroy
    public void preDestroy() {
        File f = new File(outputFileName);
        f.getParentFile().mkdirs();

        try {
            FileOutputStream out = new FileOutputStream(outputFileName);
            // TODO Refactor this
            //mapper.writerWithDefaultPrettyPrinter().writeValue(out, userPreferences);
        } catch (IOException ex) {
            log.error("Failed to serialized", ex);
        }
        log.info("Saved: {}", outputFileName);
    }
}
