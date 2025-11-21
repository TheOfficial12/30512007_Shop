/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.HashMap;

/**
 *
 * @author 30512007
 */
public class Customer extends User {

    private String addressLine1;
    private String addressLine2;
    private String town;
    private String postcode;
    private boolean isRegistered;
    private HashMap <Integer, Order> orders;
    
    
    public Customer()
    {
        super ();
        orders = new HashMap<>();
    }
    
    public Customer (String usernameIn, String passwordIn, String firstNameIn, String lastNameIn, String addressLine1In, 
            String addressLine2In, String townIn, String postcodeIn)
    {
        
        super(usernameIn, passwordIn, firstNameIn, lastNameIn);
        addressLine1 = addressLine1In;
        addressLine2 = addressLine2In;
        town = townIn;
        postcode = postcodeIn;
        isRegistered = true;
        orders = new HashMap<>();
    }
    
    public HashMap <Integer, Order> getOrders()
    {
        return orders;
    }
    public void setOrders(HashMap<Integer, Order> ordersIn)
    {
        this.orders = ordersIn;
    }
    
    public String getAddressLine1()
    {
        return addressLine1;
    }
    public void setAddressLine1 (String addressLine1In)
    {
        addressLine1 = addressLine1In;
    }
    
    public String getAddressLine2()
    {
        return addressLine2;
    }
    public void setAddressLine2(String addressLine2In)
    {
        addressLine2 = addressLine2In;
    }
    
    public String getTown()
    {
        return town;
    }
    public void setTown(String townIn)
    {
        town = townIn;
    }
    
    public String getPostcode()
    {
        return postcode;
    }
    public void setPostcode(String postcodeIn)
    {
        postcode = postcodeIn;
    }
    
    public boolean getIsRegistered ()
    {
        return isRegistered;
    }
    public void setIsRegistered(boolean isRegisteredIn)
    {
        isRegistered = isRegisteredIn;
    }
    
    
}
