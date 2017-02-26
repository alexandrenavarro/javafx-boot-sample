package org.controlsfx.control.builder;

import com.github.alexandrenavarro.javafxbootsample.util.builder.Builder;
import javafx.scene.Node;
import org.controlsfx.control.StatusBar;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The {@link StatusBarBuilder} is a Builder for {@link org.controlsfx.control.StatusBar} objects.
 * <p> ATTENTION:
 *     This class has been generated.
 *     If you want to ADD HANDWRITTEN CODE,
 *     please MOVE THIS FILE out of the generated-sources folder
 *     in order to prevent it from being overwritten by the
 *     PojoBuilder generator!
 * </p>
 */
@Generated("PojoBuilder")
public class StatusBarBuilder extends AbstractStatusBarBuilder implements Builder<StatusBar> {

  /**
   * Factory Method to construct a StatusBarBuilder
   *
   * @return a new StatusBarBuilder
   */
  public static StatusBarBuilder create() {
    return new StatusBarBuilder();
  }

  /**
   * Creates a new {@link StatusBarBuilder}.
   */
  public StatusBarBuilder() {
  }

  private List<Node> rightItems = Collections.emptyList();
  private List<Node> leftItems = Collections.emptyList();


  public StatusBarBuilder leftItems(Node... x) {
    leftItems = Arrays.asList(x);
    return this;
  }

  public StatusBarBuilder rightItems(Node... x) {
    rightItems = Arrays.asList(x);
    return this;
  }

  public StatusBar build() {
    final StatusBar statusBar = super.build();
    statusBar.getLeftItems().addAll(leftItems);
    statusBar.getRightItems().addAll(rightItems);

    return statusBar;
  }




}
