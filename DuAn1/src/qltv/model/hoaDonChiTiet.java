/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qltv.model;

/**
 *
 * @author tuann
 */
public class hoaDonChiTiet {
    private int id;
    private String ma;
    private int id_hd;
    private int id_spct;
    private int soLuong;
    private int donGia;

    public hoaDonChiTiet() {
    }

    public hoaDonChiTiet(int id, String ma, int id_hd, int id_spct, int soLuong, int donGia) {
        this.id = id;
        this.ma = ma;
        this.id_hd = id_hd;
        this.id_spct = id_spct;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public hoaDonChiTiet(String ma, int id_hd, int id_spct, int soLuong, int donGia) {
        this.ma = ma;
        this.id_hd = id_hd;
        this.id_spct = id_spct;
        this.soLuong = soLuong;
        this.donGia = donGia;
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

    public int getId_hd() {
        return id_hd;
    }

    public void setId_hd(int id_hd) {
        this.id_hd = id_hd;
    }

    public int getId_spct() {
        return id_spct;
    }

    public void setId_spct(int id_spct) {
        this.id_spct = id_spct;
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
}
