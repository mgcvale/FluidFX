package dev.mgcvale.fluidfx.components.core;

import javafx.beans.binding.DoubleExpression;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.layout.Region;

/**
 * A fluent API interface for JavaFX {@link Region} components, extending {@link FluidFX}.
 * It provides method chaining capabilities for common layout and property management
 * operations specific to regions, such as setting minimum, preferred, and maximum
 * dimensions, as well as managing padding.
 *
 * <p>This interface utilizes the fluent builder pattern to enable readable and concise
 * configuration of {@link Region} instances. All configuration methods return the
 * implementing instance ({@code T}) to facilitate method chaining.</p>
 *
 * <p>Example usage:</p>
 * <pre>{@code
 * MyRegion myRegion = new MyRegion();
 * myRegion
 * .wMinWidth(100)
 * .wPrefHeight(200)
 * .inMaxWidth(Double.MAX_VALUE)
 * .wPadding(new Insets(10))
 * .wStyleClass("custom-region");
 * }</pre>
 *
 * @param <T> The concrete type implementing this interface, used for method chaining.
 * @author mgcvale
 */
public interface FluidRegion<T extends FluidRegion<T>> extends FluidFX<T> {

    /**
     * Returns the underlying JavaFX {@link Region} that this {@code FluidRegion} instance wraps.
     * This method is inherited from {@link FluidFX} and is specifically typed here for clarity.
     *
     * @return The JavaFX {@link Region} instance.
     */
    @Override
    Region getSelf();

    // SECTION: Observer Properties

    /**
     * Observes the {@code widthProperty} of the underlying {@link Region}.
     * The value of the provided observer {@link DoubleProperty} will be bound to the region's width.
     *
     * @param observer The {@link DoubleProperty} to observe the region's width.
     * @return This instance for method chaining.
     */
    @SuppressWarnings("unchecked")
    default T outWidthProperty(DoubleProperty observer) {
        observer.bind(getSelf().widthProperty());
        return (T) this;
    }

    /**
     * Observes the {@code heightProperty} of the underlying {@link Region}.
     * The value of the provided observer {@link DoubleProperty} will be bound to the region's height.
     *
     * @param observer The {@link DoubleProperty} to observe the region's height.
     * @return This instance for method chaining.
     */
    @SuppressWarnings("unchecked")
    default T outHeightProperty(DoubleProperty observer) {
        observer.bind(getSelf().heightProperty());
        return (T) this;
    }

    /**
     * Observes the {@code minWidthProperty} of the underlying {@link Region}.
     * The value of the provided observer {@link DoubleProperty} will be bound to the region's minimum width.
     *
     * @param observer The {@link DoubleProperty} to observe the region's minimum width.
     * @return This instance for method chaining.
     */
    @SuppressWarnings("unchecked")
    default T outMinWidthProperty(DoubleProperty observer) {
        observer.bind(getSelf().minWidthProperty());
        return (T) this;
    }

    /**
     * Observes the {@code minHeightProperty} of the underlying {@link Region}.
     * The value of the provided observer {@link DoubleProperty} will be bound to the region's minimum height.
     *
     * @param observer The {@link DoubleProperty} to observe the region's minimum height.
     * @return This instance for method chaining.
     */
    @SuppressWarnings("unchecked")
    default T outMinHeightProperty(DoubleProperty observer) {
        observer.bind(getSelf().minHeightProperty());
        return (T) this;
    }

    /**
     * Observes the {@code prefWidthProperty} of the underlying {@link Region}.
     * The value of the provided observer {@link DoubleProperty} will be bound to the region's preferred width.
     *
     * @param observer The {@link DoubleProperty} to observe the region's preferred width.
     * @return This instance for method chaining.
     */
    @SuppressWarnings("unchecked")
    default T outPrefWidthProperty(DoubleProperty observer) {
        observer.bind(getSelf().prefWidthProperty());
        return (T) this;
    }

    /**
     * Observes the {@code prefHeightProperty} of the underlying {@link Region}.
     * The value of the provided observer {@link DoubleProperty} will be bound to the region's preferred height.
     *
     * @param observer The {@link DoubleProperty} to observe the region's preferred height.
     * @return This instance for method chaining.
     */
    @SuppressWarnings("unchecked")
    default T outPrefHeightProperty(DoubleProperty observer) {
        observer.bind(getSelf().prefHeightProperty());
        return (T) this;
    }

    /**
     * Observes the {@code maxWidthProperty} of the underlying {@link Region}.
     * The value of the provided observer {@link DoubleProperty} will be bound to the region's maximum width.
     *
     * @param observer The {@link DoubleProperty} to observe the region's maximum width.
     * @return This instance for method chaining.
     */
    @SuppressWarnings("unchecked")
    default T outMaxWidthProperty(DoubleProperty observer) {
        observer.bind(getSelf().maxWidthProperty());
        return (T) this;
    }

    /**
     * Observes the {@code maxHeightProperty} of the underlying {@link Region}.
     * The value of the provided observer {@link DoubleProperty} will be bound to the region's maximum height.
     *
     * @param observer The {@link DoubleProperty} to observe the region's maximum height.
     * @return This instance for method chaining.
     */
    @SuppressWarnings("unchecked")
    default T outMaxHeightProperty(DoubleProperty observer) {
        observer.bind(getSelf().maxHeightProperty());
        return (T) this;
    }

    // SECTION: Input Bindings

    /**
     * Binds the {@code minWidthProperty} of the underlying {@link Region} to the provided {@link DoubleExpression}.
     *
     * @param binding The {@link DoubleExpression} to bind the region's minimum width to.
     * @return This instance for method chaining.
     */
    @SuppressWarnings("unchecked")
    default T inMinWidth(DoubleExpression binding) {
        getSelf().minWidthProperty().bind(binding);
        return (T) this;
    }

