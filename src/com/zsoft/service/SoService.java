package com.zsoft.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import com.zsoft.Dao.SoDao;
import com.zsoft.Dao.UserDao;
import com.zsoft.domain.User;
import com.zsoft.exception.ParameterException;

@Service
public class SoService {

	Logger log = Logger.getLogger(SoService.class);
	
	@Autowired
	private SoDao soDao;
	
	private Map<String, Object> map = new HashMap<>();
	
	public List loadSoList() throws Exception {
		return soDao.fetchSoList();
	}
	
	public List keywordSearchSoList(String keyword) throws Exception {
		return soDao.keywordFetchSoList(keyword);
	}
}
