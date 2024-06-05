package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import com.laptrinhjavaweb.DAO.impl.anhDAO;
import com.laptrinhjavaweb.DAO.impl.danhMucDAO;
import com.laptrinhjavaweb.DAO.impl.roleDAO;
import com.laptrinhjavaweb.model.role;
import com.laptrinhjavaweb.model.user;

public class userMapper implements rowMapper<user>{
	anhDAO anhDAO = new anhDAO();
	danhMucDAO danhMucDAO = new danhMucDAO();

	public user mapRow(ResultSet resultSet) {
		try {
			user user= new user();
			user.setUser_id(resultSet.getInt("id"));
			user.setTenDangNhap(resultSet.getString("tenDangNhap"));
			user.setMatKhau(resultSet.getString("matKhau"));
			user.setTen(resultSet.getString("ten"));
			user.setEmail(resultSet.getString("email"));
			user.setDiaChi(resultSet.getString("diaChi"));
			roleDAO roleDAO= new roleDAO();
			role role=roleDAO.selectByID(resultSet.getInt("role_id"));
			user.setRole_id(role);
			user.setTonTai(resultSet.getInt("tonTai"));
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
