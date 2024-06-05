package com.laptrinhjavaweb.service;
import java.util.List;

import com.laptrinhjavaweb.model.danhMuc;

public interface IdanhMucService {
	danhMuc findByID(int id);
	List<danhMuc> findAll();
	int suaDanhMuc(danhMuc dm);
	int themDanhMuc(danhMuc dm);
}
