package qltv.model;


public class khachHang {
    private int id;
    private String maKH;
    private String ten;
    private String soDienThoai;
    private String diaChi;
    private int gioiTinh;
    private String ngaySinh;
    
    public khachHang() {
    }

    public khachHang(String maKH, String ten, String soDienThoai, String diaChi, int gioiTinh, String ngaySinh) {
        this.maKH = maKH;
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
    }
    
    public khachHang(int id, String maKH, String ten, String soDienThoai, String diaChi, int gioiTinh, String ngaySinh) {
        this.id = id;
        this.maKH = maKH;
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
    }

    public khachHang(String ten, String soDienThoai, String diaChi, int gioiTinh, String ngaySinh) {
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
}
