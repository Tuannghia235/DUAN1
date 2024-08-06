/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qltv.model;

/**
 *
 * @author tuann
 */
public class nhanVien {
     private int id;

    public nhanVien(String ma, String ten, String soDienThoai, String pass) {
        this.ma = ma;
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.pass = pass;
    }

    public nhanVien(String ma, String ten, String soDienThoai, String email, String pass, int gioiTinh, int chucVu, int trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.pass = pass;
        this.gioiTinh = gioiTinh;
        this.chucVu = chucVu;
        this.trangThai = trangThai;
    }
    private String ma;

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }
    private String ten;
    private String soDienThoai;
    private String email;
    private String pass;
    private int gioiTinh;
    private int chucVu;
    private int trangThai;

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

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getChucVu() {
        return chucVu;
    }

    public void setChucVu(int chucVu) {
        this.chucVu = chucVu;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public nhanVien() {
    }

    public nhanVien(int id, String ten, String soDienThoai, String email, String pass, int gioiTinh, int chucVu, int trangThai) {
        this.id = id;
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.pass = pass;
        this.gioiTinh = gioiTinh;
        this.chucVu = chucVu;
        this.trangThai = trangThai;
    }

    public nhanVien(String ten, String soDienThoai, String email, String pass, int gioiTinh, int chucVu, int trangThai) {
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.pass = pass;
        this.gioiTinh = gioiTinh;
        this.chucVu = chucVu;
        this.trangThai = trangThai;
    }
}