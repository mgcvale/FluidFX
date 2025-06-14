package dev.mgcvale.fluidfx.example.todolist.view;

import dev.mgcvale.fluidfx.components.controls.FButton;
import dev.mgcvale.fluidfx.components.controls.FLabel;
import dev.mgcvale.fluidfx.components.controls.FListView;
import dev.mgcvale.fluidfx.components.controls.FTextField;
import dev.mgcvale.fluidfx.components.controls.FCheckBox;
import dev.mgcvale.fluidfx.components.core.FluidGroup;
import dev.mgcvale.fluidfx.components.groups.HGroup;
import dev.mgcvale.fluidfx.components.groups.VGroup;
import dev.mgcvale.fluidfx.components.layout.Pad;
import dev.mgcvale.fluidfx.example.todolist.model.TodoItem;
import dev.mgcvale.fluidfx.example.todolist.viewmodel.TodoListViewModel;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class TodoList extends VBox implements FluidGroup<TodoList> {

    public TodoList(TodoListViewModel vm) {
        getChildren().addAll(
                new VGroup().wChildren(
                        new HGroup().wSpacing(12).wChildren(
                                new FTextField().hgrow().biText(vm.newItemTitleProperty()).onKeyPressed(e -> vm.setError("")),
                                new FButton("Criar").onAction(e -> vm.addItem())
                        ),
                        new FLabel().inText(vm.errorProperty()).inVisible(vm.errorProperty().isEmpty())
                ),
                new FListView<TodoItem>().wCellFactory(lv -> new ListCell<TodoItem>() {
                    @Override
                    protected void updateItem(TodoItem todoItem, boolean empty) {
                        super.updateItem(todoItem, empty);
                        if (empty || todoItem == null) {
                            setText(null);
                            setGraphic(null);
                        } else {
                            setGraphic(new HGroup().wSpacing(8).wChildren(
                                    new FCheckBox().biIndeterminate(todoItem.doneProperty()),
                                    new FLabel().biText(todoItem.titleProperty()).hgrow()
                            ));
                        }
                    }
                }).wItems(vm.getItems()).outSelectedItem(vm.selectedItemProperty()),
                new HGroup().wSpacing(8).wPadding(Pad.x(8)).wChildren(
                        new FButton("Limpar feitas").onAction(e -> vm.clearDone()),
                        new FButton("Deletar").onAction(e -> vm.removeItem(vm.selectedItemProperty().get())).inDisable(vm.selectedItemProperty().isNull())
                )
        );

    }

    @Override
    public Pane getSelf() {
        return this;
    }
}
