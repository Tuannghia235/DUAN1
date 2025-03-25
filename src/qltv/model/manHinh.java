package qltv.model;


public class manHinh {
    private int id;
    private String ma;
    private String ten;

    public manHinh(int id, String ma, String ten) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
    }

    public manHinh(int id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public manHinh() {
    }

    public manHinh(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
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
    
    public Object[] toDataRow(){
        return new Object[]{
            this.getId(),
            this.getMa(),
            this.getTen()
        };
    }
}
