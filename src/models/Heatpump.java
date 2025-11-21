package models;

/**
 * UPDATED: Class name changed back to 'Heatpump' (lowercase p) to match file name.
 * Added the required toString() method.
 * @author 30512007
 */
public class Heatpump extends Product { // Note the class name change
    
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
    

    @Override
    public String toString() {
   
        return getProductName() + " - £" + String.format("%.2f", getPrice());
    }
}

