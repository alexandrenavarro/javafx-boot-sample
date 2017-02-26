package com.github.alexandrenavarro.javafxbootsample.preferences;

import com.github.alexandrenavarro.javafxbootsample.util.builder.Ref;
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
    private final Ref<PropertySheet> propertySheetRef = Ref.create();

    public UserPrefView() {
        view = PopOverBuilder.create()
                .contentNode(PropertySheetBuilder.create().buildToRef(propertySheetRef))
                .arrowLocation(PopOver.ArrowLocation.RIGHT_TOP)
                .build();

    }
}
