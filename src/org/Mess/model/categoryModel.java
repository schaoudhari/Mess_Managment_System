package org.Mess.model;

public class categoryModel {
	private int id;
	private String name;
	private int Mfees;
	private int plateRate;
	private int sum;
	
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public categoryModel() {
		
	}
	public categoryModel(String name, int mfees, int plateRate) {
		super();
		this.name = name;
		this.Mfees = mfees;
		this.plateRate = plateRate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMfees() {
		return Mfees;
	}
	public void setMfees(int mfees) {
		this.Mfees = mfees;
	}
	public int getPlateRate() {
		return plateRate;
	}
	public void setPlateRate(int plateRate) {
		this.plateRate = plateRate;
	}
	
}
