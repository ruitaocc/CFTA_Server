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
	

	//数据列表
	private CourseTable dataTable;
	private CourseTableModel tableModel;
	
	//操作区域
	private Box handleBox = Box.createVerticalBox();
	
	//查询
	private Box queryBox = Box.createHorizontalBox();
	private JLabel courseNameLabel = new JLabel("课程名称: ");
	private JTextField realCourse = new JTextField(10);
	private JButton queryButton = new JButton("查询");
	
	//操作
	private Box operateBox = Box.createHorizontalBox();
	private JButton newButton = new JButton("添加课程");
	private JButton deleteButton = new JButton("删除课程");
	
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
	
	//查询方法
	private void query() {
		String realCourse = this.realCourse.getText();
		List<Course> courses = ApplicationContext.courseService.query(realCourse);
		this.tableModel.setDatas(courses);
		this.dataTable.updateUI();
	}
	
	//点击打开添加用户的对话框触发的方法
	private void addCourse() {
		this.addCourseDialog.setVisible(true);
	}
	
	//删除用户
	private void deleteCourse() {
		String courserId = ViewUtil.getSelectValue(this.dataTable, "id");
		if (courserId == null) {
			ViewUtil.showWarn("请选择需要操作的课程项", this);
			return;
		}
		int result = ViewUtil.showConfirm("是否要删除?", this);
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
	
	//创建事务列表
	private void createTable() {
		this.tableModel = new CourseTableModel();
		this.dataTable = new CourseTable(this.tableModel);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.dataTable.setPreferredScrollableViewportSize(new Dimension((int)(screen.getWidth()/1.5), (int)screen.getHeight()/3));
		this.tableScrollPane = new JScrollPane(this.dataTable);
	}
	
	//创建操作区域Box
	private void createOperateBox() {
		this.operateBox.add(this.newButton);
		this.operateBox.add(Box.createHorizontalStrut(30));
		this.operateBox.add(this.deleteButton);
		this.handleBox.add(this.operateBox);
	}
	
	//实现父类的抽象方法, 读取数据
	public void readData() {
		List<Course> courses = ApplicationContext.courseService.getCourses();
		this.tableModel.setDatas(courses);
		this.dataTable.updateUI();
	}

	//创建查询区域
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
