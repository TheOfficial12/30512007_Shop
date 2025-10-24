/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg30512007_shop;

import java.util.Date;
    
/**
 *
 * @author 30512007
 */
public class OrderLine {
    private int orderLineId;
    private Product productBought;
    private int quantity;
    private double lineTotal;
    
    //Getters and Setters
    
    //Getter
    public int getOrderLineId()
    {
        return orderLineId;
    }
    //Setter
    public void setOrderLineId (int orderLineIdIn)
    {
        orderLineId = orderLineIdIn;
    }
    
    
    //Getter
    public Product getProductBought()
    {
        return productBought;
    }
    //Setter
    public void setProductBought (Product productBoughtIn)
    {
        productBought = productBoughtIn;
    }
    
    //Getter
    public int getQuantity()
    {
        return quantity;
    }
    public void setQuantity (int quantityIn)
    {
        quantity = quantityIn;
    }
    
    //Getter
    public double getLineTotal()
    {
        return lineTotal;
    }
    //Setter
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
