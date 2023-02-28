/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinh.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author tramy
 */
public class DBUtils {

    public static Connection getConnection() throws NamingException {
//        try {
//            String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
//            if (instance == null || instance.trim().isEmpty()) {
//                url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
//            }
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//
//            Connection con = DriverManager.getConnection(url, userID, password);
//            return con;
//        } catch (SQLException ex) {
//            System.out.println("Connection error! " + ex.getMessage());
//        } catch (ClassNotFoundException ex) {
//            System.out.println("Connection error! " + ex.getMessage());
//        }
//        return null;
        
        try {
            Context ctx = new InitialContext();
            Context envCtx = (Context) ctx.lookup("java:comp/env");
            DataSource ds = (DataSource) envCtx.lookup("Chinh");
            Connection con = ds.getConnection();
            return con;
        } catch (SQLException ex) {
            System.out.println("Connection error! " + ex.getMessage());
        }
        return null;

    }
    
    
//    private final static String serverName = "localhost";
//    private final static String dbName = "Chinh_FA223W";
//    private final static String portNumber = "1433";
//    private final static String instance = "";//LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
//    private final static String userID = "sa";
//    private final static String password = "12345";
//
//    public static void main(String[] args) {
//        try {
//            System.out.println(new DBUtils().getConnection());
//        } catch (Exception e) {
//        }
//    }
}
