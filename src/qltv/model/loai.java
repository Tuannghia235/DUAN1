package qltv.model;

public class loai {
    private int id;
    private String ten;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public loai(String ten) {
        this.ten = ten;
    }

    public loai(int id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public loai() {
    }
}
