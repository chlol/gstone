package com.chlol.gstone.dao.mybatis.dialect;
import java.sql.Statement;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Intercepts({ @Signature(type = StatementHandler.class, method = "query", args = { Statement.class,ResultHandler.class }) })
public class DiclectStatementHandlerInterceptor implements Interceptor {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
    private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
    private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
    private static final ReflectorFactory DEFAULT_ReflectorFactory = new DefaultReflectorFactory();
    
    private IDialect dialect;
    
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		MetaObject metaObject = MetaObject.forObject(statementHandler, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY,DEFAULT_ReflectorFactory);  
		RowBounds rowBounds = (RowBounds) metaObject.getValue("delegate.rowBounds");
		if (rowBounds.getLimit() > 0 && rowBounds.getLimit() < RowBounds.NO_ROW_LIMIT) {
			BoundSql boundSql = statementHandler.getBoundSql();
			String sql = boundSql.getSql();
			sql = dialect.getPagedString(sql, rowBounds.getOffset(), rowBounds.getLimit());
			this.logger.debug(sql);
			metaObject.setValue("delegate.boundSql.sql", sql);
			metaObject.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
			metaObject.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		// do nothing
	}

	public IDialect getDialect() {
		return dialect;
	}

	public void setDialect(IDialect dialect) {
		this.dialect = dialect;
	}
}
