package com.laptrinhjavaweb.DAO.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.DAO.IfeedbackDAO;
import com.laptrinhjavaweb.model.feedBack;
import com.laptrinhjavaweb.model.sanPham;
import com.laptrinhjavaweb.model.user;




@Repository
public class feedbackDAO extends abstractDAO<feedBack> implements IfeedbackDAO {

	public List<feedBack> findByID(int id) {
		ArrayList<feedBack> ketqua = new ArrayList<>();
		Connection con = getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT*FROM feedback WHERE id = '"+id+"'";
			ResultSet rs = st.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				int sanPhamID = rs.getInt("id");
				sanPhamDAO spd= new sanPhamDAO();
				sanPham sp=spd.sellectByid(sanPhamID);
				int user_id = rs.getInt("user_id");
				userDAO usd= new userDAO();
				user u= usd.findById(user_id);
				String tieuDe = rs.getString("tieuDe");
				String noiDung=rs.getString("noiDung");
				feedBack fb = new feedBack(u, sp, tieuDe, noiDung);
				ketqua.add(fb);
			}

		} catch (SQLException ex) {
			
		}
		return ketqua;
	}

	@Override
	public List<feedBack> findAll() {
		ArrayList<feedBack> ketqua = new ArrayList<>();
		Connection con = getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT*FROM feedback ";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int sanPhamID = rs.getInt("id");
				sanPhamDAO spd= new sanPhamDAO();
				sanPham sp=spd.sellectByid(sanPhamID);
				int user_id = rs.getInt("user_id");
				userDAO usd= new userDAO();
				user u= usd.findById(user_id);
				String tieuDe = rs.getString("tieuDe");
				String noiDung=rs.getString("noiDung");
				feedBack fb = new feedBack(u, sp, tieuDe, noiDung);
				ketqua.add(fb);
			}

		} catch (SQLException ex) {
			
		}
		return ketqua;
	}

	public int xoa(int sanpham, int user) {
		Connection con = getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "DELETE FROM feedback WHERE id='" + sanpham + "' AND user_id='"+user+"'";
			int check = st.executeUpdate(sql);
			System.out.println(sql);
			System.out.println("so dong thay doi la :" + check);
			if (check > 0) {
				System.out.println("thuc hien thanh cong :" + sql);
			} else {
				System.out.println("that bai");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int insert(feedBack fb) {
		Connection con = getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "INSERT INTO feedback(id,user_id,tieuDe,noiDung)"
					+ "VALUES('" + fb.getSanPham().getId() + "','" + fb.getUser().getUser_id() + "','" + fb.getTieuDe()+"','"
					+ fb.getNoiDung() + "')";

			int check = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

}
