package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.anh;

public class anhMapper implements rowMapper<anh>{

	public anh mapRow(ResultSet resultSet) {
		try {
			anh anh= new anh();
			anh.setId(resultSet.getInt("anh_id"));
			anh.setHinhAnh(resultSet.getString("hinhAnh"));
			return anh;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
