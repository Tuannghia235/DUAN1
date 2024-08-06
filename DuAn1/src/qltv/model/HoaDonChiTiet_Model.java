/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qltv.model;

/**
 *
 * @author PC
 */
public class HoaDonChiTiet_Model {
    private Integer Id;
    private int id_hd;
    private int id_spct;
    private String tenSanPham;
    private Integer SoLuong;
    private Integer tongTien;

    public HoaDonChiTiet_Model() {
    }

    public HoaDonChiTiet_Model(Integer Id, int id_hd, int id_spct, String tenSanPham, Integer SoLuong, Integer tongTien) {
        this.Id = Id;
        this.id_hd = id_hd;
        this.id_spct = id_spct;
        this.tenSanPham = tenSanPham;
        this.SoLuong = SoLuong;
        this.tongTien = tongTien;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
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

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public Integer getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(Integer SoLuong) {
        this.SoLuong = SoLuong;
    }

    public Integer getTongTien() {
        return tongTien;
    }

    public void setTongTien(Integer tongTien) {
        this.tongTien = tongTien;
    }

    
}
