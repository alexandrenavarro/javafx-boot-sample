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
 * Created by anavarro on 04/03/17.
 */
@Component
public class TopStatusBarView {

    @Getter
    private final KeyCombination ctrlMKeyCombination = new KeyCodeCombination(KeyCode.M, KeyCombination.CONTROL_DOWN);

    @Getter
    private final Label hamburgerLabel = LabelBuilder.create()
            .id("hamburgerLabelReference")
            .graphic(FontAwesomeIconFactory.get().createIcon(FontAwesomeIcon.BARS))
            .tooltip(TooltipBuilder.create().text(ctrlMKeyCombination.getDisplayText()).build())
            .build();

    @Getter
    private final KeyCombination ctrlPKeyCombination = new KeyCodeCombination(KeyCode.P, KeyCombination.CONTROL_DOWN);

    @Getter
    private final Label gearLabel = LabelBuilder.create()
            .graphic(FontAwesomeIconFactory.get().createIcon(FontAwesomeIcon.GEARS))
            .tooltip(TooltipBuilder.create().text(ctrlPKeyCombination.getDisplayText()).build())
            .build();

    @Getter
    private final StatusBar view;

    public TopStatusBarView() {
        view = StatusBarBuilder.create()
                .leftItems(hamburgerLabel)
                .rightItems(gearLabel)
                .text("")
                .build();
    }


}
