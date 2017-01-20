package com.zsoft.Dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zsoft.domain.MenuCategory;

@Repository
public class MenuDao {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	
	/************************ Menu Category *****************************/
	public List fetchMenuCategoryList() {
		List list = null;
		list = jdbcTemplate.queryForList("select menuGroupID as categoryId, sequence, menuGroupName as categoryName"
				+ ", webShowMenu as online from [m33MenuGroup]");
		return list;
	}
	
	public void saveMenuCategory(MenuCategory menuCategory){
		String sql = "insert into [m33MenuGroup] (menuGroupID, sequence, menuGroupName, webShowMenu) values (?, ?, ?, ?)";
		jdbcTemplate.update(sql, menuCategory.getCategoryId(), menuCategory.getSequence()
				, menuCategory.getCategoryName(), menuCategory.isOnline());
	}
	
	public void updateMenuCategory(MenuCategory menuCategory){
		String sql = "update [m33MenuGroup] set sequence=?, menuGroupName=?, webShowMenu= ? where menuGroupId = ?";
		jdbcTemplate.update(sql, menuCategory.getSequence(), menuCategory.getCategoryName()
				, menuCategory.isOnline(), menuCategory.getCategoryId());
	}
	
	
	/************************ Menu *****************************/
	public List fetchMenuList() {
		List list = null;
		list = jdbcTemplate.queryForList("select menuGroupID as categoryId, menuId, menuName, minPax, price, remarks"
				+ ", unitPrice, sequence, noItem, ledger, cookLeadTime, deliveryLeadTime, collectionLeadTime"
				+ ", multiDelivery, DelYN, DelYN, alacarte, menuItemShowImage, deliveryRef, deliveryFee"
				+ ", minTotalWaiver, minPaxWaive, minWaiverMode, addOn"
				+ ", active as online from [m33Menu]");
		return list;
	}
	
	public List fetchMenuListByCategoryId(String categoryId) {
		List list = null;
		list = jdbcTemplate.queryForList("select menuGroupID as categoryId, menuId, menuName, minPax, price, remarks"
				+ ", unitPrice, sequence, noItem, ledger, cookLeadTime, deliveryLeadTime, collectionLeadTime"
				+ ", multiDelivery, DelYN, DelYN, alacarte, menuItemShowImage, deliveryRef, deliveryFee"
				+ ", minTotalWaiver, minPaxWaive, minWaiverMode, addOn"
				+ ", active as online from [m33Menu] where menuGroupID = ?", categoryId );
		return list;
	}
	
	/************************ Menu Item Group *****************************/
	public List fetchMenuItemGroup(String menuId){
		List list = null;
		list = jdbcTemplate.queryForList("select menuCategoryType, kitchen, chief, section, sequence, itemId as groupId, addOn, addPrice"
				+ ", menuItemName as groupName, limitSelection, optional, prepareQty, prepareUnitMs, price, alacarte"
				+ ", from [m33MenuItem] where menuCategoryType='Menu-Item-Group' menuID = ?", menuId );
		return list;
	}
	
	/************************ Menu Item *****************************/
//	public MenuCategory fetchMenuCategory(int id) {
//		MenuCategory menuCategory = new MenuCategory();
//		RowMapper<MenuCategory> rowMapper = new RowMapper<MenuCategory>() {
//			public MenuCategory mapRow(ResultSet rs, int sowNum) throws SQLException {
//				MenuCategory menucategory = new MenuCategory();
//				menucategory.setId(rs.getInt("id"));
//				menucategory.setMenuCategoryName(rs.getString("menuCategoryName"));
//				menucategory.setOnlineShow(rs.getBoolean("onlineShow"));
//				return menucategory;
//			}
//		};
//		String sql = "select id, menuCategoryName, onlineShow from menuCategory where id = ?";
//		menuCategory = jdbcTemplate.queryForObject(sql, rowMapper, id);
//		return menuCategory;
//	}
	
}
