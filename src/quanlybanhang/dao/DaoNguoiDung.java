/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlybanhang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import quanlybanhang.connectDB.ConnectDB;
import quanlybanhang.enity.NguoiDung;

/**
 *
 * @author admin
 */
public class DaoNguoiDung {
    
    public NguoiDung layTaiKhoan (String taikhoan) throws ClassNotFoundException{
        ConnectDB conn =new ConnectDB();
        NguoiDung nd =new NguoiDung();
        String sql="Select * from nguoidung where taikhoan=?";
        try {
            
            PreparedStatement ps =conn.connect().prepareStatement(sql);
            ps.setString(1,taikhoan);
            ResultSet rs =ps.executeQuery();
            while(rs.next()){
                nd.setHoten(rs.getString("HOVATEN"));
                nd.setTaikhoan(rs.getString("TAIKHOAN"));
                nd.setMatkhau(rs.getString("MATKHAU"));
                nd.setNamsinh(rs.getString("NAMSINH"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return nd;
    }
    public static void main(String[] args) {
        try {
            DaoNguoiDung nd =new DaoNguoiDung();
            NguoiDung ND= nd.layTaiKhoan("vinhoccac");
            System.out.print(ND.getHoten());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
