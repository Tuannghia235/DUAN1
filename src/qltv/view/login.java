package qltv.view;

import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;
import qltv.service.loginServiceImpl;

public class login extends javax.swing.JFrame {

    private loginServiceImpl loginServiceImpl = new loginServiceImpl();
    private static final String CONFIG_FILE = "user.properties";

    public login() {
        initComponents();
        setLocationRelativeTo(null);
        loadUserCredentials();
    }

    private void saveUserCredentials(String username, String password, boolean remember) {
        try (FileOutputStream fos = new FileOutputStream(CONFIG_FILE)) {
            Properties properties = new Properties();
            properties.setProperty("username", username);
            properties.setProperty("password", remember ? password : "");
            properties.setProperty("remember", String.valueOf(remember));
            properties.store(fos, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadUserCredentials() {
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
            Properties properties = new Properties();
            properties.load(fis);

            String username = properties.getProperty("username", "");
            String password = properties.getProperty("password", "");
            boolean remember = Boolean.parseBoolean(properties.getProperty("remember", "false"));

            txt_ma.setText(username);
            txt_pass.setText(password);
            cbo_remember.setSelected(remember);
        } catch (IOException e) {

        }
    }

    boolean checkTrong() {
        String ma = txt_ma.getText().trim();
        String pass = txt_pass.getPassword().toString();
        if (ma.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Tài khoản không được để trống !");
            return false;
        }
        if (pass.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Mật khẩu không được để trống !");
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btn_login = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        txt_pass = new javax.swing.JPasswordField();
        cbo_remember = new javax.swing.JCheckBox();
        rdo_hienMk = new javax.swing.JRadioButton();
        btn_dangKy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng Nhập");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Đăng nhập");

        jPanel1.setBackground(new java.awt.Color(24, 159, 206));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qltv/images/logobee.png"))); // NOI18N
        jLabel4.setPreferredSize(new java.awt.Dimension(50, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("FPT POLYTECHNIC");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qltv/images/profile.png"))); // NOI18N
        jLabel2.setText("Tài Khoản :");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qltv/images/padlock.png"))); // NOI18N
        jLabel3.setText("Mật Khẩu :");

        btn_login.setText("Đăng nhập");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        btn_exit.setText("Thoát");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        cbo_remember.setText("Nhớ mật khẩu ?");
        cbo_remember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_rememberActionPerformed(evt);
            }
        });

        rdo_hienMk.setText("Hiện Mật Khẩu");
        rdo_hienMk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_hienMkActionPerformed(evt);
            }
        });

        btn_dangKy.setText("Đăng Ký");
        btn_dangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dangKyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ma)
                            .addComponent(txt_pass, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(cbo_remember, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(btn_login)
                                .addGap(29, 29, 29)
                                .addComponent(btn_dangKy)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(rdo_hienMk)
                                .addGap(17, 17, 17))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btn_exit)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdo_hienMk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_exit))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbo_remember)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_login)
                            .addComponent(btn_dangKy))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        String ma = txt_ma.getText().trim();
        String pass = new String(txt_pass.getPassword()).trim();
        boolean remember = cbo_remember.isSelected();
        if (checkTrong() == true) {
            if (loginServiceImpl.checkMa(ma) == true) {
                if (loginServiceImpl.checkPass(pass, ma) == true) {
                    JOptionPane.showMessageDialog(rootPane, "Đăng nhập thành công");
                    saveUserCredentials(ma, pass, remember);
                    mainJframe frame = new mainJframe();
                    frame.setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
                    frame.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
                    frame.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Sai mật khẩu !");
                    int chon = JOptionPane.showConfirmDialog(rootPane, "Bạn quên mật khẩu ?");
                    if(chon==0){
                        new quenMatKhauJFrame().setVisible(true);
                        new quenMatKhauJFrame().setLocationRelativeTo(null);
                    }
                    else{
                        
                    }
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Tài khoản không tồn tại !");
            }
        }
    }//GEN-LAST:event_btn_loginActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null,
                "Bạn có chắc chắn muốn thoát?", "Xác nhận",
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
        return;
    }//GEN-LAST:event_btn_exitActionPerformed

    private void cbo_rememberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_rememberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_rememberActionPerformed

    private void rdo_hienMkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_hienMkActionPerformed
        if (rdo_hienMk.isSelected()) {
            txt_pass.setEchoChar((char) 0);
        } else {
            txt_pass.setEchoChar('*');
        }
    }//GEN-LAST:event_rdo_hienMkActionPerformed

    private void btn_dangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dangKyActionPerformed
        new dangKyJFrame().setVisible(true);
    }//GEN-LAST:event_btn_dangKyActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dangKy;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_login;
    private javax.swing.JCheckBox cbo_remember;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rdo_hienMk;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JPasswordField txt_pass;
    // End of variables declaration//GEN-END:variables
}
