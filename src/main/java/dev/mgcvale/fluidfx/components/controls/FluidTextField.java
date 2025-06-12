package dev.mgcvale.fluidfx.components.controls;

import dev.mgcvale.fluidfx.components.core.FluidControl;
import dev.mgcvale.fluidfx.components.core.FluidFX;
import dev.mgcvale.fluidfx.components.core.FluidLabeled;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;

public class FluidTextField extends TextField implements FluidControl<FluidTextField> {

    @Override
    public Control getSelf() {
        return this;
    }

    public FluidTextField() {
        super();
    }

    public FluidTextField withPrompt(String prompt) {
        setPromptText(prompt);
        return this;
    }

    // text properties
    public FluidTextField withText(String text) {
        setText(text);
        return this;
    }

    public FluidTextField bindTextProperty(StringBinding stringBinding) {
        textProperty().bind(stringBinding);
        return this;
    }

    public FluidTextField watchTextProperty(StringProperty observer) {
        observer.bind(textProperty());
        return this;
    }

}
