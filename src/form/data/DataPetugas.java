package form.data;

import java.awt.Color;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.Event;
import java.awt.Font;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import koneksi.*;

public class DataPetugas extends javax.swing.JInternalFrame {
    
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
    //--------------------------------------------------------------------------
   
    public DataPetugas() {
        initComponents();
        CON.konek();
        kon = CON.con;
        st = CON.stat; 
        
        kondisi_awal();
        tampilkan_data();
        ec = new EscapeChar();

        
        remove_jdp();
        jam();
        
        //placeholder
        Placeholder id = new Placeholder("Id Petugas", ID);
        Placeholder nama = new Placeholder("Nama Petugas", NAMAPETUGAS);
        Placeholder username = new Placeholder("Username", USERNAME);
        Placeholder pass = new Placeholder("Password", PASSWORD);
        Placeholder confirmpass = new Placeholder("Confirm Password", CONFIRMPASSWORD);
        Placeholder search = new Placeholder("Search", PENCARIAN);
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
    
        
    //--------------------------------- Bersih ---------------------------------
        private void bersihkan(){
            ID.setText(null);
            NAMAPETUGAS.setText(null);
            USERNAME.setText(null);
            PASSWORD.setText(null);
            CONFIRMPASSWORD.setText(null);
            HAKAKSES.setSelectedItem("Pilih");
        }
    //--------------------------------------------------------------------------
    
        
    //----------------------------- Kondisi Awal -------------------------------
        private void kondisi_awal(){
            ID.setEnabled(false);
            NAMAPETUGAS.setEnabled(false);
            USERNAME.setEnabled(false);
            PASSWORD.setEnabled(false);
            CONFIRMPASSWORD.setEnabled(false);
            HAKAKSES.setEnabled(false);
            LABELCANCEL.setEnabled(false);
            INSERT.setVisible(true);
            UPDATE.setVisible(true);
            DELETE.setVisible(true);

            jLabel15.setVisible(false);
            jLabel17.setVisible(false);
            LABEL_CONFIRM.setText("");
    }
    //--------------------------------------------------------------------------
    
        
    //--------------------- Klik Button Insert Update Delete -------------------
        public void klik(){
            ID.setEnabled(false);
            NAMAPETUGAS.setEnabled(true);
            USERNAME.setEnabled(true);
            PASSWORD.setEnabled(true);
            CONFIRMPASSWORD.setEnabled(true);
            HAKAKSES.setEnabled(true);
            LABELCANCEL.setEnabled(true);
    }
    //--------------------------------------------------------------------------
    
        
        
    //--------------------- Menanmpilkan data di DB ke tabel--------------------
         private void tampilkan_data(){
            try {
            tabel = new DefaultTableModel();
            jTable1.setModel(tabel);
            tabel.addColumn("Id");
            tabel.addColumn("Nama Petugas");
            tabel.addColumn("Username");
            tabel.addColumn("Hak Akses");


            st = CON.con.createStatement();
            sql = "SELECT * FROM tb_petugas  INNER JOIN tb_level ON tb_petugas.id_level = tb_level.id_level";
            rs = st.executeQuery(sql);

            while(rs.next()){
                Object[] o = new Object[4];
                o[0] = rs.getString("id_petugas");
                o[1] = rs.getString("nama_petugas");
                o[2] = rs.getString("username");
                o[3] = rs.getString("level").substring(0,1).toUpperCase() + rs.getString("level").substring(1);
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
        jLabel1 = new javax.swing.JLabel();
        PENCARIAN = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        NAMAPETUGAS = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        USERNAME = new javax.swing.JTextField();
        JAM = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        HAKAKSES = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        CONFIRMPASSWORD = new javax.swing.JPasswordField();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        PASSWORD = new javax.swing.JPasswordField();
        jPanel8 = new javax.swing.JPanel();
        CANCEL = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        LABELCANCEL = new javax.swing.JLabel();
        DELETE = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        LABELDELTE = new javax.swing.JLabel();
        INSERT = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        LABELINSERT = new javax.swing.JLabel();
        UPDATE = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        LABELUPDATE = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        LABEL_CONFIRM = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1549, 1017));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1549, 1017));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_search_48px.png"))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_name_40px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NAMAPETUGAS, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NAMAPETUGAS, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_identification_documents_40px.png"))); // NOI18N

        ID.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
            .addComponent(ID)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_male_user_40px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(USERNAME, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(USERNAME)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        JAM.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        JAM.setForeground(new java.awt.Color(73, 128, 98));
        JAM.setText("JAM");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_exchange_40px.png"))); // NOI18N

        HAKAKSES.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Pilih Hak Akses --", "Administrator", "Petugas" }));
        HAKAKSES.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HAKAKSES, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(HAKAKSES)
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_password_40px.png"))); // NOI18N

        CONFIRMPASSWORD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CONFIRMPASSWORDKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CONFIRMPASSWORD, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(CONFIRMPASSWORD)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_lock_40px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PASSWORD, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
            .addComponent(PASSWORD)
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_insert_page_40px.png"))); // NOI18N

        LABELINSERT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LABELINSERT.setForeground(new java.awt.Color(73, 128, 98));
        LABELINSERT.setText("Insert");

        javax.swing.GroupLayout INSERTLayout = new javax.swing.GroupLayout(INSERT);
        INSERT.setLayout(INSERTLayout);
        INSERTLayout.setHorizontalGroup(
            INSERTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(INSERTLayout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LABELINSERT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        INSERTLayout.setVerticalGroup(
            INSERTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8)
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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
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
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CANCEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UPDATE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(INSERT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel16.setBackground(new java.awt.Color(73, 128, 98));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(73, 128, 98));
        jLabel16.setText("Data Petugas");

        jLabel15.setText("* Kosongkan jika tidak ingin diubah");

        jLabel17.setText("* Kosongkan jika tidak ingin diubah");

        LABEL_CONFIRM.setForeground(new java.awt.Color(255, 51, 51));
        LABEL_CONFIRM.setText("*confirm password ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(213, 213, 213)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LABEL_CONFIRM))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(599, 599, 599)
                        .addComponent(jLabel16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(357, 357, 357)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(255, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(493, 493, 493))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(499, 499, 499))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(JAM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PENCARIAN, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PENCARIAN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(JAM)))
                .addGap(30, 30, 30)
                .addComponent(jLabel16)
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(LABEL_CONFIRM)
                        .addGap(73, 73, 73)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
        jTable1.setRowMargin(5);
        jTable1.setSelectionBackground(new java.awt.Color(73, 128, 98));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1533, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void INSERTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_INSERTMouseClicked
        if (LABELINSERT.getText().equalsIgnoreCase("Insert")){
            LABELINSERT.setText(" Save ");
            klik();
            DELETE.setVisible(false);
            UPDATE.setVisible(false);
        }else if(NAMAPETUGAS.getText().isEmpty() || USERNAME.getText().isEmpty() || PASSWORD.getText().isEmpty() || HAKAKSES.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Ada data yang belum di isi","Informasi",JOptionPane.INFORMATION_MESSAGE);
        }else{
            try{
                   Integer level;
                   String pass;
                   String nama;
                   String username;
                   pass = ec.escapeMetaCharacters(PASSWORD.getText());
                   nama = ec.escapeMetaCharacters(NAMAPETUGAS.getText());
                   username = ec.escapeMetaCharacters(USERNAME.getText());
                   level = HAKAKSES.getSelectedIndex() == 1 ? 1 : 2;
                   pass = enc.getMD5Encrypt(PASSWORD.getText());       
                   
                   sql = "SELECT * FROM tb_petugas WHERE username='"+username +"'";
                   rs = st.executeQuery(sql);

                   if(rs.next()){
                       JOptionPane.showMessageDialog(null, "Username sudah terdaftar","Informasi",JOptionPane.INFORMATION_MESSAGE);
                   } else {
                       sql = "INSERT INTO tb_petugas VALUES ("+ null +",'"+ nama +"','"+ username +"','"+ pass +"', '"+ level +"')";
                       st.execute(sql);
                       JOptionPane.showMessageDialog(null, "Sukses tambah data");

                       tabel.fireTableDataChanged();
                       tabel.getDataVector().removeAllElements();

                       tampilkan_data();
                       bersihkan();
                       kondisi_awal();
                       jLabel15.setVisible(false);
                       jLabel17.setVisible(false);
                       LABEL_CONFIRM.setVisible(false);
                       LABELINSERT.setText("Insert");
                   }
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null, e.getMessage());
               }
        }
    }//GEN-LAST:event_INSERTMouseClicked

    private void UPDATEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UPDATEMouseClicked
        if(USERNAME.getText().isEmpty() || NAMAPETUGAS.getText().isEmpty() || HAKAKSES.getSelectedIndex() == 0){
        JOptionPane.showMessageDialog(null,"Klik Data Terlebih dahulu","Pesan",JOptionPane.WARNING_MESSAGE);
        return;
    }
        if (LABELUPDATE.getText().equalsIgnoreCase("Update")){
        LABELUPDATE.setText(" Save ");
        klik();
        INSERT.setVisible(false);
        DELETE.setVisible(false);
    }else if(NAMAPETUGAS.getText().isEmpty() || USERNAME.getText().isEmpty() || HAKAKSES.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Ada data yang belum di isi","Informasi",JOptionPane.INFORMATION_MESSAGE);
        }else{
            try{
                   Integer level;
                   String pass;
                   String nama;
                   String username;
                   pass = ec.escapeMetaCharacters(PASSWORD.getText());
                   nama = ec.escapeMetaCharacters(NAMAPETUGAS.getText());
                   username = ec.escapeMetaCharacters(USERNAME.getText());
                   level = HAKAKSES.getSelectedIndex() == 1 ? 1 : 2;
                   pass = enc.getMD5Encrypt(PASSWORD.getText()); 
                   
                   if(session.getUsername().equals(USERNAME.getText())){
                        if(PASSWORD.getText().isEmpty()){
                            sql = "UPDATE tb_petugas SET nama_petugas='"+ nama +"', username='"+ username +"', id_level='"+ level +"' WHERE id_petugas='"+ ID.getText() +"'";
                        }else{
                             if(PASSWORD.getText().length() < 7){
                                JOptionPane.showMessageDialog(null, "Password minimal terdiri dari 7 huruf");
                                return;
                             }else{
                                 sql = "UPDATE tb_petugas SET nama_petugas='"+ nama +"', username='"+ username +"', password='"+ pass +"', id_level='"+ level +"' WHERE id_petugas='"+ ID.getText() +"'";
                             }
                        }
                   }else if(!session.getUsername().equals(USERNAME.getText())){
                       sql = "SELECT * FROM tb_petugas WHERE username='"+ username +"'";
                       rs = st.executeQuery(sql);
                       
                       if(rs.next()){
                           JOptionPane.showMessageDialog(null, "Username sudah terdaftar");
                           return;
                       } else {
                           if(PASSWORD.getText().isEmpty()){
                               sql = "UPDATE tb_petugas SET nama_petugas='"+ nama +"', username='"+ username +"', id_level='"+ level +"' WHERE id_petugas='"+ ID.getText() +"'";
                           }else{
                               if(PASSWORD.getText().length() < 7){
                                   JOptionPane.showMessageDialog(null, "Password minimal terdiri dari 7 huruf");
                                   return;
                               }else{
                                   sql = "UPDATE tb_petugas SET nama_petugas='"+ nama +"', username='"+ username +"', password='"+ pass +"', id_level='"+ level +"', username='"+ username +"' WHERE id_petugas='"+ ID.getText() +"'";
                               }
                           }
                       }
                   }else{
                       sql = "SELECT * FROM tb_petugas WHERE username='"+username +"'";
                       rs = st.executeQuery(sql);
                       
                       if(rs.next()){
                           JOptionPane.showMessageDialog(null, "Username sudah terdaftar");
                           return;
                       } else {
                           if(PASSWORD.getText().isEmpty()){
                               sql = "UPDATE tb_petugas SET nama_petugas='"+ nama +"', username='"+ username +"', id_level='"+ level +"' WHERE id_petugas='"+ ID.getText() +"'";
                           }else{
                               if(PASSWORD.getText().length() < 7){
                                   JOptionPane.showMessageDialog(null, "Password minimal terdiri dari 7 huruf");
                                   return;
                               }else{
                                   sql = "UPDATE tb_petugas SET nama_petugas='"+nama +"', username='"+ username +"', password='"+ pass +"', id_level='"+ level +"', username='"+ username +"' WHERE id_petugas='"+ ID.getText() +"'";
                               }
                           }
                       }
                   }
                   
                   st.execute(sql);
                   JOptionPane.showMessageDialog(null, "edit data berhasil");

                   tabel.fireTableDataChanged();
                   tabel.getDataVector().removeAllElements();

                   tampilkan_data();
                   bersihkan();
                   kondisi_awal();
                   LABELUPDATE.setText(" Update ");
                   jLabel15.setVisible(false);
                   jLabel17.setVisible(false);
                   LABEL_CONFIRM.setVisible(false);
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null, e.getMessage());
               }
        }
    }//GEN-LAST:event_UPDATEMouseClicked

    private void DELETEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DELETEMouseClicked
        if(NAMAPETUGAS.getText().equals("") || USERNAME.getText().equals("") || HAKAKSES.getSelectedIndex() == 0){
        JOptionPane.showMessageDialog(null,"Klik Data Terlebih dahulu","Pesan",JOptionPane.WARNING_MESSAGE);
        return;
        }
        try {
            int ok=JOptionPane.showConfirmDialog(null,"Apakah Anda yakin?","Konfirmasi",JOptionPane.YES_NO_OPTION);
         if(ok==0){  

            sql = "DELETE FROM tb_petugas WHERE id_petugas ='"+ID.getText()+"'";
            st.executeUpdate(sql);
            tampilkan_data();
            bersihkan();
            kondisi_awal();
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            
         }else{
             kondisi_awal();
             bersihkan();
         }   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_DELETEMouseClicked

    private void CANCELMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CANCELMouseClicked
        bersihkan();
        LABELINSERT.setText("Insert");
        INSERT.setVisible(true);
        DELETE.setVisible(true);
        LABELUPDATE.setText("Update");
        UPDATE.setVisible(true);
        
        jLabel15.setVisible(false);
        jLabel17.setVisible(false);
        LABEL_CONFIRM.setVisible(false);
        kondisi_awal();
    }//GEN-LAST:event_CANCELMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try{
            sql = "SELECT * FROM tb_petugas INNER JOIN tb_level ON tb_petugas.id_level=tb_level.id_level WHERE id_petugas='"+jTable1.getValueAt(jTable1.getSelectedRow(),0)+"'";
            rs = st.executeQuery(sql);
            if(rs.next()){
                ID.setText(rs.getString("id_petugas"));
                NAMAPETUGAS.setText(rs.getString("nama_petugas"));
                USERNAME.setText(rs.getString("username"));
                HAKAKSES.setSelectedIndex(rs.getInt("id_level") == 1 ? 1 : 2);
                
                //Main button
                INSERT.setVisible(false);
                CANCEL.setEnabled(true);
                
                tampilkan_data();
                jLabel15.setVisible(true);
                jLabel17.setVisible(true);
                
            }
        }catch (Exception e){
           System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void CONFIRMPASSWORDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CONFIRMPASSWORDKeyReleased
        String registerPassword = new String (PASSWORD.getPassword());
        String retypePassword = new String (CONFIRMPASSWORD.getPassword());
        
        if (registerPassword.equals(retypePassword)) {
            LABEL_CONFIRM.setText("");
        }
        else if (!registerPassword.equals(retypePassword)) {
            LABEL_CONFIRM.setText("Password Tidak Sama!!!");
        }else if(registerPassword.equals("")){
            LABEL_CONFIRM.setText("");
        }
    }//GEN-LAST:event_CONFIRMPASSWORDKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CANCEL;
    private javax.swing.JPasswordField CONFIRMPASSWORD;
    private javax.swing.JPanel DELETE;
    private javax.swing.JComboBox HAKAKSES;
    private javax.swing.JTextField ID;
    private javax.swing.JPanel INSERT;
    private javax.swing.JLabel JAM;
    private javax.swing.JLabel LABELCANCEL;
    private javax.swing.JLabel LABELDELTE;
    private javax.swing.JLabel LABELINSERT;
    private javax.swing.JLabel LABELUPDATE;
    private javax.swing.JLabel LABEL_CONFIRM;
    private javax.swing.JTextField NAMAPETUGAS;
    private javax.swing.JPasswordField PASSWORD;
    private javax.swing.JTextField PENCARIAN;
    private javax.swing.JPanel UPDATE;
    private javax.swing.JTextField USERNAME;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
