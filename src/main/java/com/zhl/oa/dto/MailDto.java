package com.zhl.oa.dto;

public class MailDto {
	private int id;

	/**
	 * 邮件标题
	 */
	private String title;

	/**
	 * 内容
	 */
	private String content;

	/**
	 * 附件id
	 */
	private int fileId;

	/**
	 * 收件人id
	 */
	private String to;

	/**
	 * 发件人id
	 */
	private String from;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
}
