package com.laptrinhjavaweb.DAO.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.DAO.IdanhMucDAO;
import com.laptrinhjavaweb.mapper.danhMucMapper;
import com.laptrinhjavaweb.model.danhMuc;


@Repository
public class danhMucDAO extends abstractDAO<danhMuc> implements IdanhMucDAO {
	public danhMuc findByID(int id) {
		String sql = "SELECT * FROM danhmuc WHERE id= ?";
		List<danhMuc> danhMuc = query(sql, new danhMucMapper(), id);
		return danhMuc.isEmpty() ? null : danhMuc.get(0);
	}

	public danhMuc selectByid(int id) {
		danhMuc danhMuc = new danhMuc();
		Connection con = getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT*FROM danhmuc WHERE id='" + id + "'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				danhMuc.setId(rs.getInt("id"));
				danhMuc.setTen(rs.getString("ten"));
			}

		} catch (SQLException ex) {

		}
		return danhMuc;
	}

	public List<danhMuc> findAll() {
		String sql = "SELECT * FROM danhmuc WHERE tonTai=?";
		return query(sql, new danhMucMapper(),1);
	}

	public int suaDanhMuc(danhMuc t) {
		Connection con = getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "UPDATE danhmuc" + " SET ten ='" + t.getTen() + "', "+"tonTai='" + t.getTonTai()+"' " + "WHERE id='" + t.getId() + "\'";
			int check = st.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int themDanhMuc(danhMuc dm) {
		Connection con = getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "INSERT INTO danhmuc(id,ten,tonTai)" + "VALUES('" + dm.getId() + "', '" + dm.getTen()+"', '" + dm.getTonTai() + "')";

			int check = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}
}