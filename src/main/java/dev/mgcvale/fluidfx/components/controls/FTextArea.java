package dev.mgcvale.fluidfx.components.controls;

import dev.mgcvale.fluidfx.components.core.FluidControl;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Control;
import javafx.scene.control.Skin;
import javafx.scene.control.TextArea;
import javafx.scene.control.skin.TextAreaSkin;

public class FTextArea extends TextArea implements FluidControl<FTextArea> {
    @Override
    public Control getSelf() {
        return this;
    }

    public FTextArea() {
        super();
    }

    public FTextArea wPrompt(String prompt) {
        setPromptText(prompt);
        return this;
    }

    // text properties
    public FTextArea wText(String text) {
        setText(text);
        return this;
    }
    public FTextArea inText(StringBinding stringBinding) {
        textProperty().bind(stringBinding);
        return this;
    }
    public FTextArea inText(StringProperty stringBinding) {
        textProperty().bind(stringBinding);
        return this;
    }
    public FTextArea outText(StringProperty observer) {
        observer.bind(textProperty());
        return this;
    }
    public FTextArea biText(StringProperty property) {
        property.bindBidirectional(textProperty());
        return this;
    }

    public FTextArea wPrefRowCount(int count) {
        setPrefRowCount(count);
        return this;
    }
    public FTextArea inPrefRowCount(IntegerProperty count) {
        prefRowCountProperty().bind(count);
        return this;
    }
    public FTextArea outPrefRowCount(IntegerProperty count) {
        count.bind(prefRowCountProperty());
        return this;
    }
    public FTextArea biPrefRowCount(IntegerProperty count) {
        count.bindBidirectional(prefRowCountProperty());
        return this;
    }

    public FTextArea wMaxRowCount(int count) {
        setPrefRowCount(count);
        return this;
    }
    public FTextArea inMaxRowCount(IntegerProperty count) {
        prefRowCountProperty().bind(count);
        return this;
    }
    public FTextArea outMaxRowCount(IntegerProperty count) {
        count.bind(prefRowCountProperty());
        return this;
    }
    public FTextArea biMaxRowCount(IntegerProperty count) {
        count.bindBidirectional(prefRowCountProperty());
        return this;
    }

    public FTextArea wMinRowCount(int count) {
        setPrefRowCount(count);
        return this;
    }
    public FTextArea inMinRowCount(IntegerProperty count) {
        prefRowCountProperty().bind(count);
        return this;
    }
    public FTextArea outMinRowCount(IntegerProperty count) {
        count.bind(prefRowCountProperty());
        return this;
    }
    public FTextArea biMinRowCount(IntegerProperty count) {
        count.bindBidirectional(prefRowCountProperty());
        return this;
    }


    public FTextArea wWrap(boolean wrap) {
        setWrapText(wrap);
        return this;
    }
    public FTextArea inWrap(BooleanProperty wrap) {
        wrapTextProperty().bind(wrap);
        return this;
    }
    public FTextArea outWrap(BooleanProperty wrap) {
        wrap.bind(wrapTextProperty());
        return this;
    }
    public FTextArea biWrap(BooleanProperty wrap) {
        wrap.bindBidirectional(wrapTextProperty());
        return this;
    }

    public FTextArea wSkin(Skin<TextArea> skin) {
        setSkin(skin);
        return this;
    }

}
