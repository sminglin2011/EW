package com.zsoft.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zsoft.domain.MenuCategory;
import com.zsoft.service.MenuService;
import com.zsoft.service.SoService;

@Controller
public class MenuController {
	
	Logger log = Logger.getLogger(MenuController.class);
	
	@Autowired
	private MenuService menuSvc;
	
	//封装jsonView 格式{status:y, msg:''}
	private Map<String, Object> map = new HashMap<>();

	/**************************** go to page *************************************/
	@RequestMapping(value="menuMain.htm")
	public ModelAndView filterKeyword(ModelMap model, String keyword) throws Exception {
		return new ModelAndView("menu/menu_main");
	}
	@RequestMapping(value="menuItemMain.htm")
	public ModelAndView menuItemMain(ModelMap model) {
		return new ModelAndView("menu/menu_item_main");
	}
	@RequestMapping(value="menuCategoryMain.htm")
	public ModelAndView menuCategoryMain(ModelMap model) {
		return new ModelAndView("menu/menu_category");
	}
	@RequestMapping(value="menuList.htm")
	public ModelAndView menuList(ModelMap model) {
		return new ModelAndView("menu/menu_list");
	}
	@RequestMapping(value="menuItemGroupMain.htm")
	public ModelAndView menuItemGroupMain(ModelMap model) {
		return new ModelAndView("menu/menuitem_group");
	}
	
	
	/**************************** services *************************************/
	@ResponseBody
	@RequestMapping(value="/fetchMenuCategory.ewsvc")
	public Object fetchMenuCategory(ModelMap model, HttpServletResponse res) throws Exception {
		return com.zsoft.views.JsonView.Render(menuSvc.loadMenuCategoryList(), res);
	}
	
	@ResponseBody
	@RequestMapping(value="/saveMenuCategory.ewsvc")
	public Object saveMenuCategory(ModelMap model, HttpServletResponse res, @RequestBody MenuCategory menuCategory) throws Exception {
		map = menuSvc.saveMenuCategory(menuCategory);
		return com.zsoft.views.JsonView.Render(map, res);
	}
	
	
	@ResponseBody
	@RequestMapping(value="/fetchMenu.ewsvc")
	public Object fetchMenu(ModelMap model, HttpServletResponse res) throws Exception {
		return com.zsoft.views.JsonView.Render(map, res);
	}
	@ResponseBody
	@RequestMapping(value="/fetchMenuItemGroup.ewsvc")
	public Object fetchMenuItemGroup(ModelMap model, HttpServletResponse res) throws Exception {
		return com.zsoft.views.JsonView.Render(map, res);
	}
	
}
