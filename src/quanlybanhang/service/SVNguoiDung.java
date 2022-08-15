/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlybanhang.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import quanlybanhang.dao.DaoNguoiDung;
import quanlybanhang.enity.NguoiDung;

/**
 *
 * @author admin
 */
public class SVNguoiDung {
    private DaoNguoiDung Daond;
    
    public  SVNguoiDung(){
        Daond=new DaoNguoiDung();
    }
    
    public static String charArrayToString(char[] a){
        String b ="";
        for(int i=0; i<a.length;i++){
            b=b.concat(Character.toString(a[i]));
        }
        return b;
    }
    public boolean kiemTraTaiKhoan(String tk, char[] mk){
        NguoiDung nd =new NguoiDung();
        String mkString=SVNguoiDung.charArrayToString(mk);
        try {
            nd=Daond.layTaiKhoan(tk);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SVNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(tk.equals(nd.getTaikhoan().trim())==true && mkString.equals(nd.getMatkhau())==true){
            return true;
        } 
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        SVNguoiDung svn =new SVNguoiDung();
        char[] a ={'1','2'};
        String  b=SVNguoiDung.charArrayToString(a);
//        System.out.println(svn.kiemTraTaiKhoan("HINGUOIANHEM",a));
        System.out.print(b);
        
    }
  
}
