package org.Mess.Repository;

import org.Mess.model.AttendanceModel;

public class AdminLoginrepository extends DBConfig{
	private String Auser="Shubham";
	private String Apass="Shubham";
	public boolean checkUserPass(String user ,String pass) {
		return (Auser.equals(user)&&Apass.equals(pass));
	}
}
