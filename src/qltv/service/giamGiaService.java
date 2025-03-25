package qltv.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import qltv.dao.DBConnect;
import qltv.model.phieuGiamGia;


public class giamGiaService {
     private Connection conn = DBConnect.getConnection();
     
     public giamGiaService(){
         DBConnect.getConnection();
     }
     
     public ArrayList<phieuGiamGia> getAll(String order) throws SQLException {
        ArrayList<phieuGiamGia> phieuGiamGiaList = new ArrayList<>();
        String query = "SELECT * FROM PHIEUGIAMGIA ORDER BY " +order;
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                phieuGiamGia phieuGiamGia = new phieuGiamGia(
                        rs.getString("MAPHIEU"),
                        rs.getInt("ID_HD"),
                        rs.getInt("PHANTRAM"),
                        rs.getString("NGAYTAO"),
                        rs.getString("NGAYHETHAN"),
                        rs.getInt("TRANGTHAI")
                );
                phieuGiamGiaList.add(phieuGiamGia);
            }
        }
        return phieuGiamGiaList;
    }
     
     public int them(phieuGiamGia phieu) throws SQLException{
        String sql = "INSERT INTO PHIEUGIAMGIA (MAPHIEU, ID_HD, PHANTRAM, NGAYTAO, NGAYHETHAN, TRANGTHAI) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, phieu.getMaPhieu());
        ps.setInt(2, phieu.getIdHd());
        ps.setInt(3, phieu.getPhanTram());
        ps.setString(4, phieu.getNgayTao());
        ps.setString(5, phieu.getNgayHetHan());
        ps.setInt(6, phieu.getTrangThai());
        return ps.executeUpdate();
     }
     
     public int sua(phieuGiamGia phieu) {       
        try {
            String sql = "UPDATE PHIEUGIAMGIA SET ID_HD = ?, PHANTRAM = ?, NGAYTAO = ?, NGAYHETHAN = ?, TRANGTHAI = ? WHERE MAPHIEU = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, phieu.getIdHd());
            ps.setInt(2, phieu.getPhanTram());
            ps.setString(3, phieu.getNgayTao());
            ps.setString(4, phieu.getNgayHetHan());
            ps.setInt(5, phieu.getTrangThai());
            ps.setString(6, phieu.getMaPhieu());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
     public int huy(phieuGiamGia phieu) {       
        try {
             String sql = "UPDATE PHIEUGIAMGIA SET TRANGTHAI = ? WHERE MAPHIEU = ?";
            
            PreparedStatement ps = conn.prepareStatement(sql);     
            ps.setObject(1, 3);
            ps.setObject(2, phieu.getMaPhieu());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
     
    public ArrayList<phieuGiamGia> timKiem(int trangThai, String input, String order) throws SQLException {
        ArrayList<phieuGiamGia> list = new ArrayList<>();
        String query = null;        
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (trangThai == -1) {
            query = "select MAPHIEU, TEN, LOAIGIAMGIA, MUCGIAM, GIAMTOIDA, DONTOITHIEU, NGAYBATDAU, NGAYHETHAN, TRANGTHAI from PHIEUGIAMGIA where MAPHIEU LIKE ? ORDER BY " + order;
            ps = conn.prepareStatement(query); 
            ps.setString(1, "%" + input + "%");
        }
        else {
            query = "select MAPHIEU, TEN, LOAIGIAMGIA, MUCGIAM, GIAMTOIDA, DONTOITHIEU, NGAYBATDAU, NGAYHETHAN, TRANGTHAI from PHIEUGIAMGIA where TRANGTHAI = ? AND MAPHIEU LIKE ? ORDER BY " + order;
            ps = conn.prepareStatement(query);   
            ps.setInt(1, trangThai);
            ps.setString(2, "%" + input + "%");
        }
        
        rs = ps.executeQuery();                 
        while (rs.next()) {
            phieuGiamGia phieu = new phieuGiamGia();
            phieu.setMaPhieu(rs.getString(1));
            phieu.setIdHd(rs.getInt(2));
            phieu.setPhanTram(rs.getInt(3));
            phieu.setNgayTao(rs.getString(4));
            phieu.setNgayHetHan(rs.getString(5));
            phieu.setTrangThai(rs.getInt(6));
            list.add(phieu);
        }
            rs.close();
            ps.close();
               
        return list;
    }
    
    public ArrayList<phieuGiamGia> loc(int trangThai, String order) throws SQLException {
        ArrayList<phieuGiamGia> list = new ArrayList<>();
        String query = null;        
        PreparedStatement ps = null;
        ResultSet rs = null;
        query = "select MAPHIEU, ID_HD, PHANTRAM, NGAYTAO, NGAYHETHAN, TRANGTHAI from PHIEUGIAMGIA where TRANGTHAI = ? ORDER BY " + order;
        ps = conn.prepareStatement(query);          
        ps.setInt(1, trangThai);            
        rs = ps.executeQuery();                 
        while (rs.next()) {
            phieuGiamGia phieu = new phieuGiamGia();
            phieu.setMaPhieu(rs.getString(1));
            phieu.setIdHd(rs.getInt(2));
            phieu.setPhanTram(rs.getInt(3));
            phieu.setNgayTao(rs.getString(4));
            phieu.setNgayHetHan(rs.getString(5));
            phieu.setTrangThai(rs.getInt(6));
            list.add(phieu);
        }
            rs.close();
            ps.close();
               
        return list;
    }
    
    
    
    public void updateTrangThai() {
        String sql = "UPDATE PHIEUGIAMGIA SET TRANGTHAI = CASE " +
                "WHEN TRANGTHAI = 3 THEN 3 " +
                "WHEN NGAYTAO > CAST(GETDATE() AS DATE) THEN 0 " +
                "WHEN NGAYHETHAN < CAST(GETDATE() AS DATE) THEN 2 " +
                "ELSE 1 " +
                "END";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            int x = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<phieuGiamGia> getMa(){
        List<phieuGiamGia> list = new ArrayList<>();
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "select * from PHIEUGIAMGIA Where TRANGTHAI = 1";
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                phieuGiamGia pgg = new phieuGiamGia();
                pgg.setMaPhieu(rs.getString(1));
                list.add(pgg);
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
    
    public int getPhanTram(String ma) {
        String sql = "select PHANTRAM from PHIEUGIAMGIA Where MAPHIEU = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("PHANTRAM");
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
