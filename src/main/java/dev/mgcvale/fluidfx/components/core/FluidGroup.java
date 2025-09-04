package dev.mgcvale.fluidfx.components.core;

import javafx.beans.property.ListProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.List;

public interface FluidGroup<T extends FluidGroup<T>> extends FluidRegion<T> {
    Pane getSelf();

    @SuppressWarnings("unchecked")
    default T wChildren(Node...children) {
        getSelf().getChildren().addAll(children);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T wChildren(List<Node> children) {
        getSelf().getChildren().addAll(children);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T outChildren(ListProperty<Node> children) {
        getSelf().getChildren().addListener((ListChangeListener<? super Node>) change -> children.setAll(change.getList()));
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T inChildren(ObservableList<Node> children) {
        // Set initial children
        getSelf().getChildren().setAll(children);

        // Listen for changes and update
        children.addListener((ListChangeListener<Node>) change -> {
            getSelf().getChildren().setAll(children);
        });
        return (T) this;
    }
}