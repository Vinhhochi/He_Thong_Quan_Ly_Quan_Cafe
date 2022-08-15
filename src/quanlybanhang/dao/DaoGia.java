/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlybanhang.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import quanlybanhang.connectDB.ConnectDB;
import quanlybanhang.enity.ChiTietHoaDon;
import quanlybanhang.enity.GiaTien;

/**
 *
 * @author admin
 */
public class DaoGia {
    public int Insert (GiaTien gia, String MaThucUong){
        String sqlGia="INSERT INTO GIATIEN (MATHUCUONG,GIA,NGAYCAPNHAP) VALUES (?,?,GETDATE())";
        ConnectDB conn = new ConnectDB();
        int trangthai=0;
         try {
            PreparedStatement ps1=conn.connect().prepareStatement(sqlGia);
            ps1.setString(1,MaThucUong);
            ps1.setLong(2,gia.getGiathucuong());
           
            trangthai=ps1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
            try {
                conn.connect().rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(DaoThucUong.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return trangthai;
    }
    public GiaTien giatien(String mathucuong){
        String sql="SELECT MATHUCUONG, MAX(GIA) AS GIA FROM GIATIEN where MATHUCUONG=? GROUP BY MATHUCUONG";
        GiaTien giatien =new GiaTien();
        ConnectDB conn = new ConnectDB();
         try {
            PreparedStatement ps=conn.connect().prepareStatement(sql);
            ps.setString(1,mathucuong);
            ResultSet rs =ps.executeQuery();
            while (rs.next()){
                giatien.setId(rs.getInt("ID_GIA"));
                giatien.setGiathucuong(rs.getLong("GIA"));
                giatien.setNgaycapnhat(rs.getString("NGAYCAPNHAT"));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DaoNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
            try {
                conn.connect().rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(DaoThucUong.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return giatien;
    }
    public GiaTien layGiaTienTheoId(ChiTietHoaDon cthd){
        String sql ="select *from CHITIETHOADON where CHITIETHOADON.ID_GIA=?";
        GiaTien giatien =new GiaTien();
        ConnectDB conn = new ConnectDB();
         try {
            PreparedStatement ps=conn.connect().prepareStatement(sql);
            ps.setInt(1,cthd.getThucuong().getGia().getId());
            ResultSet rs =ps.executeQuery();
            while (rs.next()){
                giatien.setId(rs.getInt("ID_GIA"));
                giatien.setGiathucuong(rs.getLong("GIA"));
                giatien.setNgaycapnhat(rs.getString("NGAYCAPNHAT"));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DaoNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
            try {
                conn.connect().rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(DaoThucUong.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return giatien;
    }
    
}
