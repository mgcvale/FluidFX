package dev.mgcvale.fluidfx.components.controls;

import dev.mgcvale.fluidfx.components.core.FluidControl;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;

public class FTextField extends TextField implements FluidControl<FTextField> {

    @Override
    public Control getSelf() {
        return this;
    }

    public FTextField() {
        super();
    }

    public FTextField wPrompt(String prompt) {
        setPromptText(prompt);
        return this;
    }

    // text properties
    public FTextField wText(String text) {
        setText(text);
        return this;
    }

    public FTextField inText(StringExpression stringBinding) {
        textProperty().bind(stringBinding);
        return this;
    }
    public FTextField outText(StringProperty observer) {
        observer.bind(textProperty());
        return this;
    }
    public FTextField biText(StringProperty property) {
        property.bindBidirectional(textProperty());
        return this;
    }

}
