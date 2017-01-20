package com.zsoft.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class MenuItemGroup implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4128562180544381460L;
	
	private String menuItemGroupId;
	private String groupName;
}
