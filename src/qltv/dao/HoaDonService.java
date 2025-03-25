package qltv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import qltv.model.hoaDon;
import qltv.model.khachHang;

public class HoaDonService {

    public ArrayList<hoaDon> getAllHDChuaThanhToan() {
        String sql = """
                 SELECT ID, MAHD, ID_KH, ID_NV, ID_THANHTOAN, TEN, SODIENTHOAI, NGAY, TONGTIEN, TRANGTHAI 
                 FROM HOADON WHERE TRANGTHAI = 0;
                 """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ArrayList<hoaDon> danhSach = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                danhSach.add(
                        new hoaDon(
                                rs.getInt("ID"),
                                rs.getString("MAHD"),
                                rs.getInt("ID_KH"),
                                rs.getInt("ID_NV"),
                                rs.getInt("ID_THANHTOAN"),
                                rs.getString("TEN"),
                                rs.getString("SODIENTHOAI"),
                                rs.getString("NGAY"),
                                rs.getInt("TONGTIEN"),
                                rs.getInt("TRANGTHAI")
                        ));
            }
            return danhSach;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<hoaDon> getAllHD() {
        String sql = """
                 SELECT ID, MAHD, ID_KH, ID_NV, ID_THANHTOAN, TEN, SODIENTHOAI, NGAY, TONGTIEN, TRANGTHAI 
                 FROM HOADON;
                 """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ArrayList<hoaDon> danhSach = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                danhSach.add(
                        new hoaDon(
                                rs.getInt("ID"),
                                rs.getString("MAHD"),
                                rs.getInt("ID_KH"),
                                rs.getInt("ID_NV"),
                                rs.getInt("ID_THANHTOAN"),
                                rs.getString("TEN"),
                                rs.getString("SODIENTHOAI"),
                                rs.getString("NGAY"),
                                rs.getInt("TONGTIEN"),
                                rs.getInt("TRANGTHAI")
                        ));
            }
            return danhSach;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<hoaDon> timHD(String input) {
        String sql = " SELECT ID, MAHD, ID_KH, ID_NV, ID_THANHTOAN, TEN, SODIENTHOAI, NGAY, TONGTIEN, TRANGTHAI FROM HOADON WHERE ID LIKE " + input;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ArrayList<hoaDon> danhSach = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                danhSach.add(
                        new hoaDon(
                                rs.getInt("ID"),
                                rs.getString("MAHD"),
                                rs.getInt("ID_KH"),
                                rs.getInt("ID_NV"),
                                rs.getInt("ID_THANHTOAN"),
                                rs.getString("TEN"),
                                rs.getString("SODIENTHOAI"),
                                rs.getString("NGAY"),
                                rs.getInt("TONGTIEN"),
                                rs.getInt("TRANGTHAI")
                        ));
            }
            return danhSach;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void taoHoaDon(String ten, String sdt) {
        String sql = "INSERT INTO HOADON(TEN, SODIENTHOAI, TRANGTHAI, NGAY) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ten);
            ps.setString(2, sdt);
            ps.setInt(3, 0);
            LocalDate thoiDiemHT = LocalDate.now();
            ps.setString(4, thoiDiemHT.toString());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void suaHoaDon(int id, String ten, String sdt, String ngay) {
        String sql = "UPDATE HOADON SET TEN = ?, SODIENTHOAI = ?, NGAY = ? WHERE ID = ?";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ten);
            ps.setString(2, sdt);
            ps.setString(3, ngay);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void thanhToan(hoaDon hd) {
        String sql = """
                 UPDATE HOADON SET TRANGTHAI = 1,
                 TONGTIEN = ?
                 WHERE ID = ?
                 """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, hd.getTongTien());
            ps.setInt(2, hd.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteHoaDon(int id) {
        String sql = "DELETE FROM HOADON WHERE ID = ?";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<khachHang> getAllKhachHang() {
        String sql = """
                     SELECT TEN, SODIENTHOAI, DIACHI, GIOITINH, NGAYSINH FROM KHACHHANG""";

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ArrayList<khachHang> danhSach = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                danhSach.add(
                        new khachHang(
                                rs.getString("TEN"),
                                rs.getString("SODIENTHOAI"),
                                rs.getString("DIACHI"),
                                rs.getInt("GIOITINH"),
                                rs.getString("NGAYSINH")
                        ));
            }
            return danhSach;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Integer> getPhanTram() {
        List<Integer> phanTramGiamGiaList = new ArrayList<>();
        String sql = "SELECT DISTINCT PHANTRAM FROM PHIEUGIAMGIA WHERE TRANGTHAI = 2";

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                phanTramGiamGiaList.add(rs.getInt("PHANTRAM"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return phanTramGiamGiaList;
    }
}
