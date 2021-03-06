package odes.components.functions;


public class PreyFunction implements IFunction {
    @Override
    public double valueOf(double... arg) {
        double x = arg[0];
        return x;
    }

    @Override
    public double derivative(double... arg) {
        double y1 = arg[0];
        double y2= arg[1];
        return (2-.5*y2)*y1;
    }

    @Override
    public double secondDerivative(double... arg) {
        return 0;
    }
}
