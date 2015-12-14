package com.chlol.gstone.shiro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserProfile implements Serializable {
	private static final long serialVersionUID = -8099856257936833318L;

	private String loginName;
	private String password;
	private String loginHost;
	private Date loginTime;
	private String loginMessage;

	private String userId;
	private String userName;
	private String orgId;
	private String orgName;
	private String deptId;
	private String deptName;
	private String defaultPositionId;
	private String defaultPositionName;
	private Map<String, String> positions;
	private Map<String, String> roles = new HashMap<String, String>();
	private Map<String, String> groups = new HashMap<String, String>();
	private List<String> permissions = new ArrayList<String>();
	private Map<String, String> roleOrgs= new HashMap<String, String>();

	public Map<String, String> getRoleOrgs() {
		return roleOrgs;
	}
	
	public void setRoleOrgs(Map<String, String> roleOrgs) {
		this.roleOrgs = roleOrgs;
	}

	public List<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginHost() {
		return loginHost;
	}

	public void setLoginHost(String loginHost) {
		this.loginHost = loginHost;
	}

	public Date getLoginTime() {
		return loginTime;
	}
	
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	
	public String getLoginMessage() {
		return loginMessage;
	}

	public void setLoginMessage(String loginMessage) {
		this.loginMessage = loginMessage;
	}	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDefaultPositionId() {
		return defaultPositionId;
	}

	public void setDefaultPositionId(String defaultPositionId) {
		this.defaultPositionId = defaultPositionId;
	}

	public String getDefaultPositionName() {
		return defaultPositionName;
	}

	public void setDefaultPositionName(String defaultPositionName) {
		this.defaultPositionName = defaultPositionName;
	}

	public Map<String, String> getPositions() {
		return positions;
	}

	public void setPositions(Map<String, String> positions) {
		this.positions = positions;
	}

	public Map<String, String> getRoles() {
		return roles;
	}

	public void setRoles(Map<String, String> roles) {
		this.roles = roles;
	}

	public Map<String, String> getGroups() {
		return groups;
	}

	public void setGroups(Map<String, String> groups) {
		this.groups = groups;
	}

}
