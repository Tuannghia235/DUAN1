package qltv.view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import qltv.dao.HoaDonService;
import qltv.model.khachHang;

public class banHangKhachJFrame extends javax.swing.JFrame {

    static banHangJPanel setCustomerInfo;
    HoaDonService HoaDonRespository;
    DefaultTableModel dtmHoaDon;

    public banHangKhachJFrame(banHangJPanel parentPanel) {
        initComponents();
        HoaDonRespository = new HoaDonService();
        dtmHoaDon = (DefaultTableModel) tblKhachHang.getModel();
        this.setCustomerInfo = parentPanel;
        fillToTable(HoaDonRespository.getAllKhachHang());
        setLocationRelativeTo(null);
    }

    public void fillToTable(ArrayList<khachHang> danhSach) {
        dtmHoaDon.setRowCount(0);
        for (khachHang kh : danhSach) {
            String gioiTinh = kh.getGioiTinh() == 1 ? "Nam" : "Nữ";
            dtmHoaDon.addRow(new Object[]{
                kh.getTen(),
                kh.getSoDienThoai(),
                kh.getDiaChi(),
                gioiTinh,
                kh.getNgaySinh()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        btnChon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tên khách hàng", "Số điện thoại", "Địa chỉ ", "Giới tính ", "Ngày sinh"
            }
        ));
        jScrollPane1.setViewportView(tblKhachHang);

        btnChon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChon.setText("Chọn");
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnChon, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChon)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        // TODO add your handling code here:
        int i = tblKhachHang.getSelectedRow();
        if (i != -1) {
            String tenKhachHang = tblKhachHang.getValueAt(i, 0).toString();
            String soDienThoai = tblKhachHang.getValueAt(i, 1).toString();
            setCustomerInfo.setCustomerInfo(tenKhachHang, soDienThoai);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng!");
        }
    }//GEN-LAST:event_btnChonActionPerformed

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
            java.util.logging.Logger.getLogger(banHangKhachJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(banHangKhachJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(banHangKhachJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(banHangKhachJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new banHangKhachJFrame(setCustomerInfo).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChon;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKhachHang;
    // End of variables declaration//GEN-END:variables
}
