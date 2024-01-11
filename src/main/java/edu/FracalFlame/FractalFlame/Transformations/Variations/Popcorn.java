package edu.FracalFlame.FractalFlame.Transformations.Variations;

import edu.FracalFlame.FractalFlame.RecordClasses.Coordinate;
import edu.FracalFlame.FractalFlame.Transformations.Types.Transformation;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("MagicNumber")
public class Popcorn implements Transformation {
    private AffineTransformation affineTransformation;

    @Override
    public Coordinate apply(@NotNull Coordinate coordinate) {
        return new Coordinate(
            coordinate.x() + affineTransformation.c() * Math.sin(Math.tan(3 * coordinate.y())),
            coordinate.y() + affineTransformation.f() * Math.sin(Math.tan(3 * coordinate.x()))
        );
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {
        this.affineTransformation = affineTransformation;
    }
}
