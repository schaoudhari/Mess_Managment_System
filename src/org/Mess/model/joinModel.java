package org.Mess.model;

public class joinModel {
	private String Name;
	private int count_plate;
	private int sum;
	private String cname;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public joinModel() {
		
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getCount_plate() {
		return count_plate;
	}
	public void setCount_plate(int count_plate) {
		this.count_plate = count_plate;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
}
