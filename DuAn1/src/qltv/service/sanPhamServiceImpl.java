package qltv.service;

import java.util.List;
import qltv.dao.sanPhamDAO;
import qltv.dao.sanPhamDAOImpl;
import qltv.model.doPhanGiai;
import qltv.model.kichCo;
import qltv.model.kieuDang;
import qltv.model.manHinh;
import qltv.model.sanPham;
import qltv.model.sanPhamChiTiet;
import qltv.model.thuongHieu;

public class sanPhamServiceImpl implements sanPhamService {

    private sanPhamDAO sanPhamDao = null;

    public sanPhamServiceImpl() {
        sanPhamDao = new sanPhamDAOImpl();
    }

    @Override
    public List<sanPham> getListSanPham() {
        return sanPhamDao.getListSanPham();
    }

    @Override
    public List<thuongHieu> getAllBrands() {
        return sanPhamDao.getAllBrands();
    }

    @Override
    public List<kieuDang> getAllStyles() {
        return sanPhamDao.getAllStyles();
    }

    @Override
    public List<kichCo> getAllSizes() {
        return sanPhamDao.getAllSizes();
    }

    @Override
    public List<manHinh> getAllScreens() {
        return sanPhamDao.getAllScreens();
    }

    @Override
    public List<doPhanGiai> getAllResolutions() {
        return sanPhamDao.getAllResolutions();
    }

    @Override
    public int addSanPham(sanPham sp) {
        return sanPhamDao.addSanPham(sp);
    }

    @Override
    public boolean checkMa(String maSp) {
        return sanPhamDao.checkMa(maSp);
    }

    @Override
    public int updateSanPham(int id, sanPham sp) {
        return sanPhamDao.updateSanPham(id, sp);
    }

    @Override
    public int deleteSanPham(int id) {
        return sanPhamDao.deleteSanPham(id);
    }

    @Override
    public List<sanPham> getListSanPhamOrderByTrangThai(boolean trangThai) {
        return sanPhamDao.getListSanPhamOrderByTrangThai(trangThai);
    }

    @Override
    public List<sanPham> getListSanPhamByMa(String ma) {
        return sanPhamDao.getListSanPhamByMa(ma);
    }

    @Override
    public List<thuongHieu> getTenThuongHieu() {
        return sanPhamDao.getTenThuongHieu();
    }

    @Override
    public List<kieuDang> getTenKieuDang() {
        return sanPhamDao.getTenKieuDang();
    }

    @Override
    public List<kichCo> getInch() {
        return sanPhamDao.getInch();
    }

    @Override
    public List<manHinh> getTenManHinh() {
        return sanPhamDao.getTenManHinh();
    }

    @Override
    public List<doPhanGiai> getTenDoPhanGiai() {
        return sanPhamDao.getTenDoPhanGiai();
    }

    @Override
    public List<sanPhamChiTiet> getListSanPhamChiTiet() {
        return sanPhamDao.getListSanPhamChiTiet();
    }

    @Override
    public boolean checkMaTh(String maTh) {
        return sanPhamDao.checkMaTh(maTh);
    }

    @Override
    public boolean checkTenTh(String tenTh) {
        return sanPhamDao.checkTenTh(tenTh);
    }

    @Override
    public boolean checkMaKd(String maKd) {
        return sanPhamDao.checkMaKd(maKd);
    }

    @Override
    public boolean checkTenKd(String tenKd) {
        return sanPhamDao.checkTenKd(tenKd);
    }

    @Override
    public boolean checkMaKc(String maKc) {
        return sanPhamDao.checkMaKc(maKc);
    }

    @Override
    public boolean checkInch(String Inch) {
        return sanPhamDao.checkTenKc(Inch);
    }

    @Override
    public boolean checkMaDpg(String maDpg) {
        return sanPhamDao.checkMaDpg(maDpg);
    }

    @Override
    public boolean checkTenDpg(String tenDpg) {
        return sanPhamDao.checkTenDpg(tenDpg);
    }

    @Override
    public boolean checkMaMh(String maMh) {
        return sanPhamDao.checkMaMh(maMh);
    }

    @Override
    public boolean checkTenMh(String tenMh) {
        return sanPhamDao.checkTenMh(tenMh);
    }

    @Override
    public int addThuongHieu(thuongHieu th) {
        return sanPhamDao.addThuongHieu(th);
    }

    @Override
    public int addKieuDang(kieuDang kd) {
        return sanPhamDao.addKieuDang(kd);
    }

    @Override
    public int addKichCo(kichCo kc) {
        return sanPhamDao.addKichCo(kc);
    }

    @Override
    public int addDoPhanGiai(doPhanGiai dpg) {
        return sanPhamDao.addDoPhanGiai(dpg);
    }

    @Override
    public int addManHinh(manHinh mh) {
        return sanPhamDao.addManHinh(mh);
    }

    @Override
    public boolean checkIdSp(int id) {
        return sanPhamDao.checkIdSp(id);
    }

    @Override
    public boolean checkIdSpct(int id) {
        return sanPhamDao.checkIdSpct(id);
    }

    @Override
    public int addSanPhamChiTiet(sanPhamChiTiet spct) {
        return sanPhamDao.addSanPhamChiTiet(spct);
    }

    @Override
    public boolean checkMaSpct(String ma) {
        return sanPhamDao.checkMaSpct(ma);
    }

    @Override
    public List<sanPham> getTenSanPham() {
        return sanPhamDao.getTenSanPham();
    }


}
