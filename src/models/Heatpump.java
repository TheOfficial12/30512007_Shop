package models;

/**
 * @author 30512007
 */
public class Heatpump extends Product { // Inherit the product class
    
    //SPecific to the heatpump
    private double efficiencyRating;
    
    //EMpty constructor
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
    
    //GEt/Set rating 
    public double getEfficiencyRating()
    {
        return efficiencyRating;
    }
    public void setEfficiencyRating(double efficiencyRatingIn)
    {
        efficiencyRating = efficiencyRatingIn;
    }
    
    //Show name and price
    @Override
    public String toString() {
   
        return getProductName() + " - £" + String.format("%.2f", getPrice());
    }
}

