package com.chlol.gstone.shiro;

import org.apache.shiro.authc.HostAuthenticationToken;
import org.apache.shiro.authc.RememberMeAuthenticationToken;

/**
 *
 */
public class UserProfileToken implements HostAuthenticationToken, RememberMeAuthenticationToken {
	private static final long serialVersionUID = -6240268785063798511L;

	private UserProfile userProfile = null;

	/**
	 * Whether or not 'rememberMe' should be enabled for the corresponding login
	 * attempt; default is <code>false</code>
	 */
	private boolean rememberMe = false;

	/**
	 * 
	 * @param userProfile
	 */
	public UserProfileToken(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	/**
	 * 
	 * @param userProfile
	 * @param rememberMe
	 */
	public UserProfileToken(UserProfile userProfile, boolean rememberMe) {
		this.userProfile = userProfile;
		this.rememberMe = rememberMe;
	}

	@Override
	public Object getPrincipal() {
		return this.userProfile.getLoginName();
	}

	@Override
	public Object getCredentials() {
		return this.userProfile.getPassword();
	}

	/**
	 * Sets if the submitting user wishes their identity (pricipal(s)) to be
	 * remembered across sessions. Unless overridden, the default value is
	 * <tt>false</tt>, indicating <em>not</em> to be remembered across sessions.
	 * 
	 * @param rememberMe
	 *            value inidicating if the user wishes their identity
	 *            (principal(s)) to be remembered across sessions.
	 * @since 0.9
	 */
	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	@Override
	public boolean isRememberMe() {
		return this.rememberMe;
	}

	@Override
	public String getHost() {
		return userProfile.getLoginHost();
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

}
