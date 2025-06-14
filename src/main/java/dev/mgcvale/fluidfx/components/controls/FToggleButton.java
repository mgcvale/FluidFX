package dev.mgcvale.fluidfx.components.controls;

import dev.mgcvale.fluidfx.components.core.FluidControl;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.BooleanExpression;
import javafx.beans.property.BooleanProperty;
import javafx.scene.control.Control;
import javafx.scene.control.ToggleButton;

public class FToggleButton extends ToggleButton implements FluidControl<FToggleButton> {
    @Override
    public Control getSelf() {
        return this;
    }

    public FToggleButton(String text) {
        super(text);
    }

    public FToggleButton wPressed(boolean pressed) {
        setPressed(pressed);
        return this;
    }

    public FToggleButton outPressed(BooleanProperty observer) {
        observer.bind(pressedProperty());
        return this;
    }

    public FToggleButton inPressed(BooleanExpression binding) {
        binding.addListener((obs, o, n) -> setPressed(n));
        return this;
    }

}
