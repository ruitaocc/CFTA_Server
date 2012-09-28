package com.classtransaction.ui.table;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.classtransaction.model.Course;
import com.classtransaction.model.User;

public class CourseTableModel  extends DefaultTableModel{

	public final static String ID = "id";
	public final static String COURSENAME = "�γ�����";
	public final static String COURSETIME="�γ�ʱ��";
	public final static String COURSEPLACE = "�Ͽεص�";
	public final static String COURSEMASTERID="��ʦ����";
	public final static String COURSECREDIT="�γ�ѧ��";
	public final static String COURSETYPE = "�γ�����";
	public final static String COURSEREMARK="�γ̱�ע";

	private List<Course> datas;
	
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
	
	public void setDatas(List<Course> datas) {
		this.datas = datas;
	}
	
	private static final String[] columnNames = {
		ID,
		COURSENAME,
		COURSETIME,
		COURSEPLACE,
		COURSEMASTERID,
		COURSECREDIT,
		COURSETYPE,
		COURSEREMARK,
	};
	
	public Object getValueAt(int row, int column) {
		String columnName = this.getColumnName(column);
		if (this.datas != null) {
			Course course = this.datas.get(row);
			if (ID.equals(columnName)) {
				return course.getID();
			} else if (COURSENAME.equals(columnName)) {
				return course.getCOURSENAME();
			} else if (COURSETIME.equals(columnName)) {
				return course.getCOURSETIME();
			} else if (COURSEPLACE.equals(columnName)) {
				return course.getCOURSEPLACE();
			} else if (COURSEMASTERID.equals(columnName)) {
				return course.getCOURSEMASTERID();
			} else if (COURSECREDIT.equals(columnName)) {
				return course.getCOURSECREDIT();
			} else if (COURSETYPE.equals(columnName)) {
				return course.getCOURSETYPE();
			} else if (COURSEREMARK.equals(columnName)) {
				return course.getCOURSEREMARK();
			} 
			
		}
		return null;
	}
}
