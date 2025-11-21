/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author 30512007
 */
public class SolarPanel extends Product{
    
    private int wattageOutput;
    
    public SolarPanel()
    {
        
    }
    
    public SolarPanel(String productNameIn, double priceIn, int stockLevelIn, int wattageOutputIn)
    {
        super (productNameIn, priceIn, stockLevelIn);
        wattageOutput = wattageOutputIn;
    }
    
    public SolarPanel(int productIdIn, String productNameIn, double priceIn, int stockLevelIn, int wattageOutputIn)
    {
        super (productIdIn, productNameIn, priceIn, stockLevelIn);
        wattageOutput = wattageOutputIn;
    }
    
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
   
        return getProductName() + " - £" + String.format("%.2f", getPrice()) + getWattageOutput();
    }
    
}
