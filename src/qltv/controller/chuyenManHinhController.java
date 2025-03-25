package qltv.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import qltv.bean.danhMucBean;
import qltv.view.banHangJPanel;
import qltv.view.hoaDonJPanel;
import qltv.view.khachHangJPanel;
import qltv.view.login;
import qltv.view.nhanVienJPanel;
import qltv.view.phieuGiamGiaJPanel;
import qltv.view.sanPhamJPanel;

/**
 *
 * @author tuann
 */
public class chuyenManHinhController {

    private JPanel root;
    private String kindSelected = "";

    private List<danhMucBean> listItem = null;

    public chuyenManHinhController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "BanHang";
        jpnItem.setBackground(new Color(96, 100, 191));
        jlbItem.setBackground(new Color(96, 100, 191));
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new banHangJPanel());
        root.validate();
        root.repaint();
    }

    public void setEvent(List<danhMucBean> listItem) {
        this.listItem = listItem;
        for (danhMucBean item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                switch (kind) {
                    case "BanHang":
                        node = new banHangJPanel();
                        break;
                    case "HoaDon":
                        node = new hoaDonJPanel();
                        break;
                    case "SanPham":
                        node = new sanPhamJPanel();
                        break;
                    case "PhieuGiamGia":
                        node = new phieuGiamGiaJPanel();
                        break;
                    case "KhachHang":
                        node = new khachHangJPanel();
                        break;
                    case "NhanVien":
                        node = new nhanVienJPanel();
                        break;
                    case "DangXuat":
                        int confirm = JOptionPane.showConfirmDialog(null,
                                "Bạn có chắc chắn muốn thoát?", "Xác nhận",
                                JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) {
                            root.getTopLevelAncestor().setVisible(false);
                            new login().setVisible(true);
                        }
                        return;
                    default:
                        break;
                }
                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(node);
                root.validate();
                root.repaint();
                setChangeBackground(kind);

            } catch (SQLException ex) {
                Logger.getLogger(chuyenManHinhController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(24, 159, 206));
                jlbItem.setBackground(new Color(24, 159, 206));
            }
        }

    }

    private void setChangeBackground(String kind) {
        for (danhMucBean item : listItem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(96, 100, 191));
                item.getJlb().setBackground(new Color(96, 100, 191));
            } else {
                item.getJpn().setBackground(new Color(24, 159, 206));
                item.getJlb().setBackground(new Color(24, 159, 206));
            }
        }
    }
}
