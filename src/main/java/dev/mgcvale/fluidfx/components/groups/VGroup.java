package dev.mgcvale.fluidfx.components.groups;

import dev.mgcvale.fluidfx.components.core.*;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class VGroup extends VBox implements FluidGroup<VGroup>, FluidBox {
    private BoxSpacing spacingType;

    @Override
    public VGroup getSelf() {
        return this;
    }

    public VGroup() {
        super();
    }

    @Override
    public VGroup withChildren(Node... children) {
        getChildren().addAll(
                BoxUtils.buildChildren(this, children)
        );
        return this;
    }

    public VGroup spaceAround() {
        this.spacingType = BoxSpacing.SPACE_AROUND;
        return this;
    }
    public VGroup spaceBetween() {
        this.spacingType = BoxSpacing.SPACE_BETWEEN;
        return this;
    }
    public VGroup justifyCenter() {
        this.spacingType = BoxSpacing.CENTER;
        return this;
    }
    public VGroup justifyStart() {
        this.spacingType = BoxSpacing.LAYOUT_START;
        return this;
    }
    public VGroup justifyEnd() {
        this.spacingType = BoxSpacing.LAYOUT_END;
        return this;
    }


    public VGroup withSpacing(double spacing) {
        setSpacing(spacing);
        return this;
    }

    @Override
    public BoxSpacing getSpacingType() {
        return spacingType;
    }

    @Override
    public BoxType getBoxType() {
        return BoxType.VERTICAL;
    }
}
