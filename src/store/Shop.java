package store;

import products.Product;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shop<P extends Product> {
    private List<P> productList = new ArrayList<>();

    public void addItem(P product) {
        productList.add(product);
    }

    public int getMaxRating() {
        int count = 0;
        for (Product p : getProductList()) {
            if (p.getRate() > count) {
                count = p.getRate();
            }
        }
        return count;
    }

    public P getCheapest() {
        int minIndex = 0;
        for (int i = 1; i < productList.size(); i++) {
            if (productList.get(minIndex).getPrice() > productList.get(i).getPrice()) {
                minIndex = i;
            }
        }
        return productList.get(minIndex);
    }

    public List<P> getProductList() {
        return productList;
    }

    public void showAllProduct() {
        System.out.println("Предлагаем список наших товаров:");
        for (P p : productList) {
            System.out.println(p.getName() + " - " + p.getDescription() + " цена " + p.getPrice() + "rub"
                    + "\n" + "Идентификатор товара " + p.getName() + ": " + p.getId());
            System.out.println();
        }
    }

    public P getProductById(int id) {
        return productList.get(id);
    }
}
