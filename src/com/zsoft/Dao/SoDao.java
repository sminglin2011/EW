package com.zsoft.Dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SoDao {

Logger log = Logger.getLogger(SoDao.class);
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	
	public List fetchSoList() throws Exception {
		List list = null;
		String sql = "select postStatus, ast, soNumber, eventDate, custName, noPax, incoTerm"
				+ " from m02So where poststatus <> 'V'";
		list = jdbcTemplate.queryForList(sql);
		return list;
	}
	
	public List keywordFetchSoList(String keyword) throws Exception {
		List list = null;
		String sql = "select postStatus, ast, soNumber, eventDate, custName, noPax, incoTerm"
				+ " from m02So where poststatus <> 'V'"
				+ " and ("
				+ " soNumber like '%"+keyword+"%'"
				+ " or eventDate like '%"+keyword+"%'"
				+ " or custName like '%"+keyword+"%'"
				+ " or noPax like '%"+keyword+"%'"
				+ " or incoTerm like '%"+keyword+"%'"
				+ ")";
		list = jdbcTemplate.queryForList(sql);
		return list;
	}
}
