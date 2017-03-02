package com.github.alexandrenavarro.javafxbootsample;

import com.github.alexandrenavarro.javafxbootsample.preferences.UserPref;
import com.github.alexandrenavarro.javafxbootsample.preferences.UserPrefBeanInfo;
import com.github.alexandrenavarro.javafxbootsample.preferences.UserPrefView;
import com.github.alexandrenavarro.javafxbootsample.referential.MarketView;
import com.github.alexandrenavarro.javafxbootsample.referential.UnderlyingView;
import com.github.alexandrenavarro.javafxbootsample.request.RequestView;
import com.github.alexandrenavarro.javafxbootsample.scenario.ScenarioView;
import com.github.alexandrenavarro.javafxbootsample.statusbar.BottomStatusBarView;
import com.github.alexandrenavarro.javafxbootsample.statusbar.TaskStatusView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.extern.slf4j.Slf4j;
import org.controlsfx.control.PropertySheet;
import org.controlsfx.control.action.ActionMap;
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
    private final UserPref userPref;


    public MainController(final MainView mainView, final MarketView marketView, final UnderlyingView underlyingView, final ScenarioView scenarioView, final RequestView requestView, final UserPrefView userPrefView, TaskStatusView taskStatusView, BottomStatusBarView bottomStatusBarView, final UserPref userPref) {
        this.mainView = mainView;
        this.marketView = marketView;
        this.underlyingView = underlyingView;
        this.scenarioView = scenarioView;
        this.requestView = requestView;
        this.userPrefView = userPrefView;
        this.taskStatusView = taskStatusView;
        this.bottomStatusBarView = bottomStatusBarView;
        this.userPref = userPref;
        ActionMap.register(this);
    }

    @PostConstruct
    public void initialize() {


        // Init click on memu

        //TODO improve to render impossible to have no at least one menu expanded
        this.mainView.getMenuAccordion().setExpandedPane(this.mainView.getMenuAccordion().getPanes().get(0));

        //TODO improve it with a animation
        this.mainView.getHamburgerLabel().setOnMouseClicked(e -> showOrHideMenu());

        this.mainView.getFindMarketHyperlink().setOnMouseClicked(e -> {
            showMarketView();
        });

        this.mainView.getFindUnderlyingHyperlink().setOnMouseClicked(e -> {
            showUnderlyingView();
        });

        this.mainView.getLoadScenarioHyperlink().setOnMouseClicked(e -> {
            showScenarioView();
        });

        this.mainView.getFindRequestHyperlink().setOnMouseClicked(e -> {
            showRequestView();
        });

        this.bottomStatusBarView.getTaskInProgressButton().setOnMouseClicked(e -> {
            showTaskStatusView();
        });

        // Init Pref
        final ObservableList<PropertySheet.Item> list = FXCollections.observableArrayList();
        final BeanInfo beanInfo = new UserPrefBeanInfo();
        for (final PropertyDescriptor p : beanInfo.getPropertyDescriptors()) {
            list.add(new BeanProperty(userPref, p));
        }
        userPrefView.getPropertySheet().getItems().setAll(list);
        mainView.getGearLabel().setOnMouseClicked(e -> userPrefView.getView().show(mainView.getGearLabel()));


//        this.mainView.getView()
//                .setOnKeyPressed(e -> {
//                    if (e.isControlDown() && e.getCode() == KeyCode.M) {
//
//                    }
//
//                });

    }

    @org.controlsfx.control.action.ActionProxy(text = "Show Request", accelerator = "ctrl+R")
    private void showRequestView() {
        mainView.getContent().getChildren().setAll(requestView.getView());
    }

    @org.controlsfx.control.action.ActionProxy(text = "Show Scenario", accelerator = "ctrl+S")
    private void showScenarioView() {
        mainView.getContent().getChildren().setAll(scenarioView.getView());
    }

    @org.controlsfx.control.action.ActionProxy(text = "Show Underlying", accelerator = "ctrl+U")
    private void showUnderlyingView() {
        mainView.getContent().getChildren().setAll(underlyingView.getView());
    }

    @org.controlsfx.control.action.ActionProxy(text = "Show Market", accelerator = "ctrl+K")
    private void showMarketView() {
        mainView.getContent().getChildren().setAll(marketView.getView());
    }

    @org.controlsfx.control.action.ActionProxy(text = "Show Task", accelerator = "ctrl+T")
    private void showTaskStatusView() {
        mainView.getContent().getChildren().setAll(taskStatusView.getView());
    }

    @org.controlsfx.control.action.ActionProxy(text = "Show Market", accelerator = "ctrl+M")
    private void showOrHideMenu() {
        if (this.mainView.getMenuAccordion().isVisible()) {
            mainView.getMenuAccordion().setVisible(false);
            mainView.getView().setLeft(null);
        } else {
            mainView.getMenuAccordion().setVisible(true);
            mainView.getView().setLeft(mainView.getMenuAccordion());
        }
    }


}
