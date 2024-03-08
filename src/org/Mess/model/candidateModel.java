package org.Mess.model;

public class candidateModel {
	private int id;
	private String name;
	private int age;
	private int Cate_id;
	private int adv_amt;
	public int getAdv_amt() {
		return adv_amt;
	}
	public void setAdv_amt(int adv_amt) {
		this.adv_amt = adv_amt;
	}
	public candidateModel() {
		
	}
	public candidateModel(String name, int age, int cate_id) {
		super();
		this.name = name;
		this.age = age;
		this.Cate_id = cate_id;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCate_id() {
		return Cate_id;
	}
	public void setCate_id(int cate_id) {
		Cate_id = cate_id;
	}
}
