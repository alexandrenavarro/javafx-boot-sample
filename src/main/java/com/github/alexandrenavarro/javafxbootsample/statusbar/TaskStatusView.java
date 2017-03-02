package com.github.alexandrenavarro.javafxbootsample.statusbar;

import javafx.concurrent.Task;
import lombok.Getter;
import org.controlsfx.control.TaskProgressView;
import org.controlsfx.control.builder.TaskProgressViewBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by anavarro on 02/03/17.
 */
@Component
public class TaskStatusView {

    @Getter
    private TaskProgressView<Task<?>> view = TaskProgressViewBuilder.create().build();


}
