/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlybanhang.publicfunction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileWriter;   // Import the FileWriter class
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author admin
 */
public class KhoaChinh {

    private String url;

    public KhoaChinh(String url) {
        this.url = url;
    }

    public int docFile() {
        int index = 1;
        File text = new File(this.url);
        try {
            Scanner sc = new Scanner(text);
            index = sc.nextInt();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(KhoaChinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        return index;
    }

    public void ghifile(String Index) {
        try {
            FileWriter out = new FileWriter(this.url);
            out.write(Index);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(KhoaChinh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String taoKhoaChinh(String prefix_){
        String key;
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy");
        String year = simpleDateFormat.format(date);
        int value_of_file = docFile();
        key = prefix_.concat( year.concat(Integer.toString(value_of_file)));
        value_of_file++;
        ghifile(Integer.toString(value_of_file));
        return key;
    }

    public static void main(String[] args) {
        KhoaChinh kc = new KhoaChinh("D:\\JAVASWING\\QuanLyBanHang\\JavaApplication10\\src\\index.txt");
        String a = kc.taoKhoaChinh("TU");
        System.out.print(a);

    }
}
