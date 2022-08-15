/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlybanhang.service;

import quanlybanhang.dao.DaoChiTietHoaDon;
import quanlybanhang.enity.HoaDon;

/**
 *
 * @author admin
 */
public class SVChitiethoadon {
    private DaoChiTietHoaDon dao;
    
    public SVChitiethoadon(){
        dao =new DaoChiTietHoaDon();
    }
    public int capNhatChiTietHoaDon(HoaDon hd){
        return dao.Insert_ChiTietHoaDonChoHD(hd);
    }
}
