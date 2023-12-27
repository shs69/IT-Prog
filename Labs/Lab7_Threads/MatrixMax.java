package Labs.Lab7_Threads;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MatrixMax {
    public static void main(String[] args) {
        double[][] matrix = {
                {1, 2, 3, 5},
                {25, 3, 0, 1},
                {1, 1, 1, 1},
        };
        System.out.println(maxOfMatrix(matrix));
    }

    public static double maxOfMatrix(double[][] array){
        double maxx = 0;
        ExecutorService service = Executors.newFixedThreadPool(array.length);
        ArrayList<Double> result = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            Future<Double> a = service.submit(new MatrixMaxCallable(array[i]));
            try {
                result.add(a.get());
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Error");
            }
        }

        for (Double elem: result){
            if (elem >= maxx) {
                maxx = elem;
            }
        }
        service.close();
        return maxx;
    }
}
