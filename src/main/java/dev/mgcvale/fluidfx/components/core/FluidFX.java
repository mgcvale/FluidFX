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
    default T withStyleClass(String ...classes) {
        getSelf().getStyleClass().addAll(classes);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T withStyle(String style) {
        getSelf().setStyle(getSelf().getStyle().concat(" " + style));
        return (T) this;
    }

    // SECTION: layout
    // V and H box specific methods
    @SuppressWarnings("unchecked")
    default T withVgrow(Priority p) {
        VBox.setVgrow(getSelf(), p);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T withHgrow(Priority p) {
        HBox.setHgrow(getSelf(), p);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T withVboxMargin(Insets margin) {
        VBox.setMargin(getSelf(), margin);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T withHboxMargin(Insets margin) {
        HBox.setMargin(getSelf(), margin);
        return (T) this;
    }

    default T hGrow() {
        return withHgrow(Priority.ALWAYS);
    }

    default T vGrow() {
        return withVgrow(Priority.ALWAYS);
    }

    // BorderPane specific methods
    @SuppressWarnings("unchecked")
    default T withBorderPaneAlignment(Pos pos) {
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

    // withs
    @SuppressWarnings("unchecked")
    default T withTranslateX(double x) {
        getSelf().setTranslateX(x);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T withTranslateY(double y) {
        getSelf().setTranslateY(y);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T withLayoutX(double x) {
        getSelf().setLayoutX(x);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T withLayoutY(double y) {
        getSelf().setLayoutY(y);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T withRotate(double r) {
        getSelf().setRotate(r);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T withScaleX(double x) {
        getSelf().setScaleX(x);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T withScaleY(double y) {
        getSelf().setScaleY(y);
        return (T) this;
    }


    // watchers
    @SuppressWarnings("unchecked")
    default T watchTranslateXProperty(DoubleProperty observer) {
        observer.bind(getSelf().translateXProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T watchTranslateYProperty(DoubleProperty observer) {
        observer.bind(getSelf().translateYProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T watchLayoutXProperty(DoubleProperty observer) {
        observer.bind(getSelf().layoutXProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T watchLayoutYProperty(DoubleProperty observer) {
        observer.bind(getSelf().layoutYProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T watchRotateProperty(DoubleProperty observer) {
        observer.bind(getSelf().rotateProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T watchScaleXProperty(DoubleProperty observer) {
        observer.bind(getSelf().scaleXProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T watchScaleYProperty(DoubleProperty observer) {
        observer.bind(getSelf().scaleYProperty());
        return (T) this;
    }


    // bindings
    @SuppressWarnings("unchecked")
    default T bindTranslateX(DoubleBinding binding) {
        getSelf().translateXProperty().bind(binding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T bindTranslateY(DoubleBinding binding) {
        getSelf().translateYProperty().bind(binding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T bindLayoutX(DoubleBinding binding) {
        getSelf().layoutXProperty().bind(binding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T bindLayoutY(DoubleBinding binding) {
        getSelf().layoutYProperty().bind(binding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T bindRotate(DoubleBinding binding) {
        getSelf().rotateProperty().bind(binding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T bindScaleX(DoubleBinding binding) {
        getSelf().scaleXProperty().bind(binding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T bindScaleY(DoubleBinding binding) {
        getSelf().scaleYProperty().bind(binding);
        return (T) this;
    }

    // SECTION: general component properties: visibility, managed, disabled

    // withs

    @SuppressWarnings("unchecked")
    default T withVisible(boolean visible) {
        getSelf().setVisible(visible);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T withManaged(boolean managed) {
        getSelf().setManaged(managed);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T withDisable(boolean disable) {
        getSelf().setDisable(disable);
        return (T) this;
    }

    // getters
    @SuppressWarnings("unchecked")
    default T watchVisibleProperty(BooleanProperty observer) {
        observer.bind(getSelf().visibleProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T watchManagedProperty(BooleanProperty observer) {
        observer.bind(getSelf().managedProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T watchDisableProperty(BooleanProperty observer) {
        observer.bind(getSelf().disableProperty());
        return (T) this;
    }

    // bindings
    @SuppressWarnings("unchecked")
    default T bindVisible(BooleanBinding binding) {
        getSelf().visibleProperty().bind(binding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T bindManaged(BooleanBinding binding) {
        getSelf().managedProperty().bind(binding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T bindDisable(BooleanBinding binding) {
        getSelf().disableProperty().bind(binding);
        return (T) this;
    }

    // SECTION: general styling

    // setters
    @SuppressWarnings("unchecked")
    default T withOpacity(double opacity) {
        getSelf().setOpacity(opacity);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T withEffect(Effect effect) {
        getSelf().setEffect(effect);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T withCursor(Cursor cursor) {
        getSelf().setCursor(cursor);
        return (T) this;
    }

    // getters
    @SuppressWarnings("unchecked")
    default T watchOpacityProperty(DoubleProperty observer) {
        observer.bind(getSelf().opacityProperty());
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T watchEffectProperty(ObjectProperty<Effect> observer) {
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
    default T bindOpacity(DoubleBinding binding) {
        getSelf().opacityProperty().bind(binding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T bindEffect(ObjectBinding<Effect> binding) {
        getSelf().effectProperty().bind(binding);
        return (T) this;
    }
    @SuppressWarnings("unchecked")
    default T bindCursor(ObjectBinding<Cursor> binding) {
        getSelf().cursorProperty().bind(binding);
        return (T) this;
    }

    // SECTION: focus and event handling


    // focusTraversable
    @SuppressWarnings("unchecked")
    default T withFocusTraversable(boolean value) {
        getSelf().setFocusTraversable(value);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T watchFocusTraversable(BooleanProperty observer) {
        observer.bind(getSelf().focusTraversableProperty());
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default T bindFocusTraversable(BooleanBinding binding) {
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
    default T withOnKeyPressed(EventHandler<? super KeyEvent> handler) {
        getSelf().setOnKeyPressed(handler);
        return (T) this;
    }


    //  generic onEvent (for any event type)
    @SuppressWarnings("unchecked")
    default <E extends Event> T withEventHandler(EventType<E> type, EventHandler<E> handler) {
        getSelf().addEventHandler(type, handler);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    default <E extends Event> T withoutEventHandler(EventType<E> type, EventHandler<? super E> handler) {
        getSelf().removeEventHandler(type, handler);
        return (T) this;
    }


}