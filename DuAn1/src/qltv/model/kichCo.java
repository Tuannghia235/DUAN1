package qltv.model;

public class kichCo {
    private int id;
    private String ma;
    private int inch;

    public kichCo(int id, int inch) {
        this.id = id;
        this.inch = inch;
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

    public int getInch() {
        return inch;
    }

    public void setInch(int inch) {
        this.inch = inch;
    }

    public kichCo(int id, String ma, int inch) {
        this.id = id;
        this.ma = ma;
        this.inch = inch;
    }

    public kichCo() {
    }

    public kichCo(String ma, int inch) {
        this.ma = ma;
        this.inch = inch;
    }
    
    public Object[] toDataRow(){
        return new Object[]{
            this.getId(),
            this.getMa(),
            this.getInch()
        };
    }
}
