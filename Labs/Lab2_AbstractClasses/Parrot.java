package Labs.Lab2_AbstractClasses;

public class Parrot extends Animals{
    private String parrotFather;
    private boolean hungry;
    private boolean sleep;

    public Parrot(String familyAnimal, String name, float weight, String color, String breed, String ownerName, String parrotFather, boolean hungry, boolean sleep){
        super(familyAnimal, name, weight, color, breed, ownerName);
        this.parrotFather = parrotFather;
        this.hungry = hungry;
        this.sleep = sleep;
    }

    @Override
    public void needEat(){
        System.out.println("Кожаное создание, капитан Прайс хочет есть!");
    }

    public void full(){
        System.out.println("Да не хочу я есть, закормил ты меня уже!");
    }

    public void isHungry(){
        if (hungry) {
            needEat();
        } else {
            full();
        }
    }

    public void isSleep(){
        System.out.println("Прекрати мешать моему сну! Пока я капитан этого судна ты обязан чтить мой покой");
    }
    public void noSleep(){
        System.out.println("Как ты смеешь обвинять своего капитана в тунеядстве??? Я полон энергии!");
    }

    public void isSleeping() {
        if (sleep) {
            isSleep();
        } else {
            noSleep();
        }
    }

    public String getParrotFather(){
        return parrotFather;
    }

    public boolean hungry(){
        return hungry;
    }

    public boolean sleep(){
        return sleep;
    }

    public void setParrotFather(String parrotFather){
        this.parrotFather = parrotFather;
    }

    public void setHungry(boolean hungry){
        this.hungry = hungry;
    }

    public void setSleep(boolean sleep){
        this.sleep = sleep;
    }
}
