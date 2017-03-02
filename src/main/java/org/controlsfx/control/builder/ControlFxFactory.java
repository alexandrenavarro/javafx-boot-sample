package org.controlsfx.control.builder;


import javafx.concurrent.Task;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import org.controlsfx.control.*;


/**
 * Created by anavarro on 25/02/17.
 */
public class ControlFxFactory {

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static <T> BreadCrumbBar<T> createBreadCrumbBar() {
        return new BreadCrumbBar<T>();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static <T> CheckComboBox<T> createCheckComboBox() {
        return new CheckComboBox<T>();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static <T> CheckListView<T> createCheckListView() {
        return new CheckListView<T>();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static <T> CheckTreeView<T> createCheckTreeView() {
        return new CheckTreeView<T>();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static <T> GridCell<T> createGridCell() {
        return new GridCell<T>();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static <T> GridView<T> createGridView() {
        return new GridView<T>();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static HiddenSidesPane createHiddenSidesPane() {
        return new HiddenSidesPane();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static HyperlinkLabel createHyperlinkLabel() {
        return new HyperlinkLabel();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static InfoOverlay createInfoOverlay() {
        return new InfoOverlay();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static <T> ListSelectionView<T> createListSelectionView() {
        return new ListSelectionView<T>();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static MaskerPane createMaskerPane() {
        return new MaskerPane();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static MasterDetailPane createMasterDetailPane() {
        return new MasterDetailPane();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static NotificationPane createNotificationPane() {
        return new NotificationPane();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static PlusMinusSlider createPlusMinusSlider() {
        return new PlusMinusSlider();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static PopOver createPopOver() {
        return new PopOver();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static <T> PrefixSelectionChoiceBox<T> createPrefixSelectionChoiceBox() {
        return new PrefixSelectionChoiceBox<T>();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static <T> PrefixSelectionComboBox<T> createPrefixSelectionComboBox() {
        return new PrefixSelectionComboBox<T>();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static PropertySheet createPropertySheet() {
        return new PropertySheet();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static RangeSlider createRangeSlider() {
        return new RangeSlider();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static Rating createRating() {
        return new Rating();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static SegmentedButton createSegmentedButton() {
        return new SegmentedButton();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static SnapshotView createSnapshotView() {
        return new SnapshotView();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static StatusBar createStatusBar() {
        return new StatusBar();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static <T extends Task<?>> TaskProgressView<T> createTaskProgressView() {
        return new TaskProgressView<T>();
    }

    @GeneratePojoBuilder(withSetterNamePattern = "*", intoPackage = "*.builder", withFactoryMethod = "create", withGenerationGap = true)
    public static ToggleSwitch createToggleSwitch() {
        return new ToggleSwitch();
    }


}
