package com.github.alexandrenavarro.javafxbootsample;

import com.github.alexandrenavarro.javafxbootsample.content.ContentView;
import com.github.alexandrenavarro.javafxbootsample.preferences.UserPref;
import com.github.alexandrenavarro.javafxbootsample.preferences.UserPrefBeanInfo;
import com.github.alexandrenavarro.javafxbootsample.preferences.UserPrefView;
import com.github.alexandrenavarro.javafxbootsample.referential.MarketView;
import com.github.alexandrenavarro.javafxbootsample.referential.UnderlyingView;
import com.github.alexandrenavarro.javafxbootsample.request.RequestView;
import com.github.alexandrenavarro.javafxbootsample.scenario.ScenarioView;
import com.github.alexandrenavarro.javafxbootsample.statusbar.BottomStatusBarView;
import com.github.alexandrenavarro.javafxbootsample.statusbar.TaskStatusView;
import com.github.alexandrenavarro.javafxbootsample.statusbar.TopStatusBarView;
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.util.Duration;
import lombok.extern.slf4j.Slf4j;
import org.controlsfx.control.PropertySheet;
import org.controlsfx.property.BeanProperty;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.beans.BeanInfo;
import java.beans.PropertyDescriptor;

/**
 * Created by anavarro on 26/02/17.
 */
@Component
@Slf4j
public class MainController {

    private final MainView mainView;
    private final MarketView marketView;
    private final UnderlyingView underlyingView;
    private final ScenarioView scenarioView;
    private final RequestView requestView;
    private final UserPrefView userPrefView;
    private final TaskStatusView taskStatusView;
    private final BottomStatusBarView bottomStatusBarView;
    private final TopStatusBarView topStatusBarView;
    private final ContentView contentView;
    private final UserPref userPref;


    public MainController(final MainView mainView, final MarketView marketView, final UnderlyingView underlyingView, final ScenarioView scenarioView, final RequestView requestView, final UserPrefView userPrefView, TaskStatusView taskStatusView, BottomStatusBarView bottomStatusBarView, TopStatusBarView topStatusBarView, ContentView contentView, final UserPref userPref) {
        this.mainView = mainView;
        this.marketView = marketView;
        this.underlyingView = underlyingView;
        this.scenarioView = scenarioView;
        this.requestView = requestView;
        this.userPrefView = userPrefView;
        this.taskStatusView = taskStatusView;
        this.bottomStatusBarView = bottomStatusBarView;
        this.topStatusBarView = topStatusBarView;
        this.contentView = contentView;
        this.userPref = userPref;
    }

    @PostConstruct
    public void initialize() {


        // Init click on memu

        //TODO improve to render impossible to have no at least one menu expanded
        this.mainView.getMenuAccordion().setExpandedPane(this.mainView.getMenuAccordion().getPanes().get(0));

        //TODO improve it with a animation
        this.topStatusBarView.getHamburgerLabel().setOnMouseClicked(e -> showOrHideMenu());

        this.mainView.getFindMarketHyperlink().setOnMouseClicked(e -> showMarketView());
        this.mainView.getFindUnderlyingHyperlink().setOnMouseClicked(e -> showUnderlyingView());
        this.mainView.getLoadScenarioHyperlink().setOnMouseClicked(e -> showScenarioView());
        this.mainView.getFindRequestHyperlink().setOnMouseClicked(e -> showRequestView());

        this.bottomStatusBarView.getTasksInProgressLabel().setOnMouseClicked(e -> showTaskStatusView());

        // Init Pref
        final ObservableList<PropertySheet.Item> list = FXCollections.observableArrayList();
        final BeanInfo beanInfo = new UserPrefBeanInfo();
        for (final PropertyDescriptor p : beanInfo.getPropertyDescriptors()) {
            list.add(new BeanProperty(userPref, p));
        }
        userPrefView.getPropertySheet().getItems().setAll(list);
        this.topStatusBarView.getGearLabel().setOnMouseClicked(e -> showPreferences());


        this.mainView.getView()
                .setOnKeyPressed(e -> {
                    if (this.topStatusBarView.getCtrlMKeyCombination().match(e)) {
                        showOrHideMenu();
                    } else if (this.topStatusBarView.getCtrlPKeyCombination().match(e)) {
                        showPreferences();
                    } else if (this.bottomStatusBarView.getCtrlTKeyCombination().match(e)) {
                        showTaskStatusView();
                    } else if (this.mainView.getCtrlRKeyCombination().match(e)) {
                        showRequestView();
                    } else if (this.mainView.getCtrlSKeyCombination().match(e)) {
                        showScenarioView();
                    } else if (this.mainView.getCtrlUKeyCombination().match(e)) {
                        showUnderlyingView();
                    } else if (this.mainView.getCtrlKKeyCombination().match(e)) {
                        showMarketView();
                    }

                });


        final KeyCombination keyComb1 = new KeyCodeCombination(KeyCode.R, KeyCombination.CONTROL_DOWN);
    }

