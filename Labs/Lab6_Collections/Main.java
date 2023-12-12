package Labs.Lab6_Collections;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push(4);
        System.out.println(stack.pop());


        StoreSales store = new StoreSales();
        store.addSale("chips", 2);
        store.addSale("cola", 3);
        store.addSale("potato", 1);
        store.addSale("honey", 2);
        System.out.println(store.salesList());
        System.out.println(store.getSalesSum());
        System.out.println(store.getPopularProduct());
    }
}
