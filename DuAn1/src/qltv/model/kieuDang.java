/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qltv.model;

/**
 *
 * @author tuann
 */
public class kieuDang {
    private int id;
    private String ma;
    private String ten;

    public kieuDang(int id, String ten) {
        this.id = id;
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

    public kieuDang(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public kieuDang(int id, String ma, String ten) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
    }

    public kieuDang() {
    }
    
    public Object[] toDataRow(){
        return new Object[]{
            this.getId(),
            this.getMa(),
            this.getTen()
        };
    }
}
