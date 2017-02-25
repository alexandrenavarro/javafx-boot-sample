package javafx.scene.control.builder;

import com.github.alexandrenavarro.javafxbootsample.util.builder.Builder;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;

import javax.annotation.Generated;
import java.util.*;

/**
 * The {@link AccordionBuilder} is a Builder for {@link javafx.scene.control.Accordion} objects.
 * <p> ATTENTION:
 *     This class has been generated.
 *     If you want to ADD HANDWRITTEN CODE,
 *     please MOVE THIS FILE out of the generated-sources folder
 *     in order to prevent it from being overwritten by the
 *     PojoBuilder generator!
 * </p>
 */
@Generated("PojoBuilder")
public class AccordionBuilder extends AbstractAccordionBuilder implements Builder<Accordion> {

  /**
   * Factory Method to construct a AccordionBuilder
   *
   * @return a new AccordionBuilder
   */
  public static AccordionBuilder create() {
    return new AccordionBuilder();
  }

  /**
   * Creates a new {@link AccordionBuilder}.
   */
  public AccordionBuilder() {
  }


  private List<TitledPane> titledPanes = Collections.emptyList();

  public AccordionBuilder panes(TitledPane... x) {
    titledPanes = Arrays.asList(x);
    return this;
  }

  public Accordion build() {
    final Accordion accordion = super.build();
    accordion.getPanes().addAll(titledPanes);
    return accordion;
  }

}
