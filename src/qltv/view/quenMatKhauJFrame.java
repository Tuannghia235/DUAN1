package qltv.view;

import javax.swing.JOptionPane;
import qltv.service.loginServiceImpl;


public class quenMatKhauJFrame extends javax.swing.JFrame {

    private loginServiceImpl loginServiceImpl = new loginServiceImpl();
    public quenMatKhauJFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    boolean checkTrong() {
        String ma = txt_ma.getText().trim();
        
        if (ma.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Tài khoản không được để trống !");
            return false;
        }
        String soText = txt_so.getText();
        if (soText.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Số điện thoại chưa nhập!");
            return false;
        }

        int so;
        try {
            so = Integer.parseInt(soText);
            if (so <= 0) {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập số điện thoại > 0!");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Số điện thoại phải là số!");
            return false;
        }
        return true;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_so = new javax.swing.JTextField();
        btn_getMatKhau = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quên Mật Khẩu");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Quên Mật Khẩu");

        jLabel2.setText("Tên Tài Khoản :");

        jLabel3.setText("Số Điện Thoại :");

        btn_getMatKhau.setText("Lấy mật khẩu");
        btn_getMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_getMatKhauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(50, 50, 50)
                                .addComponent(txt_so, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(50, 50, 50)
                                .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_getMatKhau)
                                .addGap(26, 26, 26))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel1)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txt_so, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(btn_getMatKhau)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_getMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_getMatKhauActionPerformed
        String ma = txt_ma.getText();
        int so = Integer.parseInt(txt_so.getText().toString());
        if(checkTrong()==true){
            if(loginServiceImpl.checkMa(ma)==true){
                String pass = loginServiceImpl.getMatKhau(ma, so);
                if(pass!=null){
                    JOptionPane.showMessageDialog(rootPane, "Thành Công, Mật khẩu là : "+pass);
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Thất bại ! Số không đúng");
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Mã chưa tồn tại");
            }
        }
    }//GEN-LAST:event_btn_getMatKhauActionPerformed

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
            java.util.logging.Logger.getLogger(quenMatKhauJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(quenMatKhauJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(quenMatKhauJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quenMatKhauJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new quenMatKhauJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_getMatKhau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_so;
    // End of variables declaration//GEN-END:variables
}
