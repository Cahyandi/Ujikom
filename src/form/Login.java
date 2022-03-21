package form;

import java.sql.*;
import java.util.*;
import javax.swing.*;
import koneksi.*;
import java.awt.Color;
import static form.MenuUtama.*;

public class Login extends javax.swing.JFrame {
    //---------------------------DEKLARASI VARIABEL-----------------------------
        private String sql;
        private ResultSet rs;
        private Statement stat;
        private Connection con;
        private Koneksi kon = new Koneksi();
        private Session session = new Session();
        private EncryptMD5 enc = new EncryptMD5();
        private EscapeChar ec = new EscapeChar();
        private List<Session> list;
        private Session a;
    //--------------------------------------------------------------------------
        
    public Login() {
        initComponents();
        
        kon.konek();
        con = kon.con;
        stat = kon.stat;
        ec = new EscapeChar();
        USERNAME.requestFocus();
        
        //PlaceHolder
        Placeholder username = new Placeholder("Username", USERNAME);
        Placeholder password = new Placeholder("Password", PASSWORD);
    }
    
    //--------------------------- LOGIN SEBAGAI ADMIN --------------------------
        private void admin(){
        //BUTTON AKTIF
        BTN_BARANG.setVisible(true);
        BTN_PETUGAS.setVisible(true);
        LAPORAN_BARANG.setVisible(true);
        LAPORAN_PETUGAS.setVisible(true);
        TEXT_FROMDATA.setVisible(true);
        TXT_LAPORAN.setVisible(true);
        //BUTTON NONAKTIF
        BTN_USER.setVisible(false);
        BTN_LELANG.setVisible(false);
        LAPORAN_USER.setVisible(false);
        LAPORAN_PEMENANG_LELANG.setVisible(false);
        BTN_PENAWARAN.setVisible(false);
        TEXT_FORMBID.setVisible(false);
//        PENAWARAN.setVisible(false);
    }
    //--------------------------------------------------------------------------
        
        
    //---------------------------LOGIN SEBAGAI PETUGAS--------------------------
        private void petugas(){
            
        //BUTTON AKTIF
        BTN_BARANG.setVisible(true);
        BTN_USER.setVisible(true);
        BTN_LELANG.setVisible(true);
        LAPORAN_USER.setVisible(true);
        LAPORAN_PEMENANG_LELANG.setVisible(true);
        LAPORAN_BARANG.setVisible(true);
        TEXT_FROMDATA.setVisible(true);
        TXT_LAPORAN.setVisible(true);
        
        //BUTTON NONAKTIF
        BTN_PETUGAS.setVisible(false);
        LAPORAN_PETUGAS.setVisible(false);
        BTN_PENAWARAN.setVisible(false);
        TEXT_FORMBID.setVisible(false);

    }   
        
