package com.laptrinhjavaweb.model;

public class role {
private Integer role_id;
private String name;
public role() {
}

public role(Integer role_id, String name) {
	this.role_id = role_id;
	this.name = name;
}

public int getRole_id() {
	return role_id;
}
public void setRole_id(Integer role_id) {
	this.role_id = role_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
