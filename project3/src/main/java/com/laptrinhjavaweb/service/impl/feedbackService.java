package com.laptrinhjavaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.DAO.IfeedbackDAO;
import com.laptrinhjavaweb.model.feedBack;
import com.laptrinhjavaweb.service.IfeedbackService;
@Service
public class feedbackService implements IfeedbackService{
	@Autowired
    private IfeedbackDAO feedbackDAO;
	public List<feedBack> findByID(int id) {
		return feedbackDAO.findByID(id);
	}
	@Override
	public List<feedBack> findAll() {
		return feedbackDAO.findAll();
	}
	@Override
	public int xoa(int sanpham, int user) {
		return feedbackDAO.xoa(sanpham, user);
	}
	@Override
	public int insert(feedBack fb) {
		return feedbackDAO.insert(fb);
	}

}
