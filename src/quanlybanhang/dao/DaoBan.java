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
import quanlybanhang.enity.GiaTien;
import quanlybanhang.enity.HoaDon;
import quanlybanhang.enity.ThucUong;

/**
 *
 * @author admin
 */
public class DaoBan {
    private ConnectDB conn;
    public DaoBan(){
        conn =new ConnectDB();
    }
    
    public List<Ban> danhSachBan(){
        int trangthai=0;
        String sql="SELECT *FROM BAN";
        ArrayList<Ban> Danh_sach_ban = new ArrayList<>();
        ConnectDB conn = new ConnectDB();
        try {
            PreparedStatement ps = conn.connect().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ban bn = new Ban();
                bn.setId_ban(rs.getInt("ID_BAN"));
                bn.setBan(rs.getInt("soban"));
                Danh_sach_ban.add(bn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Danh_sach_ban ;
    }
    
    public List<Ban> danhSachBanVaHoaDon(){
        String sql= "SELECT *FROM BAN LEFT JOIN HOADON ON BAN.ID_BAN=HOADON.ID_BAN WHERE  HOADON.NGAY >= ALL(SELECT NGAY FROM HOADON WHERE HOADON.ID_BAN=BAN.ID_BAN)";
        ArrayList<Ban> Danh_sach_ban = new ArrayList<>();
        ConnectDB conn = new ConnectDB();
        try {
            PreparedStatement ps = conn.connect().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd =new HoaDon();
                Ban bn = new Ban();
                
                hd.setTrangthai(rs.getInt("TRANGTHAI"));
                hd.setMahoadon(rs.getString("MAHOADON"));
                
                bn.setId_ban(rs.getInt("ID_BAN"));
                bn.setBan(rs.getInt("soban"));
                bn.setHoadon(hd);
                
                
                Danh_sach_ban.add(bn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Danh_sach_ban ;
    
    }    
    public int Insert(Ban ban){
       int trangthai=0;
        String sql="INSERT INTO BAN(soban) values (?)";
        try {
            PreparedStatement ps =this.conn.connect().prepareStatement(sql);
            ps.setInt(1, ban.getSoBan());
            trangthai = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoBan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trangthai;
    }
     public int update (Ban ban){
       int trangthai=0;
        String sql="UPDATE BAN SET soban= ? where ID_BAN= ?";
        try {
            PreparedStatement ps =this.conn.connect().prepareStatement(sql);
            ps.setInt(1, ban.getSoBan());
            ps.setInt(2, ban.getSoBan());
            trangthai = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoBan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trangthai;
    }
      public int delete (Ban ban){
       int trangthai=0;
        String sql="DELETE BAN WHERE ID_BAN=?";
        try {
            PreparedStatement ps =this.conn.connect().prepareStatement(sql);
            ps.setInt(1, ban.getId_ban());
            trangthai = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoBan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trangthai;
    }
      
    public int Insert_HoaDonChoBan(Ban ban){
        String sql ="INSERT INTO HOADON(MAHOADON,ID_BAN,NGAY,GHICHU,TRANGTHAI) VALUES (?,?,GETDATE(),?,?)";
        ConnectDB conn = new ConnectDB();
        int trangthai=0;
        
        try {
            
            PreparedStatement ps = conn.connect().prepareStatement(sql);
            ps.setString(1,ban.getHoadon().getMahoadon());
            ps.setInt(2,ban.getId_ban());
            ps.setString(3,ban.getHoadon().getGhichu());
            ps.setInt(4,ban.getHoadon().getTrangthai());
            
            if(ps.executeUpdate()!=0){
                trangthai =1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trangthai;
    }
    
}
