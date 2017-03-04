package com.github.alexandrenavarro.javafxbootsample.statusbar;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.utils.FontAwesomeIconFactory;
import javafx.scene.control.Label;
import javafx.scene.control.builder.LabelBuilder;
import javafx.scene.control.builder.TooltipBuilder;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import lombok.Getter;
import org.controlsfx.control.StatusBar;
import org.controlsfx.control.builder.StatusBarBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by anavarro on 25/02/17.
 */
@Component
public class BottomStatusBarView {

    @Getter
    private final StatusBar view;

    @Getter
    private final KeyCombination ctrlTKeyCombination = new KeyCodeCombination(KeyCode.T, KeyCombination.CONTROL_DOWN);

    @Getter
    private final Label tasksInProgressLabel = LabelBuilder.create()
            .graphic(FontAwesomeIconFactory.get().createIcon(FontAwesomeIcon.TASKS))
            .tooltip(TooltipBuilder.create().text(ctrlTKeyCombination.getDisplayText()).build())
            .build();

    public BottomStatusBarView() {
        view = StatusBarBuilder.create()
                .rightItems(tasksInProgressLabel)
                .build();
    }

}
