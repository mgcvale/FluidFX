package dev.mgcvale.fluidfx.components.groups;


import dev.mgcvale.fluidfx.components.core.FluidControl;
import dev.mgcvale.fluidfx.components.core.FluidGroup;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;


public class ScrollGroup extends ScrollPane implements FluidControl<ScrollGroup> {
    @Override
    public Control getSelf() {
        return this;
    }

    public ScrollGroup() {
        super();
    }

    public ScrollGroup hbarPolicy(ScrollBarPolicy policy) {
        setHbarPolicy(policy);
        return this;
    }

    public ScrollGroup vbarPolicy(ScrollBarPolicy policy) {
        setVbarPolicy(policy);
        return this;
    }

    public ScrollGroup withContent(Node content) {
        setContent(content);
        return this;
    }

    public ScrollGroup withFixedWitdh() {
        setFitToWidth(true);
        return this;
    }


}