package com.zsoft.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class Menu implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 395973574607885684L;
	
	private String menuId;
	private String menuName;
	private String categoryId;
	private MenuCategory menuCategory;
	private int minPax;
	private double price;
	private String remarks;
	private double unitPrice;
	private String sequence;
	private int noItem;
	private int ledger;
	private int cookLeadTime;
	private int deliveryLeadTime;
	private int collectionLeadTime;
	private String multiDelivery;
	private boolean delYN;
	private boolean colYN;
	private boolean alacarte;
	private boolean menuItemShowImage;
	private String deliveryRef;
	private double deliveryFee;
	private double minTotalWaiver;
	private int minPaxWaiver;
	private String minWaiverMode;
	private boolean addOn;

//	price, remarks"
//			+ ", unitPrice, sequence, noItem, ledger, cookLeadTime, deliveryLeadTime, collectionLeadTime"
//			+ ", multiDelivery, DelYN, DelYN, alacarte, menuItemShowImage, deliveryRef, deliveryFee"
//			+ ", minTotalWaiver, minPaxWaiver, minWaiverMode, addOn
}
