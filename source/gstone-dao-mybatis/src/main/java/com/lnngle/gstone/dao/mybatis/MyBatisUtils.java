package com.lnngle.gstone.dao.mybatis;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyBatisUtils {
	private static final Logger logger = LoggerFactory.getLogger(MyBatisUtils.class);
	public static Integer getTotalCount(SqlSession session, final String statementId, final Object params) {
		int totalCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			MappedStatement mst = session.getConfiguration().getMappedStatement(statementId);
			String boundSql = mst.getBoundSql(params).getSql();
			String sql = "";
			int index = boundSql.indexOf(MybatisConstants.SQL_KEYWORD_ORDER_BY);
			if (index == -1) {
				if (boundSql.indexOf(MybatisConstants.SQL_KEYWORD_FROM_1) == -1) {
					sql = MybatisConstants.SELECT_COUNT
							+ boundSql.substring(boundSql.indexOf(MybatisConstants.SQL_KEYWORD_FROM_2));
				} else {
					sql = MybatisConstants.SELECT_COUNT
							+ boundSql.substring(boundSql.indexOf(MybatisConstants.SQL_KEYWORD_FROM_1));
				}
			} else {
				boundSql = boundSql.substring(0, index);
				if (boundSql.indexOf(MybatisConstants.SQL_KEYWORD_FROM_1) == -1) {
					sql = MybatisConstants.SELECT_COUNT
							+ boundSql.substring(boundSql.indexOf(MybatisConstants.SQL_KEYWORD_FROM_2));
				} else {
					sql = MybatisConstants.SELECT_COUNT
							+ boundSql.substring(boundSql.indexOf(MybatisConstants.SQL_KEYWORD_FROM_1));
				}
			}
			logger.debug(sql);
			pstmt = session.getConnection().prepareStatement(sql);
			DefaultParameterHandler dph = new DefaultParameterHandler(mst, params, mst.getBoundSql(params));
			dph.setParameters(pstmt);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				totalCount = rs.getInt(MybatisConstants.COUNT_NAME);
			}		
		} catch (Exception e) {
			logger.error("The query exception for:" + statementId, e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception rse) {
				logger.error("Release ResultSet failure:", rse);
			}
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception pstmte) {
				logger.error("Release PreparedStatement failure:", pstmte);
			}
		}
		return totalCount;

	}
}
