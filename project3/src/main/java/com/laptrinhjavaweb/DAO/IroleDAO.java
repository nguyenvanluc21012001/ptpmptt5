package com.laptrinhjavaweb.DAO;

import com.laptrinhjavaweb.model.role;

public interface IroleDAO extends GenericDAO<role>{
	 role selectByID(int id);
}