    private void showRequestView() {
        this.contentView.getContent().getChildren().setAll(requestView.getView());
    }

    private void showScenarioView() {
        this.contentView.getContent().getChildren().setAll(scenarioView.getView());
    }

    private void showUnderlyingView() {
        this.contentView.getContent().getChildren().setAll(underlyingView.getView());
    }

    private void showMarketView() {
        this.contentView.getContent().getChildren().setAll(marketView.getView(), this.contentView.getMaskerPane());
    }

    private void showTaskStatusView() {
        taskStatusView.getView().show(this.bottomStatusBarView.getTasksInProgressLabel());
    }

    private void showOrHideMenu() {
        if (this.mainView.getMenuAccordion().isVisible()) {
            mainView.getMenuAccordion().setVisible(false);
            mainView.getView().setLeft(null);
        } else {
            mainView.getMenuAccordion().setVisible(true);
            mainView.getView().setLeft(mainView.getMenuAccordion());
        }
    }

    private void showOrHideMenuWithAnimation() {

        // create an animation to hide sidebar.
        final double startWidth = mainView.getMenuAccordion().getWidth();
        final double startContentWidth = mainView.getContentView().getView().getWidth();
        final Animation hideSidebar = new Transition() {
            {
                setCycleDuration(Duration.millis(250));
            }

            protected void interpolate(double frac) {
                final double curWidth = startWidth * (1.0 - frac);
                final double curWidth2 = startWidth * frac;
                mainView.getMenuAccordion().setTranslateX(-startWidth + curWidth);
                mainView.getContentView().getView().setTranslateX(-startWidth + curWidth);
                mainView.getContentView().getView().setPrefWidth(startContentWidth + curWidth2);
                mainView.getContentView().getView().setMinWidth(startContentWidth + curWidth2);
                mainView.getContentView().getView().setMaxWidth(startContentWidth + curWidth2);
//                mainView.getTopStatusBarView().getView().setPrefWidth(startContentWidth + startWidth);
//                mainView.getTopStatusBarView().getView().setMinWidth(startContentWidth + startWidth);
//                mainView.getTopStatusBarView().getView().setMaxWidth(startContentWidth + startWidth);
            }
        };
        hideSidebar.onFinishedProperty().set(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mainView.getMenuAccordion().setVisible(false);
            }
        });

        // create an animation to show a sidebar.
        final Animation showSidebar = new Transition() {
            {
                setCycleDuration(Duration.millis(250));
            }

            protected void interpolate(double frac) {
                final double curWidth = startWidth * frac;
                mainView.getMenuAccordion().setTranslateX(-startWidth + curWidth);
                mainView.getContentView().getView().setTranslateX(-startWidth + curWidth);
                mainView.getContentView().getView().setPrefWidth(startContentWidth - curWidth);
                mainView.getContentView().getView().setMinWidth(startContentWidth - curWidth);
                mainView.getContentView().getView().setMaxWidth(startContentWidth - curWidth);
//                mainView.getTopStatusBarView().getView().setPrefWidth(startContentWidth + startWidth);
//                mainView.getTopStatusBarView().getView().setMinWidth(startContentWidth + startWidth);
//                mainView.getTopStatusBarView().getView().setMaxWidth(startContentWidth + startWidth);
            }
        };
        showSidebar.onFinishedProperty().set(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            }
        });
        if (showSidebar.statusProperty().get() == Animation.Status.STOPPED && hideSidebar.statusProperty().get() == Animation.Status.STOPPED) {
            if (mainView.getMenuAccordion().isVisible()) {
                hideSidebar.play();
            } else {
                mainView.getMenuAccordion().setVisible(true);
                showSidebar.play();
            }
        }

    }



    private void showPreferences() {
        userPrefView.getView().show(this.topStatusBarView.getGearLabel());
    }


}
