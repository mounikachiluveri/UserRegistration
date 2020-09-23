package com.bridgelabs.service;

import com.bridgelabs.dao.IUserRegistationDAO;
import com.bridgelabs.model.User;

public class UserRegistrationServiceImpl implements IUserRegistrationService {
    private final IUserRegistationDAO iUserRegistationDAO;
    private UserRegistrationServiceImpl iUserRegistationDAOUser;

    public UserRegistrationServiceImpl(IUserRegistationDAO iUserRegistationDAO) {
        this.iUserRegistationDAO = iUserRegistationDAO;
    }

    @Override
    public void addUser(User user) {
        this.iUserRegistationDAO.addUser(user);
    }

    @Override
    public void editUser(User user) {
        this.iUserRegistationDAO.editUser(user);
    }

    @Override
    public void deleteUser(User user) {
        this.iUserRegistationDAO.deleteUser(user);
    }

    @Override
    public int findByFirstNameAndLastName(User user) {
        return this.iUserRegistationDAO.findByFirstNameAndLastName(user);
    }

    @Override
    public void loginUser(User user) {
        this.iUserRegistationDAO.loginUser(user);
    }
}

