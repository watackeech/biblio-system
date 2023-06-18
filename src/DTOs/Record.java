package DTOs;

import java.util.Date;

public class Record {
    private Integer id;
    private Integer userId;
    private String barcodeId;
    private Date startDate;
    private Date endDate;

    public Record() {
    }

    public Record(Integer id, Integer userId, String barcodeId, Date startDate, Date endDate) {
        this.id = id;
        this.userId = userId;
        this.barcodeId = barcodeId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBarcodeId() {
        return barcodeId;
    }

    public void setBarcodeId(String barcodeId) {
        this.barcodeId = barcodeId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

