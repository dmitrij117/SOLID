package products;

public class Watch extends Product {
    private String type;
    private String countryProduction;

    public Watch(int id, String name, int price, int rate, String description, String type, String countryProduction) {
        super(id, name, price, rate, description);
        this.type = type;
        this.countryProduction = countryProduction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountryProduction() {
        return countryProduction;
    }

    public void setCountryProduction(String countryProduction) {
        this.countryProduction = countryProduction;
    }
}
