/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlybanhang.service;

import static java.awt.image.ImageObserver.ABORT;
import java.util.ArrayList;
import java.util.List;
import quanlybanhang.dao.DaoBan;
import quanlybanhang.enity.Ban;

/**
 *
 * @author admin
 */
public class SVBan {
    private DaoBan daoban;
    
    public SVBan (){
        daoban =new DaoBan();
    }
    public int themBan(Ban bn){
       if( kiemTraBanTonTai(bn)==0){
           return daoban.Insert(bn);
       }
       return 0;
    }
    public List<Ban> danhSachBan(){
        return daoban.danhSachBan();
    }
    
    public int kiemTraBanTonTai(Ban ban){
        
        int kt=0;
        List<Ban> danh_sach_ban =new ArrayList<>();
        danh_sach_ban =daoban.danhSachBan();
        
        for(Ban value: danh_sach_ban){
            if(ban.getSoBan()==value.getSoBan()){
                kt=1;
                break;
            }
        }
        return kt;
    }
    public int suaBan(Ban ban){
        if(kiemTraBanTonTai(ban)==0){
            return daoban.update(ban);
        }
        else {
            return 0;
        }
    }
      public String laySoBan(String tenban){
        int index =tenban.lastIndexOf(" ");
        index++;
        String a = "";
        for(int i=index; i<tenban.length(); i++ ){
            a=a.concat(Character.toString(tenban.charAt(i)));
        }
        return a;
    }
     public int xoaBan( Ban ban){
         return daoban.delete(ban);
     }
     public int taoHoaDonChoBan(Ban ban){
         return daoban.Insert_HoaDonChoBan(ban);
     }
     public List<Ban> danhsachban_hoadon(){
         return  daoban.danhSachBanVaHoaDon();
     }
    public static void main(String[] args) {
//        List<Ban> danh_sach_ban =new ArrayList<>();
//        Ban BAN =new Ban();
//        BAN.setBan(4);
//        SVBan ban =new SVBan();
//        danh_sach_ban =ban.danhSachBan();
//        System.out.print(ban.suaBan(BAN));
          SVBan ban =new SVBan();
          System.out.print(ban.danhsachban_hoadon().get(1).getId_ban());
    }
    
}
