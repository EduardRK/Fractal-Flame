package edu.FracalFlame.FractalFlame.Renders;

import edu.FracalFlame.FractalFlame.Image.ImageClasses.FractalImage;
import edu.FracalFlame.FractalFlame.Transformations.Types.Transformation;
import java.util.List;

public interface Renderer {
    FractalImage render(
        List<Transformation> variations
    );
}
