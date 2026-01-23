/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import models.DBManager;
import models.Product;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import models.Customer;
import models.Order;
import models.OrderLine;
import javax.swing.Timer;
import javax.swing.UIManager;

/**
 *
 * @author 30512007
 */
public class BrowseProducts extends javax.swing.JFrame {
    
    private final Color BG_DARK = new Color(24, 24, 24); //Background colour
    private final Color BTN_DEFAULT = new Color(50,50,50);
    private final Color ACCENT_GREEN = new Color(0, 210, 90); //Bright green
    private final Color TEXT_WHITE = Color.WHITE;
    private final Color TEXT_BLACK = Color.BLACK;
    
    //Logger
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(BrowseProducts.class.getName());

    //Data Vars
    private ArrayList<Product> allProducts;
    
    private Order currentBasket;
    
    private Customer loggedInCustomer;
    
    
    
    //Empty Constructor
    public BrowseProducts()
    {
        this(new Order(), null);
    }
    
    //Main Constructor
    public BrowseProducts(Order basketIn, Customer customerIn) {
        //Load Products from DB
        DBManager db = new DBManager();
        allProducts = db.loadProducts();
        
        initComponents();
        
        //Save Refs
        this.currentBasket = basketIn;
        this.loggedInCustomer = customerIn;
        
        //Init list empty
        lstProduct.setModel(new DefaultListModel<Product>());
        applyCustomDesign();
        
    }
        private void applyCustomDesign()
    {
        
        this.setLocationRelativeTo(null);
        
        //Background colour
        this.getContentPane().setBackground(BG_DARK);
        
        //Making image label too 100px
        jLabelLogo.setPreferredSize(new Dimension(100,100));
        jLabelLogo.setSize(100,100);
        
        btnAddToBasket.setBorder(UIManager.getBorder("Button.border"));
        btnAddToBasket.setOpaque(false);
        btnAddToBasket.setContentAreaFilled(true);
        btnAddToBasket.setFocusPainted(false);
        btnAddToBasket.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAddToBasket.putClientProperty("FlatLaf.style", 
                "arc: 25;" +
                "borderWidth: 0;" );
        
        
        //Buttons to Opagque and round shape)
        JButton[] btns = {btnBack, btnViewBasket};
        
        for (JButton btn : btns)
        {
            btn.setBorder(UIManager.getBorder("Button.border"));
            
            //Make button rounds
            
            btn.putClientProperty("FlatLaf.style", "arc: 25; borderWidth: 2; borderColor: #00D25A; background: #323232; foreground: #ffffff; focusWidth: 0;");
            
            //Opacity to show colours
            btn.setOpaque(false);
            btn.setContentAreaFilled(true);
            btn.setFocusPainted(false);
            
            //DEFAUlt style
            btn.setBackground(BTN_DEFAULT);
            btn.setForeground(TEXT_WHITE);
            btn.setFont(new Font ("Segoe UI", Font.BOLD, 16));
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            //GREen border
            btn.putClientProperty("JComponent.outline", ACCENT_GREEN);
            
            addHoverEffect(btn);
        }  
        try
        {
            java.net.URL imgURL = getClass().getResource("/views/logo.png");
            if (imgURL != null) {
            ImageIcon originalIcon = new ImageIcon(imgURL);
            //Resize image
            Image scaledImg = originalIcon.getImage().getScaledInstance(61, 69, Image.SCALE_SMOOTH);
            //Apply to label
            jLabelLogo.setPreferredSize(new Dimension(61,69));
            jLabelLogo.setSize(61,69);
            jLabelLogo.setMinimumSize(new Dimension(61,69));
            
            jLabelLogo.setIcon(new ImageIcon(scaledImg));
            jLabelLogo.setHorizontalAlignment(SwingConstants.CENTER);
            this.setIconImage(originalIcon.getImage());
            }
        }
        catch (Exception e)
        {
            System.out.println("Logo image not found" + e.getMessage());
        }
        
        
        //Lists and textbox
        JComponent[] inputs = {jScrollPane1, jScrollPane2, txtQuantity};
        
        for(JComponent input : inputs)
        {
            input.putClientProperty("FlatLaf.style",
                    "arc:15;" +
                    "borderWidth : 2;" +
                    "borderColor: #00D25A;" +
                    "background: #323232; " + 
                    "foreground: #ffffff;");
        }
        txtQuantity.setCaretColor(Color.WHITE);
        txtQuantity.putClientProperty("JComponent.roundRect", true);
        
        JList<?>[] lists = {lstCategories, lstProduct};
        for (JList<?> list : lists)
        {
            //Unselected colour
            list.setBackground(new Color(50,50,50));
            list.setForeground(Color.WHITE);
            
            //When a row is selected
            list.setSelectionBackground(ACCENT_GREEN);
            list.setSelectionForeground(TEXT_BLACK);
            
            list.putClientProperty("FlatLaf.style", "selectionArc: 10; selectionInsets:2, 2, 2, 2;");
        }
    }
    
