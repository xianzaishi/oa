package com.zhl.oa.domain;

import java.util.ArrayList;
import java.util.List;

public class UserResult {
	String username;
	String password;
	boolean enable;
	ArrayList<String> powerList;
	public UserResult()
	{
		username=null;
		password=null;
		enable=false;
		powerList = new ArrayList<String>();
	}
	
	public UserResult(String username,String password,boolean enable, ArrayList<String> powerList)
	{
		this.username=username;
		this.password=password;
		this.enable=enable;
		this.powerList=powerList;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public void addPower(String power)
	{
		if(!powerList.contains(power))
		{
			powerList.add(power);
		}
	}
	public List<String> getPower()
	{
		return powerList;
	}
}
