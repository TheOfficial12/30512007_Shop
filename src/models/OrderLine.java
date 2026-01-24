/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;


    
/**
 *Represents a single line item in an order.
 * Links a product to a specific quantity and calculated price.
 * @author 30512007
 */
public class OrderLine {
    private int orderLineId;
    private Product productBought;
    private int quantity;
    private double lineTotal;
    
    //Getters and Setters
    
    public int getOrderLineId()
    {
        return orderLineId;
    }
    public void setOrderLineId (int orderLineIdIn)
    {
        orderLineId = orderLineIdIn;
    }
    
    public Product getProductBought()
    {
        return productBought;
    }
    public void setProductBought (Product productBoughtIn)
    {
        productBought = productBoughtIn;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    public void setQuantity (int quantityIn)
    {
        quantity = quantityIn;
    }
    
    public double getLineTotal()
    {
        return lineTotal;
    }
    public void setLineTotal (double lineTotalIn)
    {
        lineTotal = lineTotalIn;
    }
    
    //Constructor - all parameters
    public OrderLine (int orderLineIdIn, Product productBoughtIn, int quantityIn, double lineTotalIn)
    {
        orderLineId = orderLineIdIn;
        productBought = productBoughtIn;
        quantity = quantityIn;
        lineTotal = lineTotalIn;
    }
    
    //Constructor - everything except lineTotal
        public OrderLine (int orderLineIdIn, Product productBoughtIn, int quantityIn)
    {
        orderLineId = orderLineIdIn;
        productBought = productBoughtIn;
        quantity = quantityIn;
        lineTotal = productBought.getPrice()*quantityIn;
    }
    
}
