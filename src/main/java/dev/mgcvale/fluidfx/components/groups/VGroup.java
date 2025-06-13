package dev.mgcvale.fluidfx.components.groups;

import dev.mgcvale.fluidfx.components.core.*;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.util.List;

public class VGroup extends VBox implements FluidGroup<VGroup>, FluidBox {
    private BoxSpacing spacingType;

    @Override
    public VGroup getSelf() {
        return this;
    }

    public VGroup() {
        super();
    }

    public VGroup wAlignment(Pos alignment) {
        setAlignment(alignment);
        return this;
    }

    @Override
    public VGroup wChildren(Node... children) {
        return wChildren(List.of(children));
    }

    @Override
    public VGroup wChildren(List<Node> children) {
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


    public VGroup wSpacing(double spacing) {
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
