/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *Represents a customer order.
 * Contains order details and a collection of OrderLine items.
 * @author 30512007
 */
public class Order {
    
    private int orderId;
    private Date orderDate;
    private double orderTotal;
    private String status;
    private String paymentCard;
    
    // Maps OrderLine ID to OrderLine objects for efficient lookup
    private HashMap<Integer,OrderLine> orderLines;

    //Getters and Setters

    public int getOrderId()
    {
        return orderId;
    }
    
    public void setOrderId(int orderIdIn)
    {
        orderId = orderIdIn;
    }
    
    public Date getOrderDate()
    {
        return orderDate;
    }
    public void setOrderDate (Date orderDateIn)
    {
        orderDate = orderDateIn;
    }
    
    public double getOrderTotal()
    {
        return orderTotal;
    }
    public void setOrderTotal (double orderTotalIn)
    {
        orderTotal = orderTotalIn;
    }
    
    public String getStatus()
    {
        return status;
    }
    public void setStatus (String statusIn)
    {
        status = statusIn;
    }
    
    public HashMap<Integer,OrderLine> getOrderLines()
    {
        return orderLines;
    }
    public void setOrderLines (HashMap<Integer,OrderLine> orderLinesIn)
    {
        orderLines = orderLinesIn;
    }
    
    public String getPaymentCard()
    {
        return paymentCard;
    }
    public void setPaymentCard(String paymentCard)
    {
        this.paymentCard = paymentCard;
    }
    
    //Default Constructor
    public Order()
    {
        orderId = 0;
        orderDate = new Date();
        orderTotal = 0;
        status = "";
        orderLines = new HashMap();
    }
    
    //Constructor (Everything except OrderLines)
    public Order(int orderIdIn, Date orderDateIn, double orderTotalIn, String statusIn)
    {
        orderId = orderIdIn;
        orderDate = orderDateIn;
        orderTotal = orderTotalIn;
        status = statusIn;
        orderLines = new HashMap();
    }
    
    //Adds an item to the order and updates the total price.
        public void addOrderLine(OrderLine orderLineIn)
    {
        // Add to map
        orderLines.put(orderLineIn.getOrderLineId(), orderLineIn);
        
        // Update Total
        orderTotal += orderLineIn.getLineTotal();
    }
        
        //Recalculate total costs
        public void calculateOrderTotal()
        {
           double total = 0;

            for (OrderLine ol : orderLines.values())
            {
                total = total + ol.getLineTotal();
            }
    
            this.orderTotal = total;
        }
    //Removes a product from the order and updates the total price.
     //Uses an Iterator to safely remove items while looping.
    public void removeOrderLine(int productId)
    {
        
        Iterator<Map.Entry<Integer, OrderLine>> iter = orderLines.entrySet().iterator();
        while (iter.hasNext())
        {
            Map.Entry<Integer, OrderLine> olEntry = iter.next();
            OrderLine currentLine = olEntry.getValue();
            
            // If product matches, remove line and deduct cost
            if(currentLine.getProductBought().getProductId() == productId)
            {
                iter.remove();
                this.orderTotal = this.orderTotal - currentLine.getLineTotal();
            }
            
        }
    }
}
