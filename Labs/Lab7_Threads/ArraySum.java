package Labs.Lab7_Threads;

import java.util.ArrayList;
import java.util.concurrent.*;

public class ArraySum {
    public static void main(String[] args) {
        System.out.println(SumOfArray(new double[]{1, 2, 3, 4, 5.5, 6}, 3));
    }
    public static float SumOfArray(double[] massive, int count) {
        float sum = 0;
        ArrayList<ArrayList<Double>> array = new ArrayList<>(arrayDivider(massive, count));
        ArrayList<Double> result = new ArrayList<>();
        for (ArrayList<Double> elem : array) {
            System.out.println("Массив для потока:");
            System.out.println(elem + "\n");
        }
        ExecutorService service = Executors.newFixedThreadPool(count);
        for (int i = 0; i < count; i++) {
            Future<Double> a = service.submit(new ArraySumCallable(array.get(i)));
            try {
                result.add(a.get());
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Error");
            }
        }
        service.close();
        System.out.println("Сумма массива:");
        for (Double elem: result){
            sum += elem;
        }
        return sum;
    }
    public static ArrayList<ArrayList<Double>> arrayDivider(double[] array, int count) {
        int arraySize = array.length / count;
        ArrayList<ArrayList<Double>> result = new ArrayList<>();
        int k = 0;
        while (k < array.length - (array.length % count)) {
            ArrayList<Double> intermediate = new ArrayList<>();
            for (int i = 0; i < arraySize; i++) {
                intermediate.add(array[k]);
                k++;
            }
            result.add(intermediate);
        }
        while (k != array.length) {
            ArrayList<Double> buffer = result.get(k % count);
            buffer.add(array[k]);
            result.set(k % count, buffer);
            k++;
        }
        return result;
    }
}
