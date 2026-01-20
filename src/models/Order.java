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
 *
 * @author 30512007
 */
public class Order {
    
    private int orderId;
    private Date orderDate;
    private double orderTotal;
    private String status;
    //Hashmap,Data_Type_Of_Key
    //Integer - orderLineId
    private HashMap<Integer,OrderLine> orderLines;
    private String paymentCard;
    
    //Getters and Setters
    
    //Getter
    public int getOrderId()
    {
        return orderId;
    }
    //Setter
    public void setOrderId(int orderIdIn)
    {
        orderId = orderIdIn;
    }
    
    //Getter
    public Date getOrderDate()
    {
        return orderDate;
    }
    //Setter
    public void setOrderDate (Date orderDateIn)
    {
        orderDate = orderDateIn;
    }
    
    //Getter
    public double getOrderTotal()
    {
        return orderTotal;
    }
    //Setter
    public void setOrderTotal (double orderTotalIn)
    {
        orderTotal = orderTotalIn;
    }
    
    //Getter
    public String getStatus()
    {
        return status;
    }
    //Setter
    public void setStatus (String statusIn)
    {
        status = statusIn;
    }
    
    //Getter
    public HashMap<Integer,OrderLine> getOrderLines()
    {
        return orderLines;
    }
    //Setter
    public void setOrderLines (HashMap<Integer,OrderLine> orderLinesIn)
    {
        orderLines = orderLinesIn;
    }
    
    //Get/Set for payment card
    public String getPaymentCard()
    {
        return paymentCard;
    }
    public void setPaymentCard(String paymentCard)
    {
        this.paymentCard = paymentCard;
    }
    
    //Constructor - 0 parameter
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
    
        public void addOrderLine(OrderLine orderLineIn)
    {
        // Add the new line to the HashMap using its ID as the key
        orderLines.put(orderLineIn.getOrderLineId(), orderLineIn);
        
        // Automatically update the order's total price
        orderTotal += orderLineIn.getLineTotal();
    }
        
        public void calculateOrderTotal()
        {
           double total = 0;

            for (OrderLine ol : orderLines.values())
            {
                // Add the line's total to the running total
                total = total + ol.getLineTotal();
            }
    
            // Set the class's orderTotal attribute to the final calculated value
            this.orderTotal = total;
        }
    
    public void removeOrderLine(int productId)
    {
        // Create an Iterator to safely loop through the basket
        Iterator<Map.Entry<Integer, OrderLine>> iter = orderLines.entrySet().iterator();
        while (iter.hasNext())
        {
            Map.Entry<Integer, OrderLine> olEntry = iter.next();
            OrderLine currentLine = olEntry.getValue();
            
            // Check if this line contains the product we selected
            if(currentLine.getProductBought().getProductId() == productId)
            {
                //We found the product inside this line! Remove the whole line.
                iter.remove();
            
                // Deduct the cost of that line from the total
                this.orderTotal = this.orderTotal - currentLine.getLineTotal();
            }
            
        }
    }
}
