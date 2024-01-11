package edu.FracalFlame.FractalFlame.Transformations.Variations;

import edu.FracalFlame.FractalFlame.RecordClasses.Coordinate;
import edu.FracalFlame.FractalFlame.Transformations.Types.Transformation;
import java.util.concurrent.ThreadLocalRandom;
import org.jetbrains.annotations.NotNull;

public class Noise implements Transformation {
    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }

    @Override
    public Coordinate apply(@NotNull Coordinate coordinate) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        double psi1 = threadLocalRandom.nextDouble(-1, 1);
        double psi2 = threadLocalRandom.nextDouble(-1, 1);
        return new Coordinate(
            psi1 * coordinate.x() * Math.cos(2 * Math.PI * psi2),
            psi1 * coordinate.y() * Math.sin(2 * Math.PI * psi2)
        );
    }
}
