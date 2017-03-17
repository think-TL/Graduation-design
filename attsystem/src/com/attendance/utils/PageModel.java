package com.attendance.utils;

import java.util.List;

public class PageModel<T> {
	private int currentPage = 1;
	private int pageSize = 5;
	private int allCount;
	private int allPage;// 总页数
	private List<T> result;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getAllCount() {
		return allCount;
	}

	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}

	public int getAllPage() {
		return (allCount - 1) / pageSize + 1;
	}

	public List<T> getResult() {
		return result;
	}

	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}
}
