package qltv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ArrayList;
import qltv.model.ChiTietSP_Model;
import qltv.model.sanPhamChiTiet;

public class SanPhamCTService {

    public ArrayList<ChiTietSP_Model> getAllSPCT() {
        String sql = """
                     SELECT ctsp.ID, sp.TEN, ctsp.DONGIA, dpg.TEN, kc.Inch, th.TEN, ctsp.SOLUONG
                     FROM SANPHAMCHITIET ctsp
                     JOIN SANPHAM sp ON ctsp.ID_SP = sp.ID
                     JOIN DOPHANGIAI dpg ON ctsp.ID_PHANGIAI = dpg.ID
                     JOIN KICHCO kc ON ctsp.ID_KICHCO = kc.ID
                     JOIN THUONGHIEU th ON ctsp.ID_THUONGHIEU = th.ID
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ArrayList<ChiTietSP_Model> danhSach = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                danhSach.add(new ChiTietSP_Model(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7)
                ));
            }
            return danhSach;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateSoLuongByIDCTSP(sanPhamChiTiet spct) {
        String sql = """
                     UPDATE SANPHAMCHITIET SET SOLUONG = ? WHERE ID = ?
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, spct.getSoLuong());
            ps.setInt(2, spct.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getSoLuongByID(int idSanPhamCT) {
        String sql = """
                 SELECT SOLUONG 
                 FROM SANPHAMCHITIET 
                 WHERE ID = ?
                 """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idSanPhamCT);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("SOLUONG");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<ChiTietSP_Model> timKiem(String id) {
        String sql = """
        SELECT ctsp.ID, sp.TEN, ctsp.DONGIA, dpg.TEN, kc.Inch, th.TEN, ctsp.SOLUONG
        FROM SANPHAMCHITIET ctsp
        JOIN SANPHAM sp ON ctsp.ID_SP = sp.ID
        JOIN DOPHANGIAI dpg ON ctsp.ID_PHANGIAI = dpg.ID
        JOIN KICHCO kc ON ctsp.ID_KICHCO = kc.ID
        JOIN THUONGHIEU th ON ctsp.ID_THUONGHIEU = th.ID
        WHERE ctsp.ID = ?
    """;

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            ArrayList<ChiTietSP_Model> danhSach = new ArrayList<>();
            while (rs.next()) {
                danhSach.add(new ChiTietSP_Model(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7)
                )
                );
            }
            return danhSach;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
