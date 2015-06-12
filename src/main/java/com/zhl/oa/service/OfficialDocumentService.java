package com.zhl.oa.service;

import java.util.List;

import com.zhl.oa.model.DeptFile;
import com.zhl.oa.model.DeptFolder;
import com.zhl.oa.model.MyFile;

/**
 * 单位文件服务层接口
 * 
 * @author 张宏亮
 * 
 */
public interface OfficialDocumentService {
	/**
	 * 分页内容
	 * 
	 * @param start
	 * @param maxResults
	 * @return
	 */
	public List<DeptFolder> queryDeptForPage(int start, int maxResults);

	/**
	 * 查询部门文件夹数
	 * 
	 * @return
	 */
	public Integer queryDeptCount();

	/**
	 * 添加部门文件夹
	 * 
	 * @param deptFolder
	 */
	public void insertDeptFolder(DeptFolder deptFolder);

	/**
	 * 根据id查询部门文件夹
	 * 
	 * @param id
	 * @return
	 */
	public DeptFolder queryDeptFolderById(int id);

	/**
	 * 编辑部门文件夹
	 * 
	 * @param deptFolder
	 */
	public void editDeptFolder(DeptFolder deptFolder);

	/**
	 * 删除部门文件夹
	 * 
	 * @param ids
	 */
	public void deleteDeptFodlerById(List ids);

	/**
	 * 部门文件列表分页内容
	 * 
	 * @param start
	 * @param maxResults
	 * @return
	 */
	public List<DeptFile> queryDeptFileForPage(int folderId, int start, int maxResults);

	/**
	 * 查询最新的x条内容
	 * 
	 * @param x
	 * @return
	 */
	public List<MyFile> queryFileTopX(int x);

	/**
	 * 查询部门文件数
	 * 
	 * @return
	 */
	public Integer queryDeptFileCount();

	/**
	 * 添加文件
	 * 
	 * @param myFile
	 */
	public int addFile(MyFile myFile);

	/**
	 * 添加部门文件
	 * 
	 * @param deptFile
	 */
	public void addDeptFile(DeptFile deptFile);

	/**
	 * 根据id查文件
	 * 
	 * @param id
	 * @return
	 */
	public DeptFile queryDeptFileById(int id);

	/**
	 * 根据id查文件
	 * 
	 * @param id
	 * @return
	 */
	public MyFile queryFileById(int id);

	/**
	 * 删除文件
	 * 
	 * @param ids
	 */
	public void deleteFileById(List<Integer> ids);
}
