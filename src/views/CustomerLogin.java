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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.text.JTextComponent;
import models.Customer;
import models.DBManager;

/**
 *
 * @author 30512007
 */
public class CustomerLogin extends javax.swing.JFrame {
    
    private final Color BG_DARK = new Color(24, 24, 24); //Background colour
    private final Color BTN_DEFAULT = new Color(50,50,50);
    private final Color DEFAULT_COLOUR = new Color (50, 50, 50);
    private final Color ACCENT_GREEN = new Color(0, 210, 90); //Bright green
    private final Color TEXT_WHITE = Color.WHITE;
    private final Color TEXT_BLACK = Color.BLACK;

    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CustomerLogin.class.getName());

    /**
     * Creates new form CustomerLogin
     */
    public CustomerLogin() {
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
        
        btnLogin.setBorder(UIManager.getBorder("Button.border"));
        btnLogin.setOpaque(false);
        btnLogin.setContentAreaFilled(true);
        btnLogin.setFocusPainted(false);
        btnLogin.putClientProperty("FlatLaf.style", 
                "arc: 25;" +
                "borderWidth: 0;" );
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //Buttons to Opagque and round shape)
        JButton[] btns = { btnRegister, jButton1};
        
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
        
        JTextComponent[] inputs = {txtUsername, txtPassword};
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabelLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CUSTOMER LOGIN");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");

        txtUsername.setBackground(new java.awt.Color(50, 50, 50));
        txtUsername.setForeground(new java.awt.Color(255, 255, 255));

        txtPassword.setBackground(new java.awt.Color(50, 50, 50));
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));

        btnLogin.setBackground(new java.awt.Color(0, 210, 90));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(0, 0, 0));
        btnLogin.setText("LOGIN");
        btnLogin.setMaximumSize(new java.awt.Dimension(72, 27));
        btnLogin.setMinimumSize(new java.awt.Dimension(72, 27));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnRegister.setBackground(new java.awt.Color(24, 24, 24));
        btnRegister.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("REGISTER");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(24, 24, 24));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setLabel("RETURN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPassword)
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        RegisterCustomer registerCustomer = new RegisterCustomer();
        registerCustomer.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here
        //getting text from username and password
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        
        DBManager db = new DBManager();
        //Checking if the data matches
        Customer loggedInCustomer = db.customerLogin(username, password);
        //If not null, it proces to the customerhome
        if (loggedInCustomer != null)
        {
        CustomerHome customerHome = new CustomerHome(loggedInCustomer);
        customerHome.setVisible(true);
        this.dispose();
        }
        //If null, error message
        else
        {
            JOptionPane.showMessageDialog(this,"Login Failed, Please Check your Username and Password.","Login Error", JOptionPane.ERROR_MESSAGE);
            
        }
        

    }//GEN-LAST:event_btnLoginActionPerformed

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
                new CustomerLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
