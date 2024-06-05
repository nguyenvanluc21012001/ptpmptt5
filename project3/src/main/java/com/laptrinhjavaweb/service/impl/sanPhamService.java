package com.laptrinhjavaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.DAO.IsanPhamDAO;
import com.laptrinhjavaweb.model.sanPham;
import com.laptrinhjavaweb.service.IsanPhamService;
@Service
public class sanPhamService implements IsanPhamService {
	
	public sanPhamService() {
		
	}
	@Autowired
    private IsanPhamDAO IsanPhamDAO ;
	@Override
	public List<sanPham> findAll() {
		return IsanPhamDAO.findAll();
	}
	public sanPham findByID(int id) {
		return IsanPhamDAO.findByID(id);
	}
	@Override
	public int update(sanPham sp) {
		return IsanPhamDAO.update(sp);
	}
	@Override
	public int insert(sanPham sp) {
		return IsanPhamDAO.insert(sp);
	}
	@Override
	public List<sanPham> findBytieuDe(String tieuDe) {
		return IsanPhamDAO.findBytieuDe(tieuDe);
	}
	@Override
	public List<sanPham> findByDanhMucID(int danhmucID) {
		return IsanPhamDAO.findByDanhMucID(danhmucID);
	}
	


}
