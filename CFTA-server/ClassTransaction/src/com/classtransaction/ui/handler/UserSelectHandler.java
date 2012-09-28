package com.classtransaction.ui.handler;


public interface UserSelectHandler {

	/**
	 * 在用户选择界面点击确定后执行的方法
	 * @param userId
	 * @param realName
	 */
	void confirm(String userId, String realName);
}
