package com.classtransaction.ui.dialog;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.classtransaction.model.Course;
import com.classtransaction.model.User;
import com.classtransaction.ui.CoursePanel;
import com.classtransaction.ui.UserPanel;
import com.classtransaction.util.ApplicationContext;
import com.classtransaction.util.ViewUtil;

public class AddCourseDialog extends JDialog{
	//课程编号
	private JLabel courseIDLabel = new JLabel("课程编号:");
	private JTextField courseID = new JTextField(10);
	//课程名称
	private JLabel courseNameLabel = new JLabel("课程名称:");
	private JTextField courseName = new JTextField(10);

	//上课时间
	private JLabel courseTimeLabel = new JLabel("上课时间:");
	private JTextField courseTime = new JTextField(10);

	//上课地点
	private JLabel coursePlaceLabel = new JLabel("上课地点:");
	private JTextField coursePlace = new JTextField(10);
	//教师姓名
	private JLabel courseMasterIdLabel = new JLabel("教师姓名:");
	private JTextField courseMasterId = new JTextField(10);
	//课程学分
	private JLabel courseCreditLabel = new JLabel("课程学分:");
	private JTextField courseCredit = new JTextField(10);
	//课程类别
	private JLabel courseTypeLabel = new JLabel("课程类别:");
	private JTextField courseType = new JTextField(20);

	//课程备注
	private JLabel courseRemarkLabel = new JLabel("课程备注:");
	private JTextField courseRemark = new JTextField(20);
	//按钮
	private JButton confirmButton = new JButton("确定");
	private JButton cancelButton = new JButton("取消");
	private CoursePanel coursePanel;
	public AddCourseDialog(CoursePanel coursePanel) {
		this.coursePanel = coursePanel;
		//课程编号
		Box courseIDBox = Box.createHorizontalBox();
		courseIDBox.add(Box.createHorizontalStrut(43));
		courseIDBox.add(this.courseIDLabel);
		courseIDBox.add(this.courseID);
		courseIDBox.add(Box.createHorizontalStrut(30));
		//课程名称
		Box courseNameBox = Box.createHorizontalBox();
		courseNameBox.add(Box.createHorizontalStrut(43));
		courseNameBox.add(this.courseNameLabel);
		courseNameBox.add(this.courseName);
		courseNameBox.add(Box.createHorizontalStrut(30));
		//上课时间
		Box courseTimeBox = Box.createHorizontalBox();
		courseTimeBox.add(Box.createHorizontalStrut(43));
		courseTimeBox.add(this.courseTimeLabel);
		courseTimeBox.add(this.courseTime);
		courseTimeBox.add(Box.createHorizontalStrut(30));
		//上课地点
		Box coursePlaceBox = Box.createHorizontalBox();
		coursePlaceBox.add(Box.createHorizontalStrut(43));
		coursePlaceBox.add(this.coursePlaceLabel);
		coursePlaceBox.add(this.coursePlace);
		coursePlaceBox.add(Box.createHorizontalStrut(30));
		//教师姓名
		Box courseMasterIdBox = Box.createHorizontalBox();
		courseMasterIdBox.add(Box.createHorizontalStrut(43));
		courseMasterIdBox.add(this.courseMasterIdLabel);
		courseMasterIdBox.add(this.courseMasterId);
		courseMasterIdBox.add(Box.createHorizontalStrut(30));
		//课程学分
		Box courseCreditBox = Box.createHorizontalBox();
		courseCreditBox.add(Box.createHorizontalStrut(43));
		courseCreditBox.add(this.courseCreditLabel);
		courseCreditBox.add(this.courseCredit);
		courseCreditBox.add(Box.createHorizontalStrut(30));
		//课程类别
		Box courseTypeBox = Box.createHorizontalBox();
		courseTypeBox.add(Box.createHorizontalStrut(43));
		courseTypeBox.add(this.courseTypeLabel);
		courseTypeBox.add(this.courseType);
		courseTypeBox.add(Box.createHorizontalStrut(30));
		//课程备注
		Box nativeRemarkBox = Box.createHorizontalBox();
		nativeRemarkBox.add(Box.createHorizontalStrut(43));
		nativeRemarkBox.add(this.courseRemarkLabel);
		nativeRemarkBox.add(this.courseRemark);
		nativeRemarkBox.add(Box.createHorizontalStrut(30));
		//按钮
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(this.confirmButton);
		buttonBox.add(Box.createHorizontalStrut(40));
		buttonBox.add(this.cancelButton);

		Box mainBox = Box.createVerticalBox();
		mainBox.add(Box.createVerticalStrut(20));
		mainBox.add(courseIDBox);

		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(courseNameBox);

		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(courseTimeBox);

		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(coursePlaceBox);

		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(courseMasterIdBox);

		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(courseCreditBox);


		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(courseTypeBox);

		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(nativeRemarkBox);
		
		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(buttonBox);
		mainBox.add(Box.createVerticalStrut(20));
		this.add(mainBox);	
		this.pack();
		this.setResizable(false);
		this.setTitle("添加课程");
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int)screen.getWidth()/4, (int)screen.getHeight()/5);
		initListeners();
	}


	private void initListeners() {
		this.confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				add();
			}
		});
		this.cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clean();
				setVisible(false);
			}
		});
	}


	//添加用户
	private void add() {
		if (this.courseID.getText().equals("") || this.courseName.getText().equals("")
				|| courseTime.getText().equals("")||this.coursePlace.getText().equals("")
				) {
			ViewUtil.showWarn("请输入完成的课程信息", this);
			return;
		}
		try {
			//调用业务接口添加课程项
			Course course = getCourse();
			Course course1 = ApplicationContext.courseDao.findCourse(course.getCOURSENAME());
			ApplicationContext.courseService.addCourse(getCourse());
			
			this.setVisible(false);
			this.coursePanel.readData();
			clean();
		} catch (Exception e) {
			e.printStackTrace();
			ViewUtil.showWarn(e.getMessage(), this);
		}
	}

	//清空界面元素
	private void clean() {
		courseID.setText("");
		courseName.setText("");
		courseTime.setText("");
		coursePlace.setText("");
		courseMasterId.setText("");
		courseCredit.setText("");
		courseType.setText("");
		courseRemark.setText("");
	}

	
	/*
	 ID,
		COURSENAME,
		COURSETIME,
		COURSEPLACE,
		COURSEMASTERID,
		COURSECREDIT,
		COURSETYPE,
		COURSEREMARK,*/
	//从界面元素中得到各个值, 并创建User对象
	private Course getCourse() {
		String courseIDStr = this.courseID.getText().toString();
		String courseNameStr = this.courseName.getText().toString();
		String courseTimeStr = this.courseTime.getText().toString();
		String coursePlaceStr = this.coursePlace.getText().toString();
		
		String courseMasterIdStr = courseMasterId.getText().toString();
		String courseCreditStr = courseCredit.getText().toString();
		String courseTypeStr = courseType.getText().toString();
		String courseRemarkStr = courseRemark.getText().toString();
		

		Course course = new Course();
		course.setID(courseIDStr);
		course.setCOURSENAME(courseNameStr);
		course.setCOURSETIME(courseTimeStr);
		course.setCOURSEPLACE(coursePlaceStr);
		course.setCOURSEMASTERID(courseMasterIdStr);
		course.setCOURSECREDIT(courseCreditStr);
		course.setCOURSETYPE(courseTypeStr);
		course.setCOURSEREMARK(courseRemarkStr);
		course.setISDELETE("0");
		return course;
	}
}
