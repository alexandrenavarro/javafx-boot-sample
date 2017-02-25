package javafx.scene.builder;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import net.karneim.pojobuilder.GeneratePojoBuilder;

/**
 * Created by anavarro on 25/02/17.
 */
public class JavaFxSceneFactory {

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static Scene createScene(final Parent parent) {
        return new Scene(parent);
    }

}
