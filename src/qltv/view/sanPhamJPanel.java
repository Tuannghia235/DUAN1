package qltv.view;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import qltv.model.sanPham;
import qltv.service.sanPhamServiceImpl;

public class sanPhamJPanel extends javax.swing.JPanel {

    private sanPhamServiceImpl spServiceImpl = new sanPhamServiceImpl();
    private DefaultTableModel mol = new DefaultTableModel();
    private int i = -1;

    public sanPhamJPanel() {
        initComponents();
        this.fillToTableSP(spServiceImpl.getListSanPham());
    }

    void fillToTableSP(List<sanPham> list) {
        mol = (DefaultTableModel) tbl_sanPham.getModel();
        mol.setRowCount(0);
        for (sanPham sp : list) {
            mol.addRow(sp.toDataRow());
        }
    }

    void showData(int i) {
        txt_maSP.setText(tbl_sanPham.getValueAt(i, 1).toString());
        txt_tenSP.setText(tbl_sanPham.getValueAt(i, 2).toString());
        if (tbl_sanPham.getValueAt(i, 3).toString().equalsIgnoreCase("Hoạt động")) {
            rdo_ConHang.setSelected(true);
        } else {
            rdo_HetHang.setSelected(true);
        }
    }

    sanPham readForm() {
        String ma;
        String ten;
        boolean trangThai;
        ma = txt_maSP.getText();
        if (ma.isEmpty()) {
            jlb_thongBao.setText("Mã chưa nhập !");
            return null;
        }
        ten = txt_tenSP.getText();
        if (ten.isEmpty()) {
            jlb_thongBao.setText("Tên chưa nhập !");
            return null;
        }
        if (rdo_ConHang.isSelected()) {
            trangThai = true;
        } else {
            trangThai = false;
        }
        return new sanPham(ma, ten, trangThai);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jpnRoot = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jpnThongTin = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jlbSearch = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        txt_maSP = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rdo_ConHang = new javax.swing.JRadioButton();
        rdo_HetHang = new javax.swing.JRadioButton();
        btn_timKiem = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_sanPham = new javax.swing.JTable();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_lamMoi = new javax.swing.JButton();
        txt_tenSP = new javax.swing.JTextField();
        cbo_Loc = new javax.swing.JComboBox<>();
        jlb_thongBao = new javax.swing.JLabel();
        sanPhamChiTietJPanel1 = new qltv.view.sanPhamChiTietJPanel();

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 102));

        jpnThongTin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel4.setText("Mã Sản Phẩm :");

        jlbSearch.setText("Tìm Kiếm :");

        txt_search.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txt_maSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maSPActionPerformed(evt);
            }
        });

        jLabel5.setText("Trạng Thái :");

        buttonGroup1.add(rdo_ConHang);
        rdo_ConHang.setSelected(true);
        rdo_ConHang.setText("Hoạt đông");

        buttonGroup1.add(rdo_HetHang);
        rdo_HetHang.setText("Không hoạt động");
        rdo_HetHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_HetHangActionPerformed(evt);
            }
        });

        btn_timKiem.setText("Tìm Kiếm");
        btn_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timKiemActionPerformed(evt);
            }
        });

        jLabel6.setText("Tên Sản Phẩm :");

        tbl_sanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Mã", "Tên", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_sanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_sanPham);

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

        cbo_Loc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoạt động", "Không hoạt động" }));
        cbo_Loc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_LocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tenSP))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(btn_them)
                                .addGap(40, 40, 40)
                                .addComponent(btn_sua)
                                .addGap(40, 40, 40)
                                .addComponent(btn_xoa)
                                .addGap(40, 40, 40)
                                .addComponent(btn_lamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(cbo_Loc, 0, 143, Short.MAX_VALUE)))
                        .addGap(0, 46, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlbSearch)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_maSP, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(45, 45, 45)
                            .addComponent(btn_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(36, 36, 36)
                            .addComponent(rdo_ConHang)
                            .addGap(47, 47, 47)
                            .addComponent(rdo_HetHang)))
                    .addContainerGap(246, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_tenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_Loc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_them)
                    .addComponent(btn_sua)
                    .addComponent(btn_xoa)
                    .addComponent(btn_lamMoi))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlbSearch)
                        .addComponent(btn_timKiem))
                    .addGap(41, 41, 41)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txt_maSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(rdo_ConHang)
                        .addComponent(rdo_HetHang))
                    .addContainerGap(263, Short.MAX_VALUE)))
        );

        jlb_thongBao.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jlb_thongBao.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jpnThongTinLayout = new javax.swing.GroupLayout(jpnThongTin);
        jpnThongTin.setLayout(jpnThongTinLayout);
        jpnThongTinLayout.setHorizontalGroup(
            jpnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThongTinLayout.createSequentialGroup()
                .addGroup(jpnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnThongTinLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnThongTinLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jlb_thongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jpnThongTinLayout.setVerticalGroup(
            jpnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnThongTinLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jlb_thongBao)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jpnThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thông tin chi tiết", jPanel6);
        jTabbedPane1.addTab("Chi tiết sản phẩm", sanPhamChiTietJPanel1);

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnRoot, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 66, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_maSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maSPActionPerformed

    private void tbl_sanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sanPhamMouseClicked
        i = tbl_sanPham.getSelectedRow();
        txt_maSP.setEnabled(false);
        this.showData(i);
    }//GEN-LAST:event_tbl_sanPhamMouseClicked

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        sanPham sp = readForm();
        if (sp != null) {
            String maSp = txt_maSP.getText().trim();
            if (spServiceImpl.checkMa(maSp) == false) {
                if (spServiceImpl.addSanPham(sp) > 0) {
                    jlb_thongBao.setText("Thêm thành công");
                    fillToTableSP(spServiceImpl.getListSanPham());
                } else {
                    jlb_thongBao.setText("Thêm thất bại");
                }
            } else {
                jlb_thongBao.setText("Mã sản phẩm đã tồn tại");
            }
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        sanPham sp = readForm();
        if (sp != null) {
            i = tbl_sanPham.getSelectedRow();
            if (i == -1) {
                jlb_thongBao.setText("Bạn chưa chọn dòng để sửa");
            } else {
                int id = Integer.parseInt(tbl_sanPham.getValueAt(i, 0).toString());
                if (spServiceImpl.updateSanPham(id, sp) > 0) {
                    jlb_thongBao.setText("Sửa thành công");
                    fillToTableSP(spServiceImpl.getListSanPham());
                } else {
                    jlb_thongBao.setText("Sửa thất bại");
                }
            }
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_lamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lamMoiActionPerformed
        txt_maSP.setEnabled(true);
        txt_maSP.setText("");
        txt_tenSP.setText("");
        buttonGroup1.clearSelection();
        rdo_ConHang.setSelected(true);
        fillToTableSP(spServiceImpl.getListSanPham());
    }//GEN-LAST:event_btn_lamMoiActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        i = tbl_sanPham.getSelectedRow();
        if (i == -1) {
            jlb_thongBao.setText("Bạn chưa chọn dòng để xóa");
        } else {
            int id = Integer.parseInt(tbl_sanPham.getValueAt(i, 0).toString());
            if (spServiceImpl.deleteSanPham(id) > 0) {
                jlb_thongBao.setText("Xóa thành công");
                fillToTableSP(spServiceImpl.getListSanPham());
            } else {
                jlb_thongBao.setText("Xóa thất bại");
            }
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void cbo_LocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_LocActionPerformed
        boolean trangThai;
        if(cbo_Loc.getSelectedItem().toString().equalsIgnoreCase("Còn Hàng")){
            trangThai = true;
            fillToTableSP(spServiceImpl.getListSanPhamOrderByTrangThai(trangThai));
        }
        else{
            trangThai = false;
            fillToTableSP(spServiceImpl.getListSanPhamOrderByTrangThai(trangThai));
        }
    }//GEN-LAST:event_cbo_LocActionPerformed

    private void btn_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiemActionPerformed
        String ma = txt_search.getText().trim();
        fillToTableSP(spServiceImpl.getListSanPhamByMa(ma));
    }//GEN-LAST:event_btn_timKiemActionPerformed

    private void rdo_HetHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_HetHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdo_HetHangActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_lamMoi;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_timKiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbo_Loc;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jlbSearch;
    private javax.swing.JLabel jlb_thongBao;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnThongTin;
    private javax.swing.JRadioButton rdo_ConHang;
    private javax.swing.JRadioButton rdo_HetHang;
    private qltv.view.sanPhamChiTietJPanel sanPhamChiTietJPanel1;
    private javax.swing.JTable tbl_sanPham;
    private javax.swing.JTextField txt_maSP;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_tenSP;
    // End of variables declaration//GEN-END:variables
}
