package qltv.dao;

import java.util.List;
import qltv.model.doPhanGiai;
import qltv.model.kichCo;
import qltv.model.kieuDang;
import qltv.model.manHinh;
import qltv.model.sanPham;
import qltv.model.sanPhamChiTiet;
import qltv.model.thuongHieu;


public interface sanPhamDAO {
    public List<sanPham> getListSanPham();
    public List<sanPhamChiTiet> getListSanPhamChiTiet();
    public int addSanPhamChiTiet(sanPhamChiTiet spct);
    public int updateSpct(String maSpct,sanPhamChiTiet spct);
    public int deleteSpct(int id);
    public List<sanPhamChiTiet> getListSanPhamChiTietByMa(String maSpct);
    public List<sanPham> getListSanPhamByMa(String ma);
    public List<sanPham> getTenSanPham();
    public List<thuongHieu> getAllBrands();
    public List<kieuDang> getAllStyles();
    public List<kichCo> getAllSizes();
    public List<manHinh> getAllScreens();
    public List<doPhanGiai> getAllResolutions();
    public List<thuongHieu> getTenThuongHieu();
    public List<kieuDang> getTenKieuDang();
    public List<kichCo> getInch();
    public List<manHinh> getTenManHinh();
    public List<doPhanGiai> getTenDoPhanGiai();
    public int addSanPham(sanPham sp);
    public boolean checkMa(String maSp);
    public int updateSanPham(int id,sanPham sp);
    public int deleteSanPham(int id);
    public List<sanPham> getListSanPhamOrderByTrangThai(boolean trangThai);
    public List<sanPhamChiTiet> getListSanPhamChiTietOrderByTrangThai(boolean trangThai);
    public boolean checkMaTh(String maTh);
    public boolean checkTenTh(String tenTh);
    public boolean checkMaKd(String maKd);
    public boolean checkTenKd(String tenKd);
    public boolean checkMaKc(String maKc);
    public boolean checkTenKc(String Inch);
    public boolean checkMaDpg(String maDpg);
    public boolean checkTenDpg(String tenDpg);
    public boolean checkMaMh(String maMh);
    public boolean checkTenMh(String tenMh);
    public int addThuongHieu(thuongHieu th);
    public int updateThuongHieu(int id,thuongHieu th);
    public int deleteThuongHieu(int id);
    public int addKieuDang(kieuDang kd);
    public int updateKieuDang(int id,kieuDang kd);
    public int deleteKieuDang(int id);
    public int addKichCo(kichCo kc);
    public int updateKichCo(int id,kichCo kc);
    public int deleteKichCo(int id);
    public int addDoPhanGiai(doPhanGiai dpg);
    public int updateDpg(int id,doPhanGiai dpg);
    public int deleteDpg(int id);
    public int addManHinh(manHinh mh);
    public int updateManHinh(int id,manHinh mh);
    public int deleteManHinh(int id);
    public boolean checkIdSp(int id);
    public boolean checkIdSpct(int id);
    public boolean checkMaSpct(String ma);
    public int getIDByTenTh(String maTh);
    public int getIDByTenKd(String maKd);
    public int getIDByTenMh(String maMh);
    public int getIDByTenKc(String maKc);
    public int getIDByTenDpg(String maDpg);
    public int getIDByTenSp(String maSp);
}
