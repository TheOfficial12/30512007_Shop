package models;
import java.sql.Connection; // Import Connection
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement; // Import Statement
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author 30512007
 */
public class DBManager {

    private static final String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    private static final String DB_URL = "jdbc:ucanaccess://Data/ShopDB.accdb";

    public void unregisterCustomer(String username)
    {
        String sqlDeleteOrderLine = "DELETE FROM OrderLines WHERE OrderId IN (SELECT OrderId FROM Orders WHERE Username=?)";
        String sqlDeleteOrders = "DELETE FROM Orders WHERE Username = ?";
        String sqlDeleteCustomer = "DELETE FROM Customers WHERE Username = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL))
        {
            //OrderLines
            try (PreparedStatement stmt = conn.prepareStatement(sqlDeleteOrderLine))
            {
                stmt.setString(1,username);
                stmt.executeUpdate();
            }
            
            //Orders
            try (PreparedStatement stmt = conn.prepareStatement(sqlDeleteOrders))
            {
                stmt.setString(1, username);
                stmt.executeUpdate();
            }
            
            //Customer
            try(PreparedStatement stmt = conn.prepareStatement(sqlDeleteCustomer))
            {
                stmt.setString(1,username);
                stmt.executeUpdate();
            }
        }
        catch (SQLException ex) 
        {
            System.err.println("Error unregistering customer: " + ex.getMessage());
        }
    }

