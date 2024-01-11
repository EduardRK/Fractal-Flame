package edu.FracalFlame.FractalFlame.Transformations.Variations;

import edu.FracalFlame.FractalFlame.RecordClasses.Coordinate;
import edu.FracalFlame.FractalFlame.Transformations.Types.Transformation;
import org.jetbrains.annotations.NotNull;

public class Sinusoidal implements Transformation {
    @Override
    public Coordinate apply(@NotNull Coordinate coordinate) {
        return new Coordinate(Math.sin(coordinate.x()), Math.sin(coordinate.y()));
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }
}
