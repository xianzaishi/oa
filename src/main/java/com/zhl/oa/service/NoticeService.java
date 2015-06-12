package com.zhl.oa.service;

import java.util.List;

import com.zhl.oa.model.Notice;


/**
 * 内容服务层接口
 * 
 * @author 张宏亮
 * 
 */
public interface NoticeService {
	/**
	 * 添加内容
	 * 
	 * @param notice
	 */
	public void addNotice(Notice notice);

	/**
	 * 分页内容
	 * 
	 * @param start
	 * @param maxResults
	 * @return
	 */
	public List<Notice> queryNoticeForPage(int start, int maxResults);

	/**
	 * 查询内容条数
	 * 
	 * @return
	 */
	public Integer queryNoticeCount();
	
	/**
	 * 删除内容
	 * 
	 * @param ids
	 */
	public void deleteNoticeById(List ids);

	/**
	 * 查询内容
	 * 
	 * @param id
	 * @return
	 */
	public Notice queryNoticeById(int id);
	
	/**
	 * 查询最新的x条内容
	 * 
	 * @param x
	 * @return
	 */
	public List<Notice> queryNoticeTopX(int x);
	
	/**
	 * 编辑内容
	 * 
	 * @param notice
	 */
	public void updateNotice(Notice notice);

	/**
	 * 模糊搜索内容
	 * 
	 * @param keyword
	 * @return
	 */
	public List<Notice> queryNoticeByKeyword(String keyword, int start, int maxResults);

	/**
	 * 模糊搜索内容结果数
	 * 
	 * @param keyword
	 * @return
	 */
	public int keywordSearchResultCount(String keyword);
}
