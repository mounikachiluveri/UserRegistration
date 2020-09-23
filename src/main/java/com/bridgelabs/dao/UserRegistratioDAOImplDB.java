package com.bridgelabs.dao;

import com.bridgelabs.model.User;
import com.bridgelabs.repositery.UserRepo;

import java.sql.*;

import static com.bridgelabs.utility.UserInputOutput.*;

public class UserRegistratioDAOImplDB implements IUserRegistationDAO {
    public static final String INSERT_User_QUERY = "insert into User( first_name, last_name, password, emailId, phone_number ) values (?,?,?,?,?)";
    private static final String SELECT_User_QUERY = "select * from User";
    private static final String QUERY = "select count(*) AS total from User where first_name = ? and last_name = ?";
    private static final String UPDATE_User = "Update User set password = ?, emailId = ?, phone_number = ? where first_name = ? and last_name = ?";
    private static final String DELETE_User = "delete from User where first_name = ? and last_name = ?";

    public void addUser(User user) {
        try (Connection con = UserRepo.getConnection();
             PreparedStatement stmt = con.prepareStatement(INSERT_User_QUERY)) {
            int counter = 1;
            stmt.setString(counter++, user.getFirstName());
            stmt.setString(counter++, user.getLastName());
            stmt.setString(counter++, user.getPassword());
            stmt.setString(counter++, user.getEmailId());
            stmt.setString(counter, user.getPhoneNumber());
            stmt.executeUpdate();
            System.out.println("Registration successfully");
        } catch (SQLException e) {
            System.out.println("Exception");
            e.printStackTrace();
        }
    }

    public void editUser(User user) {
        try (Connection con = UserRepo.getConnection();
             PreparedStatement stmt = con.prepareStatement(UPDATE_User)) {
            int counter = 1;
            stmt.setString(counter++, user.getPassword());
            stmt.setString(counter++, user.getEmailId());
            stmt.setString(counter++, user.getPhoneNumber());
            stmt.setString(counter++, user.getFirstName());
            stmt.setString(counter, user.getLastName());
            stmt.executeUpdate();
            System.out.println("Record Updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int findByFirstNameAndLastName(User user) {
        int count = 0;
        try (Connection con = UserRepo.getConnection();
             PreparedStatement stmt = con.prepareStatement(QUERY)) {
            int counter = 1;
            stmt.setString(counter++, user.getFirstName());
            stmt.setString(counter, user.getLastName());
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
    public void deleteUser(User user) {
        try (Connection con = UserRepo.getConnection();
             PreparedStatement stmt = con.prepareStatement(DELETE_User)) {
            int counter = 1;
            stmt.setString(counter++, user.getFirstName());
            stmt.setString(counter, user.getLastName());
            stmt.executeUpdate();
            System.out.println("Record deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loginUser(User user) {
        try (Connection con = UserRepo.getConnection();
             PreparedStatement stmt = con.prepareStatement(SELECT_User_QUERY)) {
            ResultSet rs = stmt.executeQuery();
            String databaseEmail;
            String databasePassword;
            while (rs.next()) {
                databaseEmail = rs.getString("emailId");
                databasePassword = rs.getString("password");
                if ((user.getEmailId().equals(databaseEmail)) && (user.getPassword().equals(databasePassword))) {
                    System.out.println("login successfully");
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
