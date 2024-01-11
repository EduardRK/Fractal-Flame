package edu.FracalFlame.FractalFlame.Transformations.Variations;

import edu.FracalFlame.FractalFlame.RecordClasses.Coordinate;
import edu.FracalFlame.FractalFlame.Transformations.Types.Transformation;
import org.jetbrains.annotations.NotNull;

public class Cross implements Transformation {
    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }

    @Override
    public Coordinate apply(@NotNull Coordinate coordinate) {
        double multiplier = Math.sqrt(1 / Math.pow(Math.pow(coordinate.x(), 2) - Math.pow(coordinate.y(), 2), 2));
        return new Coordinate(
            multiplier * coordinate.x(),
            multiplier * coordinate.y()
        );
    }
}
