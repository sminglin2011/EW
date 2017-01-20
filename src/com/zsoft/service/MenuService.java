package com.zsoft.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.GapContent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zsoft.Dao.MenuDao;
import com.zsoft.domain.MenuCategory;
import com.zsoft.util.GeneratorId;

@Service
public class MenuService {

	@Autowired
	private MenuDao menuDao;
	
	private Map<String, Object> resultMap = new HashMap<>();
	
	/************************ Menu Category *********************************/
	public List loadMenuCategoryList() {
		return menuDao.fetchMenuCategoryList();
	}
	
	public Map<String, Object> saveMenuCategory(MenuCategory menuCategory) {
		resultMap.put("status", "y");
		resultMap.put("msg", "success");
		try {
			if (menuCategory.getCategoryId() == null || menuCategory.getCategoryId().equals("")) {
				String categoryId = GeneratorId.generate9();
				menuCategory.setCategoryId(categoryId);
				menuDao.saveMenuCategory(menuCategory);
			} else {
				menuDao.updateMenuCategory(menuCategory);
			}
		} catch (Exception e) {
			resultMap.put("status", "n");
			resultMap.put("msg", e.getMessage());
			e.printStackTrace();
		}
		
		return resultMap;
	}
}
