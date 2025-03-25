package qltv.service;

import qltv.dao.loginDAO;
import qltv.dao.loginDAOImpl;
import qltv.model.nhanVien;


public class loginServiceImpl implements loginService{

    private loginDAO loginDAO = null;
    
    public loginServiceImpl() {
        loginDAO = new loginDAOImpl();
    }
    @Override
    public boolean checkMa(String ma) {
        return loginDAO.checkMa(ma);
    }

    @Override
    public boolean checkPass(String pass,String ma) {
        return loginDAO.checkPass(pass,ma);
    }

    @Override
    public int addAccount(nhanVien nv) {
        return loginDAO.addAccount(nv);
    }

    @Override
    public String getMatKhau(String ma, int so) {
        return loginDAO.getMatKhau(ma, so);
    }
    
}
