package edu.FracalFlame.FractalFlame.Transformations.Variations;

import edu.FracalFlame.FractalFlame.RecordClasses.Coordinate;
import edu.FracalFlame.FractalFlame.Transformations.Types.Transformation;
import org.jetbrains.annotations.NotNull;

public class Polar implements Transformation {
    @Override
    public Coordinate apply(@NotNull Coordinate coordinate) {
        double theta = Math.atan(coordinate.x() / coordinate.y());
        double r = Math.sqrt(Math.pow(coordinate.x(), 2) + Math.pow(coordinate.y(), 2));
        return new Coordinate(theta / Math.PI, r - 1);
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }
}
