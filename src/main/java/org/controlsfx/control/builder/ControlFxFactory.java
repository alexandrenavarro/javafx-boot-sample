package org.controlsfx.control.builder;


import net.karneim.pojobuilder.GeneratePojoBuilder;
import org.controlsfx.control.MaskerPane;
import org.controlsfx.control.PopOver;
import org.controlsfx.control.PropertySheet;
import org.controlsfx.control.StatusBar;
import org.controlsfx.control.textfield.CustomTextField;

/**
 * Created by anavarro on 25/02/17.
 */
public class ControlFxFactory {

    @GeneratePojoBuilder(withSetterNamePattern="*", intoPackage="*.builder", withFactoryMethod="create", withGenerationGap = true)
    public static StatusBar createStatusBar() {
        return new StatusBar();
    }


    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static MaskerPane createMaskerPane() {
        return new MaskerPane();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static CustomTextField createCustomTextField() {
        return new CustomTextField();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static PopOver createPopOver() {
        return new PopOver();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static PropertySheet createPropertySheet() {
        return new PropertySheet();
    }




}
