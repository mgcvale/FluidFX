package dev.mgcvale.fluidfx.reactive;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.binding.StringExpression;

public class FluidText {

    public static StringBinding build(Object ... objs) {
        return (StringBinding) Bindings.concat(objs);
    }

}
