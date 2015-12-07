package com.chlol.gstone.dao.mybatis.dialect.impl;

import com.chlol.gstone.dao.mybatis.dialect.IDialect;

public class SQLServer2005Dialect implements IDialect {
	public String getPagedString(String sql, boolean hasOffset)
	{
		return null;
	}

	public String getPagedString(String sql, int offset, int limit)
	{
		if (offset == 0) { 
			return new StringBuffer(sql.length() + 8).append(sql).insert(getSqlAfterSelectInsertPoint(sql), " top " + limit).toString();
		} else {
			int orderByIndex = sql.toLowerCase().lastIndexOf("order by");

			if (orderByIndex <= 0) {
				throw new UnsupportedOperationException("must specify 'order by' statement to support limit operation with offset in sql server 2005");
			}

			String sqlOrderBy = sql.substring(orderByIndex + 8);
			String sqlRemoveOrderBy = sql.substring(0, orderByIndex);
			int insertPoint = getSqlAfterSelectInsertPoint(sql);
			return new StringBuffer(sql.length() + 100).append("with tempPagination as(").append(sqlRemoveOrderBy).insert(insertPoint + 23,
				" ROW_NUMBER() OVER(ORDER BY " + sqlOrderBy + ") as RowNumber,").append(
				") select * from tempPagination where RowNumber between " + (offset + 1) + " and " + (offset + limit)).toString();
		}

	}
	
	protected static int getSqlAfterSelectInsertPoint(String sql)
	{
		int selectIndex = sql.toLowerCase().indexOf("select");
		final int selectDistinctIndex = sql.toLowerCase().indexOf("select distinct");
		return selectIndex + (selectDistinctIndex == selectIndex ? 15 : 6);
	}

	public boolean supportsPaged()
	{
		return true;
	}
}
