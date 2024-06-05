package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.laptrinhjavaweb.DAO.IchiTietDonHangDAO;
import com.laptrinhjavaweb.model.chiTietDonHang;
import com.laptrinhjavaweb.service.IchiTietDonHangService;

@Service
public class chiTietDonHangService implements IchiTietDonHangService {
	public chiTietDonHangService() {
	}

	@Autowired
	private IchiTietDonHangDAO IchiTietDonHangDAO;
	public int insert(chiTietDonHang ctdh) {
		return IchiTietDonHangDAO.insert(ctdh);
	}
	@Override
	public ArrayList<chiTietDonHang> sellectAllById(int id) {
		return IchiTietDonHangDAO.sellectAllById(id);
	}
	@Override
	public int delete(int donhangid) {
		return IchiTietDonHangDAO.delete(donhangid);
	}

}
