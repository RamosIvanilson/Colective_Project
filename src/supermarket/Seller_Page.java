
package supermarket;

import java.sql.*;
import connection.DatabaseConnection;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import scroll.ScrollBarCustom;


public class Seller_Page extends javax.swing.JFrame {
    
//    private final Connection con;
    private int prod_ID = 0;
    public Seller_Page() {
        initComponents();
        init();
        Category_Combo.setSelectedItem("=====");
        prod_scroll.setVerticalScrollBar(new ScrollBarCustom());
        prod_scroll.getVerticalScrollBar().setUnitIncrement(16);
        prod_Qty.setEditable(false);
        update_prod.setVisible(false);
        delete_prod.setVisible(false);
        Add.setVisible(false);
        Clear.setVisible(false);
    }
    
    private void init() {
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketmanagement?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            PreparedStatement ps = con.prepareStatement("SELECT id, name, quantity, price, category FROM products");

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String ID = String.valueOf(rs.getString("id"));
                String Name = rs.getString("name");
                String Quantity = rs.getString("quantity");
                String Price = rs.getString("price");
                String category = rs.getString("category");
                
                String tData[] = {ID, Name, Quantity, Price, category};
                DefaultTableModel tableModel = (DefaultTableModel)prodTable.getModel();
                tableModel.addRow(tData);
            }
            rs.close();
            ps.close();
            
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        Category_Combo.addItem("=====");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketmanagement?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            PreparedStatement ps = con.prepareStatement("SELECT category FROM products_category");

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String category = rs.getString("category");
                Category_Combo.addItem(category);
            }
            rs.close();
            ps.close();
            
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void Refresh_Table() {
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketmanagement?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            PreparedStatement ps = con.prepareStatement("SELECT id, name, quantity, price, category FROM products");

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String ID = String.valueOf(rs.getString("id"));
                String Name = rs.getString("name");
                String Quantity = rs.getString("quantity");
                String Price = rs.getString("price");
                String category = rs.getString("category");
                
                String tData[] = {ID, Name, Quantity, Price, category};
                DefaultTableModel tableModel = (DefaultTableModel)prodTable.getModel();
                tableModel.addRow(tData);
            }
            rs.close();
            ps.close();
            
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void Filter_Data_From_Table(String categoryString) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketmanagement?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            PreparedStatement ps = con.prepareStatement("SELECT id, name, quantity, price, category FROM products WHERE category=?");
            ps.setString(1, categoryString);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String ID = String.valueOf(rs.getString("id"));
                String Name = rs.getString("name");
                String Quantity = rs.getString("quantity");
                String Price = rs.getString("price");
                String Category = rs.getString("category");
                
                String tData[] = {ID, Name, Quantity, Price, Category};
                DefaultTableModel tableModel = (DefaultTableModel)prodTable.getModel();
                tableModel.addRow(tData);
            }
            rs.close();
            ps.close();
            
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void Search_Data_From_Table(String nameString) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketmanagement?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            PreparedStatement ps = con.prepareStatement("SELECT id, name, quantity, price, category FROM products WHERE name LIKE '%"+nameString+"%'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String ID = String.valueOf(rs.getString("id"));
                String Name = rs.getString("name");
                String Quantity = rs.getString("quantity");
                String Price = rs.getString("price");
                String Category = rs.getString("category");
                
                String tData[] = {ID, Name, Quantity, Price, Category};
                DefaultTableModel tableModel = (DefaultTableModel)prodTable.getModel();
                tableModel.addRow(tData);
            }
            rs.close();
            ps.close();
            
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void Search_Data_From_Table_With_Category(String nameString, String categoryString) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketmanagement?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            PreparedStatement ps = con.prepareStatement("SELECT id, name, quantity, price, category FROM products WHERE name LIKE '%"+nameString+"%' AND category='"+categoryString+"'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String ID = String.valueOf(rs.getString("id"));
                String Name = rs.getString("name");
                String Quantity = rs.getString("quantity");
                String Price = rs.getString("price");
                String Category = rs.getString("category");
                
                String tData[] = {ID, Name, Quantity, Price, Category};
                DefaultTableModel tableModel = (DefaultTableModel)prodTable.getModel();
                tableModel.addRow(tData);
            }
            rs.close();
            ps.close();
            
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    ImageIcon  Get_Product_Image(int id) {
        ImageIcon schImage = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketmanagement?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            PreparedStatement ps = con.prepareStatement("SELECT image FROM products WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                schImage = new ImageIcon(rs.getBytes("image"));
            }
            rs.close();
            ps.close();
            
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return schImage;
    }
    
    private void Add_Product_To_Table() {
        if(add_prod_to_pay.getRowCount() == 0) {
            int Discount_Card = JOptionPane.showConfirmDialog(this, "Does the Customer have a Family Point discount card?", null, JOptionPane.YES_NO_OPTION);
            if(Discount_Card == JOptionPane.YES_OPTION) {
                
            } else if(Discount_Card == JOptionPane.NO_OPTION){
                if(!prod_Qty.getText().equals("")) {
                    String prodName = prod_Name.getText();
                    int prodQuantity = Integer.parseInt(prod_Qty.getText());
                    float prodPrice = Float.parseFloat(prod_Price.getText());
                    String tData[] = {String.valueOf(this.prod_ID), prodName, String.valueOf(prodQuantity), String.valueOf(prodPrice)};
                    DefaultTableModel tableModel = (DefaultTableModel)add_prod_to_pay.getModel();
                    tableModel.addRow(tData);
                    SetBill();
                    Border border = new Border();
                    border.setColor(new Color(51,153,255));
                    prod_Qty.setBorder(border);
                }
            }
        } else {
//            int id = Integer.parseInt(prodTable.getValueAt(prodTable.getSelectedRow(), 0).toString());
//            String prod_name = prodTable.getValueAt(prodTable.getSelectedRow(), 1).toString();
            if(!prod_Qty.getText().equals("")) {
                int prod_qty = Integer.parseInt(prodTable.getValueAt(prodTable.getSelectedRow(), 2).toString());
                if(prod_qty > 0) {
                    if(!Already_Added(this.prod_ID)) {
                        String prodName = prod_Name.getText();
                        int prodQuantity = Integer.parseInt(prod_Qty.getText());
                        float prodPrice = Float.parseFloat(prod_Price.getText());
                        String tData[] = {String.valueOf(this.prod_ID), prodName, String.valueOf(prodQuantity), String.valueOf(prodPrice)};
                        DefaultTableModel tableModel = (DefaultTableModel)add_prod_to_pay.getModel();
                        tableModel.addRow(tData);
                        SetBill();
                        Border border = new Border();
                        border.setColor(new Color(51,153,255));
                        prod_Qty.setBorder(border);
                    }
                } else if(prod_qty == 0){
                    JOptionPane.showMessageDialog(null, "Out Of Stock");
                    prod_Name.setText("");
                    prod_Qty.setText("");
                    prod_image.setImage(null);
                }
            } else {
                Border border = new Border();
                border.setColor(Color.RED);
                prod_Qty.setBorder(border);
            }
        }
    }
    
    private boolean Already_Added(int id) {
        boolean added = false;
        for(int i=0;i<add_prod_to_pay.getRowCount();i++) {
            int check = Integer.parseInt(String.valueOf(add_prod_to_pay.getValueAt(i, 0)));
            if(id == check) {
                added = true;
                return added;
            }
        }
        return added;
    }
    
    private float Get_Price_From_DB(int id) {
        float price = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketmanagement?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            PreparedStatement ps = con.prepareStatement("SELECT price FROM products WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                price = rs.getFloat("price");
            }
            rs.close();
            ps.close();
            
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return price;
    }
    
    private void SetBill() {
        float bill = 0;
        for(int i=0;i<add_prod_to_pay.getRowCount();i++) {
            float price = Float.parseFloat(add_prod_to_pay.getValueAt(i, 3).toString());
            bill += price;
            String sum = String.valueOf(bill);
            BILL.setText(sum + " RON");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        prod_Name = new javax.swing.JTextField();
        prod_Qty = new javax.swing.JTextField();
        Category_Combo = new javax.swing.JComboBox<>();
        prod_scroll = new javax.swing.JScrollPane();
        prodTable = new javax.swing.JTable();
        BILL = new javax.swing.JLabel();
        prod_image = new swing.ImageAvatar();
        Add = new supermarket.Button();
        Clear = new supermarket.Button();
        Pay_Bill = new supermarket.Button();
        Filter = new supermarket.Button();
        Refresh = new supermarket.Button();
        search_from_table = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        add_prod_to_pay = new javax.swing.JTable();
        prod_Price = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        update_prod = new supermarket.Button();
        delete_prod = new supermarket.Button();
        button6 = new supermarket.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Product's Name:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Quantity:");

        prod_Name.setEditable(false);
        prod_Name.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        prod_Name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));

        prod_Qty.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        prod_Qty.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        prod_Qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                prod_QtyKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prod_QtyKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                prod_QtyKeyTyped(evt);
            }
        });

        prodTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Prod ID", "Prod Name", "Prod  Quantity", "Prod Price", "Prod Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        prodTable.getTableHeader().setReorderingAllowed(false);
        prodTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prodTableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                prodTableMousePressed(evt);
            }
        });
        prod_scroll.setViewportView(prodTable);
        if (prodTable.getColumnModel().getColumnCount() > 0) {
            prodTable.getColumnModel().getColumn(0).setResizable(false);
            prodTable.getColumnModel().getColumn(1).setResizable(false);
            prodTable.getColumnModel().getColumn(2).setResizable(false);
        }

        BILL.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        BILL.setForeground(new java.awt.Color(51, 153, 255));
        BILL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        prod_image.setBorderSize(2);
        prod_image.setBorderSpace(-1);

        Add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        Add.setForeground(new java.awt.Color(51, 153, 255));
        Add.setText("ADD");
        Add.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Clear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        Clear.setForeground(new java.awt.Color(51, 153, 255));
        Clear.setText("CLEAR");
        Clear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        Pay_Bill.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        Pay_Bill.setForeground(new java.awt.Color(51, 153, 255));
        Pay_Bill.setText("PAY");
        Pay_Bill.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Pay_Bill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pay_BillActionPerformed(evt);
            }
        });

        Filter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        Filter.setForeground(new java.awt.Color(51, 153, 255));
        Filter.setText("FILTER");
        Filter.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterActionPerformed(evt);
            }
        });

        Refresh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        Refresh.setForeground(new java.awt.Color(51, 153, 255));
        Refresh.setText("REFRESH");
        Refresh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        search_from_table.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        search_from_table.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        search_from_table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        search_from_table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_from_tableKeyReleased(evt);
            }
        });

        add_prod_to_pay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Prod ID", "Prod Name", "Prod Quantity", "Prod Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        add_prod_to_pay.getTableHeader().setReorderingAllowed(false);
        add_prod_to_pay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                add_prod_to_payMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(add_prod_to_pay);
        if (add_prod_to_pay.getColumnModel().getColumnCount() > 0) {
            add_prod_to_pay.getColumnModel().getColumn(0).setResizable(false);
            add_prod_to_pay.getColumnModel().getColumn(1).setResizable(false);
            add_prod_to_pay.getColumnModel().getColumn(2).setResizable(false);
            add_prod_to_pay.getColumnModel().getColumn(3).setResizable(false);
        }

        prod_Price.setEditable(false);
        prod_Price.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        prod_Price.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        prod_Price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                prod_PriceKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Price");

        update_prod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        update_prod.setForeground(new java.awt.Color(51, 153, 255));
        update_prod.setText("UPDATE");
        update_prod.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        update_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_prodActionPerformed(evt);
            }
        });

        delete_prod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        delete_prod.setForeground(new java.awt.Color(51, 153, 255));
        delete_prod.setText("DELETE");
        delete_prod.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        delete_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_prodActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(prod_image, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(prod_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(62, 62, 62)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(prod_Qty, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(prod_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(update_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(delete_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(BILL, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(Category_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(search_from_table, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Filter, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(prod_scroll))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(Pay_Bill, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(236, 236, 236)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(prod_image, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prod_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prod_Qty, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prod_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(update_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Category_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Filter, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search_from_table, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(prod_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BILL, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(Pay_Bill, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 1090, 810));

        button6.setForeground(new java.awt.Color(255, 255, 255));
        button6.setText("X");
        button6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });
        jPanel1.add(button6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1072, 0, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1113, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void prodTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prodTableMouseClicked
        
    }//GEN-LAST:event_prodTableMouseClicked

    private void prodTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prodTableMousePressed
        int id = Integer.parseInt(prodTable.getValueAt(prodTable.getSelectedRow(), 0).toString());
        this.prod_ID = id;
        String prod_name = prodTable.getValueAt(prodTable.getSelectedRow(), 1).toString();
        String prod_qty = prodTable.getValueAt(prodTable.getSelectedRow(), 2).toString();
        String prod_price = String.valueOf(Get_Price_From_DB(id));
        ImageIcon imageIcon = Get_Product_Image(id);
        prod_image.setImage(imageIcon);
        prod_Name.setText(prod_name);
        prod_Price.setText(prod_price);
        prod_Qty.setEditable(true);
        prod_Qty.setText("");
        Add.setVisible(true);
        Clear.setVisible(true);
        update_prod.setVisible(false);
        delete_prod.setVisible(false);
    }//GEN-LAST:event_prodTableMousePressed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        this.dispose();
    }//GEN-LAST:event_button6ActionPerformed

    private void FilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterActionPerformed
        prodTable.setModel(new DefaultTableModel(null, new String[]{"Prod ID", "Prod Name", "Prod Quantity", "Prod Price", "Prod Category"}));
        Filter_Data_From_Table(Category_Combo.getSelectedItem().toString());
        Category_Combo.setSelectedItem("=====");
    }//GEN-LAST:event_FilterActionPerformed

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        Refresh_Table();
    }//GEN-LAST:event_RefreshActionPerformed

    private void search_from_tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_from_tableKeyReleased
        if(Category_Combo.getSelectedItem().toString().equals("=====")) {
            prodTable.setModel(new DefaultTableModel(null, new String[]{"Prod ID", "Prod Name", "Prod Quantity", "Prod Price", "Prod Category"}));
            Search_Data_From_Table(search_from_table.getText());
        } else {
            prodTable.setModel(new DefaultTableModel(null, new String[]{"Prod ID", "Prod Name", "Prod Quantity", "Prod Price", "Prod Category"}));
            Search_Data_From_Table_With_Category(search_from_table.getText(), Category_Combo.getSelectedItem().toString());
        }
    }//GEN-LAST:event_search_from_tableKeyReleased

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        Add_Product_To_Table();
    }//GEN-LAST:event_AddActionPerformed

    private void prod_QtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prod_QtyKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c) || Character.isISOControl(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_prod_QtyKeyTyped

    private void prod_PriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prod_PriceKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_prod_PriceKeyTyped

    private void prod_QtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prod_QtyKeyReleased
        float prodPrice = Float.parseFloat(prodTable.getValueAt(prodTable.getSelectedRow(), 3).toString());
        if(!prod_Qty.getText().equals("")) {
            if(prod_Qty.getText().equals("1")) {
                prod_Price.setText(String.valueOf(prodTable.getValueAt(prodTable.getSelectedRow(), 3).toString()));
            } else if(Integer.parseInt(prod_Qty.getText()) > Integer.parseInt(prodTable.getValueAt(prodTable.getSelectedRow(), 2).toString())) {
                JOptionPane.showMessageDialog(null, "The maximum quantity is " + prodTable.getValueAt(prodTable.getSelectedRow(), 2).toString() + "!");
                prod_Qty.setText("");
            } else {
                float prodQuantity = Float.parseFloat(prod_Qty.getText());
                float price = prodPrice*prodQuantity;
                prod_Price.setText(String.valueOf(price));
            }
        } else {
            prod_Price.setText(String.valueOf(prodTable.getValueAt(prodTable.getSelectedRow(), 3).toString()));
        }
    }//GEN-LAST:event_prod_QtyKeyReleased

    private void prod_QtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prod_QtyKeyPressed
        
    }//GEN-LAST:event_prod_QtyKeyPressed

    private void add_prod_to_payMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_prod_to_payMousePressed
        int id = Integer.parseInt(add_prod_to_pay.getValueAt(add_prod_to_pay.getSelectedRow(), 0).toString());
        String prod_name = add_prod_to_pay.getValueAt(add_prod_to_pay.getSelectedRow(), 1).toString();
        String prod_qty = add_prod_to_pay.getValueAt(add_prod_to_pay.getSelectedRow(), 2).toString();
        String prod_price = String.valueOf(Get_Price_From_DB(id));
        ImageIcon imageIcon = Get_Product_Image(id);
        prod_image.setImage(imageIcon);
        prod_Name.setText(prod_name);
        prod_Qty.setText(prod_qty);
        prod_Price.setText(prod_price);
        prod_Qty.setEditable(true);
        Add.setVisible(false);
        Clear.setVisible(false);
        update_prod.setVisible(true);
        delete_prod.setVisible(true);
    }//GEN-LAST:event_add_prod_to_payMousePressed

    private void update_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_prodActionPerformed
        if(!prod_Qty.getText().equals("")) {
            String prod_price = prod_Price.getText();
            String prod_qty = prod_Qty.getText();
            add_prod_to_pay.setValueAt(prod_qty, add_prod_to_pay.getSelectedRow(), 2);
            add_prod_to_pay.setValueAt(prod_price, add_prod_to_pay.getSelectedRow(), 3);
            SetBill();
        } else {
            Border border = new Border();
            border.setColor(Color.RED);
            prod_Qty.setBorder(border);
        }
    }//GEN-LAST:event_update_prodActionPerformed

    private void delete_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_prodActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel)add_prod_to_pay.getModel();
        if(add_prod_to_pay.getSelectedRowCount() == 1) {
            tableModel.removeRow(add_prod_to_pay.getSelectedRow());
            SetBill();
        } else{
            if(add_prod_to_pay.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Table empty!!");
            } else {
                JOptionPane.showMessageDialog(null, "Please select a single item to delete!");
            }
        }
    }//GEN-LAST:event_delete_prodActionPerformed

    private void Pay_BillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pay_BillActionPerformed
        if(add_prod_to_pay.getRowCount() > 0) {
            Map<Integer, Integer> Prod_List = new LinkedHashMap<>();
            for(int i=0;i<add_prod_to_pay.getRowCount();i++) {
                int id = Integer.parseInt(add_prod_to_pay.getValueAt(i, 0).toString());
                int qty = Integer.parseInt(add_prod_to_pay.getValueAt(i, 2).toString());
                Prod_List.put(id, qty);
            }
            new PaymentMethod(Prod_List).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No item added to chart!");
        }
    }//GEN-LAST:event_Pay_BillActionPerformed
    
    private class Border extends EmptyBorder {
        
        private Color focuscolor = new Color(128, 189, 255);
        private Color color = new Color(206, 212, 218);

        public Color getFocuscolor() {
            return focuscolor;
        }

        public void setFocuscolor(Color focuscolor) {
            this.focuscolor = focuscolor;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
        
        public Border(int border) {
            super(border, border, border, border);
        }

        public Border() {
            this(5);
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D)g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if(c.isFocusOwner()) {
                g2.setColor(focuscolor);
            } else {
                g2.setColor(color);
            }
            g2.drawRect(x, y, width - 1, height - 1);
            g2.dispose();
        }
        
    }
    
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Seller_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Seller_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Seller_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Seller_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Seller_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private supermarket.Button Add;
    private javax.swing.JLabel BILL;
    private javax.swing.JComboBox<String> Category_Combo;
    private supermarket.Button Clear;
    private supermarket.Button Filter;
    private supermarket.Button Pay_Bill;
    private supermarket.Button Refresh;
    private javax.swing.JTable add_prod_to_pay;
    private supermarket.Button button6;
    private supermarket.Button delete_prod;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable prodTable;
    private javax.swing.JTextField prod_Name;
    private javax.swing.JTextField prod_Price;
    private javax.swing.JTextField prod_Qty;
    private swing.ImageAvatar prod_image;
    private javax.swing.JScrollPane prod_scroll;
    private javax.swing.JTextField search_from_table;
    private supermarket.Button update_prod;
    // End of variables declaration//GEN-END:variables
}
