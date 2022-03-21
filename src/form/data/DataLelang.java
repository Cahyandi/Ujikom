package form.data;

import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import koneksi.*;




public class DataLelang extends javax.swing.JInternalFrame {

    //-----------------------------------VARIABEL-------------------------------
        private String sql;
        private ResultSet rs;
        private Statement st;
        private Connection kon;
        private DefaultTableModel tabel;  
        private Koneksi CON = new Koneksi();
        private Session session = new Session();
        private EscapeChar ec = new EscapeChar();
        private SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        private SimpleDateFormat fm1 = new SimpleDateFormat("dd-MM-yyyy");
        private Calendar cal = Calendar.getInstance();
        
        
    //--------------------------------------------------------------------------
        
        
    public DataLelang() {
        initComponents();
        
        CON.konek();
        kon = CON.con;
        st = CON.stat;
        
        ec = new EscapeChar();
        ID.setEditable(false);
        
        CB_NAMABARANG.requestFocus();;
        TANGGAL.setDate(cal.getTime());
        
        
        datacb_nm();
        datastatus();
        tampilkan_data();
        kondisi_awal();
        
        
        jam();
        remove_jdp();
        
        //placeholder 
        Placeholder id = new Placeholder("ID", ID);
        
        
    }

    //---------------------Menghilangkan border jdekstoppane--------------------
        private void remove_jdp(){
            this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
            BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
            ui.setNorthPane(null);
        }
    //--------------------------------------------------------------------------
        
    
    //------------------------------Jam Otomatis--------------------------------
        private void jam(){
            Thread p = new Thread(){
                public void run(){
                    for(;;){
                        Calendar cal = new GregorianCalendar();
                        int jam = cal.get(Calendar.HOUR);
                        int menit = cal.get(Calendar.MINUTE);
                        int detik = cal.get(Calendar.SECOND);
                        int AM_PM = cal.get(Calendar.AM_PM);

                        String day="";
                        if (AM_PM == 1){
                            day="AM";
                        }else{
                            day="PM";
                        }
                        String Waktu =  jam  +" : "+ menit +" : "+ detik +" "+day;
                        JAM.setText(Waktu);
                    }
                }
            };
            p.start();
        }
    //--------------------------------------------------------------------------
        
    
    //--------------------------- Bersih ------------------------------------
    private void bersihkan(){
        ID.setText(null);
        tabel.fireTableDataChanged();
        tabel.getDataVector().removeAllElements();
        tampilkan_data();

        datacb_nm();
        datastatus();
        TANGGAL.setDate(cal.getTime());
    }
    
