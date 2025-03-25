package qltv.view;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import qltv.dao.HDCTService;
import qltv.dao.SanPhamCTService;
import qltv.model.ChiTietSP_Model;
import qltv.dao.HoaDonService;
import qltv.model.HoaDonChiTiet_Model;
import qltv.model.hoaDon;
import qltv.model.hoaDonChiTiet;
import qltv.model.phieuGiamGia;
import qltv.model.sanPhamChiTiet;
import qltv.service.giamGiaService;

public final class banHangJPanel extends javax.swing.JPanel {

    HoaDonService HoaDonRespository;
    SanPhamCTService SanPhamCTRespos;
    HDCTService HoaDonChiTietResponsitory;

    DefaultTableModel dtmHoaDon;
    DefaultTableModel dtmGioHang;
    DefaultTableModel dtmSanPham;

    private giamGiaService giamGiaService = new giamGiaService();
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

    public banHangJPanel() {
        initComponents();
        SanPhamCTRespos = new SanPhamCTService();
        HoaDonRespository = new HoaDonService();
        HoaDonChiTietResponsitory = new HDCTService();
        dtmHoaDon = (DefaultTableModel) tblHoaDon.getModel();
        dtmGioHang = (DefaultTableModel) tblGioHang.getModel();
        dtmSanPham = (DefaultTableModel) tblSanPham.getModel();
        showTableSanPhamCT(SanPhamCTRespos.getAllSPCT());
        showTableHoaDon(HoaDonRespository.getAllHDChuaThanhToan());
        setPhieuGiamGia();

    }

    void setPhieuGiamGia() {
        cboGiamGia.removeAllItems();
        cboGiamGia.addItem("Chọn giảm giá");
        for (phieuGiamGia pgg : giamGiaService.getMa()) {
            cboGiamGia.addItem(pgg.getMaPhieu());
        }
    }

