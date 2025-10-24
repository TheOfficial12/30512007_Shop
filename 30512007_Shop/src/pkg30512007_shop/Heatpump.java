/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg30512007_shop;

/**
 *
 * @author 30512007
 */
public class Heatpump extends Product{
    
    private double efficiencyRating;
    
    public Heatpump()
    {
        
    }
    
    public Heatpump(String productNameIn, double priceIn, int stockLevelIn, double efficiencyRatingIn)
    {
        super (productNameIn, priceIn, stockLevelIn);
        efficiencyRating = efficiencyRatingIn;
    }
    
    public Heatpump(int productIdIn, String productNameIn, double priceIn, int stockLevelIn, double efficiencyRatingIn)
    {
        super (productIdIn, productNameIn, priceIn, stockLevelIn);
        efficiencyRating = efficiencyRatingIn;
    }
    
    public double getEfficiencyRating()
    {
        return efficiencyRating;
    }
    public void setEfficiencyRating(double efficiencyRatingIn)
    {
        efficiencyRating = efficiencyRatingIn;
    }
    
}
