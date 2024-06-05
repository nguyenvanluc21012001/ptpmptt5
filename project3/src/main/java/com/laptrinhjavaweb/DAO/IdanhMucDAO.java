package com.laptrinhjavaweb.DAO;

import java.util.List;

import com.laptrinhjavaweb.model.danhMuc;

public interface IdanhMucDAO extends GenericDAO<danhMuc>{
	danhMuc findByID(int a);
	List<danhMuc> findAll();
	int suaDanhMuc(danhMuc dm);
	int themDanhMuc(danhMuc dm);
}
