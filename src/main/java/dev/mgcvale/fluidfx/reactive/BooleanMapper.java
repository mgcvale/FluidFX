package dev.mgcvale.fluidfx.reactive;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.*;

public class BooleanMapper {

    public static StringProperty mapAsString(
            BooleanProperty source,
            String trueValue,
            String falseValue
    ) {
        StringBinding binding = new StringBinding() {
            {
                bind(source);
            }
            @Override
            protected String computeValue() {
                return source.get() ? trueValue : falseValue;
            }
        };

        StringProperty result = new SimpleStringProperty();
        result.bind(binding);
        return result;
    }

    public static <T> ObjectProperty<T> map(
            BooleanProperty source,
            T trueValue,
            T falseValue
    ) {
        ObjectBinding<T> binding = new ObjectBinding<>() {
            {
                bind(source);
            }

            @Override
            protected T computeValue() {
                return source.get() ? trueValue : falseValue;
            }
        };

        ObjectProperty<T> result = new SimpleObjectProperty<>();
        result.bind(binding);
        return result;
    }
}
