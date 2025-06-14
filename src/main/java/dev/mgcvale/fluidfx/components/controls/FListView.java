package dev.mgcvale.fluidfx.components.controls;

import dev.mgcvale.fluidfx.components.core.FluidControl;
import javafx.beans.binding.BooleanExpression;
import javafx.beans.binding.ObjectExpression;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.util.List;

public class FListView<T> extends ListView<T> implements FluidControl<FListView<T>> {
    @Override
    public Control getSelf() {
        return this;
    }

    public FListView() {
        super();
    }

    public FListView(ObservableList<T> items) {
        super(items);
    }

    public FListView<T> wItems(ObservableList<T> items) {
        setItems(items);
        return this;
    }

    public FListView<T> wSelectionMode(SelectionMode mode) {
        getSelectionModel().setSelectionMode(mode);
        return this;
    }
    public FListView<T> inSelectionMode(ObservableValue<SelectionMode> mode) {
        getSelectionModel().selectionModeProperty().bind(mode);
        return this;
    }
    public FListView<T> outSelectionMode(ObjectProperty<SelectionMode> mode) {
        mode.bind(getSelectionModel().selectionModeProperty());
        return this;
    }
    public FListView<T> biSelectionMode(ObjectProperty<SelectionMode> mode) {
        mode.bindBidirectional(getSelectionModel().selectionModeProperty());
        return this;
    }

    public FListView<T> wCellFactory(Callback<ListView<T>, ListCell<T>> factory) {
        setCellFactory(factory);
        return this;
    }

    public FListView<T> wEditable(boolean editable) {
        setEditable(editable);
        return this;
    }
    public FListView<T> inEditable(BooleanExpression editable) {
        editableProperty().bind(editable);
        return this;
    }
    public FListView<T> outEditable(BooleanProperty editable) {
        editable.bind(editableProperty());
        return this;
    }
    public FListView<T> biEditable(BooleanProperty editable) {
        editable.bindBidirectional(editableProperty());
        return this;
    }

    public FListView<T> wSelect(T t) {
        getSelectionModel().select(t);
        return this;
    }
    public FListView<T> wSelect(int i) {
        getSelectionModel().select(i);
        return this;
    }

    public FListView<T> wSelectionModel(MultipleSelectionModel<T> model) {
        setSelectionModel(model);
        return this;
    }
    public FListView<T> inSelectionModel(ObservableValue<? extends MultipleSelectionModel<T>> model) {
        selectionModelProperty().bind(model);
        return this;
    }
    public FListView<T> outSelectionModel(ObjectProperty<MultipleSelectionModel<T>> model) {
        model.bind(selectionModelProperty());
        return this;
    }
    public FListView<T> biSelectionModel(ObjectProperty<MultipleSelectionModel<T>> model) {
        model.bindBidirectional(selectionModelProperty());
        return this;
    }

    public FListView<T> outSelectedItem(ObjectProperty<T> selectedItem) {
        selectedItem.bind(getSelectionModel().selectedItemProperty());
        return this;
    }
    public FListView<T> outSelectedIndex(IntegerProperty selectedIndex) {
        selectedIndex.bind(getSelectionModel().selectedIndexProperty());
        return this;
    }

    public FListView<T> wPlaceholder(Node node) {
        setPlaceholder(node);
        return this;
    }
    public FListView<T> inPlaceholder(ObservableValue<Node> node) {
        placeholderProperty().bind(node);
        return this;
    }
    public FListView<T> outPlaceholder(ObjectProperty<Node> node) {
        node.bind(placeholderProperty());
        return this;
    }
    public FListView<T> biPlaceholder(ObjectProperty<Node> node) {
        node.bindBidirectional(placeholderProperty());
        return this;
    }

}
