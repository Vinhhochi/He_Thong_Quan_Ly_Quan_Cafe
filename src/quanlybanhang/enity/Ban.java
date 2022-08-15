/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlybanhang.enity;

import java.util.ArrayList;


/**
 *
 * @author admin
 */
public class Ban {
    private int id_ban;
    private int soban;
    private HoaDon  hoadon;
    
    public Ban(){
        id_ban=0;
        this.hoadon =new HoaDon();
    }

    public int getId_ban() {
        return id_ban;
    }

    public HoaDon getHoadon() {
        return hoadon;
    }

    public void setId_ban(int id_ban) {
        this.id_ban = id_ban;
    }

    public void setHoadon(HoaDon hoadon) {
        this.hoadon = hoadon;
    }

    public Ban(int id_ban,HoaDon hoadon) {
        this.id_ban = id_ban;
        this.hoadon = hoadon;
    }
    
    public static void main(String[] args) {
        
    }

    public int getSoBan() {
        return this.soban;
    }
    
    public void setBan(int ban){
        this.soban=ban;
    }
    
}
