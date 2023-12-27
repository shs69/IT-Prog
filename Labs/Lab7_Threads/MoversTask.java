package Labs.Lab7_Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class MoversTask extends RecursiveTask<Double> {
    List<Product> products;

    public MoversTask(List<Product> products) {
        this.products = products;
    }

    @Override
    public Double compute() {

        if (products.isEmpty()) {
            System.out.println("Начальник, мы уже всё закончили. Отдыхаем!");
            return null;
        }

        List<Product> currentLoad = new ArrayList<>();
        double currentWeight = 0;

        for (Product product : products) {
            if (currentWeight + product.getWeight() <= 150) {
                currentLoad.add(product);
                currentWeight += product.getWeight();
            } else if (product.getWeight() > 150) {
                System.out.println("Товар слишком тяжелый, начальник! Втроём не осилим.");
                return null;
            } else {
                break;
            }
        }

        System.out.println("Перевозим следующие товары:");
        currentLoad.forEach(elem -> System.out.println(elem.name));
        System.out.println("Разгружаем следующие товары:");
        currentLoad.forEach(elem -> System.out.println(elem.name));

        List<Product> remainProducts = new ArrayList<>(products);
        remainProducts.removeAll(currentLoad);

        List<MoversTask> subTasks = new ArrayList<>();
        subTasks.add(new MoversTask(remainProducts));

        invokeAll(subTasks);

        return null;
    }

}
