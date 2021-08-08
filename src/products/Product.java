package products;

public class Product {
    private int id;
    private String name;
    private int price;
    private int rate;
    private String description;

    public Product(int id, String name, int price, int rate, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rate = rate;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
