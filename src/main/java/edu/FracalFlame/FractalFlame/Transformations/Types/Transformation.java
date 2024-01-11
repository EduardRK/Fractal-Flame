package edu.FracalFlame.FractalFlame.Transformations.Types;

import edu.FracalFlame.FractalFlame.RecordClasses.Coordinate;
import edu.FracalFlame.FractalFlame.Transformations.Variations.AffineTransformation;
import java.util.function.Function;

public interface Transformation extends Function<Coordinate, Coordinate> {
    void setAffine(AffineTransformation affineTransformation);
}
