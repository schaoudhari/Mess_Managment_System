package org.Mess.model;

public class menuModel {
	private int menu_id;
	private String Menu_name;
	private String Day;
	public menuModel() {
		
	}
	
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public String getMenu_name() {
		return Menu_name;
	}
	public void setMenu_name(String menu_name) {
		Menu_name = menu_name;
	}
	public String getDay() {
		return Day;
	}
	public void setDay(String day) {
		Day = day;
	}
}
