package com.zhl.oa.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhl.oa.dao.NoticeDao;
import com.zhl.oa.model.Notice;
import com.zhl.oa.service.NoticeService;

/**
 * 内容服务层实现类
 * 
 * @author 张宏亮
 * 
 */
@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDao noticeDao;

	/**
	 * 添加内容
	 * 
	 * @param notice
	 */
	public void addNotice(Notice notice) {
		noticeDao.addNotice(notice);
	}

	/**
	 * 分页内容
	 * 
	 * @param start
	 * @param maxResults
	 * @return
	 */
	public List<Notice> queryNoticeForPage(int start, int maxResults) {
		return noticeDao.queryNoticeForPage(start, maxResults);
	}

	/**
	 * 查询内容条数
	 * 
	 * @return
	 */
	public Integer queryNoticeCount() {
		return noticeDao.queryNoticeCount();
	}

	/**
	 * 删除内容
	 * 
	 * @param ids
	 */
	public void deleteNoticeById(List ids) {
		noticeDao.deleteNoticeById(ids);
	}

	/**
	 * 查询内容
	 * 
	 * @param id
	 * @return
	 */
	public Notice queryNoticeById(int id) {
		return noticeDao.queryNoticeById(id);
	}

	/**
	 * 查询最新的x条内容
	 * 
	 * @param x
	 * @return
	 */
	public List<Notice> queryNoticeTopX(int x) {
		return noticeDao.queryNoticeTopX(x);
	}

	/**
	 * 编辑内容
	 * 
	 * @param notice
	 */
	public void updateNotice(Notice notice) {
		noticeDao.updateNotice(notice);
	}

	/**
	 * 模糊搜索内容
	 * 
	 * @param keyword
	 * @return
	 */
	public List<Notice> queryNoticeByKeyword(String keyword, int start, int maxResults) {
		return noticeDao.queryNoticeByKeyword(keyword, start, maxResults);
	}

	/**
	 * 模糊搜索内容结果数
	 * 
	 * @param keyword
	 * @return
	 */
	public int keywordSearchResultCount(String keyword) {
		return noticeDao.keywordSearchResultCount(keyword);
	}
}
