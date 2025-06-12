package dev.mgcvale.fluidfx.components.core;

import dev.mgcvale.fluidfx.components.util.Ref;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.effect.Effect;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.util.function.Consumer;


public interface FluidFX<T extends FluidFX<T>> {
    Node getSelf();

    // SECTION: CSS
    @SuppressWarnings("unchecked")
    default T wStyleClass(String ...classes) {
        getSelf().getStyleClass().addAll(classes);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T wStyle(String style) {
        getSelf().setStyle(getSelf().getStyle().concat(" " + style));
        return (T) this;
    }

    // SECTION: layout
    // V and H box specific methods
    @SuppressWarnings("unchecked")
    default T wVgrow(Priority p) {
        VBox.setVgrow(getSelf(), p);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T wHgrow(Priority p) {
        HBox.setHgrow(getSelf(), p);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T wVboxMargin(Insets margin) {
        VBox.setMargin(getSelf(), margin);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T wHboxMargin(Insets margin) {
        HBox.setMargin(getSelf(), margin);
        return (T) this;
    }

    default T hgrow() {
        return wHgrow(Priority.ALWAYS);
    }

    default T vgrow() {
        return wVgrow(Priority.ALWAYS);
    }

    // BorderPane specific methods
    @SuppressWarnings("unchecked")
    default T wBorderPaneAlignment(Pos pos) {
        BorderPane.setAlignment(getSelf(), pos);
        return (T) this;
    }

    // SECTION: utility

    @SuppressWarnings("unchecked")
    default T grabInstance(Ref<T> ref) {
        ref.ref = (T) this;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T applyCustomFunction(Consumer<T> consumer) {
        consumer.accept((T) this);
        return (T) this;
    }


    // SECTION: layout/translate/rotate properties

    // ws
    @SuppressWarnings("unchecked")
    default T wTranslateX(double x) {
        getSelf().setTranslateX(x);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T wTranslateY(double y) {
        getSelf().setTranslateY(y);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T wLayoutX(double x) {
        getSelf().setLayoutX(x);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T wLayoutY(double y) {
        getSelf().setLayoutY(y);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T wRotate(double r) {
        getSelf().setRotate(r);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T wScaleX(double x) {
        getSelf().setScaleX(x);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T wScaleY(double y) {
        getSelf().setScaleY(y);
        return (T) this;
    }


    // watchers
    @SuppressWarnings("unchecked")
    default T outTranslateXProperty(DoubleProperty observer) {
        observer.bind(getSelf().translateXProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T outTranslateYProperty(DoubleProperty observer) {
        observer.bind(getSelf().translateYProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T outLayoutXProperty(DoubleProperty observer) {
        observer.bind(getSelf().layoutXProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T outLayoutYProperty(DoubleProperty observer) {
        observer.bind(getSelf().layoutYProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T outRotateProperty(DoubleProperty observer) {
        observer.bind(getSelf().rotateProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T outScaleXProperty(DoubleProperty observer) {
        observer.bind(getSelf().scaleXProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T outScaleYProperty(DoubleProperty observer) {
        observer.bind(getSelf().scaleYProperty());
        return (T) this;
    }


    // bindings
    @SuppressWarnings("unchecked")
    default T inTranslateX(DoubleBinding binding) {
        getSelf().translateXProperty().bind(binding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T inTranslateY(DoubleBinding binding) {
        getSelf().translateYProperty().bind(binding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T inLayoutX(DoubleBinding binding) {
        getSelf().layoutXProperty().bind(binding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T inLayoutY(DoubleBinding binding) {
        getSelf().layoutYProperty().bind(binding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T inRotate(DoubleBinding binding) {
        getSelf().rotateProperty().bind(binding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T inScaleX(DoubleBinding binding) {
        getSelf().scaleXProperty().bind(binding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T inScaleY(DoubleBinding binding) {
        getSelf().scaleYProperty().bind(binding);
        return (T) this;
    }

    // SECTION: general component properties: visibility, managed, disabled

    // ws

    @SuppressWarnings("unchecked")
    default T wVisible(boolean visible) {
        getSelf().setVisible(visible);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T wManaged(boolean managed) {
        getSelf().setManaged(managed);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T wDisable(boolean disable) {
        getSelf().setDisable(disable);
        return (T) this;
    }

    // getters
    @SuppressWarnings("unchecked")
    default T outVisibleProperty(BooleanProperty observer) {
        observer.bind(getSelf().visibleProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T outManagedProperty(BooleanProperty observer) {
        observer.bind(getSelf().managedProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T outDisableProperty(BooleanProperty observer) {
        observer.bind(getSelf().disableProperty());
        return (T) this;
    }

    // bindings
    @SuppressWarnings("unchecked")
    default T inVisible(BooleanBinding binding) {
        getSelf().visibleProperty().bind(binding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T inManaged(BooleanBinding binding) {
        getSelf().managedProperty().bind(binding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T inDisable(BooleanBinding binding) {
        getSelf().disableProperty().bind(binding);
        return (T) this;
    }

    // SECTION: general styling

    // setters
    @SuppressWarnings("unchecked")
    default T wOpacity(double opacity) {
        getSelf().setOpacity(opacity);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T wEffect(Effect effect) {
        getSelf().setEffect(effect);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T wCursor(Cursor cursor) {
        getSelf().setCursor(cursor);
        return (T) this;
    }

    // getters
    @SuppressWarnings("unchecked")
    default T outOpacityProperty(DoubleProperty observer) {
        observer.bind(getSelf().opacityProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T outEffectProperty(ObjectProperty<Effect> observer) {
        observer.bind(getSelf().effectProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T getCursorProperty(ObjectProperty<Cursor> observer) {
        observer.bind(getSelf().cursorProperty());
        return (T) this;
    }

    // bindings
    @SuppressWarnings("unchecked")
    default T inOpacity(DoubleBinding binding) {
        getSelf().opacityProperty().bind(binding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T inEffect(ObjectBinding<Effect> binding) {
        getSelf().effectProperty().bind(binding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T inCursor(ObjectBinding<Cursor> binding) {
        getSelf().cursorProperty().bind(binding);
        return (T) this;
    }

    // SECTION: focus and event handling


    // focusTraversable
    @SuppressWarnings("unchecked")
    default T wFocusTraversable(boolean value) {
        getSelf().setFocusTraversable(value);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T outFocusTraversable(BooleanProperty observer) {
        observer.bind(getSelf().focusTraversableProperty());
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T inFocusTraversable(BooleanBinding binding) {
        getSelf().focusTraversableProperty().bind(binding);
        return (T) this;
    }

    // events

    @SuppressWarnings("unchecked")
    default T onClick(EventHandler<? super MouseEvent> handler) {
        getSelf().setOnMouseClicked(handler);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T onKeyPressed(EventHandler<? super KeyEvent> handler) {
        getSelf().setOnKeyPressed(handler);
        return (T) this;
    }


    //  generic onEvent (for any event type)
    @SuppressWarnings("unchecked")
    default <E extends Event> T wEventHandler(EventType<E> type, EventHandler<E> handler) {
        getSelf().addEventHandler(type, handler);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default <E extends Event> T woutEventHandler(EventType<E> type, EventHandler<? super E> handler) {
        getSelf().removeEventHandler(type, handler);
        return (T) this;
    }


}