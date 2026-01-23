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
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.text.JTextComponent;
import models.Customer;

/**
 *
 * @author thomm
 */
public class RegisterCustomer extends javax.swing.JFrame {
    
     private final Color BG_DARK = new Color(24, 24, 24); //Background colour
    private final Color BTN_DEFAULT = new Color(50,50,50);
    private final Color DEFAULT_COLOUR = new Color (50, 50, 50);
    private final Color ACCENT_GREEN = new Color(0, 210, 90); //Bright green
    private final Color TEXT_WHITE = Color.WHITE;
    private final Color TEXT_BLACK = Color.BLACK;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RegisterCustomer.class.getName());
 
    private static final String DB_URL = "jdbc:ucanaccess://Data/ShopDB.accdb";
    
    
    /**
     * Creates new form RegisterCustomer
     */
    public RegisterCustomer() {
        initComponents();
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
        
        btnRegister.setBorder(UIManager.getBorder("Button.border"));
        btnRegister.setOpaque(false);
        btnRegister.setContentAreaFilled(true);
        btnRegister.setFocusPainted(false);
        btnRegister.putClientProperty("FlatLaf.style", 
                "arc: 25;" +
                "borderWidth: 0;" );
        btnRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //Buttons to Opagque and round shape)
        JButton[] btns = {Back};
        
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
        
        JTextComponent[] inputs = {txtUsername, txtPassword, txtFirstName, txtLastName, txtAddressLine1, txtAddressLine2, txtTown, txtPostcode};
        for (JTextComponent input : inputs)
        {
            input.setOpaque(false);
            input.setBorder(UIManager.getBorder("TextField.border"));
            
            input.putClientProperty("FlatLaf.style",
                    "arc: 15;" + //Rounded Corners
                    "borderColor: #00D25A;"+ //Bright Gren
                    "borderWidth: 2;" + //Visible green outline
                    "focusWidth: 1;"+
                    "caretColor: #ffffff;" + //White blinking cursor
                    " selectionBackground : #00D25A;" +
                    "selectionForeground: #000000;");
            input.setMargin(new Insets(5, 10, 5, 10));
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
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAddressLine1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAddressLine2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTown = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPostcode = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Username:");

        txtUsername.setBackground(new java.awt.Color(50, 50, 50));
        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(255, 255, 255));
        txtUsername.setCaretColor(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password:");

        txtPassword.setBackground(new java.awt.Color(50, 50, 50));
        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setCaretColor(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("First Name:");

        txtFirstName.setBackground(new java.awt.Color(50, 50, 50));
        txtFirstName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFirstName.setForeground(new java.awt.Color(255, 255, 255));
        txtFirstName.setCaretColor(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Last Name:");

        txtLastName.setBackground(new java.awt.Color(50, 50, 50));
        txtLastName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtLastName.setForeground(new java.awt.Color(255, 255, 255));
        txtLastName.setCaretColor(new java.awt.Color(255, 255, 255));
        txtLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastNameActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Address Line 1:");

        txtAddressLine1.setBackground(new java.awt.Color(50, 50, 50));
        txtAddressLine1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAddressLine1.setForeground(new java.awt.Color(255, 255, 255));
        txtAddressLine1.setCaretColor(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Address Line 2:");

        txtAddressLine2.setBackground(new java.awt.Color(50, 50, 50));
        txtAddressLine2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAddressLine2.setForeground(new java.awt.Color(255, 255, 255));
        txtAddressLine2.setCaretColor(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Town:");

        txtTown.setBackground(new java.awt.Color(50, 50, 50));
        txtTown.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTown.setForeground(new java.awt.Color(255, 255, 255));
        txtTown.setCaretColor(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Postcode:");

        txtPostcode.setBackground(new java.awt.Color(50, 50, 50));
        txtPostcode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPostcode.setForeground(new java.awt.Color(255, 255, 255));
        txtPostcode.setCaretColor(new java.awt.Color(255, 255, 255));
        txtPostcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPostcodeActionPerformed(evt);
            }
        });

        btnRegister.setBackground(new java.awt.Color(0, 210, 90));
        btnRegister.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(0, 0, 0));
        btnRegister.setText("REGISTER");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        Back.setBackground(new java.awt.Color(24, 24, 24));
        Back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Back.setForeground(new java.awt.Color(255, 255, 255));
        Back.setText("BACK");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("STAFF LOGIN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                            .addComponent(txtLastName))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                                        .addComponent(txtUsername))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(198, 198, 198))
                                    .addComponent(txtPostcode)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtAddressLine2, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                                            .addComponent(txtAddressLine1)
                                            .addComponent(txtTown))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(7, 7, 7))))))
                        .addGap(35, 35, 35))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddressLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddressLine2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTown, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastNameActionPerformed

    private void txtPostcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPostcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPostcodeActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        CustomerLogin customerLogin = new CustomerLogin();
        customerLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        //Input retrievel
        String username  = txtUsername.getText();
        String password = txtPassword.getText();
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String addressLine1 = txtAddressLine1.getText();
        String addressLine2 = txtAddressLine2.getText();
        String town = txtTown.getText();
        String postcode = txtPostcode.getText();
        
        //Input Validation
        // Ensure critical login credentials are provided
        if (username.isEmpty() || password.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Username and Password are required.");
            return;
        }
        // Ensure personal details are provided
        if (firstName.isEmpty()||lastName.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "First Name and LastName are required.");
            return;
        }
        // Ensure address details are sufficient for delivery
        if(addressLine1.isEmpty() || town.isEmpty() || postcode.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Address Line1, Town and Postcode are required.");
            return;
        }
        //Create Object & Save
        // Create a new Customer object with the validated data
        Customer newCustomer = new Customer(username, password, firstName, lastName, addressLine1, addressLine2, town, postcode);
        
        models.DBManager db = new models.DBManager();
        
        // Attempt to register the customer in the database
        if (db.registerCustomer(newCustomer))
        {
            JOptionPane.showMessageDialog(this,"Registrstion SuccessFull!");
            
            // Redirect the user to the Login screen upon success
            CustomerLogin customerLogin = new CustomerLogin();
            customerLogin.setVisible(true);
            this.dispose();
        }
        else
        {
            // Handle duplicate usernames or database errors
            JOptionPane.showMessageDialog(this, "Error: Registration Failed (Username might be taken).");
        }
        
    }//GEN-LAST:event_btnRegisterActionPerformed

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
                new RegisterCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JTextField txtAddressLine1;
    private javax.swing.JTextField txtAddressLine2;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPostcode;
    private javax.swing.JTextField txtTown;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
