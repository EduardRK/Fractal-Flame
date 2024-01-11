package edu.FracalFlame;

import edu.FracalFlame.FractalFlame.Generators.FractalFlameGenerator;

public final class FractalFlameMain {
    private FractalFlameMain() {

    }

    public static void main(String[] args) {
        ArgsParser argsParser = ArgsParser.create(args);
        FractalFlameGenerator.generate(
            argsParser.variationsType(),
            argsParser.imageFormat(),
            argsParser.parameters(),
            argsParser.path()
        );
    }
}
