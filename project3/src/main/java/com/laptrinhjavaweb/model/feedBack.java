package com.laptrinhjavaweb.model;

public class feedBack {
private user user;
private sanPham sanPham;
private String tieuDe;
private String noiDung;
public feedBack() {
	
}

public feedBack(com.laptrinhjavaweb.model.user user, com.laptrinhjavaweb.model.sanPham sanPham, String tieuDe,
		String noiDung) {
	this.user = user;
	this.sanPham = sanPham;
	this.tieuDe = tieuDe;
	this.noiDung = noiDung;
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
public String getTieuDe() {
	return tieuDe;
}
public void setTieuDe(String tieuDe) {
	this.tieuDe = tieuDe;
}
public String getNoiDung() {
	return noiDung;
}
public void setNoiDung(String noiDung) {
	this.noiDung = noiDung;
}

}
