/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *Solar Panel subclass.
 * @author 30512007
 */
public class SolarPanel extends Product{
    
    // Specific wattage output
    private int wattageOutput;
    
    //Constructors
    public SolarPanel()
    {
        
    }
    //Constructor without ID.
    public SolarPanel(String productNameIn, double priceIn, int stockLevelIn, int wattageOutputIn)
    {
        super (productNameIn, priceIn, stockLevelIn);
        wattageOutput = wattageOutputIn;
    }
    
    //Constructor with everything
    public SolarPanel(int productIdIn, String productNameIn, double priceIn, int stockLevelIn, int wattageOutputIn)
    {
        super (productIdIn, productNameIn, priceIn, stockLevelIn);
        wattageOutput = wattageOutputIn;
    }
    
    //Getters and Setters
    
    public int getWattageOutput()
    {
        return wattageOutput;
    }
    public void setWattageOutput(int wattageOutputIn)
    {
        wattageOutput = wattageOutputIn;
    }
    
    @Override
    public String toString() {
   
        return getProductName() + " - £" + String.format("%.2f", getPrice()) + " (" + wattageOutput + "W)";
    }
    
}
