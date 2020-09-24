package com.bridgelabs.controller;

import com.bridgelabs.model.User;
import com.bridgelabs.service.UserRegistrationValidator;
import com.bridgelabs.service.UserService;
import com.bridgelabs.utility.UserInput;
public class UserRegistration {

    public static void main(String[] args) {
        User userDetail = new User();
        UserService userService = new UserService();
        boolean isContinue = true;
        System.out.println("Welcome UserRegistration program");
        while (isContinue) {
            System.out.println("1)REGISTERUSER   \n2)UPDATEUSER   \n3)DELETEUSER \n4)Login User");
            int select = UserInput.getNumber();
            switch (select) {
                case 1:
                    userDetail = getMailid(userService);
                    if (userService.findByEmailId(userDetail) == 1) {
                        System.out.println("User already exist");
                    } else {
                        userDetail = InputFromUser(userService, userDetail);
                        userService.addUser(userDetail);
                        System.out.println("Registration successfully");
                    }
                    break;
                case 2:
                    userDetail = getMailid(userService);
                    if (userService.findByEmailId(userDetail) != 1) {
                        System.out.println("user not exist by email ID");
                    } else {
                        userDetail = InputFromUser(userService, userDetail);
                        userService.updateUser(userDetail);
                        System.out.println("Record Updated successfully");
                    }
                    break;

                case 3:
                    userDetail = getMailid(userService);
                    if (userService.findByEmailId(userDetail) != 1) {
                        System.out.println("user not exist by email ID");
                    } else {
                        userService.deleteUser(userDetail);
                        System.out.println("Record deleted successfully");
                    }
                    break;
                case 4:
                    userDetail = getMailidAndPassword(userService);
                    System.out.println(userService.loginUser(userDetail));

            }
            break;
        }
    }

    private static User getMailidAndPassword(UserService userService) {
        User mailIdAndPassword = new User();
        System.out.println("Email Id");
        String emailId = UserInput.getString();
        mailIdAndPassword.emailId = userService.checkFieldValidation(UserRegistrationValidator.ValidatePattern.EMAIL, emailId, "Email Id");
        System.out.println("Password");
        String password = UserInput.getString();
        mailIdAndPassword.password = userService.checkFieldValidation(UserRegistrationValidator.ValidatePattern.PASSWORD, password, "Password");
        return mailIdAndPassword;
    }

    private static User getMailid(UserService userService) {
        User userDetail = new User();
        System.out.println("Email Id");
        String emailId = UserInput.getString();
        userDetail.emailId = userService.checkFieldValidation(UserRegistrationValidator.ValidatePattern.EMAIL, emailId, "Email Id");
        return userDetail;
    }

    private static User InputFromUser(UserService userService, User userDetail) {
        System.out.println("First Name");
        String firstName = UserInput.getString();

        userDetail.firstName = userService.checkFieldValidation(UserRegistrationValidator.ValidatePattern.NAME, firstName, "First Name");

        System.out.println("Last Name");
        String lastName = UserInput.getString();
        userDetail.lastName = userService.checkFieldValidation(UserRegistrationValidator.ValidatePattern.NAME, lastName, "Last Name");

        System.out.println("Password");
        String password = UserInput.getString();
        userDetail.password = userService.checkFieldValidation(UserRegistrationValidator.ValidatePattern.PASSWORD, password, "Password");

        System.out.println("phoneNo");
        String phoneNumber = UserInput.getString();
        userDetail.phoneNumber = userService.checkFieldValidation(UserRegistrationValidator.ValidatePattern.MOBILE, phoneNumber, "phoneNo");
        return userDetail;
    }
}




