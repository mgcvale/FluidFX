package dev.mgcvale.fluidfx.components.controls;

import dev.mgcvale.fluidfx.components.core.FluidControl;
import dev.mgcvale.fluidfx.components.core.FluidFX;
import javafx.scene.control.Control;
import javafx.scene.control.Label;

public class FluidLabel extends Label implements FluidControl<FluidLabel> {
    @Override
    public Control getSelf() {
        return this;
    }

    public FluidLabel(String text) {
        super(text);
    }
}
