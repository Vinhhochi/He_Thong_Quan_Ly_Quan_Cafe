/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlybanhang.enity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class HoaDon {
    private String mahoadon;
    private SimpleDateFormat date;
    private String ghichu;
    private int trangthai;
    private List<ChiTietHoaDon> chitiethoadon;

    public HoaDon(String mahoadon, SimpleDateFormat date, String ghichu, int trangthai, List<ChiTietHoaDon> chitiethoadon) {
        this.mahoadon = mahoadon;
        this.date = date;
        this.ghichu = ghichu;
        this.trangthai = trangthai;
        this.chitiethoadon = chitiethoadon;
    }
    
    public HoaDon(){
        this.mahoadon="";
        this.date=new SimpleDateFormat("dd-MM-yy");
        this.ghichu="";
        trangthai=0;
        chitiethoadon=new ArrayList<>(); 
    }

    public List<ChiTietHoaDon> getChitiethoadon() {
        return chitiethoadon;
    }

    public void setChiTietHoaDon(List<ChiTietHoaDon> ct){
        this.chitiethoadon=ct;
    }
    public String getMahoadon() {
        return mahoadon;
    }

    public SimpleDateFormat getDate() {
        return date;
    }

    public String getGhichu() {
        return ghichu;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setMahoadon(String mahoadon) {
        this.mahoadon = mahoadon;
    }

    public void setDate(SimpleDateFormat date) {
        this.date = date;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    
}
