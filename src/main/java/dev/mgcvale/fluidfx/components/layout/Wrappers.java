package dev.mgcvale.fluidfx.components.layout;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class Wrappers {
    public static <T extends Node> T wHgrow(T c, Priority p) {
        HBox.setHgrow(c, p);
        return c;
    }
    public static <T extends Node> T wHgrow(T c) {
        return wHgrow(c, Priority.ALWAYS);
    }

    public static <T extends Node> T wVgrow(T c, Priority p) {
        VBox.setVgrow(c, p);
        return c;
    }
    public static <T extends Node> T wVgrow(T c) {
        return wVgrow(c, Priority.ALWAYS);
    }


    public static <T extends Node> T wStyle(T c, String style) {
        c.setStyle(c.getStyle().concat(style));
        return c;
    }

    public static Label wAlignment(Label l, TextAlignment pos) {
        l.setTextAlignment(pos);
        return l;
    }

    public static <T extends Node> T wStyleClass(T n, String ...classes) {
        n.getStyleClass().addAll(classes);
        return n;
    }

    public static <T extends Labeled> T wTextAlignment(T n, TextAlignment alignment) {
        n.setTextAlignment(alignment);
        return n;
    }
}
