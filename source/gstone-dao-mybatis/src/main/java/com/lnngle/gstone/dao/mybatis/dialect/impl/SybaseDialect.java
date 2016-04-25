package com.lnngle.gstone.dao.mybatis.dialect.impl;

import com.lnngle.gstone.dao.mybatis.dialect.IDialect;

public class SybaseDialect implements IDialect {
	public String getPagedString(String sql, boolean hasOffset)
	{
		return null;
	}

	public String getPagedString(String sql, int offset, int limit)
	{

		return null;
	}

	public boolean supportsPaged()
	{
		return false;
	}
}
