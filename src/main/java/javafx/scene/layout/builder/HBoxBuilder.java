package javafx.scene.layout.builder;

import javafx.scene.Node;
import javafx.scene.layout.HBox;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The {@link HBoxBuilder} is a Builder for {@link javafx.scene.layout.HBox} objects.
 * <p> ATTENTION:
 *     This class has been generated.
 *     If you want to ADD HANDWRITTEN CODE,
 *     please MOVE THIS FILE out of the generated-sources folder
 *     in order to prevent it from being overwritten by the
 *     PojoBuilder generator!
 * </p>
 */
@Generated("PojoBuilder")
public class HBoxBuilder extends AbstractHBoxBuilder {

  /**
   * Factory Method to construct a HBoxBuilder
   *
   * @return a new HBoxBuilder
   */
  public static HBoxBuilder create() {
    return new HBoxBuilder();
  }

  /**
   * Creates a new {@link HBoxBuilder}.
   */
  public HBoxBuilder() {
  }

  private List<Node> nodeList = Collections.emptyList();

  public HBoxBuilder children(Node... x) {
    nodeList = Arrays.asList(x);
    return this;
  }

  public HBox build() {
    final HBox hBox = super.build();
    hBox.getChildren().addAll(nodeList);
    return hBox;
  }
}
