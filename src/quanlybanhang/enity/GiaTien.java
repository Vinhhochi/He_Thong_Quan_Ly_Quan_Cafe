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
public class GiaTien {
    private int id;
    private long giathucuong;
    private String ngaycapnhat;

    public GiaTien(){
        this.id=0;
        this.giathucuong=0;
        this.ngaycapnhat="";
    }
    public GiaTien(int id, long giathucuong, String ngaycapnhat) {
        this.id = id;
        this.giathucuong = giathucuong;
        this.ngaycapnhat = ngaycapnhat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGiathucuong(long giathucuong) {
        this.giathucuong = giathucuong;
    }

    public void setNgaycapnhat(String ngaycapnhat) {
        this.ngaycapnhat = ngaycapnhat;
    }

    public int getId() {
        return id;
    }

    public long getGiathucuong() {
        return giathucuong;
    }

    public String getNgaycapnhat() {
        return ngaycapnhat;
    }
    public void capNhatGia(long giamoi){
        this.giathucuong=giamoi;
    }
    
    
    
}
