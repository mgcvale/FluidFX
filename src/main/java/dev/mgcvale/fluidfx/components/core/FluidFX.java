package dev.mgcvale.fluidfx.components.core;

import dev.mgcvale.fluidfx.components.util.Ref;
import javafx.beans.binding.*;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ObservableValue;
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

/**
 * A fluent API interface for JavaFX {@link Node} components that provides method chaining capabilities
 * for common JavaFX operations such as styling, layout management, property binding,
 * and event handling.
 *
 * <p>This interface uses the fluent builder pattern to allow for readable and concise {@link Node}
 * component configuration. All methods return the implementing instance ({@code T}) to enable
 * method chaining.</p>
 *
 * <p>Example usage:</p>
 * <pre>{@code
 * myComponent
 *     .wStyleClass("my-class")
 *     .wVisible(true)
 *     .onClick(event -> System.out.println("Clicked!"))
 *     .hgrow();
 * }</pre>
 *
 * @param <T> the concrete type implementing this interface, used for method chaining
 * @author mgcvale
 */
public interface FluidFX<T extends FluidFX<T>> {

    /**
     * Returns the underlying JavaFX {@link Node} that this {@code FluidRegion} instance wraps.
     *
     * @return The JavaFX {@link Node} instance.
     */
    Node getSelf();

    // SECTION: CSS

    /**
     * Adds one or more CSS style classes to this component.
     *
     * @param classes the CSS style class names to add
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T wStyleClass(String ...classes) {
        getSelf().getStyleClass().addAll(classes);
        return (T) this;
    }

    /**
     * Appends inline CSS styles to this component.
     *
     * @param style the CSS style string to append
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T wStyle(String style) {
        getSelf().setStyle(getSelf().getStyle().concat(" " + style));
        return (T) this;
    }

    // SECTION: layout
    // V and H box specific methods

    /**
     * Sets the vertical grow priority for this component when inside a VBox.
     *
     * @param p the Priority to set for vertical growth
     * @return this instance for method chaining
     * @see VBox#setVgrow(Node, Priority)
     */
    @SuppressWarnings("unchecked")
    default T wVgrow(Priority p) {
        VBox.setVgrow(getSelf(), p);
        return (T) this;
    }

    /**
     * Sets the horizontal grow priority for this component when inside an HBox.
     *
     * @param p the Priority to set for horizontal growth
     * @return this instance for method chaining
     * @see HBox#setHgrow(Node, Priority)
     */
    @SuppressWarnings("unchecked")
    default T wHgrow(Priority p) {
        HBox.setHgrow(getSelf(), p);
        return (T) this;
    }

    /**
     * Sets the margin for this component when inside a VBox.
     *
     * @param margin the Insets to use as margin
     * @return this instance for method chaining
     * @see VBox#setMargin(Node, Insets)
     */
    @SuppressWarnings("unchecked")
    default T wVboxMargin(Insets margin) {
        VBox.setMargin(getSelf(), margin);
        return (T) this;
    }

    /**
     * Sets the margin for this component when inside an HBox.
     *
     * @param margin the Insets to use as margin
     * @return this instance for method chaining
     * @see HBox#setMargin(Node, Insets)
     */
    @SuppressWarnings("unchecked")
    default T wHboxMargin(Insets margin) {
        HBox.setMargin(getSelf(), margin);
        return (T) this;
    }

    /**
     * Convenience method to set horizontal grow priority to ALWAYS.
     * Equivalent to {@code wHgrow(Priority.ALWAYS)}.
     *
     * @return this instance for method chaining
     */
    default T hgrow() {
        return wHgrow(Priority.ALWAYS);
    }

    /**
     * Convenience method to set vertical grow priority to ALWAYS.
     * Equivalent to {@code wVgrow(Priority.ALWAYS)}.
     *
     * @return this instance for method chaining
     */
    default T vgrow() {
        return wVgrow(Priority.ALWAYS);
    }

    // BorderPane specific methods

    /**
     * Sets the alignment for this component when inside a BorderPane.
     *
     * @param pos the Pos alignment to set
     * @return this instance for method chaining
     * @see BorderPane#setAlignment(Node, Pos)
     */
    @SuppressWarnings("unchecked")
    default T wBorderPaneAlignment(Pos pos) {
        BorderPane.setAlignment(getSelf(), pos);
        return (T) this;
    }

    // SECTION: utility

