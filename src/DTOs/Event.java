package DTOs;

import java.sql.Timestamp;

public class Event {
    private int id;
    private int userId;
    private String eventTitle;
    private String summary;
    private int maxCap;
    private int currentParticipants;
    private Timestamp startTime;
    private Timestamp endTime;
    private String image;

    public Event(int id, int userId, String eventTitle, String summary, int maxCap, int currentParticipants,
                    Timestamp startTime, Timestamp endTime, String image) {
        this.id = id;
        this.userId = userId;
        this.eventTitle = eventTitle;
        this.summary = summary;
        this.maxCap = maxCap;
        this.currentParticipants = currentParticipants;
        this.startTime = startTime;
        this.endTime = endTime;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public String getSummary() {
        return summary;
    }

    public int getMaxCap() {
        return maxCap;
    }

    public int getCurrentParticipants() {
        return currentParticipants;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public String getImage() {
        return image;
    }
}
