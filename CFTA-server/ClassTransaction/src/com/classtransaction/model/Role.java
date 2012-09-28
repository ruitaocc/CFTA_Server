package com.classtransaction.model;
/**
 * 权限管理类
 * @author ruitaocc@gmail.com
 *
 */
public class Role extends ValueObject{
	//课程管理权限+卫生管理权限+财务管理权限+成员信息管理权限+活动管理权限+考勤管理权限+超级管理权限
	private String COURSE_AUTHORITY;
	private String HEALTH_AUTHORITY;
	private String FINANCE_AUTHORITY;
	private String USER_IMFO_AUTHORITY;
	private String ACTIVITY_AUTHORITY;
	private String KAOQING_AUTHORITY;
	private String SUPER_AUTHORITY;
	
	public String getCOURSE_AUTHORITY() {
		return COURSE_AUTHORITY;
	}
	public void setCOURSE_AUTHORITY(String cOURSEAUTHORITY) {
		COURSE_AUTHORITY = cOURSEAUTHORITY;
	}
	public String getHEALTH_AUTHORITY() {
		return HEALTH_AUTHORITY;
	}
	public void setHEALTH_AUTHORITY(String hEALTHAUTHORITY) {
		HEALTH_AUTHORITY = hEALTHAUTHORITY;
	}
	public String getFINANCE_AUTHORITY() {
		return FINANCE_AUTHORITY;
	}
	public void setFINANCE_AUTHORITY(String fINANCEAUTHORITY) {
		FINANCE_AUTHORITY = fINANCEAUTHORITY;
	}
	public String getUSER_IMFO_AUTHORITY() {
		return USER_IMFO_AUTHORITY;
	}
	public void setUSER_IMFO_AUTHORITY(String uSERIMFOAUTHORITY) {
		USER_IMFO_AUTHORITY = uSERIMFOAUTHORITY;
	}
	public String getACTIVITY_AUTHORITY() {
		return ACTIVITY_AUTHORITY;
	}
	public void setACTIVITY_AUTHORITY(String aCTIVITYAUTHORITY) {
		ACTIVITY_AUTHORITY = aCTIVITYAUTHORITY;
	}
	public String getKAOQING_AUTHORITY() {
		return KAOQING_AUTHORITY;
	}
	public void setKAOQING_AUTHORITY(String kAOQINGAUTHORITY) {
		KAOQING_AUTHORITY = kAOQINGAUTHORITY;
	}
	
	public String getSUPER_AUTHORITY() {
		return SUPER_AUTHORITY;
	}
	public void setSUPER_AUTHORITY(String sUPERAUTHORITY) {
		SUPER_AUTHORITY = sUPERAUTHORITY;
	}
	@Override
	public String toString() {
		return "Role [ACTIVITY_AUTHORITY=" + ACTIVITY_AUTHORITY
				+ ", COURSE_AUTHORITY=" + COURSE_AUTHORITY
				+ ", FINANCE_AUTHORITY=" + FINANCE_AUTHORITY
				+ ", HEALTH_AUTHORITY=" + HEALTH_AUTHORITY
				+ ", KAOQING_AUTHORITY=" + KAOQING_AUTHORITY
				+ ", SUPER_AUTHORITY=" + SUPER_AUTHORITY
				+ ", USER_IMFO_AUTHORITY=" + USER_IMFO_AUTHORITY + "]";
	}

}
