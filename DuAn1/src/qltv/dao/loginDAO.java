package qltv.dao;

import qltv.model.nhanVien;


public interface loginDAO {
    public boolean checkMa(String ma);
    public boolean checkPass(String pass,String ma);
    public int addAccount(nhanVien nv);
    public String getMatKhau(String ma,int so);
}
