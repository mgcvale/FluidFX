package dev.mgcvale.fluidfx.components.groups;

import dev.mgcvale.fluidfx.components.core.FluidGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class HGroup extends HBox implements FluidGroup<HGroup> {

    @Override
    public Pane getSelf() {
        return this;
    }

    public HGroup() {
        super();
    }

}
