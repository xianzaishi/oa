package com.zhl.oa.domain;

public class ResourceResult {
	String url;
	String type;
	boolean enable;
	String role;
	
	public ResourceResult()
	{
		this.url=null;
		this.type=null;
		this.enable=false;
		this.role=null;
	}
	
	public ResourceResult(String url,String type,boolean enable,String role)
	{
		this.url=url;
		this.type=type;
		this.enable=enable;
		this.role=role;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean getEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
