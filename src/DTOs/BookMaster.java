package DTOs;

public class BookMaster {
    private String id;
    private String title;
    private String author;
    private Integer totalStock;
    private Integer currentStock;
    private Integer publicationYear;
    private String category;
    private String description;
    private String image;
    private String location;

    public BookMaster() {
    }

    public BookMaster(String id, String title, String author, Integer currentStock, Integer totalStock,
            Integer publicationYear,
            String category, String description, String image, String location) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.currentStock = currentStock;
        this.totalStock = totalStock;
        this.publicationYear = publicationYear;
        this.category = category;
        this.description = description;
        this.image = image;
        this.setLocation(location);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Integer getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }

    public Integer getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(Integer totalStock) {
        this.totalStock = totalStock;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
