package com.zhl.oa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhl.oa.constant.Url;
import com.zhl.oa.constant.View;
import com.zhl.oa.model.Role;
import com.zhl.oa.model.UserRole;
import com.zhl.oa.service.RoleService;
import com.zhl.oa.service.UserService;

/**
 * UMS控制器
 * 
 * @author 张宏亮
 * 
 */
@Controller
public class UmsController {
	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	/**
	 * 登陆页面
	 * 
	 * @return
	 */
	@RequestMapping(value = Url.UMS_LOGIN)
	public String loginPage() {
		return View.LoginView;
	}

	@RequestMapping(value = Url.AccessDenied)
	public String accessDenied() {
		return View.AccessDenied;
	}

	/**
	 * UMS主页
	 * 
	 * @return
	 */
	@RequestMapping(value = Url.UMS_INDEX)
	public String indexPage() {
		return View.IndexView;
	}

	/**
	 * 用户授权页面
	 * 
	 * @return
	 */
	@RequestMapping(value = Url.UMS_USER_AUTHORIZE)
	public String userAuthorize(@PathVariable int id, ModelMap model) {
		List<Integer> roleIds;
		List<Role> roleList = roleService.queryRole();
		boolean isUserRoleExist = userService.isUserRoleExist(id);
		if (isUserRoleExist == true) {
			roleIds = userService.queryRoleIdByUserId(id);
		} else {
			roleIds = null;
		}

		model.addAttribute("userId", id);
		model.addAttribute("roleIds", roleIds);
		model.addAttribute("roleList", roleList);
		return View.UserAuthorize;
	}

	/**
	 * 授权
	 * 
	 * @param userId
	 * @param roleIds
	 * @return
	 */
	@RequestMapping(value = Url.UMS_USER_AUTHORIZE_SUBMIT)
	public String userAuthorizeSubmit(@PathVariable int userId, @PathVariable String roleIds) {
		// Map<String, Integer> params = new HashMap<String, Integer>();
		// params.put("userId", userId);
		// params.put("roleId", roleId);
		// int count = userService.queryUserRoleById(params);
		// if (count > 0) {// TODO
		//
		// }

		// 删除已有授权
		userService.deleteUserRoleByUserId(userId);

		// roleIds字符串处理
		UserRole userRole = new UserRole();
		roleIds = roleIds.substring(0, roleIds.length() - 1);
		String roleIdArray[] = roleIds.split(",");
		for (int i = 0; i < roleIdArray.length; i++) {
			// 添加新授权
			userRole.setUserId(userId);
			userRole.setRoleId(Integer.parseInt(roleIdArray[i]));
			userService.addUserRole(userRole);
		}
		return View.CloseView;
	}
}

