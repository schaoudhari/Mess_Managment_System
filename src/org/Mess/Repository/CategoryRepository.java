package org.Mess.Repository;
import java.sql.*;
import org.Mess.model.categoryModel;

public class CategoryRepository extends DBConfig{
	private int Cate_Id;
	private int getCategoryId() {
		try {
			stmt=conn.prepareStatement("select max(Cid) from category_mem");
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
	public boolean AddCategory(categoryModel cmodel){
		try {
				int catId=this.getCategoryId();
				stmt=conn.prepareStatement("insert into category_mem values(?,?,?,?)");
				stmt.setInt(1, catId);
				stmt.setString(2, cmodel.getName());
				stmt.setInt(3, cmodel.getMfees());
				stmt.setInt(4, cmodel.getPlateRate());
				int value=stmt.executeUpdate();
				if(value>0) {
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
