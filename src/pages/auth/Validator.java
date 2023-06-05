package pages.auth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String EMAIL_PATTERN =
            "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public static boolean validateEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    private static final Pattern pattern2 = Pattern.compile(PASSWORD_PATTERN);

    public static boolean validatePassword(String password) {
        Matcher matcher = pattern2.matcher(password);
        return matcher.matches();
    }


//    At least 8 characters long
//    Contains at least one uppercase letter (A-Z)
//    Contains at least one lowercase letter (a-z)
//    Contains at least one digit (0-9)
//    Contains at least one special character from the set [@#$%^&+=]
//    Does not contain whitespace



}
