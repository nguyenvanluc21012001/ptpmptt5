package com.laptrinhjavaweb.DAO.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;
import com.laptrinhjavaweb.DAO.IsizeDAO;
import com.laptrinhjavaweb.model.size;

@Repository
public class sizeDAO extends abstractDAO<size> implements IsizeDAO{

	public size findByID(int id) {
		size s = null;
		Connection con = getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT*FROM size WHERE id='" + id + "'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int idd = rs.getInt("id");
				String name = rs.getString("name");

				s = new size(idd, name);
			}
		} catch (SQLException ex) {
			
		}
		return s;
	}
	
}
