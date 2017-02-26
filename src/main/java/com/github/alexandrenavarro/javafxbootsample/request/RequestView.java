package com.github.alexandrenavarro.javafxbootsample.request;


import com.github.alexandrenavarro.javafxbootsample.View;
import com.github.alexandrenavarro.javafxbootsample.util.builder.Ref;
import javafx.geometry.Pos;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.builder.LabelBuilder;
import javafx.scene.control.builder.TreeTableViewBuilder;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.builder.BorderPaneBuilder;
import javafx.scene.layout.builder.HBoxBuilder;
import lombok.Getter;
import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.control.textfield.builder.CustomTextFieldBuilder;
import org.springframework.stereotype.Component;

@Component
public class RequestView implements View {

    private final BorderPane requestView;

    @Getter
    private final Ref<CustomTextField> customTextFieldRef = Ref.create();
    @Getter
    private final Ref<TreeTableView> treeTableViewRef = Ref.create();

    public RequestView() {
        this.requestView = BorderPaneBuilder.create()
                .top(HBoxBuilder.create()
                        .alignment(Pos.CENTER_LEFT)
                        .children(
                                LabelBuilder.create()
                                        .text("Find a Request").build(),
                                CustomTextFieldBuilder.create()
                                        .promptText("1000123  or 78f23bd0-266c-42b7-91fc-b63369fb02b7").buildToRef(customTextFieldRef))
                        .build())
                .center(TreeTableViewBuilder.create().build())
                .build();
    }

    @Override
    public BorderPane getView() {
        return requestView;
    }


}
