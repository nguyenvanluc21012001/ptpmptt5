package com.laptrinhjavaweb.DAO;

import java.util.List;

import com.laptrinhjavaweb.model.feedBack;

public interface IfeedbackDAO {
List<feedBack> findByID(int id);
List<feedBack> findAll();
int xoa(int sanpham, int user);
int insert(feedBack fb);
}
