package dev.mgcvale.fluidfx.components.groups;

import dev.mgcvale.fluidfx.components.core.FluidGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class StackGroup extends StackPane implements FluidGroup<StackGroup> {
    @Override
    public Pane getSelf() {
        return this;
    }

    public StackGroup() {
        super();
    }

}