package qltv.view;

import qltv.model.nhanVien;
import qltv.service.loginServiceImpl;

public class dangKyJFrame extends javax.swing.JFrame {

    private loginServiceImpl loginServiceImpl = new loginServiceImpl();

    public dangKyJFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    nhanVien readForm() {
        String ma;
        String ten;

        ma = txt_ma.getText();
        if (ma.isEmpty()) {
            jlb_thongBao.setText("Tên tài khoản chưa nhập!");
            return null;
        }

        ten = txt_ten.getText();
        if (ten.isEmpty()) {
            jlb_thongBao.setText("Tên người dùng chưa nhập!");
            return null;
        }

        String soText = txt_soDienThoai.getText();
        if (soText.isEmpty()) {
            jlb_thongBao.setText("Số điện thoại chưa nhập!");
            return null;
        }

        int so;
        try {
            so = Integer.parseInt(soText);
            if (so <= 0) {
                jlb_thongBao.setText("Vui lòng nhập số điện thoại > 0!");
                return null;
            }
        } catch (NumberFormatException e) {
            jlb_thongBao.setText("Số điện thoại phải là số!");
            return null;
        }

        // Convert char[] to String correctly
        char[] passArray = txt_pass.getPassword();
        String pass = new String(passArray);
        if (pass.isEmpty()) {
            jlb_thongBao.setText("Mật khẩu chưa nhập!");
            return null;
        }

        char[] checkPassArray = txt_checkPass.getPassword();
        String checkPass = new String(checkPassArray);
        if (!pass.equals(checkPass)) {
            jlb_thongBao.setText("Mật khẩu không khớp!");
            return null;
        }

        // Return a new instance of nhanVien if all fields are valid
        return new nhanVien(ma, ten, soText, pass);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        txt_soDienThoai = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_pass = new javax.swing.JPasswordField();
        txt_checkPass = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        btn_dangKy = new javax.swing.JButton();
        rdo_hienPass = new javax.swing.JRadioButton();
        btn_quenMK = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_ten = new javax.swing.JTextField();
        jlb_thongBao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Đăng Ký");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Đăng Ký Tài Khoản");

        jLabel2.setText("Tên Tài Khoản :");

        jLabel3.setText("Số Điện Thoại :");

        jLabel4.setText("Mật Khẩu :");

        jLabel5.setText("Nhập Lại Mật Khẩu :");

        btn_dangKy.setText("Đăng Ký");
        btn_dangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dangKyActionPerformed(evt);
            }
        });

        rdo_hienPass.setText("Hiện Mật Khẩu");
        rdo_hienPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_hienPassActionPerformed(evt);
            }
        });

        btn_quenMK.setText("Quên Mật Khẩu");
        btn_quenMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quenMKActionPerformed(evt);
            }
        });

        jLabel6.setText("Tên Người Dùng :");

        jlb_thongBao.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlb_thongBao.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdo_hienPass)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_dangKy)
                                        .addGap(27, 27, 27)
                                        .addComponent(btn_quenMK)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(txt_checkPass))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_pass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                                    .addComponent(txt_soDienThoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                                    .addComponent(txt_ten, javax.swing.GroupLayout.Alignment.LEADING)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jlb_thongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addComponent(jlb_thongBao)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_soDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_checkPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(rdo_hienPass)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_dangKy)
                    .addComponent(btn_quenMK))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdo_hienPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_hienPassActionPerformed
        if (rdo_hienPass.isSelected()) {
            txt_pass.setEchoChar((char) 0);
            txt_checkPass.setEchoChar((char) 0);
        } else {
            txt_pass.setEchoChar('*');
            txt_checkPass.setEchoChar('*');
        }
    }//GEN-LAST:event_rdo_hienPassActionPerformed

    private void btn_dangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dangKyActionPerformed
        nhanVien nv = readForm();
        if (nv != null) {
            String ma = txt_ma.getText().trim();
            if (loginServiceImpl.checkMa(ma) == false) {
                if (loginServiceImpl.addAccount(nv) > 0) {
                    jlb_thongBao.setText("Đăng ký thành công");
                    dispose();
                } else {
                    jlb_thongBao.setText("Đăng Ký thất bại");
                }
            } else {
                jlb_thongBao.setText("Tên tài khoản đã tồn tại");
            }
        }
    }//GEN-LAST:event_btn_dangKyActionPerformed

    private void btn_quenMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quenMKActionPerformed
        new quenMatKhauJFrame().setVisible(true);
        new quenMatKhauJFrame().setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_quenMKActionPerformed

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
            java.util.logging.Logger.getLogger(dangKyJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dangKyJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dangKyJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dangKyJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dangKyJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dangKy;
    private javax.swing.JButton btn_quenMK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jlb_thongBao;
    private javax.swing.JRadioButton rdo_hienPass;
    private javax.swing.JPasswordField txt_checkPass;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_soDienThoai;
    private javax.swing.JTextField txt_ten;
    // End of variables declaration//GEN-END:variables
}
