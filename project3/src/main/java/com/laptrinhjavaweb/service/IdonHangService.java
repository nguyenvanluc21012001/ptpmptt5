package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.donHang;

public interface IdonHangService {
List<donHang> findAll();
int insert(donHang dh);
donHang findByid(int madonhang);
int delete(int donhangid);
}
