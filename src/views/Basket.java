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
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import models.Customer;
import models.DBManager;
import models.Order;
import models.OrderLine;
import models.Product;

/**
 *
 * @author 30512007
 */
public class Basket extends javax.swing.JFrame {
    
    private final Color BG_DARK = new Color(24, 24, 24); //Background colour
    private final Color BTN_DEFAULT = new Color(50,50,50);
    private final Color ACCENT_GREEN = new Color(0, 210, 90); //Bright green
    private final Color TEXT_WHITE = Color.WHITE;
    private final Color TEXT_BLACK = Color.BLACK;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Basket.class.getName());
    
    private Order currentBasket;
    private Customer loggedInCustomer;
    
    /**
     * Creates new form Basket
     */
    public Basket() {
        initComponents();
        applyCustomDesign();
    }
    
        
    public Basket (Order basketIn, Customer customerIn)
    {
        initComponents();
        // Store session data for processing later
        this.currentBasket = basketIn;
        this.loggedInCustomer = customerIn;
        applyCustomDesign();
        // update the total price label immediately
        lblTotalPrice.setText("Total: £" + String.format("%.2f", currentBasket.getOrderTotal()) );
        // Fill the table with the current items in the basket
        populateTable();
        // Method: updateBasketTable() or updateGUI()

        // FIX: Check if list is empty
        if (lstOrders.getRowCount() == 0) {
            btnBuy.setEnabled(false);// Grey out the button
        } else {
            btnBuy.setEnabled(true);// Make it clickable
        }
    }
    

    
    private void populateTable()
    {
        // Get the model from the JTable to manipulate rows
        DefaultTableModel powerModel = (DefaultTableModel) lstOrders.getModel();
        
        // Clear existing rows to prevent duplicates when refreshing
        powerModel.setRowCount(0);
        
        // Iterate through the HashMap of OrderLines
        for (Map.Entry<Integer, OrderLine> ol: currentBasket.getOrderLines().entrySet())
        {
            OrderLine actualOrderLine = ol.getValue();
            Product product = actualOrderLine.getProductBought();
            
            // Create an array of data for the new row with Id, name, quantity, price
            Object[] rowData = new Object[] {
                product.getProductId(),
                product.getProductName(),
                actualOrderLine.getQuantity(),
                "£" + actualOrderLine.getLineTotal()
                
            };
            
            // Add the new row to the table
            powerModel.addRow(rowData);
        }
    }

    private void applyCustomDesign()
    {
        // Center the window on the screen
        this.setLocationRelativeTo(null);
        
        // Set the main background colour to deep dark grey
        this.getContentPane().setBackground(BG_DARK);
        
        //Making image label too 100px
        jLabelLogo.setPreferredSize(new Dimension(100,100));
        jLabelLogo.setSize(100,100);
        
        //Style the Buy Now Button 
        btnBuy.setBorder(UIManager.getBorder("Button.border"));
        btnBuy.setOpaque(false);
        btnBuy.setContentAreaFilled(true);
        btnBuy.setFocusPainted(false);
        btnBuy.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // Apply FlatLaf rounded corners without a border
        btnBuy.putClientProperty("FlatLaf.style", 
                "arc: 25;" +
                "borderWidth: 0;" );
        
        
        // Style Secondary Buttons (Add More / Remove)
        JButton[] btns = {btnAddMoreProducts, btnRemoveOrderLine};
        
        for (JButton btn : btns)
        {
            btn.setBorder(UIManager.getBorder("Button.border"));
            // Apply rounded corners and a green border
            btn.putClientProperty("FlatLaf.style", "arc: 25; borderWidth: 2; borderColor: #00D25A; background: #323232; foreground: #ffffff; focusWidth: 0;");
           // Ensure transparency for the background color to show
            btn.setOpaque(false);
            btn.setContentAreaFilled(true);
            btn.setFocusPainted(false);
            // Default colors and font
            btn.setBackground(BTN_DEFAULT);
            btn.setForeground(TEXT_WHITE);
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            // Set the component outline color
            btn.putClientProperty("JComponent.outline", ACCENT_GREEN);
            addHoverEffect(btn);
        }  
        try
            //Load Logo Image
        {
            java.net.URL imgURL = getClass().getResource("/views/logo.png");
            if (imgURL != null) {
            ImageIcon originalIcon = new ImageIcon(imgURL);
            // Scale the image smoothly to fit the label
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
        
        //Style the Order List Table 
        jScrollPane1.putClientProperty("FlatLaf.style",
                "arc: 15;"
                        + "borderWidth:2;"
                        + "borderColor:#00D25a;"
                        + "background: #323232;"
                        + "focusWidth: 0;");

        // Customize selection colors (Green highlight, black text)
        lstOrders.setSelectionBackground(ACCENT_GREEN);
        lstOrders.setSelectionForeground(TEXT_BLACK);
        lstOrders.setRowHeight(30);
        lstOrders.putClientProperty("FlatLaf.style", "selectionArc: 10; selectionInsets:2, 2, 2, 2; focusWidth: 0;");
        
        // Style the Table Header
        lstOrders.getTableHeader().setBackground(new Color(30, 30, 30));
        lstOrders.getTableHeader().setForeground(TEXT_WHITE);
        lstOrders.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        lstOrders.getTableHeader().putClientProperty("FlatLaf.style", "bottomSeparatorColor: #00D25A; bottomSeparatorHeight: 2;");
       
        // Adjust column widths for better readability

        if (lstOrders.getColumnModel().getColumnCount()>0)
        {
            // ID Column (Narrow)

            lstOrders.getColumnModel().getColumn(0).setMinWidth(0);
            lstOrders.getColumnModel().getColumn(0).setMaxWidth(100);
            lstOrders.getColumnModel().getColumn(0).setPreferredWidth(80);
            // Quantity Column (Narrow)
            lstOrders.getColumnModel().getColumn(2).setMinWidth(0);
            lstOrders.getColumnModel().getColumn(2).setMaxWidth(100);
            lstOrders.getColumnModel().getColumn(2).setPreferredWidth(90);
        }
    }
    /**
     * Adds visual feedback when hovering over buttons.
     */
     private void addHoverEffect(JButton btn)
    {
        btn.addMouseListener(new MouseAdapter()
                {
                    public void mouseEntered(MouseEvent evt)
                {
                    // Hover: Bright green background, black text
                    btn.setBackground(ACCENT_GREEN);
                    btn.setForeground(TEXT_BLACK);
                }
                    public void mouseExited (MouseEvent evt)
                {
                    // Exit: Revert to dark theme
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

        jScrollPane1 = new javax.swing.JScrollPane();
        lstOrders = new javax.swing.JTable();
        btnAddMoreProducts = new javax.swing.JButton();
        btnBuy = new javax.swing.JButton();
        btnRemoveOrderLine = new javax.swing.JButton();
        lblTotalPrice = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lstOrders.setBackground(new java.awt.Color(24, 24, 24));
        lstOrders.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lstOrders.setForeground(new java.awt.Color(255, 255, 255));
        lstOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ProductId", "Product", "Quantity", "Price"
            }
        ));
        jScrollPane1.setViewportView(lstOrders);
        if (lstOrders.getColumnModel().getColumnCount() > 0) {
            lstOrders.getColumnModel().getColumn(0).setPreferredWidth(60);
        }

        btnAddMoreProducts.setBackground(new java.awt.Color(24, 24, 24));
        btnAddMoreProducts.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddMoreProducts.setForeground(new java.awt.Color(255, 255, 255));
        btnAddMoreProducts.setText("ADD MORE PRODUCTS");
        btnAddMoreProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMoreProductsActionPerformed(evt);
            }
        });

        btnBuy.setBackground(new java.awt.Color(0, 210, 90));
        btnBuy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuy.setForeground(new java.awt.Color(0, 0, 0));
        btnBuy.setText("BUY");
        btnBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyActionPerformed(evt);
            }
        });

        btnRemoveOrderLine.setBackground(new java.awt.Color(24, 24, 24));
        btnRemoveOrderLine.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRemoveOrderLine.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoveOrderLine.setText("REMOVE PRODUCT");
        btnRemoveOrderLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveOrderLineActionPerformed(evt);
            }
        });

        lblTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTotalPrice.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalPrice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("YOUR BASKET");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnAddMoreProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRemoveOrderLine, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnRemoveOrderLine, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(btnAddMoreProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMoreProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMoreProductsActionPerformed
        // TODO add your handling code here:
        BrowseProducts browseProducts = new BrowseProducts(this.currentBasket, this.loggedInCustomer);
        browseProducts.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAddMoreProductsActionPerformed

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyActionPerformed
        // TODO add your handling code here:
        Payment payment = new Payment(this.loggedInCustomer,this.currentBasket);
        payment.setVisible(true);
        
        this.dispose();

    }//GEN-LAST:event_btnBuyActionPerformed

    private void btnRemoveOrderLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveOrderLineActionPerformed
        // TODO add your handling code here:
        //Get selected row index
        int selectedRow = lstOrders.getSelectedRow();
        
        if (selectedRow == -1)
        {
            // Error handling if nothing is selected
            JOptionPane.showMessageDialog(this,"Error: Please Choose a Product to remove");
        }
        else
        {
            //Get product id from coloumn 0 of the selected row
            String idString = lstOrders.getValueAt(selectedRow, 0).toString();
            int productId = Integer.parseInt(idString);
            
            // Remove the item from the Order object
            currentBasket.removeOrderLine(productId);
            
            // Confirm success and refresh the table to show changes
            JOptionPane.showMessageDialog(this, "Product successfully removed");
            populateTable();
            // Recalculate and update the total price label
            lblTotalPrice.setText("Total: £" + String.format("%.2f", currentBasket.getOrderTotal()) );
            
        }
    }//GEN-LAST:event_btnRemoveOrderLineActionPerformed

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
                new Basket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMoreProducts;
    private javax.swing.JButton btnBuy;
    private javax.swing.JButton btnRemoveOrderLine;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotalPrice;
    private javax.swing.JTable lstOrders;
    // End of variables declaration//GEN-END:variables
}
