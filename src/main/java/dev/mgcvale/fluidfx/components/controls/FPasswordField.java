package dev.mgcvale.fluidfx.components.controls;

import dev.mgcvale.fluidfx.components.core.FluidControl;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Control;
import javafx.scene.control.PasswordField;

public class FPasswordField extends PasswordField implements FluidControl<FPasswordField> {
    @Override
    public Control getSelf() {
        return this;
    }

    public FPasswordField() {
        super();
    }

    public FPasswordField wPrompt(String prompt) {
        setPromptText(prompt);
        return this;
    }


    public FPasswordField wText(String text) {
        setText(text);
        return this;
    }
    public FPasswordField inText(StringExpression stringBinding) {
        textProperty().bind(stringBinding);
        return this;
    }
    public FPasswordField outText(StringProperty observer) {
        observer.bind(textProperty());
        return this;
    }
    public FPasswordField biText(StringProperty property) {
        property.bindBidirectional(textProperty());
        return this;
    }
}
