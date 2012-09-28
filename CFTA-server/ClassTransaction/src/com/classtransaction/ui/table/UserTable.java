package com.classtransaction.ui.table;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;


public class UserTable extends JTable {

	public UserTable(UserTableModel model) {
		super(model);
		setTableFace();
	}
	/*USER_ID,
	USER_NAME,
	SNUMBER,
	GENDER,
	BIRTHDAY,
	ADDRESS,
	NATIVE_PLACE,
	PHONE,
	SHORTPHONE,
	EMAIL*/
	public void setTableFace() {
		this.getColumn(UserTableModel.USER_ID).setMinWidth(-1);
		this.getColumn(UserTableModel.USER_ID).setMaxWidth(-1);
		this.getColumn(UserTableModel.USER_NAME).setMaxWidth(200);
		this.getColumn(UserTableModel.SNUMBER).setMaxWidth(200);
		this.getColumn(UserTableModel.GENDER).setMaxWidth(200);
		this.getColumn(UserTableModel.BIRTHDAY).setMaxWidth(200);
		this.getColumn(UserTableModel.ADDRESS).setMaxWidth(200);
		this.getColumn(UserTableModel.NATIVE_PLACE).setMaxWidth(200);
		this.getColumn(UserTableModel.PHONE).setMaxWidth(200);
		this.getColumn(UserTableModel.SHORTPHONE).setMaxWidth(200);
		this.getColumn(UserTableModel.EMAIL).setMaxWidth(200);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setRowHeight(25);
		//…Ë÷√‰÷»æ∆˜
		this.getColumn(UserTableModel.USER_NAME).setCellRenderer(new UserTableCellRenderer());
		this.getColumn(UserTableModel.SNUMBER).setCellRenderer(new UserTableCellRenderer());
		this.getColumn(UserTableModel.GENDER).setCellRenderer(new UserTableCellRenderer());
		this.getColumn(UserTableModel.BIRTHDAY).setCellRenderer(new UserTableCellRenderer());
		this.getColumn(UserTableModel.ADDRESS).setCellRenderer(new UserTableCellRenderer());
		this.getColumn(UserTableModel.NATIVE_PLACE).setCellRenderer(new UserTableCellRenderer());
		this.getColumn(UserTableModel.PHONE).setCellRenderer(new UserTableCellRenderer());
		this.getColumn(UserTableModel.SHORTPHONE).setCellRenderer(new UserTableCellRenderer());
		this.getColumn(UserTableModel.EMAIL).setCellRenderer(new UserTableCellRenderer());
	}
	
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
