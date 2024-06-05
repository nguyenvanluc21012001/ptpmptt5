package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.laptrinhjavaweb.model.role;

public class roleMapper implements rowMapper<role>{
	public role mapRow(ResultSet resultSet) {
		try {
			role role= new role();
			role.setRole_id(resultSet.getInt("id"));
			role.setName(resultSet.getString("name"));
			return role;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
