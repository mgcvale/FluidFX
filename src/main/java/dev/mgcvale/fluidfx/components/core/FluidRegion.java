package dev.mgcvale.fluidfx.components.core;

import dev.mgcvale.fluidfx.components.util.Ref;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.DoubleExpression;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;


import javafx.geometry.Insets;
import javafx.scene.layout.Region;public interface FluidRegion<T extends FluidRegion<T>> extends FluidFX<T> {
    Region getSelf();

    // observers
    @SuppressWarnings("unchecked")
    default T outWidthProperty(DoubleProperty observer) {
        observer.bind(getSelf().widthProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T outHeightProperty(DoubleProperty observer) {
        observer.bind(getSelf().heightProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T outMinWidthProperty(DoubleProperty observer) {
        observer.bind(getSelf().minWidthProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T outMinHeightProperty(DoubleProperty observer) {
        observer.bind(getSelf().minHeightProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T outPrefWidthProperty(DoubleProperty observer) {
        observer.bind(getSelf().prefWidthProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T outPrefHeightProperty(DoubleProperty observer) {
        observer.bind(getSelf().prefHeightProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T outMaxWidthProperty(DoubleProperty observer) {
        observer.bind(getSelf().maxWidthProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T outMaxHeightProperty(DoubleProperty observer) {
        observer.bind(getSelf().maxHeightProperty());
        return (T) this;
    }

    // bindings
    @SuppressWarnings("unchecked")
    default T inMinWidth(DoubleExpression binding) {
        getSelf().minWidthProperty().bind(binding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T inMinHeight(DoubleExpression binding) {
        getSelf().minHeightProperty().bind(binding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T inPrefWidth(DoubleExpression binding) {
        getSelf().prefWidthProperty().bind(binding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T inPrefHeight(DoubleExpression binding) {
        getSelf().prefHeightProperty().bind(binding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T inMaxWidth(DoubleExpression binding) {
        getSelf().maxWidthProperty().bind(binding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T inMaxHeight(DoubleExpression binding) {
        getSelf().maxHeightProperty().bind(binding);
        return (T) this;
    }

    // setters
    @SuppressWarnings("unchecked")
    default T wMinWidth(double minWidth) {
        getSelf().setMinWidth(minWidth);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T wMinHeight(double minHeight) {
        getSelf().setMinHeight(minHeight);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T wPrefWidth(double prefWidth) {
        getSelf().setPrefWidth(prefWidth);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T wPrefHeight(double prefHeight) {
        getSelf().setPrefHeight(prefHeight);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T wMaxWidth(double maxWidth) {
        getSelf().setMaxWidth(maxWidth);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T wMaxHeight(double maxHeight) {
        getSelf().setMaxHeight(maxHeight);
        return (T) this;
    }

    // padding
    @SuppressWarnings("unchecked")
    default T wPadding(Insets padding) {
        getSelf().setPadding(padding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T inPadding(ObjectProperty<Insets> paddingBinding) {
        getSelf().paddingProperty().bind(paddingBinding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T outPadding(ObjectProperty<Insets> observer) {
        observer.bind(getSelf().paddingProperty());
        return (T) this;
    }

}
