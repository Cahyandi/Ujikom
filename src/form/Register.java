package form;


import koneksi.*;
import java.sql.*;
import java.awt.Color;
import java.security.*;
import java.util.List;
import javax.swing.JOptionPane;

public class Register extends javax.swing.JFrame {
    //---------------------------DEKLARASI VARIABEL-----------------------------
        private String sql;
        private ResultSet rs;
        private Statement stat;
        private Connection con;
        private Koneksi kon = new Koneksi();
        private EncryptMD5 enc = new EncryptMD5();
        private EscapeChar ec = new EscapeChar();
    //--------------------------------------------------------------------------
   
    public Register() {
        initComponents();
        kon.konek();
        con = kon.con;
        stat = kon.stat;
        ec = new EscapeChar();
        enc = new EncryptMD5();
        LABEL_CONFIRM.setText("");
        
        //PlaceHolder
        Placeholder nama = new Placeholder("Nama Lengkap", NAME);
        Placeholder username = new Placeholder("Username", USERNAME);
        Placeholder password = new Placeholder("Password", PASSWORD);
        Placeholder confirmpassword = new Placeholder("Confirm Password", CONFIRMPASSWORD);
        Placeholder telp = new Placeholder("No Telephone", TELP);
    }
    
    //------------------------------KONDISI AWALL-------------------------------
        private void kondisi_awal(){
            NAME.setEnabled(false);
            USERNAME.setEnabled(false);
            PASSWORD.setEnabled(false);
            TELP.setEnabled(false);
        }
    //--------------------------------------------------------------------------
        
