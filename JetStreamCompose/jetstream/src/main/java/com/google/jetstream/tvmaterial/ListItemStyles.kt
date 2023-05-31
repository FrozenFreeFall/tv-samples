import androidx.annotation.FloatRange
import androidx.compose.foundation.Indication
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.tv.material3.Border
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Glow

/**
 * Defines [Shape] for all TV [Indication] states of a ListItem.
 */
@ExperimentalTvMaterial3Api
@Immutable
class ListItemShape internal constructor(
    internal val shape: Shape,
    internal val focusedShape: Shape,
    internal val pressedShape: Shape,
    internal val selectedShape: Shape,
    internal val disabledShape: Shape,
    internal val focusedSelectedShape: Shape,
    internal val focusedDisabledShape: Shape,
    internal val pressedSelectedShape: Shape
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as ListItemShape

        if (shape != other.shape) return false
        if (focusedShape != other.focusedShape) return false
        if (pressedShape != other.pressedShape) return false
        if (selectedShape != other.selectedShape) return false
        if (disabledShape != other.disabledShape) return false
        if (focusedSelectedShape != other.focusedSelectedShape) return false
        if (focusedDisabledShape != other.focusedDisabledShape) return false
        if (pressedSelectedShape != other.pressedSelectedShape) return false

        return true
    }

    override fun hashCode(): Int {
        var result = shape.hashCode()
        result = 31 * result + focusedShape.hashCode()
        result = 31 * result + pressedShape.hashCode()
        result = 31 * result + selectedShape.hashCode()
        result = 31 * result + disabledShape.hashCode()
        result = 31 * result + focusedSelectedShape.hashCode()
        result = 31 * result + focusedDisabledShape.hashCode()
        result = 31 * result + pressedSelectedShape.hashCode()

        return result
    }

    override fun toString(): String {
        return "ListItemShape(shape=$shape, " +
                "focusedShape=$focusedShape," +
                "pressedShape=$pressedShape, " +
                "selectedShape=$selectedShape, " +
                "disabledShape=$disabledShape, " +
                "focusedSelectedShape=$focusedSelectedShape, " +
                "focusedDisabledShape=$focusedDisabledShape, " +
                "pressedSelectedShape=$pressedSelectedShape)"
    }
}

/**
 * Defines container & content color [Color] for all TV [Indication] states of a ListItem.
 */
