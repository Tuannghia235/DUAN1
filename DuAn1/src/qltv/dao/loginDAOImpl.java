package qltv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import qltv.model.nhanVien;

public class loginDAOImpl implements loginDAO {

    @Override
    public boolean checkMa(String ma) {
        String sql = "SELECT * from NHANVIEN where MANV = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            boolean exists = rs.next();
            rs.close();
            ps.close();
            cons.close();
            return exists;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean checkPass(String pass, String ma) {
        String sql = "SELECT * from NHANVIEN where PASS = ? and MANV = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setString(2, ma);
            ResultSet rs = ps.executeQuery();
            boolean exists = rs.next();
            rs.close();
            ps.close();
            cons.close();
            return exists;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int addAccount(nhanVien nv) {
        String sql = "INSERT INTO NHANVIEN(MANV,TEN,SODIENTHOAI,PASS) VALUES(?,?,?,?)";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.getSoDienThoai());
            ps.setObject(4, nv.getPass());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public String getMatKhau(String ma, int so) {
        String sql = "SELECT PASS FROM NHANVIEN WHERE MANV = ? AND SODIENTHOAI = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setObject(1, ma);
            ps.setObject(2, so);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("PASS");
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
