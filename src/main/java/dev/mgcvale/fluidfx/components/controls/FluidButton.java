package dev.mgcvale.fluidfx.components.controls;

import dev.mgcvale.fluidfx.components.core.FluidFX;
import dev.mgcvale.fluidfx.components.util.Ref;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class FluidButton extends Button implements FluidFX<FluidButton> {

    @Override
    public Node getSelf() {
        return this;
    }

    public FluidButton(String text) {
        super(text);
    }

    public FluidButton withOnAction(EventHandler<ActionEvent> onAction) {
        setOnAction(onAction);
        return this;
    }

    public FluidButton withText(String text) {
        setText(text);
        return this;
    }

    public FluidButton bindTextProperty(StringBinding stringBinding) {
        textProperty().bind(stringBinding);
        return this;
    }

    public FluidButton watchTextProperty(StringProperty observer) {
        observer.bind(textProperty());
        return this;
    }

    public FluidButton getTextProperty(Ref<StringProperty> ref) {
        ref.ref = textProperty();
        return this;
    }
}
