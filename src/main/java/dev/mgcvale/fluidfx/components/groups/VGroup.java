package dev.mgcvale.fluidfx.components.groups;

import dev.mgcvale.fluidfx.components.core.FluidGroup;
import dev.mgcvale.fluidfx.components.core.FluidRegion;
import javafx.scene.layout.VBox;

public class VGroup extends VBox implements FluidGroup<VGroup> {

    @Override
    public VGroup getSelf() {
        return this;
    }

    public VGroup() {
        super();
    }

}
