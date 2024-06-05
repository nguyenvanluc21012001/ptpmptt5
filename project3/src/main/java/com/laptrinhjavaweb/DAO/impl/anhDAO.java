package com.laptrinhjavaweb.DAO.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.DAO.IanhDAO;
import com.laptrinhjavaweb.mapper.anhMapper;

import com.laptrinhjavaweb.model.anh;


@Repository
public class anhDAO extends abstractDAO<anh> implements IanhDAO{
	public anh findByID(int id) {
		String sql="SELECT * FROM anh WHERE id= ?";
		List<anh> anh= query(sql, new anhMapper(), id);
		return anh.isEmpty() ? null : anh.get(0);
	}
	public anh selectByID(int id) {
        anh a= new anh();
        Connection con= getConnection();
        try {
            Statement st = con.createStatement();
            String sql = "SELECT*FROM anh WHERE anh_id='"+id+"'";
            ResultSet rs =st.executeQuery(sql);
            while (rs.next()) {                
                a.setId(rs.getInt("anh_id"));
                a.setHinhAnh(rs.getString("hinhAnh"));
            }
           
        } catch (SQLException ex) {
            
        }
        return a;
	}
	@Override
	public List<anh> findAll() {
		String sql = "SELECT * FROM anh";
		return query(sql, new anhMapper());
	}
	@Override
	public int insert(anh anh) {
		Connection con =getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "INSERT INTO anh(anh_id,hinhAnh)" + "VALUES('" + anh.getId() + "','" + anh.getHinhAnh() + "')";

			int check = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}


}
