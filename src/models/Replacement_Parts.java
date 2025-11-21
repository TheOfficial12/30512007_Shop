package models;

/*
 * @author 30512007
 */
public class Replacement_Parts extends Product {
    
    
    private String partFor;

    // Getters and Setters
    
    public String getPartFor() {
        return partFor;
    }

    public void setPartFor(String partFor) {
        this.partFor = partFor;
    }
    
    // --- Constructors ---

    public Replacement_Parts() {
        super();
        this.partFor = "";
    }


    public Replacement_Parts(String productName, double price, int stockLevel, String partFor) {
      
        super(productName, price, stockLevel); 
        this.partFor = partFor;
    }


    public Replacement_Parts(int productId, String productName, double price, int stockLevel, String partFor) {
      
        super(productId, productName, price, stockLevel); 
        this.partFor = partFor;
    }
    

    @Override
    public String toString() {
        // Example: "Filter (for Heat Pump) - £25.99"
        return String.format("%s (for %s) - £%.2f", 
                this.getProductName(), 
                this.partFor, 
                this.getPrice());
    }
}