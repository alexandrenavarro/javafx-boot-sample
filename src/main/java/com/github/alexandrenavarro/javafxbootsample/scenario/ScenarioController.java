package com.github.alexandrenavarro.javafxbootsample.scenario;

import javafx.stage.FileChooser;
import lombok.extern.slf4j.Slf4j;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.model.StyleSpans;
import org.fxmisc.richtext.model.StyleSpansBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by anavarro on 26/02/17.
 */
@Component
@Slf4j
public class ScenarioController {

    private static final String[] KEYWORDS = new String[]{"given a sales", "given a trader",
            "then wait scenarioStatus", "when the sales send a rfq", "send price", "send order accepted", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum", "extends", "final",
            "finally", "float", "for", "goto", "if", "implements", "import", "instanceof",
            "int", "interface", "long", "native", "new", "package", "private",
            "protected", "public", "return", "short", "static", "strictfp", "super",
            "switch", "synchronized", "this", "throw", "throws", "transient", "try",
            "void", "volatile", "while"};

    private static final String KEYWORD_PATTERN = "\\b(" + String.join("|", KEYWORDS)
            + ")\\b";
    private static final String PAREN_PATTERN = "\\(|\\)";
    private static final String BRACE_PATTERN = "\\{|\\}";
    private static final String BRACKET_PATTERN = "\\[|\\]";
    private static final String SEMICOLON_PATTERN = "\\;";
    private static final String STRING_PATTERN = "\"([^\"\\\\]|\\\\.)*\"";
    private static final String COMMENT_PATTERN = "//[^\n]*" + "|" + "/\\*(.|\\R)*?\\*/";

    private static final Pattern PATTERN = Pattern.compile("(?<KEYWORD>" + KEYWORD_PATTERN
            + ")" + "|(?<PAREN>" + PAREN_PATTERN + ")" + "|(?<BRACE>" + BRACE_PATTERN
            + ")" + "|(?<BRACKET>" + BRACKET_PATTERN + ")" + "|(?<SEMICOLON>"
            + SEMICOLON_PATTERN + ")" + "|(?<STRING>" + STRING_PATTERN + ")"
            + "|(?<COMMENT>" + COMMENT_PATTERN + ")");


    private static final String sampleCode = "given a sales \"irmat.villet\"\n" +
            "given a trader \"samuel.raux\"\n" +
            "\n" +
            "when the sales send a rfq {\n" +
            "}\n" +
            "\n" +
            "then wait scenarioStatus \"NEW\"\n" +
            "then wait scenarioStatus \"BEING-PRICED\"\n" +
            "\n" +
            "send price {\n" +
            "}\n" +
            "\n" +
            "then wait scenarioStatus \"PRICED\"\n" +
            "send order accepted {\n" +
            "}\n" +
            "\n" +
            "then wait scenarioStatus \"ORDER-ACCEPTED\"\n";


    private final ScenarioView scenarioView;

    public ScenarioController(ScenarioView scenarioView) {
        this.scenarioView = scenarioView;
    }


    @PostConstruct
    public void initialize() {
        final CodeArea codeArea = this.scenarioView.getCodeArea();
        codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
        //final VirtualizedScrollPane<CodeArea> vCodeArea = new VirtualizedScrollPane<>(codeArea);
        codeArea.richChanges().filter(ch -> !ch.getInserted().equals(ch.getRemoved())) // XXX
                .subscribe(change -> {
                    codeArea.setStyleSpans(0, computeHighlighting(codeArea.getText()));
                });
        codeArea.replaceText(0, 0, sampleCode);
        codeArea.getStylesheets()
                .add(getClass().getResource("/java-keywords.css").toExternalForm());

        this.scenarioView.getOpenButton().setOnAction(e -> {
            openScenario();
        });

        this.scenarioView.getSaveButton().setOnAction(e -> {
            saveScenario();
        });

        this.scenarioView.getView()
                .setOnKeyPressed(e -> {
                    if (this.scenarioView.getCtrlOKeyCombination().match(e)) {
                        openScenario();
                    } else if (this.scenarioView.getCtrlSKeyCombination().match(e)) {
                        saveScenario();
                    }
                });


        this.scenarioView.getStopButton().disarm();

    }

    private void openScenario() {
        final FileChooser fileChooser = new FileChooser();
        final FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("SCenario Onyx (*.sco)", "*.sco");
        fileChooser.getExtensionFilters().add(extFilter);
        final File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            try {
                this.scenarioView.getCodeArea().replaceText(new String(Files.readAllBytes(file.toPath())));
            } catch (IOException e1) {
                log.warn("Error e:{}", e1);
            }
        }
        log.info("file:{}", file);
    }

    private void saveScenario() {
        final FileChooser fileChooser = new FileChooser();
        final FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("SCenario Onyx (*.sco)", "*.sco");
        fileChooser.getExtensionFilters().add(extFilter);
        final File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            try {
                Files.write(file.toPath(), this.scenarioView.getCodeArea().getText().getBytes(), StandardOpenOption.CREATE);
            } catch (IOException e1) {
                log.warn("Error e:{}", e1);
            }
        }
    }

    private static StyleSpans<Collection<String>> computeHighlighting(String text) {
        Matcher matcher = PATTERN.matcher(text);
        int lastKwEnd = 0;
        StyleSpansBuilder<Collection<String>> spansBuilder = new StyleSpansBuilder<>();
        while (matcher.find()) {
            String styleClass = matcher.group("KEYWORD") != null ? "keyword"
                    : matcher.group("PAREN") != null ? "paren"
                    : matcher.group("BRACE") != null ? "brace"
                    : matcher.group("BRACKET") != null ? "bracket"
                    : matcher.group("SEMICOLON") != null
                    ? "semicolon"
                    : matcher.group("STRING") != null
                    ? "string"
                    : matcher
                    .group("COMMENT") != null
                    ? "comment"
                    : null;
            /* never happens */
            assert styleClass != null;
            spansBuilder.add(Collections.emptyList(), matcher.start() - lastKwEnd);
            spansBuilder.add(Collections.singleton(styleClass),
                    matcher.end() - matcher.start());
            lastKwEnd = matcher.end();
        }
        spansBuilder.add(Collections.emptyList(), text.length() - lastKwEnd);
        return spansBuilder.create();
    }

}