@ExperimentalTvMaterial3Api
@Immutable
class ListItemColors internal constructor(
    internal val containerColor: Color,
    internal val contentColor: Color,
    internal val focusedContainerColor: Color,
    internal val focusedContentColor: Color,
    internal val pressedContainerColor: Color,
    internal val pressedContentColor: Color,
    internal val selectedContainerColor: Color,
    internal val selectedContentColor: Color,
    internal val disabledContainerColor: Color,
    internal val disabledContentColor: Color,
    internal val focusedSelectedContainerColor: Color,
    internal val focusedSelectedContentColor: Color,
    internal val pressedSelectedContainerColor: Color,
    internal val pressedSelectedContentColor: Color
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as ListItemColors

        if (containerColor != other.containerColor) return false
        if (contentColor != other.contentColor) return false
        if (focusedContainerColor != other.focusedContainerColor) return false
        if (focusedContentColor != other.focusedContentColor) return false
        if (pressedContainerColor != other.pressedContainerColor) return false
        if (pressedContentColor != other.pressedContentColor) return false
        if (selectedContainerColor != other.selectedContainerColor) return false
        if (selectedContentColor != other.selectedContentColor) return false
        if (disabledContainerColor != other.disabledContainerColor) return false
        if (disabledContentColor != other.disabledContentColor) return false
        if (focusedSelectedContainerColor != other.focusedSelectedContainerColor) return false
        if (focusedSelectedContentColor != other.focusedSelectedContentColor) return false
        if (pressedSelectedContainerColor != other.pressedSelectedContainerColor) return false
        if (pressedSelectedContentColor != other.pressedSelectedContentColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = containerColor.hashCode()
        result = 31 * result + contentColor.hashCode()
        result = 31 * result + focusedContainerColor.hashCode()
        result = 31 * result + focusedContentColor.hashCode()
        result = 31 * result + pressedContainerColor.hashCode()
        result = 31 * result + pressedContentColor.hashCode()
        result = 31 * result + selectedContainerColor.hashCode()
        result = 31 * result + selectedContentColor.hashCode()
        result = 31 * result + disabledContainerColor.hashCode()
        result = 31 * result + disabledContentColor.hashCode()
        result = 31 * result + focusedSelectedContainerColor.hashCode()
        result = 31 * result + focusedSelectedContentColor.hashCode()
        result = 31 * result + pressedSelectedContainerColor.hashCode()
        result = 31 * result + pressedSelectedContentColor.hashCode()
        return result
    }

    override fun toString(): String {
        return "ListItemColors(containerColor=$containerColor, " +
                "contentColor=$contentColor, " +
                "focusedContainerColor=$focusedContainerColor, " +
                "focusedContentColor=$focusedContentColor, " +
                "pressedContainerColor=$pressedContainerColor, " +
                "pressedContentColor=$pressedContentColor, " +
                "selectedContainerColor=$selectedContainerColor, " +
                "selectedContentColor=$selectedContentColor, " +
                "disabledContainerColor=$disabledContainerColor, " +
                "disabledContentColor=$disabledContentColor, " +
                "focusedSelectedContainerColor=$focusedSelectedContainerColor, " +
                "focusedSelectedContentColor=$focusedSelectedContentColor, " +
                "pressedSelectedContainerColor=$pressedSelectedContainerColor, " +
                "pressedSelectedContentColor=$pressedSelectedContentColor)"
    }
}

/**
 * Defines the scale for all TV [Indication] states of a ListItem.
 * Note: This scale must always be a non-negative float.
 */
@ExperimentalTvMaterial3Api
@Immutable
class ListItemScale internal constructor(
    @FloatRange(from = 0.0) internal val scale: Float,
    @FloatRange(from = 0.0) internal val focusedScale: Float,
    @FloatRange(from = 0.0) internal val pressedScale: Float,
    @FloatRange(from = 0.0) internal val selectedScale: Float,
    @FloatRange(from = 0.0) internal val disabledScale: Float,
    @FloatRange(from = 0.0) internal val focusedSelectedScale: Float,
    @FloatRange(from = 0.0) internal val focusedDisabledScale: Float,
    @FloatRange(from = 0.0) internal val pressedSelectedScale: Float
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as ListItemScale

        if (scale != other.scale) return false
        if (focusedScale != other.focusedScale) return false
        if (pressedScale != other.pressedScale) return false
        if (selectedScale != other.selectedScale) return false
        if (disabledScale != other.disabledScale) return false
        if (focusedSelectedScale != other.focusedSelectedScale) return false
        if (focusedDisabledScale != other.focusedDisabledScale) return false
        if (pressedSelectedScale != other.pressedSelectedScale) return false

        return true
    }

    override fun hashCode(): Int {
        var result = scale.hashCode()
        result = 31 * result + focusedScale.hashCode()
        result = 31 * result + pressedScale.hashCode()
        result = 31 * result + selectedScale.hashCode()
        result = 31 * result + disabledScale.hashCode()
        result = 31 * result + focusedSelectedScale.hashCode()
        result = 31 * result + focusedDisabledScale.hashCode()
        result = 31 * result + pressedSelectedScale.hashCode()

        return result
    }

    override fun toString(): String {
        return "ListItemScale(scale=$scale, " +
                "focusedScale=$focusedScale, " +
                "pressedScale=$pressedScale, " +
                "selectedScale=$selectedScale, " +
                "disabledScale=$disabledScale, " +
                "focusedSelectedScale=$focusedSelectedScale, " +
                "focusedDisabledScale=$focusedDisabledScale, " +
                "pressedSelectedScale=$pressedSelectedScale)"
    }

    companion object {
        /**
         * Signifies the absence of a [ScaleIndication] in ListItem component.
         */
        val None = ListItemScale(
            scale = 1f,
            focusedScale = 1f,
            pressedScale = 1f,
            selectedScale = 1f,
            disabledScale = 1f,
            focusedSelectedScale = 1f,
            focusedDisabledScale = 1f,
            pressedSelectedScale = 1f
        )
    }
}

