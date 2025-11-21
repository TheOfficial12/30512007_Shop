/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author 30512007
 */
public class User {
    
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    
    public User()
    {
        
    }
    
    public User (String usernameIn, String passwordIn, String firstNameIn, String lastNameIn)
    {
        username = usernameIn;
        password = passwordIn;
        firstName = firstNameIn;
        lastName = lastNameIn;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String usernameIn)
    {
        username = usernameIn;
    }
    
        public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String passwordIn)
    {
        password = passwordIn;
    }
    
        public String getFirstName()
    {
        return firstName;
    }
    
    public void setFirstName(String firstNameIn)
    {
        firstName = firstNameIn;
    }
    
        public String getLastName()
    {
        return lastName;
    }
    
    public void setLastName(String lastNameIn)
    {
        lastName = lastNameIn;
    }
    
    
    
    
}
