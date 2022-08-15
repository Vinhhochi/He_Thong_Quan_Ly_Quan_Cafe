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
public class ThucUong {
    private String mathucuong;
    private String tenthucuong;
    private GiaTien gia;

    public  ThucUong(){
        mathucuong="";
        tenthucuong="";
        gia =new GiaTien();
}
    public String getMathucuong() {
        return mathucuong;
    }

    public String getTenthucuong() {
        return tenthucuong;
    }

    public void setMathucuong(String mathucuong) {
        this.mathucuong = mathucuong;
    }

    public void setTenthucuong(String tenthucuong) {
        this.tenthucuong = tenthucuong;
    }

    public ThucUong(String mathucuong, String tenthucuong,GiaTien gia) {
        this.mathucuong = mathucuong;
        this.tenthucuong = tenthucuong;
        this.gia =gia;
    }

    public void setGia(GiaTien gia) {
        this.gia = gia;
    }

    public GiaTien getGia() {
        return gia;
    }
    
    public void capNhatGia(long giamoi){
        gia.capNhatGia(giamoi);
    }
   
}
