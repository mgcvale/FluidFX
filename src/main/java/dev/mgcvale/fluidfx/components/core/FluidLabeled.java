package dev.mgcvale.fluidfx.components.core;

import javafx.beans.binding.StringBinding;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Labeled;

public interface FluidLabeled<T extends FluidLabeled<T>> extends FluidControl<T> {
    Labeled getSelf();

    // text properties
    @SuppressWarnings("unchecked")
    default T withText(String text) {
        getSelf().setText(text);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T bindTextProperty(StringBinding stringBinding) {
        getSelf().textProperty().bind(stringBinding);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T watchTextProperty(StringProperty observer) {
        observer.bind(getSelf().textProperty());
        return (T) this;
    }

}
