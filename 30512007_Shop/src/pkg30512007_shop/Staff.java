/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg30512007_shop;

/**
 *
 * @author 30512007
 */
public class Staff extends User{
    
    private String position;
    private double salary;
    
    public Staff()
    {
        
    }
    
    public Staff (String usernameIn, String passwordIn, String firstNameIn, String lastNameIn, String positionIn, double salaryIn)
    {
        super (usernameIn, passwordIn, firstNameIn, lastNameIn);
        position = positionIn;
        salary = salaryIn;
    }
    
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
