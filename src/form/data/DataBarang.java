package form.data;

import java.awt.Image;
import java.io.File;
import java.sql.*;
import java.awt.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.*;
import java.util.logging.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.JTableHeader;
import koneksi.*;

public class DataBarang extends javax.swing.JInternalFrame {

    //-----------------------------------VARIABEL-------------------------------
        private String sql;
        private ResultSet rs;
        private Statement st;
        private Connection kon;
        private DefaultTableModel tabel;  
        private Koneksi CON = new Koneksi();
        private Session session = new Session();
        private EscapeChar ec = new EscapeChar();
        private EncryptMD5 enc = new EncryptMD5();
        private Calendar cal = Calendar.getInstance();
    //--------------------------------------------------------------------------
        
    public DataBarang() {
        initComponents();
        CON.konek();
        kon = CON.con;
        st = CON.stat;
        
        ec = new EscapeChar();
        TANGGAL.setDate(cal.getTime());
        tampilkan_data();
        kondisi_awal();
        
        remove_jdp();
        jam();    
        TANGGAL.setDate(cal.getTime());
        
        //PlaceHolder
        Placeholder id = new Placeholder("Id Barang", ID);
        Placeholder namabarang = new Placeholder("Nama Barang", NAMABARANG);
        Placeholder Photo = new Placeholder("Photo Barang", TEXTPHOTO);
        Placeholder harga = new Placeholder("harga Barang", HARGABARANG);
        Placeholder desc= new Placeholder("Deskripsi", DESKRIPSI);
        Placeholder cari = new Placeholder("Search", PENCARIAN);
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
        
        
    //-------------------------------- Bersih ----------------------------------
       private void bersihkan() {
        ID.setText(null);
        NAMABARANG.setText(null);
        TANGGAL.setDate(null);
        HARGABARANG.setText(null);
        DESKRIPSI.setText(null);
        TEXTPHOTO.setText(null);
        Picture.setIcon(null);
    }
    //--------------------------------------------------------------------------

        
    //------------------------------ Kondisi awal ------------------------------
        private void kondisi_awal() {
            ID.setEnabled(false);
            NAMABARANG.setEnabled(false);
            TANGGAL.setEnabled(false);
            DESKRIPSI.setEnabled(false);
            HARGABARANG.setEnabled(false);
            TEXTPHOTO.setEnabled(false);
            CANCEL.setEnabled(false);
            INSERT.setVisible(true);
            UPDATE.setVisible(true);
            DELETE.setVisible(true);
            
            CHOOSEFILE.setVisible(false);
    }
    //--------------------------------------------------------------------------
        
        
        
    //------------------- Klik Button Insert Update Delete ---------------------
        private void klik_insert() {
        ID.setEnabled(false);
        NAMABARANG.setEnabled(true);
        TANGGAL.setEnabled(true);
        HARGABARANG.setEnabled(true);
        DESKRIPSI.setEnabled(true);
        CANCEL.setEnabled(true);
        TEXTPHOTO.setEnabled(true);
        
        CHOOSEFILE.setVisible(true);
    }

    //--------------------------------------------------------------------------
        
        
    //----------------------- Mengambil tanggal dari tabel----------------------
        private static Date gettanggalfromtable(JTable table, int kolom) {
            JTable tabel = table;
            String tgl = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), kolom));
            Date tanggal = null;
            try {
                tanggal = new SimpleDateFormat("yyyy-MM-dd").parse(tgl);
            } catch (Exception e) {
                Logger.getLogger(DataBarang.class.getName()).log(Level.SEVERE, null, e);
            }
            return tanggal;

    }
    //--------------------------------------------------------------------------
    
        
    //--------------------- Menanmpilkan data di DB ke tabel--------------------
         private void tampilkan_data() {

        try {
            tabel = new DefaultTableModel();
            jTable1.setModel(tabel);
            tabel.addColumn("Id");
            tabel.addColumn("Nama Barang");
            tabel.addColumn("Tanggal");
            tabel.addColumn("Harga Barang");
            tabel.addColumn("Deskripsi");

           
            sql = "SELECT * FROM tb_barang";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Object[] o = new Object[5];
                o[0] = rs.getString("id_barang");
                o[1] = rs.getString("nama_barang");
                o[2] = rs.getString("tgl");
                o[3] = rs.getString("harga_awal");
                o[4] = rs.getString("deskripsi_barang");
                tabel.addRow(o);
                
                //Proses Mengedit tampilan header tabel
                JTableHeader tableHeader = jTable1.getTableHeader();
                tableHeader.setBackground(Color.white);
                tableHeader.setForeground(new Color(73,128,98));
                Font HeaderFont = new Font("Tahoma", Font.BOLD, 16);
                tableHeader.setFont(HeaderFont);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //--------------------------------------------------------------------------
    
         
    //------------------------------ Function Search ---------------------------
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
    //--------------------------------------------------------------------------
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JAM = new javax.swing.JLabel();
        PENCARIAN = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        NAMABARANG = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        TANGGAL = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        TEXTPHOTO = new javax.swing.JTextField();
        CHOOSEFILE = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        HARGABARANG = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DESKRIPSI = new javax.swing.JTextArea();
        jPanel9 = new javax.swing.JPanel();
        CANCEL = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        LABELCANCEL = new javax.swing.JLabel();
        DELETE = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        LABELDELTE = new javax.swing.JLabel();
        INSERT = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        LABELINSERT = new javax.swing.JLabel();
        UPDATE = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        LABELUPDATE = new javax.swing.JLabel();
        Picture = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1549, 1017));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1549, 1017));

        JAM.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        JAM.setForeground(new java.awt.Color(73, 128, 98));
        JAM.setText("JAM");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_search_48px.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_identification_documents_40px.png"))); // NOI18N

        ID.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ID)
                .addContainerGap())
        );

        jLabel16.setBackground(new java.awt.Color(73, 128, 98));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(73, 128, 98));
        jLabel16.setText("Data Barang");

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_list_40px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NAMABARANG, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NAMABARANG)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Tear-Off_Calendar_40px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TANGGAL, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TANGGAL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_camera_identification_40px.png"))); // NOI18N

        CHOOSEFILE.setBackground(new java.awt.Color(73, 128, 98));
        CHOOSEFILE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CHOOSEFILEMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Choose File");

        javax.swing.GroupLayout CHOOSEFILELayout = new javax.swing.GroupLayout(CHOOSEFILE);
        CHOOSEFILE.setLayout(CHOOSEFILELayout);
        CHOOSEFILELayout.setHorizontalGroup(
            CHOOSEFILELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
            .addGroup(CHOOSEFILELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CHOOSEFILELayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        CHOOSEFILELayout.setVerticalGroup(
            CHOOSEFILELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(CHOOSEFILELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CHOOSEFILELayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TEXTPHOTO, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CHOOSEFILE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CHOOSEFILE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TEXTPHOTO))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_euro_money_40px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HARGABARANG, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 48, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HARGABARANG)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_create_40px.png"))); // NOI18N

        DESKRIPSI.setColumns(20);
        DESKRIPSI.setRows(5);
        jScrollPane2.setViewportView(DESKRIPSI);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(0, 49, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

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

        DELETE.setBackground(new java.awt.Color(255, 255, 255));
        DELETE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(73, 128, 98), 2));
        DELETE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DELETEMouseClicked(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_remove_40px.png"))); // NOI18N

        LABELDELTE.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LABELDELTE.setForeground(new java.awt.Color(73, 128, 98));
        LABELDELTE.setText("Delete");

        javax.swing.GroupLayout DELETELayout = new javax.swing.GroupLayout(DELETE);
        DELETE.setLayout(DELETELayout);
        DELETELayout.setHorizontalGroup(
            DELETELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DELETELayout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LABELDELTE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        DELETELayout.setVerticalGroup(
            DELETELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12)
            .addGroup(DELETELayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LABELDELTE))
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
                .addGap(104, 104, 104)
                .addComponent(INSERT, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(UPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(CANCEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CANCEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(INSERT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Picture, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(204, 204, 204))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 455, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(742, 742, 742)
                .addComponent(jLabel16)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(JAM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PENCARIAN, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JAM, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PENCARIAN, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Picture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(47, 47, 47)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1533, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try{
            sql = "SELECT * FROM tb_barang WHERE id_barang='"+jTable1.getValueAt(jTable1.getSelectedRow(),0)+"'";
            rs = st.executeQuery(sql);
             
            if(rs.next()){
                ID.setText(rs.getString("id_barang"));
                NAMABARANG.setText(rs.getString("nama_barang"));
                TEXTPHOTO.setText(rs.getString("image"));
                TANGGAL.setDate(gettanggalfromtable(jTable1, 2));
                HARGABARANG.setText(rs.getString("harga_awal"));
                DESKRIPSI.setText(rs.getString("deskripsi_barang"));
                
                ImageIcon image = new ImageIcon(rs.getString("image"));
                Image img = image.getImage().getScaledInstance(Picture.getWidth(), Picture.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(img);
                Picture.setIcon(scaledIcon);
                
                //Main Burton
                INSERT.setVisible(false);
                CANCEL.setVisible(true);
                
                //Menampilkan Data ke tabel
                tampilkan_data();
            }   
        }catch (Exception e){
            System.out.println(e.getMessage());        
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void CANCELMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CANCELMouseClicked
        bersihkan();
        LABELINSERT.setText("Insert");
        INSERT.setVisible(true);
        DELETE.setVisible(true);
        LABELUPDATE.setText("Update");
        UPDATE.setVisible(true);
        
        
        kondisi_awal();
    }//GEN-LAST:event_CANCELMouseClicked

    private void DELETEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DELETEMouseClicked
        if (NAMABARANG.getText().equals("") || TANGGAL.getDate().equals("") || HARGABARANG.getText().equals("") || DESKRIPSI.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Klik Data Terlebih dahulu", "Pesan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (ok == 0) {
                SimpleDateFormat Date = new SimpleDateFormat("yyyy-MM-dd");
                String tgl = String.valueOf(Date.format(TANGGAL.getDate()));
                
                sql = "DELETE FROM tb_barang WHERE id_barang='" + ID.getText() + "'";
                st.executeUpdate(sql);
                tampilkan_data();
                bersihkan();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                kondisi_awal();
            } else {

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_DELETEMouseClicked

    private void INSERTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_INSERTMouseClicked
        if (LABELINSERT.getText().equalsIgnoreCase("Insert")) {
            LABELINSERT.setText(" Save ");
            klik_insert();
            DELETE.setVisible(false);
            UPDATE.setVisible(false);
        } else if (NAMABARANG.getText().equals("") || TANGGAL.getDate().equals("") || HARGABARANG.getText().equals("") || DESKRIPSI.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Isi data dengan lengkap terlebih dahulu", "Pesan", JOptionPane.WARNING_MESSAGE);
        } else {
            klik_insert();
            try {
                String nama;
                String desc;
                String harga;
                SimpleDateFormat Date = new SimpleDateFormat("yyyy-MM-dd");
                String tgl = String.valueOf(Date.format(TANGGAL.getDate()));
                String image = TEXTPHOTO.getText();
                image = image.replace("\\", "\\\\");
                nama = ec.escapeMetaCharacters(NAMABARANG.getText());
                desc = ec.escapeMetaCharacters(DESKRIPSI.getText());
                harga = ec.escapeMetaCharacters(HARGABARANG.getText());
                
                sql = "INSERT INTO tb_barang VALUES(" + null + ",'" + nama + "','" + image + "','" + tgl +  "','" + harga + "','" + desc + "')";
                st.execute(sql);
                tampilkan_data();
                LABELINSERT.setText("Insert");
                JOptionPane.showMessageDialog(null, "Data Barang Berhasil Ditambahkan");
                bersihkan();
                kondisi_awal();
                setIconImage(null);
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_INSERTMouseClicked

    private void UPDATEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UPDATEMouseClicked
        if (NAMABARANG.getText().equals("") || TANGGAL.getDate().equals("") || HARGABARANG.getText().equals("") || DESKRIPSI.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Klik Data Terlebih dahulu", "Pesan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (LABELUPDATE.getText().equalsIgnoreCase("Update")) {
            LABELUPDATE.setText("  Save  ");
            klik_insert();
            CANCEL.setVisible(true);
            DELETE.setVisible(false);
            INSERT.setVisible(false);
        } else {
            try {
                SimpleDateFormat Date = new SimpleDateFormat("yyyy-MM-dd");
                String tgl = String.valueOf(Date.format(TANGGAL.getDate()));
                String image = TEXTPHOTO.getText();
                image = image.replace("\\", "\\\\");
                String nama;
                String desc;
                String harga;
                nama = ec.escapeMetaCharacters(NAMABARANG.getText());
                desc = ec.escapeMetaCharacters(DESKRIPSI.getText());
                harga = ec.escapeMetaCharacters(HARGABARANG.getText());

                sql = "UPDATE tb_barang SET nama_barang='" + nama + "',image='" + image + "',tgl='" + tgl + "',harga_awal='" + harga + "',deskripsi_barang='" + desc + "'WHERE id_barang ='" + ID.getText() + "'";
                st.executeUpdate(sql);
                tampilkan_data();
                bersihkan();
                LABELUPDATE.setText("Update");
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
                kondisi_awal();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_UPDATEMouseClicked

    private void CHOOSEFILEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CHOOSEFILEMouseClicked
        JFileChooser c = new JFileChooser();
        c.setFileFilter(new FileNameExtensionFilter("jpg|jpeg|png|bmp", "jpg","jpeg","png","bmp"));
        c.showOpenDialog(null);
        File f = c.getSelectedFile();
        String Filename = f.getAbsolutePath();
        TEXTPHOTO.setText(Filename);
        Image getAbsolutePath = null;
        ImageIcon icon = new ImageIcon(Filename);
        Image img = icon.getImage().getScaledInstance(Picture.getWidth(), Picture.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);
        Picture.setIcon(scaledIcon);
    }//GEN-LAST:event_CHOOSEFILEMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CANCEL;
    private javax.swing.JPanel CHOOSEFILE;
    private javax.swing.JPanel DELETE;
    private javax.swing.JTextArea DESKRIPSI;
    private javax.swing.JTextField HARGABARANG;
    private javax.swing.JTextField ID;
    private javax.swing.JPanel INSERT;
    private javax.swing.JLabel JAM;
    private javax.swing.JLabel LABELCANCEL;
    private javax.swing.JLabel LABELDELTE;
    private javax.swing.JLabel LABELINSERT;
    private javax.swing.JLabel LABELUPDATE;
    private javax.swing.JTextField NAMABARANG;
    private javax.swing.JTextField PENCARIAN;
    private javax.swing.JLabel Picture;
    private com.toedter.calendar.JDateChooser TANGGAL;
    private javax.swing.JTextField TEXTPHOTO;
    private javax.swing.JPanel UPDATE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void setIconImage(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
