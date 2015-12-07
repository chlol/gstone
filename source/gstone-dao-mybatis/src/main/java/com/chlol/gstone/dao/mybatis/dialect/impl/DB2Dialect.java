package com.chlol.gstone.dao.mybatis.dialect.impl;

import com.chlol.gstone.dao.mybatis.dialect.IDialect;

public class DB2Dialect implements IDialect {
	public String getPagedString(String sql, boolean hasOffset) {
		return null;
	}

	public String getPagedString(String sql, int offset, int limit) {
		int startOfSelect = sql.toLowerCase().indexOf("select");

		StringBuffer pagingSelect = new StringBuffer(sql.length() + 100)
				.append(sql.substring(0, startOfSelect)) // add
				.append("select * from ( select ").append(getRowNumber(sql));

		if (hasDistinct(sql)) {
			pagingSelect.append(" row_.* from ( ")
					.append(sql.substring(startOfSelect)).append(" ) as row_");
		} else {
			pagingSelect.append(sql.substring(startOfSelect + 6));
		}

		pagingSelect.append(" ) as temp_ where rownumber_ ");

		if (offset > 0) {
			pagingSelect.append("between " + (offset + 1) + " and "
					+ (offset + limit));
		} else {
			pagingSelect.append("<= " + limit);
		}

		return pagingSelect.toString();
	}

	public boolean supportsPaged() {
		return false;
	}

	private String getRowNumber(String sql) {
		StringBuffer rownumber = new StringBuffer(50)
				.append("rownumber() over(");

		int orderByIndex = sql.toLowerCase().indexOf("order by");

		if (orderByIndex > 0 && !hasDistinct(sql)) {
			rownumber.append(sql.substring(orderByIndex));
		}

		rownumber.append(") as rownumber_,");

		return rownumber.toString();
	}

	private static boolean hasDistinct(String sql) {
		return sql.toLowerCase().indexOf("select distinct") >= 0;
	}
}
