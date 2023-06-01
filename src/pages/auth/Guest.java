package pages.auth;

public class Guest extends User {
    private String NIK;
    private String address;
    private int age;
    private String phoneNumber;
    private String country;
    private String city;
    private String guestType;

    public Guest(int id, String username, String password, String email, String fullName, String dateOfBirth,
                 String gender, String NIK, String address, int age, String phoneNumber, String country,
                 String city, String guestType) {
        super(id, username, password, email, fullName, dateOfBirth, gender);
        this.NIK = NIK;
        this.address = address;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.city = city;
        this.guestType = guestType;
    }

    // Getters and setters for Guest class attributes


    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGuestType() {
        return guestType;
    }

    public void setGuestType(String guestType) {
        this.guestType = guestType;
    }
}




