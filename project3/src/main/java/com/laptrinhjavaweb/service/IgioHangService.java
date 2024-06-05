package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.gioHang;

public interface IgioHangService {
	List<gioHang> findById(int id);
	int insert(int sanpham,int user,int soluong);
}
