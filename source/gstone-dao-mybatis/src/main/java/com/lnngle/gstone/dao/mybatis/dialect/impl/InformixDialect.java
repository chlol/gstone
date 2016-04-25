package com.lnngle.gstone.dao.mybatis.dialect.impl;

import com.lnngle.gstone.dao.mybatis.dialect.IDialect;

public class InformixDialect implements IDialect {
	public String getPagedString(String sql, boolean hasOffset) {
		return null;
	}

	public String getPagedString(String sql, int offset, int limit) {
		if (offset > 0) {
			throw new UnsupportedOperationException("informix has no offset");
		}
		return new StringBuffer(sql.length() + 8)
				.append(sql)
				.insert(sql.toLowerCase().indexOf("select") + 6,
						" first " + limit).toString();
	}

	public boolean supportsPaged() {
		return false;
	}
}
