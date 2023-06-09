package DTOs;

public class User {
	private Integer studentId;
    private String name;
    private String password;

    public User() {
    }

    public User(Integer studentId, String name, String password) {
        this.studentId = studentId;
        this.name = name;
        this.password = password;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}