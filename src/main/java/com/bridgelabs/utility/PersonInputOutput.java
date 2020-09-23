package com.bridgelabs.utility;

import com.bridgelabs.model.Person;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonInputOutput {

    public static String firstName;
    public static String emailId;
    public static String phoneNumber;
    public static String lastName;
    public static String password;

    public static Person getPersonName() {
        Person person = new Person();
        String firstAndLastName;
        System.out.println("Enter the First Name");
        firstName = UserInput.getString();
        while (!PersonInputOutput.stringChecker(firstName)) {
            System.out.println("Enter valid the first name");
            firstName = UserInput.getString();
        }
        person.setFirstName(firstName);
        System.out.println("Enter the Last Name");
        lastName = UserInput.getString();
        while (!PersonInputOutput.stringChecker(lastName)) {
            System.out.println("Enter valid the last name");
            lastName = UserInput.getString();
        }
        person.setLastName(lastName);
        firstAndLastName = person.getFirstName() + person.getLastName();
        return person;
    }

    public static Person addPersonRecord(Person person) {
        try {
            long length;
            System.out.println("Enter the Password");
            password = UserInput.getString();
            while (!PersonInputOutput.passwordChecker(password)) {
                System.out.println("Enter valid the Password");
                password = UserInput.getString();
            }
            person.setPassword(password);
            System.out.println("Enter the emailId");
            emailId = UserInput.getString();
            while (!PersonInputOutput.emailChecker(emailId)) {
                System.out.println("Enter the valid emailId");
                emailId = UserInput.getString();
            }
            person.setEmailId(emailId);
            System.out.println("Enter the 10 Digit Mobile Number");
            phoneNumber = UserInput.getString();
            while (!PersonInputOutput.phoneNumberChecker(phoneNumber)) {
                System.out.println("Enter the valid phone number");
                phoneNumber = UserInput.getString();
            }
            person.setPhoneNumber(phoneNumber);
        } catch (NullPointerException | InputMismatchException e) {
            System.out.println(e);
        }
        return person;
    }

    public static Person loginPerson() {
        Person person = new Person();
        try {
            System.out.println("Enter the emailId");
            person.setEmailId(UserInput.getString());
            System.out.println("Enter the Password");
            person.setPassword(UserInput.getString());
        } catch (NullPointerException | InputMismatchException e) {
            System.out.println(e);
        }
        return person;
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

    public static String validateField(Person person) {
        if (!PersonInputOutput.stringChecker(person.getFirstName())) {
            return "unsuccessfull";
        }
        if (!PersonInputOutput.stringChecker(person.getLastName())) {
            return "unsuccessfull";
        }
        if (!PersonInputOutput.passwordChecker(person.getPassword())) {
            return "unsuccessfull";
        }
        if (!PersonInputOutput.emailChecker(person.getEmailId())) {
            return "unsuccessfull";
        }
        if (!PersonInputOutput.phoneNumberChecker(person.getPhoneNumber())) {
            return "unsuccessfull";
        }
        return "Successfull";
    }
}

