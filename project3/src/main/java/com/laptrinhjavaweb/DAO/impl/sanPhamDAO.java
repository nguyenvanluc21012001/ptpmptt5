package com.laptrinhjavaweb.DAO.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.DAO.IsanPhamDAO;
import com.laptrinhjavaweb.mapper.sanPhamMapper;
import com.laptrinhjavaweb.model.sanPham;




@Repository
public class sanPhamDAO extends abstractDAO<sanPham> implements IsanPhamDAO{
	public List<sanPham> findAll() {
		String sql="SELECT * FROM sanpham WHERE tonTai=?";
		return query(sql, new sanPhamMapper(),1);
	}
	public sanPham findByID(int id) {
		String sql="SELECT * FROM sanpham WHERE id =?";
		List<sanPham> sanPham= query(sql, new sanPhamMapper(), id);
		return sanPham.isEmpty() ? null : sanPham.get(0);
	}
	public sanPham sellectByid(int id) {
		anhDAO anhDAO= new anhDAO();
		danhMucDAO danhMucDAO= new danhMucDAO();
		sanPham sanPham = new sanPham();
		Connection con = getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "SELECT*FROM sanpham WHERE id='" + id + "' AND tonTai='1'";
			ResultSet resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				sanPham.setId(resultSet.getInt("id"));
				sanPham.setTieuDe(resultSet.getString("tieuDe"));
				com.laptrinhjavaweb.model.danhMuc danhMuc =danhMucDAO.selectByid(resultSet.getInt("danhMuc_id"));
				sanPham.setDanhMuc(danhMuc);
				sanPham.setGia(resultSet.getInt("gia"));
				sanPham.setGiaBan(resultSet.getInt("giaBan"));	
				//anh anh=IanhServices.selectByID(resultSet.getInt("anh"));
				com.laptrinhjavaweb.model.anh anh1=anhDAO.selectByID(resultSet.getInt("anh"));
				sanPham.setAnh(anh1);
				sanPham.setMoTaSanPham(resultSet.getString("moTaSanPham"));
				sanPham.setTonTai(resultSet.getInt("tonTai"));	
				return sanPham;
			}

		} catch (SQLException ex) {

		}
		return sanPham;
	}

	public int update(sanPham t) {
		Connection con = getConnection();
		try {
			int a= 1;
			Statement st = con.createStatement();
			String sql = "UPDATE sanpham" + " SET tieuDe ='" + t.getTieuDe() + "'," + "danhMuc_id ='" + t.getDanhMuc().getId() + "'," + "gia ='"
					+ t.getGia() + "'," + "giaBan ='" + t.getGiaBan()  + "',"+"anh ='" + t.getAnh().getId()+"',"+"moTaSanPham ='" + t.getMoTaSanPham()+"', " +"tonTai ='" + t.getTonTai()+"'"
				    + " WHERE id='" + t.getId() + "\'";
			System.out.println(sql);
			int check = st.executeUpdate(sql);
		} catch (SQLException ex) {
			Logger.getLogger(sanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
		}

		return 0;
	}
	@Override
	public int insert(sanPham sp) {
		Connection con =getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "INSERT INTO sanpham(id,tieuDe,danhMuc_id,gia,giaBan,anh,moTaSanPham,tonTai)"
					+ "VALUES('" + sp.getId() + "','" + sp.getTieuDe() + "','" + sp.getDanhMuc().getId() + "','"
					+ sp.getGia() + "','" + sp.getGiaBan() +  "','" + sp.getAnh().getId() + "','"
					+ sp.getMoTaSanPham()+ "','"+sp.getTonTai() + "')";

			int check = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}
	public List<sanPham> findBytieuDe(String tieuDe) {
		anhDAO anhDAO= new anhDAO();
		danhMucDAO danhMucDAO= new danhMucDAO();
		Connection con = getConnection();
		ArrayList<sanPham> ketqua= new ArrayList<>();
		try {
			Statement st = con.createStatement();
			String sql="SELECT * FROM sanpham WHERE tonTai='1' AND tieuDe LIKE '%"+tieuDe+"%'";
			ResultSet resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				sanPham sanPham = new sanPham();
				sanPham.setId(resultSet.getInt("id"));
				sanPham.setTieuDe(resultSet.getString("tieuDe"));
				com.laptrinhjavaweb.model.danhMuc danhMuc =danhMucDAO.selectByid(resultSet.getInt("danhMuc_id"));
				sanPham.setDanhMuc(danhMuc);
				sanPham.setGia(resultSet.getInt("gia"));
				sanPham.setGiaBan(resultSet.getInt("giaBan"));	
				//anh anh=IanhServices.selectByID(resultSet.getInt("anh"));
				com.laptrinhjavaweb.model.anh anh1=anhDAO.selectByID(resultSet.getInt("anh"));
				sanPham.setAnh(anh1);
				sanPham.setMoTaSanPham(resultSet.getString("moTaSanPham"));
				sanPham.setTonTai(resultSet.getInt("tonTai"));	
				ketqua.add(sanPham);
			}

		} catch (SQLException ex) {

		}
		return ketqua;
	}
	@Override
	public List<sanPham> findByDanhMucID(int danhmucID) {
		String sql="SELECT * FROM sanpham WHERE tonTai=? AND danhMuc_id=?" ;
		return query(sql, new sanPhamMapper(),1,danhmucID);
	}
	
}

