package DTOs;

public class User {
    private Integer id;
    private String name;
    private String studentId;
    private String password;

    public User() {
    }

    public User(Integer id, String name, String studentId, String password) {
        this.id = id;
        this.name = name;
        this.studentId = studentId;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}