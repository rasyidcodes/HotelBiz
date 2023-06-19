package pages.auth;

interface AuthProvider {
    User authenticate(String username, String password);

    default User signupGuest(String username, char[] password, String email, String fullName, String dateOfBirth, String gender, String NIK, String address, int age, String phoneNumber, String country, String city, String guestType) {
        return null;
    }

    default User signupEmployee(String username, char[] password, String email, String fullName, String dateOfBirth, String gender, int salary, int role){
        return  null;
    }
}
