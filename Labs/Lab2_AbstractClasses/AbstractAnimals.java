package Labs.Lab2_AbstractClasses;

public abstract class AbstractAnimals {
    private String familyAnimal;
    private String name;
    private float weight;
    static private int count;
    public AbstractAnimals(String familyAnimals, String name, float weight){
        this.familyAnimal = familyAnimals;
        this.name = name;
        this.weight = weight;
        count += 1;
    }
    public AbstractAnimals(){
        this.familyAnimal = "Dog";
        this.name = "Archie";
        this.weight = 10;
        count += 1;
    }
    public void display(){
        System.out.println(familyAnimal);
        System.out.println(name);
        System.out.println(weight);
    }
    public String getFamilyAnimal() {
        return familyAnimal;
    }
    public String getName(){
        return name;
    }
    public static int getCount() {
        return count;
    }
    public void setFamilyAnimal(String familyAnimal){
        this.familyAnimal = familyAnimal;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
}
