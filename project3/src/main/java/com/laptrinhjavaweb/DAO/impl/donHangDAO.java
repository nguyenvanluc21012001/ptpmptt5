package com.laptrinhjavaweb.DAO.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.DAO.IdonHangDAO;
import com.laptrinhjavaweb.model.donHang;


@Repository
public class donHangDAO extends abstractDAO<donHang> implements IdonHangDAO{
	public List<donHang> findAll() {
		ArrayList<donHang> ketqua = new ArrayList<>();
		Connection con = getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT*FROM donhang WHERE tonTai=1";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				int user_id = rs.getInt("user_id");
				userDAO usd= new userDAO();
				com.laptrinhjavaweb.model.user u= usd.findById(user_id);
				String ten = rs.getString("ten");
				String sdt = rs.getString("sdt");
				String diachi=rs.getString("diaChi");
				Timestamp thoiGianDatTimestamp=rs.getTimestamp("thoigianDat");
				LocalDateTime thoiGianDat = thoiGianDatTimestamp.toLocalDateTime();
				donHang dh = new donHang(id, u, ten,sdt, diachi, thoiGianDat, 1);
				ketqua.add(dh);
			}

		} catch (SQLException ex) {

		}
		return ketqua;
	}

	@Override
	public int insert(donHang dh) {
		Connection con = getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "INSERT INTO donhang(id,user_id,ten,sdt,diaChi,thoiGianDat,tonTai)"
					+ "VALUES('" + dh.getId() + "','" + dh.getUser().getUser_id() + "','" + dh.getTen() + "','" 
					+ dh.getSdt() + "','" + dh.getDiaChiNhan() + "','"+dh.getThoiGianDat()+"','"+dh.getTonTai()+"')";

			int check = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public donHang findByid(int madonhang) {
		Connection con = getConnection();
		donHang dh= null;
		try {
			Statement st = con.createStatement();
			String sql = "SELECT*FROM donhang WHERE id="+madonhang+" AND tonTai=1";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				int user_id = rs.getInt("user_id");
				userDAO usd= new userDAO();
				com.laptrinhjavaweb.model.user u= usd.findById(user_id);
				String ten = rs.getString("ten");
				String sdt = rs.getString("sdt");
				String diachi=rs.getString("diaChi");
				Timestamp thoiGianDatTimestamp=rs.getTimestamp("thoigianDat");
				LocalDateTime thoiGianDat = thoiGianDatTimestamp.toLocalDateTime();
				dh = new donHang(id, u, ten,sdt, diachi, thoiGianDat, 1);
			}

		} catch (SQLException ex) {

		}
		return dh;
	}

	@Override
	public int delete(int donhangid) {
		Connection con = getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "DELETE FROM donhang WHERE id='" + donhangid + "'";

			int check = st.executeUpdate(sql);
			System.out.println("so dong thay doi la :" + check);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

}
