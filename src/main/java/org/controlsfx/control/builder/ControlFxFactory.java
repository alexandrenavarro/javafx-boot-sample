package org.controlsfx.control.builder;

import javafx.scene.control.AccordionBuilder;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBoxBuilder;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import org.controlsfx.control.StatusBar;

/**
 * Created by anavarro on 25/02/17.
 */
public class ControlFxFactory {

    @GeneratePojoBuilder(withSetterNamePattern="*", intoPackage="*.builder", withFactoryMethod="create", withGenerationGap = true)
    public static StatusBar createStatusBar() {
        return new StatusBar();
    }

}
