
package qltv.model;

public class hoaDon {

    private int id;
    private String ma;
    private int id_kh;
    private int id_nv;
    private int id_thanhToan;
    private String ten;
    private String sdt;
    private String ngay;
    private int tongTien;
    private int trangThai;

    public hoaDon() {
    }

    public hoaDon(int id, String ma, int id_kh, int id_nv, int id_thanhToan, String ten, String sdt, String ngay, int tongTien, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.id_kh = id_kh;
        this.id_nv = id_nv;
        this.id_thanhToan = id_thanhToan;
        this.ten = ten;
        this.sdt = sdt;
        this.ngay = ngay;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public int getId_kh() {
        return id_kh;
    }

    public void setId_kh(int id_kh) {
        this.id_kh = id_kh;
    }

    public int getId_nv() {
        return id_nv;
    }

    public void setId_nv(int id_nv) {
        this.id_nv = id_nv;
    }

    public int getId_thanhToan() {
        return id_thanhToan;
    }

    public void setId_thanhToan(int id_thanhToan) {
        this.id_thanhToan = id_thanhToan;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    
}
