package org.Mess.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.Mess.Helper.PathHelper;

public class DBConfig {
	protected Connection conn;
	protected PreparedStatement stmt;
	protected ResultSet rs;
	public DBConfig() {
		try {
			//we need to create object of PathHelper of conn connection throw PathHelper error to us
			PathHelper phelp=new PathHelper();
			Class.forName(PathHelper.p.getProperty("Driver"));
			conn=DriverManager.getConnection(PathHelper.p.getProperty("url"),PathHelper.p.getProperty("user"),PathHelper.p.getProperty("pass"));
		}
		catch(Exception ex) {
			System.out.println("Error is ex"+ex);
		}
	}
}
