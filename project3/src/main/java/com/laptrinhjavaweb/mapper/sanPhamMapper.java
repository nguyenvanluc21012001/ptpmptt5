package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.laptrinhjavaweb.DAO.impl.anhDAO;
import com.laptrinhjavaweb.DAO.impl.danhMucDAO;
import com.laptrinhjavaweb.model.anh;
import com.laptrinhjavaweb.model.danhMuc;
import com.laptrinhjavaweb.model.sanPham;
import com.laptrinhjavaweb.service.IanhService;
import com.laptrinhjavaweb.service.IsanPhamService;



public class sanPhamMapper implements rowMapper<sanPham> {
	anhDAO anhDAO= new anhDAO();
	danhMucDAO danhMucDAO= new danhMucDAO();
	public sanPham mapRow(ResultSet resultSet) {
		try {
			sanPham sanPham= new sanPham();
			sanPham.setId(resultSet.getInt("id"));
			sanPham.setTieuDe(resultSet.getString("tieuDe"));
			danhMuc danhMuc =danhMucDAO.selectByid(resultSet.getInt("danhMuc_id"));
			sanPham.setDanhMuc(danhMuc);
			sanPham.setGia(resultSet.getInt("gia"));
			sanPham.setGiaBan(resultSet.getInt("giaBan"));	
			//anh anh=IanhServices.selectByID(resultSet.getInt("anh"));
			anh anh1=anhDAO.selectByID(resultSet.getInt("anh"));
			sanPham.setAnh(anh1);
			sanPham.setMoTaSanPham(resultSet.getString("moTaSanPham"));
			sanPham.setTonTai(resultSet.getInt("tonTai"));	
			return sanPham;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
