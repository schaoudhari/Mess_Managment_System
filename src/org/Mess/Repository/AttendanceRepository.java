package org.Mess.Repository;

import java.sql.Date;

import org.Mess.model.AttendanceModel;

public class AttendanceRepository extends DBConfig{
	private int can_id;
	private int getAttendanceId() {
		try {
			stmt=conn.prepareStatement("select max(attend_id) from attendance");
			rs=stmt.executeQuery();
			if(rs.next()) {
				can_id=rs.getInt(1);
			}
			can_id++;
		}catch(Exception ex) {
			System.out.println("Error is");
		}
		return can_id;
	}
	public int getMonth(String month) {
			
			int mont=0;
			switch(month) {
			case "Jan":
				mont=0;
				break;
			case "Feb":
				mont=1;
				break;
			case "Mar":
				mont=2;
				break;
			case "Apr":
				mont=3;
				break;
			case "May":
				mont=4;
					break;
			case "June":
				mont=5;
				break;
			case "July":
				mont=6;
				break;
			case "Aug":
				mont=7;
				break;
			case "Sep":
				mont=8;
				break;
			case "oct":
				mont=9;
				break;
			case "Nov":
				mont=10;
				break;
			case "Dec":
				mont=11;
				break;
			}
			return mont;
		}

	public boolean addAttendance(AttendanceModel amodel) {
		try {
			int id=this.getAttendanceId();
			stmt=conn.prepareStatement("insert into attendance values(?,?,?,?)");
			stmt.setInt(1, id);
			stmt.setInt(2, amodel.getCan_id());
			String date=amodel.getDate();
			String []uDate=date.split(" ");
//			System.out.println(uDate[1]+"\t"+uDate[2]+"\t"+uDate[5]);
			Date sqlDate=new Date(Integer.parseInt(uDate[5])-1900,this.getMonth(uDate[1]),Integer.parseInt(uDate[2]));
			stmt.setDate(3, sqlDate);
			stmt.setInt(4, amodel.getPlates());
			int value=stmt.executeUpdate();
			if(value>0)
			{
				return true;
			}
			else {
				return false;
			}
			
		}catch(Exception ex) {
			System.out.println("Error Is"+ex);
			return false;
		}
	}
}
