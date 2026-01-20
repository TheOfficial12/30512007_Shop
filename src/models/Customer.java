/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author 30512007
 */
public class Customer extends User { // Inherits User features

    private String addressLine1;
    private String addressLine2;
    private String town;
    private String postcode;
    private boolean isRegistered;
    
    // Store orders by ID
    private HashMap <Integer, Order> orders;
    
    // List for card nums
    private LinkedList<String> cardNumbers;
    
    
    public Customer()
    {
        super (); // Call parent constructor
        orders = new HashMap<>(); //Init order Map
        cardNumbers= new LinkedList<>(); //Init card list   
    }
    
    //constructor with all details
    public Customer (String usernameIn, String passwordIn, String firstNameIn, String lastNameIn, String addressLine1In, 
            String addressLine2In, String townIn, String postcodeIn)
    {
        
        super(usernameIn, passwordIn, firstNameIn, lastNameIn); //pass user details to parent
        addressLine1 = addressLine1In;
        addressLine2 = addressLine2In;
        town = townIn;
        postcode = postcodeIn;
        isRegistered = true;
        
        //Init lists
        orders = new HashMap<>();
        cardNumbers = new LinkedList();
    }
    
    //Get/Set Orders
    public HashMap <Integer, Order> getOrders()
    {
        return orders;
    }
    public void setOrders(HashMap<Integer, Order> ordersIn)
    {
        this.orders = ordersIn;
    }
    
    //Get/Set Address line1
    public String getAddressLine1()
    {
        return addressLine1;
    }
    public void setAddressLine1 (String addressLine1In)
    {
        addressLine1 = addressLine1In;
    }
    
    //Get/Set Address Line 2
    public String getAddressLine2()
    {
        return addressLine2;
    }
    public void setAddressLine2(String addressLine2In)
    {
        addressLine2 = addressLine2In;
    }
    
    // Get/Set Town
    public String getTown()
    {
        return town;
    }
    public void setTown(String townIn)
    {
        town = townIn;
    }
    
    // Get/Set Postcode
    public String getPostcode()
    {
        return postcode;
    }
    public void setPostcode(String postcodeIn)
    {
        postcode = postcodeIn;
    }
    
    // Check if registered 
    public boolean getIsRegistered ()
    {
        return isRegistered;
    }
    public void setIsRegistered(boolean isRegisteredIn)
    {
        isRegistered = isRegisteredIn;
    }
    
    //Add Card to list
    public void addCard (String cardNo)
    {
        cardNumbers.add(cardNo);
    }
    
    //Remove card by index
    public void removeCard (int nodeNo)
    {
        cardNumbers.remove(nodeNo);
    }
    
    //Add card to the first of the list
    public void addFirstCard(String cardNo)
    {
        cardNumbers.addFirst(cardNo);
    }
    
    //Get all cardss
    public LinkedList<String> getCardNumbers()
    {
        return cardNumbers;
    }
}
