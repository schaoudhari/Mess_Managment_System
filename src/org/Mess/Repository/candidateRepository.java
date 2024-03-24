package org.Mess.Repository;
import java.util.*;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.Mess.model.AttendanceModel;
import org.Mess.model.BillModel;
import org.Mess.model.candidateModel;
import org.Mess.model.categoryModel;
import org.Mess.model.joinModel;

public class candidateRepository extends DBConfig{
	public List< categoryModel> getAllCategory(){
		try {
			stmt=conn.prepareStatement("select * from category_mem");
			rs=stmt.executeQuery();
			List<categoryModel> listExams=new ArrayList<categoryModel>();
			while(rs.next()) {
				categoryModel model=new categoryModel();
				model.setId(rs.getInt(1));
				model.setName(rs.getString(2));
				model.setMfees(rs.getInt(3));
				model.setPlateRate(rs.getInt(4));
				listExams.add(model);
			}
			return listExams.size()>0?listExams:null;
		}catch(Exception ex) {
			System.out.println("Error is"+ex);
			return null;
		}
	}
	private int Cate_Id;
	private int getCandidateId() {
		try {
			stmt=conn.prepareStatement("select max(Can_id) from candidate");
			rs=stmt.executeQuery();
			if(rs.next()) {
				Cate_Id=rs.getInt(1);
			}
			++Cate_Id;
		}catch(Exception ex) {
			System.out.println("Error is"+ex);
		}
		return Cate_Id;
	}
	public boolean addCandiadate(candidateModel cmodel) {
		try {
			int cand_id=this.getCandidateId();
			stmt=conn.prepareStatement("insert into candidate(can_id,can_name,can_age,category_id)values(?,?,?,?)");
			stmt.setInt(1,cand_id);
			stmt.setString(2,cmodel.getName());
			stmt.setInt(3, cmodel.getAge());
			stmt.setInt(4, cmodel.getCate_id());
			int value=stmt.executeUpdate();
			if(value==1) {
				return true;
			}
			else {
				return false;
			}
		}catch(Exception ex) {
			System.out.println("Error is"+ex);
		}
		return false;
	}
	public int searchCandidate(String canName) {
		try {
			stmt=conn.prepareStatement("select can_id from candidate where can_name=?");
			stmt.setString(1, canName);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			else {
				return -1;
			}
		}catch(Exception ex) {
			System.out.println("Error is"+ex);
		}
		return 1;
	}
	public boolean addAdvance(int id,int adv) {
		try {
			stmt=conn.prepareStatement("update candidate set adv_amt=? where can_id=?");
			stmt.setInt(1, adv);
			stmt.setInt(2, id);
			int value=stmt.executeUpdate();
			if(value==1) {
				return true;
			}
			else {
				return false;
			}
		}catch(Exception ex) {
			System.out.println("Error is"+ex);
			return false;
		}
	}
	public List<candidateModel> getAllCandidates(String canName){
		try {
			stmt=conn.prepareStatement("select can_id,can_name from candidate where can_name='"+canName+"' ");
			rs=stmt.executeQuery();
			
			List<candidateModel> listExams=new ArrayList<candidateModel>();
			while(rs.next()) {
				candidateModel model=new candidateModel();
				model.setId(rs.getInt(1));
				model.setName(rs.getString(2));
				listExams.add(model);
			}
			return listExams.size()>0?listExams:null;
		}catch(Exception ex) {
			System.out.println("Error is"+ex);
			return null;
		}
	}
	public List<joinModel>getMonthlyBill(int id,String mno) {
		try {
			int cid=id;
			stmt=conn.prepareStatement(" select c.can_name,count(p.plate),sum(p.plate*cm.plate_rate),cm.cname from attendance p inner join candidate c on p.can_id=c.can_id inner join category_mem cm on c.category_id=cm.cid where c.can_id="+cid+" and cm.cname='monthly' and p.date like '%-"+mno+"-%' group by can_name;");
			rs=stmt.executeQuery();
			List<joinModel> listExams=new ArrayList<joinModel>();
			while(rs.next()) {
				joinModel jmodel=new joinModel();
				jmodel.setName(rs.getString(1));
				jmodel.setCount_plate(rs.getInt(2));
				jmodel.setSum(rs.getInt(3));
				jmodel.setCname(rs.getString(4));
				listExams.add(jmodel);
			}
			return listExams.size()>0?listExams:null;
		}catch(Exception ex) {
			System.out.println("Error is"+ex);
			return null;
		}
//		return false;
	}
	/*public Map<Integer, String> getMonthlyvisit(String mno) {
//		int cid=id;
		try {
			stmt=conn.prepareStatement(" select count(a.attend_id) from candidate c inner join attendance a on a.can_id=c.can_id where a.date like '%-"+mno+"-%';");
			rs=stmt.executeQuery();
			
	//		List<joinModel> listExams=new ArrayList<joinModel>();
			Map<Integer,String> map = new LinkedHashMap<>();
			while(rs.next()) {
				int id=rs.getInt(1);
				String val = rs.getString(2);
			   map.put(id, val);
			}
			return map;
		}catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
	}*/
	
