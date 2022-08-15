/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlybanhang.service;

import java.util.List;
import quanlybanhang.dao.DaoChiTietHoaDon;
import quanlybanhang.dao.DaoHoaDon;
import quanlybanhang.enity.ChiTietHoaDon;
import quanlybanhang.enity.HoaDon;

/**
 *
 * @author admin
 */
public class SVHoaDon {
    private DaoHoaDon dao;
    public SVHoaDon(){
        dao =new DaoHoaDon();
    }
    public int taoHoaDon(HoaDon hd){
       return dao.Insert(hd);
    }
    public List<ChiTietHoaDon> layChiTietHoaDonTheoBan( int idban){
        return dao.layChiTietHoaDonTheoBan(idban);
    }
    public int capNhatHoaDon(HoaDon hd){
        return dao.updateTrangThai(hd);
    }
    public static void main(String[] args) {
        String a[][] =new String[1000][2];
        SVHoaDon sv =new SVHoaDon(); 
        System.out.print(sv.layChiTietHoaDonTheoBan(1));
    }
    
}
