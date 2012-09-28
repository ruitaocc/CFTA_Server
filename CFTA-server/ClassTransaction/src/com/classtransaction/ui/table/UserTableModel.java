package com.classtransaction.ui.table;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.classtransaction.model.User;


public class UserTableModel extends DefaultTableModel {

	public final static String USER_ID = "id";
	
	public final static String USER_NAME = "�û���";
	
	//ѧ��
	public final static String SNUMBER="ѧ����";
	//�Ա�
	public final static String GENDER = "�Ա�";
	//��������
	public final static String BIRTHDAY="����";
	//����
	public final static String ADDRESS="����";
	//����
	public final static String NATIVE_PLACE = "����";
	//�ֻ�
	public final static String PHONE="�ֻ�";
	//�̺�
	public final static String SHORTPHONE="�ֻ��̺�";
	//����
	public final static String EMAIL="����";
	

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
