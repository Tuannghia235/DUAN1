package qltv.service;

import qltv.model.nhanVien;


public interface loginService {
    public boolean checkMa(String ma);
    public boolean checkPass(String pass,String ma);
    public int addAccount(nhanVien nv);
    public String getMatKhau(String ma, int so);
}
