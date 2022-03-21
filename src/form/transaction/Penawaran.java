package form.transaction;

import java.awt.Image;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.*;
import koneksi.*;
public class Penawaran extends javax.swing.JInternalFrame {
    private Connection con;
    private ResultSet rs, rs2;
    private Statement stat, stat2;
    private String sql, sql2, sql3, sql4;
    private Koneksi kon = new Koneksi();
    private DefaultTableModel tabel;
    private Session session = new Session();
    private EscapeChar ec = new EscapeChar();
    private SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
    
    public Penawaran() {
        initComponents();
        
        con = kon.con;
        stat = kon.stat;
        stat2 = kon.stat;
        ec = new EscapeChar();
        tampil_data();
        NAMABARANG.setVisible(false);
        RP.setVisible(false);
      
        BID.setVisible(false);
        BIDTERTINGGI.setVisible(false);
        DESKRIPSI.setVisible(false);
        DESK.setVisible(false);
        
        remove_jdp();
    }
    
    //---------------------Menghilangkan border jdekstoppane--------------------
        private void remove_jdp(){
            this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
            BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
            ui.setNorthPane(null);
        }
    //--------------------------------------------------------------------------

    private void tampil_data (){
        try {
            tabel = new DefaultTableModel();
            jTable1.setModel(tabel);
            tabel.addColumn("Nama Barang");
            tabel.addColumn("Tgl Lelang");
            tabel.addColumn("Harga Awal");
            tabel.addColumn("Harga Tertinggi");
            tabel.addColumn("Penawar");
            
            sql = "SELECT * FROM tb_lelang  INNER JOIN tb_barang ON tb_lelang.id_barang =tb_barang.id_barang LEFT JOIN tb_masyarakat ON tb_lelang.id_user = tb_masyarakat.id_user INNER JOIN tb_petugas ON tb_lelang.id_petugas = tb_petugas.id_petugas WHERE tb_lelang.status='dibuka'";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                 Object[] o = new Object[8];
                 o[0] = rs.getString("nama_barang");
                 o[1] = String.valueOf(fm.format(rs.getDate("tgl_lelang")));
                 o[2] = rs.getString("harga_awal");
                 o[3] = rs.getString("harga_akhir") == null ? "Belum ada" : rs.getString("harga_akhir");
                 o[4] = rs.getString("nama_lengkap") == null ? "Belum ada" : rs.getString("nama_lengkap");
                 
                 tabel.addRow(o);
             }
        } catch (Exception e) {
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        Picture = new javax.swing.JLabel();
        INSERT = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        LABELINSERT = new javax.swing.JLabel();
        NAMABARANG = new javax.swing.JLabel();
        BID = new javax.swing.JLabel();
        BIDTERTINGGI = new javax.swing.JLabel();
        RP = new javax.swing.JLabel();
        HARGABARANG = new javax.swing.JLabel();
        DESK = new javax.swing.JLabel();
        DESKRIPSI = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1549, 1017));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1549, 1017));

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel16.setBackground(new java.awt.Color(73, 128, 98));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(73, 128, 98));
        jLabel16.setText("Penawaran");

        INSERT.setBackground(new java.awt.Color(255, 255, 255));
        INSERT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(73, 128, 98), 2));
        INSERT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                INSERTMouseClicked(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_insert_page_40px.png"))); // NOI18N

        LABELINSERT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LABELINSERT.setForeground(new java.awt.Color(73, 128, 98));
        LABELINSERT.setText("Bid");

        javax.swing.GroupLayout INSERTLayout = new javax.swing.GroupLayout(INSERT);
        INSERT.setLayout(INSERTLayout);
        INSERTLayout.setHorizontalGroup(
            INSERTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(INSERTLayout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LABELINSERT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        INSERTLayout.setVerticalGroup(
            INSERTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9)
            .addGroup(INSERTLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LABELINSERT))
        );

        NAMABARANG.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        NAMABARANG.setForeground(new java.awt.Color(73, 128, 98));
        NAMABARANG.setText("Nama Barang");

        BID.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        BID.setForeground(new java.awt.Color(73, 128, 98));
        BID.setText("Bid Tertingggi : Rp");

        BIDTERTINGGI.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        BIDTERTINGGI.setForeground(new java.awt.Color(73, 128, 98));
        BIDTERTINGGI.setText("b");

        RP.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        RP.setForeground(new java.awt.Color(73, 128, 98));
        RP.setText("RP");

        HARGABARANG.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        HARGABARANG.setForeground(new java.awt.Color(73, 128, 98));
        HARGABARANG.setToolTipText("");

        DESK.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        DESK.setForeground(new java.awt.Color(73, 128, 98));
        DESK.setText("Deskripsi Barang : ");

        DESKRIPSI.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        DESKRIPSI.setForeground(new java.awt.Color(73, 128, 98));
        DESKRIPSI.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1469, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(687, 687, 687)
                        .addComponent(jLabel16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(570, 570, 570)
                        .addComponent(Picture, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(NAMABARANG)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(RP)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(HARGABARANG)))
                                    .addGap(40, 40, 40))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(DESK)))
                            .addComponent(BID))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BIDTERTINGGI)
                            .addComponent(DESKRIPSI))))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(INSERT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(727, 727, 727))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(NAMABARANG)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HARGABARANG)
                            .addComponent(RP, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BIDTERTINGGI)
                            .addComponent(BID))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DESK)
                            .addComponent(DESKRIPSI)))
                    .addComponent(Picture, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addComponent(INSERT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void INSERTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_INSERTMouseClicked
        if (HARGABARANG.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Pilih Data Terlebih dahulu", "Pesan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        JFrame frame = new JFrame();
        Integer id_barang;
        String result = JOptionPane.showInputDialog(frame, "Masukkan harga penawaran");

        try {
            String namabarang;
            namabarang = NAMABARANG.getText();
            sql = "SELECT id_barang,harga_awal FROM tb_barang WHERE nama_barang='"+ NAMABARANG.getText() +"'";
            rs = stat.executeQuery(sql);
                if(rs.next()){
             id_barang = rs.getInt("id_barang");
                   
                    if(Integer.parseInt(result) > rs.getInt("harga_awal")){    
                        sql2 = "SELECT harga_akhir FROM tb_lelang WHERE id_barang='"+ id_barang +"' AND harga_akhir IS NOT NULL";
                        rs2 = stat2.executeQuery(sql2);
                        if(rs2.next()){  
                            if(Integer.parseInt(result) > rs2.getInt("harga_akhir")){
                                sql3 = "INSERT INTO tb_history_lelang VALUES ("+ null +",(SELECT id_lelang FROM tb_lelang WHERE id_barang='"+ id_barang +"'),'"+ id_barang +"', '"+ session.getId() +"', '"+ result +"')";
                                sql4 = "UPDATE tb_lelang SET harga_akhir='"+ result +"', id_user='"+ session.getId() +"' WHERE id_barang='"+ id_barang +"'";

                                stat.execute(sql3);
                                stat.execute(sql4);

                                JOptionPane.showMessageDialog(null, "Sukses menambah penawaran");

                                tabel.fireTableDataChanged();
                                tabel.getDataVector().removeAllElements();

                                tampil_data();  
                            } else{
                                JOptionPane.showMessageDialog(null,"Masukkan nominal lelang lebih dari harga tertinggi!");
                           }
                        } else {
                                sql3 = "INSERT INTO tb_history_lelang VALUES ("+ null +",(SELECT id_lelang FROM tb_lelang WHERE id_barang='"+ id_barang +"'),'"+ id_barang +"', '"+ session.getId() +"', '"+ result +"')";
                                
                                sql4 = "UPDATE tb_lelang SET harga_akhir='"+ result +"', id_user='"+ session.getId() +"' WHERE id_barang='"+ id_barang +"'";

                                stat.execute(sql3);
                                stat.execute(sql4);

                                JOptionPane.showMessageDialog(null, "Sukses menambah penawaran");

                                tabel.fireTableDataChanged();
                                tabel.getDataVector().removeAllElements();

                                tampil_data();  
                        }
                    }else{
                         JOptionPane.showMessageDialog(null,"Masukkan nominal lelang lebih dari harga awal!");
                    }
                }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_INSERTMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        String namabarang;

        namabarang = jTable1.getValueAt(jTable1.getSelectedRow(),0).toString();

        try {
            sql = "SELECT * FROM tb_lelang INNER JOIN tb_barang ON tb_lelang.id_barang = tb_barang.id_barang WHERE nama_barang='"+ec.escapeMetaCharacters(namabarang)+"'";
            rs = stat.executeQuery(sql);
        
            if (rs.next()) {
                NAMABARANG.setText(ec.escapeMetaCharacters(rs.getString("nama_barang")));
                HARGABARANG.setText(rs.getString("harga_awal"));
                BIDTERTINGGI.setText(rs.getString("harga_akhir"));
                DESKRIPSI.setText(ec.escapeMetaCharacters(rs.getString("deskripsi_barang")));

                ImageIcon image = new ImageIcon(rs.getString("image"));
                Image img = image.getImage().getScaledInstance(Picture.getWidth(), Picture.getHeight(), Image.SCALE_SMOOTH);
                
                ImageIcon scaledIcon = new ImageIcon(img);
                DESK.setVisible(true);
                DESKRIPSI.setVisible(true);
                Picture.setIcon(scaledIcon);
                NAMABARANG.setVisible(true);
                RP.setVisible(true);
                HARGABARANG.setVisible(true);
                BID.setVisible(true);
                BIDTERTINGGI.setVisible(true);
                tampil_data();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BID;
    private javax.swing.JLabel BIDTERTINGGI;
    private javax.swing.JLabel DESK;
    private javax.swing.JLabel DESKRIPSI;
    private javax.swing.JLabel HARGABARANG;
    private javax.swing.JPanel INSERT;
    private javax.swing.JLabel LABELINSERT;
    private javax.swing.JLabel NAMABARANG;
    private javax.swing.JLabel Picture;
    private javax.swing.JLabel RP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
