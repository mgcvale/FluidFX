package dev.mgcvale.fluidfx.components.core;

import javafx.beans.binding.StringBinding;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Labeled;

public interface FluidLabeled<T extends FluidLabeled<T>> extends FluidControl<T> {
    Labeled getSelf();

    // text properties
    @SuppressWarnings("unchecked")
    default T wText(String text) {
        getSelf().setText(text);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T inText(ObservableValue<String> stringBinding) {
        getSelf().textProperty().bind(stringBinding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T outText(StringProperty observer) {
        observer.bind(getSelf().textProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T biText(StringProperty text) {
        getSelf().textProperty().bindBidirectional(text);
        return (T) this;
    }

}
