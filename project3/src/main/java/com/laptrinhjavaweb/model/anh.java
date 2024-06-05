package com.laptrinhjavaweb.model;

public class anh {
private Integer id;
private String hinhAnh;
public anh() {
	
}


public anh(Integer id, String hinhAnh) {
	this.id = id;
	this.hinhAnh = hinhAnh;
}


public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getHinhAnh() {
	return hinhAnh;
}
public void setHinhAnh(String hinhAnh) {
	this.hinhAnh = hinhAnh;
}

}
