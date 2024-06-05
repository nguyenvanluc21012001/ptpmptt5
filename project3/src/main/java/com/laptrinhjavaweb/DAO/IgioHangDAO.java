package com.laptrinhjavaweb.DAO;

import java.util.List;

import com.laptrinhjavaweb.model.gioHang;

public interface IgioHangDAO {
	List<gioHang> findById(int id);
	int insert(int sanpham,int user,int soluong);
}
