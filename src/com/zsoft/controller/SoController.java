package com.zsoft.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zsoft.service.SoService;

@Controller
public class SoController {
	
	Logger log = Logger.getLogger(SoController.class);
	
	@Autowired
	private SoService soSvc;
	
	//封装jsonView 格式{status:y, msg:''}
	private Map<String, Object> map = new HashMap<>();

	/**************************** go to page *************************************/
	@RequestMapping(value="soMain.htm")
	public ModelAndView filterKeyword(ModelMap model, String keyword) throws Exception {
		return new ModelAndView("so/so_main");
	}
	
	/**************************** services *************************************/
	@ResponseBody
	@RequestMapping(value="/fetchAllSo.ewsvc")
	public Object fetchAllSo(ModelMap model, HttpServletResponse res) throws Exception {
		List list = soSvc.loadSoList();
		return com.zsoft.views.JsonView.Render(list, res);
	}
	@ResponseBody
	@RequestMapping(value="/keywordFetchAllSo.ewsvc")
	public Object keywordFetchAllSo(ModelMap model, HttpServletResponse res, String param) throws Exception {
		log.debug("param = ? " + param);
		List list = soSvc.keywordSearchSoList(param);
		return com.zsoft.views.JsonView.Render(list, res);
	}
	
}
