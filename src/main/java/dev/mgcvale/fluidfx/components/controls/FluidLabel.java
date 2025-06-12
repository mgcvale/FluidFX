package dev.mgcvale.fluidfx.components.controls;

import dev.mgcvale.fluidfx.components.core.FluidControl;
import dev.mgcvale.fluidfx.components.core.FluidFX;
import dev.mgcvale.fluidfx.components.core.FluidLabeled;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;

public class FluidLabel extends Label implements FluidLabeled<FluidLabel> {
    @Override
    public Labeled getSelf() {
        return this;
    }

    public FluidLabel(String text) {
        super(text);
    }

    public FluidLabel() {
        super();
    }
}
