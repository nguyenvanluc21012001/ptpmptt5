package com.laptrinhjavaweb.service;


import java.util.List;

import com.laptrinhjavaweb.model.anh;

public interface IanhService {
	anh findByID(int id);
	anh selectByID(int id);
	List<anh> findAll();
	int insert(anh anh);
}
