package com.github.alexandrenavarro.javafxbootsample;

import com.github.alexandrenavarro.javafxbootsample.content.ContentView;
import com.github.alexandrenavarro.javafxbootsample.statusbar.BottomStatusBarView;
import com.github.alexandrenavarro.javafxbootsample.statusbar.TopStatusBarView;
import javafx.scene.control.Accordion;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.builder.AccordionBuilder;
import javafx.scene.control.builder.HyperlinkBuilder;
import javafx.scene.control.builder.TitledPaneBuilder;
import javafx.scene.control.builder.TooltipBuilder;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.builder.BorderPaneBuilder;
import javafx.scene.layout.builder.VBoxBuilder;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by anavarro on 25/02/17.
 */
@Component
public class MainView {

    @Getter
    private final BorderPane view;

    @Getter
    private final BottomStatusBarView bottomStatusBarView;

    @Getter
    private final TopStatusBarView topStatusBarView;

    @Getter
    private final ContentView contentView;

    @Getter
    private final KeyCombination ctrlUKeyCombination = new KeyCodeCombination(KeyCode.U, KeyCombination.CONTROL_DOWN);

    @Getter
    private final Hyperlink findUnderlyingHyperlink = HyperlinkBuilder.create()
            .text("Find Underlying")
            .tooltip(TooltipBuilder.create().text(ctrlUKeyCombination.getDisplayText()).build())
            .build();

    @Getter
    private final KeyCombination ctrlOKeyCombination = new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN);

    @Getter
    private final Hyperlink findOptionMaturitiesHyperlink = HyperlinkBuilder.create()
            .text("Find Option Maturities")
            .tooltip(TooltipBuilder.create().text(ctrlOKeyCombination.getDisplayText()).build())
            .build();

    @Getter
    private final KeyCombination ctrlKKeyCombination = new KeyCodeCombination(KeyCode.K, KeyCombination.CONTROL_DOWN);

    @Getter
    private final Hyperlink findMarketHyperlink = HyperlinkBuilder.create()
            .text("Find Market")
            .tooltip(TooltipBuilder.create().text(ctrlKKeyCombination.getDisplayText()).build())
            .build();

    @Getter
    private final KeyCombination ctrlRKeyCombination = new KeyCodeCombination(KeyCode.R, KeyCombination.CONTROL_DOWN);

    @Getter
    private final Hyperlink findRequestHyperlink = HyperlinkBuilder.create()
            .text("Find Request")
            .tooltip(TooltipBuilder.create().text(ctrlRKeyCombination.getDisplayText()).build())
            .build();

    @Getter
    private final KeyCombination ctrlSKeyCombination = new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN);

    @Getter
    private final Hyperlink loadScenarioHyperlink = HyperlinkBuilder.create()
            .text("Load Scenario")
            .tooltip(TooltipBuilder.create().text(ctrlSKeyCombination.getDisplayText()).build())
            .build();

    @Getter
    private final Accordion menuAccordion;

    @Inject
    public MainView(final BottomStatusBarView bottomStatusBarView, TopStatusBarView topStatusBarView, ContentView contentView) {
        this.bottomStatusBarView = bottomStatusBarView;
        this.topStatusBarView = topStatusBarView;
        this.contentView = contentView;
        this.menuAccordion = AccordionBuilder.create()
                .panes(
                        TitledPaneBuilder.create()
                                .text("Referential")
                                .content(VBoxBuilder.create()
                                        .children(
                                                findUnderlyingHyperlink,
                                                findOptionMaturitiesHyperlink,
                                                findMarketHyperlink)
                                        .build())
                                .build(),
                        TitledPaneBuilder.create()
                                .text("Request")
                                .content(VBoxBuilder.create()
                                        .children(
                                                findRequestHyperlink)
                                        .build())
                                .build(),
                        TitledPaneBuilder.create()
                                .text("Scenario")
                                .content(VBoxBuilder.create()
                                        .children(
                                                loadScenarioHyperlink)
                                        .build())
                                .build())
                .build();
        this.view = BorderPaneBuilder.create()
                .left(menuAccordion)
                .top(this.topStatusBarView.getView())
                .bottom(this.bottomStatusBarView.getView())
                .center(this.contentView.getView())
                .build();
    }


}
