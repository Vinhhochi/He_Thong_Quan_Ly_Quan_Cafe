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
public class NguoiDung {
    private String taikhoan;
    private String matkhau;
    private String hoten;
    private String namsinh;

    
    public NguoiDung(String taikhoan, String matkhau, String hoten, String namsinh) {
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.hoten = hoten;
        this.namsinh = namsinh;
    }

    public NguoiDung() {
        this.taikhoan="";
        this.matkhau="";
        this.hoten="";
        this.namsinh="";//To change body of generated methods, choose Tools | Templates.
    }
    
    public String getTaikhoan() {
        return taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }

    public String getHoten() {
        return hoten;
    }

    public String getNamsinh() {
        return namsinh;
    }
}
