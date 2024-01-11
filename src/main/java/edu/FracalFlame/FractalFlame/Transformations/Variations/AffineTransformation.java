package edu.FracalFlame.FractalFlame.Transformations.Variations;

import edu.FracalFlame.FractalFlame.RecordClasses.Coordinate;
import edu.FracalFlame.FractalFlame.Transformations.Types.Transformation;
import java.awt.Color;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public record AffineTransformation(double a, double b, double c, double d, double e, double f, Color color)
    implements Transformation {
    @Contract("_ -> new")
    @Override
    public @NotNull Coordinate apply(@NotNull Coordinate coordinate) {
        return new Coordinate(
            a * coordinate.x() + b * coordinate.y() + c,
            d * coordinate.x() + e * coordinate.y() + f
        );
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }
}
