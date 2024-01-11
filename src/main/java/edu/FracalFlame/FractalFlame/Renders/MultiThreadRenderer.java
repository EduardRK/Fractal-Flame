package edu.FracalFlame.FractalFlame.Renders;

import edu.FracalFlame.Constants;
import edu.FracalFlame.FractalFlame.Generators.AffineGenerator;
import edu.FracalFlame.FractalFlame.Generators.Generator;
import edu.FracalFlame.FractalFlame.Image.ImageClasses.FractalImage;
import edu.FracalFlame.FractalFlame.Transformations.Types.Transformation;
import edu.FracalFlame.FractalFlame.Transformations.Variations.AffineTransformation;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadRenderer implements Renderer {

    @Override
    public FractalImage render(
        List<Transformation> variations
    ) {
        FractalImage fractalImage = FractalImage.create(Constants.WIDTH, Constants.HEIGHT);
        Generator<AffineTransformation> affineTransformationGenerator = new AffineGenerator();
        List<AffineTransformation> affineTransformationList = affineTransformationGenerator.generate();
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        for (long i = 0; i < Constants.COUNT_SAMPLES; ++i) {
            executorService.submit(
                () -> RenderUtils.renderOneSample(
                    fractalImage,
                    Constants.RECT,
                    affineTransformationList,
                    variations
                ));
        }
        executorService.shutdown();
        executorService.close();
        return fractalImage;
    }
}
