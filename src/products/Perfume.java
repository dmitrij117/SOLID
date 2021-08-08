package products;

public class Perfume extends Product {
    private int sizeMl;

    public Perfume(int id, String name, int price, int rate, String description, int sizeMl) {
        super(id, name, price, rate, description);
        this.sizeMl = sizeMl;
    }

    public int getSizeMl() {
        return sizeMl;
    }

    public void setSizeMl(int sizeMl) {
        this.sizeMl = sizeMl;
    }
}