    //------------------------------KLIK SIGN UP-------------------------------
        private void klik_signup(){
            NAME.setEnabled(true);
            USERNAME.setEnabled(true);
            PASSWORD.setEnabled(true);
            TELP.setEnabled(true);
        }
    //--------------------------------------------------------------------------
        
        
    //---------------------------------Bersih-----------------------------------
        private void bersih(){
            NAME.setText("");
            USERNAME.setText("");
            PASSWORD.setText("");
            TELP.setText("");
        }
    //--------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        NAME = new javax.swing.JTextField();
        USERNAME = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TELP = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        PASSWORD = new javax.swing.JPasswordField();
        CONFIRMPASSWORD = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        LABEL_CONFIRM = new javax.swing.JLabel();
        Btn_SIGNUP = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(73, 128, 98));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(73, 128, 98));
        jLabel1.setText("Create Your Account");

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Create for user by user");

        jPanel1.setOpaque(false);

        jLabel4.setBackground(new java.awt.Color(73, 128, 98));
        jLabel4.setForeground(new java.awt.Color(73, 128, 98));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_name_tag_24px.png"))); // NOI18N
        jLabel4.setToolTipText("");

        jLabel5.setBackground(new java.awt.Color(73, 128, 98));
        jLabel5.setForeground(new java.awt.Color(73, 128, 98));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_lock_32px.png"))); // NOI18N

        jLabel6.setBackground(new java.awt.Color(73, 128, 98));
        jLabel6.setForeground(new java.awt.Color(73, 128, 98));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_user_male_30px.png"))); // NOI18N
        jLabel6.setToolTipText("");

        NAME.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                NAMEFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                NAMEFocusLost(evt);
            }
        });

        USERNAME.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                USERNAMEFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                USERNAMEFocusLost(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(73, 128, 98));
        jLabel7.setForeground(new java.awt.Color(73, 128, 98));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_password_24px.png"))); // NOI18N

        TELP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TELPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TELPFocusLost(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(73, 128, 98));
        jLabel8.setForeground(new java.awt.Color(73, 128, 98));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_telephone_24px.png"))); // NOI18N

        CONFIRMPASSWORD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CONFIRMPASSWORDKeyReleased(evt);
            }
        });

        jPanel3.setOpaque(false);

        LABEL_CONFIRM.setForeground(new java.awt.Color(255, 51, 51));
        LABEL_CONFIRM.setText("*confirm password tidak sesuai dgn password");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(LABEL_CONFIRM)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(LABEL_CONFIRM)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        Btn_SIGNUP.setBackground(new java.awt.Color(73, 128, 98));
        Btn_SIGNUP.setForeground(new java.awt.Color(73, 128, 98));
        Btn_SIGNUP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_SIGNUPMouseClicked(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Sign up");

        javax.swing.GroupLayout Btn_SIGNUPLayout = new javax.swing.GroupLayout(Btn_SIGNUP);
        Btn_SIGNUP.setLayout(Btn_SIGNUPLayout);
        Btn_SIGNUPLayout.setHorizontalGroup(
            Btn_SIGNUPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(Btn_SIGNUPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Btn_SIGNUPLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel10)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        Btn_SIGNUPLayout.setVerticalGroup(
            Btn_SIGNUPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(Btn_SIGNUPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Btn_SIGNUPLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel10)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NAME)
                            .addComponent(USERNAME)
                            .addComponent(PASSWORD)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(21, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(TELP, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CONFIRMPASSWORD))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Btn_SIGNUP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(NAME))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(USERNAME)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CONFIRMPASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TELP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addComponent(Btn_SIGNUP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel9.setForeground(new java.awt.Color(0, 0, 255));
        jLabel9.setText("Sign in");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(73, 128, 98));
        jLabel3.setText("Sudah punya akun?");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(151, 151, 151))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(37, 37, 37)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void NAMEFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NAMEFocusGained
        if (NAME.getText().equals("Username")) {
            NAME.setText(null);
            NAME.requestFocus();

            //Font color
            NAME.setForeground(Color.black);
        }
    }//GEN-LAST:event_NAMEFocusGained

    private void NAMEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NAMEFocusLost
        if (NAME.getText().length()==0) {
            //Font color
            NAME.setForeground(Color.gray);
            NAME.setText("Username");
        }
    }//GEN-LAST:event_NAMEFocusLost

    private void USERNAMEFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_USERNAMEFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_USERNAMEFocusGained

    private void USERNAMEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_USERNAMEFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_USERNAMEFocusLost

    private void TELPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TELPFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TELPFocusGained

    private void TELPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TELPFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_TELPFocusLost

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        new Login().show();
        dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void Btn_SIGNUPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_SIGNUPMouseClicked
         if(NAME.getText().isEmpty() || USERNAME.getText().isEmpty() || PASSWORD.getText().isEmpty() || TELP.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ada data yang belum di isi","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }else if(PASSWORD.getText().length() < 7 || PASSWORD.getText().length() < 7){
            JOptionPane.showMessageDialog(null, "Password minimal terdiri dari 7 huruf","Informasi",JOptionPane.INFORMATION_MESSAGE);
        }else if(TELP.getText().length() <= 10){
            JOptionPane.showMessageDialog(null, "No.Telpon minimal terdiri dari 10 angka","Informasi",JOptionPane.INFORMATION_MESSAGE);
        }else{
            try{
                String pass;
                String nama;
                String username;
                pass = enc.getMD5Encrypt(PASSWORD.getText());
                nama = ec.escapeMetaCharacters(NAME.getText());
                username = ec.escapeMetaCharacters(USERNAME.getText());
                sql = "SELECT * FROM tb_masyarakat WHERE username='"+username +"'";
                rs = stat.executeQuery(sql);
            
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "Username sudah terdaftar","Informasi",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    String telp = TELP.getText();
                    
                    sql = "INSERT INTO tb_masyarakat (nama_lengkap, username, password, telp) VALUES ('"+ nama +"', '"+ username +"', '"+ pass +"','"+ telp +"')";
                    stat.execute(sql);
                    JOptionPane.showMessageDialog(null, "Berhasi mendaftar, silahkan login!");

                    new Login().show();
                    this.dispose();
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
    
    }
    }//GEN-LAST:event_Btn_SIGNUPMouseClicked

    private void CONFIRMPASSWORDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CONFIRMPASSWORDKeyReleased
        String registerPassword = new String (PASSWORD.getPassword());
        String retypePassword = new String (CONFIRMPASSWORD.getPassword());
        
        if (registerPassword.equals(retypePassword)) {
             LABEL_CONFIRM.setText("");
        }
        else if (!registerPassword.equals(retypePassword)) {
                    LABEL_CONFIRM.setText("WARNING!!!, Password Tidak Sama!!!");
        }
    }//GEN-LAST:event_CONFIRMPASSWORDKeyReleased

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn_SIGNUP;
    private javax.swing.JPasswordField CONFIRMPASSWORD;
    private javax.swing.JLabel LABEL_CONFIRM;
    private javax.swing.JTextField NAME;
    private javax.swing.JPasswordField PASSWORD;
    private javax.swing.JTextField TELP;
    private javax.swing.JTextField USERNAME;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    // End of variables declaration//GEN-END:variables
}
