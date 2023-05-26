public class BookMaster {
    private int id;
    private String title;
    private String author;
    private int currentStock;
    private int totalStock;
    private int publicationYear;
    private String category;
    private String description;

    public BookMaster(int id, String title, String author, int currentStock, int totalStock, int publicationYear,
            String category, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.currentStock = currentStock;
        this.totalStock = totalStock;
        this.publicationYear = publicationYear;
        this.category = category;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public int getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(int totalStock) {
        this.totalStock = totalStock;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
