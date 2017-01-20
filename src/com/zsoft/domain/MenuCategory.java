package com.zsoft.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class MenuCategory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String categoryId;
	private String categoryName;
	private String sequence;
	private boolean online;
	
}
