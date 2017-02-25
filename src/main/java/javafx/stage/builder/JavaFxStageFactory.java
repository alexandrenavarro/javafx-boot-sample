package javafx.stage.builder;

import javafx.stage.FileChooser;
import net.karneim.pojobuilder.GeneratePojoBuilder;

/**
 * Created by anavarro on 25/02/17.
 */
public class JavaFxStageFactory {

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static FileChooser createFileChooser() {
        return new FileChooser();
    }
}
