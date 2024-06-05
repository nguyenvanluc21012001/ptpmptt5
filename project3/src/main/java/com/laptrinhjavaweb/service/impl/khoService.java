package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.laptrinhjavaweb.DAO.IkhoDAO;
import com.laptrinhjavaweb.model.kho;
import com.laptrinhjavaweb.service.IkhoService;
@Service
public class khoService implements IkhoService{
	@Autowired
    private IkhoDAO IkhoDAO ;
	public kho find(int sanPhamID, int sizeID) {
		return IkhoDAO.find(sanPhamID, sizeID);
	}

}
