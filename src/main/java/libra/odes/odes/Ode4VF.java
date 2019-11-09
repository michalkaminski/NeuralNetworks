package libra.odes.odes;

import javafx.util.Pair;
import libra.functions.IFunction;
import libra.initialcondition.InitialConditions;
import libra.odes.visual.EulerVisualizationVF2D;

public class Ode4VF {
    public static void main(String[] args) {
        double SCALE = 3;
        double STEP = 0.01d;
        double START = 0d;
        Pair<Double, Double>[] initialConditions = InitialConditions.getInitialConditions(
                -3, 3, 5000);

        EulerVisualizationVF2D vis = new EulerVisualizationVF2D(
                new XFunction(),
                new YFunction(),
                initialConditions,
                SCALE,
                STEP,
                START
        );
        vis.visualize();
    }

    private static class XFunction implements IFunction {
        @Override
        public double valueOf(double... arg) {
            double x = arg[0];
            double y = arg[1];
            return x;
         }

        @Override
        public double derivative(double... arg) {
            double x = arg[0];
            double y = arg[1];
            return (x + 1) / (Math.pow(x + 1, 2) + Math.pow(y, 2)) + (x - 1) / (Math.pow(x - 1, 2) + Math.pow(y, 2));
        }
    }

    private static class YFunction implements IFunction {
        @Override
        public double valueOf(double... arg) {
            double x = arg[0];
            return x;
        }

        @Override
        public double derivative(double... arg) {
            double x = arg[0];
            double y = arg[1];
            return y / (Math.pow(x + 1, 2) + Math.pow(y, 2)) + y / (Math.pow(x - 1, 2) + Math.pow(y, 2));
        }
    }
}

