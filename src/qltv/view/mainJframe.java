package qltv.view;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import qltv.bean.danhMucBean;
import qltv.controller.chuyenManHinhController;


public class mainJframe extends javax.swing.JFrame {

    public mainJframe() {
        initComponents();

        setTitle("Quản Lý Bán TV");       
        chuyenManHinhController controller = new chuyenManHinhController(jpnView);
        List<danhMucBean> listItem = new ArrayList();
        listItem.add(new danhMucBean("BanHang", jpnBanHang, jlbBanHang));
        listItem.add(new danhMucBean("HoaDon", jpnHoaDon, jlbHoaDon));
        listItem.add(new danhMucBean("SanPham", jpnSanPham, jlbSanPham));
        listItem.add(new danhMucBean("PhieuGiamGia", jpnPhieuGiamGia, jlbPhieuGiamGia));
        listItem.add(new danhMucBean("KhachHang", jpnKhachHang, jlbKhachHang));
        listItem.add(new danhMucBean("NhanVien", jpnNhanVien, jlbNhanVien));
        listItem.add(new danhMucBean("DangXuat", jpnDangXuat, jlbDangXuat));
        controller.setEvent(listItem);
        this.setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        controller.setView(jpnBanHang, jlbBanHang);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnMenu = new javax.swing.JPanel();
        jpnBand = new javax.swing.JPanel();
        jlbTitle = new javax.swing.JLabel();
        jpnBanHang = new javax.swing.JPanel();
        jlbBanHang = new javax.swing.JLabel();
        jpnHoaDon = new javax.swing.JPanel();
        jlbHoaDon = new javax.swing.JLabel();
        jpnSanPham = new javax.swing.JPanel();
        jlbSanPham = new javax.swing.JLabel();
        jpnPhieuGiamGia = new javax.swing.JPanel();
        jlbPhieuGiamGia = new javax.swing.JLabel();
        jpnKhachHang = new javax.swing.JPanel();
        jlbKhachHang = new javax.swing.JLabel();
        jpnNhanVien = new javax.swing.JPanel();
        jlbNhanVien = new javax.swing.JLabel();
        jpnDangXuat = new javax.swing.JPanel();
        jlbDangXuat = new javax.swing.JLabel();
        jpnView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnMenu.setBackground(new java.awt.Color(24, 159, 206));

        jpnBand.setBackground(new java.awt.Color(255, 51, 51));

        jlbTitle.setBackground(new java.awt.Color(0, 0, 0));
        jlbTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlbTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qltv/images/tv.png"))); // NOI18N
        jlbTitle.setText("TV SHOP 07");

        javax.swing.GroupLayout jpnBandLayout = new javax.swing.GroupLayout(jpnBand);
        jpnBand.setLayout(jpnBandLayout);
        jpnBandLayout.setHorizontalGroup(
            jpnBandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBandLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jlbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jpnBandLayout.setVerticalGroup(
            jpnBandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
        );

        jpnBanHang.setBackground(new java.awt.Color(24, 159, 206));

        jlbBanHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbBanHang.setForeground(new java.awt.Color(255, 255, 255));
        jlbBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qltv/images/cart.png"))); // NOI18N
        jlbBanHang.setText("Bán Hàng");

        javax.swing.GroupLayout jpnBanHangLayout = new javax.swing.GroupLayout(jpnBanHang);
        jpnBanHang.setLayout(jpnBanHangLayout);
        jpnBanHangLayout.setHorizontalGroup(
            jpnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBanHangLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jlbBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnBanHangLayout.setVerticalGroup(
            jpnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnBanHangLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpnHoaDon.setBackground(new java.awt.Color(24, 159, 206));

        jlbHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        jlbHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qltv/images/bill.png"))); // NOI18N
        jlbHoaDon.setText("Hóa Đơn");

        javax.swing.GroupLayout jpnHoaDonLayout = new javax.swing.GroupLayout(jpnHoaDon);
        jpnHoaDon.setLayout(jpnHoaDonLayout);
        jpnHoaDonLayout.setHorizontalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnHoaDonLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jlbHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpnHoaDonLayout.setVerticalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHoaDonLayout.createSequentialGroup()
                .addComponent(jlbHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jpnSanPham.setBackground(new java.awt.Color(24, 159, 206));

        jlbSanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbSanPham.setForeground(new java.awt.Color(255, 255, 255));
        jlbSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qltv/images/product.png"))); // NOI18N
        jlbSanPham.setText("Sản Phẩm");

        javax.swing.GroupLayout jpnSanPhamLayout = new javax.swing.GroupLayout(jpnSanPham);
        jpnSanPham.setLayout(jpnSanPhamLayout);
        jpnSanPhamLayout.setHorizontalGroup(
            jpnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSanPhamLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jlbSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnSanPhamLayout.setVerticalGroup(
            jpnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSanPhamLayout.createSequentialGroup()
                .addComponent(jlbSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jpnPhieuGiamGia.setBackground(new java.awt.Color(24, 159, 206));

        jlbPhieuGiamGia.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbPhieuGiamGia.setForeground(new java.awt.Color(255, 255, 255));
        jlbPhieuGiamGia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qltv/images/voucher.png"))); // NOI18N
        jlbPhieuGiamGia.setText("Phiếu Giảm Giá");

        javax.swing.GroupLayout jpnPhieuGiamGiaLayout = new javax.swing.GroupLayout(jpnPhieuGiamGia);
        jpnPhieuGiamGia.setLayout(jpnPhieuGiamGiaLayout);
        jpnPhieuGiamGiaLayout.setHorizontalGroup(
            jpnPhieuGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPhieuGiamGiaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jlbPhieuGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnPhieuGiamGiaLayout.setVerticalGroup(
            jpnPhieuGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPhieuGiamGiaLayout.createSequentialGroup()
                .addComponent(jlbPhieuGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jpnKhachHang.setBackground(new java.awt.Color(24, 159, 206));

        jlbKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        jlbKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qltv/images/customer.png"))); // NOI18N
        jlbKhachHang.setText("Khách Hàng");

        javax.swing.GroupLayout jpnKhachHangLayout = new javax.swing.GroupLayout(jpnKhachHang);
        jpnKhachHang.setLayout(jpnKhachHangLayout);
        jpnKhachHangLayout.setHorizontalGroup(
            jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhachHangLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jlbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnKhachHangLayout.setVerticalGroup(
            jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnNhanVien.setBackground(new java.awt.Color(24, 159, 206));

        jlbNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        jlbNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qltv/images/management.png"))); // NOI18N
        jlbNhanVien.setText("Nhân Viên");

        javax.swing.GroupLayout jpnNhanVienLayout = new javax.swing.GroupLayout(jpnNhanVien);
        jpnNhanVien.setLayout(jpnNhanVienLayout);
        jpnNhanVienLayout.setHorizontalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNhanVienLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jlbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnNhanVienLayout.setVerticalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnDangXuat.setBackground(new java.awt.Color(24, 159, 206));

        jlbDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        jlbDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qltv/images/logout.png"))); // NOI18N
        jlbDangXuat.setText("Đăng Xuất");

        javax.swing.GroupLayout jpnDangXuatLayout = new javax.swing.GroupLayout(jpnDangXuat);
        jpnDangXuat.setLayout(jpnDangXuatLayout);
        jpnDangXuatLayout.setHorizontalGroup(
            jpnDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDangXuatLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jlbDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jpnDangXuatLayout.setVerticalGroup(
            jpnDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDangXuatLayout.createSequentialGroup()
                .addComponent(jlbDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnBand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jpnNhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpnKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpnPhieuGiamGia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpnSanPham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpnHoaDon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpnBanHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jpnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addComponent(jpnBand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnPhieuGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 826, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
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
            java.util.logging.Logger.getLogger(mainJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainJframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlbBanHang;
    private javax.swing.JLabel jlbDangXuat;
    private javax.swing.JLabel jlbHoaDon;
    private javax.swing.JLabel jlbKhachHang;
    private javax.swing.JLabel jlbNhanVien;
    private javax.swing.JLabel jlbPhieuGiamGia;
    private javax.swing.JLabel jlbSanPham;
    private javax.swing.JLabel jlbTitle;
    private javax.swing.JPanel jpnBanHang;
    private javax.swing.JPanel jpnBand;
    private javax.swing.JPanel jpnDangXuat;
    private javax.swing.JPanel jpnHoaDon;
    private javax.swing.JPanel jpnKhachHang;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnNhanVien;
    private javax.swing.JPanel jpnPhieuGiamGia;
    private javax.swing.JPanel jpnSanPham;
    private javax.swing.JPanel jpnView;
    // End of variables declaration//GEN-END:variables
}
