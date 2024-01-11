package edu.FracalFlame.FractalFlame.Transformations.Variations;

import edu.FracalFlame.FractalFlame.RecordClasses.Coordinate;
import edu.FracalFlame.FractalFlame.Transformations.Types.Transformation;
import org.jetbrains.annotations.NotNull;

public class Waves implements Transformation {
    private AffineTransformation affineTransformation;

    @Override
    public Coordinate apply(@NotNull Coordinate coordinate) {
        return new Coordinate(
            coordinate.x()
                + affineTransformation.b() * Math.sin(coordinate.y() / Math.pow(affineTransformation.c(), 2)),
            coordinate.y()
                + affineTransformation.e() * Math.sin(coordinate.x() / Math.pow(affineTransformation.f(), 2))
        );
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {
        this.affineTransformation = affineTransformation;
    }
}
