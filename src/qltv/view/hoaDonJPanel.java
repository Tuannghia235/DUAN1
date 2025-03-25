
package qltv.view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import qltv.dao.HDCTService;
import qltv.dao.SanPhamCTService;
import qltv.dao.HoaDonService;
import qltv.model.HoaDonChiTiet_Model;
import qltv.model.hoaDon;


public class hoaDonJPanel extends javax.swing.JPanel {
    HoaDonService HoaDonRespository;
    SanPhamCTService SanPhamCTRespos;
    HDCTService HoaDonChiTietResponsitory;

    DefaultTableModel dtmHoaDon;
    DefaultTableModel dtmGioHang;
    
    public hoaDonJPanel() {
        initComponents();
        SanPhamCTRespos = new SanPhamCTService();
        HoaDonRespository = new HoaDonService();
        HoaDonChiTietResponsitory = new HDCTService();
        dtmHoaDon = (DefaultTableModel) tblHoaDon.getModel();
        dtmGioHang = (DefaultTableModel) tblGioHang.getModel();
        showTableHoaDon(HoaDonRespository.getAllHD());
    }
    
     public void showTableHoaDon(ArrayList<hoaDon> danhSach) {
        dtmHoaDon.setRowCount(0);
        for (hoaDon hd : danhSach) {
            String trangThai = hd.getTrangThai() == 1 ? "Đã thanh toán" : "Chưa thanh toán";
            dtmHoaDon.addRow(new Object[]{
                hd.getId(),
                hd.getTen(),
                hd.getSdt(),
                hd.getNgay(),
                trangThai  
            });
        }
    }

    public void showTableHoaDonChiTiet(ArrayList<HoaDonChiTiet_Model> danhSach) {
        dtmGioHang.setRowCount(0);
        for (HoaDonChiTiet_Model hdct : danhSach) {
            dtmGioHang.addRow(new Object[]{
                hdct.getId_spct(),
                hdct.getTenSanPham(),
                hdct.getSoLuong(),
                hdct.getTongTien(),hdct.getSoLuong()*hdct.getTongTien()});
        }
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtSoDienThoai1 = new javax.swing.JTextField();
        txt_ngay = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTen1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btn_Chon = new javax.swing.JButton();
        btn_Refresh = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        txt_Tim = new javax.swing.JTextField();
        btn_Tim = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Giỏ hàng");

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID hóa đơn", "Tên khách hàng", "Số điện thoại", "Ngày thanh toán", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Danh sách hóa đơn");

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblGioHang);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("Ngày thanh toán");

        jLabel11.setText("Tên khách hàng");

        jLabel12.setText("Số điện thoại");

        btn_Chon.setText("Chọn");
        btn_Chon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ChonActionPerformed(evt);
            }
        });

        btn_Refresh.setText("Làm mới");
        btn_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RefreshActionPerformed(evt);
            }
        });

        btn_Xoa.setText("Xóa");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        btn_Sua.setText("Sửa");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel8)
                        .addGap(26, 26, 26)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTen1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(btn_Chon))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSoDienThoai1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_Sua)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Xoa)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Refresh)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTen1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Chon))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDienThoai1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Refresh)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Xoa)
                    .addComponent(btn_Sua))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        txt_Tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TimActionPerformed(evt);
            }
        });

        btn_Tim.setText("Tìm kiếm");
        btn_Tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Tim)
                        .addGap(10, 10, 10))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Tim))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ChonActionPerformed
        new hoaDonKhachJFrame1(this).setVisible(true);
    }//GEN-LAST:event_btn_ChonActionPerformed

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        int i = tblHoaDon.getSelectedRow();
        if(i == -1) {
            JOptionPane.showMessageDialog(this, "Hãy chọn hóa đơn cần sửa");
            return;
        }
        if(tblHoaDon.getValueAt(i, 4).toString().equalsIgnoreCase("Đã thanh toán")){
            JOptionPane.showMessageDialog(this, "Không thể sửa hóa đơn đã thanh toán");
            return;
        }
        try {
            String ten = txtTen1.getText();
            String soDT = txtSoDienThoai1.getText();
            int id = Integer.parseInt(tblHoaDon.getValueAt(i, 0).toString());
            String ngay = txt_ngay.getText();
            if (!soDT.matches("\\d{10}")) {
                JOptionPane.showMessageDialog(this, "Số điện thoại phải gồm 10 chữ số.");
                return;
            }
            HoaDonRespository.suaHoaDon(id ,ten, soDT, ngay);
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            showTableHoaDon(HoaDonRespository.getAllHD());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi sửa hóa đơn.");
        }
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int i = tblHoaDon.getSelectedRow();
        
        txtTen1.setText(tblHoaDon.getValueAt(i, 1).toString());
        txtSoDienThoai1.setText(tblHoaDon.getValueAt(i, 2).toString());
        txt_ngay.setText(tblHoaDon.getValueAt(i, 3).toString());
        int idHoaDon = Integer.parseInt(tblHoaDon.getValueAt(i, 0).toString());
        showTableHoaDonChiTiet(HoaDonChiTietResponsitory.getALLByIdHoaDon(idHoaDon));
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
       int selectedRow = tblHoaDon.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hóa đơn để xóa.");
            return;
        }
        if(tblHoaDon.getValueAt(selectedRow, 4).toString().equalsIgnoreCase("Đã thanh toán")){
            JOptionPane.showMessageDialog(this, "Không thể xóa hóa đơn đã thanh toán");
            return;
        }
        int idHoaDon = Integer.parseInt(tblHoaDon.getValueAt(selectedRow, 0).toString());
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa hóa đơn này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            HoaDonRespository.deleteHoaDon(idHoaDon);
            showTableHoaDon(HoaDonRespository.getAllHD());
            dtmGioHang.setRowCount(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void btn_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefreshActionPerformed
        tblHoaDon.clearSelection();
        txtSoDienThoai1.setText("");
        txtTen1.setText("");
        txt_ngay.setText("");
    }//GEN-LAST:event_btn_RefreshActionPerformed

    private void txt_TimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TimActionPerformed

    private void btn_TimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimActionPerformed
      String input = txt_Tim.getText().toString().trim();
        if (!input.isEmpty()) {
            if (!HoaDonRespository.timHD(input).isEmpty()) {
                showTableHoaDon(HoaDonRespository.timHD(input));
            } else {
                JOptionPane.showMessageDialog(this, "ko tìm thấy");
            }
        } else
            JOptionPane.showMessageDialog(this, "ô tìm kiếm đang trống");  
    }//GEN-LAST:event_btn_TimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Chon;
    private javax.swing.JButton btn_Refresh;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Tim;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtSoDienThoai1;
    private javax.swing.JTextField txtTen1;
    private javax.swing.JTextField txt_Tim;
    private javax.swing.JTextField txt_ngay;
    // End of variables declaration//GEN-END:variables

    void setCustomerInfo(String tenKhachHang, String soDienThoai) {
        txtTen1.setText(tenKhachHang);
        txtSoDienThoai1.setText(soDienThoai);
    }
}
