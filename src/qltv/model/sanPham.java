package qltv.model;

public class sanPham {

    private int id;
    private String ma;
    private String ten;
    private boolean trangThai;

    public sanPham() {
    }

    public sanPham(int id, String ma, String ten, boolean trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
    }

    public sanPham(String ma, String ten, boolean trangThai) {
        this.ma = ma;
        this.ten = ten;
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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Object[] toDataRow() {
        return new Object[]{
            this.getId(),
            this.getMa(),
            this.getTen(),
            this.isTrangThai() ? "Hoạt động" : "Không hoạt động"
        };
    }

}
