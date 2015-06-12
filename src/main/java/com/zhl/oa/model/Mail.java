package com.zhl.oa.model;

/**
 * 内部邮件实体类
 * 
 * @author 张宏亮
 * 
 */
public class Mail {

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
	private int to;

	/**
	 * 发件人id
	 */
	private int from;

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

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}
}
