package qltv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import qltv.model.HoaDonChiTiet_Model;
import qltv.model.hoaDonChiTiet;

public class HDCTService {

    public ArrayList<HoaDonChiTiet_Model> getALLByIdHoaDon(int idHoaDon) {
        String sql = """
                     SELECT hdct.ID, hdct.ID_HD, hdct.ID_SPCT, sp.TEN, hdct.SOLUONG, hdct.DONGIA
                     FROM HOADONCHITIET hdct
                     INNER JOIN SANPHAMCHITIET ctsp ON hdct.ID_SPCT = ctsp.ID
                     INNER JOIN SANPHAM sp ON ctsp.ID_SP = sp.ID
                     WHERE hdct.ID_HD = ?;
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ArrayList<HoaDonChiTiet_Model> danhSach = new ArrayList<>();
            ps.setInt(1, idHoaDon);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                danhSach.add(new HoaDonChiTiet_Model(
                                rs.getInt(1),
                                rs.getInt(2),
                                rs.getInt(3),
                                rs.getString(4),
                                rs.getInt(5),
                                rs.getInt(6)
                        ));
            }
            return danhSach;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addHDCT(hoaDonChiTiet hdct) {
        String sql = """
             INSERT INTO HOADONCHITIET(ID_HD, ID_SPCT, SOLUONG, DONGIA) VALUES(?,?,?,?)
             """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, hdct.getId_hd());
            ps.setInt(2, hdct.getId_spct());
            ps.setInt(3, hdct.getSoLuong());
            ps.setInt(4, hdct.getDonGia());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteHDCT(int idSanPhamCT, int idHoaDon) {
        String sql = """
                 DELETE FROM HOADONCHITIET 
                 WHERE ID_SPCT = ? AND ID_HD = ?
                 """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idSanPhamCT);
            ps.setInt(2, idHoaDon);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateHDCT(hoaDonChiTiet hdct) {
        String sql = """
            UPDATE HOADONCHITIET 
            SET SOLUONG = ?, DONGIA = ? 
            WHERE ID = ?;
        """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, hdct.getSoLuong());
            ps.setInt(2, hdct.getDonGia());
            ps.setInt(3, hdct.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int getTongTienByIdHoaDon(int idHoaDon) {
        String sql = """
                    SELECT 
                        HD.ID AS ID_HOADON,
                        SUM(HDC.DONGIA * HDC.SOLUONG) AS TONGTIEN
                    FROM HOADON HD
                        JOIN HOADONCHITIET HDC ON HD.ID = HDC.ID_HD
                        WHERE HD.ID = ?
                        GROUP BY HD.ID;
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idHoaDon);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("TONGTIEN");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