	public List<Integer> getMonthlyvisit(String mno) {
//		int cid=id;
		try {
			stmt=conn.prepareStatement(" select count(a.attend_id) from candidate c inner join attendance a on a.can_id=c.can_id where a.date like '%-"+mno+"-%';");
			rs=stmt.executeQuery();
			
	//		List<joinModel> listExams=new ArrayList<joinModel>();
			List<Integer> map = new ArrayList<>();
			while(rs.next()) {
				int id=rs.getInt(1);
				//String val = rs.getString(2);
			   map.add(id);
			}
			return map;
		}catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	public List<Integer> getMonthlyMembers() {
		try {
			stmt=conn.prepareStatement("select count(can_name) from candidate where category_id=1;");
			rs=stmt.executeQuery();
			List<Integer> map = new ArrayList<>();
			while(rs.next()) {
				int id=rs.getInt(1);
				//String val = rs.getString(2);
			   map.add(id);
			}
			return map;
		}catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
//	
	public List<BillModel> getMonthlybill(String cname) {
		try {
			stmt=conn.prepareStatement("select c.can_name,sum(a.plate),sum(a.plate*cm.plate_rate) from candidate c inner join category_mem cm on c.category_id=cm.cid inner join attendance a on a.can_id=c.can_id where c.can_name='"+cname+"' group by c.can_name;");
			rs=stmt.executeQuery();
			List<BillModel> map = new ArrayList<BillModel>();
			while(rs.next()) {
				BillModel bmodel=new BillModel();
				bmodel.setName(rs.getString(1));
				bmodel.setTotal_Plates(rs.getInt(2));
				bmodel.setTotal_Amount(rs.getInt(3));
				map.add(bmodel);
			}
			return map.size()>0?map:null;
		}catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	public List<BillModel> getDailyWalkingBill(String date) {
		try {
			stmt=conn.prepareStatement("select c.can_name,sum(a.plate),sum(a.plate*cm.plate_rate) from candidate c inner join attendance a on c.can_id=a.can_id inner join category_mem cm on c.category_id=cm.cid where c.category_id=2 and a.date like '%"+date+"%' group by c.can_name;");
			rs=stmt.executeQuery();
			List<BillModel> map = new ArrayList<BillModel>();
			while(rs.next()) {
				BillModel bmodel=new BillModel();
				bmodel.setName(rs.getString(1));
				bmodel.setTotal_Plates(rs.getInt(2));
				bmodel.setTotal_Amount(rs.getInt(3));
				map.add(bmodel);
			}
			return map.size()>0?map:null;
		}catch(Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	public boolean updateWalking(int prate) {
		try {
			stmt=conn.prepareStatement("update category_mem set plate_rate=? where cname='daily walking user';");
			stmt.setInt(1, prate);
			int value=stmt.executeUpdate();
			if(value==1) {
				return true;
			}
			else {
				return false;
			}
		}catch(Exception ex) {
			System.out.println("Error is"+ex);
			return false;
		}
	}
	public boolean updateMonthly(int plrate) {
		try {
			stmt=conn.prepareStatement("update category_mem set plate_rate=? where cname='monthly';");
			stmt.setInt(1, plrate);
			int value=stmt.executeUpdate();
			if(value==1) {
				return true;
			}
			else {
				return false;
			}
		}catch(Exception ex) {
			System.out.println("Error is"+ex);
			return false;
		}
	}

}
