package com.zhl.oa.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 通知实体类
 * 
 * @author 张宏亮
 * 
 */
public class Notice implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private int id;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 内容
	 */
	private String content;

	/**
	 * 创建人
	 */
	private String creator;

	/**
	 * 最后修改人
	 */
	private String modifier;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 最后修改时间
	 */
	private Date modifyDate;

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

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
}
