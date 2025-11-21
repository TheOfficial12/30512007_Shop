package models; // Your package declaration

import java.util.ArrayList; // Import ArrayList for the lists


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Create an instance of DBManager
        DBManager dbManager = new DBManager();

        // --- Test loading customers ---
        System.out.println("--- Loading Customers ---");
        ArrayList<Customer> loadedCustomers = dbManager.loadCustomers();

        // Check if any customers were loaded
        if (loadedCustomers.isEmpty()) {
            System.out.println("No customers found or error occurred.");
        } else {
            // Print details of each loaded customer
            for (Customer cust : loadedCustomers) {
                // Use the correct getter method name from your User class
                System.out.println("Loaded Customer: " + cust.getFirstName() + " " + cust.getLastName() + " (" + cust.getUsername() + ")");
            }
        }
        System.out.println("--------------------------\n");


        // --- Test loading staff ---
        System.out.println("--- Loading Staff ---");
        ArrayList<Staff> loadedStaff = dbManager.loadStaff();

        // Check if any staff were loaded
        if (loadedStaff.isEmpty()) {
            System.out.println("No staff found or error occurred.");
        } else {
            // Print details of each loaded staff member
            for (Staff staff : loadedStaff) {
                 // Use the correct getter method name from your User class
                System.out.println("Loaded Staff: " + staff.getFirstName() + " " + staff.getLastName() + " (" + staff.getUsername() + "), Position: " + staff.getPosition());
            }
        }
        System.out.println("-----------------------");
    }
}