package form;
import form.data.*;
import java.io.File;
import java.util.ArrayList;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import koneksi.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.*;
import net.sf.jasperreports.view.*;
import form.transaction.*;
public class MenuUtama extends javax.swing.JFrame {

    private List<Session> list;
    private JasperReport jasper;
    private JasperPrint print;
    private Connection con;
    private Koneksi kon = new Koneksi();
    
    public MenuUtama() {
        initComponents();
        kon.konek();
        con = kon.con;
        
        //Max layar laptop
        setExtendedState(MAXIMIZED_BOTH);
    }
    
        
        
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1820, 1080));

        jPanel2.setBackground(new java.awt.Color(73, 128, 98));

        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);

        LEVEL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LEVEL.setForeground(new java.awt.Color(255, 255, 255));
        LEVEL.setText("Level");

        NAMA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NAMA.setForeground(new java.awt.Color(255, 255, 255));
        NAMA.setText("nama");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Welcome, ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LEVEL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NAMA)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(LEVEL)
                .addComponent(NAMA)
                .addComponent(jLabel2))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_auction_100px_1.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Lelang Online");

        TEXT_FORMBID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TEXT_FORMBID.setForeground(new java.awt.Color(255, 255, 255));
        TEXT_FORMBID.setText("Form Bid");

        jPanel15.setOpaque(false);
        jPanel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel15MouseClicked(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Logout");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_logout_rounded_left_48px_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(34, 34, 34))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel24)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        BTN_PETUGAS.setBackground(new java.awt.Color(255, 255, 255));
        BTN_PETUGAS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_PETUGASMouseClicked(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_business_building_48px_1.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(73, 128, 98));
        jLabel7.setText("Data Petugas");

        javax.swing.GroupLayout BTN_PETUGASLayout = new javax.swing.GroupLayout(BTN_PETUGAS);
        BTN_PETUGAS.setLayout(BTN_PETUGASLayout);
        BTN_PETUGASLayout.setHorizontalGroup(
            BTN_PETUGASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BTN_PETUGASLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BTN_PETUGASLayout.setVerticalGroup(
            BTN_PETUGASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(BTN_PETUGASLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap())
        );

        BTN_BARANG.setBackground(new java.awt.Color(255, 255, 255));
        BTN_BARANG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_BARANGMouseClicked(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_buy_48px.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(73, 128, 98));
        jLabel9.setText("Data Barang");

        javax.swing.GroupLayout BTN_BARANGLayout = new javax.swing.GroupLayout(BTN_BARANG);
        BTN_BARANG.setLayout(BTN_BARANGLayout);
        BTN_BARANGLayout.setHorizontalGroup(
            BTN_BARANGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BTN_BARANGLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        BTN_BARANGLayout.setVerticalGroup(
            BTN_BARANGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(BTN_BARANGLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap())
        );

        BTN_USER.setBackground(new java.awt.Color(255, 255, 255));
        BTN_USER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_USERMouseClicked(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_staff_48px.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(73, 128, 98));
        jLabel11.setText("Data User");

        javax.swing.GroupLayout BTN_USERLayout = new javax.swing.GroupLayout(BTN_USER);
        BTN_USER.setLayout(BTN_USERLayout);
        BTN_USERLayout.setHorizontalGroup(
            BTN_USERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BTN_USERLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        BTN_USERLayout.setVerticalGroup(
            BTN_USERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(BTN_USERLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap())
        );

        BTN_LELANG.setBackground(new java.awt.Color(255, 255, 255));
        BTN_LELANG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_LELANGMouseClicked(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_sell_48px.png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(73, 128, 98));
        jLabel13.setText("Lelang");

        javax.swing.GroupLayout BTN_LELANGLayout = new javax.swing.GroupLayout(BTN_LELANG);
        BTN_LELANG.setLayout(BTN_LELANGLayout);
        BTN_LELANGLayout.setHorizontalGroup(
            BTN_LELANGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BTN_LELANGLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addContainerGap(114, Short.MAX_VALUE))
        );
        BTN_LELANGLayout.setVerticalGroup(
            BTN_LELANGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(BTN_LELANGLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap())
        );

        LAPORAN_PETUGAS.setBackground(new java.awt.Color(255, 255, 255));
        LAPORAN_PETUGAS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LAPORAN_PETUGASMouseClicked(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_combo_chart_48px.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(73, 128, 98));
        jLabel17.setText("Petugas");

        javax.swing.GroupLayout LAPORAN_PETUGASLayout = new javax.swing.GroupLayout(LAPORAN_PETUGAS);
        LAPORAN_PETUGAS.setLayout(LAPORAN_PETUGASLayout);
        LAPORAN_PETUGASLayout.setHorizontalGroup(
            LAPORAN_PETUGASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LAPORAN_PETUGASLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        LAPORAN_PETUGASLayout.setVerticalGroup(
            LAPORAN_PETUGASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(LAPORAN_PETUGASLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addContainerGap())
        );

        LAPORAN_BARANG.setBackground(new java.awt.Color(255, 255, 255));
        LAPORAN_BARANG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LAPORAN_BARANGMouseClicked(evt);
            }
        });

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_combo_chart_48px.png"))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(73, 128, 98));
        jLabel23.setText("Barang");

        javax.swing.GroupLayout LAPORAN_BARANGLayout = new javax.swing.GroupLayout(LAPORAN_BARANG);
        LAPORAN_BARANG.setLayout(LAPORAN_BARANGLayout);
        LAPORAN_BARANGLayout.setHorizontalGroup(
            LAPORAN_BARANGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LAPORAN_BARANGLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        LAPORAN_BARANGLayout.setVerticalGroup(
            LAPORAN_BARANGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(LAPORAN_BARANGLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addContainerGap())
        );

        LAPORAN_USER.setBackground(new java.awt.Color(255, 255, 255));
        LAPORAN_USER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LAPORAN_USERMouseClicked(evt);
            }
        });

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_combo_chart_48px.png"))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(73, 128, 98));
        jLabel21.setText("User");

        javax.swing.GroupLayout LAPORAN_USERLayout = new javax.swing.GroupLayout(LAPORAN_USER);
        LAPORAN_USER.setLayout(LAPORAN_USERLayout);
        LAPORAN_USERLayout.setHorizontalGroup(
            LAPORAN_USERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LAPORAN_USERLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        LAPORAN_USERLayout.setVerticalGroup(
            LAPORAN_USERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(LAPORAN_USERLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addContainerGap())
        );

        LAPORAN_PEMENANG_LELANG.setBackground(new java.awt.Color(255, 255, 255));
        LAPORAN_PEMENANG_LELANG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LAPORAN_PEMENANG_LELANGMouseClicked(evt);
            }
        });

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_combo_chart_48px.png"))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(73, 128, 98));
        jLabel19.setText(" Lelang");

        javax.swing.GroupLayout LAPORAN_PEMENANG_LELANGLayout = new javax.swing.GroupLayout(LAPORAN_PEMENANG_LELANG);
        LAPORAN_PEMENANG_LELANG.setLayout(LAPORAN_PEMENANG_LELANGLayout);
        LAPORAN_PEMENANG_LELANGLayout.setHorizontalGroup(
            LAPORAN_PEMENANG_LELANGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LAPORAN_PEMENANG_LELANGLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        LAPORAN_PEMENANG_LELANGLayout.setVerticalGroup(
            LAPORAN_PEMENANG_LELANGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(LAPORAN_PEMENANG_LELANGLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addContainerGap())
        );

        TEXT_FROMDATA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TEXT_FROMDATA.setForeground(new java.awt.Color(255, 255, 255));
        TEXT_FROMDATA.setText("Form Data");

        TXT_LAPORAN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TXT_LAPORAN.setForeground(new java.awt.Color(255, 255, 255));
        TXT_LAPORAN.setText("Laporan");

        BTN_PENAWARAN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_PENAWARANMouseClicked(evt);
            }
        });

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_combo_chart_48px.png"))); // NOI18N

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(73, 128, 98));
        jLabel27.setText("Penawaran");

        javax.swing.GroupLayout BTN_PENAWARANLayout = new javax.swing.GroupLayout(BTN_PENAWARAN);
        BTN_PENAWARAN.setLayout(BTN_PENAWARANLayout);
        BTN_PENAWARANLayout.setHorizontalGroup(
            BTN_PENAWARANLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BTN_PENAWARANLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        BTN_PENAWARANLayout.setVerticalGroup(
            BTN_PENAWARANLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(BTN_PENAWARANLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(BTN_PENAWARAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(LAPORAN_PEMENANG_LELANG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(LAPORAN_USER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(LAPORAN_BARANG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BTN_LELANG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(LAPORAN_PETUGAS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BTN_USER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BTN_BARANG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BTN_PETUGAS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(TEXT_FROMDATA))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(TXT_LAPORAN))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(TEXT_FORMBID))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 19, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(TEXT_FROMDATA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_PETUGAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTN_BARANG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTN_USER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTN_LELANG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(TXT_LAPORAN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LAPORAN_PETUGAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LAPORAN_BARANG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(LAPORAN_USER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LAPORAN_PEMENANG_LELANG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(TEXT_FORMBID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_PENAWARAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1549, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1017, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jDesktopPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1950, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1017, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseClicked
        list = new ArrayList<Session>();
        list.clear();

        new Home().show();
        this.dispose();
    }//GEN-LAST:event_jPanel15MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
       new Home().show();
       dispose();
    }//GEN-LAST:event_jLabel25MouseClicked

    private void BTN_PETUGASMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_PETUGASMouseClicked
        
        DataPetugas p = new DataPetugas();
        jDesktopPane1.removeAll();
        jDesktopPane1.add(p).setVisible(true);
    }//GEN-LAST:event_BTN_PETUGASMouseClicked

    private void BTN_BARANGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_BARANGMouseClicked
        DataBarang p = new DataBarang();
        jDesktopPane1.removeAll();
        jDesktopPane1.add(p).setVisible(true);
    }//GEN-LAST:event_BTN_BARANGMouseClicked

    private void BTN_USERMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_USERMouseClicked
        DataUser p = new DataUser();
        jDesktopPane1.removeAll();
        jDesktopPane1.add(p).setVisible(true);
    }//GEN-LAST:event_BTN_USERMouseClicked

    private void BTN_LELANGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_LELANGMouseClicked
        DataLelang p = new DataLelang();
        jDesktopPane1.removeAll();
        jDesktopPane1.add(p).setVisible(true);
    }//GEN-LAST:event_BTN_LELANGMouseClicked

    private void LAPORAN_BARANGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LAPORAN_BARANGMouseClicked
        try {
            File file = new File("src/Laporan/DataBarang.jasper");
            HashMap hm = new HashMap();
            jasper = (JasperReport) JRLoader.loadObject(file);
            print = JasperFillManager.fillReport(jasper, hm, con);
            JasperViewer.viewReport(print,false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_LAPORAN_BARANGMouseClicked

    private void LAPORAN_USERMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LAPORAN_USERMouseClicked
        try {
            File file = new File("src/Laporan/DataUser.jasper");
            HashMap hm = new HashMap();
            jasper = (JasperReport) JRLoader.loadObject(file);
            print = JasperFillManager.fillReport(jasper, hm, con);
            JasperViewer.viewReport(print,false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_LAPORAN_USERMouseClicked

    private void BTN_PENAWARANMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_PENAWARANMouseClicked
        Penawaran p = new Penawaran();
        jDesktopPane1.removeAll();
        jDesktopPane1.add(p).setVisible(true);
    }//GEN-LAST:event_BTN_PENAWARANMouseClicked

    private void LAPORAN_PETUGASMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LAPORAN_PETUGASMouseClicked
       try {
            File file = new File("src/Laporan/DataPetugas.jasper");
            HashMap hm = new HashMap();
            jasper = (JasperReport) JRLoader.loadObject(file);
            print = JasperFillManager.fillReport(jasper, hm, con);
            JasperViewer.viewReport(print,false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_LAPORAN_PETUGASMouseClicked

    private void LAPORAN_PEMENANG_LELANGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LAPORAN_PEMENANG_LELANGMouseClicked
        try {
            File file = new File("src/Laporan/PemenangLelang.jasper");
            HashMap hm = new HashMap();
            jasper = (JasperReport) JRLoader.loadObject(file);
            print = JasperFillManager.fillReport(jasper, hm, con);
            JasperViewer.viewReport(print,false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_LAPORAN_PEMENANG_LELANGMouseClicked

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final javax.swing.JPanel BTN_BARANG = new javax.swing.JPanel();
    public static final javax.swing.JPanel BTN_LELANG = new javax.swing.JPanel();
    public static final javax.swing.JPanel BTN_PENAWARAN = new javax.swing.JPanel();
    public static final javax.swing.JPanel BTN_PETUGAS = new javax.swing.JPanel();
    public static final javax.swing.JPanel BTN_USER = new javax.swing.JPanel();
    public static final javax.swing.JPanel LAPORAN_BARANG = new javax.swing.JPanel();
    public static final javax.swing.JPanel LAPORAN_PEMENANG_LELANG = new javax.swing.JPanel();
    public static final javax.swing.JPanel LAPORAN_PETUGAS = new javax.swing.JPanel();
    public static final javax.swing.JPanel LAPORAN_USER = new javax.swing.JPanel();
    public static final javax.swing.JLabel LEVEL = new javax.swing.JLabel();
    public static final javax.swing.JLabel NAMA = new javax.swing.JLabel();
    public static final javax.swing.JLabel TEXT_FORMBID = new javax.swing.JLabel();
    public static final javax.swing.JLabel TEXT_FROMDATA = new javax.swing.JLabel();
    public static final javax.swing.JLabel TXT_LAPORAN = new javax.swing.JLabel();
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    public static final javax.swing.JPanel jPanel3 = new javax.swing.JPanel();
    // End of variables declaration//GEN-END:variables




}
