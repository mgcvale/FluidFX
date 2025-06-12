package dev.mgcvale.fluidfx.components.controls;

import dev.mgcvale.fluidfx.components.core.FluidControl;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Control;
import javafx.scene.control.TextArea;

public class FTextArea extends TextArea implements FluidControl<FTextArea> {
    @Override
    public Control getSelf() {
        return this;
    }

    public FTextArea() {
        super();
    }

    public FTextArea withPrompt(String prompt) {
        setPromptText(prompt);
        return this;
    }

    // text properties
    public FTextArea wText(String text) {
        setText(text);
        return this;
    }

    public FTextArea inText(StringBinding stringBinding) {
        textProperty().bind(stringBinding);
        return this;
    }

    public FTextArea outText(StringProperty observer) {
        observer.bind(textProperty());
        return this;
    }

}
