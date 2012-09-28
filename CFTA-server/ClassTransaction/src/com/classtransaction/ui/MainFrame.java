package com.classtransaction.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;


import com.classtransaction.model.User;
import com.classtransaction.util.ApplicationContext;

public class MainFrame extends JFrame {

	private JMenuBar menuBar = new JMenuBar();
	
	private JMenu tsMenu = new JMenu("����˵�");
	
	//��ǰ�Ľ���
	private BasePanel currentPanel;
	
	
	
	//�û�����
	private UserPanel userPanel;
	//�γ̹���
	private CoursePanel coursePanel;
		
	
	//��¼������ʾ��
	private JPanel messagePanel;
	//private JTextField editbox;
	//private JButton buttonsent;
	
	//�û�����
	private Action userManage = new AbstractAction("�û�����", new ImageIcon("images/menu/person_icon1.png")) {
		public void actionPerformed(ActionEvent e) {
			changePanel(userPanel);
		}
	};
	//�û�����
	private Action courseManage = new AbstractAction("�γ̹���", new ImageIcon("images/menu/course_icon2.png")) {
		public void actionPerformed(ActionEvent e) {
			changePanel(coursePanel);
		}
	};
	
	
	
	public MainFrame() {
		this.userPanel = new UserPanel();
		this.coursePanel = new CoursePanel();
		
		messagePanel = new JPanel();
		//editbox = new JTextField("sdfsdfsd");
		//buttonsent = new JButton("sent");
		//messagePanel.add(editbox);
		//messagePanel.add(buttonsent);
		
		createMenu();
		this.add(userPanel);
		this.currentPanel = userPanel;
		this.currentPanel.readData();
		//this.add(this.currentPanel);
		//this.add(messagePanel);
		
		this.pack();
		this.repaint();
		this.setTitle("�༶�������ϵͳ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int)screen.getWidth()/2-this.getWidth()/2, (int)screen.getHeight()/2-this.getHeight()/2);
	}

	private void createMenu() {
		this.tsMenu.add(this.userManage);
		this.tsMenu.add(this.courseManage);
		//�ж�Ȩ��
		/*User loginUser = ApplicationContext.loginUser;
		//System.out.println(loginUser.getRole().getROLE_NAME());
		if (loginUser.getRole().getCOURSE_AUTHORITY().equals("1")) {
			this.tsMenu.remove(2);
		} else if (loginUser.getRole().getROLE_NAME().equals("employee")) {
			this.tsMenu.remove(2);
			this.tsMenu.remove(1);
		}*/
		this.menuBar.add(this.tsMenu);
		this.setJMenuBar(this.menuBar);
	}
	
	/**
	 * ����˵�ִ�еķ���
	 */
	private void changePanel(BasePanel panel) {
		//�Ƴ���ǰ��ʾ��JPanel
		this.remove(this.currentPanel);
		
		//�����Ҫ��ʾ��JPanel
		this.add(panel);
		
		this.currentPanel = panel;
		this.currentPanel.readData();
		this.currentPanel.add(messagePanel);
		this.pack();
		this.repaint();
		this.setVisible(true);
	}

}
