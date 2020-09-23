package com.bridgelabs.service;

import com.bridgelabs.dao.UserRegistratioDAOImplDB;
import com.bridgelabs.model.Person;
import com.bridgelabs.utility.PersonInputOutput;
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
                    Person personAdd = PersonInputOutput.getPersonName();
                    personAdd = PersonInputOutput.addPersonRecord(personAdd);
                    iUserRegistrationService.addPerson(personAdd);

                    break;
                case 2:
                    Person personEdit = PersonInputOutput.getPersonName();
                    if (iUserRegistrationService.findByFirstNameAndLastName(personEdit) == 0) {
                        System.out.println("No Data Found");
                    } else {
                        personEdit = PersonInputOutput.addPersonRecord(personEdit);
                        iUserRegistrationService.editPerson(personEdit);
                    }
                    break;

                case 3:
                    Person personDelete = PersonInputOutput.getPersonName();
                    if (iUserRegistrationService.findByFirstNameAndLastName(personDelete) == 0) {
                        System.out.println("No Data Found");
                    } else {
                        iUserRegistrationService.deletePerson(personDelete);
                    }
                    break;
                case 4:
                    Person personLogin = PersonInputOutput.loginPerson();
                    iUserRegistrationService.loginPerson(personLogin);
            }
            break;
        }
    }
}
