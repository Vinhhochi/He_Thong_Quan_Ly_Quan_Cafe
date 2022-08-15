/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author admin
 */
public class app {
     public void xoaPhanTuTrongMang(int index, String a[][], int col){
        for(int i=index; i<a.length-1; i ++){
            for (int j=0; j<col; j++){
                a[i][j]=a[i+1][j];
            }
        }
        for (int j=0; j<col; j++){
                a[a.length-1][j]=null;
            }
     
    }
     int demSoPhanTuTrongMang(String a[][]){
        int dem=0;
        for(int i=0; i<a.length; i++){
           if(a[i][0] !=null){
               dem =dem+1;
           }
           else{
               break;
           }
        }
        return dem;
    }
     @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        app a =new app();
        String b[][] =new String[10][10];
        b[0][0] ="sds";
        b[0][1]="sds";
        b[1][0]="cc";
        b[1][1]="cc";
       
        a.xoaPhanTuTrongMang(0, b,2);
        System.out.print(a.demSoPhanTuTrongMang(b));
        
        for(int i=0; i<a.demSoPhanTuTrongMang(b); i ++){
            for (int j=0; j<10; j++){
               System.out.print(b[i][j]+" ");
            }
             System.out.println();
        }
        
    }
    
}
