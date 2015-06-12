package com.zhl.oa.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhl.oa.constant.CmsUrl;
import com.zhl.oa.constant.CmsView;
import com.zhl.oa.model.Notice;
import com.zhl.oa.service.NoticeService;

/**
 * 通知控制器
 * 
 * @author 张宏亮
 * 
 */
@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;

	private final String NOTICE_INDEX_URL = "/cms/notice/page/1";

	/**
	 * 单位公告
	 * 
	 * @return
	 */
	@RequestMapping(value = CmsUrl.CMS_NOTICE)
	public String notice(@PathVariable int page, ModelMap model) {
		List<Notice> noticeList = noticeService.queryNoticeForPage((page - 1) * 20, 20);
		int count = noticeService.queryNoticeCount();

		model.addAttribute("noticeList", noticeList);
		model.addAttribute("count", count);
		model.addAttribute("page", page);
		return CmsView.NoticeView;
	}

	/**
	 * 添加通知
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = CmsUrl.CMS_NOTICE_ADD)
	public String addNotice(ModelMap model) {
		Notice notice = new Notice();
		model.addAttribute("notice", notice);
		return CmsView.AddNoticeView;
	}

	/**
	 * 添加通知
	 * 
	 * @param notice
	 * @return
	 */
	@RequestMapping(value = CmsUrl.CMS_NOTICE_ADD_SUBMIT, method = RequestMethod.POST)
	public String addNoticeSubmit(Notice notice, HttpServletRequest request) {
		HttpSession session = request.getSession();
		notice.setCreator(session.getAttribute("userName").toString());
		notice.setModifier(session.getAttribute("userName").toString());
		notice.setCreateDate(new Date());
		notice.setModifyDate(new Date());
		noticeService.addNotice(notice);
		return "redirect:" + NOTICE_INDEX_URL;
	}

	/**
	 * 删除通知
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = CmsUrl.CMS_NOTICE_DELETE)
	public String deleteNotice(@PathVariable List<Integer> ids) {
		noticeService.deleteNoticeById(ids);
		return "redirect:" + NOTICE_INDEX_URL;
	}

	/**
	 * 编辑通知页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = CmsUrl.CMS_NOTICE_EDIT)
	public String editNotice(@PathVariable int id, ModelMap model) {
		Notice notice = noticeService.queryNoticeById(id);
		model.addAttribute("notice", notice);
		return CmsView.EditNoticeView;
	}

	/**
	 * 编辑通知
	 * 
	 * @param notice
	 * @return
	 */
	@RequestMapping(value = CmsUrl.CMS_NOTICE_EDIT_SUBMIT, method = RequestMethod.POST)
	public String editNoticeSubmit(Notice notice, HttpServletRequest request) {
		HttpSession session = request.getSession();
		notice.setModifier(session.getAttribute("userName").toString());
		notice.setModifyDate(new Date());
		noticeService.updateNotice(notice);
		return "redirect:" + NOTICE_INDEX_URL;
	}

	/**
	 * 模糊搜索通知
	 * 
	 * @param keyword
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = CmsUrl.CMS_CONTENT_SEARCH, method = RequestMethod.POST)
	public String keywordSearchNotice(@PathVariable String keyword, @PathVariable int page, ModelMap model) {
		List<Notice> noticeList = noticeService.queryNoticeByKeyword(keyword, (page - 1) * 20, 20);
		int count = noticeService.keywordSearchResultCount(keyword);

		model.addAttribute("noticeList", noticeList);
		model.addAttribute("count", count);
		model.addAttribute("page", page);
		return CmsView.SearchNoticeView;
	}

	/**
	 * 预览内容
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = CmsUrl.CMS_CONTENT_PREVIEW)
	public String preview(@PathVariable int id, ModelMap model) {
		Notice notice = noticeService.queryNoticeById(id);
		model.addAttribute("notice", notice);
		return CmsView.PreviewNoticeView;
	}
}

