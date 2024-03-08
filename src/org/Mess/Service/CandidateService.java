package org.Mess.Service;

import java.util.List;

import org.Mess.Repository.candidateRepository;
import org.Mess.model.candidateModel;
import org.Mess.model.categoryModel;

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
}
