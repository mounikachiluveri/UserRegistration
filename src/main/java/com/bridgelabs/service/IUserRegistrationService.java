package com.bridgelabs.service;

import com.bridgelabs.model.Person;

public interface IUserRegistrationService {
    int findByFirstNameAndLastName(Person person);
    void addPerson(Person person);
    void editPerson(Person person);
    void deletePerson(Person person);
    void loginPerson(Person person);
}
