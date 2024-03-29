package edu.FracalFlame.FractalFlame.Renders;

import edu.FracalFlame.Constants;
import edu.FracalFlame.FractalFlame.Image.ImageClasses.FractalImage;
import edu.FracalFlame.FractalFlame.Image.ImageClasses.Pixel;
import edu.FracalFlame.FractalFlame.RecordClasses.Coordinate;
import edu.FracalFlame.FractalFlame.RecordClasses.Rect;
import edu.FracalFlame.FractalFlame.Transformations.Types.Transformation;
import edu.FracalFlame.FractalFlame.Transformations.Variations.AffineTransformation;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class RenderUtils {

    private RenderUtils() {
    }

    public static void renderOneSample(
        FractalImage fractalImage,
        Rect rect,
        List<AffineTransformation> affineTransformationList,
        List<Transformation> variations
    ) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        Coordinate coordinate = getRandomCoordinate(rect, threadLocalRandom);

        for (int i = -Constants.ITERATIONS_FOR_CENTER; i < Constants.COUNT_ONE_SAMPLE; ++i) {
            AffineTransformation affineTransformation =
                getRandomAffineTransformation(affineTransformationList, threadLocalRandom);
            Transformation transformation = getRandomVariation(variations, threadLocalRandom);
            coordinate = affineTransformation.apply(coordinate);
            transformation.setAffine(affineTransformation);
            coordinate = transformation.apply(coordinate);

            if (i > 0) {
                double angle = 0.0;
                Coordinate rotateCoordinate;
                for (int s = 0; s < Constants.SYMMETRY; angle += 2 * Math.PI / Constants.SYMMETRY, ++s) {
                    rotateCoordinate = coordinate.rotate(angle);
                    if (rect.contains(rotateCoordinate)) {
                        Coordinate newCoordinate = getNewCoordinate(rotateCoordinate, rect);
                        if (newCoordinate.x() < Constants.WIDTH && newCoordinate.y() < Constants.HEIGHT) {
                            Pixel pixel = fractalImage.pixel(newCoordinate);
                            synchronized (pixel) {
                                pixel.setColor(affineTransformation);
                                pixel.hit();
                            }
                        }
                    }
                }

            }
        }
    }

    private static AffineTransformation getRandomAffineTransformation(
        @NotNull List<AffineTransformation> affineTransformationList,
        @NotNull ThreadLocalRandom threadLocalRandom
    ) {
        return affineTransformationList.get(threadLocalRandom.nextInt(affineTransformationList.size()));
    }

    private static Transformation getRandomVariation(
        @NotNull List<Transformation> variations,
        @NotNull ThreadLocalRandom threadLocalRandom
    ) {
        return variations.get(threadLocalRandom.nextInt(variations.size()));
    }

    @Contract("_, _ -> new")
    private static @NotNull Coordinate getRandomCoordinate(
        @NotNull Rect rect,
        @NotNull ThreadLocalRandom threadLocalRandom
    ) {
        return new Coordinate(
            rect.x() + threadLocalRandom.nextDouble(0, 1) * rect.width(),
            rect.y() + threadLocalRandom.nextDouble(0, 1) * rect.height()
        );
    }

    @Contract("_, _ -> new")
    private static @NotNull Coordinate getNewCoordinate(
        @NotNull Coordinate coordinate,
        @NotNull Rect rect
    ) {
        return new Coordinate(
            Constants.WIDTH
                - (int) (((rect.getMaxX() - coordinate.x()) / (rect.getMaxX() - rect.x())) * Constants.WIDTH),
            Constants.HEIGHT
                - (int) (((rect.getMaxY() - coordinate.y()) / (rect.getMaxY() - rect.y())) * Constants.HEIGHT)
        );
    }
}
