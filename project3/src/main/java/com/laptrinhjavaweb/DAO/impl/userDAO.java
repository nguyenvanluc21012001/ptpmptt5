package com.laptrinhjavaweb.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.DAO.IuserDAO;
import com.laptrinhjavaweb.model.role;
import com.laptrinhjavaweb.model.user;


@Repository
public class userDAO extends abstractDAO<user> implements IuserDAO{

	@Override
	public user sellectByTaiKhoanMatKhau(String tenDangNhap, String matKhau) {
		user u = null;
		try {

			Connection con = getConnection();
			String sql = "SELECT * FROM user WHERE tenDangNhap=? and matKhau=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, tenDangNhap);
			st.setString(2, matKhau);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int idd = rs.getInt("id");
				String tdn = rs.getString("tenDangNhap");
				String mk = rs.getString("matKhau");
				String ten = rs.getString("ten");
				String email = rs.getString("email");
				String diaChi = rs.getString("diaChi");
				int role_id = rs.getInt("role_id");
				int tonTai = rs.getInt("tonTai");
				role role;
				if (role_id == 1) {
					role = new role(1, "nhân viên");
				} else {
					role = new role(2, "khách hàng");
				}
				u = new user(idd, tdn, mk,ten,email, diaChi, role,tonTai);
			}

		} catch (SQLException ex) {

		}
		return u;
	}
	@Override
	public user findById(int id) {
		user u = null;
		Connection con = getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT*FROM user WHERE id='" + id + "'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int idd = rs.getInt("id");
				String tenDangNhap = rs.getString("tenDangNhap");
				String matKhau = rs.getString("matKhau");
				String ten = rs.getString("ten");
				String email = rs.getString("email");
				String diaChi = rs.getString("diaChi");
				int role_id = rs.getInt("role_id");
				role role;
				if (role_id == 1) {
					role = new role(1, "nhân viên");
				} else {
					role = new role(2, "khách hàng");
				}
				int tonTai = rs.getInt("tonTai");
				u = new user(idd, tenDangNhap, matKhau, ten, email, diaChi, role, tonTai);
			}

		} catch (SQLException ex) {
			
		}
		return u;
	}
	@Override
	public int insert(user u) {
		Connection con = getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "INSERT INTO user(id,tenDangNhap,matKhau,ten,email,diaChi,role_id,tonTai)" + "VALUES('"
					+ u.getUser_id() + "','" + u.getTenDangNhap() + "','" + u.getMatKhau() + "','" + u.getTen() + "','"
					+ u.getEmail() + "','" + u.getDiaChi() + "','" + u.getRole_id().getRole_id() + "','" + u.getTonTai()
					+ "')";

			int check = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}
}
