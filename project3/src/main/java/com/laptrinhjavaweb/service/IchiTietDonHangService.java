package com.laptrinhjavaweb.service;

import java.util.ArrayList;

import com.laptrinhjavaweb.model.chiTietDonHang;

public interface IchiTietDonHangService {
int insert(chiTietDonHang ctdh);
ArrayList<chiTietDonHang> sellectAllById(int id);
int delete(int donhangid);
}
