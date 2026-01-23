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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import models.DBManager;
import models.Product;
import models.Staff;

/**
 *
 * @author 30512007
 */
public class ProductMenu extends javax.swing.JFrame {
    
    private final Color BG_DARK = new Color(24, 24, 24); //Background colour
    private final Color BTN_DEFAULT = new Color(50,50,50);
    private final Color ACCENT_GREEN = new Color(0, 210, 90); //Bright green
    private final Color TEXT_WHITE = Color.WHITE;
    private final Color TEXT_BLACK = Color.BLACK;
    
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ProductMenu.class.getName());

    private ArrayList<Product> currentCategoryProducts = new ArrayList<>();
    
    private ArrayList<Product> allProducts;
    
    private Staff loggedInStaff;
    
    public ProductMenu()
    {
        initComponents();
        applyCustomDesign();
    }
    /**
     * Creates new form ProductMenu
     */
    public ProductMenu(Staff staffIn) {
        DBManager db = new DBManager();
        allProducts = db.loadProducts();
        
        initComponents();
        applyCustomDesign();

        this.loggedInStaff = staffIn;       
        
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
        
        btnAddProduct.setBorder(UIManager.getBorder("Button.border"));
        btnAddProduct.setOpaque(false);
        btnAddProduct.setContentAreaFilled(true);
        btnAddProduct.setFocusPainted(false);
        btnAddProduct.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAddProduct.putClientProperty("FlatLaf.style", 
                "arc: 25;" +
                "borderWidth: 0;" );
        
        
        //Buttons to Opagque and round shape)
        JButton[] btns = {jButton1, btnBubbleSort, btnDeleteProduct, btnEditProduct, btnBinarySearch, btnLinearSearch, btnSelectionSort};
        
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
        JComponent[] inputs = {jScrollPane1, jScrollPane2, txtSearchPrice};
        
        for(JComponent input : inputs)
        {
            input.putClientProperty("FlatLaf.style",
                    "arc:15;" +
                    "borderWidth : 2;" +
                    "borderColor: #00D25A;" +
                    "background: #323232; " + 
                    "foreground: #ffffff;");
        }
        txtSearchPrice.setCaretColor(Color.WHITE);
        txtSearchPrice.putClientProperty("JComponent.roundRect", true);
        
        JList<?>[] lists = {lstProduct, lstCategories};
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

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCategories = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstProduct = new javax.swing.JList<>();
        btnEditProduct = new javax.swing.JButton();
        btnDeleteProduct = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnBubbleSort = new javax.swing.JButton();
        btnSelectionSort = new javax.swing.JButton();
        txtSearchPrice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnLinearSearch = new javax.swing.JButton();
        btnBinarySearch = new javax.swing.JButton();
        btnAddProduct = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 0));

        jButton1.setBackground(new java.awt.Color(50, 50, 50));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("RETURN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CATEGORIES");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PRODUCTS");

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
        lstProduct.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstProductValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstProduct);

        btnEditProduct.setBackground(new java.awt.Color(50, 50, 50));
        btnEditProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnEditProduct.setText("EDIT PRODUCT");
        btnEditProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProductActionPerformed(evt);
            }
        });

        btnDeleteProduct.setBackground(new java.awt.Color(50, 50, 50));
        btnDeleteProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDeleteProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteProduct.setText("DELETE PRODUCT");
        btnDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProductActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SORT BY:");

        btnBubbleSort.setBackground(new java.awt.Color(50, 50, 50));
        btnBubbleSort.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBubbleSort.setForeground(new java.awt.Color(255, 255, 255));
        btnBubbleSort.setText("Bubble Sort");
        btnBubbleSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBubbleSortActionPerformed(evt);
            }
        });

        btnSelectionSort.setBackground(new java.awt.Color(50, 50, 50));
        btnSelectionSort.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSelectionSort.setForeground(new java.awt.Color(255, 255, 255));
        btnSelectionSort.setText("Selection Sort");
        btnSelectionSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectionSortActionPerformed(evt);
            }
        });

        txtSearchPrice.setBackground(new java.awt.Color(50, 50, 50));
        txtSearchPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearchPrice.setForeground(new java.awt.Color(255, 255, 255));
        txtSearchPrice.setCaretColor(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ENTER PRODUCT PRICE:");

        btnLinearSearch.setBackground(new java.awt.Color(50, 50, 50));
        btnLinearSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLinearSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnLinearSearch.setText("Linear Search");
        btnLinearSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLinearSearchActionPerformed(evt);
            }
        });

        btnBinarySearch.setBackground(new java.awt.Color(50, 50, 50));
        btnBinarySearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBinarySearch.setForeground(new java.awt.Color(255, 255, 255));
        btnBinarySearch.setText("Binary Search");
        btnBinarySearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBinarySearchActionPerformed(evt);
            }
        });

        btnAddProduct.setBackground(new java.awt.Color(0, 210, 90));
        btnAddProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddProduct.setForeground(new java.awt.Color(0, 0, 0));
        btnAddProduct.setText("ADD PRODUCT");
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PRODUCT MANAGEMENT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 426, Short.MAX_VALUE))
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBubbleSort, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSelectionSort, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSearchPrice)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnLinearSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnBinarySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBinarySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSelectionSort, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBubbleSort, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLinearSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEditProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(btnDeleteProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstProductValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstProductValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_lstProductValueChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        StaffHome staffHome = new StaffHome(this.loggedInStaff);
        staffHome.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lstCategoriesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCategoriesValueChanged
        // TODO add your handling code here:
        
        currentCategoryProducts.clear();
        
        String selectedCategory = lstCategories.getSelectedValue();
        DefaultListModel<Product> productsModel = new DefaultListModel<>();
        
        // Loop through all products
        for (Product p : allProducts)
        {
            
            if(p.getClass().getName().equals("models." + selectedCategory))
            {
                // It's a match! Add it to the list.
                productsModel.addElement(p);
                
                currentCategoryProducts.add(p);
            }
        }
        // Update the listbox with the filtered list
        lstProduct.setModel(productsModel);
    }//GEN-LAST:event_lstCategoriesValueChanged

    private void btnEditProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProductActionPerformed
        // TODO add your handling code here:
        //Validation
        // Check if an item is actually selected in the list (-1 means no selection)
        if (lstProduct.getSelectedIndex()!= -1)
        {
            // Retrieve the selected object and cast it to the Product class
            Object selectedProductObject = (Object)lstProduct.getSelectedValue();
            Product selectedProduct = (Product) selectedProductObject;
            //Navigation
            EditProduct editProduct = new EditProduct(this.loggedInStaff,selectedProduct);
            editProduct.setVisible(true);
            this.dispose();
            
        }
        
        else
        {
            // Show error if the user clicks Edit without highlighting a row
            JOptionPane.showMessageDialog(this, "Choose a Product First", "Product Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnEditProductActionPerformed

    private void btnDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProductActionPerformed
        // TODO add your handling code here:
        // Ensure a product is selected before attempting deletion
        if (lstProduct.getSelectedIndex() != -1)
        {
            
            Product selectedProduct = lstProduct.getSelectedValue();
            
            //Database Deletion
            // Initialize DB connection and delete the record using the unique Product ID
            DBManager db = new DBManager();
            db.deleteProduct(selectedProduct.getProductId());
            
            //UpdateUI
            // Update the visual list immediately by removing the item from the model
            DefaultListModel productModel = (DefaultListModel)lstProduct.getModel();
            productModel.remove(lstProduct.getSelectedIndex());
            
            // Refresh the local master list to ensure data synchronization
            allProducts = db.loadProducts();
            
            JOptionPane.showMessageDialog(this, "Deleted Product successfully!");
        }
        else
        {
            // Handle case where no selection was made
            JOptionPane.showMessageDialog(this, "Error: Select a Product First");
        } 
    }//GEN-LAST:event_btnDeleteProductActionPerformed

    private void btnBubbleSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBubbleSortActionPerformed
        // TODO add your handling code here:
        //Get items from the list, and not the database
        DefaultListModel<Product> currentModel = (DefaultListModel<Product>) lstProduct.getModel();
        ArrayList<Product> productList = new ArrayList<>();
        
        //copy items from list to array list
        for (int i = 0; i < currentModel.getSize();i++)
        {
            productList.add(currentModel.getElementAt(i));
        }
        
        //Bubble Sort (Sort ArrayList)
        int n = productList.size();
        //use boolean flagto control if another pass through the list is needed
        boolean swapRequired = true;
        
        //Outer Loop
        //The while loop  keeps running as long as a swap happened in the previous pass
        //If no swaps occur, the list is orted and is stopped
        while (swapRequired)
        {
            swapRequired = false; //Assume sorted until proven
            
            //Loop stops at size -2 to compare a with a+1
            for (int a=0; a<= n -2; a++)
            {
                //Compare Price
                if (productList.get(a).getPrice() > productList.get(a+1).getPrice())
                {
                    //Swap
                    Product temp = productList.get(a);
                    productList.set(a, productList.get(a+1));
                    productList.set(a+1,temp);
                    
                    swapRequired = true;
                    
                }
            }
        }
        
        //Updating the List Box 
        //Clear Existing list and add sorted list back
        currentModel.clear();
        for (Product p : productList)
        {
            currentModel.addElement(p);
        }
    }//GEN-LAST:event_btnBubbleSortActionPerformed

    private void btnSelectionSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectionSortActionPerformed
        // TODO add your handling code here:
        //Get items from the list, and not the database
        DefaultListModel<Product> currentModel = (DefaultListModel<Product>) lstProduct.getModel();
        ArrayList<Product> productList = new ArrayList<>();
        
        //copy items from list to array list
        for (int i = 0; i < currentModel.getSize();i++)
        {
            productList.add(currentModel.getElementAt(i));
        }
        
        //Selection Sort
        //GO through each position we want to place the cheapest product
        //a is the position are currently tyring to fit correctly
        int n = productList.size();
        
        
        for (int a = 0; a<n-1; a++)
        {
            //Assume product at a is cheapest for now
            int min = a;
            //look through list to find actual cheapest
            for (int b = a+1; b<n; b++)
            {
                if (productList.get(min).getPrice()>productList.get(b).getPrice())
                {
                    min=b; //update the index of cheapest product
                }
            }
            
            //Swap the product at position a with the cheapest one we found at min
            Product tempProduct = productList.get(a);
            productList.set(a,productList.get(min)); 
            productList.set(min, tempProduct);
            
        }
        
        //Update GUI
        currentModel.clear();
        for (Product p: productList)
        {
            currentModel.addElement(p);
        }
    }//GEN-LAST:event_btnSelectionSortActionPerformed

    private void btnLinearSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLinearSearchActionPerformed
        // TODO add your handling code here:
        DefaultListModel resultModel = new DefaultListModel();
        
        try
        {
            double targetPrice = Double.parseDouble(txtSearchPrice.getText());
            
            
            //Get current List of products from screen
            boolean isFound = false; //Glag to remeber if its found
            //Loop to go through every product in the List
            for (Product p : currentCategoryProducts)
            {
                //Compare to check if the products price match the target
                if (p.getPrice() == targetPrice)
                {
                    isFound = true;
                    resultModel.addElement(p);
                }
            }
            //If not found
            if(!isFound)
            {
                resultModel.addElement("Not Found");
            }
            
            //Updating Screen
            lstProduct.setModel(resultModel);
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Please enter a valid Number for price");
        }
    }//GEN-LAST:event_btnLinearSearchActionPerformed

    private void btnBinarySearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBinarySearchActionPerformed
        // TODO add your handling code here:
        DefaultListModel resultModel = new DefaultListModel();
        
        try
        {
            double targetPrice = Double.parseDouble(txtSearchPrice.getText());
            //Get current List of products from screen
            //COnvert ListModel to ArrayList for easier index access
            ListModel<Product> currentModel = lstProduct.getModel();
            ArrayList<Product> productList = new ArrayList<>();
            
            for (int i = 0; i < currentModel.getSize(); i++)
            {
                productList.add(currentModel.getElementAt(i));
            }
            
            //Define Search Boundaries
            int min = 0;
            int max = productList.size() - 1;
            
            //Loop to keep searching while the range is valid
            while (min<= max)
            {
                //FInding the middle Position
                int middle= (min + max)/2;
                Product middleProduct = productList.get(middle);
                
                //Check the mIDdle
                if (middleProduct.getPrice() == targetPrice)
                {
                    //Found
                    resultModel.addElement(middleProduct);
                    lstProduct.setModel(resultModel);
                    return; //Stopping here if founf
                }
                else
                {
                    //Decide to go left or right
                    if (targetPrice < middleProduct.getPrice())
                    {
                        //Target is smaller (cheaper) search left
                        max = middle - 1;
                    }
                    else
                    {
                        //Target is larger (expensive) search right
                        min = middle +1;
                    }
                }
            }
            //If loop finishes and didnt find it
            resultModel.addElement("Not Found");
            lstProduct.setModel(resultModel);
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for price");
        }
    }//GEN-LAST:event_btnBinarySearchActionPerformed

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        // TODO add your handling code here:
        AddProduct addProduct = new AddProduct(this.loggedInStaff);
        addProduct.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnAddProductActionPerformed

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
                new ProductMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnBinarySearch;
    private javax.swing.JButton btnBubbleSort;
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.JButton btnEditProduct;
    private javax.swing.JButton btnLinearSearch;
    private javax.swing.JButton btnSelectionSort;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstCategories;
    private javax.swing.JList<Product> lstProduct;
    private javax.swing.JTextField txtSearchPrice;
    // End of variables declaration//GEN-END:variables
}
