package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.feedBack;

public interface IfeedbackService {
List<feedBack> findByID(int id);
List<feedBack> findAll();
int xoa(int sanpham, int user);
int insert(feedBack fb);

}
