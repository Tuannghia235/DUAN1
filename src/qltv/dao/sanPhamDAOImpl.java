package qltv.dao;

import java.util.ArrayList;
import java.util.List;
import qltv.model.sanPham;
import java.sql.*;
import qltv.model.doPhanGiai;
import qltv.model.kichCo;
import qltv.model.kieuDang;
import qltv.model.loai;
import qltv.model.manHinh;
import qltv.model.sanPhamChiTiet;
import qltv.model.thuongHieu;

public class sanPhamDAOImpl implements sanPhamDAO {

    @Override
    public List<sanPham> getListSanPham() {
        List<sanPham> list = new ArrayList<>();
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT ID,MASP,TEN,TRANGTHAI FROM SANPHAM";
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sanPham sp = new sanPham();
                sp.setId(rs.getInt(1));
                sp.setMa(rs.getString(2));
                sp.setTen(rs.getString(3));
                sp.setTrangThai(rs.getBoolean(4));
                list.add(sp);
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
    public List<thuongHieu> getAllBrands() {
        List<thuongHieu> brands = new ArrayList<>();
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "select ID,MA,TEN,NGUONGOC from THUONGHIEU";
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                thuongHieu th = new thuongHieu();
                th.setId(rs.getInt("ID"));
                th.setMa(rs.getString("MA"));
                th.setTen(rs.getString("TEN"));
                th.setNguonGoc(rs.getString("NGUONGOC"));
                brands.add(th);
            }
            ps.close();
            rs.close();
            cons.close();
            return brands;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        sanPhamDAO sanPhamDAO = new sanPhamDAOImpl();
    }

