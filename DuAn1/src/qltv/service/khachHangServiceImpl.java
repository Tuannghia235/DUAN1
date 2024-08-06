package qltv.service;

import java.util.List;
import qltv.dao.khachHangDAO;
import qltv.dao.khachHangDAOImpl;
import qltv.model.khachHang;


public class khachHangServiceImpl implements khachHangService{

    private khachHangDAO khachHangDAO = null;

    public khachHangServiceImpl() {
        khachHangDAO = new khachHangDAOImpl();
    }
    
    @Override
    public List<khachHang> getAll() {
        return khachHangDAO.getAll();
    }

    @Override
    public int them(khachHang kh) {
        return khachHangDAO.them(kh);
    }

    @Override
    public int sua(khachHang kh) {
        return khachHangDAO.sua(kh);
    }

    @Override
    public List<khachHang> timKiem(String input, String searchtype) {
        return khachHangDAO.timKiem(input, searchtype);
    }
    
}
