package dev.mgcvale.fluidfx.components.core;


import javafx.scene.Node;
import javafx.scene.layout.Pane;

public interface FluidGroup<T extends FluidGroup<T>> extends FluidRegion<T> {
    Pane getSelf();

    @SuppressWarnings("unchecked")
    default T withChildren(Node...children) {
        getSelf().getChildren().addAll(children);

        return (T) this;
    }
}