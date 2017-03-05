package javafx.scene.control.builder;

import javafx.scene.control.*;
import net.karneim.pojobuilder.GeneratePojoBuilder;


/**
 * Created by anavarro on 25/02/17.
 */
public class JavafxSceneControlFactory {

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static TitledPane createTitledPane() {
        return new TitledPane();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static Button createButton() {
        return new Button();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static Accordion createAccordion() {
        return new Accordion();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static Label createLabel() {
        return new Label();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static RadioButton createRadioButton() {
        return new RadioButton();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static ToggleButton createToggleButton() {
        return new ToggleButton();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static CheckBox createCheckbox() {
        return new CheckBox();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static <T> ChoiceBox<T> createChoiceBox() {
        return new ChoiceBox<T>();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static TextField createTextField() {
        return new TextField();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static PasswordField createPasswordField() {
        return new PasswordField();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static ScrollBar createScrollBar() {
        return new ScrollBar();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static ScrollPane createScrollPane() {
        return new ScrollPane();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static <T> ListView<T> createListView() {
        return new ListView<T>();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static <S> TableView<S> createTableView() {
        return new TableView<S>();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static <T> TreeView<T> createTreeView() {
        return new TreeView<T>();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static <S> TreeTableView<S> createTreeTableView() {
        return new TreeTableView<S>();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static <T> ComboBox<T> createComboBox() {
        return new ComboBox<T>();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static Separator createSeparator() {
        return new Separator();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static Slider createSlider() {
        return new Slider();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static ProgressBar createProgressBar() {
        return new ProgressBar();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static Hyperlink createHyperlink() {
        return new Hyperlink();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static Tooltip createTooltip() {
        return new Tooltip();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static Menu createMenu() {
        return new Menu();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static MenuItem createMenuItem() {
        return new MenuItem();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static MenuBar createMenuBar() {
        return new MenuBar();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static MenuButton createMenuButton() {
        return new MenuButton();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static ColorPicker createColorPicker() {
        return new ColorPicker();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static DatePicker createDatePicker() {
        return new DatePicker();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static Pagination createPagination() {
        return new Pagination();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static <S, T> TableColumn<S, T> createTableColumn() {
        return new TableColumn<S, T>();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static <S, T> TreeTableColumn<S, T> createTreeTableColumn() {
        return new TreeTableColumn<S, T>();
    }


}
