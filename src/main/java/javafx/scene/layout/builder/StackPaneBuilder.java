package javafx.scene.layout.builder;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The {@link StackPaneBuilder} is a Builder for {@link javafx.scene.layout.StackPane} objects.
 * <p> ATTENTION:
 * This class has been generated.
 * If you want to ADD HANDWRITTEN CODE,
 * please MOVE THIS FILE out of the generated-sources folder
 * in order to prevent it from being overwritten by the
 * PojoBuilder generator!
 * </p>
 */
@Generated("PojoBuilder")
public class StackPaneBuilder extends AbstractStackPaneBuilder {

    /**
     * Factory Method to construct a StackPaneBuilder
     *
     * @return a new StackPaneBuilder
     */
    public static StackPaneBuilder create() {
        return new StackPaneBuilder();
    }

    /**
     * Creates a new {@link StackPaneBuilder}.
     */
    public StackPaneBuilder() {
    }

    private List<Node> nodeList = Collections.emptyList();

    public StackPaneBuilder children(Node... x) {
        nodeList = Arrays.asList(x);
        return this;
    }

    public StackPane build() {
        final StackPane stackPane = super.build();
        stackPane.getChildren().addAll(nodeList);
        return stackPane;
    }
}
