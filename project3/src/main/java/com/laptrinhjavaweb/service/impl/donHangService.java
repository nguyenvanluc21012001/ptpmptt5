package com.laptrinhjavaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.DAO.IdonHangDAO;
import com.laptrinhjavaweb.model.donHang;
import com.laptrinhjavaweb.service.IdonHangService;

@Service
public class donHangService implements IdonHangService {
	public donHangService() {
	}

	@Autowired
	private IdonHangDAO IdonHangDAO;

	public List<donHang> findAll() {
		return IdonHangDAO.findAll();
	}

	@Override
	public int insert(donHang dh) {
		return IdonHangDAO.insert(dh);
	}

	@Override
	public donHang findByid(int madonhang) {
		return IdonHangDAO.findByid(madonhang);
	}

	@Override
	public int delete(int donhangid) {
		return IdonHangDAO.delete(donhangid);
	}

}
