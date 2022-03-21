package mx.com.gm.challengearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySorting {

    public static void main(String[] args) {
        int[] test = new int[]{
            6, 3, 1, 2, 7, 5, 4, 8, 9
        };
        Item[] items = new Item[]{
            new Item(7, "iPhone", 34),
            new Item(2, "Laptop", 9),
            new Item(9, "House", 85)
        };
        //sortWithClass(test);
        sortManually(test);
        sorting(items);
    }

    private static void sortManually(int[] array) {
        //int[] sorted = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int tmp = 0;
                if (array[i] > array[j]) {
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
    
    

    private static void sortWithClass(int[] array) {
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sorting(Item[] items) {
        Arrays.sort(items, (o1, o2) -> o1.getPrice() - o2.getPrice());
        System.out.println(Arrays.toString(items));
    }
}

class Item {

    int id;
    String name;
    int price;

    Item(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", name=" + name + ", price=" + price + '}';
    }

}
