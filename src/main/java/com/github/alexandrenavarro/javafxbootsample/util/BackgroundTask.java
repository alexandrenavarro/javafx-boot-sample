package com.github.alexandrenavarro.javafxbootsample.util;

import com.github.alexandrenavarro.javafxbootsample.statusbar.GlobalStatusView;
import javafx.concurrent.Task;

import java.util.function.Supplier;

/**
 * Created by anavarro on 13/03/17.
 */
public class BackgroundTask<V> extends Task<V> {


    private final String onRunningMsg;
    private final String onSucceededMsg;
    private final String onFailedMsg;
    private final Supplier<V> supplier;

    public BackgroundTask(final Supplier<V> supplier, final String onRunningMsg, final String onSucceededMsg, final String onFailedMsg, GlobalStatusView globalStatusView) {
        super();
        this.onRunningMsg = onRunningMsg;
        this.onSucceededMsg = onSucceededMsg;
        this.onFailedMsg = onFailedMsg;
        this.supplier = supplier;

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

    }


    @Override
    protected V call() throws Exception {
        return supplier.get();
    }
}
