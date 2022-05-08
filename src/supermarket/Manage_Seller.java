package supermarket;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

public class Manage_Seller extends javax.swing.JFrame {
    
    private String imagePath;
    
    public Manage_Seller() {
        initComponents();
        init();
        editB.setVisible(false);
        SetShift_start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        s_gender = new javax.swing.JComboBox<>();
        addB = new javax.swing.JButton();
        clearB = new javax.swing.JButton();
        editB = new javax.swing.JButton();
        delectB = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        s_table = new javax.swing.JTable();
        s_photo = new swing.ImageAvatar();
        upload_photo = new supermarket.Button();
        jLabel9 = new javax.swing.JLabel();
        s_shift_end = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        s_name = new javax.swing.JTextField();
        s_surname = new javax.swing.JTextField();
        s_password = new javax.swing.JTextField();
        s_shift_start = new javax.swing.JComboBox<>();
        button1 = new supermarket.Button();
        button2 = new supermarket.Button();
        logout = new supermarket.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 204, 255));
        jLabel2.setText("MANAGE SELLERS");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 204, 255));
        jLabel5.setText("SURNAME");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 204, 255));
        jLabel6.setText("NAME");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 204, 255));
        jLabel8.setText("GENDER");

        s_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        s_gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_genderActionPerformed(evt);
            }
        });

        addB.setBackground(new java.awt.Color(51, 204, 255));
        addB.setForeground(new java.awt.Color(255, 255, 255));
        addB.setText("Add");
        addB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBActionPerformed(evt);
            }
        });

        clearB.setBackground(new java.awt.Color(51, 204, 255));
        clearB.setForeground(new java.awt.Color(255, 255, 255));
        clearB.setText("Clear");
        clearB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBActionPerformed(evt);
            }
        });

        editB.setBackground(new java.awt.Color(51, 204, 255));
        editB.setForeground(new java.awt.Color(255, 255, 255));
        editB.setText("Update");
        editB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBActionPerformed(evt);
            }
        });

        delectB.setBackground(new java.awt.Color(51, 204, 255));
        delectB.setForeground(new java.awt.Color(255, 255, 255));
        delectB.setText("Delete");
        delectB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delectBActionPerformed(evt);
            }
        });

        s_table.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        s_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "SURNAME", "PASSWORD", "GENDER", "SHIFT START", "SHIFT END"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        s_table.setRowHeight(25);
        s_table.setSelectionBackground(new java.awt.Color(0, 204, 255));
        s_table.getTableHeader().setReorderingAllowed(false);
        s_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                s_tableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(s_table);
        if (s_table.getColumnModel().getColumnCount() > 0) {
            s_table.getColumnModel().getColumn(0).setResizable(false);
            s_table.getColumnModel().getColumn(1).setResizable(false);
            s_table.getColumnModel().getColumn(2).setResizable(false);
            s_table.getColumnModel().getColumn(3).setResizable(false);
            s_table.getColumnModel().getColumn(4).setResizable(false);
            s_table.getColumnModel().getColumn(5).setResizable(false);
            s_table.getColumnModel().getColumn(6).setResizable(false);
        }

        s_photo.setBorderSize(2);
        s_photo.setBorderSpace(-1);

        upload_photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        upload_photo.setForeground(new java.awt.Color(51, 153, 255));
        upload_photo.setText("Upload Photo");
        upload_photo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        upload_photo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upload_photoActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 204, 255));
        jLabel9.setText("PASSWORD");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 204, 255));
        jLabel10.setText("SHIFT START");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 204, 255));
        jLabel11.setText("SHIFT END");

        s_shift_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_shift_startActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 973, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(s_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(281, 281, 281)
                                .addComponent(delectB, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editB, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addB, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(clearB, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(s_name)
                                    .addComponent(s_surname, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                    .addComponent(s_password)
                                    .addComponent(s_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(s_shift_start, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(s_shift_end, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(0, 29, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(upload_photo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(412, 412, 412)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                            .addComponent(s_name, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(s_shift_start, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(s_shift_end, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(s_surname, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(s_password, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(s_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(112, 112, 112))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(s_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(upload_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delectB, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editB, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addB, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                .addContainerGap())
        );

        button1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Manage Categories");
        button1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("Manage Products");
        button2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        logout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setText("LOGOUT");
        logout.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void SetShift_start() {
        s_shift_start.addItem("8:00");
        s_shift_start.addItem("8:30");
        s_shift_start.addItem("9:00");
        s_shift_start.addItem("9:30");
        s_shift_start.addItem("10:00");
        s_shift_start.addItem("10:30");
        s_shift_start.addItem("11:00");
        s_shift_start.addItem("11:30");
        s_shift_start.addItem("12:00");
        s_shift_start.addItem("12:30");
        s_shift_start.addItem("13:00");
        s_shift_start.addItem("13:30");
        s_shift_start.addItem("14:00");
        s_shift_start.addItem("14:30");
        s_shift_start.addItem("15:00");
        s_shift_start.addItem("15:30");
        s_shift_start.addItem("16:00");
        s_shift_start.addItem("16:30");
        s_shift_start.addItem("17:00");
        s_shift_start.addItem("17:30");
        s_shift_start.addItem("18:00");
    }
    
    private void Set_shift_end() {
        if(s_shift_start.getSelectedItem().equals("8:00")) {
            s_shift_end.removeAllItems();
            s_shift_end.addItem("12:00");
            s_shift_end.addItem("14:00");
            s_shift_end.addItem("16:00");
        } else if(s_shift_start.getSelectedItem().equals("8:30")) {
            s_shift_end.removeAllItems();
            s_shift_end.addItem("12:30");
            s_shift_end.addItem("14:30");
            s_shift_end.addItem("16:30");
        } else if(s_shift_start.getSelectedItem().equals("9:00")) {
            s_shift_end.removeAllItems();
            s_shift_end.addItem("13:00");
            s_shift_end.addItem("15:00");
            s_shift_end.addItem("17:00");
        } else if(s_shift_start.getSelectedItem().equals("9:30")) {
            s_shift_end.removeAllItems();
            s_shift_end.addItem("13:30");
            s_shift_end.addItem("15:30");
            s_shift_end.addItem("17:30");
        } else if(s_shift_start.getSelectedItem().equals("10:00")) {
            s_shift_end.removeAllItems();
            s_shift_end.addItem("14:00");
            s_shift_end.addItem("16:00");
            s_shift_end.addItem("18:00");
        } else if(s_shift_start.getSelectedItem().equals("10:30")) {
            s_shift_end.removeAllItems();
            s_shift_end.addItem("14:30");
            s_shift_end.addItem("16:30");
            s_shift_end.addItem("18:30");
        } else if(s_shift_start.getSelectedItem().equals("11:00")) {
            s_shift_end.removeAllItems();
            s_shift_end.addItem("15:00");
            s_shift_end.addItem("17:00");
            s_shift_end.addItem("19:00");
        } else if(s_shift_start.getSelectedItem().equals("11:30")) {
            s_shift_end.removeAllItems();
            s_shift_end.addItem("15:30");
            s_shift_end.addItem("17:30");
            s_shift_end.addItem("19:30");
        } else if(s_shift_start.getSelectedItem().equals("12:00")) {
            s_shift_end.removeAllItems();
            s_shift_end.addItem("16:00");
            s_shift_end.addItem("18:00");
            s_shift_end.addItem("20:00");
        } else if(s_shift_start.getSelectedItem().equals("12:30")) {
            s_shift_end.removeAllItems();
            s_shift_end.addItem("16:30");
            s_shift_end.addItem("18:30");
            s_shift_end.addItem("20:30");
        } else if(s_shift_start.getSelectedItem().equals("13:00")) {
            s_shift_end.removeAllItems();
            s_shift_end.addItem("17:00");
            s_shift_end.addItem("19:00");
            s_shift_end.addItem("21:00");
        } else if(s_shift_start.getSelectedItem().equals("13:30")) {
            s_shift_end.removeAllItems();
            s_shift_end.addItem("17:30");
            s_shift_end.addItem("19:30");
            s_shift_end.addItem("21:30");
        } else if(s_shift_start.getSelectedItem().equals("14:00")) {
            s_shift_end.removeAllItems();
            s_shift_end.addItem("18:00");
            s_shift_end.addItem("20:00");
            s_shift_end.addItem("22:00");
        } else if(s_shift_start.getSelectedItem().equals("14:30")) {
            s_shift_end.removeAllItems();
            s_shift_end.addItem("18:30");
            s_shift_end.addItem("20:30");
        } else if(s_shift_start.getSelectedItem().equals("15:00")) {
            s_shift_end.removeAllItems();
            s_shift_end.addItem("19:00");
            s_shift_end.addItem("21:00");
        } else if(s_shift_start.getSelectedItem().equals("15:30")) {
            s_shift_end.removeAllItems();
            s_shift_end.addItem("19:30");
            s_shift_end.addItem("21:30");
        } else if(s_shift_start.getSelectedItem().equals("16:00")) {
            s_shift_end.removeAllItems();
            s_shift_end.addItem("20:00");
            s_shift_end.addItem("22:00");
        } else if(s_shift_start.getSelectedItem().equals("16:30")) {
            s_shift_end.removeAllItems();
            s_shift_end.addItem("20:30");
        } else if(s_shift_start.getSelectedItem().equals("17:00")) {
            s_shift_end.removeAllItems();
            s_shift_end.addItem("21:00");
        } else if(s_shift_start.getSelectedItem().equals("17:30")) {
            s_shift_end.removeAllItems();
            s_shift_end.addItem("21:30");
        } else if(s_shift_start.getSelectedItem().equals("18:00")) {
            s_shift_end.removeAllItems();
            s_shift_end.addItem("22:00");
        }
    }
    
    private void init(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketmanagement?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            PreparedStatement ps = con.prepareStatement("SELECT id, name, surname, password, gender, shift_start, shift_end FROM sellers");

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String password = rs.getString("password");
                String gender = rs.getString("gender");
                String shift_start = rs.getString("shift_start");
                String shift_end = rs.getString("shift_end");
                
                String tData[] = {id, name, surname, password, gender, shift_start, shift_end};
                DefaultTableModel tableModel = (DefaultTableModel)s_table.getModel();
                tableModel.addRow(tData);
            }
            rs.close();
            ps.close();
            
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void Add_To_Table() {
        if(!s_name.getText().equals("")) {
            if(!s_surname.getText().equals("")) {
                if(!s_password.getText().equals("")) {
                    if(s_photo.getImage() != null) {
                        String name = s_name.getText();
                        String surname = s_surname.getText();
                        String password = s_password.getText();
                        String gender = s_gender.getSelectedItem().toString();
                        String shift_start = s_shift_start.getSelectedItem().toString();
                        String shift_end = s_shift_end.getSelectedItem().toString();

                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketmanagement?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");

                            PreparedStatement ps = con.prepareStatement("INSERT INTO sellers(name, surname, password, gender, shift_start, shift_end, image) VALUES(?,?,?,?,?,?,?)");

                            ps.setString(1, name);
                            ps.setString(2, surname);
                            ps.setString(3, password);
                            ps.setString(4, gender);
                            ps.setString(5, shift_start);
                            ps.setString(6, shift_end);
                            ps.setBinaryStream(7, new FileInputStream(this.imagePath));

                            ps.execute();

                            DefaultTableModel tableModel = (DefaultTableModel)s_table.getModel();
                            tableModel.setRowCount(0);  
                            init();

                            ps.close();

                        } catch (SQLException | ClassNotFoundException ex) {
                            JOptionPane.showMessageDialog(null, ex);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Manage_Seller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Photo Missing");
                    }

                } else {
                    Border border = new Border();
                    border.setColor(Color.RED);
                    s_password.setBorder(border);
                }
            } else {
                Border border = new Border();
                border.setColor(Color.RED);
                s_surname.setBorder(border);
            }
        } else {
            Border border = new Border();
            border.setColor(Color.RED);
            s_name.setBorder(border);
        }
    }
    
    private void Delete_From_DB(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketmanagement?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            PreparedStatement ps = con.prepareStatement("DELETE FROM `sellers` WHERE id=?");
            
            ps.setInt(1, id);
            ps.executeUpdate();
            
            ps.close();
            
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void Update_Data() {
        if(!s_name.getText().equals("")) {
            if(!s_surname.getText().equals("")) {
                if(!s_password.getText().equals("")) {

                    String name = s_name.getText();
                    String surname = s_surname.getText();
                    String password = s_password.getText();
                    String gender = s_gender.getSelectedItem().toString();
                    String shift_start = s_shift_start.getSelectedItem().toString();
                    String shift_end = s_shift_end.getSelectedItem().toString();
                    int id = Integer.parseInt(s_table.getValueAt(s_table.getSelectedRow(), 0).toString());
                    
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketmanagement?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");

                        PreparedStatement ps = con.prepareStatement("UPDATE `sellers` SET name=?, surname=?, password=?, gender=?, shift_start=?, shift_end=? WHERE id=?");
                        
                        ps.setString(1, name);
                        ps.setString(2, surname);
                        ps.setString(3, password);
                        ps.setString(4, gender);
                        ps.setString(5, shift_start);
                        ps.setString(6, shift_end);
                        ps.setInt(7, id);
                        
                        ps.executeUpdate();
                        
                        DefaultTableModel tableModel = (DefaultTableModel)s_table.getModel();
                        tableModel.setRowCount(0);  
                        init();
                        
                        ps.close();

                    } catch (SQLException | ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }

                } else {

                }
            } else {

            }
        } else {

        }
    }
    
    private void SetImage() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("C:\\Users\\THINKPAD\\Pictures"));
        
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                String n = file.getName().toLowerCase();
                if(file.isDirectory() | n.endsWith(".png") | n.endsWith(".jpg") | n.endsWith(".jpeg")) {
                    return true;
                }
                return false;
            }

            @Override
            public String getDescription() {
                return ".png | .jpg | .jepg";
            }
        });
        
        int X = fileChooser.showSaveDialog(null);
        if(X == JFileChooser.APPROVE_OPTION) {
            
            File file = fileChooser.getSelectedFile();
            String filename = file.getAbsolutePath();
            s_photo.setImage(new ImageIcon(filename));
            this.imagePath = filename;
        }
    }
    
    ImageIcon  Get_Seller_Image(int id) {
        ImageIcon schImage = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketmanagement?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            PreparedStatement ps = con.prepareStatement("SELECT image FROM sellers WHERE id=?");
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
    
    private void s_genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_genderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s_genderActionPerformed

    private void addBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBActionPerformed
        Add_To_Table();
        editB.setVisible(false);
    }//GEN-LAST:event_addBActionPerformed

    private void clearBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBActionPerformed
        s_name.setText("");
        s_surname.setText("");
        s_password.setText("");
        editB.setVisible(false);
    }//GEN-LAST:event_clearBActionPerformed

    private void editBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBActionPerformed
        Update_Data();
        editB.setVisible(false);
    }//GEN-LAST:event_editBActionPerformed

    private void delectBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delectBActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel)s_table.getModel();
        if(s_table.getSelectedRowCount() == 1) {
            int id = Integer.parseInt(s_table.getValueAt(s_table.getSelectedRow(), 0).toString());
            Delete_From_DB(id);
            tableModel.removeRow(s_table.getSelectedRow());
            editB.setVisible(false);
        } else{
            if(s_table.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Table empty!!");
                editB.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a single item to delete!");
                editB.setVisible(false);
            }
        }
    }//GEN-LAST:event_delectBActionPerformed

    private void s_tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s_tableMousePressed
        int id = Integer.parseInt(s_table.getValueAt(s_table.getSelectedRow(), 0).toString());
        String name = s_table.getValueAt(s_table.getSelectedRow(), 1).toString();
        String surname = s_table.getValueAt(s_table.getSelectedRow(), 2).toString();
        String password = s_table.getValueAt(s_table.getSelectedRow(), 3).toString();
        String gender = s_table.getValueAt(s_table.getSelectedRow(), 4).toString();
        String shift_start = s_table.getValueAt(s_table.getSelectedRow(), 5).toString();
        String shift_end = s_table.getValueAt(s_table.getSelectedRow(), 6).toString();
        ImageIcon photo = Get_Seller_Image(id);
        s_photo.setImage(photo);
        s_name.setText(name);
        s_surname.setText(surname);
        s_password.setText(password);
        s_gender.setSelectedItem(gender);
        s_shift_start.setSelectedItem(shift_start);
        s_shift_end.setSelectedItem(shift_end);
        editB.setVisible(true);
    }//GEN-LAST:event_s_tableMousePressed

    private void upload_photoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upload_photoActionPerformed
        SetImage();
    }//GEN-LAST:event_upload_photoActionPerformed

    private void s_shift_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_shift_startActionPerformed
        Set_shift_end();
    }//GEN-LAST:event_s_shift_startActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        new Category().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        new Products().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button2ActionPerformed
    
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
            java.util.logging.Logger.getLogger(Manage_Seller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manage_Seller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manage_Seller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manage_Seller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manage_Seller().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addB;
    private supermarket.Button button1;
    private supermarket.Button button2;
    private javax.swing.JButton clearB;
    private javax.swing.JButton delectB;
    private javax.swing.JButton editB;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private supermarket.Button logout;
    private javax.swing.JComboBox<String> s_gender;
    private javax.swing.JTextField s_name;
    private javax.swing.JTextField s_password;
    private swing.ImageAvatar s_photo;
    private javax.swing.JComboBox<String> s_shift_end;
    private javax.swing.JComboBox<String> s_shift_start;
    private javax.swing.JTextField s_surname;
    private javax.swing.JTable s_table;
    private supermarket.Button upload_photo;
    // End of variables declaration//GEN-END:variables
}
