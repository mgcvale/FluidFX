package dev.mgcvale.fluidfx.components.controls;

import dev.mgcvale.fluidfx.components.core.FluidControl;
import dev.mgcvale.fluidfx.components.util.Ref;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.scene.control.Control;
import javafx.scene.control.ToggleButton;

public class FluidToggleButton extends ToggleButton implements FluidControl<FluidToggleButton> {
    @Override
    public Control getSelf() {
        return this;
    }

    public FluidToggleButton(String text) {
        super(text);
    }

    public FluidToggleButton withPressed(boolean pressed) {
        setPressed(pressed);
        return this;
    }

    public FluidToggleButton watchPressedProperty(BooleanProperty observer) {
        observer.bind(pressedProperty());
        return this;
    }

    public FluidToggleButton bindPressedProperty(BooleanBinding binding) {
        binding.addListener((obs, o, n) -> setPressed(n));
        return this;
    }

}
