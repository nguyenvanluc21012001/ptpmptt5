package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.danhMuc;

public class danhMucMapper implements rowMapper<danhMuc>{
	public danhMuc mapRow(ResultSet resultSet) {
		try {
			danhMuc danhMuc= new danhMuc();
			danhMuc.setId(resultSet.getInt("id"));
			danhMuc.setTen(resultSet.getString("ten"));
			return danhMuc;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
