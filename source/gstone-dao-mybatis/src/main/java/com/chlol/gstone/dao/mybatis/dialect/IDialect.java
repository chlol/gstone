package com.chlol.gstone.dao.mybatis.dialect;

public interface IDialect {
	public boolean supportsPaged();
	public String getPagedString(String sql, boolean hasOffset);
	public String getPagedString(String sql, int offset, int limit);
}  