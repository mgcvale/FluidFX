package dev.mgcvale.fluidfx.components.groups;


import dev.mgcvale.fluidfx.components.core.FluidControl;
import dev.mgcvale.fluidfx.components.core.FluidGroup;
import javafx.beans.binding.BooleanExpression;
import javafx.beans.property.BooleanProperty;
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

    public ScrollGroup wHbarPolicy(ScrollBarPolicy policy) {
        setHbarPolicy(policy);
        return this;
    }

    public ScrollGroup wVbarPolicy(ScrollBarPolicy policy) {
        setVbarPolicy(policy);
        return this;
    }

    public ScrollGroup wContent(Node content) {
        setContent(content);
        return this;
    }

    public ScrollGroup wFixedWitdh() {
        setFitToWidth(true);
        return this;
    }

    public ScrollGroup wFixedHeight() {
        setFitToHeight(true);
        return this;
    }

    public ScrollGroup wPannable(boolean pane) {
        setPannable(pane);
        return this;
    }
    public ScrollGroup inPannable(BooleanExpression p) {
        pannableProperty().bind(p);
        return this;
    }
    public ScrollGroup outPannable(BooleanProperty p) {
        p.bind(pannableProperty());
        return this;
    }
    public ScrollGroup biPannable(BooleanProperty p) {
        p.bindBidirectional(pannableProperty());
        return this;
    }


}