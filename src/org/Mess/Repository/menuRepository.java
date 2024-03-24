package org.Mess.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.Mess.model.candidateModel;
import org.Mess.model.menuModel;

public class menuRepository extends DBConfig{
	public List<menuModel> getAllMenu(){
		try {
			stmt=conn.prepareStatement("select * from menu");
			rs=stmt.executeQuery();
			List<menuModel> listmenu=new ArrayList<menuModel>();
			while(rs.next()) {
				menuModel model=new menuModel();
				model.setMenu_id(rs.getInt(1));
				model.setMenu_name(rs.getString(2));
				model.setDay(rs.getString(3));
				listmenu.add(model);
			}
			return listmenu.size()>0?listmenu:null;
		}catch(Exception ex) {
			System.out.println("Error is:"+ex);
			return null;
		}
	}
}
