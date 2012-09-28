package com.classtransaction.ui.dialog;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.classtransaction.model.Role;
import com.classtransaction.model.User;
import com.classtransaction.ui.UserPanel;
import com.classtransaction.util.ApplicationContext;
import com.classtransaction.util.ViewUtil;


/**
 * 添加用户界面

 *
 */
public class AddUserDialog extends JDialog {

	//用户名
	private JLabel userNameLabel = new JLabel("用户名:");
	private JTextField userName = new JTextField(10);
	
	//
	private JLabel studentNumLabel = new JLabel("学号:");
	private JTextField studentNum = new JTextField(10);
	
	//密码
	private JLabel passwordLabel = new JLabel("密码:");
	private JPasswordField password = new JPasswordField(20);
	//性别
	private JLabel genderLabel = new JLabel("性别:");
	private JComboBox genderSelect = new JComboBox();
	//生日
	private JLabel birthdayLabel = new JLabel("生日:");
	private JTextField birthday = new JTextField(10);
	//地址
	private JLabel addressLabel = new JLabel("地址:");
	private JTextField address = new JTextField(20);
	
	//籍贯
	private JLabel nativePlaceLabel = new JLabel("籍贯:");
	private JTextField nativePlace = new JTextField(20);
	
	//手机
	private JLabel phoneLabel = new JLabel("手机:");
	private JTextField phone = new JTextField(20);
	//短号
	private JLabel shortphoneLabel = new JLabel("短号:");
	private JTextField shortphone = new JTextField(20);
	//e_mail
	private JLabel emailLabel = new JLabel("邮箱:");
	private JTextField email = new JTextField(20);
	
	
	//按钮
	private JButton confirmButton = new JButton("确定");
	private JButton cancelButton = new JButton("取消");
	
	private UserPanel userPanel;
	
