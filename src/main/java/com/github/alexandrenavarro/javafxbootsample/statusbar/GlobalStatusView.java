package com.github.alexandrenavarro.javafxbootsample.statusbar;

import com.github.alexandrenavarro.javafxbootsample.content.ContentView;
import lombok.Getter;
import org.springframework.stereotype.Component;

/**
 * Created by anavarro on 06/03/17.
 */
@Component
public class GlobalStatusView {

    @Getter
    private final TaskStatusView taskStatusView;
    @Getter
    private final BottomStatusBarView bottomStatusBarView;
    @Getter
    private final ContentView contentView;


    public GlobalStatusView(TaskStatusView taskStatusView, BottomStatusBarView bottomStatusBarView, ContentView contentView) {
        this.taskStatusView = taskStatusView;
        this.bottomStatusBarView = bottomStatusBarView;
        this.contentView = contentView;
    }
}
