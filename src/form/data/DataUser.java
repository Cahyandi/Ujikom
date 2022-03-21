
package form.data;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import koneksi.*;

public class DataUser extends javax.swing.JInternalFrame {
    private Connection con;
    private ResultSet rs;
    private Statement stat;
    private String sql;
    private Koneksi kon = new Koneksi();
    private DefaultTableModel tabel;
    
    public DataUser() {
        initComponents();
        
        con = kon.con;
        stat = kon.stat;
        tampilkan_data();
        remove_jdp();
        
        Placeholder search = new Placeholder("Search", PENCARIAN);
    }
    
    
    //---------------------Menghilangkan border jdekstoppane--------------------
        private void remove_jdp(){
            this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
            BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
            ui.setNorthPane(null);
        }
    //--------------------------------------------------------------------------
        
         private void tampilkan_data(){
        try{
            tabel = new DefaultTableModel();
            jTable1.setModel(tabel);
            tabel.addColumn("ID Pengguna");
            tabel.addColumn("Nama Lengkap");
            tabel.addColumn("Username");
            tabel.addColumn("No.Telpon");
            
            sql = "SELECT *FROM tb_masyarakat";
            rs = stat.executeQuery(sql);
            
             while (rs.next()) {
                Object[] o = new Object[5];
                o[0] = rs.getString("id_user");
                o[1] = rs.getString("nama_lengkap");
                o[2] = rs.getString("username");
                o[3] = rs.getString("telp");
                tabel.addRow(o);
                
                //Proses Mengedit tampilan header tabel
                 JTableHeader tableHeader = jTable1.getTableHeader();
                 tableHeader.setBackground(Color.white);
                 tableHeader.setForeground(new Color(73,128,98));
                 Font HeaderFont = new Font("Tahoma", Font.BOLD, 18);
                 tableHeader.setFont(HeaderFont);
            }
        }catch  (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
        private void search(String str){
        try {
            tabel = (DefaultTableModel)jTable1.getModel();
            TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tabel);
            jTable1.setRowSorter(tr);
            tr.setRowFilter(RowFilter.regexFilter(str));
            
        } catch (Exception e) {
            System.out.println(e.getMessage()); 
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        PENCARIAN = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1549, 1017));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1549, 1017));

        jLabel16.setBackground(new java.awt.Color(73, 128, 98));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(73, 128, 98));
        jLabel16.setText("Data User");

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(204, 204, 204));
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(73, 128, 98));
        jScrollPane1.setViewportView(jTable1);

        PENCARIAN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PENCARIANKeyReleased(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_search_48px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(593, 593, 593)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addContainerGap(802, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PENCARIAN, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel16)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(PENCARIAN, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1533, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 981, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PENCARIANKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PENCARIANKeyReleased
        String cari = PENCARIAN.getText();
        search(cari);
    }//GEN-LAST:event_PENCARIANKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PENCARIAN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
