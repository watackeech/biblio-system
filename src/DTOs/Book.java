package DTOs;

public class Book {
    private Integer id;
    private String masterId;
    private String status;

    public Book() {
    }

    public Book(Integer id, String masterId, String status) {
        this.id = id;
        this.masterId = masterId;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}