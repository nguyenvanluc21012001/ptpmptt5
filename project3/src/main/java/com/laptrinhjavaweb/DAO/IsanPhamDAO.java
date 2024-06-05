package com.laptrinhjavaweb.DAO;

import java.util.List;

import com.laptrinhjavaweb.model.sanPham;


public interface IsanPhamDAO extends GenericDAO<sanPham> {
	List<sanPham> findAll();
	sanPham findByID(int id);
	int update(sanPham sp);
	int insert(sanPham sp);
	List<sanPham> findBytieuDe(String tieuDe);
	List<sanPham> findByDanhMucID(int danhmucID);
}
