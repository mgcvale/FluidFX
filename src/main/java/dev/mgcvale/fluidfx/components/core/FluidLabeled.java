package dev.mgcvale.fluidfx.components.core;

import javafx.beans.binding.StringBinding;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Labeled;

public interface FluidLabeled<T extends FluidLabeled<T>> extends FluidControl<FluidLabeled<T>> {
    Labeled getSelf();

    // text properties
    default T withText(String text) {
        getSelf().setText(text);
        return (T) this;
    }

    default T bindTextProperty(StringBinding stringBinding) {
        getSelf().textProperty().bind(stringBinding);
        return (T) this;
    }

    default T watchTextProperty(StringProperty observer) {
        observer.bind(getSelf().textProperty());
        return (T) this;
    }

}
