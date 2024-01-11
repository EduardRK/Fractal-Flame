package edu.FracalFlame.FractalFlame.Image.Processors;

import edu.FracalFlame.Constants;
import edu.FracalFlame.FractalFlame.Image.ImageClasses.FractalImage;
import edu.FracalFlame.FractalFlame.Image.ImageClasses.Pixel;

public class GammaCorrection implements ImageProcessor {

    @Override
    public void process(FractalImage fractalImage) {
        double max = 0;
        Pixel[] pixels = fractalImage.data();
        for (Pixel pixel : pixels) {
            if (pixel.count() != 0) {
                pixel.setNormal(Math.log10(pixel.count()));
                max = Math.max(pixel.normal(), max);
            }
        }
        for (Pixel pixel : pixels) {
            pixel.setNormal(pixel.normal() / max);
            pixel.setRed(pixel.red() * Math.pow(pixel.normal(), 1.0 / Constants.GAMMA));
            pixel.setGreen(pixel.green() * Math.pow(pixel.normal(), 1.0 / Constants.GAMMA));
            pixel.setBlue(pixel.blue() * Math.pow(pixel.normal(), 1.0 / Constants.GAMMA));
        }
    }
}
