package com.chlol.gstone.dao.common;

import java.io.Serializable;
import java.util.List;

public class PageResult<T> implements Serializable {
	private static final long serialVersionUID = -7851784969138175755L;
	private int totalPages;
	private int totalRecords;
	private List<T> data;

	public PageResult(int totalPages, int totalRecords, List<T> data) {
		this.totalPages = totalPages;
		this.totalRecords = totalRecords;
		this.data = data;
	}

	public PageResult() {
		super();
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
	
	public static void main(String[] args) {
		int c = 0;
		int p = 5;
		
		int r = c/p;
		int m = c%p;
		if (m > 0) {
			r ++;
		}
		
		System.out.println(r);
	}

}
