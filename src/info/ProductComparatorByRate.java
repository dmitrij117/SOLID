package info;

import products.Product;

import java.util.Comparator;

public class ProductComparatorByRate implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getRate() - o1.getRate();
    }
}
