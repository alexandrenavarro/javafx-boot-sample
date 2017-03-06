package com.github.alexandrenavarro.javafxbootsample.util;

import com.github.alexandrenavarro.javafxbootsample.statusbar.GlobalStatusView;
import javafx.concurrent.Task;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by anavarro on 06/03/17.
 */

@Getter
@Setter
public abstract class GenericTask<V> extends Task<V> {

    private final String onRunningMsg;
    private final String onSucceededMsg;
    private final String onFailedMsg;

    public GenericTask(String onRunningMsg, String onSucceededMsg, String onFailedMsg, GlobalStatusView globalStatusView) {
        this.onRunningMsg = onRunningMsg;
        this.onSucceededMsg = onSucceededMsg;
        this.onFailedMsg = onFailedMsg;
        globalStatusView.getContentView().getMaskerPane().progressProperty().bind(this.progressProperty());
        globalStatusView.getContentView().getMaskerPane().textProperty().bind(this.messageProperty());
        globalStatusView.getBottomStatusBarView().getView().textProperty().bind(this.messageProperty());
        this.setOnRunning(e -> {
            updateMessage(this.onRunningMsg);
            globalStatusView.getContentView().getMaskerPane().setVisible(true);
        });
        this.setOnSucceeded(e -> {
            updateMessage(this.onSucceededMsg);
            globalStatusView.getContentView().getMaskerPane().setVisible(false);
        });
        this.setOnFailed(e -> {
            updateMessage(this.onFailedMsg);
            globalStatusView.getContentView().getMaskerPane().setVisible(false);
        });
        this.setOnCancelled(e -> {
            updateMessage(this.onFailedMsg);
            globalStatusView.getContentView().getMaskerPane().setVisible(false);
        });

        globalStatusView.getTaskStatusView().getTaskProgressView().getTasks().add(this);
    }

}
