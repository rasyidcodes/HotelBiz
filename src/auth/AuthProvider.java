package auth;

interface AuthProvider {
    User authenticate(String username, String password);
}
