/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlybanhang.service;

import java.util.ArrayList;
import java.util.List;
import quanlybanhang.dao.DaoThucUong;
import quanlybanhang.enity.ThucUong;

/**
 *
 * @author admin
 */
public class SVThucUong {
    private DaoThucUong Dtt;
    public SVThucUong(){
         Dtt =new DaoThucUong();
    }
    public List<ThucUong> danhSachThucUong (){
        List<ThucUong> danhsachthucuong=new ArrayList<>();
        danhsachthucuong =Dtt.layDanhSachThucUong();
        return danhsachthucuong;
    }
    public int themThucUong(ThucUong tu){
        return Dtt.insert(tu);
    }
    public int suaThucUong(ThucUong tu){
        return Dtt.update(tu);
    }
    public int xoaThucUong(String mathucuong){
        return Dtt.delete(mathucuong);
    }
    public int capNhatThucUong(ThucUong tu){
        return Dtt.update(tu);
    }
    public static void main(String[] args) {
       List<ThucUong> danhsachthucuong =new ArrayList<>();
       SVThucUong svtu =new SVThucUong();
       danhsachthucuong =svtu.danhSachThucUong();
       System.out.print(danhsachthucuong.get(2).getTenthucuong());
    }
 
}
