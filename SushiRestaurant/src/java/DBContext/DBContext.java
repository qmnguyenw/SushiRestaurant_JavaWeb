/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Hiệp Vũ
 */
public class DBContext {
    public Connection getConnection() throws NamingException, ClassNotFoundException, SQLException {
        InitialContext init = new InitialContext();
//        Context context = (Context)init.lookup("java:/comp/env");
        Context context = (Context)init.lookup("java:comp/env");
        String dbName = (String)context.lookup("dbname");
        String serverName = (String)context.lookup("server");
        String portNumber = (String)context.lookup("port");
        String userID = (String)context.lookup("user");
        String password = (String)context.lookup("password");
                
        String url = "jdbc:sqlserver://localhost:1433;databaseName="+dbName+";integratedSecurity=true";
        String url2 = "jdbc:sqlserver://"+serverName+":"+portNumber +";databaseName="+dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url2,userID,password);
    }
    
    public void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
    
    public String getImgDir() throws NamingException {
        InitialContext init = new InitialContext();
        return "static/images/";
    }   
    
}
