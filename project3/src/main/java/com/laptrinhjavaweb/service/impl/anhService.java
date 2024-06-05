package com.laptrinhjavaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.DAO.IanhDAO;
import com.laptrinhjavaweb.model.anh;
import com.laptrinhjavaweb.service.IanhService;
@Service
public class anhService implements IanhService{
    public anhService() {
		
	}
	@Autowired
    private IanhDAO IanhDAO ;
	public anh findByID(int id) {
		return IanhDAO.findByID(id);
	}
	public anh selectByID(int id) {
		return IanhDAO.selectByID(id);
	}
	@Override
	public List<anh> findAll() {
		return IanhDAO.findAll();
	}
	@Override
	public int insert(anh anh) {
		return IanhDAO.insert(anh);
	}

}
