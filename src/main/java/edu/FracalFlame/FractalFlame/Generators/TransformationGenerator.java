package edu.FracalFlame.FractalFlame.Generators;

import edu.FracalFlame.FractalFlame.Transformations.Factories.TransformationFactory;
import edu.FracalFlame.FractalFlame.Transformations.Types.Transformation;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

public final class TransformationGenerator implements Generator<Transformation> {
    private final List<String> typesTransformations;
    private final List<Double> parameters;

    public TransformationGenerator(List<String> typesTransformations, List<Double> parameters) {
        this.typesTransformations = typesTransformations;
        this.parameters = parameters;
    }

    @Override
    public @NotNull List<Transformation> generate() {
        List<Transformation> transformationList = new ArrayList<>();
        TransformationFactory transformationFactory = new TransformationFactory();
        for (String type : typesTransformations) {
            transformationList.add(transformationFactory.create(type, parameters));
        }
        return transformationList;
    }
}
