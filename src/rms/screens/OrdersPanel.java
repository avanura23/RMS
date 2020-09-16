/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms.screens;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import rms.models.MenuItem;
import rms.models.Order;
import rms.resources.OrdersDbHandler;
import rms.resources.Utils;

/**
 *
 * @author soupa
 */

public class OrdersPanel extends javax.swing.JPanel {
    
    private DefaultListModel listModel;
    private OrdersDbHandler ordersDb;
    private ArrayList<Order> orders;
    private DefaultTableModel tableModel;

    /**
     * Creates new form OrderPanel
     */
    public OrdersPanel() {
        initComponents();
        ordersDb = new OrdersDbHandler();
        listModel = new DefaultListModel();
        orders = Utils.arrangeOrders(ordersDb.getOrders());
        
        for(Order order : orders){
        
            listModel.addElement("Order " + order.getId());
            
        }
        
        orderList.setModel(listModel);
        initTableModel();
        
    }
    
    private void initTableModel(){
        
        tableModel = new DefaultTableModel();
        jTable1.setModel(tableModel);
        tableModel.addColumn("NAME");
        tableModel.addColumn("PRICE");
        tableModel.addColumn("QTY");
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        orderList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        showReceipt = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        totalLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        orderList.setBackground(new java.awt.Color(204, 204, 204));
        orderList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        orderList.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        orderList.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(orderList);

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Orders");

        showReceipt.setBackground(new java.awt.Color(255, 153, 0));
        showReceipt.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        showReceipt.setForeground(new java.awt.Color(255, 255, 255));
        showReceipt.setText("Show Details");
        showReceipt.setBorder(null);
        showReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showReceiptActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(jTable1);

        totalLabel.setBackground(new java.awt.Color(255, 255, 255));
        totalLabel.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        totalLabel.setForeground(new java.awt.Color(0, 0, 0));
        totalLabel.setText("Total:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(showReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(showReceipt, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void showReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showReceiptActionPerformed
        // TODO add your handling code here:
        if(orderList.getSelectedIndex() != -1){
            
            initTableModel();
            
            Order order = orders.get(orderList.getSelectedIndex());
            
            
            for(MenuItem item : (ArrayList<MenuItem>)order.getItems()){
            
                String row[] = {item.getName(),String.valueOf(item.getPrice()),String.valueOf(item.getQty())};
                tableModel.addRow(row);
                
            }
            
            totalLabel.setText("Total: $" + String.format("%5.2f",order.getTotal()));
        
        }
    }//GEN-LAST:event_showReceiptActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JList<String> orderList;
    private javax.swing.JButton showReceipt;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
