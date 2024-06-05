package com.laptrinhjavaweb.service;

import java.util.List;
import com.laptrinhjavaweb.model.sanPham;

public interface IsanPhamService {
	List<sanPham> findAll();
	sanPham findByID(int productId);
	int update(sanPham sp);
	int insert(sanPham sp);
	List<sanPham> findBytieuDe(String tieuDe);
	List<sanPham> findByDanhMucID(int danhmucID);
}
