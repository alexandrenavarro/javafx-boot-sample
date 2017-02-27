package com.github.alexandrenavarro.javafxbootsample;

import com.github.alexandrenavarro.javafxbootsample.statusbar.BottomStatusBarView;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.utils.FontAwesomeIconFactory;
import javafx.scene.control.Accordion;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.builder.AccordionBuilder;
import javafx.scene.control.builder.HyperlinkBuilder;
import javafx.scene.control.builder.LabelBuilder;
import javafx.scene.control.builder.TitledPaneBuilder;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.builder.BorderPaneBuilder;
import javafx.scene.layout.builder.StackPaneBuilder;
import javafx.scene.layout.builder.VBoxBuilder;
import lombok.Getter;
import org.controlsfx.control.builder.StatusBarBuilder;
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
    private final Label hamburgerLabel = LabelBuilder.create()
            .id("hamburgerLabelReference")
            .graphic(FontAwesomeIconFactory.get().createIcon(FontAwesomeIcon.BARS))
            .build();
    @Getter
    private final Label gearLabel = LabelBuilder.create()
            .graphic(FontAwesomeIconFactory.get().createIcon(FontAwesomeIcon.GEARS))
            .build();

    @Getter
    private final StackPane content = StackPaneBuilder.create().build();

    @Getter
    private final Hyperlink findUnderlyingHyperlink = HyperlinkBuilder.create()
            .text("Find Underlying")
            .build();
    @Getter
    private final Hyperlink findOptionMaturitiesHyperlink = HyperlinkBuilder.create()
            .text("Find Option Maturities")
            .build();
    @Getter
    private final Hyperlink findMarketHyperlink = HyperlinkBuilder.create()
            .text("Find Market")
            .build();
    @Getter
    private final Hyperlink findRequestHyperlink = HyperlinkBuilder.create()
            .text("Find Request")
            .build();

    @Getter
    private final Hyperlink loadScenarioHyperlink = HyperlinkBuilder.create()
            .text("Load Scenario")
            .build();

    @Getter
    private final Accordion menuAccordion;

    @Inject
    public MainView(final BottomStatusBarView bottomStatusBarView) {
        this.bottomStatusBarView = bottomStatusBarView;
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
                .top(StatusBarBuilder.create()
                        .leftItems(hamburgerLabel)
                        .rightItems(gearLabel)
                        .text("")
                        .build())
                .bottom(bottomStatusBarView.getView())
                .center(TitledPaneBuilder.create()
                        .collapsible(false)
                        .text("")
                        .maxHeight(Double.MAX_VALUE)
                        .content(content)
                        .build())
                .build();
    }


}
