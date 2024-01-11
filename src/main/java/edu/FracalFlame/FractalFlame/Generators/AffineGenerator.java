package edu.FracalFlame.FractalFlame.Generators;

import edu.FracalFlame.Constants;
import edu.FracalFlame.FractalFlame.Transformations.Factories.AffineTransformationFactory;
import edu.FracalFlame.FractalFlame.Transformations.Variations.AffineTransformation;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class AffineGenerator implements Generator<AffineTransformation> {
    public AffineGenerator() {
    }

    public @NotNull List<AffineTransformation> generate() {
        List<AffineTransformation> affineTransformationList = new ArrayList<>();
        AffineTransformationFactory affineTransformationFactory = new AffineTransformationFactory();
        for (int i = 0; i < Constants.COUNT_AFFINE_TRANSFORMATIONS; ++i) {
            affineTransformationList.add(affineTransformationFactory.create());
        }
        return affineTransformationList;
    }
}
