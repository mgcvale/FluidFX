package dev.mgcvale.fluidfx.components.core;

import dev.mgcvale.fluidfx.components.layout.Spacers;
import javafx.collections.ObservableList;
import javafx.scene.Node;

import java.util.LinkedList;
import java.util.List;

public class BoxUtils {

    public static List<Node> buildChildren(FluidBox box, List<Node> children) {
        final BoxType type = box.getBoxType();
        final BoxSpacing s = box.getSpacingType();
        List<Node> result = new LinkedList<>();

        // initial spacer, for space around, end and center. The spacer has Priority.ALWAYS
        if (s == BoxSpacing.SPACE_AROUND || s == BoxSpacing.LAYOUT_END || s == BoxSpacing.CENTER) result.add(Spacers.fromType(type));

        // add children, adding spacing with Priority.ALWAYS between them if using space around or space between
        for (int i = 0; i < children.size(); i++) {
            result.add(children.get(i));

            // we never add spacers after the last child, and we only do between them for space between and space around.
            if (i != children.size() - 1 && (s == BoxSpacing.SPACE_AROUND || s == BoxSpacing.SPACE_BETWEEN)) result.add(Spacers.fromType(type));
        }

        // initial spacer, for space around, start and center. The spacer has Priority.ALWAYS
        if (s == BoxSpacing.SPACE_AROUND || s == BoxSpacing.LAYOUT_START || s == BoxSpacing.CENTER) result.add(Spacers.fromType(type));

        return result;
    }

}
