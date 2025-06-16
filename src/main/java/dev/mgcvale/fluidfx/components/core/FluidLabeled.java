package dev.mgcvale.fluidfx.components.core;

import javafx.beans.binding.StringBinding;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Labeled;
import javafx.scene.text.TextAlignment;

public interface FluidLabeled<T extends FluidLabeled<T>> extends FluidControl<T> {
    Labeled getSelf();

    // text properties
    @SuppressWarnings("unchecked")
    default T wText(String text) {
        getSelf().setText(text);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T inText(StringExpression stringBinding) {
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

    @SuppressWarnings("unchecked")
    default T wTextAlignment(TextAlignment align) {
        getSelf().setTextAlignment(align);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T wWrap(boolean wrap) {
        getSelf().setWrapText(wrap);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T inWrap(BooleanProperty wrap) {
        getSelf().wrapTextProperty().bind(wrap);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T outWrap(BooleanProperty wrap) {
        wrap.bind(getSelf().wrapTextProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T biWrap(BooleanProperty wrap) {
        wrap.bindBidirectional(getSelf().wrapTextProperty());
        return (T) this;
    }

}