	public AddUserDialog(UserPanel userPanel) {
		this.userPanel = userPanel;
		//用户名
		Box userNameBox = Box.createHorizontalBox();
		userNameBox.add(Box.createHorizontalStrut(30));
		userNameBox.add(this.userNameLabel);
		userNameBox.add(this.userName);
		userNameBox.add(Box.createHorizontalStrut(30));
		//学号
		Box studentNumBox = Box.createHorizontalBox();
		studentNumBox.add(Box.createHorizontalStrut(43));
		studentNumBox.add(this.studentNumLabel);
		studentNumBox.add(this.studentNum);
		studentNumBox.add(Box.createHorizontalStrut(30));
		//密码
		Box passwdBox = Box.createHorizontalBox();
		passwdBox.add(Box.createHorizontalStrut(43));
		passwdBox.add(this.passwordLabel);
		passwdBox.add(this.password);
		passwdBox.add(Box.createHorizontalStrut(30));
		
		//性别
		Box genderBox = Box.createHorizontalBox();
		genderBox.add(Box.createHorizontalStrut(43));
		genderBox.add(this.genderLabel);
		genderBox.add(this.genderSelect);
		genderBox.add(Box.createHorizontalStrut(30));
		
		
		//生日
		Box birthdayBox = Box.createHorizontalBox();
		birthdayBox.add(Box.createHorizontalStrut(43));
		birthdayBox.add(this.birthdayLabel);
		birthdayBox.add(this.birthday);
		birthdayBox.add(Box.createHorizontalStrut(30));
		//宿舍
		Box addressBox = Box.createHorizontalBox();
		addressBox.add(Box.createHorizontalStrut(43));
		addressBox.add(this.addressLabel);
		addressBox.add(this.address);
		addressBox.add(Box.createHorizontalStrut(30));
		//籍贯
		Box nativePlaceBox = Box.createHorizontalBox();
		nativePlaceBox.add(Box.createHorizontalStrut(43));
		nativePlaceBox.add(this.nativePlaceLabel);
		nativePlaceBox.add(this.nativePlace);
		nativePlaceBox.add(Box.createHorizontalStrut(30));
		//手机
		Box phoneBox = Box.createHorizontalBox();
		phoneBox.add(Box.createHorizontalStrut(43));
		phoneBox.add(this.phoneLabel);
		phoneBox.add(this.phone);
		phoneBox.add(Box.createHorizontalStrut(30));
		//短号
		Box shortphoneBox = Box.createHorizontalBox();
		shortphoneBox.add(Box.createHorizontalStrut(43));
		shortphoneBox.add(this.shortphoneLabel);
		shortphoneBox.add(this.shortphone);
		shortphoneBox.add(Box.createHorizontalStrut(30));
		//籍贯
		Box emailBox = Box.createHorizontalBox();
		emailBox.add(Box.createHorizontalStrut(43));
		emailBox.add(this.emailLabel);
		emailBox.add(this.email);
		emailBox.add(Box.createHorizontalStrut(30));
		
		
		
		
		
		//按钮
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(this.confirmButton);
		buttonBox.add(Box.createHorizontalStrut(40));
		buttonBox.add(this.cancelButton);
		
		Box mainBox = Box.createVerticalBox();
		
		
		mainBox.add(Box.createVerticalStrut(20));
		mainBox.add(userNameBox);
		
		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(studentNumBox);
		
		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(passwdBox);
		
		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(genderBox);
		
		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(birthdayBox);
		
		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(addressBox);
		
		
		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(nativePlaceBox);
		
		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(phoneBox);
		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(shortphoneBox);
		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(emailBox);
		

		
		mainBox.add(Box.createVerticalStrut(10));
		mainBox.add(buttonBox);
		mainBox.add(Box.createVerticalStrut(20));
		this.add(mainBox);	
		this.pack();
		this.setResizable(false);
		this.setTitle("新建成员");
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int)screen.getWidth()/4, (int)screen.getHeight()/5);
		initListeners();
	}
	
	//创建角色下拉
	private void createRoleSelect() {
		
			this.genderSelect.addItem("男");
			this.genderSelect.addItem("女");
		
	}
	
	@Override
	public void setVisible(boolean b) {
		super.setVisible(b);
		if (b) createRoleSelect();
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
	
	//返回密码字符串
	private String getPassword() {
		char[] passes = this.password.getPassword();
		StringBuffer password = new StringBuffer();
		for (char c : passes) {
			password.append(c);
		}
		return password.toString();
	}
	
	//添加用户
	private void add() {
		if (this.userName.getText().equals("") || this.studentNum.getText().equals("")
				|| getPassword().equals("")||this.birthday.getText().equals("")
				||this.phone.getText().equals("")) {
			ViewUtil.showWarn("请输入完成的用户信息", this);
			return;
		}
		try {
			//调用业务接口添加用户
			User user = getUser();
			User user1 = ApplicationContext.userDao.findUser(user.getUSER_NAME());
			ApplicationContext.userService.addUser(getUser());
			ApplicationContext.roleService.addRoleSynWithUser();
			this.setVisible(false);
			this.userPanel.readData();
			clean();
		} catch (Exception e) {
			e.printStackTrace();
			ViewUtil.showWarn(e.getMessage(), this);
		}
	}
	
	//清空界面元素
	private void clean() {
		//用户名
		userName.setText("");
		this.genderSelect.removeAllItems();
		//
		studentNum.setText("");
		
		//密码
		password.setText("");
		
		//生日
		birthday.setText("");
		//地址
		address.setText("");
		
		//籍贯
		nativePlace.setText("");
		
		//手机
		phone.setText("");
		//短号
		shortphone.setText("");
		//e_mail
		email.setText("");
	}
	
	//从界面元素中得到各个值, 并创建User对象
	private User getUser() {
		String userNameStr = this.userName.getText().toString();
		String studentNumStr = this.studentNum.getText().toString();
		String passwdStr = getPassword().toString();
		String birthdayStr = birthday.getText().toString();
		String genderStr = (genderSelect.getSelectedIndex()==0?"男":"女").toString();
		String addressStr = address.getText().toString();
		String nativePlaceStr = nativePlace.getText().toString();
		String phoneStr = phone.getText().toString();
		String shortphoneStr = shortphone.getText().toString();
		String emailStr = email.getText().toString();
		
		
		
		
		
		User user = new User();
		user.setUSER_NAME(userNameStr);
		user.setSNUMBER(studentNumStr);
		user.setPASS_WORD(passwdStr);
		user.setBIRTHDAY(birthdayStr);
		user.setGENDER(genderStr);
		user.setADDRESS(addressStr);
		user.setNATIVE_PLACE(nativePlaceStr);
		user.setPHONE(phoneStr);
		user.setSHORTPHONE(shortphoneStr);
		user.setEMAIL(emailStr);
		user.setIS_DELETE("0");
		return user;
	}
}
