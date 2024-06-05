package com.laptrinhjavaweb.DAO;

import java.util.List;

import com.laptrinhjavaweb.model.donHang;

public interface IdonHangDAO {
List<donHang> findAll();
int insert(donHang dh);
donHang findByid(int madonhang);
int delete(int donhangid);
}
