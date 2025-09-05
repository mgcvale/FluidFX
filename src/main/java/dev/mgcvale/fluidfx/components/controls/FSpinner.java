package dev.mgcvale.fluidfx.components.controls;

import dev.mgcvale.fluidfx.components.core.FluidControl;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Control;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.util.StringConverter;

public class FSpinner<T> extends Spinner<T> implements FluidControl<FSpinner<T>> {

    @Override
    public Control getSelf() {
        return this;
    }

    public FSpinner() {
        super();
    }

    public FSpinner(SpinnerValueFactory<T> valueFactory) {
        super(valueFactory);
    }

    public FSpinner(int min, int max, int initialValue) {
        super(min, max, initialValue);
    }

    public FSpinner(int min, int max, int initialValue, int amountToStepBy) {
        super(min, max, initialValue, amountToStepBy);
    }

    public FSpinner(double min, double max, double initialValue) {
        super(min, max, initialValue);
    }

    public FSpinner(double min, double max, double initialValue, double amountToStepBy) {
        super(min, max, initialValue, amountToStepBy);
    }

    public FSpinner<T> wEditable(boolean editable) {
        setEditable(editable);
        return this;
    }

    public FSpinner<T> inEditable(ObservableValue<Boolean> editable) {
        editableProperty().bind(editable);
        return this;
    }

    public FSpinner<T> outEditable(ObjectProperty<Boolean> observer) {
        observer.bind(editableProperty().asObject());
        return this;
    }

    // wrap around functionality (only works with Integer and Double value factories)
    public FSpinner<T> wWrapAround(boolean wrapAround) {
        SpinnerValueFactory<T> factory = getValueFactory();
        if (factory instanceof SpinnerValueFactory.IntegerSpinnerValueFactory) {
            ((SpinnerValueFactory.IntegerSpinnerValueFactory) factory).setWrapAround(wrapAround);
        } else if (factory instanceof SpinnerValueFactory.DoubleSpinnerValueFactory) {
            ((SpinnerValueFactory.DoubleSpinnerValueFactory) factory).setWrapAround(wrapAround);
        }
        return this;
    }

    public FSpinner<T> wValue(T value) {
        getValueFactory().setValue(value);
        return this;
    }

    public FSpinner<T> inValue(ObservableValue<T> value) {
        getValueFactory().valueProperty().bind(value);
        return this;
    }

    public FSpinner<T> outValue(ObjectProperty<T> observer) {
        observer.bind(getValueFactory().valueProperty());
        return this;
    }

    public FSpinner<T> biValue(ObjectProperty<T> property) {
        getValueFactory().valueProperty().bindBidirectional(property);
        return this;
    }

    public FSpinner<T> onValueChange(ChangeListener<? super T> listener) {
        valueProperty().addListener(listener);
        return this;
    }

    public FSpinner<T> wValueFactory(SpinnerValueFactory<T> valueFactory) {
        setValueFactory(valueFactory);
        return this;
    }

    public FSpinner<T> inValueFactory(ObservableValue<SpinnerValueFactory<T>> valueFactory) {
        valueFactoryProperty().bind(valueFactory);
        return this;
    }

    public FSpinner<T> outValueFactory(ObjectProperty<SpinnerValueFactory<T>> observer) {
        observer.bind(valueFactoryProperty());
        return this;
    }

    public FSpinner<T> wConverter(StringConverter<T> converter) {
        if (getValueFactory() != null) {
            getValueFactory().setConverter(converter);
        }
        return this;
    }

    public static FSpinner<Integer> intSpinner(int min, int max, int initialValue) {
        return new FSpinner<>(min, max, initialValue);
    }

    public static FSpinner<Integer> intSpinner(int min, int max, int initialValue, int step) {
        return new FSpinner<>(min, max, initialValue, step);
    }

    public static FSpinner<Double> doubleSpinner(double min, double max, double initialValue) {
        return new FSpinner<>(min, max, initialValue);
    }

    public static FSpinner<Double> doubleSpinner(double min, double max, double initialValue, double step) {
        return new FSpinner<>(min, max, initialValue, step);
    }

    public FSpinner<T> wIntRange(int min, int max) {
        SpinnerValueFactory<T> factory = getValueFactory();
        if (factory instanceof SpinnerValueFactory.IntegerSpinnerValueFactory) {
            SpinnerValueFactory.IntegerSpinnerValueFactory intFactory =
                (SpinnerValueFactory.IntegerSpinnerValueFactory) factory;
            intFactory.setMin(min);
            intFactory.setMax(max);
        }
        return this;
    }

    public FSpinner<T> wDoubleRange(double min, double max) {
        SpinnerValueFactory<T> factory = getValueFactory();
        if (factory instanceof SpinnerValueFactory.DoubleSpinnerValueFactory) {
            SpinnerValueFactory.DoubleSpinnerValueFactory doubleFactory =
                (SpinnerValueFactory.DoubleSpinnerValueFactory) factory;
            doubleFactory.setMin(min);
            doubleFactory.setMax(max);
        }
        return this;
    }

    public FSpinner<T> wIntStep(int step) {
        SpinnerValueFactory<T> factory = getValueFactory();
        if (factory instanceof SpinnerValueFactory.IntegerSpinnerValueFactory) {
            SpinnerValueFactory.IntegerSpinnerValueFactory intFactory =
                (SpinnerValueFactory.IntegerSpinnerValueFactory) factory;
            intFactory.setAmountToStepBy(step);
        }
        return this;
    }

    public FSpinner<T> wDoubleStep(double step) {
        SpinnerValueFactory<T> factory = getValueFactory();
        if (factory instanceof SpinnerValueFactory.DoubleSpinnerValueFactory) {
            SpinnerValueFactory.DoubleSpinnerValueFactory doubleFactory =
                (SpinnerValueFactory.DoubleSpinnerValueFactory) factory;
            doubleFactory.setAmountToStepBy(step);
        }
        return this;
    }
}