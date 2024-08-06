package qltv.service;

import java.util.List;
import qltv.model.doPhanGiai;
import qltv.model.kichCo;
import qltv.model.kieuDang;
import qltv.model.manHinh;
import qltv.model.sanPham;
import qltv.model.sanPhamChiTiet;
import qltv.model.thuongHieu;

/**
 *
 * @author tuann
 */
public interface sanPhamService {
    public List<sanPham> getListSanPham();
    public List<sanPhamChiTiet> getListSanPhamChiTiet();
    public List<sanPham> getListSanPhamOrderByTrangThai(boolean trangThai);
    public List<sanPham> getListSanPhamByMa(String ma);
    public List<thuongHieu> getAllBrands();
    public List<kieuDang> getAllStyles();
    public List<kichCo> getAllSizes();
    public List<manHinh> getAllScreens();
    public List<doPhanGiai> getAllResolutions();
    public List<sanPham> getTenSanPham();
    public List<thuongHieu> getTenThuongHieu();
    public List<kieuDang> getTenKieuDang();
    public List<kichCo> getInch();
    public List<manHinh> getTenManHinh();
    public List<doPhanGiai> getTenDoPhanGiai();
    public int addSanPham(sanPham sp);
    public boolean checkMa(String maSp);
    public int updateSanPham(int id,sanPham sp);
    public int deleteSanPham(int id);
    public boolean checkMaTh(String maTh);
    public boolean checkTenTh(String tenTh);
    public boolean checkMaKd(String maKd);
    public boolean checkTenKd(String tenKd);
    public boolean checkMaKc(String maKc);
    public boolean checkInch(String Inch);
    public boolean checkMaDpg(String maDpg);
    public boolean checkTenDpg(String tenDpg);
    public boolean checkMaMh(String maMh);
    public boolean checkTenMh(String tenMh);
    public int addThuongHieu(thuongHieu th);
    public int addKieuDang(kieuDang kd);
    public int addKichCo(kichCo kc);
    public int addDoPhanGiai(doPhanGiai dpg);
    public int addManHinh(manHinh mh);
    public boolean checkIdSp(int id);
    public boolean checkIdSpct(int id);
    public int addSanPhamChiTiet(sanPhamChiTiet spct);
    public boolean checkMaSpct(String ma);
    
}
