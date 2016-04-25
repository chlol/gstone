package com.lnngle.gstone.dao.common.utils;

public class PageUtils {
	public static int getTotalPages(int totalRecords, int pageSize) {
		if (totalRecords < 0 || pageSize < 1) {
			return 0;
		}
		int totalPages = totalRecords / pageSize;
		int m = totalRecords % pageSize;
		if (m > 0) {
			totalPages++;
		}
		return totalPages;
	}
}
