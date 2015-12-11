package com.chlol.gstone.dao.mybatis;

public final class MybatisConstants {
	public final static String SYMBOL_DOT = ".";
	
	public final static String MYBATIS_CONFIG_FILE = "mybatis-config.xml";
	public final static String MYBATIS_MAPPER_ROOT = "mybatis_mappers";
	public final static String MYBATIS_MAPPER_POSTFIX = "mapper.xml";
	
	public final static String STATEMENT_ID_KEY = "STATEMENT_ID";
	
	public final static String PAGGING_SIZE_KEY = "PAGGING_SIZE";	
	public final static String PAGGING_OFFSET_KEY = "PAGGING_OFFSET";
	public final static int PAGGING_DEFAULT_SIZE_VALUE = 20;
	public final static int PAGGING_DEFAULT_OFFSET_VALUE = 0;
	
	public final static String RESULT_DATA_KEY = "RESULT_DATA";
	public final static String RESULT_COUNT_KEY = "RESULT_COUNT";
	
	public final static String EXECUTE_TYPE_KEY = "EXECUTE_TYPE";
	public final static String EXECUTE_TYPE_INSERT = "insert";
	public final static String EXECUTE_TYPE_UPDATE = "update";
	public final static String EXECUTE_TYPE_DELETE = "delete";
	public final static String EXECUTE_TYPE_GET = "get";
	public final static String EXECUTE_TYPE_GET_ALL = "getAll";
	public final static String EXECUTE_TYPE_SEARCH_ALL = "searchAll";
	public final static String EXECUTE_TYPE_SEARCH_FOR_PAGING = "searchForPaging";
	
	public final static String PK_NAME_KEY = "id";
	
	public final static String SQL_KEYWORD_FROM_1 = "FROM";
	public final static String SQL_KEYWORD_FROM_2 = "from";
	public final static String SQL_KEYWORD_ORDER_BY = "order by";
	
	public static final String SQL_KEYWORD_ORDER = "order";
	public static final String SQL_KEYWORD_ASC = " ASC";
	public static final String SQL_KEYWORD_DESC = " DESC";
	
	public final static String COUNT_NAME = "totalCount";
	public final static String SELECT_COUNT = "SELECT count(*) " + COUNT_NAME
			+ " ";
}
	