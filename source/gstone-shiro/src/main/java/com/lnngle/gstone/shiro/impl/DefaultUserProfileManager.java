package com.lnngle.gstone.shiro.impl;

import com.lnngle.gstone.shiro.IUserProfileManager;
import com.lnngle.gstone.shiro.UserProfile;

public class DefaultUserProfileManager implements IUserProfileManager {
	private static final String DefaultUserName = "admin";
	private static final String DefaultUserLoginFailureMessage = "Invalid user name and password";
	
	@Override
	public UserProfile checkUser(String loginName, String password) {
		UserProfile up = new UserProfile();
		if (DefaultUserName.equals(loginName)) {
			up.setLoginName(loginName);
			up.setUserName(loginName);
		} else {
			up.setLoginMessage(DefaultUserLoginFailureMessage);
		}
		return up;
	}

	@Override
	public UserProfile checkUser(String loginName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUserPassword(String loginName, String newPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void changePosition(UserProfile userProfile, String posId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getUserAuth(String loginId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cleanCache() {
		// TODO Auto-generated method stub

	}

}
