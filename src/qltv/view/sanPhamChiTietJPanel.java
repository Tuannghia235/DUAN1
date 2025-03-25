package qltv.view;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import qltv.model.doPhanGiai;
import qltv.model.kichCo;
import qltv.model.kieuDang;
import qltv.model.manHinh;
import qltv.model.sanPham;
import qltv.model.sanPhamChiTiet;
import qltv.model.thuongHieu;
import qltv.service.sanPhamServiceImpl;

public class sanPhamChiTietJPanel extends javax.swing.JPanel {

    private sanPhamServiceImpl spServiceImpl = new sanPhamServiceImpl();
    private DefaultTableModel mol = new DefaultTableModel();
    private int i = -1;

    public sanPhamChiTietJPanel() {
        initComponents();
        fillToTable(spServiceImpl.getListSanPhamChiTiet());
        setComboBox();
    }

    void setComboBox() {
        cbo_thuongHieu.removeAllItems();
        for (thuongHieu th : spServiceImpl.getTenThuongHieu()) {
            cbo_thuongHieu.addItem(th.getTen());

        }
        cbo_sanPham.removeAllItems();
        for (sanPham sp : spServiceImpl.getTenSanPham()) {
            cbo_sanPham.addItem(sp.getTen());
        }
        cbo_kichCo.removeAllItems();
        for (kichCo kc : spServiceImpl.getInch()) {
            cbo_kichCo.addItem(String.valueOf(kc.getInch()));
        }
        cbo_kieuDang.removeAllItems();
        for (kieuDang kd : spServiceImpl.getTenKieuDang()) {
            cbo_kieuDang.addItem(kd.getTen());
        }
        cbo_manHinh.removeAllItems();
        for (manHinh mh : spServiceImpl.getTenManHinh()) {
            cbo_manHinh.addItem(mh.getTen());
        }
        cbo_phanGiai.removeAllItems();
        for (doPhanGiai dpg : spServiceImpl.getTenDoPhanGiai()) {
            cbo_phanGiai.addItem(dpg.getTen());
        }
    }

    void fillToTable(List<sanPhamChiTiet> list) {
        mol = (DefaultTableModel) tbl_bang.getModel();
        mol.setRowCount(0);
        for (sanPhamChiTiet spct : list) {
            mol.addRow(spct.toDataRow());
        }
    }

    void showData(int i) {
        txt_ma.setText(tbl_bang.getValueAt(i, 1).toString());
        cbo_sanPham.setSelectedItem(tbl_bang.getValueAt(i, 2).toString());
        txt_soLuong.setText(tbl_bang.getValueAt(i, 3).toString());
        txt_donGia.setText(tbl_bang.getValueAt(i, 4).toString());
        cbo_thuongHieu.setSelectedItem(tbl_bang.getValueAt(i, 5).toString());
        cbo_kieuDang.setSelectedItem(tbl_bang.getValueAt(i, 6).toString());
        cbo_manHinh.setSelectedItem(tbl_bang.getValueAt(i, 7).toString());
        cbo_kichCo.setSelectedItem(tbl_bang.getValueAt(i, 8).toString());
        cbo_phanGiai.setSelectedItem(tbl_bang.getValueAt(i, 9).toString());
        if (tbl_bang.getValueAt(i, 10).toString().equalsIgnoreCase("Cũ")) {
            rdo_Cu.setSelected(true);
        } else {
            rdo_Moi.setSelected(true);
        }
        if (tbl_bang.getValueAt(i, 11).toString().equalsIgnoreCase("Hoạt động")) {
            rdo_ConHang.setSelected(true);
        } else {
            rdo_hetHang.setSelected(true);
        }
    }

