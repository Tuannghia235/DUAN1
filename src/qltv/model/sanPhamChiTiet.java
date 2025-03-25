package qltv.model;

public class sanPhamChiTiet {

    private int id;
    private String ma;
    private int id_sp;
    private int soLuong;
    private int donGia;
    private int id_thuongHieu;
    private int id_kieuDang;
    private int id_manHinh;
    private int id_kichCo;
    private int id_phanGiai;
    private int id_loai;
    private boolean trangThai;

    private sanPham sp;

    public sanPham getSp() {
        return sp;
    }

    public void setSp(sanPham sp) {
        this.sp = sp;
    }
    private thuongHieu thuongHieu;
    private kieuDang kieuDang;
    private loai loai;
    private kichCo kichCo;
    private manHinh manHinh;
    private doPhanGiai doPhanGiai;

    public sanPhamChiTiet() {
    }

    public sanPhamChiTiet(String ma, int id_sp, int soLuong, int donGia, int id_thuongHieu, int id_kieuDang, int id_manHinh, int id_kichCo, int id_phanGiai, int id_loai, boolean trangThai) {
        this.ma = ma;
        this.id_sp = id_sp;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.id_thuongHieu = id_thuongHieu;
        this.id_kieuDang = id_kieuDang;
        this.id_manHinh = id_manHinh;
        this.id_kichCo = id_kichCo;
        this.id_phanGiai = id_phanGiai;
        this.id_loai = id_loai;
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

    public int getId_sp() {
        return id_sp;
    }

    public void setId_sp(int id_sp) {
        this.id_sp = id_sp;
    }

    public int getId_thuongHieu() {
        return id_thuongHieu;
    }

    public void setId_thuongHieu(int id_thuongHieu) {
        this.id_thuongHieu = id_thuongHieu;
    }

    public int getId_kieuDang() {
        return id_kieuDang;
    }

    public void setId_kieuDang(int id_kieuDang) {
        this.id_kieuDang = id_kieuDang;
    }

    public int getId_loai() {
        return id_loai;
    }

    public void setId_loai(int id_loai) {
        this.id_loai = id_loai;
    }

    public int getId_kichCo() {
        return id_kichCo;
    }

    public void setId_kichCo(int id_kichCo) {
        this.id_kichCo = id_kichCo;
    }

    public int getId_manHinh() {
        return id_manHinh;
    }

    public void setId_manHinh(int id_manHinh) {
        this.id_manHinh = id_manHinh;
    }

    public int getId_phanGiai() {
        return id_phanGiai;
    }

    public void setId_phanGiai(int id_phanGiai) {
        this.id_phanGiai = id_phanGiai;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public thuongHieu getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(thuongHieu thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public kieuDang getKieuDang() {
        return kieuDang;
    }

    public void setKieuDang(kieuDang kieuDang) {
        this.kieuDang = kieuDang;
    }

    public loai getLoai() {
        return loai;
    }

    public void setLoai(loai loai) {
        this.loai = loai;
    }

    public kichCo getKichCo() {
        return kichCo;
    }

    public void setKichCo(kichCo kichCo) {
        this.kichCo = kichCo;
    }

    public manHinh getManHinh() {
        return manHinh;
    }

    public void setManHinh(manHinh manHinh) {
        this.manHinh = manHinh;
    }

    public doPhanGiai getDoPhanGiai() {
        return doPhanGiai;
    }

    public void setDoPhanGiai(doPhanGiai doPhanGiai) {
        this.doPhanGiai = doPhanGiai;
    }

    public Object[] toDataRow() {
        return new Object[]{
            this.getId(),
            this.getMa(),
            this.getSp().getTen(),
            this.getSoLuong(),
            this.getDonGia(),
            this.getThuongHieu().getTen(),
            this.getKieuDang().getTen(),
            this.getManHinh().getTen(),
            this.getKichCo().getInch(),
            this.getDoPhanGiai().getTen(),
            this.getLoai().getTen(),
            this.isTrangThai()  ? "Hoạt động" : "Không hoạt động"
        };
    }
}
