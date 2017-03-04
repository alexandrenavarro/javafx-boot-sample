package com.github.alexandrenavarro.javafxbootsample.statusbar;

import javafx.concurrent.Task;
import lombok.Getter;
import org.controlsfx.control.PopOver;
import org.controlsfx.control.TaskProgressView;
import org.controlsfx.control.builder.PopOverBuilder;
import org.controlsfx.control.builder.TaskProgressViewBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by anavarro on 02/03/17.
 */
@Component
public class TaskStatusView {

    @Getter
    private final PopOver view;

    @Getter
    private TaskProgressView<Task<?>> taskProgressView = TaskProgressViewBuilder.create().build();

    public TaskStatusView() {
        view = PopOverBuilder.create()
                .contentNode(taskProgressView)
                .arrowLocation(PopOver.ArrowLocation.RIGHT_BOTTOM)
                .build();
    }


}
