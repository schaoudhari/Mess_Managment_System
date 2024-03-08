package org.Mess.model;

import java.util.*;

public class AttendanceModel {
	private int id;
	private int can_id;
	private String date;
	private int plates;
	public AttendanceModel() {
		
	}
	public AttendanceModel(int can_id, String date, int plates) {
		super();
		this.can_id = can_id;
		this.date = date;
		this.plates = plates;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCan_id() {
		return can_id;
	}
	public void setCan_id(int can_id) {
		this.can_id = can_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPlates() {
		return plates;
	}
	public void setPlates(int plates) {
		this.plates = plates;
	}
}
