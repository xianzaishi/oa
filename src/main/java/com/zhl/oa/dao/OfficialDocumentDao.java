package com.zhl.oa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhl.oa.model.DeptFile;
import com.zhl.oa.model.DeptFolder;
import com.zhl.oa.model.MyFile;

/**
 * 单位文件Dao
 * 
 * @author 张宏亮
 * 
 */
@Repository
public class OfficialDocumentDao extends BaseDao{
	/**
	 * 分页内容
	 * 
	 * @param start
	 * @param maxResults
	 * @return
	 */
	public List<DeptFolder> queryDeptForPage(int start, int maxResults) {
		return (List<DeptFolder>) getSqlMapClientTemplate().queryForList("officialDocument.queryDept", start, maxResults);
	}

	/**
	 * 查询部门文件夹数
	 * 
	 * @return
	 */
	public Integer queryDeptCount() {
		return (Integer) getSqlMapClientTemplate().queryForObject("officialDocument.queryDeptCount");
	}

	/**
	 * 添加部门文件夹
	 * 
	 * @param deptFolder
	 */
	public void insertDeptFolder(DeptFolder deptFolder) {
		getSqlMapClientTemplate().insert("officialDocument.insertDeptFolder", deptFolder);
	}

	/**
	 * 根据id查询部门文件夹
	 * 
	 * @param id
	 * @return
	 */
	public DeptFolder queryDeptFolderById(int id) {
		return (DeptFolder) getSqlMapClientTemplate().queryForObject("officialDocument.queryDeptFolderById", id);
	}

	/**
	 * 编辑部门文件夹
	 * 
	 * @param deptFolder
	 */
	public void editDeptFolder(DeptFolder deptFolder) {
		getSqlMapClientTemplate().update("officialDocument.updateDeptFolder", deptFolder);
	}

	/**
	 * 删除部门文件夹
	 * 
	 * @param ids
	 */
	public void deleteDeptFodlerById(List ids) {
		getSqlMapClientTemplate().delete("officialDocument.deleteDeptFodlerById", ids);
	}

	/**
	 * 部门文件列表分页内容
	 * 
	 * @param start
	 * @param maxResults
	 * @return
	 */
	public List<DeptFile> queryDeptFileForPage(int folderId, int start, int maxResults) {
		return (List<DeptFile>) getSqlMapClientTemplate().queryForList("officialDocument.queryDeptFile", folderId, start, maxResults);
	}

	/**
	 * 查询最新的x条内容
	 * 
	 * @param x
	 * @return
	 */
	public List<MyFile> queryFileTopX(int x) {
		return (List<MyFile>) getSqlMapClientTemplate().queryForList("officialDocument.queryFileTopX", x);
	}

	/**
	 * 查询部门文件数
	 * 
	 * @return
	 */
	public Integer queryDeptFileCount() {
		return (Integer) getSqlMapClientTemplate().queryForObject("officialDocument.queryDeptFileCount");
	}

	/**
	 * 添加文件
	 * 
	 * @param myFile
	 */
	public int addFile(MyFile myFile) {
		return (Integer) getSqlMapClientTemplate().insert("officialDocument.insertFile", myFile);
	}

	/**
	 * 添加部门文件
	 * 
	 * @param deptFile
	 */
	public void addDeptFile(DeptFile deptFile) {
		getSqlMapClientTemplate().insert("officialDocument.insertDeptFile", deptFile);
	}

	/**
	 * 根据id查文件
	 * 
	 * @param id
	 * @return
	 */
	public DeptFile queryDeptFileById(int id) {
		return (DeptFile) getSqlMapClientTemplate().queryForObject("officialDocument.queryDeptFileById", id);
	}

	/**
	 * 根据id查文件
	 * 
	 * @param id
	 * @return
	 */
	public MyFile queryFileById(int id) {
		return (MyFile) getSqlMapClientTemplate().queryForObject("officialDocument.queryFileById", id);
	}

	/**
	 * 删除文件
	 * 
	 * @param ids
	 */
	public void deleteDeptFileById(List<Integer> ids) {
		getSqlMapClientTemplate().delete("officialDocument.deleteDeptFileById", ids);
	}

	/**
	 * 删除文件
	 * 
	 * @param ids
	 */
	public void deleteFileById(List<Integer> ids) {
		getSqlMapClientTemplate().delete("officialDocument.deleteFileByIds", ids);
	}

}
