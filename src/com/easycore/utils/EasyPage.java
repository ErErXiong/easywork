package com.easycore.utils;

import java.util.List;

public class EasyPage<T> {
	private int total;
	private List<T> rows;

	public EasyPage(int total, List<T> rows) {
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
