package dev.mgcvale.fluidfx.components.core;

import javafx.scene.control.Control;
import javafx.scene.control.Tooltip;

public interface FluidControl<T extends FluidControl<T>> extends FluidRegion<T> {
    Control getSelf();

    @SuppressWarnings("unchecked")
    default T wTooltip(Tooltip tooltip) {
        getSelf().setTooltip(tooltip);
        return (T) this;
    }
}