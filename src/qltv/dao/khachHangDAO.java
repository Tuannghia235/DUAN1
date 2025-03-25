package qltv.dao;

import java.util.List;
import qltv.model.khachHang;

public interface khachHangDAO {
    public List<khachHang> getAll();
    public int them(khachHang kh);
    public int sua(khachHang kh);
    public List<khachHang> timKiem(String input, String searchtype);
}
