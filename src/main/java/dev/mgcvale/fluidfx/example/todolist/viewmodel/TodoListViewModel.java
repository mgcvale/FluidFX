package dev.mgcvale.fluidfx.example.todolist.viewmodel;

import dev.mgcvale.fluidfx.example.todolist.model.TodoItem;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class TodoListViewModel {
    private ObservableList<TodoItem> items;
    private StringProperty newItemTitle, error;
    private ObjectProperty<TodoItem> selectedItem;

    public TodoListViewModel() {
        error = new SimpleStringProperty("");
        newItemTitle = new SimpleStringProperty("");
        items = FXCollections.observableArrayList();
        selectedItem = new SimpleObjectProperty<>(null);
    }

    public void addItem() {
        if (!newItemTitle.get().trim().isEmpty()) {
            getItems().add(new TodoItem(newItemTitle.get().trim(), false));
            newItemTitle.set("");
            error.set("");
        } else {
            error.set("O nome não pode ser vazio");
        }
    }

    public StringProperty errorProperty() {
        return error;
    }

    public void setError(String error) {
        this.error.set(error);
    }

    public void removeItem(TodoItem item) {
        items.remove(item);
    }

    public StringProperty newItemTitleProperty() {
        return newItemTitle;
    }

    public ObservableList<TodoItem> getItems() {
        return items;
    }

    public ObjectProperty<TodoItem> selectedItemProperty() {
        return selectedItem;
    }

    public void clearDone() {
        items.removeIf(TodoItem::isDone);
    }
}
