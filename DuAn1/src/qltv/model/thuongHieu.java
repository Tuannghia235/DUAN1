package qltv.model;

/**
 *
 * @author tuann
 */
public class thuongHieu {
    private int id;
    private String ma;
    private String ten;
    private String nguonGoc;

    public thuongHieu() {
    }

    public thuongHieu(int id, String ma, String ten, String nguonGoc) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.nguonGoc = nguonGoc;
    }

    public thuongHieu(int id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public thuongHieu(String ma, String ten, String nguonGoc) {
        this.ma = ma;
        this.ten = ten;
        this.nguonGoc = nguonGoc;
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

    public String getNguonGoc() {
        return nguonGoc;
    }

    public void setNguonGoc(String nguonGoc) {
        this.nguonGoc = nguonGoc;
    }

    public Object[] toDataRow(){
        return new Object[]{
            this.getId(),
            this.getMa(),
            this.getTen(),
            this.getNguonGoc()
        };
    }
}
