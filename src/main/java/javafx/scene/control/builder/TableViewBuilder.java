package javafx.scene.control.builder;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The {@link TableViewBuilder} is a Builder for {@link javafx.scene.control.TableView} objects.
 * <p> ATTENTION:
 *     This class has been generated.
 *     If you want to ADD HANDWRITTEN CODE,
 *     please MOVE THIS FILE out of the generated-sources folder
 *     in order to prevent it from being overwritten by the
 *     PojoBuilder generator!
 * </p>
 */
@Generated("PojoBuilder")
public class TableViewBuilder<S> extends AbstractTableViewBuilder<S> {

  /**
   * Factory Method to construct a TableViewBuilder<S>
   *
   * @return a new TableViewBuilder<S>
   */
  public static <S> TableViewBuilder<S> create() {
    return new TableViewBuilder<S>();
  }

  /**
   * Creates a new {@link TableViewBuilder}.
   */
  public TableViewBuilder() {
  }

    private List<TableColumn> tableColumnList = Collections.emptyList();

    public TableView build() {
        final TableView tableView = super.build();
        tableView.getColumns().addAll(tableColumnList);
        return tableView;
    }

    public TableViewBuilder columns(TableColumn... x) {
        this.tableColumnList = Arrays.asList(x);
        return this;
    }
}
