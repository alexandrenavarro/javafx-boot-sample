package com.github.alexandrenavarro.javafxbootsample.util;

import com.github.alexandrenavarro.javafxbootsample.statusbar.GlobalStatusView;
import javafx.concurrent.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 * Created by anavarro on 13/03/17.
 */
@Component
@Slf4j
public class TaskExecutor {

    private final GlobalStatusView globalStatusView;

    public TaskExecutor(GlobalStatusView globalStatusView) {
        this.globalStatusView = globalStatusView;
    }

    public <R> CompletableFuture<R> submitTask(final Supplier<R> supplier, final String onRunningMsg, final String onSucceededMsg, final String onFailedMsg) {
        final BackgroundTask<R> backgroundTask = new BackgroundTask<>(supplier, onRunningMsg, onSucceededMsg, onFailedMsg, this.globalStatusView);
        return CompletableFuture.supplyAsync(() -> {
            try {
                return backgroundTask.call();
            } catch (Exception e) {
                log.warn("Error e:{}", e);
            }
            return null;
        });
    }

    public <V> CompletableFuture<V> submitTask(final Task<V> task, final String onRunningMsg, final String onSucceededMsg, final String onFailedMsg) {
        globalStatusView.getContentView().getMaskerPane().progressProperty().bind(task.progressProperty());
        task.setOnRunning(e -> {
            globalStatusView.getBottomStatusBarView().getView().setText(onRunningMsg);
            globalStatusView.getContentView().getMaskerPane().setText(onRunningMsg);
            globalStatusView.getContentView().getMaskerPane().setVisible(true);
        });
        task.setOnSucceeded(e -> {
            globalStatusView.getBottomStatusBarView().getView().setText(onSucceededMsg);
            globalStatusView.getContentView().getMaskerPane().setText(onSucceededMsg);
            globalStatusView.getContentView().getMaskerPane().setVisible(false);
        });
        task.setOnFailed(e -> {
            globalStatusView.getBottomStatusBarView().getView().setText(onFailedMsg);
            globalStatusView.getContentView().getMaskerPane().setText(onFailedMsg);
            globalStatusView.getContentView().getMaskerPane().setVisible(false);
        });
        task.setOnCancelled(e -> {
            globalStatusView.getBottomStatusBarView().getView().setText(onFailedMsg);
            globalStatusView.getContentView().getMaskerPane().setText(onFailedMsg);
            globalStatusView.getContentView().getMaskerPane().setVisible(false);
        });


        return CompletableFuture.supplyAsync(() -> {
            try {
                return task.get();
            } catch (InterruptedException e) {
                log.warn("Error e:{}", e);
            } catch (ExecutionException e) {
                log.warn("Error e:{}", e);
            }
            return null;
        });
    }

}
