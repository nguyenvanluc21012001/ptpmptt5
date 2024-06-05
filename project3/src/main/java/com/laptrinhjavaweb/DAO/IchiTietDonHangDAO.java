package com.laptrinhjavaweb.DAO;

import java.util.ArrayList;

import com.laptrinhjavaweb.model.chiTietDonHang;

public interface IchiTietDonHangDAO {
int insert(chiTietDonHang ctdh);
ArrayList<chiTietDonHang> sellectAllById(int id);
int delete(int donhangid);
}