    @Override
    public List<kieuDang> getAllStyles() {
        List<kieuDang> styles = new ArrayList<>();
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "select ID,MA,TEN from KIEUDANG";
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                kieuDang kd = new kieuDang();
                kd.setId(rs.getInt("ID"));
                kd.setMa(rs.getString("MA"));
                kd.setTen(rs.getString("TEN"));
                styles.add(kd);
            }
            ps.close();
            rs.close();
            cons.close();
            return styles;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<manHinh> getAllScreens() {
        List<manHinh> screens = new ArrayList<>();
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "select ID,MA,TEN from MANHINH";
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                manHinh mh = new manHinh();
                mh.setId(rs.getInt("ID"));
                mh.setMa(rs.getString("MA"));
                mh.setTen(rs.getString("TEN"));
                screens.add(mh);
            }
            ps.close();
            rs.close();
            cons.close();
            return screens;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<doPhanGiai> getAllResolutions() {
        List<doPhanGiai> resolutions = new ArrayList<>();
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "select ID,MA,TEN from DOPHANGIAI";
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                doPhanGiai dpg = new doPhanGiai();
                dpg.setId(rs.getInt("ID"));
                dpg.setMa(rs.getString("MA"));
                dpg.setTen(rs.getString("TEN"));
                resolutions.add(dpg);
            }
            ps.close();
            rs.close();
            cons.close();
            return resolutions;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<kichCo> getAllSizes() {
        List<kichCo> sizes = new ArrayList<>();
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "select ID,MA,Inch from KICHCO";
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                kichCo kc = new kichCo();
                kc.setId(rs.getInt("ID"));
                kc.setMa(rs.getString("MA"));
                kc.setInch(rs.getInt("Inch"));
                sizes.add(kc);
            }
            ps.close();
            rs.close();
            cons.close();
            return sizes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<thuongHieu> getTenThuongHieu() {
        List<thuongHieu> brands = new ArrayList<>();
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "select TEN from THUONGHIEU";
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                thuongHieu th = new thuongHieu();
                th.setTen(rs.getString("TEN"));
                brands.add(th);
            }
            ps.close();
            rs.close();
            cons.close();
            return brands;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<kieuDang> getTenKieuDang() {
        List<kieuDang> styles = new ArrayList<>();
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "select TEN from KIEUDANG";
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                kieuDang kd = new kieuDang();
                kd.setTen(rs.getString("TEN"));
                styles.add(kd);
            }
            ps.close();
            rs.close();
            cons.close();
            return styles;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<kichCo> getInch() {
        List<kichCo> sizes = new ArrayList<>();
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "select Inch from KICHCO";
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                kichCo kc = new kichCo();
                kc.setInch(rs.getInt("Inch"));
                sizes.add(kc);
            }
            ps.close();
            rs.close();
            cons.close();
            return sizes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<manHinh> getTenManHinh() {
        List<manHinh> screens = new ArrayList<>();
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "select TEN from MANHINH";
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                manHinh mh = new manHinh();
                mh.setTen(rs.getString("TEN"));
                screens.add(mh);
            }
            ps.close();
            rs.close();
            cons.close();
            return screens;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<doPhanGiai> getTenDoPhanGiai() {
        List<doPhanGiai> resolutions = new ArrayList<>();
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "select TEN from DOPHANGIAI";
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                doPhanGiai dpg = new doPhanGiai();
                dpg.setTen(rs.getString("TEN"));
                resolutions.add(dpg);
            }
            ps.close();
            rs.close();
            cons.close();
            return resolutions;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addSanPham(sanPham sp) {
        String sql = "INSERT INTO SANPHAM(MASP,TEN,TRANGTHAI) VALUES (?,?,?)";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setObject(1, sp.getMa());
            ps.setObject(2, sp.getTen());
            ps.setObject(3, sp.isTrangThai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public boolean checkMa(String maSp) {
        String sql = "SELECT ID, MASP, TEN, TRANGTHAI FROM SANPHAM WHERE MASP = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, maSp);
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
    public int updateSanPham(int id, sanPham sp) {
        String sql = "UPDATE SANPHAM SET MASP = ?, TEN = ?, TRANGTHAI = ? where ID = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setObject(1, sp.getMa());
            ps.setObject(2, sp.getTen());
            ps.setObject(3, sp.isTrangThai());
            ps.setObject(4, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int deleteSanPham(int id) {
        String sql1 = "DELETE FROM HOADONCHITIET WHERE ID_SPCT IN (SELECT ID FROM SANPHAMCHITIET WHERE ID_SP = ?)";
        String sql2 = "DELETE FROM SANPHAMCHITIET WHERE ID_SP IN (SELECT ID FROM SANPHAM WHERE ID = ?)";
        String sql3 = "DELETE FROM SANPHAM WHERE ID = ?";
        Connection cons = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        try {
            cons = DBConnect.getConnection();
            cons.setAutoCommit(false);

            ps1 = cons.prepareStatement(sql1);
            ps1.setInt(1, id);
            int rowsAffected1 = ps1.executeUpdate();

            ps2 = cons.prepareStatement(sql2);
            ps2.setInt(1, id);
            int rowsAffected2 = ps2.executeUpdate();

            ps3 = cons.prepareStatement(sql3);
            ps3.setInt(1, id);
            int rowsAffected3 = ps3.executeUpdate();

            cons.commit();
            return rowsAffected1 + rowsAffected2 + rowsAffected3;
        } catch (Exception e) {
            e.printStackTrace();
            if (cons != null) {
                try {
                    cons.rollback();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            return 0;
        } finally {
            try {
                if (ps1 != null) {
                    ps1.close();
                }
                if (ps2 != null) {
                    ps2.close();
                }
                if (ps3 != null) {
                    ps3.close();
                }
                if (cons != null) {
                    cons.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public List<sanPham> getListSanPhamOrderByTrangThai(boolean trangThai) {
        List<sanPham> list = new ArrayList<>();
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT ID,MASP,TEN,TRANGTHAI FROM SANPHAM WHERE TRANGTHAI = ?";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setBoolean(1, trangThai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sanPham sp = new sanPham();
                sp.setId(rs.getInt(1));
                sp.setMa(rs.getString(2));
                sp.setTen(rs.getString(3));
                sp.setTrangThai(rs.getBoolean(4));
                list.add(sp);
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
    public List<sanPham> getListSanPhamByMa(String ma) {
        List<sanPham> list = new ArrayList<>();
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT ID,MASP,TEN,TRANGTHAI FROM SANPHAM where masp like ?";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, "%" + ma + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sanPham sp = new sanPham();
                sp.setId(rs.getInt(1));
                sp.setMa(rs.getString(2));
                sp.setTen(rs.getString(3));
                sp.setTrangThai(rs.getBoolean(4));
                list.add(sp);
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
    public List<sanPhamChiTiet> getListSanPhamChiTiet() {
        List<sanPhamChiTiet> list = new ArrayList<>();
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "select SANPHAMCHITIET.ID,SANPHAMCHITIET.MASPCT, SANPHAM.TEN AS TEN_SANPHAM, SANPHAMCHITIET.SOLUONG, SANPHAMCHITIET.DONGIA, \n" +
"                                          THUONGHIEU.TEN AS TEN_THUONGHIEU, KIEUDANG.TEN AS TEN_KIEUDANG, MANHINH.TEN AS TEN_MANHINH, \n" +
"                                          KICHCO.Inch AS INCH_KICHCO, DOPHANGIAI.TEN AS TEN_DOPHANGIAI, LOAI.TEN AS TEN_LOAI , SANPHAMCHITIET.TRANGTHAI AS TRANGTHAI\n" +
"                                          from SANPHAMCHITIET\n" +
"                                          JOIN SANPHAM ON SANPHAM.ID = SANPHAMCHITIET.ID_SP\n" +
"                                          JOIN THUONGHIEU ON THUONGHIEU.ID = SANPHAMCHITIET.ID_THUONGHIEU \n" +
"                                          JOIN KIEUDANG ON KIEUDANG.ID = SANPHAMCHITIET.ID_KIEUDANG \n" +
"                                          JOIN KICHCO ON KICHCO.ID = SANPHAMCHITIET.ID_KICHCO \n" +
"                                          JOIN MANHINH ON MANHINH.ID = SANPHAMCHITIET.ID_MANHINH \n" +
"                                          JOIN DOPHANGIAI ON DOPHANGIAI.ID = SANPHAMCHITIET.ID_PHANGIAI \n" +
"                                          JOIN LOAI ON LOAI.ID = SANPHAMCHITIET.ID_LOAI\n" +
"                                          Where SANPHAM.TRANGTHAI = 1";
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sanPhamChiTiet spct = new sanPhamChiTiet();
                spct.setId(rs.getInt(1));
                spct.setMa(rs.getString("MASPCT"));

                sanPham sp = new sanPham();
                sp.setTen(rs.getString("TEN_SANPHAM"));
                spct.setSp(sp);

                spct.setSoLuong(rs.getInt("SOLUONG"));
                spct.setDonGia(rs.getInt("DONGIA"));
                spct.setTrangThai(rs.getBoolean("TRANGTHAI"));

                thuongHieu th = new thuongHieu();
                th.setTen(rs.getString("TEN_THUONGHIEU"));
                spct.setThuongHieu(th);

                kieuDang kd = new kieuDang();
                kd.setTen(rs.getString("TEN_KIEUDANG"));
                spct.setKieuDang(kd);

                manHinh mh = new manHinh();
                mh.setTen(rs.getString("TEN_MANHINH"));
                spct.setManHinh(mh);

                kichCo kc = new kichCo();
                kc.setInch(rs.getInt("INCH_KICHCO"));
                spct.setKichCo(kc);

                doPhanGiai dpg = new doPhanGiai();
                dpg.setTen(rs.getString("TEN_DOPHANGIAI"));
                spct.setDoPhanGiai(dpg);

                loai l = new loai();
                l.setTen(rs.getString("TEN_LOAI"));
                spct.setLoai(l);

                list.add(spct);
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
    public boolean checkMaTh(String maTh) {
        String sql = "select ID,MA,TEN,NGUONGOC from THUONGHIEU WHERE MA = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, maTh);
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
    public boolean checkMaKd(String maKd) {
        String sql = "select ID,MA,TEN from KIEUDANG where TEN = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, maKd);
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
    public boolean checkMaKc(String maKc) {
        String sql = "select ID,MA,Inch from KICHCO where MA = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, maKc);
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
    public boolean checkMaDpg(String maDpg) {
        String sql = "select ID,MA,TEN from DOPHANGIAI where MA = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, maDpg);
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
    public boolean checkMaMh(String maMh) {
        String sql = "select ID,MA,TEN from MANHINH where MA = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, maMh);
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
    public int addThuongHieu(thuongHieu th) {
        String sql = "INSERT INTO THUONGHIEU(MA,TEN,NGUONGOC) VALUES (?,?,?)";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setObject(1, th.getMa());
            ps.setObject(2, th.getTen());
            ps.setObject(3, th.getNguonGoc());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int addKieuDang(kieuDang kd) {
        String sql = "INSERT INTO KIEUDANG(MA,TEN) VALUES (?,?)";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setObject(1, kd.getMa());
            ps.setObject(2, kd.getTen());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int addKichCo(kichCo kc) {
        String sql = "INSERT INTO KICHCO(MA,Inch) VALUES (?,?)";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setObject(1, kc.getMa());
            ps.setObject(2, kc.getInch());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int addDoPhanGiai(doPhanGiai dpg) {
        String sql = "INSERT INTO DOPHANGIAI(MA,TEN) VALUES (?,?)";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setObject(1, dpg.getMa());
            ps.setObject(2, dpg.getTen());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int addManHinh(manHinh mh) {
        String sql = "INSERT INTO MANHINH(MA,TEN) VALUES (?,?)";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setObject(1, mh.getMa());
            ps.setObject(2, mh.getTen());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public boolean checkTenTh(String tenTh) {
        String sql = "select ID,MA,TEN,NGUONGOC from THUONGHIEU WHERE TEN= ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, tenTh);
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
    public boolean checkTenKd(String tenKd) {
        String sql = "select ID,MA,TEN from KIEUDANG where TEN = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, tenKd);
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
    public boolean checkTenKc(String Inch) {

        String sql = "select ID,MA,Inch from KICHCO where Inch = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, Inch);
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
    public boolean checkTenDpg(String tenDpg) {
        String sql = "select ID,MA,TEN from DOPHANGIAI where TEN = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, tenDpg);
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
    public boolean checkTenMh(String tenMh) {
        String sql = "select ID,MA,TEN from MANHINH where TEN = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, tenMh);
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
    public int addSanPhamChiTiet(sanPhamChiTiet spct) {
        String sql = """
                     INSERT INTO SANPHAMCHITIET(MASPCT,ID_SP,SOLUONG,DONGIA,ID_THUONGHIEU,ID_KIEUDANG,ID_MANHINH,ID_KICHCO,ID_PHANGIAI,ID_LOAI,TRANGTHAI)
                     VALUES (?,?,?,?,?,?,?,?,?,?,?)""";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setObject(1, spct.getMa());
            ps.setObject(2, spct.getId_sp());
            ps.setObject(3, spct.getSoLuong());
            ps.setObject(4, spct.getDonGia());
            ps.setObject(5, spct.getId_thuongHieu());
            ps.setObject(6, spct.getId_kieuDang());
            ps.setObject(7, spct.getId_manHinh());
            ps.setObject(8, spct.getId_kichCo());
            ps.setObject(9, spct.getId_phanGiai());
            ps.setObject(10, spct.getId_loai());
            ps.setObject(11, spct.isTrangThai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public boolean checkIdSp(int id) {
        String sql = "select * from SANPHAM where ID = ? ";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setInt(1, id);
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
    public boolean checkIdSpct(int id) {
        String sql = "select * from SANPHAMCHITIET where ID = ? ";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setInt(1, id);
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
    public boolean checkMaSpct(String ma) {
        String sql = "select * from SANPHAMCHITIET where MASPCT = ?";
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
    public List<sanPham> getTenSanPham() {
        List<sanPham> sanPham = new ArrayList<>();
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "select TEN from SANPHAM";
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sanPham sp = new sanPham();
                sp.setTen(rs.getString("TEN"));
                sanPham.add(sp);
            }
            ps.close();
            rs.close();
            cons.close();
            return sanPham;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getIDByTenTh(String maTh) {
        String sql = "SELECT ID FROM THUONGHIEU WHERE TEN = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, maTh);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("ID");
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int getIDByTenKd(String maKd) {
        String sql = "select ID from KIEUDANG WHERE TEN = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, maKd);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("ID");
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int getIDByTenMh(String maMh) {
        String sql = "select ID from MANHINH WHERE TEN = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, maMh);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("ID");
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int getIDByTenKc(String maKc) {
        String sql = "select ID from KICHCO WHERE Inch = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, maKc);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("ID");
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int getIDByTenDpg(String maDpg) {
        String sql = "select ID from DOPHANGIAI WHERE TEN = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, maDpg);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("ID");
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int getIDByTenSp(String maSp) {
        String sql = "select ID from SANPHAM WHERE TEN = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, maSp);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("ID");
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int updateSpct(String maSpct, sanPhamChiTiet spct) {
        String sql = "UPDATE SANPHAMCHITIET SET ID_SP = ?, SOLUONG = ?, DONGIA = ?, ID_THUONGHIEU = ?,ID_KIEUDANG = ?,ID_MANHINH = ?,ID_KICHCO = ?, ID_PHANGIAI = ?, ID_LOAI = ?, TRANGTHAI = ? WHERE MASPCT = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setObject(1, spct.getId_sp());
            ps.setObject(2, spct.getSoLuong());
            ps.setObject(3, spct.getDonGia());
            ps.setObject(4, spct.getId_thuongHieu());
            ps.setObject(5, spct.getId_kieuDang());
            ps.setObject(6, spct.getId_manHinh());
            ps.setObject(7, spct.getId_kichCo());
            ps.setObject(8, spct.getId_phanGiai());
            ps.setObject(9, spct.getId_loai());
            ps.setObject(10, spct.isTrangThai());
            ps.setObject(11, maSpct);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<sanPhamChiTiet> getListSanPhamChiTietByMa(String maSpct) {
        List<sanPhamChiTiet> list = new ArrayList<>();
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "select SANPHAMCHITIET.ID,SANPHAMCHITIET.MASPCT, SANPHAM.TEN AS TEN_SANPHAM, SANPHAMCHITIET.SOLUONG, SANPHAMCHITIET.DONGIA, \n"
                    + "                                          THUONGHIEU.TEN AS TEN_THUONGHIEU, KIEUDANG.TEN AS TEN_KIEUDANG, MANHINH.TEN AS TEN_MANHINH, \n"
                    + "                                          KICHCO.Inch AS INCH_KICHCO, DOPHANGIAI.TEN AS TEN_DOPHANGIAI, LOAI.TEN AS TEN_LOAI , SANPHAMCHITIET.TRANGTHAI AS TRANGTHAI\n"
                    + "                                          from SANPHAMCHITIET\n"
                    + "                                          JOIN SANPHAM ON SANPHAM.ID = SANPHAMCHITIET.ID_SP\n"
                    + "                                          JOIN THUONGHIEU ON THUONGHIEU.ID = SANPHAMCHITIET.ID_THUONGHIEU \n"
                    + "                                          JOIN KIEUDANG ON KIEUDANG.ID = SANPHAMCHITIET.ID_KIEUDANG \n"
                    + "                                          JOIN KICHCO ON KICHCO.ID = SANPHAMCHITIET.ID_KICHCO \n"
                    + "                                          JOIN MANHINH ON MANHINH.ID = SANPHAMCHITIET.ID_MANHINH \n"
                    + "                                          JOIN DOPHANGIAI ON DOPHANGIAI.ID = SANPHAMCHITIET.ID_PHANGIAI \n"
                    + "                                          JOIN LOAI ON LOAI.ID = SANPHAMCHITIET.ID_LOAI\n"
                    + "                                          Where SANPHAMCHITIET.MASPCT like ?";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, "%" + maSpct + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sanPhamChiTiet spct = new sanPhamChiTiet();
                spct.setId(rs.getInt(1));
                spct.setMa(rs.getString("MASPCT"));

                sanPham sp = new sanPham();
                sp.setTen(rs.getString("TEN_SANPHAM"));
                spct.setSp(sp);

                spct.setSoLuong(rs.getInt("SOLUONG"));
                spct.setDonGia(rs.getInt("DONGIA"));
                spct.setTrangThai(rs.getBoolean("TRANGTHAI"));

                thuongHieu th = new thuongHieu();
                th.setTen(rs.getString("TEN_THUONGHIEU"));
                spct.setThuongHieu(th);

                kieuDang kd = new kieuDang();
                kd.setTen(rs.getString("TEN_KIEUDANG"));
                spct.setKieuDang(kd);

                manHinh mh = new manHinh();
                mh.setTen(rs.getString("TEN_MANHINH"));
                spct.setManHinh(mh);

                kichCo kc = new kichCo();
                kc.setInch(rs.getInt("INCH_KICHCO"));
                spct.setKichCo(kc);

                doPhanGiai dpg = new doPhanGiai();
                dpg.setTen(rs.getString("TEN_DOPHANGIAI"));
                spct.setDoPhanGiai(dpg);

                loai l = new loai();
                l.setTen(rs.getString("TEN_LOAI"));
                spct.setLoai(l);

                list.add(spct);
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
    public List<sanPhamChiTiet> getListSanPhamChiTietOrderByTrangThai(boolean trangThai) {
        List<sanPhamChiTiet> list = new ArrayList<>();
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "select SANPHAMCHITIET.ID,SANPHAMCHITIET.MASPCT, SANPHAM.TEN AS TEN_SANPHAM, SANPHAMCHITIET.SOLUONG, SANPHAMCHITIET.DONGIA, \n"
                    + "                                          THUONGHIEU.TEN AS TEN_THUONGHIEU, KIEUDANG.TEN AS TEN_KIEUDANG, MANHINH.TEN AS TEN_MANHINH, \n"
                    + "                                          KICHCO.Inch AS INCH_KICHCO, DOPHANGIAI.TEN AS TEN_DOPHANGIAI, LOAI.TEN AS TEN_LOAI , SANPHAMCHITIET.TRANGTHAI AS TRANGTHAI\n"
                    + "                                          from SANPHAMCHITIET\n"
                    + "                                          JOIN SANPHAM ON SANPHAM.ID = SANPHAMCHITIET.ID_SP\n"
                    + "                                          JOIN THUONGHIEU ON THUONGHIEU.ID = SANPHAMCHITIET.ID_THUONGHIEU \n"
                    + "                                          JOIN KIEUDANG ON KIEUDANG.ID = SANPHAMCHITIET.ID_KIEUDANG \n"
                    + "                                          JOIN KICHCO ON KICHCO.ID = SANPHAMCHITIET.ID_KICHCO \n"
                    + "                                          JOIN MANHINH ON MANHINH.ID = SANPHAMCHITIET.ID_MANHINH \n"
                    + "                                          JOIN DOPHANGIAI ON DOPHANGIAI.ID = SANPHAMCHITIET.ID_PHANGIAI \n"
                    + "                                          JOIN LOAI ON LOAI.ID = SANPHAMCHITIET.ID_LOAI\n"
                    + "                                          Where SANPHAMCHITIET.TRANGTHAI = ?";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setBoolean(1, trangThai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sanPhamChiTiet spct = new sanPhamChiTiet();
                spct.setId(rs.getInt(1));
                spct.setMa(rs.getString("MASPCT"));

                sanPham sp = new sanPham();
                sp.setTen(rs.getString("TEN_SANPHAM"));
                spct.setSp(sp);

                spct.setSoLuong(rs.getInt("SOLUONG"));
                spct.setDonGia(rs.getInt("DONGIA"));
                spct.setTrangThai(rs.getBoolean("TRANGTHAI"));

                thuongHieu th = new thuongHieu();
                th.setTen(rs.getString("TEN_THUONGHIEU"));
                spct.setThuongHieu(th);

                kieuDang kd = new kieuDang();
                kd.setTen(rs.getString("TEN_KIEUDANG"));
                spct.setKieuDang(kd);

                manHinh mh = new manHinh();
                mh.setTen(rs.getString("TEN_MANHINH"));
                spct.setManHinh(mh);

                kichCo kc = new kichCo();
                kc.setInch(rs.getInt("INCH_KICHCO"));
                spct.setKichCo(kc);

                doPhanGiai dpg = new doPhanGiai();
                dpg.setTen(rs.getString("TEN_DOPHANGIAI"));
                spct.setDoPhanGiai(dpg);

                loai l = new loai();
                l.setTen(rs.getString("TEN_LOAI"));
                spct.setLoai(l);

                list.add(spct);
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
    public int deleteSpct(int id) {
        String sql1 = "DELETE FROM HOADONCHITIET WHERE ID_SPCT IN (SELECT ID FROM SANPHAMCHITIET WHERE ID = ?)";
        String sql2 = "DELETE FROM SANPHAMCHITIET WHERE ID = ?";
        Connection cons = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        try {
            cons = DBConnect.getConnection();
            cons.setAutoCommit(false);

            ps1 = cons.prepareStatement(sql1);
            ps1.setInt(1, id);
            int rowsAffected1 = ps1.executeUpdate();

            ps2 = cons.prepareStatement(sql2);
            ps2.setInt(1, id);
            int rowsAffected2 = ps2.executeUpdate();

            cons.commit();
            return rowsAffected1 + rowsAffected2;
        } catch (Exception e) {
            e.printStackTrace();
            if (cons != null) {
                try {
                    cons.rollback();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            return 0;
        } finally {
            try {
                if (ps1 != null) {
                    ps1.close();
                }
                if (ps2 != null) {
                    ps2.close();
                }
                if (cons != null) {
                    cons.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int updateThuongHieu(int id, thuongHieu th) {
        String sql = "UPDATE THUONGHIEU SET TEN = ?, NGUONGOC = ? where ID = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setObject(1, th.getTen());
            ps.setObject(2, th.getNguonGoc());
            ps.setObject(3, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int deleteThuongHieu(int id) {
        String sql1 = "DELETE FROM HOADONCHITIET WHERE ID_SPCT IN (SELECT ID FROM SANPHAMCHITIET WHERE ID_THUONGHIEU = ?)";
        String sql2 = "DELETE FROM SANPHAMCHITIET WHERE ID_THUONGHIEU IN (SELECT ID FROM THUONGHIEU WHERE ID = ?)";
        String sql3 = "DELETE FROM THUONGHIEU WHERE ID = ?";
        Connection cons = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        try {
            cons = DBConnect.getConnection();
            cons.setAutoCommit(false);

            ps1 = cons.prepareStatement(sql1);
            ps1.setInt(1, id);
            int rowsAffected1 = ps1.executeUpdate();

            ps2 = cons.prepareStatement(sql2);
            ps2.setInt(1, id);
            int rowsAffected2 = ps2.executeUpdate();

            ps3 = cons.prepareStatement(sql3);
            ps3.setInt(1, id);
            int rowsAffected3 = ps3.executeUpdate();

            cons.commit();
            return rowsAffected1 + rowsAffected2 + rowsAffected3;
        } catch (Exception e) {
            e.printStackTrace();
            if (cons != null) {
                try {
                    cons.rollback();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            return 0;
        } finally {
            try {
                if (ps1 != null) {
                    ps1.close();
                }
                if (ps2 != null) {
                    ps2.close();
                }
                if (ps3 != null) {
                    ps3.close();
                }
                if (cons != null) {
                    cons.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int updateKieuDang(int id, kieuDang kd) {
        String sql = "UPDATE KIEUDANG SET TEN = ? where ID = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setObject(1, kd.getTen());
            ps.setObject(2, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int deleteKieuDang(int id) {
        String sql1 = "DELETE FROM HOADONCHITIET WHERE ID_SPCT IN (SELECT ID FROM SANPHAMCHITIET WHERE ID_KIEUDANG = ?)";
        String sql2 = "DELETE FROM SANPHAMCHITIET WHERE ID_KIEUDANG IN (SELECT ID FROM KIEUDANG WHERE ID = ?)";
        String sql3 = "DELETE FROM KIEUDANG WHERE ID = ?";
        Connection cons = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        try {
            cons = DBConnect.getConnection();
            cons.setAutoCommit(false);

            ps1 = cons.prepareStatement(sql1);
            ps1.setInt(1, id);
            int rowsAffected1 = ps1.executeUpdate();

            ps2 = cons.prepareStatement(sql2);
            ps2.setInt(1, id);
            int rowsAffected2 = ps2.executeUpdate();

            ps3 = cons.prepareStatement(sql3);
            ps3.setInt(1, id);
            int rowsAffected3 = ps3.executeUpdate();

            cons.commit();
            return rowsAffected1 + rowsAffected2 + rowsAffected3;
        } catch (Exception e) {
            e.printStackTrace();
            if (cons != null) {
                try {
                    cons.rollback();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            return 0;
        } finally {
            try {
                if (ps1 != null) {
                    ps1.close();
                }
                if (ps2 != null) {
                    ps2.close();
                }
                if (ps3 != null) {
                    ps3.close();
                }
                if (cons != null) {
                    cons.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int updateManHinh(int id, manHinh mh) {
        String sql = "UPDATE MANHINH SET TEN = ? where ID = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setObject(1, mh.getTen());
            ps.setObject(2, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int deleteManHinh(int id) {
        String sql1 = "DELETE FROM HOADONCHITIET WHERE ID_SPCT IN (SELECT ID FROM SANPHAMCHITIET WHERE ID_MANHINH = ?)";
        String sql2 = "DELETE FROM SANPHAMCHITIET WHERE ID_MANHINH IN (SELECT ID FROM MANHINH WHERE ID = ?)";
        String sql3 = "DELETE FROM MANHINH WHERE ID = ?";
        Connection cons = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        try {
            cons = DBConnect.getConnection();
            cons.setAutoCommit(false);

            ps1 = cons.prepareStatement(sql1);
            ps1.setInt(1, id);
            int rowsAffected1 = ps1.executeUpdate();

            ps2 = cons.prepareStatement(sql2);
            ps2.setInt(1, id);
            int rowsAffected2 = ps2.executeUpdate();

            ps3 = cons.prepareStatement(sql3);
            ps3.setInt(1, id);
            int rowsAffected3 = ps3.executeUpdate();

            cons.commit();
            return rowsAffected1 + rowsAffected2 + rowsAffected3;
        } catch (Exception e) {
            e.printStackTrace();
            if (cons != null) {
                try {
                    cons.rollback();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            return 0;
        } finally {
            try {
                if (ps1 != null) {
                    ps1.close();
                }
                if (ps2 != null) {
                    ps2.close();
                }
                if (ps3 != null) {
                    ps3.close();
                }
                if (cons != null) {
                    cons.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int updateDpg(int id, doPhanGiai dpg) {
        String sql = "UPDATE DOPHANGIAI SET TEN = ? where ID = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setObject(1, dpg.getTen());
            ps.setObject(2, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int deleteDpg(int id) {
        String sql1 = "DELETE FROM HOADONCHITIET WHERE ID_SPCT IN (SELECT ID FROM SANPHAMCHITIET WHERE ID_PHANGIAI = ?)";
        String sql2 = "DELETE FROM SANPHAMCHITIET WHERE ID_PHANGIAI IN (SELECT ID FROM DOPHANGIAI WHERE ID = ?)";
        String sql3 = "DELETE FROM DOPHANGIAI WHERE ID = ?";
        Connection cons = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        try {
            cons = DBConnect.getConnection();
            cons.setAutoCommit(false);

            ps1 = cons.prepareStatement(sql1);
            ps1.setInt(1, id);
            int rowsAffected1 = ps1.executeUpdate();

            ps2 = cons.prepareStatement(sql2);
            ps2.setInt(1, id);
            int rowsAffected2 = ps2.executeUpdate();

            ps3 = cons.prepareStatement(sql3);
            ps3.setInt(1, id);
            int rowsAffected3 = ps3.executeUpdate();

            cons.commit();
            return rowsAffected1 + rowsAffected2 + rowsAffected3;
        } catch (Exception e) {
            e.printStackTrace();
            if (cons != null) {
                try {
                    cons.rollback();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            return 0;
        } finally {
            try {
                if (ps1 != null) {
                    ps1.close();
                }
                if (ps2 != null) {
                    ps2.close();
                }
                if (ps3 != null) {
                    ps3.close();
                }
                if (cons != null) {
                    cons.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int updateKichCo(int id, kichCo kc) {
        String sql = "UPDATE KICHCO SET Inch = ? where ID = ?";
        try {
            Connection cons = DBConnect.getConnection();
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setObject(1, kc.getInch());
            ps.setObject(2, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int deleteKichCo(int id) {
        String sql1 = "DELETE FROM HOADONCHITIET WHERE ID_SPCT IN (SELECT ID FROM SANPHAMCHITIET WHERE ID_KICHCO = ?)";
        String sql2 = "DELETE FROM SANPHAMCHITIET WHERE ID_KICHCO IN (SELECT ID FROM KICHCO WHERE ID = ?)";
        String sql3 = "DELETE FROM KICHCO WHERE ID = ?";
        Connection cons = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        try {
            cons = DBConnect.getConnection();
            cons.setAutoCommit(false);

            ps1 = cons.prepareStatement(sql1);
            ps1.setInt(1, id);
            int rowsAffected1 = ps1.executeUpdate();

            ps2 = cons.prepareStatement(sql2);
            ps2.setInt(1, id);
            int rowsAffected2 = ps2.executeUpdate();

            ps3 = cons.prepareStatement(sql3);
            ps3.setInt(1, id);
            int rowsAffected3 = ps3.executeUpdate();

            cons.commit();
            return rowsAffected1 + rowsAffected2 + rowsAffected3;
        } catch (Exception e) {
            e.printStackTrace();
            if (cons != null) {
                try {
                    cons.rollback();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            return 0;
        } finally {
            try {
                if (ps1 != null) {
                    ps1.close();
                }
                if (ps2 != null) {
                    ps2.close();
                }
                if (ps3 != null) {
                    ps3.close();
                }
                if (cons != null) {
                    cons.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
