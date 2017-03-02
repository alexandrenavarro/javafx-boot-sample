package org.controlsfx.control.textfield.builder;

import net.karneim.pojobuilder.GeneratePojoBuilder;
import org.controlsfx.control.textfield.CustomTextField;


/**
 * Created by anavarro on 02/03/17.
 */
public class ControlFxTextFieldFactory {

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static CustomTextField createCustomTextField() {
        return new CustomTextField();
    }
}
