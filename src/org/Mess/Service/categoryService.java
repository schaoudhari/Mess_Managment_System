package org.Mess.Service;

import org.Mess.Repository.CategoryRepository;
import org.Mess.model.categoryModel;

public class categoryService {
	CategoryRepository crepo =new CategoryRepository();
	public boolean AddCategory(categoryModel cmodel) {
		return crepo.AddCategory(cmodel);
	}
	
}
