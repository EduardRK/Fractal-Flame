package edu.FracalFlame.FractalFlame.Transformations.Factories;

import edu.FracalFlame.FractalFlame.Transformations.Types.Parametric;
import edu.FracalFlame.FractalFlame.Transformations.Types.Transformation;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Bent;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Blob;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Blur;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Bubble;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Cosine;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Cross;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Curl;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Cylinder;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Diamond;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Disc;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Ex;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Exponential;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Eyefish;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Fan;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Fan2;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Fisheye;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Gaussian;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Handkerchief;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Heart;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Horseshoe;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Hyperbolic;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Julia;
import edu.FracalFlame.FractalFlame.Transformations.Variations.JuliaN;
import edu.FracalFlame.FractalFlame.Transformations.Variations.JuliaScope;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Linear;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Ngon;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Noise;
import edu.FracalFlame.FractalFlame.Transformations.Variations.PDJ;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Perspective;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Pie;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Polar;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Popcorn;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Power;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Rectangles;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Rings;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Rings2;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Sinusoidal;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Spherical;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Spiral;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Square;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Swirl;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Tangent;
import edu.FracalFlame.FractalFlame.Transformations.Variations.Waves;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class TransformationFactory {
    public TransformationFactory() {
    }

    @SuppressWarnings("CyclomaticComplexity")
    public Transformation create(@NotNull String typeTransformation, List<Double> parameters) {
        return switch (typeTransformation.toLowerCase()) {
            case "bent" -> new Bent();
            case "blob" -> {
                Parametric parametric = new Blob();
                parametric.setParameters(parameters);
                yield parametric;
            }
            case "blur" -> new Blur();
            case "bubble" -> new Bubble();
            case "cosine" -> new Cosine();
            case "cross" -> new Cross();
            case "curl" -> {
                Parametric parametric = new Curl();
                parametric.setParameters(parameters);
                yield parametric;
            }
            case "cylinder" -> new Cylinder();
            case "diamond" -> new Diamond();
            case "disc" -> new Disc();
            case "ex" -> new Ex();
            case "exponential" -> new Exponential();
            case "eyefish" -> new Eyefish();
            case "fan" -> new Fan();
            case "fan2" -> {
                Parametric parametric = new Fan2();
                parametric.setParameters(parameters);
                yield parametric;
            }
            case "fisheye" -> new Fisheye();
            case "gaussian" -> new Gaussian();
            case "handkerchief" -> new Handkerchief();
            case "heart" -> new Heart();
            case "horseshoe" -> new Horseshoe();
            case "hyperbolic" -> new Hyperbolic();
            case "julia" -> new Julia();
            case "julian" -> {
                Parametric parametric = new JuliaN();
                parametric.setParameters(parameters);
                yield parametric;
            }
            case "juliascope" -> {
                Parametric parametric = new JuliaScope();
                parametric.setParameters(parameters);
                yield parametric;
            }
            case "linear" -> new Linear();
            case "ngon" -> {
                Parametric parametric = new Ngon();
                parametric.setParameters(parameters);
                yield parametric;
            }
            case "noise" -> new Noise();
            case "pdj" -> {
                Parametric parametric = new PDJ();
                parametric.setParameters(parameters);
                yield parametric;
            }
            case "perspective" -> {
                Parametric parametric = new Perspective();
                parametric.setParameters(parameters);
                yield parametric;
            }
            case "pie" -> {
                Parametric parametric = new Pie();
                parametric.setParameters(parameters);
                yield parametric;
            }
            case "polar" -> new Polar();
            case "popcorn" -> new Popcorn();
            case "power" -> new Power();
            case "rectangle" -> {
                Parametric parametric = new Rectangles();
                parametric.setParameters(parameters);
                yield parametric;
            }
            case "rings" -> new Rings();
            case "rings2" -> {
                Parametric parametric = new Rings2();
                parametric.setParameters(parameters);
                yield parametric;
            }
            case "sinusoidal" -> new Sinusoidal();
            case "spherical" -> new Spherical();
            case "spiral" -> new Spiral();
            case "square" -> new Square();
            case "swirl" -> new Swirl();
            case "tangent" -> new Tangent();
            case "waves" -> new Waves();
            default -> throw new IllegalArgumentException("Wrong transformation type");
        };
    }
}
