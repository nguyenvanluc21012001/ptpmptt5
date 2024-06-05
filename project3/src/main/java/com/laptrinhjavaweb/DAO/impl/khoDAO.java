package com.laptrinhjavaweb.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.DAO.IkhoDAO;
import com.laptrinhjavaweb.model.kho;

@Repository
public class khoDAO extends abstractDAO<kho> implements IkhoDAO{

	public kho find(int sanPhamID, int sizeID) {
		kho k = null;
		try {

			Connection con = getConnection();
			String sql = "SELECT * FROM kho WHERE sanpham_id=? and size_id=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,sanPhamID);
			st.setInt(2,sizeID);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int sanPham = rs.getInt("sanPham_id");
				sanPhamDAO spd= new sanPhamDAO();
				com.laptrinhjavaweb.model.sanPham sp = spd.sellectByid(sanPham);
				int size = rs.getInt("size_id");
				sizeDAO sd= new sizeDAO();
				com.laptrinhjavaweb.model.size s= sd.findByID(size);
				int soLuong = rs.getInt("soLuongTonKho");
				k= new kho(sp, s, soLuong);
			}
          System.out.println(k.getSanPham().getMoTaSanPham()+" "+k.getSoLuong());
		} catch (SQLException ex) {
			
		}
		return k;
	}

}
