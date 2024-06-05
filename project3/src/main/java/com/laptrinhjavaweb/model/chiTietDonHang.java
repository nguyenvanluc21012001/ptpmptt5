package com.laptrinhjavaweb.model;

public class chiTietDonHang {
private donHang donHang;
private sanPham sanPham;
private Integer soLuong;
public chiTietDonHang() {
	
}

public chiTietDonHang(com.laptrinhjavaweb.model.donHang donHang, com.laptrinhjavaweb.model.sanPham sanPham,
		Integer soLuong) {
	super();
	this.donHang = donHang;
	this.sanPham = sanPham;
	this.soLuong = soLuong;
}

public donHang getDonHang() {
	return donHang;
}
public void setDonHang(donHang donHang) {
	this.donHang = donHang;
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
