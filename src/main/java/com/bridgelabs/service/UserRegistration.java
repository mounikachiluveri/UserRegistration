package com.bridgelabs.service;

import com.bridgelabs.dao.UserRegistratioDAOImplDB;
import com.bridgelabs.model.User;
import com.bridgelabs.utility.UserInputOutput;
import com.bridgelabs.utility.UserInput;

public class UserRegistration {

    public static void main(String[] args) {
        IUserRegistrationService iUserRegistrationService = new UserRegistrationServiceImpl(new UserRegistratioDAOImplDB());
        boolean isContinue = true;
        System.out.println("Welcome UserRegistration program");
        while (isContinue) {
            System.out.println("1)REGISTERUSER   \n2)UPDATEUSER   \n3)DELETEUSER \n4)Login User");
            int select = UserInput.getNumber();
            switch (select) {
                case 1:
                    User userAdd = UserInputOutput.getUserName();
                    userAdd = UserInputOutput.addUserRecord(userAdd);
                    iUserRegistrationService.addUser(userAdd);
                    break;
                case 2:
                    User userEdit = UserInputOutput.getUserName();
                    if (iUserRegistrationService.findByFirstNameAndLastName(userEdit) == 0) {
                        System.out.println("No Data Found");
                    } else {
                        userEdit = UserInputOutput.addUserRecord(userEdit);
                        iUserRegistrationService.editUser(userEdit);
                    }
                    break;

                case 3:
                    User userDelete = UserInputOutput.getUserName();
                    if (iUserRegistrationService.findByFirstNameAndLastName(userDelete) == 0) {
                        System.out.println("No Data Found");
                    } else {
                        iUserRegistrationService.deleteUser(userDelete);
                    }
                    break;
                case 4:
                    User userLogin = UserInputOutput.loginUser();
                    iUserRegistrationService.loginUser(userLogin);
            }
            break;
        }
    }
}
