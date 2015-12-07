package com.chlol.gstone.dao.mybatis.dialect.impl;

import com.chlol.gstone.dao.mybatis.dialect.IDialect;

public class SQLServerDialect implements IDialect {
	public String getPagedString(String sql, boolean hasOffset)
	{
		return null;
	}

	public String getPagedString(String sql, int offset, int limit)
	{
		if (offset > 0) {
			throw new UnsupportedOperationException("sql server has no offset");
		}
		return new StringBuffer(sql.length() + 8).append(sql).insert(getAfterSelectInsertPoint(sql), " top " + limit).toString();
	}

	static int getAfterSelectInsertPoint(String sql)
	{
		int selectIndex = sql.toLowerCase().indexOf("select");
		final int selectDistinctIndex = sql.toLowerCase().indexOf("select distinct");
		return selectIndex + (selectDistinctIndex == selectIndex ? 15 : 6);
	}

	public boolean supportsPaged()
	{
		return false;
	}

}
