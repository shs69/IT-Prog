package Labs.Lab2_AbstractClasses;

public class Fish extends Animals{
    private boolean isGold;
    private String nativeReservoir;
    private boolean hungry;

    public Fish(String familyAnimal, String name, float weight, String color, String breed, String ownerName, boolean hungry, String nativeReservoir, boolean isGold) {
        super(familyAnimal, name, weight, color, breed, ownerName);
        this.hungry = hungry;
        this.isGold = isGold;
        this.nativeReservoir = nativeReservoir;
    }

    public void ifGold() {
        System.out.println("Не еешь меня, я любое твоё желание выполню...");
    }

    public void noGold(){
        System.out.println("Буль..буль...буль-буль...");
    }

    public void isGold() {
        if (isGold) {
            ifGold();
        } else{
            noGold();
        }
    }
    public boolean getGold(){
        return isGold;
    }

    public String getNativeReservoir(){
        return nativeReservoir;
    }

    public boolean getHungry(){
        return hungry;
    }

    public void setGold(boolean isGold){
        this.isGold = isGold;
    }

    public void setNativeReservoir(String nativeReservoir){
        this.nativeReservoir = nativeReservoir;
    }

    public void setHungry(boolean hungry){
        this.hungry = hungry;
    }
}
