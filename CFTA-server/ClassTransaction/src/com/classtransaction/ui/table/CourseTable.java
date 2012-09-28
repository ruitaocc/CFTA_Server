package com.classtransaction.ui.table;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class CourseTable extends JTable{

	public CourseTable(CourseTableModel model) {
		super(model);
		setTableFace();
	}
	/*ID,
		COURSENAME,
		COURSETIME,
		COURSEPLACE,
		COURSEMASTERID,
		COURSECREDIT,
		COURSETYPE,
		COURSEREMARK,*/
	public void setTableFace() {
		this.getColumn(CourseTableModel.ID).setMinWidth(-1);
		this.getColumn(CourseTableModel.ID).setMaxWidth(-1);
		this.getColumn(CourseTableModel.COURSENAME).setMaxWidth(200);
		this.getColumn(CourseTableModel.COURSETIME).setMaxWidth(200);
		this.getColumn(CourseTableModel.COURSEPLACE).setMaxWidth(200);
		this.getColumn(CourseTableModel.COURSEMASTERID).setMaxWidth(200);
		this.getColumn(CourseTableModel.COURSECREDIT).setMaxWidth(200);
		this.getColumn(CourseTableModel.COURSETYPE).setMaxWidth(200);
		this.getColumn(CourseTableModel.COURSEREMARK).setMaxWidth(200);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setRowHeight(25);
		//…Ë÷√‰÷»æ∆˜
		this.getColumn(CourseTableModel.COURSENAME).setCellRenderer(new CourseTableCellRender());
		this.getColumn(CourseTableModel.COURSETIME).setCellRenderer(new CourseTableCellRender());
		this.getColumn(CourseTableModel.COURSEPLACE).setCellRenderer(new CourseTableCellRender());
		this.getColumn(CourseTableModel.COURSEMASTERID).setCellRenderer(new CourseTableCellRender());
		this.getColumn(CourseTableModel.COURSECREDIT).setCellRenderer(new CourseTableCellRender());
		this.getColumn(CourseTableModel.COURSETYPE).setCellRenderer(new CourseTableCellRender());
		this.getColumn(CourseTableModel.COURSEREMARK).setCellRenderer(new CourseTableCellRender());
	}
	
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
