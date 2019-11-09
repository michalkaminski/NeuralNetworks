package libra.odes.visual;

import javafx.util.Pair;
import libra.functions.IFunction;
import lombok.extern.slf4j.Slf4j;
import n.draw.StdDraw;


@Slf4j
public class EulerVisualizationVF2D {

    IFunction functionX;
    IFunction functionY;

    Pair<Double, Double> initialCondition[];

    double SCALE;
    double h;
    double START;

    double defaultRadius = StdDraw.getPenRadius();

    public EulerVisualizationVF2D(
            IFunction functionX,
            IFunction functionY,
            Pair<Double, Double> initialCondition[],
            double SCALE,
            double STEP,
            double START
    ) {
        this.functionX = functionX;
        this.functionY=functionY;
        this.initialCondition = initialCondition;
        this.SCALE = SCALE;
        this.h = STEP;
        this.START = START;
    }

    public void visualize() {

        setUpGraph();

        double sX;
        double sY;

        for (int i = 0; i <= initialCondition.length-1; i++) {
            double x = this.initialCondition[i].getKey();
            double y = this.initialCondition[i].getValue();

            for (double t = -START; t <= SCALE; t += h) {

                StdDraw.setPenRadius(0.001d);
                StdDraw.setPenColor(StdDraw.RED);

                StdDraw.point(x, y);
                sX = h*functionX.derivative(x,y);
                sY = h*functionY.derivative(x,y);
                StdDraw.line(x,y, x+sX, y+sY);

                x+=sX;
                y+=sY;

            }
        }
        finalizeGraph();
    }


    private void finalizeGraph() {
        StdDraw.setPenRadius(defaultRadius);
        StdDraw.show();
    }


    private void setUpGraph() {
        StdDraw.setCanvasSize(1200, 800);
        StdDraw.enableDoubleBuffering();
        StdDraw.clear();

        StdDraw.setXscale(-SCALE, SCALE);
        StdDraw.setYscale(-SCALE, SCALE);

        /** axis */
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        StdDraw.line(0, -SCALE, 0, SCALE);
        StdDraw.line(-SCALE, 0, SCALE, 0);
    }
}
