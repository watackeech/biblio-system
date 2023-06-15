package DTOs;

public class User {
	private Integer studentId;
    private String name;
    private String password;
    private String status;

    public User() {
    }

    public User(Integer studentId, String name, String password, String status) {
        this.studentId = studentId;
        this.name = name;
        this.password = password;
        this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}