package org.Mess.Service;

import org.Mess.Repository.AttendanceRepository;
import org.Mess.model.AttendanceModel;

public class AttendanceService {
	AttendanceRepository arepo=new AttendanceRepository();
	public boolean addAttendance(AttendanceModel amodel) {
		return arepo.addAttendance(amodel);
	}
}