    sanPhamChiTiet readForm() {
        String ma = txt_ma.getText();
        if (ma.isEmpty()) {
            jlb_thongBao.setText("Mã chưa nhập");
            return null;
        }

        int idSp = spServiceImpl.getIDByTenSp(cbo_sanPham.getSelectedItem().toString());

        String soLuongText = txt_soLuong.getText();
        if (soLuongText.isEmpty()) {
            jlb_thongBao.setText("Số lượng chưa nhập !");
            return null;
        }
        int soLuong;
        try {
            soLuong = Integer.parseInt(soLuongText);
            if (soLuong <= 0) {
                jlb_thongBao.setText("Vui lòng nhập số lượng > 0 !");
                return null;
            }
        } catch (NumberFormatException e) {
            jlb_thongBao.setText("Số lượng phải là số !");
            return null;
        }

        String donGiaText = txt_donGia.getText();
        if (donGiaText.isEmpty()) {
            jlb_thongBao.setText("Đơn giá chưa nhập !");
            return null;
        }
        int donGia;
        try {
            donGia = Integer.parseInt(donGiaText);
            if (donGia <= 0) {
                jlb_thongBao.setText("Vui lòng nhập đơn giá > 0 !");
                return null;
            }
        } catch (NumberFormatException e) {
            jlb_thongBao.setText("Đơn giá phải là số !");
            return null;
        }

        int idTh = spServiceImpl.getIDByTenTh(cbo_thuongHieu.getSelectedItem().toString());
        int idKd = spServiceImpl.getIDByTenKd(cbo_kieuDang.getSelectedItem().toString());
        int idMh = spServiceImpl.getIDByTenMh(cbo_manHinh.getSelectedItem().toString());
        int idKc = spServiceImpl.getIDByTenKc(cbo_kichCo.getSelectedItem().toString());
        int idDpg = spServiceImpl.getIDByTenDpg(cbo_phanGiai.getSelectedItem().toString());

        int phanLoai;
        if (rdo_Cu.isSelected()) {
            phanLoai = 1;
        } else {
            phanLoai = 2;
        }

        boolean trangThai;
        if (rdo_ConHang.isSelected()) {
            trangThai = true;
        } else {
            trangThai = false;
        }

        jlb_thongBao.setText("");
        return new sanPhamChiTiet(ma, idSp, soLuong, donGia, idTh, idKd, idMh, idKc, idDpg, phanLoai, trangThai);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jlb_thongBao = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        txt_soLuong = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbo_thuongHieu = new javax.swing.JComboBox<>();
        cbo_manHinh = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbo_phanGiai = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbo_kieuDang = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbo_kichCo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rdo_Cu = new javax.swing.JRadioButton();
        rdo_Moi = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_donGia = new javax.swing.JTextField();
        btn_themManHinh = new javax.swing.JButton();
        btn_themThuongHieu = new javax.swing.JButton();
        btn_themDoPhanGiai = new javax.swing.JButton();
        btn_themKieuDang = new javax.swing.JButton();
        btn_themKichCo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_bang = new javax.swing.JTable();
        txt_search = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_lamMoi = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        rdo_hetHang = new javax.swing.JRadioButton();
        rdo_ConHang = new javax.swing.JRadioButton();
        cbo_sanPham = new javax.swing.JComboBox<>();
        btn_timKiem = new javax.swing.JButton();
        cbo_trangThai = new javax.swing.JComboBox<>();

        jlb_thongBao.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jlb_thongBao.setForeground(new java.awt.Color(255, 0, 51));
        jlb_thongBao.setName(""); // NOI18N
        jlb_thongBao.setPreferredSize(new java.awt.Dimension(50, 50));

        jLabel1.setText("Mã Sản Phẩm Chi Tiết :");

        jLabel2.setText("Số Lượng :");

        jLabel3.setText("Thương Hiệu :");

        cbo_thuongHieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_thuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_thuongHieuActionPerformed(evt);
            }
        });

        cbo_manHinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Màn Hình :");

        cbo_phanGiai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Phân Giải :");

        cbo_kieuDang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_kieuDang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_kieuDangActionPerformed(evt);
            }
        });

        jLabel6.setText("Kiểu Dáng :");

        cbo_kichCo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Kích Cỡ :");

        jLabel8.setText("Loại :");

        buttonGroup1.add(rdo_Cu);
        rdo_Cu.setText("Cũ");

        buttonGroup1.add(rdo_Moi);
        rdo_Moi.setSelected(true);
        rdo_Moi.setText("Mới");

        jLabel9.setText("Mã Sản Phẩm :");

        jLabel10.setText("Đơn Giá :");

        btn_themManHinh.setText("+");
        btn_themManHinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themManHinhActionPerformed(evt);
            }
        });

        btn_themThuongHieu.setText("+");
        btn_themThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themThuongHieuActionPerformed(evt);
            }
        });

        btn_themDoPhanGiai.setText("+");
        btn_themDoPhanGiai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themDoPhanGiaiActionPerformed(evt);
            }
        });

        btn_themKieuDang.setText("+");
        btn_themKieuDang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themKieuDangActionPerformed(evt);
            }
        });

        btn_themKichCo.setText("+");
        btn_themKichCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themKichCoActionPerformed(evt);
            }
        });

        tbl_bang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã", "Mã Sản Phẩm", "Số Lượng", "Đơn Giá", "Thương Hiệu", "Kiểu Dáng", "Màn Hình", "Kích Cỡ", "Phân Giải", "Loại", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
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

        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });

        jLabel11.setText("Tìm Kiếm :");

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

        jLabel12.setText("Trạng Thái :");

        buttonGroup2.add(rdo_hetHang);
        rdo_hetHang.setText("Không hoạt động");

        buttonGroup2.add(rdo_ConHang);
        rdo_ConHang.setSelected(true);
        rdo_ConHang.setText("Hoạt động");

        cbo_sanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_sanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_sanPhamActionPerformed(evt);
            }
        });

        btn_timKiem.setText("Tìm kiếm");
        btn_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timKiemActionPerformed(evt);
            }
        });

        cbo_trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoạt động", "Không hoạt động" }));
        cbo_trangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_trangThaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btn_timKiem)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 73, Short.MAX_VALUE)
                                        .addComponent(btn_them)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_sua)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_xoa)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_lamMoi))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdo_ConHang)
                                        .addGap(22, 22, 22)
                                        .addComponent(rdo_hetHang)))
                                .addGap(230, 230, 230))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_ma)
                                    .addComponent(txt_soLuong)
                                    .addComponent(cbo_thuongHieu, 0, 205, Short.MAX_VALUE)
                                    .addComponent(cbo_manHinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbo_phanGiai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_themManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_themThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_themDoPhanGiai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbo_sanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_donGia, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(cbo_kichCo, 0, 223, Short.MAX_VALUE)
                                                    .addComponent(cbo_kieuDang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(rdo_Cu, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(rdo_Moi, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(cbo_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(97, 97, 97)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btn_themKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btn_themKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(10, 10, 10))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jlb_thongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jlb_thongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(cbo_sanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txt_donGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbo_thuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbo_kieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_themThuongHieu)
                    .addComponent(btn_themKieuDang))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbo_manHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cbo_kichCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_themManHinh)
                    .addComponent(btn_themKichCo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbo_phanGiai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(rdo_Cu)
                    .addComponent(rdo_Moi)
                    .addComponent(btn_themDoPhanGiai))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(rdo_hetHang)
                    .addComponent(rdo_ConHang))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them)
                    .addComponent(btn_sua)
                    .addComponent(btn_xoa)
                    .addComponent(btn_lamMoi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(btn_timKiem)
                    .addComponent(cbo_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbo_thuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_thuongHieuActionPerformed

    }//GEN-LAST:event_cbo_thuongHieuActionPerformed

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void cbo_kieuDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_kieuDangActionPerformed

    }//GEN-LAST:event_cbo_kieuDangActionPerformed

    private void tbl_bangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bangMouseClicked
        i = tbl_bang.getSelectedRow();
        txt_ma.setEnabled(false);
        this.showData(i);
    }//GEN-LAST:event_tbl_bangMouseClicked

    private void btn_lamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lamMoiActionPerformed
        txt_ma.setEnabled(true);
        txt_ma.setText("");
        txt_soLuong.setText("");
        txt_donGia.setText("");
        txt_search.setText("");
        jlb_thongBao.setText("Làm Mới Thành Công");
        setComboBox();
        fillToTable(spServiceImpl.getListSanPhamChiTiet());
    }//GEN-LAST:event_btn_lamMoiActionPerformed

    private void btn_themThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themThuongHieuActionPerformed
        new thuongHieuJFrame().setVisible(true);

    }//GEN-LAST:event_btn_themThuongHieuActionPerformed

    private void btn_themKieuDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themKieuDangActionPerformed
        new kieuDangJFrame().setVisible(true);
    }//GEN-LAST:event_btn_themKieuDangActionPerformed

    private void btn_themManHinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themManHinhActionPerformed
        new manHinhJFrame().setVisible(true);
    }//GEN-LAST:event_btn_themManHinhActionPerformed

    private void btn_themKichCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themKichCoActionPerformed
        new kichCoJFrame().setVisible(true);
    }//GEN-LAST:event_btn_themKichCoActionPerformed

    private void btn_themDoPhanGiaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themDoPhanGiaiActionPerformed
        new doPhanGiaiJFrame().setVisible(true);
    }//GEN-LAST:event_btn_themDoPhanGiaiActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        sanPhamChiTiet spct = readForm();
        if (spct != null) {
            String ma = txt_ma.getText().trim();
            if (spServiceImpl.checkMaSpct(ma) == false) {
                if (spServiceImpl.addSanPhamChiTiet(spct) > 0) {
                    jlb_thongBao.setText("Thêm thành công");
                    fillToTable(spServiceImpl.getListSanPhamChiTiet());
                } else {
                    jlb_thongBao.setText("Thêm thất bại");
                }
            } else {
                jlb_thongBao.setText("Mã sản phẩm đã tồn tại");
            }
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void cbo_sanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_sanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_sanPhamActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        sanPhamChiTiet spct = readForm();
        if (spct != null) {
            int i = tbl_bang.getSelectedRow();
            if (i == -1) {
                jlb_thongBao.setText("Bạn chưa chọn dòng để sửa");
            } else {
                String ma = txt_ma.getText().trim();
                if (spServiceImpl.updateSpct(ma, spct) > 0) {
                    jlb_thongBao.setText("Sửa thành công");
                    fillToTable(spServiceImpl.getListSanPhamChiTiet());
                } else {
                    jlb_thongBao.setText("Sửa thất bại");
                }
            }
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiemActionPerformed
        String ma = txt_search.getText().toString();
        fillToTable(spServiceImpl.getListSanPhamChiTietByMa(ma));
    }//GEN-LAST:event_btn_timKiemActionPerformed

    private void cbo_trangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_trangThaiActionPerformed
        boolean trangThai;
        if(cbo_trangThai.getSelectedItem().toString().equalsIgnoreCase("Còn Hàng")){
            trangThai = true;
            fillToTable(spServiceImpl.getListSanPhamChiTietOrderByTrangThai(trangThai));
        }
        else{
            trangThai = false;
            fillToTable(spServiceImpl.getListSanPhamChiTietOrderByTrangThai(trangThai));
        }
    }//GEN-LAST:event_cbo_trangThaiActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        i = tbl_bang.getSelectedRow();
        if (i == -1) {
            jlb_thongBao.setText("Bạn chưa chọn dòng để xóa");
        } else {
            int id = Integer.parseInt(tbl_bang.getValueAt(i, 0).toString());
            if (spServiceImpl.deleteSpct(id) > 0) {
                jlb_thongBao.setText("Xóa thành công");
                fillToTable(spServiceImpl.getListSanPhamChiTiet());
            } else {
                jlb_thongBao.setText("Xóa thất bại");
            }
        }
    }//GEN-LAST:event_btn_xoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_lamMoi;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_themDoPhanGiai;
    private javax.swing.JButton btn_themKichCo;
    private javax.swing.JButton btn_themKieuDang;
    private javax.swing.JButton btn_themManHinh;
    private javax.swing.JButton btn_themThuongHieu;
    private javax.swing.JButton btn_timKiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbo_kichCo;
    private javax.swing.JComboBox<String> cbo_kieuDang;
    private javax.swing.JComboBox<String> cbo_manHinh;
    private javax.swing.JComboBox<String> cbo_phanGiai;
    private javax.swing.JComboBox<String> cbo_sanPham;
    private javax.swing.JComboBox<String> cbo_thuongHieu;
    private javax.swing.JComboBox<String> cbo_trangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlb_thongBao;
    private javax.swing.JRadioButton rdo_ConHang;
    private javax.swing.JRadioButton rdo_Cu;
    private javax.swing.JRadioButton rdo_Moi;
    private javax.swing.JRadioButton rdo_hetHang;
    private javax.swing.JTable tbl_bang;
    private javax.swing.JTextField txt_donGia;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_soLuong;
    // End of variables declaration//GEN-END:variables
}
