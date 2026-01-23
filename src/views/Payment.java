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
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import models.Customer;
import models.DBManager;
import models.Order;
import models.OrderLine;
import models.Product;

/**
 *
 * @author thomm
 */
public class Payment extends javax.swing.JFrame {
    
    private final Color BG_DARK = new Color(24, 24, 24); //Background colour
    private final Color BTN_DEFAULT = new Color(50,50,50);
    private final Color ACCENT_GREEN = new Color(0, 210, 90); //Bright green
    private final Color TEXT_WHITE = Color.WHITE;
    private final Color TEXT_BLACK = Color.BLACK;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Payment.class.getName());

    private Order currentBasket;
    private Customer loggedInCustomer;
    /**
     * Creates new form Payment
     */
    
    public Payment() {
        
        initComponents();
        applyCustomDesign();
    }
    
    public Payment(Customer customer, Order basket) {
        initComponents();
        this.loggedInCustomer = customer;
        this.currentBasket = basket;
        applyCustomDesign();

        show_cards();
    }

    private String maskCardNumber(String realCardNumber)
    {
        //If input is null or short
        if (realCardNumber == null || realCardNumber.length()<8)
        {
            JOptionPane.showMessageDialog(this, "Enter a valid Card");
            return realCardNumber;
        }
        String lastFour = realCardNumber.substring(realCardNumber.length()-4);
        //Making only the last 4 digits show, and everything else masked
        return "**** **** ****" + lastFour;
    }
    
    public void show_cards()
    {
        // Create a list model to manipulate the JList component
        DefaultListModel<String> cardsModel = new DefaultListModel();
        // Loop through the card numbers stored in the Customer object
        for (String card: loggedInCustomer.getCardNumbers())
        {
            cardsModel.addElement(String.valueOf(card));
        }
        // Update the visual list to show the cards
        lstCardNo.setModel(cardsModel);
    }
    
    private void applyCustomDesign()
    {
        this.setLocationRelativeTo(null);
        
        //Background colour
        this.getContentPane().setBackground(BG_DARK);
        
        //Making image label too 100px
        jLabelLogo.setPreferredSize(new Dimension(100,100));
        jLabelLogo.setSize(100,100);
        
        JButton[] mainBtns = {btnDefaultAdd, btnConfirm};
        
        for (JButton btn : mainBtns)
        {
            btn.setBorder(UIManager.getBorder("Button.border"));
            btn.setOpaque(false);
            btn.setContentAreaFilled(true);
            btn.setFocusPainted(false);
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btn.putClientProperty("FlatLaf.style", 
                "arc: 25;" +
                "borderWidth: 0;" );
        }
        
        JButton[] secBtns = {btnBack, btnDeleteCard, btnAdd};
        
        for (JButton sbtns : secBtns)
        {
            sbtns.setBorder(UIManager.getBorder("Button.border"));
            
            //Make button rounds
            
            sbtns.putClientProperty("FlatLaf.style", "arc: 25; borderWidth: 2; borderColor: #00D25A; background: #323232; foreground: #ffffff; focusWidth: 0;");
            
            //Opacity to show colours
            sbtns.setOpaque(false);
            sbtns.setContentAreaFilled(true);
            sbtns.setFocusPainted(false);
            
            //DEFAUlt style
            sbtns.setBackground(BTN_DEFAULT);
            sbtns.setForeground(TEXT_WHITE);
            sbtns.setFont(new Font ("Segoe UI", Font.BOLD, 16));
            sbtns.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            //GREen border
            sbtns.putClientProperty("JComponent.outline", ACCENT_GREEN);
            
            addHoverEffect(sbtns);
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
        
        JComponent[] inputs = {jScrollPane1, txtCardNo, txtDefault};
        
        for(JComponent input : inputs)
        {
            input.putClientProperty("FlatLaf.style",
                    "arc:15;" +
                    "borderWidth : 2;" +
                    "borderColor: #00D25A;" +
                    "background: #323232; " + 
                    "foreground: #ffffff;");
        }
        txtCardNo.putClientProperty("JComponent.roundRect", true);
        txtDefault.putClientProperty("JComponent.roundRect", true);
        
        JList<?>[] lists = {lstCardNo};
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCardNo = new javax.swing.JList<>();
        txtCardNo = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnConfirm = new javax.swing.JButton();
        btnDeleteCard = new javax.swing.JButton();
        btnDefaultAdd = new javax.swing.JButton();
        txtDefault = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabelLogo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Enter Card Number:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Select Card Number:");

        lstCardNo.setBackground(new java.awt.Color(50, 50, 50));
        lstCardNo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lstCardNo.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(lstCardNo);

        txtCardNo.setBackground(new java.awt.Color(50, 50, 50));
        txtCardNo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCardNo.setForeground(new java.awt.Color(255, 255, 255));
        txtCardNo.setCaretColor(new java.awt.Color(255, 255, 255));

        btnAdd.setBackground(new java.awt.Color(24, 24, 24));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add Card");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnConfirm.setBackground(new java.awt.Color(0, 210, 90));
        btnConfirm.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnConfirm.setForeground(new java.awt.Color(0, 0, 0));
        btnConfirm.setText("CONFIRM");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnDeleteCard.setBackground(new java.awt.Color(24, 24, 24));
        btnDeleteCard.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDeleteCard.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteCard.setText("DELETE CARD");
        btnDeleteCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCardActionPerformed(evt);
            }
        });

        btnDefaultAdd.setBackground(new java.awt.Color(0, 210, 90));
        btnDefaultAdd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnDefaultAdd.setForeground(new java.awt.Color(0, 0, 0));
        btnDefaultAdd.setText("Add Card");
        btnDefaultAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefaultAddActionPerformed(evt);
            }
        });

        txtDefault.setBackground(new java.awt.Color(50, 50, 50));
        txtDefault.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDefault.setForeground(new java.awt.Color(255, 255, 255));
        txtDefault.setCaretColor(new java.awt.Color(255, 255, 255));
        txtDefault.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDefaultActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Add New Default card:");

        btnBack.setBackground(new java.awt.Color(24, 24, 24));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PAYMENT METHOD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDefault, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDefaultAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCardNo, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(btnDeleteCard, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCardNo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDefault, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDefaultAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConfirm)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBack)
                        .addComponent(btnDeleteCard)))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
        
        //Validation
        // Ensure the user has actually highlighted a card in the list
        if (lstCardNo.getSelectedIndex() == -1)
        {
            JOptionPane.showMessageDialog(this, "Please select a Card to pay with");
            return;
        }
        // Retrieve selected card and finalize basket calculations
        String selectedCard = lstCardNo.getSelectedValue();
        currentBasket.calculateOrderTotal();
        currentBasket.setPaymentCard(selectedCard);
        //Save Order to Database
        DBManager db = new DBManager();
        // Save the main Order record and get back the new unique OrderID
        int newOrderId = db.saveOrder(currentBasket, loggedInCustomer.getUsername()); 
        
        if (newOrderId>0) {
            //Save Order Lines & Update Stock
            // Loop through every product currently in the basket
            for (OrderLine ol : currentBasket.getOrderLines().values()) 
            {
                //Write the individual item to the OrderLines table
                db.writeOrderLine(ol, newOrderId);
                //Retrieve product details to adjust stock
                Product product = ol.getProductBought();
                int quantity = ol.getQuantity();
                
                //Reduce the stock level in the Products table
                db.updateStockLevel(product, quantity);
            }
            //Success & Navigation
            JOptionPane.showMessageDialog(this, "Order placed successfully!");
            // Open the confirmation screen
            Confirmation confirmFrame = new Confirmation(this.loggedInCustomer);
            confirmFrame.setVisible(true);
            this.dispose();
        } else {
             // Handle database errors 
            JOptionPane.showMessageDialog(this, "Error placing order. Please try again.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String rawCardNum = txtCardNo.getText();
        
        // Basic length check
        if (rawCardNum.length() < 8)
        {
            JOptionPane.showMessageDialog(this, "Error: Enter a Valid Card Number");
            return;
        }
        
        // Convert "12345678" to "****5678" for security
        String secureCard = maskCardNumber(rawCardNum);
        // Save to customer object and refresh the UI
        loggedInCustomer.addCard(secureCard);
        
        txtCardNo.setText("");
        show_cards();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDefaultAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefaultAddActionPerformed
        // TODO add your handling code here:
        String rawCardNum = txtDefault.getText();
        
        // Basic length check
        if (rawCardNum.length() < 8)
        {
            JOptionPane.showMessageDialog(this, "Error: Enter a Valid Card Number");
            return;
        }
        // Mask and add as the 'First' (Default) card
        String secureCard = maskCardNumber(rawCardNum);
        
        loggedInCustomer.addFirstCard(secureCard);
        
        txtCardNo.setText("");
        show_cards();
        
    }//GEN-LAST:event_btnDefaultAddActionPerformed

    private void btnDeleteCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCardActionPerformed
        // TODO add your handling code here:
        // Ensure a card is selected to avoid IndexOutOfBounds errors
        if (lstCardNo.getSelectedIndex() == - 1)
        {
            JOptionPane.showMessageDialog(this, "Error: Select a Card Number First");
        }
        else
        {
            // Remove from the customer object based on list index
            loggedInCustomer.removeCard(lstCardNo.getSelectedIndex());
            JOptionPane.showMessageDialog(this, "Success: Card Number Successfully Removed");
            // Refresh list to show it is gone
            show_cards();
        }
    }//GEN-LAST:event_btnDeleteCardActionPerformed

    private void txtDefaultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDefaultActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDefaultActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        Basket basket = new Basket(this.currentBasket, this.loggedInCustomer);
        basket.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
                new Payment().setVisible(true);
            }
        });
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnDefaultAdd;
    private javax.swing.JButton btnDeleteCard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lstCardNo;
    private javax.swing.JTextField txtCardNo;
    private javax.swing.JTextField txtDefault;
    // End of variables declaration//GEN-END:variables
}
