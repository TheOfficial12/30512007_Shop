/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *Abstract base class for all products.
 * Defines common attributes like ID, name, price, and stock.
 * @author 30512007
 */
public abstract class Product {
    
    private int productId;
    private String productName;
    private double price;
    private int stockLevel;
    
    
    //Empty constructor
    public Product() 
    {
        
    }
    
    //Constructor everything except product id
    public Product (String productNameIn, double priceIn, int stockLevelIn)
    {
        productId = 0;
        productName = productNameIn;
        price = priceIn;
        stockLevel = stockLevelIn;               
    }
    
    //Constructor with everything
    public Product (int productIdIn, String productNameIn, double priceIn, int stockLevelIn)
    {
        productId = productIdIn;
        productName = productNameIn;
        price = priceIn;
        stockLevel = stockLevelIn;
    }
    
    //Getter and setters
    
    public int getProductId()
    {
        return productId;
    }
        public void setProductId(int productIdIn)
    {
        productId = productIdIn;
    }
    
    public String getProductName()
    {
        return productName;
    }
    public void setProductName(String productNameIn)
    {
        productName = productNameIn;
    }
    
    public double getPrice()
    {
        return price;
    }
    public void setPrice(double priceIn)
    {
        price = priceIn;
    }
    
    public int getStockLevel()
    {
        return stockLevel;
    }
    public void setStockLevel(int stockLevelIn)
    {
        stockLevel = stockLevelIn;
    }
    

    @Override
    public String toString() {
        return this.getProductId() + ": " + this.getProductName() + " - £" + this.price;
    }
    
}
