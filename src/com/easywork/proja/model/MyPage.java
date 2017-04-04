package com.easywork.proja.model;

import java.util.List;

public class MyPage<T> {
	private int total;
	private List<T> rows;
	private int pageNum = 1;//当前页数
	private int pageSize = 10;//每页显示数
	public MyPage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyPage(int total, List<T> rows, int pageNum, int pageSize) {
		super();
		this.total = total;
		this.rows = rows;
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
}
