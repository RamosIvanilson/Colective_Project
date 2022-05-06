
package supermarket;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import scroll.ScrollBarCustom;

public class CardPayment extends javax.swing.JFrame {
    
    Map<Integer, Integer> Ma_p = new LinkedHashMap<>();
    
    public CardPayment(Map<Integer, Integer> map) {
        initComponents();
        this.Ma_p = map;
        init();
        Dimension d = new Dimension(scroll.getWidth(), scroll.getHeight());
        body.setPreferredSize(d);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.setHorizontalScrollBar(null);
    }
    
    private void init() {
        float total = 0;
        body.setText("		Family Point\n");
        body.setText(body.getText() + "		Allea Lirei 2\n");
        body.setText(body.getText() + "================================\n");
        body.setText(body.getText() + "Item\t\tQuantity\t\tPrice\n");
        body.setText(body.getText() + "================================\n");
        for(Map.Entry<Integer, Integer> entry: this.Ma_p.entrySet()) {
            int id = entry.getKey();
            int qty = entry.getValue();
            float price = Get_Price_From_DB(id);
            String name = Get_Name_From_DB(id);
            float final_price = price*qty;
            total += final_price;
            body.setText(body.getText() + name + "\t\t" + qty + "\t\t" + final_price + "\n");
        }
        body.setText(body.getText() + "================================\n");
        body.setText(body.getText() + "Total\t\t\t\t" + total + "\n");
    }
    
    private String Get_Name_From_DB(int id) {
        String name = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketmanagement?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            PreparedStatement ps = con.prepareStatement("SELECT name FROM products WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                name = rs.getString("name");
            }
            rs.close();
            ps.close();
            
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return name;
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
    private CardPayment() {
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        confirm_pay = new supermarket.Button();
        scroll = new javax.swing.JScrollPane();
        body = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        confirm_pay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        confirm_pay.setForeground(new java.awt.Color(51, 153, 255));
        confirm_pay.setText("CONFIRM PAY");
        confirm_pay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        confirm_pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirm_payActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(confirm_pay, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(confirm_pay, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 423, -1));

        body.setEditable(false);
        body.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        scroll.setViewportView(body);

        getContentPane().add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 423, 410));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void confirm_payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirm_payActionPerformed
        
    }//GEN-LAST:event_confirm_payActionPerformed

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
            java.util.logging.Logger.getLogger(CardPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CardPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CardPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CardPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CardPayment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane body;
    private supermarket.Button confirm_pay;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
