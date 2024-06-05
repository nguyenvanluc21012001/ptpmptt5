package com.laptrinhjavaweb.DAO;

import java.util.List;

import com.laptrinhjavaweb.model.anh;

public interface IanhDAO extends GenericDAO<anh>{
	anh findByID(int a);
	anh selectByID(int a);
	List<anh> findAll();
	int insert(anh anh);
}
