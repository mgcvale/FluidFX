package dev.mgcvale.fluidfx.components.controls;

import dev.mgcvale.fluidfx.components.core.FluidLabeled;
import javafx.beans.property.BooleanProperty;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Labeled;

public class FCheckBox extends CheckBox implements FluidLabeled<FCheckBox> {
    @Override
    public Labeled getSelf() {
        return this;
    }

    public FCheckBox(String name) {
        super(name);
    }
    public FCheckBox() {
        super();
    }
    public FCheckBox(boolean checked) {
        super();
        setSelected(checked);
    }
    public FCheckBox(boolean checked, String name) {
        super(name);
        setSelected(checked);
    }

    public FCheckBox wSelected(boolean s) {
        setSelected(s);
        return this;
    }
    public FCheckBox inSelected(BooleanProperty s) {
        selectedProperty().bind(s);
        return this;
    }
    public FCheckBox outSelected(BooleanProperty s) {
        s.bind(selectedProperty());
        return this;
    }
    public FCheckBox biSelected(BooleanProperty s) {
        s.bindBidirectional(selectedProperty());
        return this;
    }


    public FCheckBox wIndeterminate(boolean s) {
        setIndeterminate(s);
        return this;
    }
    public FCheckBox inIndeterminate(BooleanProperty s) {
        indeterminateProperty().bind(s);
        return this;
    }
    public FCheckBox outIndeterminate(BooleanProperty s) {
        s.bind(indeterminateProperty());
        return this;
    }
    public FCheckBox biIndeterminate(BooleanProperty s) {
        s.bindBidirectional(indeterminateProperty());
        return this;
    }

}
