package dev.mgcvale.fluidfx.components.groups;

import dev.mgcvale.fluidfx.components.core.FluidFX;
import dev.mgcvale.fluidfx.components.core.FluidGroup;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class BorderGroup extends BorderPane implements FluidGroup<BorderGroup> {

    @Override
    public Pane getSelf() {
        return this;
    }

    public BorderGroup() {
        super();
    }

    public BorderGroup withCenter(Node center) {
        setCenter(center);
        return this;
    }

    public BorderGroup withLeft(Node left) {
        setLeft(left);
        return this;
    }

    public BorderGroup withRight(Node right) {
        setRight(right);
        return this;
    }

    public BorderGroup withTop(Node top) {
        setTop(top);
        return this;
    }

    public BorderGroup withBottom(Node bottom) {
        setBottom(bottom);
        return this;
    }

}
