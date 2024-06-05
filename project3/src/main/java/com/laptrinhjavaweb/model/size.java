package com.laptrinhjavaweb.model;

public class size {
private Integer size_id;
private String name;
public size() {
}

public size(Integer size_id, String name) {
	this.size_id = size_id;
	this.name = name;
}

public Integer getSize_id() {
	return size_id;
}
public void setSize_id(Integer size_id) {
	this.size_id = size_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
