package dev.mgcvale.fluidfx.reactive;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;

public class PropertyConverter {

    public static <T> StringProperty asString(ObjectProperty<T> prop) {
        return bindToString(prop);
    }

    public static StringProperty asString(IntegerProperty prop) {
        return bindToString(prop, (e) -> Integer.toString(prop.get()));
    }

    public static StringProperty asString(DoubleProperty prop) {
        return bindToString(prop, (e) -> Double.toString(prop.get()));
    }

    public static StringProperty asString(FloatProperty prop) {
        return bindToString(prop, (e) -> Float.toString(prop.get()));
    }

    public static StringProperty asString(LongProperty prop) {
        return bindToString(prop, (d) -> Long.toString(prop.get()));
    }

    public static StringProperty asString(BooleanProperty prop) {
        return bindToString(prop, (d) -> Boolean.toString(prop.get()));
    }

    public static StringProperty asString(StringProperty prop) {
        // already a StringProperty; return a bound copy if needed
        StringProperty result = new SimpleStringProperty();
        result.bind(prop);
        return result;
    }

    private static <T> StringProperty bindToString(ObservableValue<T> prop) {
        StringBinding binding = new StringBinding() {
            {
                bind(prop);
            }

            @Override
            protected String computeValue() {
                T value = prop.getValue();
                return value == null ? "" : value.toString();
            }
        };
        StringProperty result = new SimpleStringProperty();
        result.bind(binding);
        return result;
    }

    private static StringProperty bindToString(ObservableValue<?> prop, javafx.util.Callback<Void, String> supplier) {
        StringBinding binding = new StringBinding() {
            {
                bind(prop);
            }

            @Override
            protected String computeValue() {
                return supplier.call(null);
            }
        };
        StringProperty result = new SimpleStringProperty();
        result.bind(binding);
        return result;
    }
}
