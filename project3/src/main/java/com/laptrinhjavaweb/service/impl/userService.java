package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.DAO.IuserDAO;
import com.laptrinhjavaweb.model.user;
import com.laptrinhjavaweb.service.IuserService;

@Service
public class userService implements IuserService{
    public userService() {
		// TODO Auto-generated constructor stub
	} 
	@Autowired
    private IuserDAO IuserDAO ;
	public user sellectByTaiKhoanMatKhau(String tenDangNhap, String matKhau) {
		return IuserDAO.sellectByTaiKhoanMatKhau(tenDangNhap, tenDangNhap);
	}
	@Override
	public user findById(int id) {
		return IuserDAO.findById(id);
	}
	@Override
	public int insert(user u) {
		return IuserDAO.insert(u);
	}

}
