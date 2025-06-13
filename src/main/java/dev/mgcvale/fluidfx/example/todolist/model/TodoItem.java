package dev.mgcvale.fluidfx.example.todolist.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TodoItem {
    private StringProperty title;
    private BooleanProperty done;

    public TodoItem(String title, boolean done) {
        this.title = new SimpleStringProperty(title);
        this.done = new SimpleBooleanProperty(done);
    }

    public void setDone(boolean done) {
        this.done.set(done);
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getTitle() {
        return title.get();
    }

    public boolean isDone() {
        return done.get();
    }

    public BooleanProperty doneProperty() {
        return done;
    }

    public StringProperty titleProperty() {
        return title;
    }
}
