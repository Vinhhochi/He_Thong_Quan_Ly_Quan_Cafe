/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlybanhang.enity;

/**
 *
 * @author admin
 */
public class ChiTietHoaDon {
    private int sl;
    private ThucUong thucuong;
    
    public ChiTietHoaDon(){
        this.sl=0;
        this.thucuong=new ThucUong();
    }

    public ChiTietHoaDon(int sl, ThucUong thucuong) {
        this.sl = sl;
        this.thucuong = thucuong;
    }

    public int getSl() {
        return sl;
    }

    public ThucUong getThucuong() {
        return thucuong;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public void setThucuong(ThucUong thucuong) {
        this.thucuong = thucuong;
    }
}
