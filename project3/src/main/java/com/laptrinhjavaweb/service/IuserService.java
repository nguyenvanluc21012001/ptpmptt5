package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.model.user;

public interface IuserService {
   user sellectByTaiKhoanMatKhau(String tenDangNhap, String matKhau);
   user findById(int id);
   int insert(user u);
}