    /**
     * Stores a reference to this instance in the provided Ref object.
     * Useful for capturing component instances during fluent construction.
     *
     * @param ref the Ref object to store this instance in
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T grabInstance(Ref<T> ref) {
        ref.ref = (T) this;
        return (T) this;
    }

    /**
     * Applies a custom function to this instance, allowing for custom
     * configuration that doesn't break the fluent chain.
     *
     * @param consumer the function to apply to this instance
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T applyCustomFunction(Consumer<T> consumer) {
        consumer.accept((T) this);
        return (T) this;
    }

    // SECTION: layout/translate/rotate properties

    // ws (setters)

    /**
     * Sets the X translation of this component.
     *
     * @param x the X translation value
     * @return this instance for method chaining
     * @see Node#setTranslateX(double)
     */
    @SuppressWarnings("unchecked")
    default T wTranslateX(double x) {
        getSelf().setTranslateX(x);
        return (T) this;
    }

    /**
     * Sets the Y translation of this component.
     *
     * @param y the Y translation value
     * @return this instance for method chaining
     * @see Node#setTranslateY(double)
     */
    @SuppressWarnings("unchecked")
    default T wTranslateY(double y) {
        getSelf().setTranslateY(y);
        return (T) this;
    }

    /**
     * Sets the X layout position of this component.
     *
     * @param x the X layout position
     * @return this instance for method chaining
     * @see Node#setLayoutX(double)
     */
    @SuppressWarnings("unchecked")
    default T wLayoutX(double x) {
        getSelf().setLayoutX(x);
        return (T) this;
    }

    /**
     * Sets the Y layout position of this component.
     *
     * @param y the Y layout position
     * @return this instance for method chaining
     * @see Node#setLayoutY(double)
     */
    @SuppressWarnings("unchecked")
    default T wLayoutY(double y) {
        getSelf().setLayoutY(y);
        return (T) this;
    }

    /**
     * Sets the rotation angle of this component in degrees.
     *
     * @param r the rotation angle in degrees
     * @return this instance for method chaining
     * @see Node#setRotate(double)
     */
    @SuppressWarnings("unchecked")
    default T wRotate(double r) {
        getSelf().setRotate(r);
        return (T) this;
    }

    /**
     * Sets the X scale factor of this component.
     *
     * @param x the X scale factor
     * @return this instance for method chaining
     * @see Node#setScaleX(double)
     */
    @SuppressWarnings("unchecked")
    default T wScaleX(double x) {
        getSelf().setScaleX(x);
        return (T) this;
    }

    /**
     * Sets the Y scale factor of this component.
     *
     * @param y the Y scale factor
     * @return this instance for method chaining
     * @see Node#setScaleY(double)
     */
    @SuppressWarnings("unchecked")
    default T wScaleY(double y) {
        getSelf().setScaleY(y);
        return (T) this;
    }

    // watchers (property observers)

