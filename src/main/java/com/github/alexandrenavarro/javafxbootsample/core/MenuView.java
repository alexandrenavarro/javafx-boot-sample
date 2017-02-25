package com.github.alexandrenavarro.javafxbootsample.core;

import com.github.alexandrenavarro.javafxbootsample.referential.GroupView;
import com.github.alexandrenavarro.javafxbootsample.referential.UnderlyingView;
import javafx.scene.Group;
import javafx.scene.control.Accordion;
import javafx.scene.control.builder.AccordionBuilder;
import javafx.scene.control.builder.LabelBuilder;
import javafx.scene.control.builder.TitledPaneBuilder;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.builder.VBoxBuilder;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by anavarro on 25/02/17.
 */
@Component
public class MenuView {

    private final Accordion accordion;
    private final ContentView contentView;
    private final UnderlyingView underlyingView;
    private final GroupView groupView;

    @Inject
    public MenuView(final ContentView contentView, final UnderlyingView underlyingView, final GroupView groupView) {
        this.contentView = contentView;
        this.underlyingView = underlyingView;
        this.groupView = groupView;
        this.accordion = AccordionBuilder.create()
                .panes(
                        TitledPaneBuilder.create()
                                .text("Referential")
                                .content(VBoxBuilder.create()
                                        .children(
                                                LabelBuilder.create()
                                                        .text("Underlying")
                                                        .onMouseClicked(e -> {
                                                        })
                                                        .onKeyPressed(e -> {
                                                            if (e.isControlDown() && e.getCode() == KeyCode.U) {

                                                            }
                                                        })

                                                        .build(),
                                                LabelBuilder.create()
                                                        .text("Group")
                                                        .onMouseClicked(e -> {
                                                        }).build())
                                        .build())
                                .build(),
                        TitledPaneBuilder.create()
                                .text("Scenario")
                                .onMouseClicked(e -> {
                                    //((BorderPane) stage.getScene().getRoot()).setCenter(countryView.getView());
                                }).build())

                .build();


    }

    public Accordion getAccordion() {
        return accordion;
    }
}
