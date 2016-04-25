package com.lnngle.gstone.dao.mybatis.dialect.impl;

import com.lnngle.gstone.dao.mybatis.dialect.IDialect;

public class OracleDialect implements IDialect {
	private String ORACLE_PAGEDSQL_FORMATTER = "SELECT * FROM (SELECT A.*, ROWNUM RN FROM (@_z_#) A WHERE ROWNUM <= @_x_#) WHERE RN >= @_y_#";

	public String getPagedString(String sql, boolean hasOffset) {
		return null;
	}

	public String getPagedString(String sql, int offset, int limit) {
		offset = offset + 1;
		int endset = offset + limit - 1;
		String rs = ORACLE_PAGEDSQL_FORMATTER
				.replaceFirst("@_y_#", offset + "")
				.replaceFirst("@_x_#", endset + "").replaceFirst("@_z_#", sql);

		return rs;
	}

	public boolean supportsPaged() {
		return true;
	}
}
