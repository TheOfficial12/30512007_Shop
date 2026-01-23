/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
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
public class BrowseProductsGuest extends javax.swing.JFrame {
    
    private final Color BG_DARK = new Color(24, 24, 24); //Background colour
    private final Color BTN_DEFAULT = new Color(50,50,50);
    private final Color ACCENT_GREEN = new Color(0, 210, 90); //Bright green
    private final Color TEXT_WHITE = Color.WHITE;
    private final Color TEXT_BLACK = Color.BLACK;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(BrowseProductsGuest.class.getName());

    private ArrayList<Product> allProducts;
    
    private Order currentBasket;
    
    private Customer loggedInCustomer;
    
    
    
    /**
     * Creates new form BrowseProducts
     */
    
    public BrowseProductsGuest()
    {
        this(new Order(), null);
        applyCustomDesign();
    }
    
    public BrowseProductsGuest(Order basketIn, Customer customerIn) {
        //Load Products from DB
        DBManager db = new DBManager();
        allProducts = db.loadProducts();
        
        initComponents();
        
        this.currentBasket = basketIn;
        this.loggedInCustomer = customerIn;
        
        lstProduct.setModel(new DefaultListModel<Product>());
        
    }
    
    private void applyCustomDesign()
    {
        
        this.setLocationRelativeTo(null);
        
        //Background colour
        this.getContentPane().setBackground(BG_DARK);
        
        //Making image label too 100px
        jLabelLogo.setPreferredSize(new Dimension(100,100));
        jLabelLogo.setSize(100,100);
        
        btnBack.setBorder(UIManager.getBorder("Button.border"));
        btnBack.setOpaque(false);
        btnBack.setContentAreaFilled(true);
        btnBack.setFocusPainted(false);
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnBack.putClientProperty("FlatLaf.style", 
                "arc: 25;" +
                "borderWidth: 0;" );
        
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
        
        JComponent[] inputs = {jScrollPane1, jScrollPane2};
        
        for(JComponent input : inputs)
        {
            input.putClientProperty("FlatLaf.style",
                    "arc:15;" +
                    "borderWidth : 2;" +
                    "borderColor: #00D25A;" +
                    "background: #323232; " + 
                    "foreground: #ffffff;");
        }
        
        
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
        jLabelLogo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCategories = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstProduct = new javax.swing.JList<>();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBack.setBackground(new java.awt.Color(0, 210, 90));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(0, 0, 0));
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BROWSE PRODUCTS");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addGap(32, 32, 32)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(28, 28, 28)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
        
        this.dispose();
        
    }//GEN-LAST:event_btnBackActionPerformed

    private void lstCategoriesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCategoriesValueChanged
        // TODO add your handling code here:
        //Get Selected Category
        String selectedCategory = lstCategories.getSelectedValue();

        if (selectedCategory == null)
        {
            return;
        }

        DefaultListModel<Product> productsModel = new DefaultListModel<>();

        for (Product p : allProducts)
        //  Check if the product's class name matches the selected category
        // (p.getClass().getName() == "models.Heatpump")
        if(p.getClass().getName().equals("models." + selectedCategory))
        {
            productsModel.addElement(p);
        }
        lstProduct.setModel(productsModel);
    }//GEN-LAST:event_lstCategoriesValueChanged

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
                new BrowseProductsGuest().setVisible(true);
            }
        }); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstCategories;
    private javax.swing.JList<Product> lstProduct;
    // End of variables declaration//GEN-END:variables
}
