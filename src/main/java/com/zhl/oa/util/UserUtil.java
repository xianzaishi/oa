package com.zhl.oa.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;

import com.zhl.oa.model.User;
import com.zhl.oa.service.UserService;

@Controller
public class UserUtil {
	@Autowired
	private UserService userService;

	/**
	 * 获得登陆用户信息
	 * 
	 * @param request
	 * @return userName
	 */
	public String getUserName(HttpServletRequest request) {
		User user = new User();
		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		// 登录名
		user.setUserName(securityContextImpl.getAuthentication().getName());
		// 登录密码，未加密的
		// user.setPassword(securityContextImpl.getAuthentication().getCredentials().toString());
		WebAuthenticationDetails details = (WebAuthenticationDetails) securityContextImpl.getAuthentication().getDetails();
		// 获得访问地址
		// System.out.println("RemoteAddress" + details.getRemoteAddress());
		// 获得sessionid
		String sessionId = details.getSessionId();
		// // 获得当前用户所拥有的权限
		// List<GrantedAuthority> authorities = (List<GrantedAuthority>)
		// securityContextImpl.getAuthentication().getAuthorities();
		// for (GrantedAuthority grantedAuthority : authorities) {
		// System.out.println("Authority" + grantedAuthority.getAuthority());
		// }
		// if (isLogin(request)) {
		// user = userService.queryUserByUserName("admin");
		// }

		// 设置session
		// HttpSession session = request.getSession();
		// session.setAttribute("id", user.getId());
		// session.setAttribute("userName", user.getUserName());
		// session.setAttribute("dept", user.getDept());
		// session.setAttribute("realName", user.getRealName());
		return user.getUserName();
	}

	/**
	 * 判断当前是否是登陆状态
	 * 
	 * @param request
	 * @return 是否登陆
	 */
	public boolean isLogin(HttpServletRequest request) {
		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		if (null != securityContextImpl && null != securityContextImpl.getAuthentication()) {
			return true;
		} else {
			return false;
		}
	}
}
