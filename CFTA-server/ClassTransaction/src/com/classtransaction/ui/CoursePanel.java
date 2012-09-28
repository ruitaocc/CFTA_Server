package com.classtransaction.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.classtransaction.model.Course;
import com.classtransaction.model.User;
import com.classtransaction.ui.dialog.AddCourseDialog;
import com.classtransaction.ui.dialog.AddUserDialog;
import com.classtransaction.ui.table.CourseTable;
import com.classtransaction.ui.table.CourseTableModel;
import com.classtransaction.ui.table.UserTable;
import com.classtransaction.ui.table.UserTableModel;
import com.classtransaction.util.ApplicationContext;
import com.classtransaction.util.ViewUtil;

public class CoursePanel extends BasePanel{

	private JScrollPane tableScrollPane;
	

	//�����б�
	private CourseTable dataTable;
	private CourseTableModel tableModel;
	
	//��������
	private Box handleBox = Box.createVerticalBox();
	
	//��ѯ
	private Box queryBox = Box.createHorizontalBox();
	private JLabel courseNameLabel = new JLabel("�γ�����: ");
	private JTextField realCourse = new JTextField(10);
	private JButton queryButton = new JButton("��ѯ");
	
	//����
	private Box operateBox = Box.createHorizontalBox();
	private JButton newButton = new JButton("��ӿγ�");
	private JButton deleteButton = new JButton("ɾ���γ�");
	
	private AddCourseDialog addCourseDialog;
	
	public CoursePanel() {
		this.addCourseDialog = new AddCourseDialog(this);
		BoxLayout mainLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(mainLayout);
		createTable();
		createQueryBox();
		createOperateBox();
		this.handleBox.add(Box.createVerticalStrut(20));
		this.handleBox.add(this.queryBox);
		this.handleBox.add(Box.createVerticalStrut(20));
		this.handleBox.add(this.operateBox);
		this.handleBox.add(Box.createVerticalStrut(20));
		this.add(this.handleBox);
		this.add(this.tableScrollPane);
		initListeners();
	}
	
	private void initListeners() {
		this.queryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				query();
			}
		});
		this.newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addCourse();
			}
		});
		this.deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteCourse();
			}
		});
	}
	
	//��ѯ����
	private void query() {
		String realCourse = this.realCourse.getText();
		List<Course> courses = ApplicationContext.courseService.query(realCourse);
		this.tableModel.setDatas(courses);
		this.dataTable.updateUI();
	}
	
	//���������û��ĶԻ��򴥷��ķ���
	private void addCourse() {
		this.addCourseDialog.setVisible(true);
	}
	
	//ɾ���û�
	private void deleteCourse() {
		String courserId = ViewUtil.getSelectValue(this.dataTable, "id");
		if (courserId == null) {
			ViewUtil.showWarn("��ѡ����Ҫ�����Ŀγ���", this);
			return;
		}
		int result = ViewUtil.showConfirm("�Ƿ�Ҫɾ��?", this);
		if (result == 0) {
			try {
				ApplicationContext.courseService.delete(courserId);
				//reflesh
				this.readData();
			} catch (Exception e) {
				ViewUtil.showWarn(e.getMessage(), this);
			}
		}
	}
	
	//���������б�
	private void createTable() {
		this.tableModel = new CourseTableModel();
		this.dataTable = new CourseTable(this.tableModel);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.dataTable.setPreferredScrollableViewportSize(new Dimension((int)(screen.getWidth()/1.5), (int)screen.getHeight()/3));
		this.tableScrollPane = new JScrollPane(this.dataTable);
	}
	
	//������������Box
	private void createOperateBox() {
		this.operateBox.add(this.newButton);
		this.operateBox.add(Box.createHorizontalStrut(30));
		this.operateBox.add(this.deleteButton);
		this.handleBox.add(this.operateBox);
	}
	
	//ʵ�ָ���ĳ��󷽷�, ��ȡ����
	public void readData() {
		List<Course> courses = ApplicationContext.courseService.getCourses();
		this.tableModel.setDatas(courses);
		this.dataTable.updateUI();
	}

	//������ѯ����
	private void createQueryBox() {
		this.queryBox.add(Box.createHorizontalStrut(100));
		this.queryBox.add(this.courseNameLabel);
		this.queryBox.add(this.realCourse);
		this.queryBox.add(Box.createHorizontalStrut(20));
		this.queryBox.add(this.queryButton);
		this.queryBox.add(Box.createHorizontalStrut(100));
		this.handleBox.add(this.queryBox);
	}
}
