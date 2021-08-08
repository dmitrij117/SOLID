package store;

import products.Product;

import java.time.LocalDate;
import java.util.*;

public class Delivery {
    private static Map<Product, Integer> cart = new HashMap<>();
    private static Map<Integer, Map<Product, Integer>> trackMap = new HashMap<>();
    Random rnd = new Random();
    private static final int MAXTRACKNUMS = 100; // замена Magic Numbers на константу
    private int trackNumber;

    public static Map<Product, Integer> getCart() {
        return cart;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public int setTrackNumber() {
        return trackNumber = rnd.nextInt(MAXTRACKNUMS); // замена Magic Numbers на константу
    }

    public void addProduct(Product product, int count) {
        cart.put(product, count);
    }

    public void removeProduct(String name) {
        Iterator<Map.Entry<Product, Integer>> iterator = cart.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Product, Integer> pair = iterator.next();
            Product key = pair.getKey();
            Integer value = pair.getValue();
            if (key.getName().equalsIgnoreCase(name)) {
                iterator.remove();
            }
        }
    }

    public void clearCart() {
        cart.clear();
    }

    public void DisplayCart() {
        if (cart.isEmpty()) {
            System.out.println("Ваша корзина пуста!");
            return;
        }
        System.out.println("В Вашей корзине следующий товары");
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey().getName() + "  " + entry.getValue().toString() + " шт.");
        }
    }

    public void addTrackNumber() {
        trackMap.put(setTrackNumber(), cart);
    }

    public static Map<Integer, Map<Product, Integer>> getTrackMap() {
        return trackMap;
    }

    public void getTrack(int number) {
        for (Map.Entry<Integer, Map<Product, Integer>> pair : getTrackMap().entrySet()) {
            if (pair.getKey() == number) {
                System.out.println("Ваша посылка в составе: ");
                for (Map.Entry<Product, Integer> entry : pair.getValue().entrySet()) {
                    System.out.println(entry.getKey().getName() + "  " + entry.getValue().toString() + " шт.");
                }
                System.out.println("Будет доставлена: " + getDeliveryDate());
            } else {
                System.out.println("Указанный трек номер не существует!");
            }
        }
    }

    public String getDeliveryDate() {
        return LocalDate.now().plusDays(7).toString();
    }
}
