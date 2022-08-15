/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlybanhang.connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.applet.Main;

/**
 *
 * @author admin
 */
public class ConnectDB {
    private Connection conn=null;
    public Connection connect(){
        String url="jdbc:sqlserver://localhost:1433;databaseName=quanlyquancafe;user=sa;password=sa";
        try {
            this.conn=DriverManager.getConnection(url);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
