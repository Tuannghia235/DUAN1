package qltv.view;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import qltv.model.doPhanGiai;
import qltv.service.sanPhamServiceImpl;

public class doPhanGiaiJFrame extends javax.swing.JFrame {

    private sanPhamServiceImpl spServiceImpl = new sanPhamServiceImpl();
    private DefaultTableModel mol = new DefaultTableModel();
    private int i = -1;
    public doPhanGiaiJFrame() {
        initComponents();
        setLocationRelativeTo(null);
        fillToTable(spServiceImpl.getAllResolutions());
    }

    void fillToTable(List<doPhanGiai> list) {
        mol = (DefaultTableModel) tbl_bang.getModel();
        mol.setRowCount(0);
        for (doPhanGiai dpg : list) {
            mol.addRow(dpg.toDataRow());
        }
    }
    
    void showData(int i) {
        txt_ma.setText(tbl_bang.getValueAt(i, 1).toString());
        txt_ten.setText(tbl_bang.getValueAt(i, 2).toString());
    }
    
    doPhanGiai readForm(){
        String ma;
        String ten;
        ma = txt_ma.getText();
        if (ma.isEmpty()) {
            jlb_thongBao.setText("Mã chưa nhập !");
            return null;
        }
        ten = txt_ten.getText();
        if (ten.isEmpty()) {
            jlb_thongBao.setText("Tên chưa nhập !");
            return null;
        }
        return new doPhanGiai(ma, ten);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        txt_ten = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_lamMoi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_bang = new javax.swing.JTable();
        jlb_thongBao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản Lý Độ Phân Giải");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Quản Lý Độ Phân Giải");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Mã Độ Phân Giải :");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Tên Độ Phân Giải :");

        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_lamMoi.setText("Làm Mới");
        btn_lamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lamMoiActionPerformed(evt);
            }
        });

        tbl_bang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Mã", "Tên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_bang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_bang);

        jlb_thongBao.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlb_thongBao.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlb_thongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(61, 61, 61)
                                        .addComponent(btn_them)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_sua)))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btn_xoa)
                                        .addGap(23, 23, 23)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_lamMoi)
                                    .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jlb_thongBao)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them)
                    .addComponent(btn_sua)
                    .addComponent(btn_xoa)
                    .addComponent(btn_lamMoi))
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_bangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bangMouseClicked
        i = tbl_bang.getSelectedRow();
        this.showData(i);
        txt_ma.setEnabled(false);
    }//GEN-LAST:event_tbl_bangMouseClicked

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        doPhanGiai dpg = readForm();
        if(dpg != null){
            String ma = txt_ma.getText().trim();
            String ten = txt_ten.getText().trim();
            if(spServiceImpl.checkMaDpg(ma)==false){
                if(spServiceImpl.checkTenDpg(ten)==false){
                    if(spServiceImpl.addDoPhanGiai(dpg)>0){
                        jlb_thongBao.setText("Thêm thành công");
                        fillToTable(spServiceImpl.getAllResolutions());
                    }
                    else{
                        jlb_thongBao.setText("Thêm thất bại");
                    }
                }
                else{
                    jlb_thongBao.setText("Tên đã tồn tại");
                }
            }
            else{
                jlb_thongBao.setText("Mã đã tồn tại");
            }
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_lamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lamMoiActionPerformed
       txt_ma.setEnabled(true);
        txt_ma.setText("");
        txt_ten.setText("");
        fillToTable(spServiceImpl.getAllResolutions());
        jlb_thongBao.setText("Làm Mới Thành Công");
    }//GEN-LAST:event_btn_lamMoiActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        doPhanGiai dpg = readForm();
        int i = tbl_bang.getSelectedRow();
        if (i == -1) {
            jlb_thongBao.setText("Bạn chưa chọn dòng để sửa");
        } else {
            if (dpg != null) {
                int id = Integer.parseInt(tbl_bang.getValueAt(i, 0).toString());
                if (spServiceImpl.updateDpg(id, dpg) > 0) {
                    jlb_thongBao.setText("Sửa thành công");
                    fillToTable(spServiceImpl.getAllResolutions());
                } else {
                    jlb_thongBao.setText("Sửa thất bại");
                }
            }
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        i = tbl_bang.getSelectedRow();
        if (i == -1) {
            jlb_thongBao.setText("Bạn chưa chọn dòng để xóa");
        } else {
            int id = Integer.parseInt(tbl_bang.getValueAt(i, 0).toString());
            if (spServiceImpl.deleteDpg(id) > 0) {
                jlb_thongBao.setText("Xóa thành công");
                fillToTable(spServiceImpl.getAllResolutions());
            } else {
                jlb_thongBao.setText("Xóa thất bại");
            }
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

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
            java.util.logging.Logger.getLogger(doPhanGiaiJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(doPhanGiaiJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(doPhanGiaiJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(doPhanGiaiJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new doPhanGiaiJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_lamMoi;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlb_thongBao;
    private javax.swing.JTable tbl_bang;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_ten;
    // End of variables declaration//GEN-END:variables
}
