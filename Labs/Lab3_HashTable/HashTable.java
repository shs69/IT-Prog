package Labs.Lab3_HashTable;
import java.util.LinkedList;

public class HashTable<K, V> {
    private LinkedList<Entry<K, V>>[] table;
    private int capacity;
    private int size;

    public static void main(String[] args){
        HashTable<Integer, String> hashMap = new HashTable<>(1000);
        hashMap.put(1, "Запомни, одна ошибка и ты ошибся");
        hashMap.put(1, " \"Я парнишка модный, по жизни свободный, корешей не бросаю и братву уважаю\" (c) Джейсон Стетхем");
        hashMap.put(2, "4VK Кузя Лакомкин - стражи хорошего настроения и здорового образа жизни");
        hashMap.put(3, "Съешь пачку Кузи и ты воин света");
        hashMap.put(4, "Тут могла быть ваша реклама");
        for (int i = 0; i <= 1; i++){
            System.out.println(hashMap.get(1));
        }
        System.out.println(hashMap.get(0));
        System.out.println(hashMap.get(2));
        System.out.println(hashMap.get(3));
        hashMap.remove(2);
        System.out.println(hashMap.get(2));
        System.out.println(hashMap.hash(2));
    }
    public HashTable(int initialSize) {
        this.capacity = initialSize;
        this.table = new LinkedList[capacity];
        this.size = 0;

    }
    public HashTable() {
        this.capacity = 10;
        this.table = new LinkedList[capacity];
        this.size = 0;
    }


    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<Entry<K, V>>();
        }
        for (Entry<K, V> entryElem: table[index]) {
            if (entryElem.getKey().equals(key)) {
                entryElem.setValue(value);
            }
        }
        table[index].add(new Entry<K, V>(key, value));
        size++;
    }
    public V get(K key){
        int index = hash(key);
        LinkedList<Entry<K, V>> list = table[index];
        if (list != null) {
            for (Entry<K, V> entryElem: list) {
                if (entryElem.getKey().equals(key)){
                    return entryElem.getValue();
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> list = table[index];
        if (list != null) {
            for (Entry<K, V> entryElem: list){
                if (entryElem.getKey().equals(key)){
                    list.remove(entryElem);
                    size --;
                }
            }
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private int hash(K key){
        return Math.abs(key.hashCode() % capacity);
    }
}
