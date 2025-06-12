package dev.mgcvale.fluidfx.components.controls;

import dev.mgcvale.fluidfx.components.core.FluidLabeled;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;

public class FLabel extends Label implements FluidLabeled<FLabel> {
    @Override
    public Labeled getSelf() {
        return this;
    }

    public FLabel(String text) {
        super(text);
    }

    public FLabel() {
        super();
    }
}
