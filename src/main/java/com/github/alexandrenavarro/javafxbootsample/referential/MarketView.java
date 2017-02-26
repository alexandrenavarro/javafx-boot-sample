package com.github.alexandrenavarro.javafxbootsample.referential;

import com.github.alexandrenavarro.javafxbootsample.View;
import com.github.alexandrenavarro.javafxbootsample.util.builder.Ref;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.builder.ButtonBuilder;
import javafx.scene.control.builder.TableViewBuilder;
import javafx.scene.layout.builder.StackPaneBuilder;
import javafx.scene.layout.builder.VBoxBuilder;
import lombok.Getter;
import org.controlsfx.control.MaskerPane;
import org.controlsfx.control.builder.MaskerPaneBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by anavarro on 26/02/17.
 */
@Component
public class MarketView implements View {

    @Getter
    private final Node view;

    @Getter
    private Ref<MaskerPane> maskerPaneRef = Ref.create();
    @Getter
    private Ref<Button> searchButtonRef = Ref.create();
    @Getter
    private Ref<TableView<Object>> tableViewRef = Ref.create();

    public MarketView() {
        this.view = VBoxBuilder.create()
                .children(
                        ButtonBuilder.create()
                                .text("Search").buildToRef(searchButtonRef),
                        StackPaneBuilder.create()
                                .children(
                                        TableViewBuilder.create()
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
                                                .buildToRef(tableViewRef),
                                        MaskerPaneBuilder.create().visible(false).buildToRef(maskerPaneRef))
                                .build()
                ).build();
    }

}