    /**
     * Binds the provided DoubleProperty to this component's translateX property.
     * The observer will be updated whenever translateX changes.
     *
     * @param observer the DoubleProperty to bind to translateX
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T outTranslateXProperty(DoubleProperty observer) {
        observer.bind(getSelf().translateXProperty());
        return (T) this;
    }

    /**
     * Binds the provided DoubleProperty to this component's translateY property.
     * The observer will be updated whenever translateY changes.
     *
     * @param observer the DoubleProperty to bind to translateY
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T outTranslateYProperty(DoubleProperty observer) {
        observer.bind(getSelf().translateYProperty());
        return (T) this;
    }

    /**
     * Binds the provided DoubleProperty to this component's layoutX property.
     * The observer will be updated whenever layoutX changes.
     *
     * @param observer the DoubleProperty to bind to layoutX
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T outLayoutXProperty(DoubleProperty observer) {
        observer.bind(getSelf().layoutXProperty());
        return (T) this;
    }

    /**
     * Binds the provided DoubleProperty to this component's layoutY property.
     * The observer will be updated whenever layoutY changes.
     *
     * @param observer the DoubleProperty to bind to layoutY
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T outLayoutYProperty(DoubleProperty observer) {
        observer.bind(getSelf().layoutYProperty());
        return (T) this;
    }

    /**
     * Binds the provided DoubleProperty to this component's rotate property.
     * The observer will be updated whenever rotate changes.
     *
     * @param observer the DoubleProperty to bind to rotate
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T outRotateProperty(DoubleProperty observer) {
        observer.bind(getSelf().rotateProperty());
        return (T) this;
    }

    /**
     * Binds the provided DoubleProperty to this component's scaleX property.
     * The observer will be updated whenever scaleX changes.
     *
     * @param observer the DoubleProperty to bind to scaleX
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T outScaleXProperty(DoubleProperty observer) {
        observer.bind(getSelf().scaleXProperty());
        return (T) this;
    }

    /**
     * Binds the provided DoubleProperty to this component's scaleY property.
     * The observer will be updated whenever scaleY changes.
     *
     * @param observer the DoubleProperty to bind to scaleY
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T outScaleYProperty(DoubleProperty observer) {
        observer.bind(getSelf().scaleYProperty());
        return (T) this;
    }

    // bindings (property inputs)

    /**
     * Binds this component's translateX property to the provided DoubleExpression.
     * TranslateX will automatically update when the binding changes.
     *
     * @param binding the DoubleExpression to bind translateX to
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T inTranslateX(DoubleExpression binding) {
        getSelf().translateXProperty().bind(binding);
        return (T) this;
    }

    /**
     * Binds this component's translateY property to the provided DoubleExpression.
     * TranslateY will automatically update when the binding changes.
     *
     * @param binding the DoubleExpression to bind translateY to
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T inTranslateY(DoubleExpression binding) {
        getSelf().translateYProperty().bind(binding);
        return (T) this;
    }

    /**
     * Binds this component's layoutX property to the provided DoubleExpression.
     * LayoutX will automatically update when the binding changes.
     *
     * @param binding the DoubleExpression to bind layoutX to
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T inLayoutX(DoubleExpression binding) {
        getSelf().layoutXProperty().bind(binding);
        return (T) this;
    }

    /**
     * Binds this component's layoutY property to the provided DoubleExpression.
     * LayoutY will automatically update when the binding changes.
     *
     * @param binding the DoubleExpression to bind layoutY to
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T inLayoutY(DoubleExpression binding) {
        getSelf().layoutYProperty().bind(binding);
        return (T) this;
    }

    /**
     * Binds this component's rotate property to the provided DoubleExpression.
     * Rotate will automatically update when the binding changes.
     *
     * @param binding the DoubleExpression to bind rotate to
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T inRotate(DoubleExpression binding) {
        getSelf().rotateProperty().bind(binding);
        return (T) this;
    }

    /**
     * Binds this component's scaleX property to the provided DoubleExpression.
     * ScaleX will automatically update when the binding changes.
     *
     * @param binding the DoubleExpression to bind scaleX to
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T inScaleX(DoubleExpression binding) {
        getSelf().scaleXProperty().bind(binding);
        return (T) this;
    }

    /**
     * Binds this component's scaleY property to the provided DoubleExpression.
     * ScaleY will automatically update when the binding changes.
     *
     * @param binding the DoubleExpression to bind scaleY to
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T inScaleY(DoubleExpression binding) {
        getSelf().scaleYProperty().bind(binding);
        return (T) this;
    }

    // SECTION: general component properties: visibility, managed, disabled

    // ws (setters)

    /**
     * Sets the visibility of this component.
     *
     * @param visible true to make the component visible, false to hide it
     * @return this instance for method chaining
     * @see Node#setVisible(boolean)
     */
    @SuppressWarnings("unchecked")
    default T wVisible(boolean visible) {
        getSelf().setVisible(visible);
        return (T) this;
    }

    /**
     * Sets whether this component is managed by its parent layout.
     * Unmanaged components are not included in layout calculations.
     *
     * @param managed true if the component should be managed by its parent
     * @return this instance for method chaining
     * @see Node#setManaged(boolean)
     */
    @SuppressWarnings("unchecked")
    default T wManaged(boolean managed) {
        getSelf().setManaged(managed);
        return (T) this;
    }

    /**
     * Sets the disabled state of this component.
     * Disabled components cannot receive user input.
     *
     * @param disable true to disable the component, false to enable it
     * @return this instance for method chaining
     * @see Node#setDisable(boolean)
     */
    @SuppressWarnings("unchecked")
    default T wDisable(boolean disable) {
        getSelf().setDisable(disable);
        return (T) this;
    }

    // getters (property observers)

