package dev.mgcvale.fluidfx.components.layout;

import javafx.beans.binding.DoubleExpression;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;

public class Pad extends Insets {

    public Pad(double v, double v1, double v2, double v3) {
        super(v, v1, v2, v3);
    }

    public Pad(double v) {
        super(v);
    }

    public Pad() {
        super(0);
    }

    public static Pad all(double v) {
        return new Pad(v);
    }
    public static Pad zero() {
        return new Pad(0);
    }

    public static Pad top(double v) {
        return new Pad(v, 0, 0, 0);
    }
    public static Pad bottom(double v) {
        return new Pad(0, 0, v, 0);
    }
    public static Pad left(double v) {
        return new Pad(0, 0, 0, v);
    }
    public static Pad right(double v) {
        return new Pad(0, v, 0, 0);
    }

    public static Pad x(double v) {
        return new Pad(0, v, 0, v);
    }
    public static Pad y(double v) {
        return new Pad(v, 0, v, 0);
    }

    public static Pad tl(double v) {
        return new Pad(v, 0, 0, v);
    }
    public static Pad tr(double v) {
        return new Pad(v, v, 0, 0);
    }
    public static Pad br(double v) {
        return new Pad(0, v, v, 0);
    }
    public static Pad bl(double v) {
        return new Pad(0, 0, v, v);
    }

    // fluent methods
    public Pad addX(double dx) {
        return new Pad(getTop(), getRight() + dx, getBottom(), getLeft() + dx);
    }
    public Pad addY(double dy) {
        return new Pad(getTop() + dy, getRight(), getBottom() + dy, getLeft());
    }

    public Pad addTop(double dt) {
        return new Pad(getTop() + dt, getRight(), getBottom(), getLeft());
    }
    public Pad addBottom(double db) {
        return new Pad(getTop(), getRight(), getBottom() + db, getLeft());
    }
    public Pad addLeft(double dl) {
        return new Pad(getTop(), getRight(), getBottom(), getLeft() + dl);
    }
    public Pad addRight(double dr) {
        return new Pad(getTop(), getRight() + dr, getBottom(), getLeft());
    }


    // reactive builders


    public static ObjectProperty<Insets> bottom(DoubleExpression v) {
        ObjectProperty<Insets> padProp = new SimpleObjectProperty<>(new Insets(0, 0, v.doubleValue(), 0));
        v.addListener((obs, o, n) -> {
            padProp.set(new Insets(0, 0, n.doubleValue(), 0));
        });
        return padProp;
    }
    public static ObjectProperty<Insets> top(DoubleExpression v) {
        ObjectProperty<Insets> padProp = new SimpleObjectProperty<>(new Insets(v.doubleValue(), 0, 0, 0));
        v.addListener((obs, o, n) -> {
            padProp.set(new Insets(n.doubleValue(), 0, 0, 0));
        });
        return padProp;
    }
    public static ObjectProperty<Insets> left(DoubleExpression v) {
        ObjectProperty<Insets> padProp = new SimpleObjectProperty<>(new Insets(0, 0, 0, v.doubleValue()));
        v.addListener((obs, o, n) -> {
            padProp.set(new Insets(0, 0, 0, n.doubleValue()));
        });
        return padProp;
    }
    public static ObjectProperty<Insets> right(DoubleExpression v) {
        ObjectProperty<Insets> padProp = new SimpleObjectProperty<>(new Insets(0, v.doubleValue(), 0, 0));
        v.addListener((obs, o, n) -> {
            padProp.set(new Insets(0, n.doubleValue(), 0, 0));
        });
        return padProp;
    }
    public static ObjectProperty<Insets> x(DoubleExpression v) {
        ObjectProperty<Insets> padProp = new SimpleObjectProperty<>(new Insets(0, v.doubleValue(), 0, v.doubleValue()));
        v.addListener((obs, o, n) -> {
            padProp.set(new Insets(0, n.doubleValue(), 0, n.doubleValue()));
        });
        return padProp;
    }

    public static ObjectProperty<Insets> y(DoubleExpression v) {
        ObjectProperty<Insets> padProp = new SimpleObjectProperty<>(new Insets(v.doubleValue(), 0, v.doubleValue(), 0));
        v.addListener((obs, o, n) -> {
            padProp.set(new Insets(n.doubleValue(), 0, n.doubleValue(), 0));
        });
        return padProp;
    }
    public static ObjectProperty<Insets> all(DoubleExpression v) {
        ObjectProperty<Insets> padProp = new SimpleObjectProperty<>(new Insets(v.doubleValue()));
        v.addListener((obs, o, n) -> {
            padProp.set(new Insets(n.doubleValue()));
        });
        return padProp;
    }
}
