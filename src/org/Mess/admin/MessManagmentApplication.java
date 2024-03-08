package org.Mess.admin;
import java.util.*;

import org.Mess.Repository.CategoryRepository;
import org.Mess.Service.AdminLoginService;
import org.Mess.Service.AttendanceService;
import org.Mess.Service.CandidateService;
import org.Mess.Service.categoryService;
import org.Mess.model.AttendanceModel;
import org.Mess.model.candidateModel;
import org.Mess.model.categoryModel;
public class MessManagmentApplication {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
//		CategoryRepository cRepo=new CategoryRepository(); 
		categoryService cservice=new categoryService();
		CandidateService canServ=new CandidateService();
		AdminLoginService aservice=new AdminLoginService();
		AttendanceService Aserv=new AttendanceService();
		int choice=0;
		do {
			System.out.println("----------------Enter Login Credentials--------------------");
			System.out.println("\t\tEnter Username\t\t");
			String uname=sc.nextLine();
			System.out.println("\t\tEnter Password\t\t");
			String password=sc.nextLine();
			boolean check=aservice.checkUserPass(uname, password);
			if(check) {
				System.out.println("User Loged In Successfull");
				do {
					System.out.println("1:Add Member Category");
					System.out.println("2:Ragister Candidate");
					System.out.println("3:Admit Candidate with Advance Amount");
					System.out.println("4:Take Attendance Of Candidate");
					System.out.println("14:Exit");
					System.out.println("Enter Your choice");
					choice=sc.nextInt();
					switch(choice) {
					case 1:
						sc.nextLine();
						System.out.println("-----------Enter Below Details----------");
						System.out.println("\tEnter Category Name : ");
						System.out.println("\t1:Monthly Member");
						System.out.println("\t2:Daily Walking User");
						String name=sc.nextLine();
						System.out.println("\tEnter Monthly Fees");
						int Mfees=sc.nextInt();
						System.out.println("\tEnter Per-Plate Rate");
						int per_plate=sc.nextInt();
						categoryModel cmodel=new categoryModel(name,Mfees,per_plate);
						boolean b=cservice.AddCategory(cmodel);
						if(b) {
							System.out.println("Data Added Successfully....");
						}else {
							System.out.println("Data Not Added.....");
						}
						break;
					case 2:
						sc.nextLine();
						List<categoryModel> list=canServ.getAllCategory();
						System.out.println("Enter Candidate Name");
						String cName=sc.nextLine();
						System.out.println("Enter Candidate Age");
						int age=sc.nextInt();
						System.out.println("=============================================================");
						System.out.println("Category_Id\t Category Name\t Monthly_Fees\tPer_Plate_Rate");
						System.out.println("=============================================================");
						for(categoryModel m:list) {
							System.out.println(m.getId()+"\t\t"+m.getName()+"\t\t\t"+m.getMfees()+"\t\t"+m.getPlateRate());
						}
						System.out.println("=============================================================");
						System.out.println("Enter Catigory id");
						int cat_Id=sc.nextInt();
						candidateModel Cmodel=new candidateModel(cName,age,cat_Id);
						b=canServ.addCandidate(Cmodel);
						if(b) {
							System.out.println("Ragistration successfull.......");
						}
						else {
							System.out.println("Some problem is there..........");
						}
						break;
					case 3:
						sc.nextLine();
						System.out.println("Enter Candidate Name");
						String canName=sc.nextLine();
						int can_id=canServ.searchCandidate(canName);
						if(can_id>0) {
							System.out.println("Enter Advance amount to Admit in 3000");
							int adv_amt=sc.nextInt();
							b=canServ.addAdvance(can_id, adv_amt);
							if(b) {
								System.out.println("Advance Added |Admitted.....");
							}else {
								System.out.println("Advance not addede....");
							}
						}
						else if(can_id==-1) {
							System.out.println("Ragistration Not Completed | Please Complete First Ragistration");
						}
						else {
							System.out.println("Something is Fishey");
						}
						break;
					case 4:
						sc.nextLine();
						System.out.println("Enter Your Name");
						String can_name=sc.nextLine();
						List <candidateModel> list1=canServ.getAllCandidate(can_name);
						if(list1!=null) {
							System.out.println("Select your candidate id from list");
							System.out.println("=============================================================");
							System.out.println("Candi_Id\tCandidate Name");
							System.out.println("=============================================================");
							for(candidateModel c:list1) {
								System.out.println(c.getId()+"\t\t"+c.getName());
							}
							System.out.println("=============================================================");
						}
						else {
							System.out.println("Candidate not Found |Ragister first");
						}
						System.out.println("Enter your Candidate Id");
						int canId=sc.nextInt();
						sc.nextLine();
						System.out.println("Enter Date");
						String date=sc.nextLine();
						Date d1=new Date(date);
						String userDate=d1.toString();
						System.out.println("Enter Plates consume");
						int PlateP=sc.nextInt();
						AttendanceModel amodel=new AttendanceModel(canId,userDate,PlateP);
						b=Aserv.addAttendance(amodel);
						if(b) {
							System.out.println("Attendance Marked ");
						}
						else {
							System.out.println("Student Not Ragisterd");
						}
						break;
					case 14:
						choice=32;
						System.out.println("============================Thank You=======================");
						break;
					}
				}while(choice!=32);

				
			}else {
				System.out.println("Username Or password is wrong");
			}
		}while(choice!=32);
	}

}
