package com.easywork.proja.model;

import java.util.List;

public class MyPage<T> {
	private int total;
	private List<T> rows;
	public MyPage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyPage(int total, List<T> rows) {
		super();
		this.total = total;
		this.rows = rows;
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
	
	
}
