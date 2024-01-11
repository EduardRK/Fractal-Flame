package edu.FracalFlame.FractalFlame.Transformations.Variations;

import edu.FracalFlame.FractalFlame.RecordClasses.Coordinate;
import edu.FracalFlame.FractalFlame.Transformations.Types.Transformation;
import org.jetbrains.annotations.NotNull;

public class Spherical implements Transformation {
    @Override
    public Coordinate apply(@NotNull Coordinate coordinate) {
        double rSquare = Math.pow(coordinate.x(), 2) + Math.pow(coordinate.y(), 2);
        return new Coordinate(coordinate.x() / rSquare, coordinate.y() / rSquare);
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }
}
