package org.Mess.admin;

import java.util.*;
import org.Mess.Repository.CategoryRepository;
import org.Mess.Service.AdminLoginService;
import org.Mess.Service.AttendanceService;
import org.Mess.Service.CandidateService;
import org.Mess.Service.categoryService;
import org.Mess.Service.menuService;
import org.Mess.model.AttendanceModel;
import org.Mess.model.BillModel;
import org.Mess.model.candidateModel;
import org.Mess.model.categoryModel;
import org.Mess.model.joinModel;
import org.Mess.model.menuModel;

public class MessManagmentApplication {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		categoryService cservice = new categoryService();
		CandidateService canServ = new CandidateService();
		AdminLoginService aservice = new AdminLoginService();
		AttendanceService Aserv = new AttendanceService();
		menuService mservice = new menuService();
		int choice = 0;
		do {
			System.out.println("----------------Enter Login Credentials--------------------");
			System.out.println("\t\tEnter Username\t\t");
			String uname = sc.nextLine();
			System.out.println("\t\tEnter Password\t\t");
			String password = sc.nextLine();
			boolean check = aservice.checkUserPass(uname, password);
			if (check) {
				System.out.println("User Loged In Successfull");
				do {
					System.out.println("\n");
					System.out.println("1:Add Member Category");
					System.out.println("2:Ragister Candidate");
					System.out.println("3:Admit Candidate with Advance Amount");
					System.out.println("4:Take Attendance Of Candidate");
					System.out.println("5:Show the Upcoming Week Menu to candidate");
					System.out.println("6:Calculate Monthly bill of candidate");
					System.out.println("7:Count the total number of candidate visit in month for walking");
					System.out.println("8:Count monthly member ");
					System.out.println("9:Find the total bill from monthly member");  
					System.out.println("10:Find the total bill of walking member ");
					System.out.println("11. Set the per plate rate for walking member");
				    System.out.println("12. Set the monthly fees for monthly member");
					System.out.println("13:Exit");
					System.out.println("Enter Your choice");
					choice = sc.nextInt();
					switch (choice) {
					case 1:
						sc.nextLine();
						System.out.println("-----------Enter Below Details----------");
						System.out.println("\tEnter Category Name : ");
						System.out.println("\t1:Monthly Member");
						System.out.println("\t2:Daily Walking User");
						String name = sc.nextLine();
						System.out.println("\tEnter Monthly Fees");
						int Mfees = sc.nextInt();
						System.out.println("\tEnter Per-Plate Rate");
						int per_plate = sc.nextInt();
						categoryModel cmodel = new categoryModel(name, Mfees, per_plate);
						boolean b = cservice.AddCategory(cmodel);
						if (b) {
							System.out.println("Data Added Successfully....");
						} else {
							System.out.println("Data Not Added.....");
						}
						break;
					case 2:
						sc.nextLine();
						List<categoryModel> list = canServ.getAllCategory();
						System.out.println("Enter Candidate Name");
						String cName = sc.nextLine();
						System.out.println("Enter Candidate Age");
						int age = sc.nextInt();
						System.out.println("=============================================================");
						System.out.println("Category_Id\t Category Name\t Monthly_Fees\tPer_Plate_Rate");
						System.out.println("=============================================================");
						for (categoryModel m : list) {
							System.out.println(m.getId() + "\t\t" + m.getName() + "\t\t\t" + m.getMfees() + "\t\t"
									+ m.getPlateRate());
						}
						System.out.println("=============================================================");
						System.out.println("Enter Catigory id");
						int cat_Id = sc.nextInt();
						candidateModel Cmodel = new candidateModel(cName, age, cat_Id);
						b = canServ.addCandidate(Cmodel);
						if (b) {
							System.out.println("Ragistration successfull.......");
						} else {
							System.out.println("Some problem is there..........");
						}
						break;
					case 3:
						sc.nextLine();
						System.out.println("Enter Candidate Name");
						String canName = sc.nextLine();
						int can_id = canServ.searchCandidate(canName);
						if (can_id > 0) {
							System.out.println("Enter Advance amount to Admit in 3000");
							int adv_amt = sc.nextInt();
							b = canServ.addAdvance(can_id, adv_amt);
							if (b) {
								System.out.println("Advance Added |Admitted.....");
							} else {
								System.out.println("Advance not addede....");
							}
						} else if (can_id == -1) {
							System.out.println("Ragistration Not Completed | Please Complete First Ragistration");
						} else {
							System.out.println("Something is Fishey");
						}
						break;
					case 4:
						sc.nextLine();
						System.out.println("Enter Your Name");
						String can_name = sc.nextLine();
						List<candidateModel> list1 = canServ.getAllCandidate(can_name);
						if (list1 != null) {
							System.out.println("Select your candidate id from list");
							System.out.println("=============================================================");
							System.out.println("Candi_Id\tCandidate Name");
							System.out.println("=============================================================");
							for (candidateModel c : list1) {
								System.out.println(c.getId() + "\t\t" + c.getName());
							}
							System.out.println("=============================================================");
						} else {
							System.out.println("Candidate not Found |Ragister first");
						}
						System.out.println("Enter your Candidate Id");
						int canId = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter Date");
						String date = sc.nextLine();
						Date d1 = new Date(date);
						String userDate = d1.toString();
						System.out.println("Enter Plates consume");
						int PlateP = sc.nextInt();
						AttendanceModel amodel = new AttendanceModel(canId, userDate, PlateP);
						b = Aserv.addAttendance(amodel);
						if (b) {
							System.out.println("Attendance Marked ");
						} else {
							System.out.println("Student Not Ragisterd");
						}
						break;
					case 5:
						sc.nextLine();
						List<menuModel> list2 = mservice.getAllMenu();
						if (list2 != null) {
							System.out.println("menu list of next week");
							System.out.println("=============================================================");
							System.out.println("Menu_Id\tMenu Name\tMenu_Day");
							System.out.println("=============================================================");
							for (menuModel c : list2) {
								System.out.println(c.getMenu_id() + "\t" + c.getMenu_name() + "\t" + c.getDay());
							}
							System.out.println("=============================================================");
						}

						break;
					case 6:
						sc.nextLine();
						System.out.println("Enter Your Name");
						String can_name1 = sc.nextLine();
						List<candidateModel> list3 = canServ.getAllCandidate(can_name1);
						if (list3 != null) {
							System.out.println("Select your candidate id from list");
							System.out.println("=============================================================");
							System.out.println("Candi_Id\tCandidate Name");
							System.out.println("=============================================================");
							for (candidateModel c : list3) {
								System.out.println(c.getId() + "\t\t" + c.getName());
							}
							System.out.println("=============================================================");
							System.out.println("Enter your Candidate Id");
							canId = sc.nextInt();
							sc.nextLine();
							System.out.println("Please include 0 if month is less than or equal between 1 to 9");
							System.err.println("01- to -09\n03");
							System.out.println("Enter A month number");
							String mno = sc.nextLine();
							List<joinModel> list4 = canServ.getMonthlyBill(canId, mno);
							if (list4 != null) {
								System.out.println("menu list of next week");
								System.out.println("=============================================================");
								System.out.println("Candiadate name\t\tTotal consumed Plates\tMonthly bill");
								System.out.println("=============================================================");
								for (joinModel c : list4) {
									System.out.println(c.getName() + "\t\t" + c.getCount_plate() + "\t" + c.getSum() + "\t"
											+ c.getCname());
								}
								System.out.println("=============================================================");
							} else {
								System.out.println("Something wrong");
							}
						} else {
							System.out.println("Candidate not Found |Ragister first");
						}
						//if candidate not found then still it will show this and thats wrong!!
						
						break;
					
					  case 7:
					  sc.nextLine(); 
					  System.out.println("Please include 0 if month is less than or equal between 1 to 9"); 
					  System.err.println("01- to -09\n01-03-2024"); 
					  System.err.println("Enter Month Number");  
					  String mno=sc.nextLine(); 
					  List<Integer> list5=canServ.getMonthlyVisit(mno);  
					  if(list5!=null) { 
						 System.out.println("Total Number of Vistors in Month Are:");
						 for(Integer data : list5) {
							 System.err.println("||\t"+data+"\t||");
						 }
					  }
					  break;  
					  case 8:
						  sc.nextLine();
						  List<Integer> list6=canServ.getMonthlyMembers(); // 
						  if(list6!=null) { 
							 System.out.println("Total Monthly Members Are:");
							 for(Integer data : list6) {
								 System.err.println("||\t"+data+"\t||");
							 }
						  }
						  break;
						  
						  
					  case 9:
						  sc.nextLine();
						  System.out.println("Enter Candidate Name to calculate bill");
						  name=sc.nextLine(); 
						  List<BillModel> list8 = canServ.getMonthlybill(name);
							if (list8 != null) {
								System.out.println("Name\tConsumed Plates\t Total Bill");
								System.out.println("=============================================================");
								for (BillModel c : list8) {
									System.out.println(c.getName()+"\t\t"+c.getTotal_Plates()+"\t\t"+c.getTotal_Amount());
								}
								System.out.println("=============================================================");
							} else {
								//if candidate 
								System.out.println("Something wrong");
							}
						  break;
					  case 10:
						  sc.nextLine();
						  System.out.println("Enter date to calculate Walking bill");
						  System.err.println("Please enter like this ");
						  System.err.println("2024-01-01");
						  date=sc.nextLine(); 
						  List<BillModel> list9 = canServ.getDailyWalkingBill(date);
							if (list9 != null) {
								System.out.println("Name\tConsumed Plates\t Total Bill");
								System.err.println("=============================================================");
								for (BillModel c : list9) {
									System.out.println(c.getName()+"\t\t"+c.getTotal_Plates()+"\t\t"+c.getTotal_Amount());
								}
								System.err.println("=============================================================");
							} else {
								System.out.println("Something wrong");
							}
						  break;
					  case 11:
						  sc.nextLine();
						  System.out.println("Enter Rate To update");
						  int prate=sc.nextInt();
								b = canServ.updateWalking(prate);
								if (b) {
									System.out.println("Rate Updated");
								} else {
									System.out.println("Rate not Updated ");
								}
						  break;
					  case 12:
						  sc.nextLine();
						  System.out.println("Enter Rate To update");
						  int plrate=sc.nextInt();
								b = canServ.updateMonthly(plrate);
								if (b) {
									System.out.println("Rate Updated");
								} else {
									System.out.println("Rate not Updated ");
								}
						  break;  
					  case 13:
						choice = 32;
						System.err.println("============================Thank You=======================");
						break;
					}
				} while (choice != 32);

			} else {
				System.out.println("Username Or password is wrong");
			}
		} while (choice != 32);
	}

}
