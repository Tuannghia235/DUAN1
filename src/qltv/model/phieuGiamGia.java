package qltv.model;

public class phieuGiamGia {
    private String maPhieu;
    private int idHd;
    private int phanTram;
    private String ngayTao;
    private String ngayHetHan;
    private int trangThai;

    // Constructors, getters, and setters
    public phieuGiamGia() {}

    public phieuGiamGia(String maPhieu, int idHd, int phanTram, String ngayTao, String ngayHetHan, int trangThai) {
        this.maPhieu = maPhieu;
        this.idHd = idHd;
        this.phanTram = phanTram;
        this.ngayTao = ngayTao;
        this.ngayHetHan = ngayHetHan;
        this.trangThai = trangThai;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public int getIdHd() {
        return idHd;
    }

    public void setIdHd(int idHd) {
        this.idHd = idHd;
    }

    public int getPhanTram() {
        return phanTram;
    }

    public void setPhanTram(int phanTram) {
        this.phanTram = phanTram;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(String ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}