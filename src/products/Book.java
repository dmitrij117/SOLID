package products;

public class Book extends Product {
    private String authorName;
    private int pageCount;


    public Book(int id, String name, int price, int rate, String description, String authorName, int pageCount) {
        super(id, name, price, rate, description);
        this.authorName = authorName;
        this.pageCount = pageCount;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
