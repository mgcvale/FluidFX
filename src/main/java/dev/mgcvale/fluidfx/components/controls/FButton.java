package dev.mgcvale.fluidfx.components.controls;

import dev.mgcvale.fluidfx.components.core.FluidFX;
import dev.mgcvale.fluidfx.components.core.FluidLabeled;
import dev.mgcvale.fluidfx.components.util.Ref;
import javafx.beans.binding.ObjectExpression;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;

public class FButton extends Button implements FluidLabeled<FButton> {

    @Override
    public Labeled getSelf() {
        return this;
    }

    public FButton(String text) {
        super(text);
    }

    public FButton onAction(EventHandler<ActionEvent> onAction) {
        setOnAction(onAction);
        return this;
    }

    public FButton wGraphic(Node graphic) {
        setGraphic(graphic);
        return this;
    }

    public FButton inGraphic(ObjectExpression<Node> graphic) {
        graphicProperty().bind(graphic);
        return this;
    }
}
