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
import java.util.logging.Level;
import java.util.logging.Logger;
import quanlybanhang.connectDB.ConnectDB;
import quanlybanhang.enity.ChiTietHoaDon;
import quanlybanhang.enity.GiaTien;
import quanlybanhang.enity.ThucUong;

/**
 *
 * @author admin
 */
public class DaoThucUong {

    public ArrayList<ThucUong> layDanhSachThucUong() {
        String sqlDoAn = "SELECT *FROM DOAN_THUCUONG,GIATIEN WHERE DOAN_THUCUONG.MATHUCUONG=GIATIEN.MATHUCUONG AND GIATIEN.NGAYCAPNHAP >=ALL(SELECT GIATIEN.NGAYCAPNHAP fROM GIATIEN WHERE GIATIEN.MATHUCUONG=DOAN_THUCUONG.MATHUCUONG)";
        ArrayList<ThucUong> danh_sach_thuc_uong = new ArrayList<>();
        ConnectDB conn = new ConnectDB();
        try {
            PreparedStatement ps = conn.connect().prepareStatement(sqlDoAn);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThucUong food = new ThucUong();
                GiaTien gia = new GiaTien();
                gia.setId(rs.getInt("ID_GIA"));
                gia.setGiathucuong(rs.getLong("GIA"));
                // gia.setNgaycapnhat(rs.getDate("NGAYCAPNHAT").toString());
                food.setMathucuong(rs.getString("MATHUCUONG"));
                food.setTenthucuong(rs.getString("TENTHUCUONG"));
                food.setGia(gia);
                danh_sach_thuc_uong.add(food);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
        }
        return danh_sach_thuc_uong;
    }

    public int insert(ThucUong tu) {
        String sqlDoAn = "INSERT INTO DOAN_THUCUONG (MATHUCUONG,TENTHUCUONG) VALUES(?,?) ";
        ConnectDB conn = new ConnectDB();
        int trangthai = 0;
        try {
            PreparedStatement ps = conn.connect().prepareStatement(sqlDoAn);

            ps.setString(1, tu.getMathucuong());
            ps.setString(2, tu.getTenthucuong());
            DaoGia daogia = new DaoGia();
            int kq = daogia.Insert(tu.getGia(), tu.getMathucuong());
            if (ps.executeUpdate() != 0 && kq != 0) {
                trangthai = 1;
            }
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

    public ThucUong layThucUongTheoMaTU(String MaThucUong){
        String sql="SELECT *FROM DOAN_THUCUONG WHERE DOAN_THUCUONG.MATHUCUONG=?";
        ConnectDB conn = new ConnectDB();
        ThucUong thucuong =new ThucUong();
        DaoGia daogiatien= new DaoGia();
        daogiatien.giatien(MaThucUong);
        int trangthai = 0;
        try {
            PreparedStatement ps = conn.connect().prepareStatement(sql);
            ps.setString(1,MaThucUong);
            ResultSet rs =ps.executeQuery();
            while (rs.next()){
                thucuong.setMathucuong(rs.getString("MATHUCUONG"));
                thucuong.setTenthucuong(rs.getString("TENTHUCUONG"));
            }
        }
         catch (SQLException ex) {
             ex.printStackTrace();
        }
        return thucuong;
    }
    public int update(ThucUong tu) {
        String sql = "update DOAN_THUCUONG SET TENTHUCUONG=? WHERE MATHUCUONG=?";
        ConnectDB conn = new ConnectDB();
        DaoGia Gia=new DaoGia();
        int trangthai = 0;
        try {
            PreparedStatement ps = conn.connect().prepareStatement(sql);
            ps.setString(2, tu.getMathucuong());
            ps.setString(1, tu.getTenthucuong());
            if( ps.executeUpdate() !=0 && Gia.Insert(tu.getGia(),tu.getMathucuong()) !=0){
                trangthai=1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
        }

        return trangthai;
    }

    public int delete(String mathucuong) {
        String sql = "DELETE DOAN_THUCUONG where MATHUCUONG=?";
        ConnectDB conn = new ConnectDB();
        int trangthai = 0;
        try {
            PreparedStatement ps = conn.connect().prepareStatement(sql);
            ps.setString(1, mathucuong);
            trangthai = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trangthai;
    }
    public ThucUong layThucUongTheoMaThucUong(ChiTietHoaDon cthd){
        String sql ="SELECT *FROM DOAN_THUCUONG WHERE DOAN_THUCUONG.MATHUCUONG=?";
         ConnectDB conn = new ConnectDB();
         ThucUong tu =new ThucUong();
        try {
            PreparedStatement ps = conn.connect().prepareStatement(sql);
            ps.setString(1, cthd.getThucuong().getMathucuong());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                tu.setMathucuong(rs.getString("MATHUCUONG"));
                tu.setTenthucuong(rs.getString("TENTHUCUONG"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tu;
    }

    public static void main(String[] args) {
        DaoThucUong daothucuong = new DaoThucUong();
        ArrayList<ThucUong> list = new ArrayList<>();
        ThucUong tu =new ThucUong();
        long gia =20000;
        GiaTien giatien =new GiaTien();
        giatien.setGiathucuong(gia);
        tu.setGia(giatien);
        tu.setMathucuong("TU20226");
        tu.setTenthucuong("BẠC XĨU NÓNG HỔI");
     //    Gia.Insert(tu.getGia(),tu.getMathucuong()) !=0
        

    }
}
