package dev.mgcvale.fluidfx.components.controls;

import dev.mgcvale.fluidfx.components.core.FluidControl;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Control;
import javafx.scene.control.TextArea;

public class FluidTextArea extends TextArea implements FluidControl<FluidTextArea> {
    @Override
    public Control getSelf() {
        return this;
    }

    public FluidTextArea() {
        super();
    }

    public FluidTextArea withPrompt(String prompt) {
        setPromptText(prompt);
        return this;
    }

    // text properties
    public FluidTextArea withText(String text) {
        setText(text);
        return this;
    }

    public FluidTextArea bindTextProperty(StringBinding stringBinding) {
        textProperty().bind(stringBinding);
        return this;
    }

    public FluidTextArea watchTextProperty(StringProperty observer) {
        observer.bind(textProperty());
        return this;
    }

}
