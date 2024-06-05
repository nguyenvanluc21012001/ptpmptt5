package com.laptrinhjavaweb.model;

public class danhMuc {
private Integer id;
private String ten;
private Integer tonTai;
public danhMuc() {
	
}



public danhMuc(Integer id, String ten, Integer tonTai) {
	this.id = id;
	this.ten = ten;
	this.tonTai = tonTai;
}
public Integer getTonTai() {
	return tonTai;
}
public void setTonTai(Integer tonTai) {
	this.tonTai = tonTai;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getTen() {
	return ten;
}
public void setTen(String ten) {
	this.ten = ten;
}

}
