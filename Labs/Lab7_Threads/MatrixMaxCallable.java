package Labs.Lab7_Threads;
import java.util.concurrent.Callable;

public class MatrixMaxCallable implements Callable<Double>{
    double[] array;

    public MatrixMaxCallable(double[] array){
        this.array = array;
    }


    @Override
    public Double call() throws Exception {
        double maxx = 0;
        for (double elem: array){
            if (elem >= maxx) {
                maxx = elem;
            }
        }
        return maxx;
    }
}
