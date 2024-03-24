package org.Mess.Service;

import java.util.List;

import org.Mess.Repository.menuRepository;
import org.Mess.model.menuModel;

public class menuService {
		menuRepository mrepo=new menuRepository();
		public List<menuModel> getAllMenu(){
			return mrepo.getAllMenu();
		}
}
