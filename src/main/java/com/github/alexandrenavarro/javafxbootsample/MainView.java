package com.github.alexandrenavarro.javafxbootsample;

import com.github.alexandrenavarro.javafxbootsample.statusbar.BottomStatusBarView;
import com.github.alexandrenavarro.javafxbootsample.util.builder.Ref;
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
public class MainView implements View {

    @Getter
    private final BorderPane view;
    @Getter
    private final BottomStatusBarView bottomStatusBarView;

    @Getter
    private Ref<Accordion> menuAccordionRef = Ref.create();
    @Getter
    private Ref<Label> gearLabelRef = Ref.create();
    @Getter
    private Ref<Label> hamburgerLabelRef = Ref.create();
    @Getter
    private Ref<Hyperlink> findUnderlyingHyperlinkRef = Ref.create();
    @Getter
    private Ref<Hyperlink> findMarketHyperlinkRef = Ref.create();
    @Getter
    private Ref<Hyperlink> findOptionMaturitiesHyperlinkRef = Ref.create();
    @Getter
    private Ref<Hyperlink> findRequestHyperlinkRef = Ref.create();
    @Getter
    private Ref<Hyperlink> loadScenarioHyperlinkRef = Ref.create();
    @Getter
    private Ref<StackPane> contentRef = Ref.create();

    @Inject
    public MainView(final BottomStatusBarView bottomStatusBarView) {
        this.bottomStatusBarView = bottomStatusBarView;
        this.view = BorderPaneBuilder.create()
                .left(AccordionBuilder.create()
                        .panes(
                                TitledPaneBuilder.create()
                                        .id("b")
                                        .text("Referential")
                                        .content(VBoxBuilder.create()
                                                .children(
                                                        HyperlinkBuilder.create()
                                                                .text("Find Underlying")
                                                                .buildToRef(findUnderlyingHyperlinkRef),
                                                        HyperlinkBuilder.create()
                                                                .text("Find Option Maturities")
                                                                .buildToRef(findOptionMaturitiesHyperlinkRef),
                                                        HyperlinkBuilder.create()
                                                                .text("Find Market")
                                                                .buildToRef(findMarketHyperlinkRef))
                                                .build())
                                        .build(),
                                TitledPaneBuilder.create()
                                        .text("Request")
                                        .content(VBoxBuilder.create()
                                                .children(
                                                        HyperlinkBuilder.create()
                                                                .text("Find Request")
                                                                .buildToRef(findRequestHyperlinkRef))
                                                .build())
                                        .build(),
                                TitledPaneBuilder.create()
                                        .text("Scenario")
                                        .content(VBoxBuilder.create()
                                                .children(
                                                        HyperlinkBuilder.create()
                                                                .text("Load Scenario")
                                                                .buildToRef(loadScenarioHyperlinkRef))
                                                .build())
                                        .build())
                        .buildToRef(menuAccordionRef))
                .top(StatusBarBuilder.create()
                        .leftItems(LabelBuilder.create()
                                .id("hamburgerLabelReference")
                                .graphic(FontAwesomeIconFactory.get().createIcon(FontAwesomeIcon.BARS))
                                .buildToRef(hamburgerLabelRef))
                        .rightItems(LabelBuilder.create()
                                .graphic(FontAwesomeIconFactory.get().createIcon(FontAwesomeIcon.GEARS))
                                .buildToRef(gearLabelRef))
                        .text("")
                        .build())
                .bottom(bottomStatusBarView.getView())
                .center(TitledPaneBuilder.create()
                        .collapsible(false)
                        .text("")
                        .maxHeight(Double.MAX_VALUE)
                        .content(StackPaneBuilder.create().buildToRef(contentRef))
                        .build())
                .build();
    }


}
