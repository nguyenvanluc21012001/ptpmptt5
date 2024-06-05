package com.laptrinhjavaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.DAO.IdanhMucDAO;

import com.laptrinhjavaweb.model.danhMuc;
import com.laptrinhjavaweb.service.IdanhMucService;
@Service
public class danhMucService implements IdanhMucService{
public danhMucService() {	
	}
	@Autowired
    private IdanhMucDAO IdanhMucDAO ;
	public danhMuc findByID(int id) {
		return IdanhMucDAO.findByID(id);
	}
	@Override
	public List<danhMuc> findAll() {
		return IdanhMucDAO.findAll();
	}
	@Override
	public int suaDanhMuc(danhMuc dm) {
		return IdanhMucDAO.suaDanhMuc(dm);
	}
	@Override
	public int themDanhMuc(danhMuc dm) {
		// TODO Auto-generated method stub
		return IdanhMucDAO.themDanhMuc(dm);
	}
}
