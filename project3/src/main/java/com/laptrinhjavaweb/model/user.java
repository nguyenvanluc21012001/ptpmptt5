package com.laptrinhjavaweb.model;

public class user {
private Integer user_id;
private String tenDangNhap;
private String matKhau;
private String ten;
private String email;
private String diaChi;
private role role_id;
private Integer tonTai;

public user() {
	
}

public user(Integer user_id, String tenDangNhap, String matKhau, String ten, String email, String diaChi, role role_id,
		Integer tonTai) {
	this.user_id = user_id;
	this.tenDangNhap = tenDangNhap;
	this.matKhau = matKhau;
	this.ten = ten;
	this.email = email;
	this.diaChi = diaChi;
	this.role_id = role_id;
	this.tonTai = tonTai;
}

public Integer getTonTai() {
	return tonTai;
}
public void setTonTai(Integer tonTai) {
	this.tonTai = tonTai;
}
public Integer getUser_id() {
	return user_id;
}
public void setUser_id(Integer user_id) {
	this.user_id = user_id;
}
public String getTenDangNhap() {
	return tenDangNhap;
}
public void setTenDangNhap(String tenDangNhap) {
	this.tenDangNhap = tenDangNhap;
}
public String getMatKhau() {
	return matKhau;
}
public void setMatKhau(String matKhau) {
	this.matKhau = matKhau;
}
public String getTen() {
	return ten;
}
public void setTen(String ten) {
	this.ten = ten;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getDiaChi() {
	return diaChi;
}
public void setDiaChi(String diaChi) {
	this.diaChi = diaChi;
}
public role getRole_id() {
	return role_id;
}
public void setRole_id(role role_id) {
	this.role_id = role_id;
}


}