    //--------------------------------------------------------------------------
        
        
    //--------------------------- LOGIN SEBAGAI PETUGAS-------------------------
        private void users(){
        BTN_PENAWARAN.setVisible(true);
        TEXT_FORMBID.setVisible(true);
            
        BTN_BARANG.setVisible(false);
        BTN_USER.setVisible(false);
        BTN_PETUGAS.setVisible(false);
        BTN_LELANG.setVisible(false);
        LAPORAN_USER.setVisible(false);
        LAPORAN_PEMENANG_LELANG.setVisible(false);
        LAPORAN_BARANG.setVisible(false);
        LAPORAN_PETUGAS.setVisible(false);
        
        TXT_LAPORAN.setVisible(false);
        TEXT_FROMDATA.setVisible(false);
        
        }
    //--------------------------------------------------------------------------
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        USERNAME = new javax.swing.JTextField();
        PASSWORD = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(73, 128, 98));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(73, 128, 98));
        jLabel1.setText("SIG IN");

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Sig in to manage for your acounnt");

        jPanel2.setOpaque(false);

        jLabel4.setBackground(new java.awt.Color(73, 128, 98));
        jLabel4.setForeground(new java.awt.Color(73, 128, 98));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_user_male_30px.png"))); // NOI18N
        jLabel4.setToolTipText("");

        jLabel5.setBackground(new java.awt.Color(73, 128, 98));
        jLabel5.setForeground(new java.awt.Color(73, 128, 98));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_lock_32px.png"))); // NOI18N

        USERNAME.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                USERNAMEFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                USERNAMEFocusLost(evt);
            }
        });

        PASSWORD.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PASSWORDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PASSWORDFocusLost(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(73, 128, 98));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Login");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jLabel6.setBackground(new java.awt.Color(73, 128, 98));
        jLabel6.setForeground(new java.awt.Color(73, 128, 98));
        jLabel6.setText("Don't have an account?");

        jLabel7.setForeground(new java.awt.Color(51, 51, 255));
        jLabel7.setText("Sign up");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(USERNAME)
                    .addComponent(PASSWORD))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 64, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(USERNAME))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(PASSWORD))
                .addGap(35, 35, 35)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel1)))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PASSWORDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PASSWORDFocusGained
        if (PASSWORD.getText().equals("Password")) {
            PASSWORD.setText(null);
            PASSWORD.requestFocus();
            
            PASSWORD.setEchoChar('0');
            //Font color
            PASSWORD.setForeground(Color.black);
        }
    }//GEN-LAST:event_PASSWORDFocusGained

    private void PASSWORDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PASSWORDFocusLost
        if (PASSWORD.getText().length()==0) {
            //Font color
            PASSWORD.setForeground(Color.gray);
            PASSWORD.setText("Password");
            PASSWORD.setEchoChar('\u0000');
        }
    }//GEN-LAST:event_PASSWORDFocusLost

    private void USERNAMEFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_USERNAMEFocusGained
        if (USERNAME.getText().equals("Username")) {
            USERNAME.setText(null);
            USERNAME.requestFocus();
            
            //Font color
            USERNAME.setForeground(Color.black);
        }
    }//GEN-LAST:event_USERNAMEFocusGained

    private void USERNAMEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_USERNAMEFocusLost
        if (USERNAME.getText().length()==0) {
            //Font color
            USERNAME.setForeground(Color.gray);
            USERNAME.setText("Username");
        }
    }//GEN-LAST:event_USERNAMEFocusLost

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        new Register().show();
        dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        if (USERNAME.getText().isEmpty() && PASSWORD.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Isi data dengan lengkap terlebih dahulu","Informasi",JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
             String pass;
             String username;
             pass = enc.getMD5Encrypt(PASSWORD.getText());

             username = ec.escapeMetaCharacters(USERNAME.getText());
               
               sql = "SELECT * FROM tb_petugas INNER JOIN tb_level ON tb_petugas.id_level = tb_level.id_level WHERE username='" + username +"' AND password='" + pass  +"'";
               rs = stat.executeQuery(sql);
               
             if (rs.next()){
                if(USERNAME.getText().equals(rs.getString("username"))){
                     if(rs.getString("level").equalsIgnoreCase("administrator")){
                        list = new ArrayList<Session>();
                        a = new Session();
                        a.setId(rs.getInt("id_petugas"));
                        a.setUsername(rs.getString("username"));
                        a.setPassword(rs.getString("password"));
                        a.setName(rs.getString("nama_petugas"));
                        a.setLevel(rs.getString("level"));
                        list.add(a);
                        new MenuUtama().show();
                        this.dispose();
                        admin();
                        LEVEL.setText(rs.getString("level"));
                        NAMA.setText(rs.getString("nama_petugas"));
                    }else {
                        list = new ArrayList<Session>();
                        a = new Session();
                        a.setId(rs.getInt("id_petugas"));
                        a.setUsername(rs.getString("username"));
                        a.setPassword(rs.getString("password"));
                        a.setName(rs.getString("nama_petugas"));
                        a.setLevel(rs.getString("level"));
                        list.add(a);
                        
                        new MenuUtama().show();
                        this.dispose();
                        petugas();
                        LEVEL.setText(rs.getString("level"));
                        NAMA.setText(rs.getString("nama_petugas"));
                      
                     }
                 }else{
                      JOptionPane.showMessageDialog(null, "Maaf Data Tidak Valid!!!", "Pesan", JOptionPane.WARNING_MESSAGE);
                 }
                 }else{
                             
                             sql = "SELECT * FROM tb_masyarakat WHERE username='"+ username +"' AND password='" + pass +"'";
                             rs = stat.executeQuery(sql);
                            if(rs.next()){
                               if(USERNAME.getText().equals(rs.getString("username"))){
                               list = new ArrayList<Session>();
                               a = new Session();
                               a.setId(rs.getInt("id_user"));
                               a.setUsername(rs.getString("username"));
                               a.setPassword(rs.getString("password"));
                               a.setName(rs.getString("nama_lengkap"));
                               list.add(a);
                               
                               new MenuUtama().show();
                               this.dispose();
                               LEVEL.setText("User");
                               NAMA.setText(rs.getString("nama_lengkap"));
                               users();
                            }else {
                     JOptionPane.showMessageDialog(null, "Maaf Data Tidak Valid!!!", "Pesan", JOptionPane.WARNING_MESSAGE);                     
                 }
                     
             }else{
               JOptionPane.showMessageDialog(null, "Maaf Data Tidak Valid!!!", "Pesan", JOptionPane.WARNING_MESSAGE);                       
            }
            }
            } catch (Exception e) {
                System.out.println("error"+e.getMessage());
            }          
        }
    }//GEN-LAST:event_jPanel3MouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PASSWORD;
    private javax.swing.JTextField USERNAME;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
