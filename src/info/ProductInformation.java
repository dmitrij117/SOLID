package info;

import products.Product;
import store.Shop;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class ProductInformation extends Shop<Product> {
    Date date = new Date();
    private final int recommendedElement = 3; // замена Magic Numbers на константу

    public int getRecommendedElement() {
        return recommendedElement;
    }

    public void rateRecommendation(Shop<Product> shop) {
        List<? extends Product> list = shop.getProductList();
        list.sort(new ProductComparatorByRate());
        System.out.println("Предлагаем Вам товары с самым высоким рейтингом по состоянию на : " + date.toString());
        List<Product> firstThreeElementsList = list.stream().limit(getRecommendedElement()).collect(Collectors.toList());
        for (Product product : firstThreeElementsList) {
            System.out.println(product.getName() + " " + product.getRate());
        }
        for (Product product : firstThreeElementsList) {
            if (product.getRate() == shop.getMaxRating()) {
                System.out.println("Товар дня по рейтингу покупателей: " + product.getName() + " - " + product.getDescription());
            }
        }
    }

    public void priceRecommendation(Shop<Product> shop) {
        List<? extends Product> list = shop.getProductList();
        list.sort(new ProductComparatorByPrice());
        System.out.println("Предлагаем Вам товары с самыми низкими ценами по состоянию на : " + date.toString());
        List<Product> firstThreeElementsList = list.stream().limit(getRecommendedElement()).collect(Collectors.toList());
        for (Product product : firstThreeElementsList) {
            System.out.println(product.getName() + " " + product.getPrice());
        }
        for (Product product : firstThreeElementsList) {
            if (product == shop.getCheapest()) {
                System.out.println("Самый дешевый товар на сегодня: " + product.getName() + " - " + product.getDescription());
            }
        }
    }

    @Override
    public int getMaxRating() {
        return super.getMaxRating();
    }

    @Override
    public Product getCheapest() {
        return super.getCheapest();
    }
}
