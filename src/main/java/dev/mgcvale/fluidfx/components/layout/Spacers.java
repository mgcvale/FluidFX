package dev.mgcvale.fluidfx.components.layout;

import dev.mgcvale.fluidfx.components.core.BoxType;
import javafx.beans.binding.DoubleBinding;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class Spacers {

    public static Region hSpacer() {
        return hSpacer(Priority.ALWAYS);
    }

    public static Region hSpacer(Priority p) {
        Region spacer = new Region();
        HBox.setHgrow(spacer, p);
        return spacer;
    }

    public static Region hSpacer(DoubleBinding sizeProperty) {
        Region spacer = new Region();
        spacer.maxHeightProperty().bind(sizeProperty);
        HBox.setHgrow(spacer, Priority.ALWAYS);
        return spacer;
    }

    public static Region vSpacer(DoubleBinding sizeProperty) {
        Region spacer = new Region();
        spacer.maxHeightProperty().bind(sizeProperty);
        VBox.setVgrow(spacer, Priority.ALWAYS);
        return spacer;
    }

    public static Region hSpacer(double size)  {
        Region spacer = new Region();
        HBox.setMargin(spacer, new Insets(0, size, 0, 0));
        return spacer;
    }

    public static Region vSpacer(double size)  {
        Region spacer = new Region();
        VBox.setMargin(spacer, new Insets(size, 0, 0, 0));
        return spacer;
    }


    public static Region vSpacer() {
        return vSpacer(Priority.ALWAYS);
    }

    public static Region vSpacer(Priority p) {
        Region spacer = new Region();
        VBox.setVgrow(spacer, p);
        return spacer;
    }

    public static Region fromType(BoxType type, Priority p) {
        return switch (type) {
            case HORIZONTAL -> hSpacer(p);
            case VERTICAL -> vSpacer(p);
        };
    }

    public static Region fromType(BoxType type) {
        return fromType(type, Priority.ALWAYS);
    }

}
