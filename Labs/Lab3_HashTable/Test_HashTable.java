package Labs.Lab3_HashTable;

public class Test_HashTable {
    public static void main(String[] args){
        HashTable<String, Contact> phoneBook = new HashTable<>(30);
        phoneBook.put("79103136542", new Contact("Sanya", "sanya@mail.ru", "18 y.o., joskiy"));
        phoneBook.put("79103136442", new Contact("Valera", "valera@mail.ru", "18 лет"));
        phoneBook.put("79063139542", new Contact("Kirill", "topMLengineer@mail.ru", "Обучу вашу нейронку. Дорого"));
        phoneBook.put("79153136542", new Contact("Valeria", "wifeKrupoderova@mail.ru", "Просто крутая"));
        phoneBook.put("79893136562", new Contact("Vanya", "ko4ka@mail.ru", "20 y.o."));
        phoneBook.put("79100006592", new Contact("Artem", "temi4@mail.ru", "Великая Китайская Стена"));
        phoneBook.put("78005553535", new Contact("Max", "army_rocket@mail.ru", "Отправлю вас на орбиту"));
        phoneBook.put("79893136562", new Contact("Andrey", "army_rocket@mail.ru", "Летаем выше небес"));
        Contact vanya = phoneBook.get("79893136562");
        System.out.println(vanya.getContactDetails());
        vanya.setEmail("oops_broke@mail.ru");
        System.out.println(vanya.getEmail());
        phoneBook.remove("78005553535");
        if (phoneBook.get("78005553535") == null) {
            System.out.println("Объекта в таблице не существует");
        } else {
            System.out.println(phoneBook.get("78005553535").getName());
        }
        System.out.println(phoneBook.get("79103136542").getAllInfo());
    }
}
