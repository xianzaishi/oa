package com.zhl.oa.dto;

import java.util.List;

/**
 * jquery grid 数据传输对象
 * 
 * @author 张宏亮
 * 
 */
public class JqGridDto {
	private static final long serialVersionUID = 1L;

	// 需要显示的数据集
	private List rows;

	// 当前第几页
	private int page;

	// 数据总数
	private int recordsCount;

	// 可显示的页数
	private int total;

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRecordsCount() {
		return recordsCount;
	}

	public void setRecordsCount(int recordsCount) {
		this.recordsCount = recordsCount;
	}

}
