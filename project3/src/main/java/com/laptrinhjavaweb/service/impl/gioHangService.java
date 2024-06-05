package com.laptrinhjavaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.DAO.IgioHangDAO;
import com.laptrinhjavaweb.model.gioHang;
import com.laptrinhjavaweb.service.IgioHangService;
@Service
public class gioHangService implements IgioHangService{
	@Autowired
    private IgioHangDAO IgioHangDAO ;
	public List<gioHang> findById(int id) {
           return IgioHangDAO.findById(id);
	}
	public int insert(int sanpham, int user, int soluong) {
		return IgioHangDAO.insert(sanpham, user, soluong);
	}

}
