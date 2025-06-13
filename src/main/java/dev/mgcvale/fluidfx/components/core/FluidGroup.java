package dev.mgcvale.fluidfx.components.core;


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
    default T inChildren(ObservableList<Node> children) {
        children.addListener(new ListChangeListener<Node>() {
            @Override
            public void onChanged(Change<? extends Node> change) {
                getSelf().getChildren().setAll(children);
            }
        });
        return (T) this;
    }
}