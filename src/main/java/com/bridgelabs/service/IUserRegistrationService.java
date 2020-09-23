package com.bridgelabs.service;

import com.bridgelabs.model.User;

public interface IUserRegistrationService {
    int findByFirstNameAndLastName(User user);
    void addUser(User user);
    void editUser(User user);
    void deleteUser(User user);
    void loginUser(User user);
}
