/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBContext.DBContext;
import Entity.Menu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Quang Nguyen
 */
public class MenuDAO {
    public Menu getMenuByID(int id) throws Exception {
        DBContext dbContext = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            String sql = "SELECT * FROM Article WHERE id = ?";
            con = dbContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String content = rs.getString("content");
                return new Menu(id, name, price, content);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            dbContext.closeConnection(con, ps, rs);
        }
        return null;
    }
    
    int numberArticleInPage = 3; 
    
    public ArrayList<Menu> getTotalMenu(int pageCurrent) throws Exception {
        DBContext dbContext = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Menu> listMenu = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM (\n" +
                    "               SELECT ROW_NUMBER() OVER (ORDER BY id) as Row_Num, \n" +
                    "               * FROM Menu) \n" +
                    " AS DataSearch WHERE DataSearch.Row_Num between ? and ?";
            con = dbContext.getConnection();
            ps = con.prepareStatement(sql);
            //get row number of the last menu in page
            int articleTo = pageCurrent * numberArticleInPage;
            //get row numberof the first menu in page
            int articleFrom = articleTo - numberArticleInPage + 1;
            ps.setInt(1, articleFrom);
            ps.setInt(2, articleTo);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String content = rs.getString("content");
                Menu menu = new Menu(id, name, price, content);
                listMenu.add(menu);
            }
            return listMenu;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            dbContext.closeConnection(con, ps, rs);
        }
    }
    
    public int getNumberPage() throws Exception {
        DBContext dbContext = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            String sql = "SELECT COUNT(id) as numOfRecord FROM Menu";
            con = dbContext.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                int numberOfRecord = rs.getInt("numOfRecord");
                return (int)Math.ceil(numberOfRecord / numberArticleInPage);
            }
            return -1;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            dbContext.closeConnection(con, ps, rs);
        }
    }
}
