package javafx.scene.builder;

import javafx.scene.Parent;
import javafx.scene.Scene;
import net.karneim.pojobuilder.GeneratePojoBuilder;

/**
 * Created by anavarro on 25/02/17.
 */
public class JavaFxSceneFactory {

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static Scene createScene(final Parent parent, double width, double height) {
        return new Scene(parent, width, height);
    }

}
