package qltv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import qltv.model.khachHang;

public class khachHangDAOImpl implements khachHangDAO {

    @Override
    public List<khachHang> getAll() {
        List<khachHang> list = new ArrayList<>();
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT ID, MAKH, TEN, SODIENTHOAI, DIACHI, GIOITINH, NGAYSINH FROM KHACHHANG";
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                khachHang kh = new khachHang();
                kh.setId(rs.getInt(1));
                kh.setMaKH(rs.getString(2));
                kh.setTen(rs.getString(3));
                kh.setSoDienThoai(rs.getString(4));
                kh.setDiaChi(rs.getString(5));
                kh.setGioiTinh(rs.getInt(6));
                kh.setNgaySinh(rs.getString(7));
                list.add(kh);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int them(khachHang kh) {
        String sql = "INSERT INTO KHACHHANG (MAKH, TEN, SODIENTHOAI, DIACHI, GIOITINH, NGAYSINH) VALUES(?,?,?,?,?,?)";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setObject(1, kh.getMaKH());
            ps.setObject(2, kh.getTen());
            ps.setObject(3, kh.getSoDienThoai());
            ps.setObject(4, kh.getDiaChi());
            ps.setObject(5, kh.getGioiTinh());
            ps.setObject(6, kh.getNgaySinh());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int sua(khachHang kh) {
        String sql = "UPDATE KHACHHANG SET TEN = ?, SODIENTHOAI = ?, DIACHI = ?, GIOITINH = ?, NGAYSINH = ? WHERE MAKH = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setObject(1, kh.getTen());
            ps.setObject(2, kh.getSoDienThoai());
            ps.setObject(3, kh.getDiaChi());
            ps.setObject(4, kh.getGioiTinh());
            ps.setObject(5, kh.getNgaySinh());
            ps.setObject(6, kh.getMaKH());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<khachHang> timKiem(String input, String searchtype) {
        List<khachHang> list = new ArrayList<>();
        String query = null;
        Connection conn = DBConnect.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if (searchtype.equalsIgnoreCase("Mã")) {
                query = "SELECT MAKH, TEN, SODIENTHOAI, DIACHI, GIOITINH, NGAYSINH FROM KHACHHANG WHERE MAKH LIKE ? ";
                ps = conn.prepareStatement(query);
                ps.setString(1, "%" + input + "%");
            } else if (searchtype.equalsIgnoreCase("Tên")) {
                query = "SELECT MAKH, TEN, SODIENTHOAI, DIACHI, GIOITINH, NGAYSINH FROM KHACHHANG WHERE TEN LIKE ? ";
                ps = conn.prepareStatement(query);
                ps.setString(1, "%" + input + "%");
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                khachHang kh = new khachHang();
                kh.setMaKH(rs.getString(1));
                kh.setTen(rs.getString(2));
                kh.setSoDienThoai(rs.getString(3));
                kh.setDiaChi(rs.getString(4));
                kh.setGioiTinh(rs.getInt(5));
                kh.setNgaySinh(rs.getString(6));
                list.add(kh);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
        }

        return list;
    }

}
