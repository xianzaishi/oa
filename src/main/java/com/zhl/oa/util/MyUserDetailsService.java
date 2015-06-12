package com.zhl.oa.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.zhl.oa.dao.UserDao;
import com.zhl.oa.domain.UserResult;

public class MyUserDetailsService implements UserDetailsService {

	private UserDao userDao;
	
	
	public MyUserDetailsService(UserDao userDao)
	{
		super();
		this.userDao=userDao;
	}
	public MyUserDetailsService()
	{
		super();
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserResult userResult = userDao.findByName(username);
		if (userResult.getPassword() == "" || userResult.getPassword() == null)
		{
			throw new UsernameNotFoundException("Can't find the user "+username);
		}
		String password = userResult.getPassword();
		Set<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(userResult.getPower());
		UserDetails user = new User(username,password, true, true, true, true, grantedAuths);
		return user;
	}
	
	private Set<GrantedAuthority> obtionGrantedAuthorities(List<String> list)
	{
		Set<GrantedAuthority> set = new HashSet<GrantedAuthority>();
		for(String power:list)
		{
			set.add(new SimpleGrantedAuthority(power));
		}
		return set;
	}
}
