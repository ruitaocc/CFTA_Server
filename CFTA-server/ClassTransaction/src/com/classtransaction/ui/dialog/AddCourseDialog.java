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
	//�γ̱��
	private JLabel courseIDLabel = new JLabel("�γ̱��:");
	private JTextField courseID = new JTextField(10);
	//�γ�����
	private JLabel courseNameLabel = new JLabel("�γ�����:");
	private JTextField courseName = new JTextField(10);

	//�Ͽ�ʱ��
	private JLabel courseTimeLabel = new JLabel("�Ͽ�ʱ��:");
	private JTextField courseTime = new JTextField(10);

	//�Ͽεص�
	private JLabel coursePlaceLabel = new JLabel("�Ͽεص�:");
	private JTextField coursePlace = new JTextField(10);
	//��ʦ����
	private JLabel courseMasterIdLabel = new JLabel("��ʦ����:");
	private JTextField courseMasterId = new JTextField(10);
	//�γ�ѧ��
	private JLabel courseCreditLabel = new JLabel("�γ�ѧ��:");
	private JTextField courseCredit = new JTextField(10);
	//�γ����
	private JLabel courseTypeLabel = new JLabel("�γ����:");
	private JTextField courseType = new JTextField(20);

	//�γ̱�ע
	private JLabel courseRemarkLabel = new JLabel("�γ̱�ע:");
	private JTextField courseRemark = new JTextField(20);
	//��ť
	private JButton confirmButton = new JButton("ȷ��");
	private JButton cancelButton = new JButton("ȡ��");
	private CoursePanel coursePanel;
	public AddCourseDialog(CoursePanel coursePanel) {
		this.coursePanel = coursePanel;
		//�γ̱��
		Box courseIDBox = Box.createHorizontalBox();
		courseIDBox.add(Box.createHorizontalStrut(43));
		courseIDBox.add(this.courseIDLabel);
		courseIDBox.add(this.courseID);
		courseIDBox.add(Box.createHorizontalStrut(30));
		//�γ�����
		Box courseNameBox = Box.createHorizontalBox();
		courseNameBox.add(Box.createHorizontalStrut(43));
		courseNameBox.add(this.courseNameLabel);
		courseNameBox.add(this.courseName);
		courseNameBox.add(Box.createHorizontalStrut(30));
		//�Ͽ�ʱ��
		Box courseTimeBox = Box.createHorizontalBox();
		courseTimeBox.add(Box.createHorizontalStrut(43));
		courseTimeBox.add(this.courseTimeLabel);
		courseTimeBox.add(this.courseTime);
		courseTimeBox.add(Box.createHorizontalStrut(30));
		//�Ͽεص�
		Box coursePlaceBox = Box.createHorizontalBox();
		coursePlaceBox.add(Box.createHorizontalStrut(43));
		coursePlaceBox.add(this.coursePlaceLabel);
		coursePlaceBox.add(this.coursePlace);
		coursePlaceBox.add(Box.createHorizontalStrut(30));
		//��ʦ����
		Box courseMasterIdBox = Box.createHorizontalBox();
		courseMasterIdBox.add(Box.createHorizontalStrut(43));
		courseMasterIdBox.add(this.courseMasterIdLabel);
		courseMasterIdBox.add(this.courseMasterId);
		courseMasterIdBox.add(Box.createHorizontalStrut(30));
		//�γ�ѧ��
		Box courseCreditBox = Box.createHorizontalBox();
		courseCreditBox.add(Box.createHorizontalStrut(43));
		courseCreditBox.add(this.courseCreditLabel);
		courseCreditBox.add(this.courseCredit);
		courseCreditBox.add(Box.createHorizontalStrut(30));
		//�γ����
		Box courseTypeBox = Box.createHorizontalBox();
		courseTypeBox.add(Box.createHorizontalStrut(43));
		courseTypeBox.add(this.courseTypeLabel);
		courseTypeBox.add(this.courseType);
		courseTypeBox.add(Box.createHorizontalStrut(30));
		//�γ̱�ע
		Box nativeRemarkBox = Box.createHorizontalBox();
		nativeRemarkBox.add(Box.createHorizontalStrut(43));
		nativeRemarkBox.add(this.courseRemarkLabel);
		nativeRemarkBox.add(this.courseRemark);
		nativeRemarkBox.add(Box.createHorizontalStrut(30));
		//��ť
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
		this.setTitle("��ӿγ�");
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


	//����û�
	private void add() {
		if (this.courseID.getText().equals("") || this.courseName.getText().equals("")
				|| courseTime.getText().equals("")||this.coursePlace.getText().equals("")
				) {
			ViewUtil.showWarn("��������ɵĿγ���Ϣ", this);
			return;
		}
		try {
			//����ҵ��ӿ���ӿγ���
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

	//��ս���Ԫ��
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
	//�ӽ���Ԫ���еõ�����ֵ, ������User����
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
