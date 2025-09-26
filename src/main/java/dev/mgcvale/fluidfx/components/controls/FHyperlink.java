package dev.mgcvale.fluidfx.components.controls;

import dev.mgcvale.fluidfx.components.core.FluidLabeled;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Hyperlink;

import java.util.function.Consumer;

public class FHyperlink extends Hyperlink implements FluidLabeled<FHyperlink> {
    @Override
    public FHyperlink getSelf() {
        return this;
    }

    public FHyperlink onAction(EventHandler<ActionEvent> onAction) {
        setOnAction(onAction);
        return this;
    }
}
