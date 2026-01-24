/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *Staff User subclass.
 * Represents employees with specific roles and salary info.
 * @author 30512007
 */
public class Staff extends User{
    
    private String position;
    private double salary;
    
    //Constructors Default
    public Staff()
    {
        
    }
    
    //Constructor with full details.
    public Staff (String usernameIn, String passwordIn, String firstNameIn, String lastNameIn, String positionIn, double salaryIn)
    {
        super (usernameIn, passwordIn, firstNameIn, lastNameIn);
        position = positionIn;
        salary = salaryIn;
    }
    
    //Getters and setters
    public String getPosition()
    {
        return position;
    }
    public void setPosition (String positionIn)
    {
        position = positionIn;
    }
    
    public double getSalary ()
    {
        return salary;
    }
    public void setSalary(double salaryIn)
    {
        salary = salaryIn;
    }
    
}
