package javafx.scene.layout.builder;

import javafx.scene.Node;
import javafx.scene.layout.VBox;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The {@link VBoxBuilder} is a Builder for {@link javafx.scene.layout.VBox} objects.
 * <p> ATTENTION:
 *     This class has been generated.
 *     If you want to ADD HANDWRITTEN CODE,
 *     please MOVE THIS FILE out of the generated-sources folder
 *     in order to prevent it from being overwritten by the
 *     PojoBuilder generator!
 * </p>
 */
@Generated("PojoBuilder")
public class VBoxBuilder extends AbstractVBoxBuilder {

  /**
   * Factory Method to construct a VBoxBuilder
   *
   * @return a new VBoxBuilder
   */
  public static VBoxBuilder create() {
    return new VBoxBuilder();
  }

  /**
   * Creates a new {@link VBoxBuilder}.
   */
  public VBoxBuilder() {
  }

  private List<Node> nodeList = Collections.emptyList();

  public VBoxBuilder children(Node... x) {
    nodeList = Arrays.asList(x);
    return this;
  }

  public VBox build() {
    final VBox vBox = super.build();
    vBox.getChildren().addAll(nodeList);
    return vBox;
  }

}
