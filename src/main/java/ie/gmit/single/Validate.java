package ie.gmit.single;

/*
Author: Stephen Kilgannon
Student Number: G00303770
Description: Class with one responsibility to validate the user
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {


    //Simply checks if value is null or empty..
    static boolean isPresent(String value) {
        return value != null && value.trim().length() > 0;
    }
    //check string for special characters
    protected static boolean isValidAlphaNumeric(String value) {
        Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
        Matcher matcher = pattern.matcher(value);
        return !matcher.find();
    }
    //check string for valid email address - this is not for prod.
    //Just for demo. This fails for lots of valid emails.
    protected static boolean isValidEmail(String value) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }
    //Validates the user object
    protected static boolean isValidUser(User user) {
        if(!Validate.isPresent(user.getName())) {
            return false;
        }
        user.setName(user.getName().trim());

        if(!Validate.isValidAlphaNumeric(user.getName())) {
            return false;
        }
        if(user.getEmail() == null || user.getEmail().trim().length() == 0) {
            return false;
        }
        user.setEmail(user.getEmail().trim());
        if(!Validate.isValidEmail(user.getEmail())) {
            return false;
        }
        return true;
    }
}
