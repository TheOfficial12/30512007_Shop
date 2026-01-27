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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import models.Customer;
import models.DBManager;

/**
 *
 * @author thomm
 */
public class UnregisteringCustomer extends javax.swing.JFrame {
    private final Color BG_DARK = new Color(24, 24, 24); //Background colour
    private final Color BTN_DEFAULT = new Color(50,50,50);
    private final Color ACCENT_GREEN = new Color(0, 210, 90); //Bright green
    private final Color TEXT_WHITE = Color.WHITE;
    private final Color TEXT_BLACK = Color.BLACK;
    private Customer loggedInCustomer;
    private static final String DB_URL = "jdbc:ucanaccess://Data/ShopDB.accdb";
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(UnregisteringCustomer.class.getName());

    /**
     * Creates new form UnregisteringCustomer
     */
    public UnregisteringCustomer() {
        initComponents();
        applyCustomDesign();
    }
    public UnregisteringCustomer(Customer customerIn)
    {
        initComponents();
        this.loggedInCustomer = customerIn;
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
        
        btnEdit.setBorder(UIManager.getBorder("Button.border"));
        btnEdit.setOpaque(false);
        btnEdit.setContentAreaFilled(true);
        btnEdit.setFocusPainted(false);
        btnEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEdit.putClientProperty("FlatLaf.style", 
                "arc: 25;" +
                "borderWidth: 0;" );
        
        
        //Buttons to Opagque and round shape)
        JButton[] btns = {btnBack};
        
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
        JComponent[] inputs = {txtPassword, txtFirst, txtLast};
        
        for(JComponent input : inputs)
        {
            input.putClientProperty("FlatLaf.style",
                    "arc:15;" +
                    "borderWidth : 2;" +
                    "borderColor: #00D25A;" +
                    "background: #323232; " + 
                    "foreground: #ffffff;");
        }
        
        txtPassword.putClientProperty("JComponent.roundRect", true);
        txtFirst.putClientProperty("JComponent.roundRect", true);
        txtLast.putClientProperty("JComponent.roundRect", true);
        
        
        
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

        jLabelLogo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        txtFirst = new javax.swing.JTextField();
        txtLast = new javax.swing.JTextField();
        btnEdit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("UNREGISTER");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ENTER PASSWORD:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ENTER FIRST NAME:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ENTER LAST NAME:");

        txtPassword.setBackground(new java.awt.Color(50, 50, 50));
        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setCaretColor(new java.awt.Color(255, 255, 255));

        txtFirst.setBackground(new java.awt.Color(50, 50, 50));
        txtFirst.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFirst.setForeground(new java.awt.Color(255, 255, 255));
        txtFirst.setCaretColor(new java.awt.Color(255, 255, 255));

        txtLast.setBackground(new java.awt.Color(50, 50, 50));
        txtLast.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtLast.setForeground(new java.awt.Color(255, 255, 255));
        txtLast.setCaretColor(new java.awt.Color(255, 255, 255));

        btnEdit.setBackground(new java.awt.Color(0, 210, 90));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(0, 0, 0));
        btnEdit.setText("UNREGISTER");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLast, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(154, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLast, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        //Getting the username of the customer to remove
        String username = loggedInCustomer.getUsername();
        String enteredPassword = txtPassword.getText();
        String enteredFirstN = txtFirst.getText();
        String enteredLastN = txtLast.getText();
        //Check if its inull and removeing any spache in the front or the back
        if (enteredPassword == null || enteredPassword.trim().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Password cant be null","Input Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
        
            // Validation: Ensure First and Last names are not empty
        if (enteredFirstN == null || enteredLastN==null || enteredFirstN.trim().isEmpty() || enteredLastN.trim().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "First Name or Last Name cant be null","Input Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
        //Checking if the passsword matches
        if (!enteredPassword.equals(loggedInCustomer.getPassword())||!enteredFirstN.equals(loggedInCustomer.getFirstName())||!enteredLastN.equals(loggedInCustomer.getLastName())) 
        {
            JOptionPane.showMessageDialog(this, "Incorrect Password, First Name, or Last Name. Account deletion cancelled.", "Security Warning", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Confirmation Dialog
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to delete your account? This cannot be undone.", 
            "Confirm Unregister", 
            JOptionPane.YES_NO_OPTION);

        //If option yes, delete everything
        if (confirm == JOptionPane.YES_OPTION) {
                DBManager db = new DBManager();
                db.unregisterCustomer(username);

                JOptionPane.showMessageDialog(this, "You have been successfully unregistered.");

                // Go back to main menu
                MainMenu mainMenu = new MainMenu();
                mainMenu.setVisible(true);
                this.dispose();
        }
        if (confirm ==JOptionPane.NO_OPTION)
        {
            CustomerHome customerHome = new CustomerHome(this.loggedInCustomer);
            customerHome.setVisible(true);
            this.dispose();
        }
        
        
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        CustomerHome customerHome = new CustomerHome(this.loggedInCustomer);
        customerHome.setVisible(true);
        
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
                new UnregisteringCustomer().setVisible(true);
            }
        }); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JTextField txtFirst;
    private javax.swing.JTextField txtLast;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}
