package models;

/**
 * Heat pump subclass.
 * @author 30512007
 */
public class Heatpump extends Product { // Inherit the product class
    
    //Specific to the heatpump
    private double efficiencyRating;
    
    //Empty constructor
    public Heatpump()
    {
        
    }
    
    //Create constructor with no ID
    public Heatpump(String productNameIn, double priceIn, int stockLevelIn, double efficiencyRatingIn)
    {
        super (productNameIn, priceIn, stockLevelIn);
        efficiencyRating = efficiencyRatingIn;
    }
    
    //COnstructor with ID
    public Heatpump(int productIdIn, String productNameIn, double priceIn, int stockLevelIn, double efficiencyRatingIn)
    {
        super (productIdIn, productNameIn, priceIn, stockLevelIn);
        efficiencyRating = efficiencyRatingIn;
    }
    
    //GEt/Set efficiency
    public double getEfficiencyRating()
    {
        return efficiencyRating;
    }
    public void setEfficiencyRating(double efficiencyRatingIn)
    {
        efficiencyRating = efficiencyRatingIn;
    }
    
    // Display string for lists
    @Override
    public String toString() {
   
        return getProductName() + " - £" + String.format("%.2f", getPrice());
    }
}

