package edu.FracalFlame.FractalFlame.Transformations.Variations;

import edu.FracalFlame.FractalFlame.RecordClasses.Coordinate;
import edu.FracalFlame.FractalFlame.Transformations.Types.Transformation;
import org.jetbrains.annotations.NotNull;

public class Cosine implements Transformation {
    @Override
    public Coordinate apply(@NotNull Coordinate coordinate) {
        double piX = Math.PI * coordinate.x();
        return new Coordinate(
            Math.cos(piX) * Math.cosh(coordinate.y()),
            -Math.sin(piX) * Math.sinh(coordinate.y())
        );
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }
}
