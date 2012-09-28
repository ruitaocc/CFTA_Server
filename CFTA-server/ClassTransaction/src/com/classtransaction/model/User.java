package com.classtransaction.model;

import java.net.Socket;


/**
 * common user model
 * @author Administrator
 *
 */

public class User extends ValueObject {
	//ID+�û���+����+ѧ��+�Ա�+��������+����+����+�ֻ�+�̺�+����+�Ƿ�ɾ��
	//ID+USER_NAME+PASS_WORD+SNUMBER+GENDER+BIRTHDAY+ADDRESS+NATIVEPLACE+PHONE+SHORTPHONE+EMAIL+IS_DELETE;
	//ɾ��ʱִ���߼�ɾ��
	
	
	//�û�����
	private String USER_NAME;
	
	//����
	private String PASS_WORD;
	//ѧ��
	private String SNUMBER;
	//�Ա�
	private String GENDER;
	//��������
	private String BIRTHDAY;
	//����
	private String ADDRESS;
	//����
	private String NATIVE_PLACE;
	//�ֻ�
	private String PHONE;
	//�̺�
	private String SHORTPHONE;
	//����
	private String EMAIL;
	
	//�Ƿ�ɾ��, 0û�б�ɾ��, 1Ϊ�Ѿ�ɾ��
	private String IS_DELETE;

	//�û���ɫ, �����������ݿ�
	private Role role;
	
	
	//socket
	private Socket socket;
	
	
	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSERNAME) {
		USER_NAME = uSERNAME;
	}

	public String getPASS_WORD() {
		return PASS_WORD;
	}

	public void setPASS_WORD(String pASSWORD) {
		PASS_WORD = pASSWORD;
	}

	public String getSNUMBER() {
		return SNUMBER;
	}

	public void setSNUMBER(String sNUMBER) {
		SNUMBER = sNUMBER;
	}

	public String getGENDER() {
		return GENDER;
	}

	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}

	public String getBIRTHDAY() {
		return BIRTHDAY;
	}

	public void setBIRTHDAY(String bIRTHDAY) {
		BIRTHDAY = bIRTHDAY;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	public String getNATIVE_PLACE() {
		return NATIVE_PLACE;
	}

	public void setNATIVE_PLACE(String nATIVEPLACE) {
		NATIVE_PLACE = nATIVEPLACE;
	}

	public String getPHONE() {
		return PHONE;
	}

	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}

	public String getSHORTPHONE() {
		return SHORTPHONE;
	}

	public void setSHORTPHONE(String sHORTPHONE) {
		SHORTPHONE = sHORTPHONE;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getIS_DELETE() {
		return IS_DELETE;
	}

	public void setIS_DELETE(String iSDELETE) {
		IS_DELETE = iSDELETE;
	}

	@Override
	public String toString() {
		return "User [ADDRESS=" + ADDRESS + ", BIRTHDAY=" + BIRTHDAY
				+ ", EMAIL=" + EMAIL + ", GENDER=" + GENDER + ", IS_DELETE="
				+ IS_DELETE + ", NATIVE_PLACE=" + NATIVE_PLACE + ", PASS_WORD="
				+ PASS_WORD + ", PHONE=" + PHONE + ", SHORTPHONE=" + SHORTPHONE
				+ ", SNUMBER=" + SNUMBER + ", USER_NAME=" + USER_NAME + "]";
	}

	//�����������ݿ���
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
	

	

	
	
}
