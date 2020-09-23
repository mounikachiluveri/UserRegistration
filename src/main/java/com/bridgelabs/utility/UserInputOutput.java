package com.bridgelabs.utility;

import com.bridgelabs.exception.UserValidationException;
import com.bridgelabs.model.User;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputOutput {

    public static String firstName;
    public static String emailId;
    public static String phoneNumber;
    public static String lastName;
    public static String password;

    public static User getUserName() {
        User user = new User();
        String firstAndLastName;
        System.out.println("Enter the First Name");
        firstName = UserInput.getString();
        while (!UserInputOutput.stringChecker(firstName)) {
            System.out.println("Enter valid the first name");
            firstName = UserInput.getString();
        }
        user.setFirstName(firstName);
        System.out.println("Enter the Last Name");
        lastName = UserInput.getString();
        while (!UserInputOutput.stringChecker(lastName)) {
            System.out.println("Enter valid the last name");
            lastName = UserInput.getString();
        }
        user.setLastName(lastName);
        firstAndLastName = user.getFirstName() + user.getLastName();
        return user;
    }

    public static User addUserRecord(User user) {
        try {
            long length;
            System.out.println("Enter the Password");
            password = UserInput.getString();
            while (!UserInputOutput.passwordChecker(password)) {
                System.out.println("Enter valid the Password");
                password = UserInput.getString();
            }
            user.setPassword(password);
            System.out.println("Enter the emailId");
            emailId = UserInput.getString();
            while (!UserInputOutput.emailChecker(emailId)) {
                System.out.println("Enter the valid emailId");
                emailId = UserInput.getString();
            }
            user.setEmailId(emailId);
            System.out.println("Enter the 10 Digit Mobile Number");
            phoneNumber = UserInput.getString();
            while (!UserInputOutput.phoneNumberChecker(phoneNumber)) {
                System.out.println("Enter the valid phone number");
                phoneNumber = UserInput.getString();
            }
            user.setPhoneNumber(phoneNumber);
        } catch (NullPointerException | InputMismatchException e) {
            System.out.println(e);
        }
        return user;
    }

    public static User loginUser() {
        User user = new User();
        try {
            System.out.println("Enter the emailId");
            user.setEmailId(UserInput.getString());
            System.out.println("Enter the Password");
            user.setPassword(UserInput.getString());
        } catch (NullPointerException | InputMismatchException e) {
            System.out.println(e);
        }
        return user;
    }

    public static boolean stringChecker(String checkString) {
        Pattern stringChecker = Pattern.compile("^[A-Z]{1}[A-Za-z]{2,}");
        Matcher matchString = stringChecker.matcher(checkString);
        return matchString.matches();
    }

    public static boolean passwordChecker(String checkString) {
        Pattern stringChecker = Pattern.compile("(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&!]){1}.{8,}");
        Matcher matchString = stringChecker.matcher(checkString);
        return matchString.matches();
    }

    public static boolean emailChecker(String checkString) {
        Pattern stringChecker = Pattern.compile("^[a-zA-Z0-9.+_-]+[@][a-zA-Z0-9]+[.]co(m|.in)$");
        Matcher matchString = stringChecker.matcher(checkString);
        return matchString.matches();
    }

    public static boolean phoneNumberChecker(String checkString) {
        Pattern stringChecker = Pattern.compile("^[0-9]{1}[0-9]{9}$");
        Matcher matchString = stringChecker.matcher(checkString);
        return matchString.matches();
    }

    public static String validateField(User user) throws UserValidationException {
        if (!UserInputOutput.stringChecker(user.getFirstName())) {
            throw new UserValidationException(UserValidationException.ExceptionType.INVALID_FIRSTNAME, "Invalid FirstName");
        }
        if (!UserInputOutput.stringChecker(user.getLastName())) {
            throw new UserValidationException(UserValidationException.ExceptionType.INVALID_LASTNAME, "Invalid LastName");

        }
        if (!UserInputOutput.passwordChecker(user.getPassword())) {
            throw new UserValidationException(UserValidationException.ExceptionType.INVALID_PASSWORD, "Invalid password");

        }
        if (!UserInputOutput.emailChecker(user.getEmailId())) {
            throw new UserValidationException(UserValidationException.ExceptionType.INVALID_EMAILID, "Invalid email");
        }

        if (!UserInputOutput.phoneNumberChecker(user.getPhoneNumber())) {
            throw new UserValidationException(UserValidationException.ExceptionType.INVALID_PHONENUMBER, "Invalid phoneNumber");
        }
        return "Registration SuccessFul";
    }
}

