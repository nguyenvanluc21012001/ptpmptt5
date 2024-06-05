package com.laptrinhjavaweb.model;

public class sanPham {
private Integer id;
private danhMuc danhMuc;
private String tieuDe; 
private Integer gia;
private Integer giaBan;
private anh anh;
private String moTaSanPham;
private Integer tonTai;
public sanPham() {
	
}

public sanPham(Integer id, com.laptrinhjavaweb.model.danhMuc danhMuc, String tieuDe, Integer gia, Integer giaBan,
		com.laptrinhjavaweb.model.anh anh, String moTaSanPham, Integer tonTai) {
	this.id = id;
	this.danhMuc = danhMuc;
	this.tieuDe = tieuDe;
	this.gia = gia;
	this.giaBan = giaBan;
	this.anh = anh;
	this.moTaSanPham = moTaSanPham;
	this.tonTai = tonTai;
}

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getTieuDe() {
	return tieuDe;
}
public void setTieuDe(String tieuDe) {
	this.tieuDe = tieuDe;
}
public Integer getGia() {
	return gia;
}
public void setGia(Integer gia) {
	this.gia = gia;
}
public Integer getGiaBan() {
	return giaBan;
}
public void setGiaBan(Integer giaBan) {
	this.giaBan = giaBan;
}
public anh getAnh() {
	return anh;
}
public void setAnh(anh anh) {
	this.anh = anh;
}
public String getMoTaSanPham() {
	return moTaSanPham;
}
public void setMoTaSanPham(String moTaSanPham) {
	this.moTaSanPham = moTaSanPham;
}
public Integer getTonTai() {
	return tonTai;
}
public void setTonTai(Integer tonTai) {
	this.tonTai = tonTai;
}
public danhMuc getDanhMuc() {
	return danhMuc;
}
public void setDanhMuc(danhMuc danhMuc) {
	this.danhMuc = danhMuc;
}
@Override
public String toString() {
	return "sanPham [id=" + id + ", danhMuc=" + danhMuc + ", tieuDe=" + tieuDe + ", gia=" + gia + ", giaBan=" + giaBan
			+ ", anh=" + anh + ", moTaSanPham=" + moTaSanPham + ", tonTai=" + tonTai + "]";
}

}
