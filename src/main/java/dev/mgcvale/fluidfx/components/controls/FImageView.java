package dev.mgcvale.fluidfx.components.controls;

import dev.mgcvale.fluidfx.components.core.FluidFX;
import javafx.beans.binding.DoubleExpression;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class FImageView extends ImageView implements FluidFX<FImageView> {
    @Override
    public Node getSelf() {
        return this;
    }

    public FImageView() {
        super();
    }

    public FImageView wFitHeight(double h) {
        setFitHeight(h);
        return this;
    }
    public FImageView inFitHeight(DoubleExpression h) {
        fitHeightProperty().bind(h);
        return this;
    }
    public FImageView outFitHeight(DoubleProperty h) {
        h.bind(fitHeightProperty());
        return this;
    }
    public FImageView biFitHeight(DoubleProperty h) {
        h.bindBidirectional(fitHeightProperty());
        return this;
    }

    public FImageView wFitWidth(double w) {
        setFitWidth(w);
        return this;
    }
    public FImageView inFitWidth(DoubleExpression w) {
        fitWidthProperty().bind(w);
        return this;
    }
    public FImageView outFitWidth(DoubleProperty w) {
        w.bind(fitWidthProperty());
        return this;
    }
    public FImageView biFitWidth(DoubleProperty w) {
        w.bindBidirectional(fitWidthProperty());
        return this;
    }

    public FImageView wPreserveRatio(boolean p) {
        setPreserveRatio(p);
        return this;
    }

    public FImageView wImage(Image img) {
        setImage(img);
        return this;
    }
    public FImageView inImage(ObservableValue<Image> img) {
        imageProperty().bind(img);
        return this;
    }

    public FImageView wFallback(Image img) {
        imageProperty().addListener((obsi, oldImg, newImg) -> {
            initializeFallback(newImg, img);
        });
        if (getImage() != null) {
            initializeFallback(getImage(), img);
        }
        return this;
    }
    private void initializeFallback(Image img, Image fallback) {
        if (img == fallback) return; // only fallback if it wasn't the fallback which threw the error
        img.errorProperty().addListener((obs, o, n) -> {
            if (img.isError()) {
                setImage(fallback);
            }
        });

        // we also check if it already has an error
        if (img.isError() && getImage() != fallback) {
            setImage(fallback);
        }
    }

    public FImageView clipCircle() {
        Circle clip = new Circle();
        clip.radiusProperty().bind(fitHeightProperty().multiply(0.5));
        clip.centerXProperty().bind(fitHeightProperty().multiply(0.5));
        clip.centerYProperty().bind(fitHeightProperty().multiply(0.5));
        setClip(clip);
        return this;
    }
}