    /**
     * Binds the {@code minHeightProperty} of the underlying {@link Region} to the provided {@link DoubleExpression}.
     *
     * @param binding The {@link DoubleExpression} to bind the region's minimum height to.
     * @return This instance for method chaining.
     */
    @SuppressWarnings("unchecked")
    default T inMinHeight(DoubleExpression binding) {
        getSelf().minHeightProperty().bind(binding);
        return (T) this;
    }

    /**
     * Binds the {@code prefWidthProperty} of the underlying {@link Region} to the provided {@link DoubleExpression}.
     *
     * @param binding The {@link DoubleExpression} to bind the region's preferred width to.
     * @return This instance for method chaining.
     */
    @SuppressWarnings("unchecked")
    default T inPrefWidth(DoubleExpression binding) {
        getSelf().prefWidthProperty().bind(binding);
        return (T) this;
    }

    /**
     * Binds the {@code prefHeightProperty} of the underlying {@link Region} to the provided {@link DoubleExpression}.
     *
     * @param binding The {@link DoubleExpression} to bind the region's preferred height to.
     * @return This instance for method chaining.
     */
    @SuppressWarnings("unchecked")
    default T inPrefHeight(DoubleExpression binding) {
        getSelf().prefHeightProperty().bind(binding);
        return (T) this;
    }

    /**
     * Binds the {@code maxWidthProperty} of the underlying {@link Region} to the provided {@link DoubleExpression}.
     *
     * @param binding The {@link DoubleExpression} to bind the region's maximum width to.
     * @return This instance for method chaining.
     */
    @SuppressWarnings("unchecked")
    default T inMaxWidth(DoubleExpression binding) {
        getSelf().maxWidthProperty().bind(binding);
        return (T) this;
    }

    /**
     * Binds the {@code maxHeightProperty} of the underlying {@link Region} to the provided {@link DoubleExpression}.
     *
     * @param binding The {@link DoubleExpression} to bind the region's maximum height to.
     * @return This instance for method chaining.
     */
    @SuppressWarnings("unchecked")
    default T inMaxHeight(DoubleExpression binding) {
        getSelf().maxHeightProperty().bind(binding);
        return (T) this;
    }

    // SECTION: Setters for Dimensions

    /**
     * Sets the minimum width of the underlying {@link Region}.
     *
     * @param minWidth The minimum width value.
     * @return This instance for method chaining.
     */
    @SuppressWarnings("unchecked")
    default T wMinWidth(double minWidth) {
        getSelf().setMinWidth(minWidth);
        return (T) this;
    }

    /**
     * Sets the minimum height of the underlying {@link Region}.
     *
     * @param minHeight The minimum height value.
     * @return This instance for method chaining.
     */
    @SuppressWarnings("unchecked")
    default T wMinHeight(double minHeight) {
        getSelf().setMinHeight(minHeight);
        return (T) this;
    }

    /**
     * Sets the preferred width of the underlying {@link Region}.
     *
     * @param prefWidth The preferred width value.
     * @return This instance for method chaining.
     */
    @SuppressWarnings("unchecked")
    default T wPrefWidth(double prefWidth) {
        getSelf().setPrefWidth(prefWidth);
        return (T) this;
    }

    /**
     * Sets the preferred height of the underlying {@link Region}.
     *
     * @param prefHeight The preferred height value.
     * @return This instance for method chaining.
     */
    @SuppressWarnings("unchecked")
    default T wPrefHeight(double prefHeight) {
        getSelf().setPrefHeight(prefHeight);
        return (T) this;
    }

    /**
     * Sets the maximum width of the underlying {@link Region}.
     *
     * @param maxWidth The maximum width value.
     * @return This instance for method chaining.
     */
    @SuppressWarnings("unchecked")
    default T wMaxWidth(double maxWidth) {
        getSelf().setMaxWidth(maxWidth);
        return (T) this;
    }

    /**
     * Sets the maximum height of the underlying {@link Region}.
     *
     * @param maxHeight The maximum height value.
     * @return This instance for method chaining.
     */
    @SuppressWarnings("unchecked")
    default T wMaxHeight(double maxHeight) {
        getSelf().setMaxHeight(maxHeight);
        return (T) this;
    }

    // SECTION: Padding Management

    /**
     * Sets the padding of the underlying {@link Region}.
     *
     * @param padding The {@link Insets} object defining the padding.
     * @return This instance for method chaining.
     */
    @SuppressWarnings("unchecked")
    default T wPadding(Insets padding) {
        getSelf().setPadding(padding);
        return (T) this;
    }

    /**
     * Binds the {@code paddingProperty} of the underlying {@link Region} to the provided {@link ObservableValue}.
     *
     * @param paddingBinding The {@link ObservableValue} of {@link Insets} to bind the region's padding to.
     * @return This instance for method chaining.
     */
    @SuppressWarnings("unchecked")
    default T inPadding(ObservableValue<Insets> paddingBinding) {
        getSelf().paddingProperty().bind(paddingBinding);
        return (T) this;
    }

    /**
     * Observes the {@code paddingProperty} of the underlying {@link Region}.
     * The value of the provided observer {@link ObjectProperty} will be bound to the region's padding.
     *
     * @param observer The {@link ObjectProperty} to observe the region's padding.
     * @return This instance for method chaining.
     */
    @SuppressWarnings("unchecked")
    default T outPadding(ObjectProperty<Insets> observer) {
        observer.bind(getSelf().paddingProperty());
        return (T) this;
    }
}