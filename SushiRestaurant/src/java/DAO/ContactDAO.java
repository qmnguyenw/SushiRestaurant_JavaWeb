/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBContext.DBContext;
import Entity.Contact;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Quang Nguyen
 */
public class ContactDAO {
    public ArrayList<Contact> getListContact() throws Exception {
        DBContext dbContext = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Contact> listContact = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM Contact";
            con = dbContext.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Contact contactObj = new Contact();
                contactObj.setId(rs.getInt("id"));
                contactObj.setOpening(rs.getString("opening"));
                contactObj.setContact(rs.getString("contact"));
                listContact.add(contactObj);
            }
            return listContact;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            dbContext.closeConnection(con, ps, rs);
        }
    }
}
