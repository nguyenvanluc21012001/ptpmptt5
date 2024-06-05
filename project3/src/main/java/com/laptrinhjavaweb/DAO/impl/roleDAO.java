package com.laptrinhjavaweb.DAO.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.DAO.IroleDAO;
import com.laptrinhjavaweb.model.role;
@Repository
public class roleDAO extends abstractDAO<role> implements IroleDAO{
	public role selectByID(int id) {
        role role= new role();
        Connection con= getConnection();
        try {
            Statement st = con.createStatement();
            String sql = "SELECT*FROM role WHERE id='"+id+"'";
            ResultSet rs =st.executeQuery(sql);
            while (rs.next()) {                
                role.setRole_id(rs.getInt("id"));
                role.setName(rs.getString("name"));
            }
           
        } catch (SQLException ex) {
            
        }
        return role;
	}
}
