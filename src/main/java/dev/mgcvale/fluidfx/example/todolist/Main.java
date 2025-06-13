package dev.mgcvale.fluidfx.example.todolist;

import dev.mgcvale.fluidfx.components.controls.FLabel;
import dev.mgcvale.fluidfx.components.groups.VGroup;
import dev.mgcvale.fluidfx.components.layout.Pad;
import dev.mgcvale.fluidfx.example.todolist.view.TodoList;
import dev.mgcvale.fluidfx.example.todolist.viewmodel.TodoListViewModel;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        TodoListViewModel todoViewModel = new TodoListViewModel();
        Scene s = new Scene(
                new VGroup().wAlignment(Pos.TOP_CENTER).wChildren(
                        new FLabel("Todo list").wPadding(Pad.bottom(8)).wStyleClass("text-8"),
                        new FLabel("Todo list made with FluidFX").wPadding(Pad.bottom(16)).wStyleClass("text-2"),
                        new TodoList(todoViewModel).wMaxWidth(600).wPadding(Pad.x(32))
                ), 600, 900
        );
        s.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        stage.setScene(s);
        stage.show();
    }
}
