package com.laptrinhjavaweb.DAO;

import com.laptrinhjavaweb.model.user;

public interface IuserDAO extends GenericDAO<user>{
	user sellectByTaiKhoanMatKhau(String tenDangNhap, String matKhau);
	user findById(int id);
	int insert(user u);
}
