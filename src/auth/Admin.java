package auth;

public class Admin extends User {
    private double salary;
    private int accessLevel;

    public Admin(int id, String username, String password, String email, String fullName, String dateOfBirth,
                 String gender, double salary, int accessLevel) {
        super(id, username, password, email, fullName, dateOfBirth, gender);
        this.salary = salary;
        this.accessLevel = accessLevel;
    }

    // Getters and setters for Admin class attributes


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }
}
