package com.bridgelabs.repositery;

import com.bridgelabs.model.User;
import java.sql.*;

public class UserRepo {
    public static final String INSERT_User_QUERY = "insert into UserDetails( first_name, last_name, emailId, password, phone_number ) values (?,?,?,?,?)";
    private static final String SELECT_User_QUERY = "select count(*) AS total from UserDetails where emailId = ? and password = ?";
    private static final String QUERY = "select count(*) AS total from UserDetails where emailId = ? ";
    private static final String UPDATE_User = "Update UserDetails set password = ?, phone_number = ?, first_name =?, last_name = ? where emailId = ?";
    private static final String DELETE_User = "delete from UserDetails where emailId=?";

    public final static String DB_URL = "jdbc:mysql://localhost:3306/world";
    public final static String DB_USERNAME = "root";
    public final static String DB_PASSWORD = "admin";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public void addUser(User user) {
        try (Connection con = UserRepo.getConnection();
             PreparedStatement stmt = con.prepareStatement(INSERT_User_QUERY)) {
            int counter = 1;
            stmt.setString(counter++, user.getFirstName());
            stmt.setString(counter++, user.getLastName());
            stmt.setString(counter++, user.getEmailId());
            stmt.setString(counter++, user.getPassword());
            stmt.setString(counter, user.getPhoneNumber());
            stmt.executeUpdate();
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
            stmt.setString(counter++, user.getPhoneNumber());
            stmt.setString(counter++, user.getFirstName());
            stmt.setString(counter++, user.getLastName());
            stmt.setString(counter, user.getEmailId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int findByEmailId(User user) {
            int count = 0;
            try (Connection con = UserRepo.getConnection();
                 PreparedStatement stmt = con.prepareStatement(QUERY)) {
                int counter = 1;
                stmt.setString(counter, user.emailId);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    count = rs.getInt("total");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return count;
        }

        public void deleteUser(User user) {
            try (Connection con = UserRepo.getConnection();
                 PreparedStatement stmt = con.prepareStatement(DELETE_User)) {
                int counter = 1;
                stmt.setString(counter, user.getEmailId());
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public int getmailIdAndPassword(User user) {

            int count = 0;
            try (Connection con = UserRepo.getConnection();
                 PreparedStatement stmt = con.prepareStatement(SELECT_User_QUERY)) {
                int counter = 1;
                stmt.setString(counter++, user.emailId);
                stmt.setString(counter, user.password);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    count = rs.getInt("total");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return count;
    }
}


