package odes.odes;

import javafx.util.Pair;
import odes.components.functions.IFunction;
import odes.components.functions.PredatorFunction;
import odes.components.functions.PreyFunction;
import odes.components.initialcondition.InitialConditions;
import odes.components.visualizations.ScatterVisualization2D;
import org.jzy3d.analysis.AnalysisLauncher;

public class PredatorPreyVF {

    public static void main(String[] args) throws Exception {
        IFunction functionX = new PreyFunction();
        IFunction functionY = new PredatorFunction();

        Pair<Double, Double>[] initialConditions =
                InitialConditions.getInitialConditions(0, 100, 10);


        double SCALE = 100;
        double STEP = 0.01d;
        double START = 0d;

//        EulerVisualizationVF2D vis = new EulerVisualizationVF2D(
//                functionX,
//                functionY,
//                initialConditions,
//                SCALE,
//                STEP,
//                START
//        );
//        vis.visualize();

        AnalysisLauncher.open(new ScatterVisualization2D(
                functionX,
                functionY,
                initialConditions,
                SCALE,
                STEP,
                START
        ));



}
}
