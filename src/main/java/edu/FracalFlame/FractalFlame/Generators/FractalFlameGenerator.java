package edu.FracalFlame.FractalFlame.Generators;

import edu.FracalFlame.FractalFlame.Image.ImageClasses.FractalImage;
import edu.FracalFlame.FractalFlame.Image.ImageClasses.ImageFormat;
import edu.FracalFlame.FractalFlame.Image.ImageSaver;
import edu.FracalFlame.FractalFlame.Image.Processors.GammaCorrection;
import edu.FracalFlame.FractalFlame.Image.Processors.ImageProcessor;
import edu.FracalFlame.FractalFlame.Renders.MultiThreadRenderer;
import edu.FracalFlame.FractalFlame.Renders.Renderer;
import edu.FracalFlame.FractalFlame.Transformations.Types.Transformation;
import java.nio.file.Path;
import java.util.List;

public final class FractalFlameGenerator {
    private FractalFlameGenerator() {

    }

    public static void generate(List<String> variations, ImageFormat imageFormat, List<Double> parameters, Path path) {
        Generator<Transformation> transformationGenerator = new TransformationGenerator(variations, parameters);
        List<Transformation> variationList = transformationGenerator.generate();

        Renderer renderer = new MultiThreadRenderer();
        FractalImage fractalImage =
            renderer.render(variationList);

        ImageProcessor imageProcessor = new GammaCorrection();
        imageProcessor.process(fractalImage);

        ImageSaver.save(fractalImage, imageFormat, path);
    }
}
