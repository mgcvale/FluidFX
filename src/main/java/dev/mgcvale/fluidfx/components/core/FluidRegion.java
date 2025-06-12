package dev.mgcvale.fluidfx.components.core;

import dev.mgcvale.fluidfx.components.util.Ref;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;


import javafx.scene.layout.Region;public interface FluidRegion<T extends FluidRegion<T>> extends FluidFX<T> {
    Region getSelf();

    @SuppressWarnings("unchecked")
    default T watchWidthProperty(DoubleProperty observer) {
        observer.bind(getSelf().widthProperty());
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T watchHeightProperty(DoubleProperty observer) {
        observer.bind(getSelf().heightProperty());
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T watchMinWidthProperty(DoubleProperty observer) {
        observer.bind(getSelf().minWidthProperty());
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T watchMinHeightProperty(DoubleProperty observer) {
        observer.bind(getSelf().minHeightProperty());
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T watchPrefWidthProperty(DoubleProperty observer) {
        observer.bind(getSelf().prefWidthProperty());
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T watchPrefHeightProperty(DoubleProperty observer) {
        observer.bind(getSelf().prefHeightProperty());
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T watchMaxWidthProperty(DoubleProperty observer) {
        observer.bind(getSelf().maxWidthProperty());
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T watchMaxHeightProperty(DoubleProperty observer) {
        observer.bind(getSelf().maxHeightProperty());
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T bindMinWidth(DoubleBinding binding) {
        getSelf().minWidthProperty().bind(binding);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T bindMinHeight(DoubleBinding binding) {
        getSelf().minHeightProperty().bind(binding);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T bindPrefWidth(DoubleBinding binding) {
        getSelf().prefWidthProperty().bind(binding);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T bindPrefHeight(DoubleBinding binding) {
        getSelf().prefHeightProperty().bind(binding);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T bindMaxWidth(DoubleBinding binding) {
        getSelf().maxWidthProperty().bind(binding);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T bindMaxHeight(DoubleBinding binding) {
        getSelf().maxHeightProperty().bind(binding);
        return (T) this;
    }

    // Set explicit values

    @SuppressWarnings("unchecked")
    default T withMinWidth(double minWidth) {
        getSelf().setMinWidth(minWidth);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T withMinHeight(double minHeight) {
        getSelf().setMinHeight(minHeight);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T withPrefWidth(double prefWidth) {
        getSelf().setPrefWidth(prefWidth);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T withPrefHeight(double prefHeight) {
        getSelf().setPrefHeight(prefHeight);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T withMaxWidth(double maxWidth) {
        getSelf().setMaxWidth(maxWidth);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T withMaxHeight(double maxHeight) {
        getSelf().setMaxHeight(maxHeight);
        return (T) this;
    }
}
