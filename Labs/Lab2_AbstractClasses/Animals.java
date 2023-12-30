package Labs.Lab2_AbstractClasses;
public class Animals extends AbstractAnimals {
    private String color;
    private String breed;
    private String ownerName;
    public Animals(String familyAnimal, String name, float weight, String color, String breed, String ownerName){
        super(familyAnimal, name, weight);
        this.color = color;
        this.breed = breed;
        this.ownerName = ownerName;
    }
    public Animals(){
        super();
        this.color = "White";
        this.breed = "Jack Russell Terrier";
        this.ownerName = "John Bellfort";
    }
    @Override
    public void display() {
        super.display();
        System.out.println(color);
        System.out.println(breed);
        System.out.println(ownerName);
    }
    public void needEat() {
        System.out.println("Мне нужна еда");
    }

    public void needWater() {
        System.out.println("Мне нужна вода");
    }

    public String getColor() {
        return color;
    }

    public String breed(){
        return breed;
    }

    public String ownerName() {
        return ownerName;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setBreeed(String breed) {
        this.breed = breed;
    }

    public void setOwnerName(String ownerName){
        this.ownerName = ownerName;
    }
}