    private void updateTien() {
        int tongTien = 0;
        for (int i = 0; i < tblGioHang.getRowCount(); i++) {
            try {
                int soLuong = Integer.parseInt(tblGioHang.getValueAt(i, 2).toString());
                int donGia = Integer.parseInt(tblGioHang.getValueAt(i, 3).toString());
                tongTien += soLuong * donGia;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Lỗi khi tính tổng tiền sản phẩm.");
                e.printStackTrace();
                return;
            }
        }

        // Định dạng tiền tệ VND
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        lbl_TongTien.setText(currencyFormat.format(tongTien));

        if (tongTien > 0) {
            int giamGia = giamGiaService.getPhanTram(cboGiamGia.getSelectedItem().toString());
            lbl_PhanTram.setText(String.valueOf(giamGia));

            int tongTienSauGiamGia = tongTien - tongTien * giamGia / 100;
            lbl_TienSauGiam.setText(currencyFormat.format(tongTienSauGiamGia));

            String tienKhachDuaStr = txtKDua.getText().trim();
            if (tienKhachDuaStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số tiền khách đưa.");
                return;
            }

            // Kiểm tra xem chuỗi có phải là một số hợp lệ hay không
            if (!tienKhachDuaStr.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Số tiền khách đưa không hợp lệ. Vui lòng nhập lại.");
                return;
            }

            long tienKhachDua;
            try {
                tienKhachDua = Long.parseLong(tienKhachDuaStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Số tiền khách đưa không hợp lệ.");
                e.printStackTrace();
                return;
            }

            long tienTraKhach = tienKhachDua - tongTienSauGiamGia;
            lbl_TraKhach.setText(currencyFormat.format(tienTraKhach));
        }
    }

    public void showTableHoaDon(ArrayList<hoaDon> danhSach) {
        dtmHoaDon.setRowCount(0);
        for (hoaDon hd : danhSach) {
            String trangThai = hd.getTrangThai() == 1 ? "Đã thanh toán" : "Chưa thanh toán";
            dtmHoaDon.addRow(new Object[]{
                hd.getId(),
                hd.getTen(),
                hd.getSdt(),
                trangThai,
                hd.getNgay()
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
                hdct.getTongTien(),});
        }
    }

    public void showTableSanPhamCT(ArrayList<ChiTietSP_Model> danhSach) {
        dtmSanPham.setRowCount(0);
        for (ChiTietSP_Model ctsp : danhSach) {
            dtmSanPham.addRow(new Object[]{
                ctsp.getId(),
                ctsp.getTenSanPham(),
                ctsp.getDonGia(),
                ctsp.getDoPhanGiai(),
                ctsp.getKichCo(),
                ctsp.getThuongHieu(),
                ctsp.getSoLuongTon(),});
        }
    }

    private void generateInvoicePDF(int idHoaDon, int tongTien, long tienKhachDua, long tienThua) {
        Document document = new Document();
        try {
            // Đường dẫn nơi lưu trữ file PDF
            String filePath = "C:\\Users\\tuann\\Workspace\\FPT Polytechnic\\PRO1041\\HOADON\\" + idHoaDon + ".pdf";

            // Tạo thư mục nếu chưa tồn tại
            File directory = new File("C:\\Users\\tuann\\Workspace\\FPT Polytechnic\\PRO1041\\HOADON\\");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String fontPath = "src/main/resources/fonts/times.ttf"; // Đảm bảo đường dẫn chính xác

            // Tạo font hỗ trợ Unicode
            BaseFont bf = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(bf, 12);

            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Định dạng tiền tệ VNĐ
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

            // Lấy thời gian hiện tại
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String formattedDateTime = now.format(formatter);

            // Tiêu đề hóa đơn
            Paragraph title = new Paragraph("HÓA ĐƠN BÁN HÀNG", new Font(bf, 16, Font.BOLD));
            title.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(title);

            // Thêm khoảng trắng giữa tiêu đề và nội dung
            document.add(new Paragraph("\n", font));

            // Thêm thông tin hóa đơn vào tài liệu PDF
            PdfPTable infoTable = new PdfPTable(2);
            infoTable.setWidthPercentage(100);

            addTableCell(infoTable, "ID Hóa Đơn:", font);
            addTableCell(infoTable, String.valueOf(idHoaDon), font);

            addTableCell(infoTable, "Tên Khách Hàng:", font);
            addTableCell(infoTable, txtTen.getText(), font);

            addTableCell(infoTable, "Số Điện Thoại:", font);
            addTableCell(infoTable, txtSDT.getText(), font);

            addTableCell(infoTable, "Thời Gian Thanh Toán:", font);
            addTableCell(infoTable, formattedDateTime, font);

            addTableCell(infoTable, "Tổng Tiền:", font);
            addTableCell(infoTable, currencyFormat.format(tongTien), font);

            addTableCell(infoTable, "Mã Giảm Giá:", font);
            addTableCell(infoTable, cboGiamGia.getSelectedItem().toString(), font);

            addTableCell(infoTable, "Phần Trăm Giảm Giá:", font);
            addTableCell(infoTable, lbl_PhanTram.getText(), font);

            addTableCell(infoTable, "Tiền Sau Giảm Giá:", font);
            addTableCell(infoTable, lbl_TienSauGiam.getText(), font);

            addTableCell(infoTable, "Tiền Khách Đưa:", font);
            addTableCell(infoTable, currencyFormat.format(tienKhachDua), font);

            addTableCell(infoTable, "Tiền Thừa:", font);
            addTableCell(infoTable, currencyFormat.format(tienThua), font);

            document.add(infoTable);

            // Thêm khoảng trắng giữa thông tin hóa đơn và chi tiết sản phẩm
            document.add(new Paragraph("\n", font));

            // Thêm tiêu đề chi tiết sản phẩm
            Paragraph productTitle = new Paragraph("Chi Tiết Sản Phẩm:", new Font(bf, 14, Font.BOLD));
            document.add(productTitle);

            // Thêm chi tiết sản phẩm từ bảng tblGioHang
            PdfPTable productTable = new PdfPTable(4);
            productTable.setWidthPercentage(100);
            productTable.setSpacingBefore(10f);

            // Thêm tiêu đề cho bảng sản phẩm
            addTableHeader(productTable, "ID Sản Phẩm", font);
            addTableHeader(productTable, "Tên Sản Phẩm", font);
            addTableHeader(productTable, "Số Lượng", font);
            addTableHeader(productTable, "Đơn Giá", font);

            for (int i = 0; i < tblGioHang.getRowCount(); i++) {
                addTableCell(productTable, tblGioHang.getValueAt(i, 0).toString(), font);
                addTableCell(productTable, tblGioHang.getValueAt(i, 1).toString(), font);
                addTableCell(productTable, tblGioHang.getValueAt(i, 2).toString(), font);
                addTableCell(productTable, currencyFormat.format(Integer.parseInt(tblGioHang.getValueAt(i, 3).toString())), font);
            }

            document.add(productTable);

            document.close();
            JOptionPane.showMessageDialog(null, "Hóa đơn đã được in ra file PDF tại " + filePath);
        } catch (DocumentException | IOException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi in hóa đơn.");
            e.printStackTrace(); // In ra lỗi để dễ dàng theo dõi
        }
    }

    private void addTableCell(PdfPTable table, String content, Font font) {
        PdfPCell cell = new PdfPCell(new Paragraph(content, font));
        cell.setBorder(PdfPCell.NO_BORDER);
        table.addCell(cell);
    }

    private void addTableHeader(PdfPTable table, String header, Font font) {
        PdfPCell headerCell = new PdfPCell(new Paragraph(header, font));
        headerCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.addCell(headerCell);
    }

    public void setCustomerInfo(String tenKhachHang, String soDienThoai) {
        txtTen.setText(tenKhachHang);
        txtSDT.setText(soDienThoai);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        btnXoaSp = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        cboGiamGia = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        txtKDua = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbl_PhanTram = new javax.swing.JLabel();
        lbl_TraKhach = new javax.swing.JLabel();
        lbl_TongTien = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbl_TienSauGiam = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        btnChon = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnTaoHoaDon = new javax.swing.JButton();

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID sản phẩm", "Tên sản phẩm", "Đơn giá", "Độ phân giải", "Kích cỡ", "Thương hiệu", "Số lượng tồn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSanPham);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Tìm kiếm sản phẩm");

        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Danh sách sản phẩm");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 862, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(11, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên sản phẩm", "Số lượng", "Đơn giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblGioHang);

        btnXoaSp.setText("Xóa sản phẩm");
        btnXoaSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSpActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Giỏ hàng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoaSp)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoaSp)
                .addGap(12, 12, 12))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cboGiamGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGiamGiaActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Phần trăm :");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Giảm giá:");

        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        txtKDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKDuaKeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Tiền thừa :");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Tổng tiền :");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("Tiền khách đưa :");

        lbl_PhanTram.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_PhanTram.setForeground(new java.awt.Color(255, 0, 0));

        lbl_TraKhach.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_TraKhach.setForeground(new java.awt.Color(255, 0, 0));

        lbl_TongTien.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_TongTien.setForeground(new java.awt.Color(255, 0, 0));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("Tiền sau giảm giá :");

        lbl_TienSauGiam.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_TienSauGiam.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_TraKhach)
                                    .addComponent(lbl_TienSauGiam)
                                    .addComponent(lbl_PhanTram)
                                    .addComponent(cboGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(24, 24, 24))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14))
                                        .addGap(56, 56, 56)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_TongTien)
                                    .addComponent(txtKDua, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnThanhToan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_TongTien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKDua, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_PhanTram))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_TienSauGiam))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_TraKhach))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThanhToan)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Tên khách hàng");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Số điện thoại");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        btnXoa.setText("Xóa hóa đơn");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnChon.setText("Chọn");
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoa)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnXoa)
                        .addComponent(btnChon))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID hóa đơn", "Tên khách hàng", "Số điện thoại", "Trạng thái", "Ngày tạo"
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Hóa đơn");

        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(btnTaoHoaDon)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaoHoaDon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(33, 33, 33)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        int soLuongSanPham = 0;
        try {
            soLuongSanPham = Integer.parseInt(JOptionPane.showInputDialog("Mời nhập số lượng sản phẩm: "));
            if (soLuongSanPham <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0.");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là một số hợp lệ.");
            return;
        }

        int selectedHoaDonRow = tblHoaDon.getSelectedRow();
        if (selectedHoaDonRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hóa đơn.");
            return;
        }

        int idHoaDon = Integer.parseInt(tblHoaDon.getValueAt(selectedHoaDonRow, 0).toString());

        int selectedSanPhamRow = tblSanPham.getSelectedRow();
        if (selectedSanPhamRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm.");
            return;
        }

        int idSPCT = Integer.parseInt(tblSanPham.getValueAt(selectedSanPhamRow, 0).toString());
        int giaBan = Integer.parseInt(tblSanPham.getValueAt(selectedSanPhamRow, 2).toString());
        int soLuongTon = Integer.parseInt(tblSanPham.getValueAt(selectedSanPhamRow, 6).toString());

        if (soLuongSanPham > soLuongTon) {
            JOptionPane.showMessageDialog(this, "Số lượng yêu cầu vượt quá số lượng tồn kho.");
            return;
        }

        ArrayList<HoaDonChiTiet_Model> listHDCT = HoaDonChiTietResponsitory.getALLByIdHoaDon(idHoaDon);
        boolean isExist = false;

        for (HoaDonChiTiet_Model hdctResponse : listHDCT) {
            if (hdctResponse.getId_spct() == idSPCT) {
                int tangSl = hdctResponse.getSoLuong() + soLuongSanPham;
                int giaMoi = tangSl * giaBan;

                hoaDonChiTiet hdct = new hoaDonChiTiet();
                hdct.setId(hdctResponse.getId());
                hdct.setSoLuong(tangSl);
                hdct.setDonGia(giaBan);

                HoaDonChiTietResponsitory.updateHDCT(hdct);

                sanPhamChiTiet ctsp = new sanPhamChiTiet();
                ctsp.setId(idSPCT);
                ctsp.setSoLuong(soLuongTon - soLuongSanPham);
                SanPhamCTRespos.updateSoLuongByIDCTSP(ctsp);

                isExist = true;
                break;
            }
        }

        if (!isExist) {
            hoaDonChiTiet hdct = new hoaDonChiTiet();
            hdct.setId_hd(idHoaDon);
            hdct.setId_spct(idSPCT);
            hdct.setSoLuong(soLuongSanPham);
            hdct.setDonGia(giaBan);

            HoaDonChiTietResponsitory.addHDCT(hdct);

            sanPhamChiTiet ctsp = new sanPhamChiTiet();
            ctsp.setId(idSPCT);
            ctsp.setSoLuong(soLuongTon - soLuongSanPham);
            SanPhamCTRespos.updateSoLuongByIDCTSP(ctsp);

            int tongTienHienTai = HoaDonChiTietResponsitory.getTongTienByIdHoaDon(idHoaDon);

            // Định dạng tiền tệ VND
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
            lbl_TongTien.setText(currencyFormat.format(tongTienHienTai));
        }

        showTableSanPhamCT(SanPhamCTRespos.getAllSPCT());
        showTableHoaDonChiTiet(HoaDonChiTietResponsitory.getALLByIdHoaDon(idHoaDon));
        showTableHoaDonChiTiet(HoaDonChiTietResponsitory.getALLByIdHoaDon(idHoaDon));
        updateTien();
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String tim = txtTimKiem.getText();

        if (!tim.isEmpty()) {
            ArrayList<ChiTietSP_Model> result = SanPhamCTRespos.timKiem(tim);

            if (!result.isEmpty()) {
                showTableSanPhamCT(result);
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ô tìm kiếm đang trống");
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnXoaSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSpActionPerformed

        if (tblGioHang.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm từ bảng giỏ hàng.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc chắn muốn xóa sản phẩm này không?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        int selectedRow = tblGioHang.getSelectedRow();
        int idHoaDon = Integer.parseInt(tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 0).toString());
        int idSanPhamCT = Integer.parseInt(tblGioHang.getValueAt(selectedRow, 0).toString());
        int soLuong = Integer.parseInt(tblGioHang.getValueAt(selectedRow, 2).toString());

        HoaDonChiTietResponsitory.deleteHDCT(idSanPhamCT, idHoaDon);

        int soLuongTon = SanPhamCTRespos.getSoLuongByID(idSanPhamCT);
        sanPhamChiTiet ctsp = new sanPhamChiTiet();
        ctsp.setId(idSanPhamCT);
        ctsp.setSoLuong(soLuongTon + soLuong);
        SanPhamCTRespos.updateSoLuongByIDCTSP(ctsp);

        DefaultTableModel modelGioHang = (DefaultTableModel) tblGioHang.getModel();
        modelGioHang.removeRow(selectedRow);

        int rowCount = tblGioHang.getRowCount();
        int tongTienMoi = 0;

        updateTien();

        showTableSanPhamCT(SanPhamCTRespos.getAllSPCT());
        showTableHoaDonChiTiet(HoaDonChiTietResponsitory.getALLByIdHoaDon(idHoaDon));
    }//GEN-LAST:event_btnXoaSpActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        int selectedHoaDonRow = tblHoaDon.getSelectedRow();
        if (selectedHoaDonRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hóa đơn.");
            return;
        }

        // Tính tổng tiền của giỏ hàng
        int tongTien = 0;
        for (int i = 0; i < tblGioHang.getRowCount(); i++) {
            try {
                // Lấy số lượng và đơn giá để tính tổng tiền cho từng sản phẩm
                int soLuong = Integer.parseInt(tblGioHang.getValueAt(i, 2).toString());
                int donGia = Integer.parseInt(tblGioHang.getValueAt(i, 3).toString());
                tongTien += soLuong * donGia;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Lỗi khi tính tổng tiền sản phẩm.");
                e.printStackTrace();
                return;
            }
        }

        // Định dạng tiền tệ VND
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

        // Lấy thông tin phiếu giảm giá từ combo box
        int giamGia = giamGiaService.getPhanTram(cboGiamGia.getSelectedItem().toString());

        // Tính tổng tiền sau khi áp dụng giảm giá
        int tongTienSauGiamGia = tongTien - tongTien * giamGia / 100;
        lbl_TienSauGiam.setText(currencyFormat.format(tongTienSauGiamGia));

        // Lấy số tiền khách đưa từ form
        String tienKhachDuaStr = txtKDua.getText().trim();
        if (tienKhachDuaStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số tiền khách đưa.");
            return;
        }

        // Chuyển đổi số tiền khách đưa sang kiểu long
        long tienKhachDua;
        try {
            tienKhachDua = Long.parseLong(tienKhachDuaStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số tiền khách đưa không hợp lệ.");
            e.printStackTrace();
            return;
        }

        // Kiểm tra xem số tiền khách đưa có đủ không
        if (tienKhachDua < tongTienSauGiamGia) {
            JOptionPane.showMessageDialog(this, "Số tiền khách đưa không đủ để thanh toán.");
            return;
        }

        // Tính tiền thừa trả lại cho khách
        long tienTraKhach = tienKhachDua - tongTienSauGiamGia;
        lbl_TraKhach.setText(currencyFormat.format(tienTraKhach));

        // Lấy ID hóa đơn từ dòng được chọn
        int idHoaDon = Integer.parseInt(tblHoaDon.getValueAt(selectedHoaDonRow, 0).toString());

        // Khởi tạo đối tượng hóa đơn và cập nhật thông tin
        hoaDon hd = new hoaDon();
        hd.setTongTien((int) tongTienSauGiamGia);
        hd.setId(idHoaDon);

        // Xử lý thanh toán hóa đơn
        try {
            HoaDonRespository.thanhToan(hd);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi thực hiện thanh toán.");
            e.printStackTrace();
            return;
        }

        // Thông báo hoàn tất thanh toán
        JOptionPane.showMessageDialog(this, "Thanh toán thành công!");

        // Hỏi người dùng có muốn in hóa đơn không
        int response = JOptionPane.showConfirmDialog(this, "Bạn có muốn in hóa đơn không?", "In hóa đơn", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            try {
                // Gọi hàm tạo và in hóa đơn PDF
                generateInvoicePDF(idHoaDon, tongTien, tienKhachDua, tienTraKhach);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi khi in hóa đơn.");
                e.printStackTrace();
            }
        }

        // Xóa tất cả các dòng trong giỏ hàng sau khi thanh toán
        dtmGioHang.setRowCount(0);

        // Đặt lại các trường thông tin sau khi thanh toán
        lbl_TongTien.setText(currencyFormat.format(0));
        txtKDua.setText("");
        lbl_TraKhach.setText(currencyFormat.format(0));
        txtTen.setText("");
        txtSDT.setText("");
        lbl_TienSauGiam.setText(currencyFormat.format(0));
        lbl_PhanTram.setText("0");

        // Hiển thị lại bảng hóa đơn chưa thanh toán
        showTableHoaDon(HoaDonRespository.getAllHDChuaThanhToan());
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblHoaDon.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hóa đơn để xóa.");
            return;
        }
        int idHoaDon = Integer.parseInt(tblHoaDon.getValueAt(selectedRow, 0).toString());
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa hóa đơn này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            HoaDonRespository.deleteHoaDon(idHoaDon);
            showTableHoaDon(HoaDonRespository.getAllHDChuaThanhToan());
            dtmGioHang.setRowCount(0);
            lbl_TongTien.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        int idSanPhamCT = Integer.parseInt(tblGioHang.getValueAt(selectedRow, 0).toString());
        int soLuong = Integer.parseInt(tblGioHang.getValueAt(selectedRow, 2).toString());

        HoaDonChiTietResponsitory.deleteHDCT(idSanPhamCT, idHoaDon);

        int soLuongTon = SanPhamCTRespos.getSoLuongByID(idSanPhamCT);
        sanPhamChiTiet ctsp = new sanPhamChiTiet();
        ctsp.setId(idSanPhamCT);
        ctsp.setSoLuong(soLuongTon + soLuong);
        SanPhamCTRespos.updateSoLuongByIDCTSP(ctsp);

        DefaultTableModel modelGioHang = (DefaultTableModel) tblGioHang.getModel();
        modelGioHang.removeRow(selectedRow);

        int rowCount = tblGioHang.getRowCount();
        showTableSanPhamCT(SanPhamCTRespos.getAllSPCT());
        showTableHoaDonChiTiet(HoaDonChiTietResponsitory.getALLByIdHoaDon(idHoaDon));
        txtTen.setText("0");
        txtSDT.setText("0");
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        // TODO add your handling code here:
        //new banKhachHangJPanel(this).setVisible(true);
        new banHangKhachJFrame(this).setVisible(true);
    }//GEN-LAST:event_btnChonActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblHoaDon.getSelectedRow();
        if (selectedRow != -1) {
            int idHoaDon = Integer.parseInt(tblHoaDon.getValueAt(selectedRow, 0).toString());
            showTableHoaDonChiTiet(HoaDonChiTietResponsitory.getALLByIdHoaDon(idHoaDon));
            HoaDonService hoaDonService = new HoaDonService();

            ArrayList<hoaDon> danhSachHoaDon = hoaDonService.getAllHD();

            hoaDon hoaDon = null;
            for (hoaDon hd : danhSachHoaDon) {
                if (hd.getId() == idHoaDon) {
                    hoaDon = hd;
                    break;
                }
            }
            if (hoaDon != null) {
                txtTen.setText(hoaDon.getTen());
                txtSDT.setText(hoaDon.getSdt());
            }
            int tongTienHienTai = HoaDonChiTietResponsitory.getTongTienByIdHoaDon(idHoaDon);
            lbl_TongTien.setText(String.valueOf(tongTienHienTai));
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hóa đơn.");
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        // TODO add your handling code here:
        try {
            String ten = txtTen.getText().trim();
            String soDT = txtSDT.getText().trim();

            if (ten.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tên khách hàng không được để trống.");
                return;
            }
            if (!soDT.isEmpty() && !ktraSDT(soDT)) {
                JOptionPane.showMessageDialog(this, "Số điện thoại phải gồm 10 chữ số.");
                return;
            }
            HoaDonRespository.taoHoaDon(ten, soDT);

            showTableHoaDon(HoaDonRespository.getAllHDChuaThanhToan());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void txtKDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKDuaKeyReleased
        updateTien();
    }//GEN-LAST:event_txtKDuaKeyReleased

    private void cboGiamGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGiamGiaActionPerformed
        updateTien();
    }//GEN-LAST:event_cboGiamGiaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChon;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaSp;
    private javax.swing.JComboBox<String> cboGiamGia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_PhanTram;
    private javax.swing.JLabel lbl_TienSauGiam;
    private javax.swing.JLabel lbl_TongTien;
    private javax.swing.JLabel lbl_TraKhach;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtKDua;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
    private boolean ktraSDT(String sdt) {
        String regex = "\\d{10}";
        return sdt.matches(regex);
    }
}
