/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlybanhang.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import quanlybanhang.connectDB.ConnectDB;
import quanlybanhang.enity.Ban;
import quanlybanhang.enity.ChiTietHoaDon;
import quanlybanhang.enity.GiaTien;
import quanlybanhang.enity.HoaDon;
import quanlybanhang.enity.ThucUong;

/**
 *
 * @author admin
 */
public class DaoHoaDon {

    public List<ChiTietHoaDon> layChiTietHoaDonTheoBan(int id_ban) {
        String sql = "SELECT *FROM BAN,HOADON,CHITIETHOADON,DOAN_THUCUONG, GIATIEN\n"
                + "	WHERE HOADON.MAHOADON=CHITIETHOADON.MAHOADON\n"
                + "	and CHITIETHOADON.MATHUCUONG=DOAN_THUCUONG.MATHUCUONG\n"
                + "	AND BAN.ID_BAN =HOADON.ID_BAN\n"
                + "	AND GIATIEN.ID_GIA =CHITIETHOADON.ID_GIA\n"
                + "	AND HOADON.TRANGTHAI=1\n"
                + "	AND HOADON.ID_BAN=?";

        ArrayList<ChiTietHoaDon> chi_tiet_hoa_don = new ArrayList<>();

        ConnectDB conn = new ConnectDB();
        try {
            PreparedStatement ps = conn.connect().prepareStatement(sql);
            ps.setInt(1, id_ban);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                ThucUong tu = new ThucUong();
                GiaTien giatien = new GiaTien();

                tu.setMathucuong(rs.getString("MATHUCUONG"));
                tu.setTenthucuong(rs.getString("TENTHUCUONG"));

                giatien.setId(rs.getInt("ID_GIA"));
                giatien.setGiathucuong(rs.getLong("GIA"));

                tu.setGia(giatien);

                cthd.setSl(rs.getInt("SL"));
                cthd.setThucuong(tu);

                chi_tiet_hoa_don.add(cthd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
        }
        // return danh_sach_thuc_uong;
        return chi_tiet_hoa_don;
    }

    public List<HoaDon> danhSachHoaDonTheoBan(Ban ban) {
        String sql = "select *from Ban,HoaDon,CHITIETHOADON,DOAN_THUCUONG,GIATIEN\n"
                + "	where Ban.ID_BAN=HOADON.ID_BAN \n"
                + "	and	  HOADON.MAHOADON=CHITIETHOADON.MAHOADON\n"
                + "	and	  CHITIETHOADON.MATHUCUONG=DOAN_THUCUONG.MATHUCUONG\n"
                + "	and	  CHITIETHOADON.ID_GIA=GIATIEN.ID_GIA"
                + "and BAN.ID_BAN=?";
        ArrayList<HoaDon> hoa_don = new ArrayList<>();
        ArrayList<ChiTietHoaDon> cthd = new ArrayList<>();
        ConnectDB conn = new ConnectDB();
        try {
            PreparedStatement ps = conn.connect().prepareStatement(sql);
            ps.setInt(1, ban.getId_ban());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hoadon = new HoaDon();
                hoadon.setMahoadon(rs.getString("MAHOADON"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
        }
        // return danh_sach_thuc_uong;
        return null;
    }

    public int Insert(HoaDon hd) {
        String sql = "INSERT INTO CHITIETHOADON (MAHOADON,MATHUCUONG,SL,ID_GIA) VALUES(?,?,?,?)";
        ConnectDB conn = new ConnectDB();
        int trangthai = 1;
        for (ChiTietHoaDon value : hd.getChitiethoadon()) {
            try {
                PreparedStatement ps = conn.connect().prepareStatement(sql);
                ps.setString(1, hd.getMahoadon());
                ps.setString(2, value.getThucuong().getMathucuong());
                ps.setInt(3, value.getSl());
                ps.setInt(4, value.getThucuong().getGia().getId());
                //ps.setInt(5,hd.get);
                if (ps.executeUpdate() == 0) {
                    trangthai = 0;
                    break;
                };
            } catch (SQLException ex) {
                Logger.getLogger(DaoNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return trangthai;
    }

    public int update(HoaDon hd) {
        String sql = "UPDATE CHITIETHOADON SET SL =SL+? WHERE MAHOADON =? and MATHUCUONG =? ";
        ConnectDB conn = new ConnectDB();
        int trangthai = 1;
        for (ChiTietHoaDon value : hd.getChitiethoadon()) {
            try {
                PreparedStatement ps = conn.connect().prepareStatement(sql);
                ps.setInt(1, value.getSl());
                ps.setString(2, hd.getMahoadon());
                ps.setString(3, value.getThucuong().getMathucuong());
                //ps.setInt(5,hd.get);
                if (ps.executeUpdate() == 0) {
                    trangthai = 0;
                    break;
                };
            } catch (SQLException ex) {
                Logger.getLogger(DaoNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return trangthai;
    }

    public int updateTrangThai(HoaDon hd) {
        String sql = "UPDATE HOADON SET TRANGTHAI = 0 WHERE MAHOADON=?";
        ConnectDB conn = new ConnectDB();
        int trangthai = 0;
        try {
            PreparedStatement ps = conn.connect().prepareStatement(sql);
            ps.setString(1,hd.getMahoadon());
            if(ps.executeUpdate() != 0){
                trangthai = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trangthai;
    }
    public static void main(String[] args) {
        DaoHoaDon dao =new DaoHoaDon();
        HoaDon hd =new HoaDon();
        hd.setMahoadon("HD202222");
        dao.updateTrangThai(hd);
    }
}
