package edu.FracalFlame.FractalFlame.Transformations.Variations;

import edu.FracalFlame.FractalFlame.RecordClasses.Coordinate;
import edu.FracalFlame.FractalFlame.Transformations.Types.Parametric;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("MagicNumber")
public class Perspective implements Parametric {
    private double angle = Math.PI / 6;
    private double dist = 5;
    private double angleCos = 0.86602540378;
    private double angleSin = 0.5;

    @Override
    public void setParameters(@NotNull List<Double> parameters) {
        Iterator<Double> iterator = parameters.iterator();
        if (iterator.hasNext()) {
            angle = iterator.next();
            angleCos = Math.cos(angle);
            angleSin = Math.sin(angle);
        }
        if (iterator.hasNext()) {
            dist = iterator.next();
        }
    }

    @Override
    public void setAffine(AffineTransformation affineTransformation) {

    }

    @Override
    public Coordinate apply(@NotNull Coordinate coordinate) {
        double p2 = dist;
        double multiplier = p2 / (p2 - coordinate.y() * angleSin);
        return new Coordinate(
            multiplier * coordinate.x(),
            multiplier * coordinate.y() * angleCos
        );
    }
}
