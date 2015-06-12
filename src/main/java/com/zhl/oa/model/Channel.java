package com.zhl.oa.model;

/**
 * 频道实体类
 * 
 * @author 张宏亮
 * 
 */
public class Channel {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private int id;

	/**
	 * 父节点id
	 */
	private int parent;

	/**
	 * 节点名称
	 */
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
