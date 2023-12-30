package Labs.Lab2_AbstractClasses;

public class Cat extends Animals{
    private String catMother;
    private boolean hungry;
    private boolean sleep;

    public Cat(String familyAnimal, String name, float weight, String color, String breed,
               String ownerName, String catMother, boolean hungry, boolean sleep){
        super(familyAnimal, name, weight, color, breed, ownerName);
        this.catMother = catMother;
        this.hungry = hungry;
        this.sleep = sleep;
        isHungry();
    }

    @Override
    public void needEat(){
        System.out.println("Покорми меня");
    }

    public void full(){
        System.out.println("Я уже наелся");
    }
    public void isHungry(){
        if (hungry) {
            needEat();
        } else {
            full();
        }
    }

    public void isSleep(){
        System.out.println("Не мешааай, я сплю..");
    }
    public void noSleep(){
        System.out.println("Кто спит? Я не спит! Я кот!");
    }

    public void isSleeping() {
        if (sleep) {
            isSleep();
        } else {
            noSleep();
        }
    }
    public String getCatMother(){
        return catMother;
    }

    public boolean hungry(){
        return hungry;
    }

    public boolean sleep(){
        return sleep;
    }

    public void setCatMother(String catMother){
        this.catMother = catMother;
    }

    public void setHungry(boolean hungry){
        this.hungry = hungry;
    }

    public void setSleep(boolean sleep){
        this.sleep = sleep;
    }
}
