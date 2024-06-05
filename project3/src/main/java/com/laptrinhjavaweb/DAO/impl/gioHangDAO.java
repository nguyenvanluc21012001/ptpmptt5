package com.laptrinhjavaweb.DAO.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.DAO.IgioHangDAO;
import com.laptrinhjavaweb.model.gioHang;
import com.laptrinhjavaweb.model.sanPham;
import com.laptrinhjavaweb.model.user;
@Repository
public class gioHangDAO extends abstractDAO<gioHang> implements IgioHangDAO{

	public List<gioHang> findById(int id) {
		ArrayList<gioHang> ketqua = new ArrayList<>();
		Connection con = getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT*FROM giohang WHERE user_id='"+id+"';";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int sanpham_id = rs.getInt("sanpham_id");
                sanPhamDAO spd= new sanPhamDAO();
                sanPham sp= new sanPham();
                sp=spd.sellectByid(sanpham_id);
                
                int user_id = rs.getInt("user_id");
				userDAO ud = new userDAO();
				user u = new user();
				u = ud.findById(user_id);

				int sl = rs.getInt("soLuong");
			
				gioHang gh = new gioHang(u,sp,sl);
				ketqua.add(gh);
			}

		} catch (SQLException ex) {
			
		}
		return ketqua;
		
	}

	@Override
	public int insert(int sanpham, int user, int soluong) {
		Connection con = getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "INSERT INTO giohang(sanpham_id,user_id,soluong)"
					+ "VALUES('" +sanpham + "','" + user + "','" + soluong  + "')";

			int check = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

}
