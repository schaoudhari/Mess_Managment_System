package org.Mess.Service;

import org.Mess.Repository.AdminLoginrepository;
import org.Mess.Repository.DBConfig;
import org.Mess.model.AttendanceModel;

public class AdminLoginService{
	AdminLoginrepository arepo=new AdminLoginrepository();
	public boolean checkUserPass(String uname,String Pass) {
		return arepo.checkUserPass(uname,Pass);
	}
	
}
