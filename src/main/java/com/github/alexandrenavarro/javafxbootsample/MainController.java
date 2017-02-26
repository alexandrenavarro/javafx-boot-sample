package com.github.alexandrenavarro.javafxbootsample;

import com.github.alexandrenavarro.javafxbootsample.preferences.UserPref;
import com.github.alexandrenavarro.javafxbootsample.preferences.UserPrefBeanInfo;
import com.github.alexandrenavarro.javafxbootsample.preferences.UserPrefView;
import com.github.alexandrenavarro.javafxbootsample.referential.MarketView;
import com.github.alexandrenavarro.javafxbootsample.referential.UnderlyingView;
import com.github.alexandrenavarro.javafxbootsample.request.RequestView;
import com.github.alexandrenavarro.javafxbootsample.scenario.ScenarioView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private final UserPref userPref;


    public MainController(final MainView mainView, final MarketView marketView, final UnderlyingView underlyingView, final ScenarioView scenarioView, final RequestView requestView, final UserPrefView userPrefView, final UserPref userPref) {
        this.mainView = mainView;
        this.marketView = marketView;
        this.underlyingView = underlyingView;
        this.scenarioView = scenarioView;
        this.requestView = requestView;
        this.userPrefView = userPrefView;
        this.userPref = userPref;
    }

    @PostConstruct
    public void initialize() {

        // Init click on memu

        //TODO improve to render impossible to have no at least one menu expanded
        this.mainView.getMenuAccordionRef().get().setExpandedPane(this.mainView.getMenuAccordionRef().get().getPanes().get(0));

        //TODO improve it with a animation
        this.mainView.getHamburgerLabelRef().get().setOnMouseClicked(e -> showOrHideMenu());

        this.mainView.getFindMarketHyperlinkRef().get().setOnMouseClicked(e -> {
            mainView.getContentRef().get().getChildren().setAll(marketView.getView());
        });

        this.mainView.getFindUnderlyingHyperlinkRef().get().setOnMouseClicked(e -> {
            mainView.getContentRef().get().getChildren().setAll(underlyingView.getView());
        });

        this.mainView.getLoadScenarioHyperlinkRef().get().setOnMouseClicked(e -> {
            mainView.getContentRef().get().getChildren().setAll(scenarioView.getView());
        });

        this.mainView.getFindRequestHyperlinkRef().get().setOnMouseClicked(e -> {
            mainView.getContentRef().get().getChildren().setAll(requestView.getView());
        });

        // Init Pref
        final ObservableList<PropertySheet.Item> list = FXCollections.observableArrayList();
        final BeanInfo beanInfo = new UserPrefBeanInfo();
        for (final PropertyDescriptor p : beanInfo.getPropertyDescriptors()) {
            list.add(new BeanProperty(userPref, p));
        }
        userPrefView.getPropertySheetRef().get().getItems().setAll(list);
        mainView.getGearLabelRef().get().setOnMouseClicked(e -> userPrefView.getView().show(mainView.getGearLabelRef().get()));
    }

    private void showOrHideMenu() {
        if (this.mainView.getMenuAccordionRef().get().isVisible()) {
            mainView.getMenuAccordionRef().get().setVisible(false);
            mainView.getView().setLeft(null);
        } else {
            mainView.getMenuAccordionRef().get().setVisible(true);
            mainView.getView().setLeft(mainView.getMenuAccordionRef().get());
        }
    }


}