    //--------------------------------------------------------------------------
    
    
    //----------------------------Kondisi Awal----------------------------------
        private void kondisi_awal(){
        INSERT.setVisible(true);
        UPDATE.setVisible(false);
    }
    //--------------------------------------------------------------------------
    
        
    //--------------------- Kondisi Setelah klik tabel -------------------------
    private void klikTable(){
        INSERT.setVisible(false);
        UPDATE.setVisible(true);
    } 
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    private void datacb_nm(){
        CB_NAMABARANG.removeAllItems();
        CB_NAMABARANG.addItem("-- Pilih Nama Barang --");
       
        try {
            sql = "SELECT * FROM tb_barang LEFT JOIN tb_lelang ON tb_barang.id_barang = tb_lelang.id_barang WHERE id_lelang IS NULL";
            rs = st.executeQuery(sql);
                
            while(rs.next()){
                CB_NAMABARANG.addItem(rs.getString("nama_barang"));
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"gagal"+e.getMessage());      
        }
    }
//------------------------------------------------------------------------------
    
//------------------------------------------------------------------------------
     private void datastatus(){
         CB_STATUS.removeAllItems();
        String[] data = {"-- Pilih Status --", "Dibuka","Ditutup"};
        for(String a : data){
           CB_STATUS.addItem(a); 
        }
     }
 //-----------------------------------------------------------------------------
     
//------------------------------------------------------------------------------
     private void tampilkan_data(){
         try {
             tabel = new DefaultTableModel();
             jTable1.setModel(tabel);
             tabel.addColumn("ID Lelang");
             tabel.addColumn("Nama Barang");
             tabel.addColumn("Tgl Lelang");
             tabel.addColumn("Harga Awal");
             tabel.addColumn("Harga Akhir");
             tabel.addColumn("Penawar");
             tabel.addColumn("Petugas");
             tabel.addColumn("Status");
             
             sql = "SELECT * FROM tb_lelang INNER JOIN tb_barang ON tb_lelang.id_barang = tb_barang.id_barang LEFT JOIN tb_masyarakat ON tb_lelang.id_user = tb_masyarakat.id_user INNER JOIN tb_petugas ON tb_lelang.id_petugas = tb_petugas.id_petugas";
             rs = st.executeQuery(sql);
             
             while(rs.next()){
                 Object[] o = new Object[8];
                 o[0] = rs.getString("id_lelang");
                 o[1] = rs.getString("nama_barang");
                 o[2] = String.valueOf(fm1.format(rs.getDate("tgl_lelang")));
                 o[3] = rs.getString("harga_awal");
                 o[4] = rs.getString("harga_akhir") == null ? "Belum ada" : rs.getString("harga_akhir");
                 o[5] = rs.getString("nama_lengkap") == null ? "Belum ada" : rs.getString("nama_lengkap");
                 o[6] = rs.getString("nama_petugas");  
                 o[7] = rs.getString("status").substring(0,1).toUpperCase() + rs.getString("status").substring(1);
                 tabel.addRow(o);
                 
                 //Proses Mengedit tampilan header tabel
                 JTableHeader tableHeader = jTable1.getTableHeader();
                 tableHeader.setBackground(Color.white);
                 tableHeader.setForeground(new Color(73,128,98));
                 Font HeaderFont = new Font("Tahoma", Font.BOLD, 18);
                 tableHeader.setFont(HeaderFont);
             }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
         }
     }
//------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        CB_STATUS = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        CB_NAMABARANG = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        TANGGAL = new com.toedter.calendar.JDateChooser();
        JAM = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        CANCEL = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        LABELCANCEL = new javax.swing.JLabel();
        INSERT = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        LABELINSERT = new javax.swing.JLabel();
        UPDATE = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        LABELUPDATE = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1549, 1017));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1549, 1017));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_name_40px.png"))); // NOI18N

        CB_STATUS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CB_STATUS, 0, 311, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
            .addComponent(CB_STATUS)
        );

        jLabel16.setBackground(new java.awt.Color(73, 128, 98));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(73, 128, 98));
        jLabel16.setText("Data Lelang");

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
        jTable1.setIntercellSpacing(new java.awt.Dimension(5, 5));
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(73, 128, 98));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_name_40px.png"))); // NOI18N

        ID.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ID, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ID))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_name_40px.png"))); // NOI18N

        CB_NAMABARANG.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CB_NAMABARANG, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CB_NAMABARANG)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_name_40px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TANGGAL, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TANGGAL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addContainerGap())
        );

        JAM.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        JAM.setForeground(new java.awt.Color(73, 128, 98));
        JAM.setText("JAM");

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        CANCEL.setBackground(new java.awt.Color(255, 255, 255));
        CANCEL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(73, 128, 98), 2));
        CANCEL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CANCELMouseClicked(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_cancel_40px.png"))); // NOI18N

        LABELCANCEL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LABELCANCEL.setForeground(new java.awt.Color(73, 128, 98));
        LABELCANCEL.setText("Cancel");

        javax.swing.GroupLayout CANCELLayout = new javax.swing.GroupLayout(CANCEL);
        CANCEL.setLayout(CANCELLayout);
        CANCELLayout.setHorizontalGroup(
            CANCELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CANCELLayout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LABELCANCEL)
                .addGap(0, 11, Short.MAX_VALUE))
        );
        CANCELLayout.setVerticalGroup(
            CANCELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(CANCELLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LABELCANCEL))
        );

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
        LABELINSERT.setText("Insert");

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

        UPDATE.setBackground(new java.awt.Color(255, 255, 255));
        UPDATE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(73, 128, 98), 2));
        UPDATE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UPDATEMouseClicked(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_update_file_40px.png"))); // NOI18N

        LABELUPDATE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LABELUPDATE.setForeground(new java.awt.Color(73, 128, 98));
        LABELUPDATE.setText("Update");

        javax.swing.GroupLayout UPDATELayout = new javax.swing.GroupLayout(UPDATE);
        UPDATE.setLayout(UPDATELayout);
        UPDATELayout.setHorizontalGroup(
            UPDATELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UPDATELayout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LABELUPDATE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
        UPDATELayout.setVerticalGroup(
            UPDATELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10)
            .addGroup(UPDATELayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LABELUPDATE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(INSERT, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(UPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CANCEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CANCEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(INSERT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(73, 128, 98));
        jLabel1.setText("*Jika ingin mengedit data, silahkan klik data terlebih dahulu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1486, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 35, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(jLabel16))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(555, 555, 555))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(JAM)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(545, 545, 545))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel16)
                .addGap(33, 33, 33)
                .addComponent(JAM)
                .addGap(45, 45, 45)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
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

    private void CANCELMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CANCELMouseClicked
        bersihkan();
        LABELINSERT.setText("Insert");
        INSERT.setVisible(true);
        
        LABELUPDATE.setText("Update");
        UPDATE.setVisible(true);

        kondisi_awal();
    }//GEN-LAST:event_CANCELMouseClicked

    private void INSERTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_INSERTMouseClicked
        if (CB_NAMABARANG.getSelectedIndex()== 0 || CB_STATUS.getSelectedIndex()==0) {
            JOptionPane.showMessageDialog(null, "Ada data yang belum di pilih","Informasi",JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
                String status;
                        
                if (CB_STATUS.getSelectedIndex() == 1) {
                    status = "dibuka";
                }else{
                    status = "dibuka";
                }
                
                String namaBarang;
                namaBarang = ec.escapeMetaCharacters((String) CB_NAMABARANG.getSelectedItem());
                sql = "INSERT INTO tb_lelang VALUES ("+ null +",(SELECT id_barang FROM tb_barang WHERE nama_barang='"+ namaBarang+"'), '"+ String.valueOf(fm.format(TANGGAL.getDate())) +"', "+ null +", "+ null +", '"+ session.getId() +"', '"+ status +"')";
                st.execute(sql);
                JOptionPane.showMessageDialog(null, "Sukses tambah data");
                
                bersihkan();
                
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_INSERTMouseClicked

    private void UPDATEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UPDATEMouseClicked
        if (CB_NAMABARANG.getSelectedIndex()== 0 || CB_STATUS.getSelectedIndex()==0) {
            JOptionPane.showMessageDialog(null, "Ada data yang belum di pilih","Informasi",JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
                String status;
                        
                if (CB_STATUS.getSelectedIndex() == 1) {
                    status = "dibuka";
                }else{
                    status = "ditutup";
                }
                String namaBarang;
                namaBarang = ec.escapeMetaCharacters((String) CB_NAMABARANG.getSelectedItem());
                sql = "UPDATE tb_lelang SET id_barang =(SELECT id_barang FROM tb_barang WHERE nama_barang='"+ namaBarang +"'), tgl_lelang='" + String.valueOf(fm.format(TANGGAL.getDate())) +"', status='"+ status +"' WHERE id_lelang='"+ ID.getText() +"'";
                st.execute(sql);
                JOptionPane.showMessageDialog(null, "Sukses edit data");
                kondisi_awal();
                bersihkan();
                } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
            
    }//GEN-LAST:event_UPDATEMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try{
            sql = "SELECT * FROM tb_lelang INNER JOIN tb_barang ON tb_lelang.id_barang = tb_barang.id_barang WHERE id_lelang='"+jTable1.getValueAt(jTable1.getSelectedRow(),0)+"'";
            rs = st.executeQuery(sql);
            if(rs.next()){
                ID.setText(rs.getString("id_lelang"));
                CB_NAMABARANG.getModel().setSelectedItem(rs.getString("nama_barang"));
                CB_STATUS.setSelectedIndex(rs.getString("status").equals("dibuka") ? 1 : 2);
                TANGGAL.setDate(rs.getDate("tgl_lelang"));
                
                klikTable();
                tampilkan_data();
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CANCEL;
    private javax.swing.JComboBox CB_NAMABARANG;
    private javax.swing.JComboBox CB_STATUS;
    private javax.swing.JTextField ID;
    private javax.swing.JPanel INSERT;
    private javax.swing.JLabel JAM;
    private javax.swing.JLabel LABELCANCEL;
    private javax.swing.JLabel LABELINSERT;
    private javax.swing.JLabel LABELUPDATE;
    private com.toedter.calendar.JDateChooser TANGGAL;
    private javax.swing.JPanel UPDATE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

   
}
