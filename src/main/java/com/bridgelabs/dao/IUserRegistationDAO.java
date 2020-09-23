package com.bridgelabs.dao;

import com.bridgelabs.model.Person;

public interface IUserRegistationDAO {
    void editPerson(Person person);

    void addPerson(Person person);

    int findByFirstNameAndLastName(Person person);

    void deletePerson(Person person);

    void loginPerson(Person person);
}








