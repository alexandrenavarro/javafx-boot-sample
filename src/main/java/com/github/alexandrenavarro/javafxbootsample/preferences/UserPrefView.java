package com.github.alexandrenavarro.javafxbootsample.preferences;

import lombok.Getter;
import org.controlsfx.control.PopOver;
import org.controlsfx.control.PropertySheet;
import org.controlsfx.control.builder.PopOverBuilder;
import org.controlsfx.control.builder.PropertySheetBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by anavarro on 26/02/17.
 */
@Component
public class UserPrefView {

    @Getter
    private final PopOver view;

    @Getter
    private final PropertySheet propertySheet = PropertySheetBuilder.create().build();

    public UserPrefView() {
        view = PopOverBuilder.create()
                .contentNode(propertySheet)
                .arrowLocation(PopOver.ArrowLocation.RIGHT_TOP)
                .build();

    }
}
