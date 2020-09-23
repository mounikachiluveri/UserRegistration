package com.bridgelabs.service;

import com.bridgelabs.dao.IUserRegistationDAO;
import com.bridgelabs.model.Person;

public class UserRegistrationServiceImpl implements IUserRegistrationService {
    private final IUserRegistationDAO iUserRegistationDAO;
    private UserRegistrationServiceImpl iUserRegistationDAOUser;

    public UserRegistrationServiceImpl(IUserRegistationDAO iUserRegistationDAO) {
        this.iUserRegistationDAO = iUserRegistationDAO;
    }

    @Override
    public void addPerson(Person person) {

        this.iUserRegistationDAO.addPerson(person);
    }

    @Override
    public void editPerson(Person person) {

        this.iUserRegistationDAO.editPerson(person);
    }

    @Override
    public void deletePerson(Person person) {

        this.iUserRegistationDAO.deletePerson(person);
    }

    @Override
    public int findByFirstNameAndLastName(Person person) {
        return this.iUserRegistationDAO.findByFirstNameAndLastName(person);
    }
    @Override
    public void loginPerson(Person person) {

        this.iUserRegistationDAO.loginPerson(person);
    }
}

