import info.ProductInformation;
import products.*;
import store.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Book book = new Book(1, "Чистый код", 800, 23, "книга о написании качественного кода", "Роберт Мартин", 400);
        Book book1 = new Book(2, "Java полное руководство", 1000, 45, "настольная книга java разработчика", "Гербердт Шилдт", 800);
        Book book2 = new Book(3, "Ubuntu Linux с нуля", 700, 29, "книга об опреционной системе Ubuntu Linux", "Сергей Волох", 600);
        Perfume perfume = new Perfume(4, "YSL", 3000, 34, "духи от Ив Сан Лоран", 50);
        Perfume perfume1 = new Perfume(5, "Chanel", 4000, 40, "духи от Шанель", 50);
        Perfume perfume2 = new Perfume(6, "Lacoste", 2800, 30, "духи от Лакосте", 50);
        Watch watch = new Watch(7, "Rolex", 500000, 60, "брендовые часы от Ролекс", "механика", "Swiss");
        Watch watch1 = new Watch(8, "Orient", 100000, 44, "брендовые часы от Ориент", "механика", "Swiss");
        Watch watch2 = new Watch(9, "Citizen", 80000, 45, "брендовые часы от Ситизен", "электронные", "Japan");
        Shop<Product> shop = new Shop<>();
        shop.addItem(book);
        shop.addItem(book1);
        shop.addItem(book2);
        shop.addItem(perfume);
        shop.addItem(perfume1);
        shop.addItem(perfume2);
        shop.addItem(watch);
        shop.addItem(watch1);
        shop.addItem(watch2);
        Delivery delivery = new Delivery();

        System.out.println("Программа: Онлайн магазин");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Меню:" + "\n" + "1.  Показать товары в наличии" + "\n" + "2.  Показать рекомендуемые товары" + "\n"
                    + "3.  Показать товары с самыми низкими ценами" + "\n" + "4.  Добавить товары в корзину" + "\n" + "5.  Удалить товар из корзины" + "\n"
                    + "6.  Очистить корзину" + "\n" + "7.  Оформить доставку товаров в корзине" + "\n" + "8.  Отследить дату доставки по трек номеру" + "\n" + "9.  Выход" + "\n"
                    + "Выберите пункт из меню (1-9):" + "\n" + "и нажмите клавишу ENTER");
            int choice = scanner.nextInt();
            if (choice == 9) {
                System.out.println("До свидания! Ждем вас за новыми покупками!!!");
                break;
            }
            if (choice == 1) {
                shop.showAllProduct();
            }
            if (choice == 2) {
                ProductInformation information = new ProductInformation();
                information.rateRecommendation(shop);
            }
            if (choice == 3) {
                ProductInformation information = new ProductInformation();
                information.priceRecommendation(shop);
            }
            if (choice == 4) {
                int id;
                int count;
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Введите id товара:");
                id = scanner1.nextInt();
                Product product = shop.getProductById(id - 1);
                System.out.println("Введите колличество товара:");
                count = scanner1.nextInt();
                delivery.addProduct(product, count);
                delivery.DisplayCart();
            }
            if (choice == 5) {
                String productName;
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Введите название товара для удаления из корзины:");
                productName = scanner1.nextLine();
                delivery.removeProduct(productName);
                delivery.DisplayCart();
            }
            if (choice == 6) {
                String answer;
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Вы уверены?(введите 'да' для подтверждения)");
                answer = scanner1.nextLine();
                if (answer.equalsIgnoreCase("да")) {
                    delivery.clearCart();
                }
                delivery.DisplayCart();
            }
            if (choice == 7) {
                if (Delivery.getCart().isEmpty()) {
                    System.out.println("КОРЗИНА ПУСТА!");
                    continue;
                }
                delivery.addTrackNumber();
                System.out.println("Ваш трек номер для отслеживания доставки: " + delivery.getTrackNumber());
                System.out.println("Товар будет доставлен: " + delivery.getDeliveryDate());
            }
            if (choice == 8) {
                int number;
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Введите Ваш трек номер заказа:");
                number = scanner1.nextInt();
                delivery.getTrack(number);
            }
        }
    }
}
