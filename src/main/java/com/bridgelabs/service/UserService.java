package com.bridgelabs.service;

import com.bridgelabs.controller.UserRegistration;
import com.bridgelabs.model.User;
import com.bridgelabs.repositery.UserRepo;
import com.bridgelabs.utility.UserInput;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    UserRepo userRepo = new UserRepo();

    public String checkFieldValidation(UserRegistrationValidator.ValidatePattern pattern, String input, String type)
    {
        while(UserRegistrationValidator.validateInput(input, pattern)){
            System.out.println("Invalid "+type+" please re-enter");
            input = UserInput.getString();
        }
        return input;
    }

    public void addUser(User userDetail) {
        userRepo.addUser(userDetail);
    }

    public int findByEmailId( User userDetail) {
       return userRepo.findByEmailId(userDetail);
    }

    public void updateUser(User userDetail) {
        userRepo.editUser(userDetail);
    }
    public void deleteUser(User userDelete) {
        userRepo.deleteUser(userDelete);
    }

    public String loginUser( User userData ) {
        String message = "Enter Valid email and password";

        if(userRepo.getmailIdAndPassword(userData) == 1 ) {
            message = "successfully login";
            return message;
        }
        return message;
    }
}

