package com.github.alexandrenavarro.javafxbootsample.referential;

import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.builder.ButtonBuilder;
import javafx.scene.control.builder.TableViewBuilder;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.layout.builder.VBoxBuilder;
import lombok.Getter;
import org.controlsfx.control.MaskerPane;
import org.controlsfx.control.builder.MaskerPaneBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by anavarro on 26/02/17.
 */
@Component
public class MarketView {

    @Getter
    private final VBox view;

    @Getter
    private final Button searchButton = ButtonBuilder.create()
            .text("Search").build();

    @Getter
    private final TableView tableView = TableViewBuilder.create()
//                                                        .columns(
//                                                                TableColumnBuilder.create()
//                                                                        .text("name")
//                                                                        .cellValueFactory(new PropertyValueFactory<>("name")).build(),
//                                                                TableColumnBuilder.create()
//                                                                        .text("Mic Code")
//                                                                        .cellValueFactory(new PropertyValueFactory<>("micCode")).build(),
//                                                                TableColumnBuilder.create()
//                                                                        .text("Label")
//                                                                        .cellValueFactory(new PropertyValueFactory<>("label")).build())
            .build();

    @Getter
    private final MaskerPane maskerPane = MaskerPaneBuilder.create().visible(false).build();

    public MarketView() {
        this.view = VBoxBuilder.create()
                .children(
                        searchButton,
                        tableView
                )
                .build();
        VBox.setVgrow(tableView, Priority.ALWAYS);


    }

}
