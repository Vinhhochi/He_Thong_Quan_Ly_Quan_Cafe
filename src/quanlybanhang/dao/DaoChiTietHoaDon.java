/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlybanhang.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class DaoChiTietHoaDon {

    public List<ChiTietHoaDon> getChiTietHoaDonTheoMaHoaDon(HoaDon hoadon) {
        String sql = "SELECT *FROM CHITIETHOADON WHERE MAHOADON =?";

        ArrayList<ChiTietHoaDon> chi_tiet_hoa_don = new ArrayList<>();
        DaoThucUong daothucuong = new DaoThucUong();
        ConnectDB conn = new ConnectDB();
        try {
            PreparedStatement ps = conn.connect().prepareStatement(sql);
            ps.setString(1, hoadon.getMahoadon());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                ThucUong thucuong = new ThucUong();
                GiaTien gia = new GiaTien();
                thucuong.setMathucuong(rs.getString("MATHUCUONG"));
                gia.setId(rs.getInt("ID_GIA"));
                thucuong.setGia(gia);
                cthd.setSl(rs.getInt("SL"));
                cthd.setThucuong(thucuong);
                chi_tiet_hoa_don.add(cthd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
        }

        return chi_tiet_hoa_don;
    }

    public int Insert_ChiTietHoaDonChoHD(HoaDon hd) {
        String sql = "INSERT INTO CHITIETHOADON (MAHOADON,MATHUCUONG,SL,ID_GIA) VALUES (?,?,?,?)";
        ConnectDB conn = new ConnectDB();
        int trangthai = 0;
        try {
            PreparedStatement ps = conn.connect().prepareStatement(sql);
            for (ChiTietHoaDon values : hd.getChitiethoadon()) {
                ps.setString(1, hd.getMahoadon());
                ps.setString(2, values.getThucuong().getMathucuong());
                ps.setInt(3, values.getSl());
                ps.setInt(4, values.getThucuong().getGia().getId());
                if (ps.executeUpdate() != 0) {
                    trangthai = 1;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trangthai;
    }

}
