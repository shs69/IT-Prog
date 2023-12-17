package Labs.Lab7_Threads;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class Movers {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        for (int i = 1; i < 31; i++){
            products.add(new Product("Товар №" + i, i * 3));
        }

        try(ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            forkJoinPool.invoke(new MoversTask(products));
        }

    }
}
