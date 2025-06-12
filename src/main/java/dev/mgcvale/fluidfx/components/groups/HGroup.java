package dev.mgcvale.fluidfx.components.groups;

import dev.mgcvale.fluidfx.components.core.*;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class HGroup extends HBox implements FluidGroup<HGroup>, FluidBox {
    protected BoxSpacing spacingType = BoxSpacing.NONE;

    @Override
    public Pane getSelf() {
        return this;
    }

    public HGroup() {
        super();
    }

    @Override
    public HGroup withChildren(Node... children) {
        getChildren().addAll(
                BoxUtils.buildChildren(this, children)
        );
        return this;
    }

    public HGroup withSpacing(double spacing) {
        setSpacing(spacing);
        return this;
    }

    public HGroup spaceAround() {
        this.spacingType = BoxSpacing.SPACE_AROUND;
        return this;
    }
    public HGroup spaceBetween() {
        this.spacingType = BoxSpacing.SPACE_BETWEEN;
        return this;
    }
    public HGroup justifyCenter() {
        this.spacingType = BoxSpacing.CENTER;
        return this;
    }
    public HGroup justifyStart() {
        this.spacingType = BoxSpacing.LAYOUT_START;
        return this;
    }
    public HGroup justifyEnd() {
        this.spacingType = BoxSpacing.LAYOUT_END;
        return this;
    }

    @Override
    public BoxSpacing getSpacingType() {
        return spacingType;
    }

    @Override
    public BoxType getBoxType() {
        return BoxType.HORIZONTAL;
    }
}
