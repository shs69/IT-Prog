package Labs.Lab8_Annotations;

public class Human {
    private double age;
    private String name;
    private String country;
    private String education;

    public Human(double age, String name, String country, String education) {
        this.age = age;
        this.name = name;
        this.country = country;
        this.education = education;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public void setEducation(String education){
        this.education = education;
    }

    public double getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getCountry(){
        return country;
    }

    public String getEducation() {
        return education;
    }

    public String getAll(){
        return name + "," + country + "," + age + "," + education;
    }
}