/**
 * Defines [Border] for all TV [Indication] states of a ListItem.
 */
@ExperimentalTvMaterial3Api
@Immutable
class ListItemBorder internal constructor(
    internal val border: Border,
    internal val focusedBorder: Border,
    internal val pressedBorder: Border,
    internal val selectedBorder: Border,
    internal val disabledBorder: Border,
    internal val focusedSelectedBorder: Border,
    internal val focusedDisabledBorder: Border,
    internal val pressedSelectedBorder: Border
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as ListItemBorder

        if (border != other.border) return false
        if (focusedBorder != other.focusedBorder) return false
        if (pressedBorder != other.pressedBorder) return false
        if (selectedBorder != other.selectedBorder) return false
        if (disabledBorder != other.disabledBorder) return false
        if (focusedSelectedBorder != other.focusedSelectedBorder) return false
        if (focusedDisabledBorder != other.focusedDisabledBorder) return false
        if (pressedSelectedBorder != other.pressedSelectedBorder) return false

        return true
    }

    override fun hashCode(): Int {
        var result = border.hashCode()
        result = 31 * result + focusedBorder.hashCode()
        result = 31 * result + pressedBorder.hashCode()
        result = 31 * result + selectedBorder.hashCode()
        result = 31 * result + disabledBorder.hashCode()
        result = 31 * result + focusedSelectedBorder.hashCode()
        result = 31 * result + focusedDisabledBorder.hashCode()
        result = 31 * result + pressedSelectedBorder.hashCode()

        return result
    }

    override fun toString(): String {
        return "ListItemBorder(border=$border, " +
                "focusedBorder=$focusedBorder, " +
                "pressedBorder=$pressedBorder, " +
                "selectedBorder=$selectedBorder, " +
                "disabledBorder=$disabledBorder, " +
                "focusedSelectedBorder=$focusedSelectedBorder, " +
                "focusedDisabledBorder=$focusedDisabledBorder, " +
                "pressedSelectedBorder=$pressedSelectedBorder)"
    }
}

/**
 * Defines [Glow] for all TV [Indication] states of a ListItem.
 */
@ExperimentalTvMaterial3Api
@Immutable
class ListItemGlow internal constructor(
    internal val glow: Glow,
    internal val focusedGlow: Glow,
    internal val pressedGlow: Glow,
    internal val selectedGlow: Glow,
    internal val focusedSelectedGlow: Glow,
    internal val pressedSelectedGlow: Glow
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as ListItemGlow

        if (glow != other.glow) return false
        if (focusedGlow != other.focusedGlow) return false
        if (pressedGlow != other.pressedGlow) return false
        if (selectedGlow != other.selectedGlow) return false
        if (focusedSelectedGlow != other.focusedSelectedGlow) return false
        if (pressedSelectedGlow != other.pressedSelectedGlow) return false

        return true
    }

    override fun hashCode(): Int {
        var result = glow.hashCode()
        result = 31 * result + focusedGlow.hashCode()
        result = 31 * result + pressedGlow.hashCode()
        result = 31 * result + selectedGlow.hashCode()
        result = 31 * result + focusedSelectedGlow.hashCode()
        result = 31 * result + pressedSelectedGlow.hashCode()

        return result
    }

    override fun toString(): String {
        return "ListItemGlow(glow=$glow, " +
                "focusedGlow=$focusedGlow, " +
                "pressedGlow=$pressedGlow, " +
                "selectedGlow=$selectedGlow, " +
                "focusedSelectedGlow=$focusedSelectedGlow, " +
                "pressedSelectedGlow=$pressedSelectedGlow)"
    }
}