package com.zhl.oa.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhl.oa.dao.DeptDao;
import com.zhl.oa.model.Department;
import com.zhl.oa.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDao deptDao;

	/**
	 * 查询部门数
	 * 
	 * @return
	 */
	public int queryDeptCount() {
		return deptDao.queryDeptCount();
	}

	/**
	 * 查询部门
	 * 
	 * @return
	 */
	public List<Department> queryDept(int maxRowCount, int rows) {
		return deptDao.queryDept(maxRowCount, rows);
	}

	/**
	 * 查询部门
	 * 
	 * @return
	 */
	public List<Department> queryDept() {
		return deptDao.queryDept();
	}

	/**
	 * 新增部门
	 * 
	 * @param dept
	 */
	public void addDept(Department dept) {
		deptDao.addDept(dept);
	}

	/**
	 * 删除部门
	 * 
	 * @param id
	 */
	public void deleteDept(int id) {
		deptDao.deleteDept(id);
	}

	/**
	 * 根据id查部门
	 * 
	 * @param id
	 * @return
	 */
	public Department queryDeptById(int id) {
		return deptDao.queryDeptById(id);
	}

	/**
	 * 编辑部门
	 * 
	 * @param dept
	 */
	public void editDept(Department dept) {
		deptDao.editDept(dept);
	}

	/**
	 * 查询部门
	 * 
	 * @param dept
	 * @return
	 */
	public List<Department> queryDeptByName(String dept) {
		return deptDao.queryDeptByName(dept);
	}

	/**
	 * 查询结果数
	 * 
	 * @param dept
	 * @return
	 */
	public int queryDeptByNameCount(String dept) {
		return deptDao.queryDeptByNameCount(dept);
	}

}
