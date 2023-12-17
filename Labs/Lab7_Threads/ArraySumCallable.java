package Labs.Lab7_Threads;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ArraySumCallable implements Callable<Double> {
    ArrayList<Double> array;

    public ArraySumCallable(ArrayList<Double> array) {
        this.array = array;
    }

    @Override
    public Double call() throws Exception {
        double res = 0;
        for (double elem : array) {
            res += elem;
        }
        System.out.println("Сумма, посчитанная потоком:" + Thread.currentThread().getName());
        System.out.println(res + "\n");
        return res;
    }
}
