package javafx.scene.web.builder;

import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import net.karneim.pojobuilder.GeneratePojoBuilder;

/**
 * Created by anavarro on 25/02/17.
 */
public class JavaFxWebFactory {

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static HTMLEditor createHTMLEditor() {
        return new HTMLEditor();
    }
}
