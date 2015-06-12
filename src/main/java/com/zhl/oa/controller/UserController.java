package com.zhl.oa.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhl.oa.constant.Url;
import com.zhl.oa.constant.View;
import com.zhl.oa.dto.JqGridDto;
import com.zhl.oa.model.Department;
import com.zhl.oa.model.User;
import com.zhl.oa.service.DeptService;
import com.zhl.oa.service.UserService;

/**
 * User控制器
 * 
 * @author 张宏亮
 * 
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private DeptService deptService;

	/**
	 * 用户管理首页
	 * 
	 * @return
	 */
	@RequestMapping(value = Url.UMS_USER_MANAGEMENT)
	public String loginPage() {
		return View.UserManagementView;
	}

	/**
	 * 分页显示所有用户和权限
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = Url.UMS_USER_GET)
	public JqGridDto getAllUser(int page, int rows) {
		// 总记录数
		int recordCount = 0;
		// 总页数
		int pageCount = 1;

		recordCount = userService.queryUserCount();

		List<User> user = new LinkedList<User>();
		user = userService.queryUser(page * rows, rows);

		for (int i = 0; i < user.size(); i++) {
			user.get(i).setDept(deptService.queryDeptById(Integer.parseInt(user.get(i).getDept())).getDepartment());
		}

		if (recordCount % rows > 0) {
			pageCount = recordCount / rows + 1;
		} else {
			pageCount = recordCount / rows;
		}

		JqGridDto jqGridDto = new JqGridDto();
		jqGridDto.setPage(page);
		jqGridDto.setRecordsCount(recordCount);
		jqGridDto.setTotal(pageCount);
		jqGridDto.setRows(user);
		return jqGridDto;
	}

	/**
	 * 添加用户页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.UMS_USER_ADD_PAGE)
	public String addUserPage(ModelMap model) {
		User user = new User();
		List<Department> deptList = new LinkedList<Department>();
		deptList = deptService.queryDept();
		
		model.addAttribute("user", user);
		model.addAttribute("deptList", deptList);
		return View.AddUser;
	}

	/**
	 * 添加用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = Url.UMS_ADD_USER, method = RequestMethod.POST)
	public String addUser(User user, ModelMap model) {
		if (!userService.queryUserByName(user.getUserName()).isEmpty()) {
			model.addAttribute("tip", "用户名已经存在");
			List<Department> deptList = new LinkedList<Department>();
			deptList = deptService.queryDept();

			model.addAttribute("deptList", deptList);
			return View.AddUser;
		}

		userService.addUser(user);
		return View.Success;
	}

	/**
	 * 删除用户
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = Url.UMS_DELETE_USER)
	public String deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
		return "success";
	}

	/**
	 * 编辑用户页面
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = Url.UMS_EDIT_USER_PAGE)
	public String editUserPage(@PathVariable int id, ModelMap model) {
		User user = new User();
		user = userService.queryUserById(id);
		List<Department> deptList = new LinkedList<Department>();
		deptList = deptService.queryDept();

		model.addAttribute("deptList", deptList);
		model.addAttribute("user", user);
		return View.EditUser;
	}

	/**
	 * 编辑用户
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = Url.UMS_EDIT_USER)
	public String editUser(@PathVariable int id, User user) {
		user.setId(id);
		userService.editUser(user);
		return View.UserManagementView;
	}

	/**
	 * 搜索人员页面
	 * 
	 * @param userName
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.UMS_SEARCH_USER)
	public String searchUserPage(@PathVariable String user, ModelMap model) {
		model.addAttribute("user", user);
		return View.SearchUser;
	}

	/**
	 * 查询人员
	 * 
	 * @param userName
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = Url.UMS_SEARCH_USER_GET)
	public JqGridDto searchUser(@PathVariable String userName) {
		List<User> user = new LinkedList<User>();
		user = userService.queryUserByName(userName);
		// 总记录数
		int recordCount = 0;
		// 总页数
		int pageCount = 1;

		recordCount = userService.queryUserByNameCount(userName);

		JqGridDto jqGridDto = new JqGridDto();
		jqGridDto.setPage(1);
		jqGridDto.setRecordsCount(recordCount);
		jqGridDto.setTotal(pageCount);
		jqGridDto.setRows(user);
		return jqGridDto;
	}

	/**
	 * 部门管理
	 * 
	 * @return
	 */
	@RequestMapping(Url.UMS_DEPT_MANAGEMENT)
	public String deptManagement() {
		return View.DeptManagementView;
	}

	/**
	 * 分页显示所有部门
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = Url.UMS_DEPT_GET)
	public JqGridDto getAll(int page, int rows) {
		// 总记录数
		int recordCount = 0;
		// 总页数
		int pageCount = 1;

		recordCount = deptService.queryDeptCount();

		List<Department> dept = new LinkedList<Department>();
		dept = deptService.queryDept(page * rows, rows);

		if (recordCount % rows > 0) {
			pageCount = recordCount / rows + 1;
		} else {
			pageCount = recordCount / rows;
		}

		JqGridDto jqGridDto = new JqGridDto();
		jqGridDto.setPage(page);
		jqGridDto.setRecordsCount(recordCount);
		jqGridDto.setTotal(pageCount);
		jqGridDto.setRows(dept);
		return jqGridDto;
	}

	/**
	 * 添加部门页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.UMS_DEPT_ADD_PAGE)
	public String addDeptPage(ModelMap model) {
		Department department = new Department();
		model.addAttribute("department", department);
		return View.AddDept;
	}

	/**
	 * 添加部门
	 * 
	 * @param dept
	 * @return
	 */
	@RequestMapping(value = Url.UMS_ADD_DEPT, method = RequestMethod.POST)
	public String addRole(Department dept) {
		deptService.addDept(dept);
		return View.Success;
	}

	/**
	 * 删除部门
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = Url.UMS_DELETE_DEPT)
	public String deleteDept(@PathVariable int id) {
		deptService.deleteDept(id);
		return "success";
	}

	/**
	 * 编辑部门页面
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = Url.UMS_EDIT_DEPT_PAGE)
	public String editDeptPage(@PathVariable int id, ModelMap model) {
		Department department = new Department();
		department = deptService.queryDeptById(id);

		model.addAttribute("department", department);
		return View.EditDept;
	}

	/**
	 * 编辑部门
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = Url.UMS_EDIT_DEPT)
	public String editDept(@PathVariable int id, Department dept) {
		dept.setId(id);
		deptService.editDept(dept);
		return View.Success;
	}

	/**
	 * 查询部门页面
	 * 
	 * @param dept
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Url.UMS_SEARCH_DEPT)
	public String searchRolePage(@PathVariable String dept, ModelMap model) {
		model.addAttribute("dept", dept);
		return View.SearchDept;
	}

	/**
	 * 查询角色
	 * 
	 * @param roleName
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = Url.UMS_SEARCH_DEPT_GET)
	public JqGridDto searchRole(@PathVariable String dept) {
		List<Department> department = new LinkedList<Department>();
		department = deptService.queryDeptByName(dept);
		// 总记录数
		int recordCount = 0;
		// 总页数
		int pageCount = 1;

		recordCount = deptService.queryDeptByNameCount(dept);

		JqGridDto jqGridDto = new JqGridDto();
		jqGridDto.setPage(1);
		jqGridDto.setRecordsCount(recordCount);
		jqGridDto.setTotal(pageCount);
		jqGridDto.setRows(department);
		return jqGridDto;
	}
}

