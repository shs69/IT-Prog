package Labs.Classes_2;
public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("cats", "Kitty", 12, "white", "cats", "Alexandr", "Kotty", true, false);
        System.out.println(cat.getCatMother());
        cat.setCatMother("Mom");
        System.out.println(cat.getCatMother());
    }
}