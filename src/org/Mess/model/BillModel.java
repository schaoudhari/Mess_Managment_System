package org.Mess.model;

public class BillModel {
	private String name;
	private int Total_Plates;
	private int Total_Amount;
	public BillModel() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotal_Plates() {
		return Total_Plates;
	}
	public void setTotal_Plates(int total_Plates) {
		Total_Plates = total_Plates;
	}
	public int getTotal_Amount() {
		return Total_Amount;
	}
	public void setTotal_Amount(int total_Amount) {
		Total_Amount = total_Amount;
	}
}