    public void deleteProduct(int productId)
    {
        String sql = "DELETE FROM Products WHERE ProductId=(?)";
        try(Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, productId);

            stmt.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println("Error print message:"+ex.getMessage());
        }
    }

    public ArrayList<Customer> loadCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();

        // This is "try-with-resources". It's much simpler!
        // It automatically declares and closes conn, stmt, and rs.
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Customers")) {

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
        }
        // No 'finally' block needed to close connections!

        return customers;
    }

    public ArrayList<Staff> loadStaff() {
        ArrayList<Staff> staffList = new ArrayList<>();

        // Using "try-with-resources" here too
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Staff")) {

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
        }

        return staffList;
    }
    

    public HashMap<Integer, Order> loadOrders(String username) {
        HashMap<Integer, Order> orders = new HashMap<>();
        String sql = "SELECT * FROM Orders WHERE Username = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
             stmt.setString(1, username);
             try (ResultSet rs = stmt.executeQuery())
             {
                while (rs.next()) 
                {
                    int orderId = rs.getInt("OrderId");
                    java.util.Date orderDate = new java.util.Date(rs.getDate("OrderDate").getTime());
                    double orderTotal = rs.getDouble("OrderTotal");
                    String status = rs.getString("Status");
                    Order order = new Order(orderId, orderDate, orderTotal, status);
                    orders.put(orderId, order);
                }
             }

        } catch (SQLException e) {
            System.out.println("Error loading orders: " + e.getMessage());
        }

        return orders;
    }
       

    public ArrayList<Product> loadProducts() {
        ArrayList<Product> allProducts = new ArrayList<>();


        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Products")) {

            while (rs.next()) {
                 //All common and specific data
                int productId = rs.getInt("ProductID");
                String productName = rs.getString("ProductName");
                double price = rs.getDouble("Price");
                int stockLevel = rs.getInt("StockLevel");
                String category = rs.getString("ProductType");
                double efficiency = rs.getDouble("EfficiencyRating");
                int wattage = rs.getInt("WattageOutput");
                String partFor = rs.getString("PartFor");


                if (category != null && category.equalsIgnoreCase("Heat Pump")) {
                    // Create Heatpump, passing the efficiency data
                    Heatpump hp = new Heatpump(productId, productName, price, stockLevel, efficiency);
                    allProducts.add(hp);
                }
                // --- FIX 2: Changed "SolarPanel" to "Solar Panel" (with space) ---
                else if (category != null && category.equalsIgnoreCase("Solar Panel")) {
                    // Create SolarPanel, passing the wattage data
                    SolarPanel sp = new SolarPanel(productId, productName, price, stockLevel, wattage);
                    allProducts.add(sp);
                }
                else if (category != null && category.equalsIgnoreCase("Replacement_Parts")) {
                    // Create Replacement_Parts object
                    Replacement_Parts rp = new Replacement_Parts(productId, productName, price, stockLevel, partFor);
                    allProducts.add(rp);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error loading products: " + e.getMessage());
        }

        return allProducts;
    }


    public Customer customerLogin(String username, String password) {
        ArrayList<Customer> customers = loadCustomers(); // Get all customers
        for (Customer c : customers) { // Loop through them
            // Check username AND password match
            if (username.equals(c.getUsername()) && password.equals(c.getPassword())) {
                return c; // Found a match, return the customer
            }
        }
        return null; // No match found
    }

    public Staff staffLogin(String username, String password) {
        ArrayList<Staff> staffList = loadStaff(); // Get all staff
        for (Staff s : staffList) { // Loop through them
            // Check username AND password match
            if (s.getUsername().equals(username) && s.getPassword().equals(password)) {
                return s; // Found a match, return the staff member
            }
        }
        return null; // No match found
    }

    public int saveOrder(Order order, String username) {


        // SQL query to insert data into the Orders table
        String sql = "INSERT INTO Orders (OrderDate, OrderTotal, Status, Username, CardNumber) VALUES (?, ?, ?, ?,?)";

        int orderId = 0;

        // Using try-with-resources for the connection and statement
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // Convert date database
            java.sql.Date sqlDate = new java.sql.Date(order.getOrderDate().getTime());

            // Set the parameters for the query
            stmt.setDate(1, sqlDate);
            stmt.setDouble(2, order.getOrderTotal());
            stmt.setString(3, "Complete"); // Set a default status
            stmt.setString(4, username);    // The logged-in customer's username [cite: 25]
            stmt.setString(5, order.getPaymentCard());
            // Execute the update
            int rowsAffected = stmt.executeUpdate();

            // If rowsAffected > 0, the insert was successful
            if (rowsAffected > 0)
            {
                try (ResultSet rs = stmt.getGeneratedKeys())
                {
                    if (rs.next())
                    {
                        orderId = rs.getInt(1);
                        order.setOrderId(orderId);
                    }
                }
            }

        } catch (SQLException e)
        {
            System.err.println("Error saving order to database: " + e.getMessage());
            return 0; // Return faalse if an error occurred
        }

            return orderId;

    }

   public void writeOrderLine (OrderLine ol, int orderId)
   {
       String sql = "INSERT INTO ORDERLINES (ProductId, Quantity, LineTotal, OrderId) VALUES (?,?,?,?)";
       try(Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(sql))
       {
           stmt.setInt(1,ol.getProductBought().getProductId());
           stmt.setInt(2,ol.getQuantity());
           stmt.setDouble(3,ol.getLineTotal());
           stmt.setInt(4,orderId);

           stmt.executeUpdate();
       }
       catch(Exception ex)
       {
           System.err.println("Error saving order line to database: " + ex.getMessage());
       }
   }

    public boolean updateStockLevel(Product product, int quantityPurchased) {


        int newStockLevel = product.getStockLevel() - quantityPurchased;


        String sql = "UPDATE Products SET StockLevel = ? WHERE ProductID = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set the parameters
            stmt.setInt(1, newStockLevel);
            stmt.setInt(2, product.getProductId());

            // Execute the update
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error updating stock for ProductID " + product.getProductId() + ": " + e.getMessage());
            return false;
        }
    }
    
    public boolean updateProduct (Product p)
    {
        String sql ="UPDATE Products SET ProductName = ?, Price = ?, StockLevel = ?, ProductType = ?, WattageOutput = ?, EfficiencyRating = ?, PartFor = ? WHERE ProductId = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, p.getProductName());
            stmt.setDouble(2, p.getPrice());
            stmt.setInt(3, p.getStockLevel());
            
            if(p instanceof SolarPanel)
            {
                stmt.setString(4, "Solar Panel");
                stmt.setInt(5, ((SolarPanel) p).getWattageOutput()); // Wattage
                stmt.setObject(6, null); // null
                stmt.setObject(7, null);
            }
            else if (p instanceof Heatpump)
            {
                stmt.setString(4, "Heat Pump");
                stmt.setObject(5, null); // null
                stmt.setDouble(6, ((Heatpump) p).getEfficiencyRating()); // Efficiency
                stmt.setObject(7, null); // null
            }
            else if (p instanceof Replacement_Parts)
            {
                stmt.setString(4, "Replacement_Parts");
                stmt.setObject(5, null); 
                stmt.setObject(6, null); 
                stmt.setString(7, ((Replacement_Parts) p).getPartFor());
            }
            stmt.setInt(8, p.getProductId());

            int rows = stmt.executeUpdate();
            return rows > 0;
        }
        catch (SQLException e)
        {
            System.out.println("Error updating product: " + e.getMessage());
            return false;
        }
    }
    
    public boolean updateCustomer(Customer c)
    {
        String sql = "UPDATE Customers SET Password = ?, FirstName = ?, LastName = ?, AddressLine1 = ?, AddressLine2 = ?, Town = ?, Postcode = ? WHERE Username = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, c.getPassword());
            stmt.setString(2,c.getFirstName());
            stmt.setString(3, c.getLastName());
            stmt.setString(4,c.getAddressLine1());
            stmt.setString(5, c.getAddressLine2());
            stmt.setString(6, c.getTown());
            stmt.setString(7, c.getPostcode());
            stmt.setString(8, c.getUsername());
            int rows = stmt.executeUpdate();
            return rows > 0;
        }
        catch (SQLException e)
        {
            System.out.println("Error updating product: " + e.getMessage());
            return false;
        }
    }
    
    public boolean registerCustomer (Customer c)
    {
        String sql = "INSERT INTO Customers (Username, Password, FirstName, LastName, AddressLine1, AddressLine2, Town, Postcode) VALUES (?,?,?,?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString (1,c.getUsername());
            stmt.setString(2, c.getPassword());
            stmt.setString(3, c.getFirstName());
            stmt.setString(4,c.getLastName());
            stmt.setString(5, c.getAddressLine1());
            stmt.setString(6,c.getAddressLine2());
            stmt.setString(7,c.getTown());
            stmt.setString(8,c.getPostcode());
            
            int rows = stmt.executeUpdate();
            return rows>0;
        }
        catch(SQLException e)
        {
            System.out.println("Error registering customer: " + e.getMessage());
            return false;
        }
    }
}


