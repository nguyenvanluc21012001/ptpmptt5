package com.laptrinhjavaweb.DAO.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.DAO.IchiTietDonHangDAO;
import com.laptrinhjavaweb.model.chiTietDonHang;



@Repository
public class chiTietDonHangDAO extends abstractDAO<chiTietDonHang> implements IchiTietDonHangDAO{
	public int insert(chiTietDonHang ctdh) {
		Connection con = getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "INSERT INTO chitietdonhang(donhang_id,sanpham_id,soLuong)"
					+ "VALUES('" + ctdh.getDonHang().getId() + "','" + ctdh.getSanPham().getId() + "','" + ctdh.getSoLuong()+"')";

			int check = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public ArrayList<chiTietDonHang> sellectAllById(int id) {
		ArrayList<chiTietDonHang> ketqua = new ArrayList<>();
		Connection con = getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT*FROM chitietdonhang WHERE donhang_id ='"+id+"';";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int donhang_id = rs.getInt("donhang_id");
				int sanpham_id = rs.getInt("sanpham_id");
				donHangDAO dhd= new donHangDAO();
				com.laptrinhjavaweb.model.donHang dh= dhd.findByid(donhang_id);
				int soluong = rs.getInt("soLuong");
				sanPhamDAO spd= new sanPhamDAO();
				com.laptrinhjavaweb.model.sanPham sp= spd.sellectByid(sanpham_id);
				chiTietDonHang chiTietDonHang = new chiTietDonHang(dh, sp, soluong);
				ketqua.add(chiTietDonHang);
			}

		} catch (SQLException ex) {
		}
		return ketqua;
	}

	@Override
	public int delete(int donhangid) {
		Connection con = getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "DELETE FROM chitietdonhang WHERE donhang_id='" + donhangid + "'";

			int check = st.executeUpdate(sql);
			System.out.println("so dong thay doi la :" + check);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

}
