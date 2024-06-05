package com.laptrinhjavaweb.model;

public class gioHang {
private user user;
private sanPham sanPham;
private Integer soLuong;
public gioHang() {
	
}

public gioHang(com.laptrinhjavaweb.model.user user, com.laptrinhjavaweb.model.sanPham sanPham, Integer soLuong) {
	this.user = user;
	this.sanPham = sanPham;
	this.soLuong = soLuong;
}

public user getUser() {
	return user;
}
public void setUser(user user) {
	this.user = user;
}
public sanPham getSanPham() {
	return sanPham;
}
public void setSanPham(sanPham sanPham) {
	this.sanPham = sanPham;
}
public Integer getSoLuong() {
	return soLuong;
}
public void setSoLuong(Integer soLuong) {
	this.soLuong = soLuong;
}

}
