package com.laptrinhjavaweb.DAO;

import java.util.List;
import com.laptrinhjavaweb.mapper.rowMapper;

public interface GenericDAO<T> {
	<T> List<T> query(String sql,rowMapper<T> row,Object... parameters);
}