    /**
     * Binds the provided BooleanProperty to this component's visible property.
     * The observer will be updated whenever visibility changes.
     *
     * @param observer the BooleanProperty to bind to visible
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T outVisibleProperty(BooleanProperty observer) {
        observer.bind(getSelf().visibleProperty());
        return (T) this;
    }

    /**
     * Binds the provided BooleanProperty to this component's managed property.
     * The observer will be updated whenever managed state changes.
     *
     * @param observer the BooleanProperty to bind to managed
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T outManagedProperty(BooleanProperty observer) {
        observer.bind(getSelf().managedProperty());
        return (T) this;
    }

    /**
     * Binds the provided BooleanProperty to this component's disable property.
     * The observer will be updated whenever disabled state changes.
     *
     * @param observer the BooleanProperty to bind to disable
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T outDisableProperty(BooleanProperty observer) {
        observer.bind(getSelf().disableProperty());
        return (T) this;
    }

    // bindings (property inputs)

    /**
     * Binds this component's visible property to the provided BooleanExpression.
     * Visibility will automatically update when the binding changes.
     *
     * @param binding the BooleanExpression to bind visible to
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T inVisible(BooleanExpression binding) {
        getSelf().visibleProperty().bind(binding);
        return (T) this;
    }

    /**
     * Binds this component's managed property to the provided BooleanExpression.
     * Managed state will automatically update when the binding changes.
     *
     * @param binding the BooleanExpression to bind managed to
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T inManaged(BooleanExpression binding) {
        getSelf().managedProperty().bind(binding);
        return (T) this;
    }

    /**
     * Binds this component's disable property to the provided BooleanExpression.
     * Disabled state will automatically update when the binding changes.
     *
     * @param binding the BooleanExpression to bind disable to
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T inDisable(BooleanExpression binding) {
        getSelf().disableProperty().bind(binding);
        return (T) this;
    }

    // SECTION: general styling

    // setters

    /**
     * Sets the opacity of this component.
     *
     * @param opacity the opacity value (0.0 = transparent, 1.0 = opaque)
     * @return this instance for method chaining
     * @see Node#setOpacity(double)
     */
    @SuppressWarnings("unchecked")
    default T wOpacity(double opacity) {
        getSelf().setOpacity(opacity);
        return (T) this;
    }

    /**
     * Sets the visual effect applied to this component.
     *
     * @param effect the Effect to apply, or null to remove effects
     * @return this instance for method chaining
     * @see Node#setEffect(Effect)
     */
    @SuppressWarnings("unchecked")
    default T wEffect(Effect effect) {
        getSelf().setEffect(effect);
        return (T) this;
    }

    /**
     * Sets the cursor that appears when hovering over this component.
     *
     * @param cursor the Cursor to display on hover
     * @return this instance for method chaining
     * @see Node#setCursor(Cursor)
     */
    @SuppressWarnings("unchecked")
    default T wCursor(Cursor cursor) {
        getSelf().setCursor(cursor);
        return (T) this;
    }

    // getters (property observers)

    /**
     * Binds the provided DoubleProperty to this component's opacity property.
     * The observer will be updated whenever opacity changes.
     *
     * @param observer the DoubleProperty to bind to opacity
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T outOpacityProperty(DoubleProperty observer) {
        observer.bind(getSelf().opacityProperty());
        return (T) this;
    }

    /**
     * Binds the provided ObjectProperty to this component's effect property.
     * The observer will be updated whenever the effect changes.
     *
     * @param observer the ObjectProperty to bind to effect
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T outEffectProperty(ObjectProperty<Effect> observer) {
        observer.bind(getSelf().effectProperty());
        return (T) this;
    }

    /**
     * Binds the provided ObjectProperty to this component's cursor property.
     * The observer will be updated whenever the cursor changes.
     *
     * @param observer the ObjectProperty to bind to cursor
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T getCursorProperty(ObjectProperty<Cursor> observer) {
        observer.bind(getSelf().cursorProperty());
        return (T) this;
    }

    // bindings (property inputs)

    /**
     * Binds this component's opacity property to the provided DoubleExpression.
     * Opacity will automatically update when the binding changes.
     *
     * @param binding the DoubleExpression to bind opacity to
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T inOpacity(DoubleExpression binding) {
        getSelf().opacityProperty().bind(binding);
        return (T) this;
    }

    /**
     * Binds this component's effect property to the provided ObservableValue.
     * Effect will automatically update when the binding changes.
     *
     * @param binding the ObservableValue to bind effect to
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T inEffect(ObservableValue<Effect> binding) {
        getSelf().effectProperty().bind(binding);
        return (T) this;
    }

    /**
     * Binds this component's cursor property to the provided ObservableValue.
     * Cursor will automatically update when the binding changes.
     *
     * @param binding the ObservableValue to bind cursor to
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T inCursor(ObservableValue<Cursor> binding) {
        getSelf().cursorProperty().bind(binding);
        return (T) this;
    }

    // SECTION: focus and event handling

    // focusTraversable

    /**
     * Sets whether this component can be reached via keyboard navigation (Tab key).
     *
     * @param value true if the component should be focus traversable
     * @return this instance for method chaining
     * @see Node#setFocusTraversable(boolean)
     */
    @SuppressWarnings("unchecked")
    default T wFocusTraversable(boolean value) {
        getSelf().setFocusTraversable(value);
        return (T) this;
    }

