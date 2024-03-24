package org.Mess.Service;

import java.util.List;
import java.util.Map;

import org.Mess.Repository.candidateRepository;
import org.Mess.model.BillModel;
import org.Mess.model.candidateModel;
import org.Mess.model.categoryModel;
import org.Mess.model.joinModel;

public class CandidateService {
	candidateRepository crepo=new candidateRepository();
	public boolean addCandidate(candidateModel cmodel) {
		return crepo.addCandiadate(cmodel);
	}
	public List<categoryModel> getAllCategory(){
		return crepo.getAllCategory();
	}
	public int searchCandidate(String canName) {
		return crepo.searchCandidate(canName);
	}
	public boolean addAdvance(int id,int adv) {
		return crepo.addAdvance(id, adv);
	}
	public List<candidateModel> getAllCandidate(String Can_name){
		return crepo.getAllCandidates(Can_name);
	}
	public  List<joinModel> getMonthlyBill(int id,String mno) {
		return crepo.getMonthlyBill(id,mno);
	}
//	public Map<Integer, String> getMonthlyVisit(String mno) {
//		// TODO Auto-generated method stub
//		return crepo.getMonthlyvisit(mno);
//	}
	public List<Integer> getMonthlyVisit(String mno) {
		// TODO Auto-generated method stub
		return crepo.getMonthlyvisit(mno);
	}
	public List<Integer> getMonthlyMembers() {
		// TODO Auto-generated method stub
		return crepo.getMonthlyMembers();
	}
	public List<BillModel> getMonthlybill(String name){
		return crepo.getMonthlybill(name);
	}
	public List<BillModel> getDailyWalkingBill(String date){
		return crepo.getDailyWalkingBill(date);
	}
	public boolean updateWalking(int pRate) {
		return crepo.updateWalking(pRate);
	}
	public boolean updateMonthly(int plrate) {
		return crepo.updateMonthly(plrate);
	}
}
