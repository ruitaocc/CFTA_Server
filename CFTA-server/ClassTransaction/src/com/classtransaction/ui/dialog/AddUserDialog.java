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
 * ����û�����

 *
 */
public class AddUserDialog extends JDialog {

	//�û���
	private JLabel userNameLabel = new JLabel("�û���:");
	private JTextField userName = new JTextField(10);
	
	//
	private JLabel studentNumLabel = new JLabel("ѧ��:");
	private JTextField studentNum = new JTextField(10);
	
	//����
	private JLabel passwordLabel = new JLabel("����:");
	private JPasswordField password = new JPasswordField(20);
	//�Ա�
	private JLabel genderLabel = new JLabel("�Ա�:");
	private JComboBox genderSelect = new JComboBox();
	//����
	private JLabel birthdayLabel = new JLabel("����:");
	private JTextField birthday = new JTextField(10);
	//��ַ
	private JLabel addressLabel = new JLabel("��ַ:");
	private JTextField address = new JTextField(20);
	
	//����
	private JLabel nativePlaceLabel = new JLabel("����:");
	private JTextField nativePlace = new JTextField(20);
	
	//�ֻ�
	private JLabel phoneLabel = new JLabel("�ֻ�:");
	private JTextField phone = new JTextField(20);
	//�̺�
	private JLabel shortphoneLabel = new JLabel("�̺�:");
	private JTextField shortphone = new JTextField(20);
	//e_mail
	private JLabel emailLabel = new JLabel("����:");
	private JTextField email = new JTextField(20);
	
	
	//��ť
	private JButton confirmButton = new JButton("ȷ��");
	private JButton cancelButton = new JButton("ȡ��");
	
	private UserPanel userPanel;
	
	public AddUserDialog(UserPanel userPanel) {
		this.userPanel = userPanel;
		//�û���
		Box userNameBox = Box.createHorizontalBox();
		userNameBox.add(Box.createHorizontalStrut(30));
		userNameBox.add(this.userNameLabel);
		userNameBox.add(this.userName);
		userNameBox.add(Box.createHorizontalStrut(30));
		//ѧ��
		Box studentNumBox = Box.createHorizontalBox();
		studentNumBox.add(Box.createHorizontalStrut(43));
		studentNumBox.add(this.studentNumLabel);
		studentNumBox.add(this.studentNum);
		studentNumBox.add(Box.createHorizontalStrut(30));
		//����
		Box passwdBox = Box.createHorizontalBox();
		passwdBox.add(Box.createHorizontalStrut(43));
		passwdBox.add(this.passwordLabel);
		passwdBox.add(this.password);
		passwdBox.add(Box.createHorizontalStrut(30));
		
		//�Ա�
		Box genderBox = Box.createHorizontalBox();
		genderBox.add(Box.createHorizontalStrut(43));
		genderBox.add(this.genderLabel);
		genderBox.add(this.genderSelect);
		genderBox.add(Box.createHorizontalStrut(30));
		
		
		//����
		Box birthdayBox = Box.createHorizontalBox();
		birthdayBox.add(Box.createHorizontalStrut(43));
		birthdayBox.add(this.birthdayLabel);
		birthdayBox.add(this.birthday);
		birthdayBox.add(Box.createHorizontalStrut(30));
		//����
		Box addressBox = Box.createHorizontalBox();
		addressBox.add(Box.createHorizontalStrut(43));
		addressBox.add(this.addressLabel);
		addressBox.add(this.address);
		addressBox.add(Box.createHorizontalStrut(30));
		//����
		Box nativePlaceBox = Box.createHorizontalBox();
		nativePlaceBox.add(Box.createHorizontalStrut(43));
		nativePlaceBox.add(this.nativePlaceLabel);
		nativePlaceBox.add(this.nativePlace);
		nativePlaceBox.add(Box.createHorizontalStrut(30));
		//�ֻ�
		Box phoneBox = Box.createHorizontalBox();
		phoneBox.add(Box.createHorizontalStrut(43));
		phoneBox.add(this.phoneLabel);
		phoneBox.add(this.phone);
		phoneBox.add(Box.createHorizontalStrut(30));
		//�̺�
		Box shortphoneBox = Box.createHorizontalBox();
		shortphoneBox.add(Box.createHorizontalStrut(43));
		shortphoneBox.add(this.shortphoneLabel);
		shortphoneBox.add(this.shortphone);
		shortphoneBox.add(Box.createHorizontalStrut(30));
		//����
		Box emailBox = Box.createHorizontalBox();
		emailBox.add(Box.createHorizontalStrut(43));
		emailBox.add(this.emailLabel);
		emailBox.add(this.email);
		emailBox.add(Box.createHorizontalStrut(30));
		
		
		
		
		
		//��ť
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
		this.setTitle("�½���Ա");
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int)screen.getWidth()/4, (int)screen.getHeight()/5);
		initListeners();
	}
	
	//������ɫ����
	private void createRoleSelect() {
		
			this.genderSelect.addItem("��");
			this.genderSelect.addItem("Ů");
		
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
	
	//���������ַ���
	private String getPassword() {
		char[] passes = this.password.getPassword();
		StringBuffer password = new StringBuffer();
		for (char c : passes) {
			password.append(c);
		}
		return password.toString();
	}
	
	//����û�
	private void add() {
		if (this.userName.getText().equals("") || this.studentNum.getText().equals("")
				|| getPassword().equals("")||this.birthday.getText().equals("")
				||this.phone.getText().equals("")) {
			ViewUtil.showWarn("��������ɵ��û���Ϣ", this);
			return;
		}
		try {
			//����ҵ��ӿ�����û�
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
	
	//��ս���Ԫ��
	private void clean() {
		//�û���
		userName.setText("");
		this.genderSelect.removeAllItems();
		//
		studentNum.setText("");
		
		//����
		password.setText("");
		
		//����
		birthday.setText("");
		//��ַ
		address.setText("");
		
		//����
		nativePlace.setText("");
		
		//�ֻ�
		phone.setText("");
		//�̺�
		shortphone.setText("");
		//e_mail
		email.setText("");
	}
	
	//�ӽ���Ԫ���еõ�����ֵ, ������User����
	private User getUser() {
		String userNameStr = this.userName.getText().toString();
		String studentNumStr = this.studentNum.getText().toString();
		String passwdStr = getPassword().toString();
		String birthdayStr = birthday.getText().toString();
		String genderStr = (genderSelect.getSelectedIndex()==0?"��":"Ů").toString();
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
