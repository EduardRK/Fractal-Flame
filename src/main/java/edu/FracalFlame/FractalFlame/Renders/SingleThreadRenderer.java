package edu.FracalFlame.FractalFlame.Renders;

import edu.FracalFlame.Constants;
import edu.FracalFlame.FractalFlame.Generators.AffineGenerator;
import edu.FracalFlame.FractalFlame.Generators.Generator;
import edu.FracalFlame.FractalFlame.Image.ImageClasses.FractalImage;
import edu.FracalFlame.FractalFlame.Transformations.Types.Transformation;
import edu.FracalFlame.FractalFlame.Transformations.Variations.AffineTransformation;
import java.util.List;

public class SingleThreadRenderer implements Renderer {
    @Override
    public FractalImage render(
        List<Transformation> variations
    ) {
        FractalImage fractalImage = FractalImage.create(Constants.WIDTH, Constants.HEIGHT);
        Generator<AffineTransformation> affineTransformationGenerator = new AffineGenerator();
        List<AffineTransformation> affineTransformationList = affineTransformationGenerator.generate();
        for (long i = 0; i < Constants.COUNT_SAMPLES; ++i) {
            RenderUtils.renderOneSample(
                fractalImage,
                Constants.RECT,
                affineTransformationList,
                variations
            );
        }
        return fractalImage;
    }
}
