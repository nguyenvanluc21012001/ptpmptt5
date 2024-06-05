package com.laptrinhjavaweb.model;

import java.time.LocalDateTime;

public class donHang {
private Integer id;
private user user;
private String ten;
private String sdt;
private String diaChiNhan;
private LocalDateTime thoiGianDat;
private Integer tonTai;

public donHang() {
	
}



public donHang(Integer id, com.laptrinhjavaweb.model.user user, String ten, String sdt, String diaChiNhan,
		LocalDateTime thoiGianDat, Integer tonTai) {
	this.id = id;
	this.user = user;
	this.ten = ten;
	this.sdt = sdt;
	this.diaChiNhan = diaChiNhan;
	this.thoiGianDat = thoiGianDat;
	this.tonTai = tonTai;
}



public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public user getUser() {
	return user;
}
public void setUser(user user) {
	this.user = user;
}
public String getTen() {
	return ten;
}
public void setTen(String ten) {
	this.ten = ten;
}
public String getDiaChiNhan() {
	return diaChiNhan;
}
public void setDiaChiNhan(String diaChiNhan) {
	this.diaChiNhan = diaChiNhan;
}
public LocalDateTime getThoiGianDat() {
	return thoiGianDat;
}
public void setThoiGianDat(LocalDateTime thoiGianDat) {
	this.thoiGianDat = thoiGianDat;
}
public Integer getTonTai() {
	return tonTai;
}
public void setTonTai(Integer tonTai) {
	this.tonTai = tonTai;
}
public String getSdt() {
	return sdt;
}
public void setSdt(String sdt) {
	this.sdt = sdt;
}

}
