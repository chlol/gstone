package com.chlol.gstone.shiro;

public interface IUserProfileManager {
	String UserProfileManager_Name = "userProfileManager";

	/**
	 * 验证用户的账号是否正确
	 * 
	 * @param loginName
	 *            登录名
	 * @param password
	 *            登录密码
	 * @return 验证通过返回用户的信息对象UserProfile的实例，否则返回只有消息（loginMessage）的UserProfile的实例
	 */
	UserProfile checkUser(String loginName, String password);

	/**
	 * 通过用户登录名获取用户的角色、权限等信息，专用于CAS单点登录
	 * 
	 * @param loginName
	 *            登录名
	 * @return 验证通过返回用户的信息对象UserProfile的实例，否则返回只有消息（loginMessage）的UserProfile的实例
	 */
	UserProfile checkUser(String loginName);

	/**
	 * 更改密码
	 * 
	 * @param loginName
	 *            登录名
	 * @param newPassword
	 *            新密码
	 * @return 密码更改是否成功
	 */
	boolean updateUserPassword(String loginName, String newPassword);

	/**
	 * 切换职位
	 * @param userProfile
	 * 			用户profile
	 * @param posId
	 * 			职位id
	 */
	void changePosition(UserProfile userProfile, String posId);
	
	/**
	 * 获取用户登录信息
	 * @param loginId 用户登录ID
	 * @return
	 */
	Object getUserAuth(String loginId);
	
	/**
	 * 清除全部roleID对应的菜单和url缓存。
	 */
	void cleanCache();
	
}

