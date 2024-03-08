package org.Mess.Repository;

import java.util.ArrayList;
import java.util.List;
import org.Mess.model.candidateModel;
import org.Mess.model.categoryModel;

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
}
