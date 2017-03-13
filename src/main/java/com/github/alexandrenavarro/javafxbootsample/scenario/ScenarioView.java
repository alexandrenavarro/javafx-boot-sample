package com.github.alexandrenavarro.javafxbootsample.scenario;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.utils.FontAwesomeIconFactory;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextAreaBuilder;
import javafx.scene.control.builder.ButtonBuilder;
import javafx.scene.control.builder.TooltipBuilder;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.layout.builder.HBoxBuilder;
import javafx.scene.layout.builder.VBoxBuilder;
import lombok.Getter;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.springframework.stereotype.Component;

/**
 * Created by anavarro on 26/02/17.
 */
@Component
public class ScenarioView {

    @Getter
    private final VBox view;

    @Getter
    private final KeyCombination ctrlOKeyCombination = new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN);

    @Getter
    private final Button openButton = ButtonBuilder.create()
            .graphic(FontAwesomeIconFactory.get().createIcon(FontAwesomeIcon.FOLDER_OPEN))
            .tooltip(TooltipBuilder.create().text(ctrlOKeyCombination.getDisplayText()).build())
            .build();


    @Getter
    private final KeyCombination ctrlSKeyCombination = new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN);

    @Getter
    private final Button saveButton = ButtonBuilder.create()
            .graphic(FontAwesomeIconFactory.get().createIcon(FontAwesomeIcon.SAVE))
            .tooltip(TooltipBuilder.create().text(ctrlSKeyCombination.getDisplayText()).build())
            .build();

    @Getter
    private final Button playButton = ButtonBuilder.create()
            .graphic(FontAwesomeIconFactory.get().createIcon(FontAwesomeIcon.PLAY))
            .build();

    @Getter
    private final Button stepForwardButton = ButtonBuilder.create()
            .graphic(FontAwesomeIconFactory.get().createIcon(FontAwesomeIcon.STEP_FORWARD))
            .build();

    @Getter
    private final Button pauseButton = ButtonBuilder.create()
            .graphic(FontAwesomeIconFactory.get().createIcon(FontAwesomeIcon.PAUSE))
            .build();

    @Getter
    private final Button stopButton = ButtonBuilder.create()
            .graphic(FontAwesomeIconFactory.get().createIcon(FontAwesomeIcon.STOP))
            .build();

    @Getter
    private final TextArea consoleTextArea = TextAreaBuilder.create().build();

    @Getter
    private final CodeArea codeArea = new CodeArea();


    @Getter
    private final VirtualizedScrollPane codeAreaVirtualizedScrollPane = new VirtualizedScrollPane(codeArea);

    public ScenarioView() {
        final HBox codeAreaHBox = HBoxBuilder.create().children(codeAreaVirtualizedScrollPane).padding(new Insets(5)).build();
        view = VBoxBuilder.create()
                .children(
                        HBoxBuilder.create().children(openButton, saveButton).padding(new Insets(5)).build(),
                        codeAreaHBox,
                        HBoxBuilder.create().children(playButton, pauseButton, stepForwardButton, stopButton).alignment(Pos.CENTER_RIGHT).padding(new Insets(5)).build(),
                        HBoxBuilder.create().children(consoleTextArea).padding(new Insets(5)).build()
                )
                .build();
        VBox.setVgrow(codeAreaHBox, Priority.ALWAYS);
        HBox.setHgrow(consoleTextArea, Priority.ALWAYS);
        HBox.setHgrow(codeAreaVirtualizedScrollPane, Priority.ALWAYS);


    }

}
