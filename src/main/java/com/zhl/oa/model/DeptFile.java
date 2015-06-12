package com.zhl.oa.model;

import java.util.Date;

public class DeptFile {
	/**
	 * id
	 */
	private int id;

	/**
	 * 所属文件分类id
	 */
	private int folderId;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 文件id
	 */
	private int fileId;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 创建人
	 */
	private String creator;

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFolderId() {
		return folderId;
	}

	public void setFolderId(int folderId) {
		this.folderId = folderId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
