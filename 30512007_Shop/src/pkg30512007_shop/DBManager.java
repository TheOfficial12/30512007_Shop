/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg30512007_shop;


import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author 30512007
 */
public class DBManager {
    
    private static final String DB_URL = "jdbc:ucanaccess://Data/ShopDB.accdb";
    
    public ArrayList<Customer> loadCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        Connection conn = null; // Declare variables outside try
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(DB_URL); // Connect
            stmt = conn.createStatement(); // Create statement
            rs = stmt.executeQuery("SELECT * FROM Customers"); // Run query

            // Loop through results
            while (rs.next()) {
                // **IMPORTANT:** Check your Access DB column names match these!
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String address1 = rs.getString("AddressLine1");
                String address2 = rs.getString("AddressLine2");
                String town = rs.getString("Town");
                String postcode = rs.getString("Postcode");

                // Create and add customer
                Customer customer = new Customer(username, password, firstName, lastName, address1, address2, town, postcode);
                customers.add(customer);
            }

        } catch (SQLException e) {
            System.err.println("Error loading customers: " + e.getMessage()); // Basic error message
        } finally {
            // Manually close resources in reverse order
            try { if (rs != null) rs.close(); } catch (SQLException e) { /* Ignore */ }
            try { if (stmt != null) stmt.close(); } catch (SQLException e) { /* Ignore */ }
            try { if (conn != null) conn.close(); } catch (SQLException e) { /* Ignore */ }
        }
        return customers;
        
    }

    public ArrayList<Staff> loadStaff() {
        ArrayList<Staff> staffList = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Staff");

            while (rs.next()) {
                // **IMPORTANT:** Check your Access DB column names match these!
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String position = rs.getString("Position");
                double salary = rs.getDouble("Salary");

                // Create and add staff
                Staff staffMember = new Staff(username, password, firstName, lastName, position, salary);
                staffList.add(staffMember);
            }

        } catch (SQLException e) {
            System.err.println("Error loading staff: " + e.getMessage());
        } finally {
            // Manually close resources
            try { if (rs != null) rs.close(); } catch (SQLException e) { /* Ignore */ }
            try { if (stmt != null) stmt.close(); } catch (SQLException e) { /* Ignore */ }
            try { if (conn != null) conn.close(); } catch (SQLException e) { /* Ignore */ }
        }
        return staffList;
    
       
    }
    
}
