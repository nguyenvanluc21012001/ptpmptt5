package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.laptrinhjavaweb.DAO.IsizeDAO;
import com.laptrinhjavaweb.model.size;
import com.laptrinhjavaweb.service.IsizeService;
@Service
public class sizeService implements IsizeService{
	@Autowired
    private IsizeDAO IsizeDAO ;
	public size findByID(int id) {
		return IsizeDAO.findByID(id);
	}

}
