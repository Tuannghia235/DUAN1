
package qltv.model;

public class ChiTietSP_Model {
    private Integer Id;
    private String tenSanPham;
    private Integer donGia;
    private String doPhanGiai;
    private Integer kichCo;
    private String thuongHieu;
    private Integer SoLuongTon;

    public ChiTietSP_Model() {
    }

    public ChiTietSP_Model(Integer Id, String tenSanPham, Integer donGia, String doPhanGiai, Integer kichCo, String thuongHieu, Integer SoLuongTon) {
        this.Id = Id;
        this.tenSanPham = tenSanPham;
        this.donGia = donGia;
        this.doPhanGiai = doPhanGiai;
        this.kichCo = kichCo;
        this.thuongHieu = thuongHieu;
        this.SoLuongTon = SoLuongTon;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public Integer getDonGia() {
        return donGia;
    }

    public void setDonGia(Integer donGia) {
        this.donGia = donGia;
    }

    public String getDoPhanGiai() {
        return doPhanGiai;
    }

    public void setDoPhanGiai(String doPhanGiai) {
        this.doPhanGiai = doPhanGiai;
    }

    public Integer getKichCo() {
        return kichCo;
    }

    public void setKichCo(Integer kichCo) {
        this.kichCo = kichCo;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public Integer getSoLuongTon() {
        return SoLuongTon;
    }

    public void setSoLuongTon(Integer SoLuongTon) {
        this.SoLuongTon = SoLuongTon;
    }

    
}
