package com.bridgelabs.dao;

import com.bridgelabs.model.Person;
import com.bridgelabs.repositery.UserRepo;
import java.sql.*;
import static com.bridgelabs.utility.PersonInputOutput.*;

public class UserRegistratioDAOImplDB implements IUserRegistationDAO {
    public static final String INSERT_PERSON_QUERY = "insert into person( first_name, last_name, password, emailId, phone_number ) values (?,?,?,?,?)";
    private static final String SELECT_PERSON_QUERY = "select * from person";
    private static final String QUERY = "select count(*) AS total from person where first_name = ? and last_name = ?";
    private static final String UPDATE_PERSON = "Update person set password = ?, emailId = ?, phone_number = ? where first_name = ? and last_name = ?";
    private static final String DELETE_PERSON = "delete from person where first_name = ? and last_name = ?";

    public void addPerson(Person person) {
        try (Connection con = UserRepo.getConnection();
             PreparedStatement stmt = con.prepareStatement(INSERT_PERSON_QUERY)) {
            int counter = 1;
            stmt.setString(counter++, person.getFirstName());
            stmt.setString(counter++, person.getLastName());
            stmt.setString(counter++, person.getPassword());
            stmt.setString(counter++, person.getEmailId());
            stmt.setString(counter, person.getPhoneNumber());
            stmt.executeUpdate();
            System.out.println("Registration successfully");
        } catch (SQLException e) {
            System.out.println("Exception");
            e.printStackTrace();
        }
    }

    public void editPerson(Person person) {
        try (Connection con = UserRepo.getConnection();
             PreparedStatement stmt = con.prepareStatement(UPDATE_PERSON)) {
            int counter = 1;
            stmt.setString(counter++, person.getPassword());
            stmt.setString(counter++, person.getEmailId());
            stmt.setString(counter++, person.getPhoneNumber());
            stmt.setString(counter++, person.getFirstName());
            stmt.setString(counter, person.getLastName());
            stmt.executeUpdate();
            System.out.println("Record Updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int findByFirstNameAndLastName(Person person) {
        int count = 0;
        try (Connection con = UserRepo.getConnection();
             PreparedStatement stmt = con.prepareStatement(QUERY)) {
            int counter = 1;
            stmt.setString(counter++, person.getFirstName());
            stmt.setString(counter, person.getLastName());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                count = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public void deletePerson(Person person) {
        try (Connection con = UserRepo.getConnection();
             PreparedStatement stmt = con.prepareStatement(DELETE_PERSON)) {
            int counter = 1;
            stmt.setString(counter++, person.getFirstName());
            stmt.setString(counter, person.getLastName());
            stmt.executeUpdate();
            System.out.println("Record deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loginPerson(Person person) {
        try (Connection con = UserRepo.getConnection();
             PreparedStatement stmt = con.prepareStatement(SELECT_PERSON_QUERY)) {
            ResultSet rs = stmt.executeQuery();
            String emailIdt = null;
            String passwordt = null;
            while (rs.next()) {
                emailIdt = rs.getString("emailId");
                passwordt = rs.getString("password");
                if ((person.getEmailId().equals(emailIdt)) && (person.getPassword().equals(passwordt))) {
                    System.out.println("login successfully");
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
