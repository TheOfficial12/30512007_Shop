/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg30512007_shop;

/**
 *
 * @author 30512007
 */
public class Product {
    
    private int productId;
    private String productName;
    private double price;
    private int stockLevel;
    
    
    public Product() 
    {
        
    }
    
    public Product (String productNameIn, double priceIn, int stockLevelIn)
    {
        productId = 0;
        productName = productNameIn;
        price = priceIn;
        stockLevel = stockLevelIn;               
    }
    
    public Product (int productIdIn, String productNameIn, double priceIn, int stockLevelIn)
    {
        productId = productIdIn;
        productName = productNameIn;
        price = priceIn;
        stockLevel = stockLevelIn;
    }
    
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
    
}
