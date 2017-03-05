package javafx.scene.layout.builder;

import javafx.scene.layout.*;
import net.karneim.pojobuilder.GeneratePojoBuilder;

/**
 * Created by anavarro on 25/02/17.
 */
public class JavafxSceneLayoutFactory {

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static AnchorPane createAnchorPane() {
        return new AnchorPane();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static BorderPane createBorderPane() {
        return new BorderPane();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static ColumnConstraints createColumnConstraints() {
        return new ColumnConstraints();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static FlowPane createFlowPane() {
        return new FlowPane();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static GridPane createGridPane() {
        return new GridPane();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static HBox createHBox() {
        return new HBox();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static Pane createPane() {
        return new Pane();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static Region createRegion() {
        return new Region();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static RowConstraints createRowConstraints() {
        return new RowConstraints();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static StackPane createStackPane() {
        return new StackPane();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static TilePane createTilePane() {
        return new TilePane();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static VBox createVBox() {
        return new VBox();
    }


}