     private void addHoverEffect(JButton btn)
    {
        btn.addMouseListener(new MouseAdapter()
                {
                    public void mouseEntered(MouseEvent evt)
                {
                    //Hovering on to vibrant green background adnd black text
                    btn.setBackground(ACCENT_GREEN);
                    btn.setForeground(TEXT_BLACK);
                }
                    public void mouseExited (MouseEvent evt)
                {
                    btn.setBackground(BTN_DEFAULT);
                    btn.setForeground(TEXT_WHITE);
                }
                });
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnViewBasket = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCategories = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstProduct = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        btnAddToBasket = new javax.swing.JButton();
        lblConfirmation = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBack.setBackground(new java.awt.Color(24, 24, 24));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BROWSE PRODUCTS");

        btnViewBasket.setBackground(new java.awt.Color(24, 24, 24));
        btnViewBasket.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnViewBasket.setForeground(new java.awt.Color(255, 255, 255));
        btnViewBasket.setText("VIEW BASKET");
        btnViewBasket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewBasketActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CATEGORIES");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PRODUCT");

        lstCategories.setBackground(new java.awt.Color(50, 50, 50));
        lstCategories.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lstCategories.setForeground(new java.awt.Color(255, 255, 255));
        lstCategories.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Heatpump", "SolarPanel", "Replacement_Parts" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstCategories.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstCategoriesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstCategories);

        lstProduct.setBackground(new java.awt.Color(50, 50, 50));
        lstProduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lstProduct.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(lstProduct);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("QUANTITY");

        txtQuantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtQuantity.setForeground(new java.awt.Color(255, 255, 255));
        txtQuantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnAddToBasket.setBackground(new java.awt.Color(0, 210, 90));
        btnAddToBasket.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddToBasket.setForeground(new java.awt.Color(0, 0, 0));
        btnAddToBasket.setText("ADD TO BASKET");
        btnAddToBasket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToBasketActionPerformed(evt);
            }
        });

        lblConfirmation.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblConfirmation.setForeground(new java.awt.Color(255, 255, 255));
        lblConfirmation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnViewBasket, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(204, 204, 204))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblConfirmation, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAddToBasket, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(117, 117, 117)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnViewBasket, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnAddToBasket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblConfirmation, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Filter list by category
    private void lstCategoriesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCategoriesValueChanged
        // TODO add your handling code here:
        // Get the string value of the selected category (e.g., "Heatpump")
        String selectedCategory = lstCategories.getSelectedValue();
        // Safety check: if nothing is selected (e.g., list cleared), do nothing
        if (selectedCategory == null)
        {
            return; 
        }
        // Create a new model to hold the filtered products
        DefaultListModel<Product> productsModel = new DefaultListModel<>();
        
        // Iterate through the master list of all products loaded from the DB
        for (Product p : allProducts)
            //  Check if the product's class name matches the selected category
            // Example: "models.Heatpump" matches "models." + "Heatpump"
            if(p.getClass().getName().equals("models." + selectedCategory))
            {
                // If it matches, add it to the display model
                productsModel.addElement(p);
            }   
        // Update the JList to show only the filtered products
        lstProduct.setModel(productsModel);
    }//GEN-LAST:event_lstCategoriesValueChanged

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        CustomerHome customerHome = new CustomerHome(this.loggedInCustomer);
        customerHome.setVisible(true);
        
        this.dispose();
        
    }//GEN-LAST:event_btnBackActionPerformed

    
    private void btnAddToBasketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToBasketActionPerformed
        // TODO add your handling code here:
        // Retrieve the selected product object and the quantity entered
        Product selectedProduct = lstProduct.getSelectedValue();    
        String quantityText = txtQuantity.getText();
        
        int quantity ;
        //Input Validation
        try
        {
            // Attempt to convert the text input into an integer
            quantity = Integer.parseInt(quantityText);
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Please enter a valid Number","Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Ensure a product is actually selected from the list
        if(selectedProduct==null)
        {
            JOptionPane.showMessageDialog(this, "Please select a product.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Logic Validation (Stock & Limits)
        // Ensure quantity is positive
        if (quantity <= 0)
        {
            JOptionPane.showMessageDialog(this, "Quanity must be more than 1", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Check if there is enough stock available for this order
        if (quantity > selectedProduct.getStockLevel()) 
        {
            // Show an error message with the available stock
            String message = "Not enough stock. Only " + selectedProduct.getStockLevel() + " available.";
            JOptionPane.showMessageDialog(this, message, "Stock Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Add to Basket
        // Create a new OrderLine using the product ID and requested quantity
        int orderLineId = selectedProduct.getProductId();
        OrderLine  newOrderLine = new OrderLine(orderLineId, selectedProduct, quantity);
        
        // Add this line to the current session's basket
        currentBasket.addOrderLine(newOrderLine);
        lblConfirmation.setText("Added to Basket");
        
        // Create a timer to clear the confirmation message after 2 seconds
        Timer timer = new Timer(2000, new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // This code runs after the delay
                lblConfirmation.setText(""); // Clear the label
            }
        });

        // Make the timer only run once
        timer.setRepeats(false);
        
        // Start the timer
        timer.start();
                
    }//GEN-LAST:event_btnAddToBasketActionPerformed

    private void btnViewBasketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewBasketActionPerformed
        // TODO add your handling code here:
        Basket basketFrame = new Basket(currentBasket, this.loggedInCustomer);
        basketFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnViewBasketActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try{
            UIManager.setLookAndFeel(new FlatDarkLaf());
            
        }
        catch(Exception e)
        {
            System.err.println("Failed to initialize Flatleaf");
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BrowseProducts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToBasket;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnViewBasket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblConfirmation;
    private javax.swing.JList<String> lstCategories;
    private javax.swing.JList<Product> lstProduct;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
