package com.laptrinhjavaweb.model;

public class kho {
private sanPham sanPham;
private size size;
private Integer soLuong;
public kho() {
	
}

public kho(com.laptrinhjavaweb.model.sanPham sanPham, com.laptrinhjavaweb.model.size size, Integer soLuong) {
	this.sanPham = sanPham;
	this.size = size;
	this.soLuong = soLuong;
}

public sanPham getSanPham() {
	return sanPham;
}
public void setSanPham(sanPham sanPham) {
	this.sanPham = sanPham;
}
public size getSize() {
	return size;
}
public void setSize(size size) {
	this.size = size;
}
public Integer getSoLuong() {
	return soLuong;
}
public void setSoLuong(Integer soLuong) {
	this.soLuong = soLuong;
}
//toi nghi nen bo cuaHang_id ra khoi san pham vaf them danhMucCuaHang vaof they cho danhMuc_id
}
