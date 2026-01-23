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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import models.DBManager;
import models.Heatpump;
import models.Product;
import models.Replacement_Parts;
import models.SolarPanel;
import models.Staff;

/**
 *
 * @author thomm
 */
public class AddProduct extends javax.swing.JFrame {
    
    private final Color BG_DARK = new Color(24, 24, 24); //Background colour
    private final Color BTN_DEFAULT = new Color(50,50,50);
    private final Color ACCENT_GREEN = new Color(0, 210, 90); //Bright green
    private final Color TEXT_WHITE = Color.WHITE;
    private final Color TEXT_BLACK = Color.BLACK;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AddProduct.class.getName());

     private static final String DB_URL = "jdbc:ucanaccess://Data/ShopDB.accdb";
  
    private Staff loggedInStaff;
    /**
     * Creates new form AddProduct
     */
    public AddProduct()
    {
        initComponents();
        applyCustomDesign();
    }
    
    public AddProduct(Staff staffIn) {
        DBManager db = new DBManager();
        
        initComponents();
        applyCustomDesign();
        this.loggedInStaff = staffIn;  
        
        ButtonGroup group =  new ButtonGroup();
        group.add(rdoBtnSolarPanel);
        group.add(rdoBtnHeatPump);
        group.add(rdoBtnReplacementPart);
    }
    

    private void applyCustomDesign()
    {
        this.setLocationRelativeTo(null);
        
        //Background colour
        this.getContentPane().setBackground(BG_DARK);
        
        //Making image label too 100px
        jLabelLogo.setPreferredSize(new Dimension(100,100));
        jLabelLogo.setSize(100,100);
        
        btnAddProduct.setBorder(UIManager.getBorder("Button.border"));
        btnAddProduct.setOpaque(false);
        btnAddProduct.setContentAreaFilled(true);
        btnAddProduct.setFocusPainted(false);
        btnAddProduct.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAddProduct.putClientProperty("FlatLaf.style", 
                "arc: 25;" +
                "borderWidth: 0;" );
        
        
        //Buttons to Opagque and round shape)
        JButton[] btns = {btnBack, btnConfirmCategory};
        
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
            String localPath = "D:\\HND\\James Hood\\Main Project\\30512007_Shop\\src\\views\\logo.png";
            ImageIcon originalIcon = new ImageIcon(localPath);
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
        catch (Exception e)
        {
            System.out.println("Logo image not found" + e.getMessage());
        }
        
        
        //Lists and textbox
        JComponent[] inputs = {txtProductName, txtPrice, txtStockLevel, txtWattage, txtEfficiency, txtPartFor};
        
        for(JComponent input : inputs)
        {
            input.putClientProperty("FlatLaf.style",
                    "arc:15;" +
                    "borderWidth : 2;" +
                    "borderColor: #00D25A;" +
                    "background: #323232; " + 
                    "foreground: #ffffff;");
        }
        
        txtProductName.putClientProperty("JComponent.roundRect", true);
        txtPrice.putClientProperty("JComponent.roundRect", true);
        txtStockLevel.putClientProperty("JComponent.roundRect", true);
        txtWattage.putClientProperty("JComponent.roundRect", true);
        txtEfficiency.putClientProperty("JComponent.roundRect", true);
        txtPartFor.putClientProperty("JComponent.roundRect", true);
        
        txtWattage.setEnabled(false);
        txtEfficiency.setEnabled(false);
        txtPartFor.setEnabled(false);
        
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

        jLabel1 = new javax.swing.JLabel();
        rdoBtnSolarPanel = new javax.swing.JRadioButton();
        rdoBtnHeatPump = new javax.swing.JRadioButton();
        rdoBtnReplacementPart = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtStockLevel = new javax.swing.JTextField();
        txtWattage = new javax.swing.JTextField();
        txtEfficiency = new javax.swing.JTextField();
        txtPartFor = new javax.swing.JTextField();
        btnAddProduct = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnConfirmCategory = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CATEGORY");

        rdoBtnSolarPanel.setBackground(new java.awt.Color(24, 24, 24));
        rdoBtnSolarPanel.setForeground(new java.awt.Color(255, 255, 255));
        rdoBtnSolarPanel.setText("Solar Panel");

        rdoBtnHeatPump.setBackground(new java.awt.Color(24, 24, 24));
        rdoBtnHeatPump.setForeground(new java.awt.Color(255, 255, 255));
        rdoBtnHeatPump.setText("Heat Pump");

        rdoBtnReplacementPart.setBackground(new java.awt.Color(24, 24, 24));
        rdoBtnReplacementPart.setForeground(new java.awt.Color(255, 255, 255));
        rdoBtnReplacementPart.setText("Replacement Part");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PRODUCT NAME:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PRICE:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("STOCK LEVEL:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("WATTAGE OUTPUT:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("EFFICIENCY RATING:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("PART FOR:");

        txtProductName.setBackground(new java.awt.Color(50, 50, 50));
        txtProductName.setForeground(new java.awt.Color(255, 255, 255));
        txtProductName.setCaretColor(new java.awt.Color(255, 255, 255));

        txtPrice.setBackground(new java.awt.Color(50, 50, 50));
        txtPrice.setForeground(new java.awt.Color(255, 255, 255));
        txtPrice.setCaretColor(new java.awt.Color(255, 255, 255));

        txtStockLevel.setBackground(new java.awt.Color(50, 50, 50));
        txtStockLevel.setForeground(new java.awt.Color(255, 255, 255));
        txtStockLevel.setCaretColor(new java.awt.Color(255, 255, 255));

        txtWattage.setBackground(new java.awt.Color(50, 50, 50));
        txtWattage.setForeground(new java.awt.Color(255, 255, 255));
        txtWattage.setCaretColor(new java.awt.Color(255, 255, 255));

        txtEfficiency.setBackground(new java.awt.Color(50, 50, 50));
        txtEfficiency.setForeground(new java.awt.Color(255, 255, 255));
        txtEfficiency.setCaretColor(new java.awt.Color(255, 255, 255));

        txtPartFor.setBackground(new java.awt.Color(50, 50, 50));
        txtPartFor.setForeground(new java.awt.Color(255, 255, 255));
        txtPartFor.setCaretColor(new java.awt.Color(255, 255, 255));

        btnAddProduct.setBackground(new java.awt.Color(0, 210, 90));
        btnAddProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddProduct.setForeground(new java.awt.Color(0, 0, 0));
        btnAddProduct.setText("ADD PRODUCT");
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(50, 50, 50));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnConfirmCategory.setBackground(new java.awt.Color(50, 50, 50));
        btnConfirmCategory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnConfirmCategory.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmCategory.setText("CONFIRM");
        btnConfirmCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmCategoryActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ADD PRODUCT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConfirmCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(49, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtStockLevel, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                                    .addComponent(txtPrice)
                                    .addComponent(txtProductName)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(0, 47, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnAddProduct))
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(txtPartFor)
                                .addComponent(txtEfficiency)
                                .addComponent(txtWattage))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdoBtnSolarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdoBtnHeatPump))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(8, 8, 8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoBtnReplacementPart)))))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoBtnSolarPanel)
                            .addComponent(rdoBtnHeatPump)
                            .addComponent(rdoBtnReplacementPart))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfirmCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtWattage, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEfficiency, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPartFor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStockLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAddProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        ProductMenu productMenu = new ProductMenu(this.loggedInStaff);
        productMenu.setVisible(true);
        
        this.dispose();
        
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        // TODO add your handling code here:
        
        
        String productName = txtProductName.getText();
        if(productName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Product Name cannot be empty");
            return;
        }
        
        double price = 0;
        int stock = 0;
        
        try
        {
            price = Double.parseDouble(txtPrice.getText());
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Error: Price should be an Integer");
            return;
        }
        
        try
        {
            stock = Integer.parseInt(txtStockLevel.getText());
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Error: Stock Level should be an Integer");
            return;
        }
        
        Product productToAdd = null;
        
        if (rdoBtnSolarPanel.isSelected())
        {
            try
            {
                int wattage = Integer.parseInt(txtWattage.getText());
                productToAdd = new SolarPanel(productName, price, stock, wattage);
            }
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(this, "Error: Wattage should be an Integer");
                return;
            }
        }
        else if (rdoBtnHeatPump.isSelected())
        {
            try
            {
                double efficiency = Double.parseDouble(txtEfficiency.getText());
                productToAdd = new Heatpump(productName, price, stock, efficiency);
            }
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(this, "Error: Stock Level should be an Integer");
                return;
            }
        }
        else if (rdoBtnReplacementPart.isSelected())
        {
            String partFor = txtPartFor.getText();
            if(partFor.isEmpty()) 
            {
                JOptionPane.showMessageDialog(this, "Error: 'Part For' cannot be empty");
                return;
            }
            productToAdd = new Replacement_Parts(productName, price, stock, partFor);
        }
        
        if (productToAdd != null)
        {
            DBManager db = new DBManager();
            if (db.addProduct(productToAdd))
            {
                JOptionPane.showMessageDialog(this,"Product Succeffully Created");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Error Saving product to the database");
            }
        }
    }//GEN-LAST:event_btnAddProductActionPerformed

    private void btnConfirmCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmCategoryActionPerformed
        // TODO add your handling code here:
        
        if (rdoBtnSolarPanel.isSelected())
        {
            // Enable Wattage
            txtWattage.setEnabled(true);
            txtWattage.setBackground(new Color(50, 50, 50)); // Reset color if needed

            // Disable & Clear the others
            txtEfficiency.setEnabled(false);
            txtEfficiency.setText("");

            txtPartFor.setEnabled(false);
            txtPartFor.setText("");
        }
        else if (rdoBtnHeatPump.isSelected())
        {
            // Enable Efficiency
            txtEfficiency.setEnabled(true);
            txtEfficiency.setBackground(new Color(50, 50, 50));

            // Disable & Clear the others
            txtWattage.setEnabled(false);
            txtWattage.setText("");

            txtPartFor.setEnabled(false);
            txtPartFor.setText("");
        }
        else if (rdoBtnReplacementPart.isSelected())
        {
            txtPartFor.setEnabled(true);
            txtPartFor.setBackground(new Color(50, 50, 50));

            // Disable & Clear the others
            txtWattage.setEnabled(false);
            txtWattage.setText("");

            txtEfficiency.setEnabled(false);
            txtEfficiency.setText("");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Error: Choose one of the Category");
        }
    }//GEN-LAST:event_btnConfirmCategoryActionPerformed

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
                new AddProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnConfirmCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JRadioButton rdoBtnHeatPump;
    private javax.swing.JRadioButton rdoBtnReplacementPart;
    private javax.swing.JRadioButton rdoBtnSolarPanel;
    private javax.swing.JTextField txtEfficiency;
    private javax.swing.JTextField txtPartFor;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtStockLevel;
    private javax.swing.JTextField txtWattage;
    // End of variables declaration//GEN-END:variables
}