    /**
     * Binds the provided BooleanProperty to this component's focusTraversable property.
     * The observer will be updated whenever focus traversable state changes.
     *
     * @param observer the BooleanProperty to bind to focusTraversable
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T outFocusTraversable(BooleanProperty observer) {
        observer.bind(getSelf().focusTraversableProperty());
        return (T) this;
    }

    /**
     * Binds this component's focusTraversable property to the provided BooleanExpression.
     * Focus traversable state will automatically update when the binding changes.
     *
     * @param binding the BooleanExpression to bind focusTraversable to
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T inFocusTraversable(BooleanExpression binding) {
        getSelf().focusTraversableProperty().bind(binding);
        return (T) this;
    }

    // events

    /**
     * Sets the event handler for mouse click events on this component.
     *
     * @param handler the EventHandler to handle mouse click events
     * @return this instance for method chaining
     * @see Node#setOnMouseClicked(EventHandler)
     */
    @SuppressWarnings("unchecked")
    default T onClick(EventHandler<? super MouseEvent> handler) {
        getSelf().setOnMouseClicked(handler);
        return (T) this;
    }

    /**
     * Sets the event handler for key pressed events on this component.
     *
     * @param handler the EventHandler to handle key pressed events
     * @return this instance for method chaining
     * @see Node#setOnKeyPressed(EventHandler)
     */
    @SuppressWarnings("unchecked")
    default T onKeyPressed(EventHandler<? super KeyEvent> handler) {
        getSelf().setOnKeyPressed(handler);
        return (T) this;
    }

    /**
     * Adds a generic event handler for the specified event type.
     * This method allows handling any type of JavaFX event.
     *
     * @param <E> the event type
     * @param type the EventType to handle
     * @param handler the EventHandler for the specified event type
     * @return this instance for method chaining
     * @see Node#addEventHandler(EventType, EventHandler)
     */
    @SuppressWarnings("unchecked")
    default <E extends Event> T wEventHandler(EventType<E> type, EventHandler<E> handler) {
        getSelf().addEventHandler(type, handler);
        return (T) this;
    }

    /**
     * Removes a previously added event handler for the specified event type.
     *
     * @param <E> the event type
     * @param type the EventType to remove the handler from
     * @param handler the EventHandler to remove
     * @return this instance for method chaining
     * @see Node#removeEventHandler(EventType, EventHandler)
     */
    @SuppressWarnings("unchecked")
    default <E extends Event> T woutEventHandler(EventType<E> type, EventHandler<? super E> handler) {
        getSelf().removeEventHandler(type, handler);
        return (T) this;
    }

    // stack pane alignment

    /**
     * Sets the alignment for this component when inside a StackPane.
     *
     * @param align the Pos alignment to set
     * @return this instance for method chaining
     * @see StackPane#setAlignment(Node, Pos)
     */
    @SuppressWarnings("unchecked")
    default T wStackAlignment(Pos align) {
        StackPane.setAlignment(getSelf(), align);
        return (T) this;
    }

    /**
     * Binds this component's StackPane alignment to the provided ObservableValue.
     * The alignment will automatically update when the binding changes.
     *
     * @param align the ObservableValue to bind StackPane alignment to
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    default T inStackAlignment(ObservableValue<Pos> align) {
        align.addListener((obs, o, n) -> {
            StackPane.setAlignment(getSelf(), n);
        });
        return (T) this;
    }
}