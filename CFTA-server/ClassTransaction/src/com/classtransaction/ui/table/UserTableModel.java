package com.classtransaction.ui.table;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.classtransaction.model.User;


public class UserTableModel extends DefaultTableModel {

	public final static String USER_ID = "id";
	
	public final static String USER_NAME = "用户名";
	
	//学号
	public final static String SNUMBER="学生号";
	//性别
	public final static String GENDER = "性别";
	//出生日期
	public final static String BIRTHDAY="生日";
	//宿舍
	public final static String ADDRESS="宿舍";
	//籍贯
	public final static String NATIVE_PLACE = "籍贯";
	//手机
	public final static String PHONE="手机";
	//短号
	public final static String SHORTPHONE="手机短号";
	//邮箱
	public final static String EMAIL="邮箱";
	

	private List<User> datas;
	
	public int getRowCount() {
		if (this.datas != null) {
			return this.datas.size();
		}
		return 0;
	}
	
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	public int getColumnCount() {
		return columnNames.length;
	}
	
	public void setDatas(List<User> datas) {
		this.datas = datas;
	}
	
	private static final String[] columnNames = {
		USER_ID,
		USER_NAME,
		SNUMBER,
		GENDER,
		BIRTHDAY,
		ADDRESS,
		NATIVE_PLACE,
		PHONE,
		SHORTPHONE,
		EMAIL
	};
	
	@Override
	public Object getValueAt(int row, int column) {
		String columnName = this.getColumnName(column);
		if (this.datas != null) {
			User user = this.datas.get(row);
			if (USER_ID.equals(columnName)) {
				return user.getID();
			} else if (USER_NAME.equals(columnName)) {
				return user.getUSER_NAME();
			} else if (SNUMBER.equals(columnName)) {
				return user.getSNUMBER();
			} else if (GENDER.equals(columnName)) {
				return user.getGENDER();
			} else if (BIRTHDAY.equals(columnName)) {
				return user.getBIRTHDAY();
			} else if (ADDRESS.equals(columnName)) {
				return user.getADDRESS();
			} else if (NATIVE_PLACE.equals(columnName)) {
				return user.getNATIVE_PLACE();
			} else if (PHONE.equals(columnName)) {
				return user.getPHONE();
			} else if (SHORTPHONE.equals(columnName)) {
				return user.getSHORTPHONE();
			} else if (EMAIL.equals(columnName)) {
				return user.getEMAIL();
			}
			
		}
		return super.getValueAt(row, column);
	}
}
