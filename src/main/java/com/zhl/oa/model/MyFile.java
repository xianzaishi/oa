package com.zhl.oa.model;

public class MyFile {
	/**
	 * id
	 */
	private int id;

	/**
	 * 文件名
	 */
	private String fileName;

	/**
	 * 路径
	 */
	private String path;

	/**
	 * 是否在用 1：在用 0：不在用
	 */
	private int enable;

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
