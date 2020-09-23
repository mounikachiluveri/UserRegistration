package com.bridgelabs.dao;

import com.bridgelabs.model.User;

public interface IUserRegistationDAO {
    void editUser(User user);
    void addUser(User user);
    int findByFirstNameAndLastName(User user);
    void deleteUser(User user);
    void loginUser(User user);
}








