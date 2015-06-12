package com.zhl.oa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhl.oa.model.Notice;

/**
 * 内容Dao
 * 
 * @author 张宏亮
 * 
 */
@Repository
public class NoticeDao extends BaseDao{
	/**
	 * 添加内容
	 * 
	 * @param notice
	 */
	public void addNotice(Notice notice) {
		getSqlMapClientTemplate().insert("notice.addNotice", notice);
	}

	/**
	 * 分页内容
	 * 
	 * @param start
	 * @param maxResults
	 * @return
	 */
	public List<Notice> queryNoticeForPage(int start, int maxResults) {
		return (List<Notice>) getSqlMapClientTemplate().queryForList("notice.queryNotice", start, maxResults);
	}

	/**
	 * 查询内容条数
	 * 
	 * @return
	 */
	public Integer queryNoticeCount() {
		return (Integer) getSqlMapClientTemplate().queryForObject("notice.queryNoticeCount");
	}

	/**
	 * 删除内容
	 * 
	 * @param ids
	 */
	public void deleteNoticeById(List ids) {
		getSqlMapClientTemplate().delete("notice.deleteNoticeById", ids);
	}

	/**
	 * 查询内容
	 * 
	 * @param id
	 * @return
	 */
	public Notice queryNoticeById(int id) {
		return (Notice) getSqlMapClientTemplate().queryForObject("notice.queryNoticeById", id);
	}

	/**
	 * 查询最新的x条内容
	 * 
	 * @param x
	 * @return
	 */
	public List<Notice> queryNoticeTopX(int x) {
		return (List<Notice>) getSqlMapClientTemplate().queryForList("notice.queryNoticeTopX", x);
	}

	/**
	 * 编辑内容
	 * 
	 * @param notice
	 */
	public void updateNotice(Notice notice) {
		getSqlMapClientTemplate().update("notice.updateNotice", notice);
	}

	/**
	 * 模糊搜索内容
	 * 
	 * @param keyword
	 * @return
	 */
	public List<Notice> queryNoticeByKeyword(String keyword, int start, int maxResults) {
		return (List<Notice>) getSqlMapClientTemplate().queryForList("notice.queryNoticeByKeyword", keyword, start, maxResults);
	}

	/**
	 * 模糊搜索内容结果数
	 * 
	 * @param keyword
	 * @return
	 */
	public int keywordSearchResultCount(String keyword) {
		return (Integer) getSqlMapClientTemplate().queryForObject("notice.keywordSearchResultCount", keyword);
	}
}
