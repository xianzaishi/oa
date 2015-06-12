package com.zhl.oa.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhl.oa.dao.OfficialDocumentDao;
import com.zhl.oa.model.DeptFile;
import com.zhl.oa.model.DeptFolder;
import com.zhl.oa.model.MyFile;
import com.zhl.oa.service.OfficialDocumentService;

/**
 * 单位文件服务层实现类
 * 
 * @author 张宏亮
 * 
 */
@Service
public class OfficialDocumentServiceImpl implements OfficialDocumentService {

	@Autowired
	private OfficialDocumentDao officialDocumentDao;

	/**
	 * 分页内容
	 * 
	 * @param start
	 * @param maxResults
	 * @return
	 */
	public List<DeptFolder> queryDeptForPage(int start, int maxResults) {
		return officialDocumentDao.queryDeptForPage(start, maxResults);
	}

	/**
	 * 查询部门文件夹数
	 * 
	 * @return
	 */
	public Integer queryDeptCount() {
		return officialDocumentDao.queryDeptCount();
	}

	/**
	 * 添加部门文件夹
	 * 
	 * @param deptFolder
	 */
	public void insertDeptFolder(DeptFolder deptFolder) {
		officialDocumentDao.insertDeptFolder(deptFolder);
	}

	/**
	 * 根据id查询部门文件夹
	 * 
	 * @param id
	 * @return
	 */
	public DeptFolder queryDeptFolderById(int id) {
		return officialDocumentDao.queryDeptFolderById(id);
	}

	/**
	 * 编辑部门文件夹
	 * 
	 * @param deptFolder
	 */
	public void editDeptFolder(DeptFolder deptFolder) {
		officialDocumentDao.editDeptFolder(deptFolder);
	}

	/**
	 * 删除部门文件夹
	 * 
	 * @param ids
	 */
	public void deleteDeptFodlerById(List ids) {
		officialDocumentDao.deleteDeptFodlerById(ids);
	}

	/**
	 * 部门文件列表分页内容
	 * 
	 * @param start
	 * @param maxResults
	 * @return
	 */
	public List<DeptFile> queryDeptFileForPage(int folderId, int start, int maxResults) {
		return officialDocumentDao.queryDeptFileForPage(folderId, start, maxResults);
	}

	/**
	 * 查询最新的x条内容
	 * 
	 * @param x
	 * @return
	 */
	public List<MyFile> queryFileTopX(int x) {
		return officialDocumentDao.queryFileTopX(x);
	}

	/**
	 * 查询部门文件数
	 * 
	 * @return
	 */
	public Integer queryDeptFileCount() {
		return officialDocumentDao.queryDeptCount();
	}

	/**
	 * 添加文件
	 * 
	 * @param myFile
	 */
	public int addFile(MyFile myFile) {
		return officialDocumentDao.addFile(myFile);
	}

	/**
	 * 添加部门文件
	 * 
	 * @param deptFile
	 */
	public void addDeptFile(DeptFile deptFile) {
		officialDocumentDao.addDeptFile(deptFile);
	}

	/**
	 * 根据id查文件
	 * 
	 * @param id
	 * @return
	 */
	public DeptFile queryDeptFileById(int id) {
		return officialDocumentDao.queryDeptFileById(id);
	}

	/**
	 * 根据id查文件
	 * 
	 * @param id
	 * @return
	 */
	public MyFile queryFileById(int id) {
		return officialDocumentDao.queryFileById(id);
	}

	/**
	 * 删除文件
	 * 
	 * @param ids
	 */
	@Transactional(rollbackFor = Exception.class)
	public void deleteFileById(List<Integer> ids) {
		officialDocumentDao.deleteFileById(ids);
		officialDocumentDao.deleteDeptFileById(ids);
	}

}
