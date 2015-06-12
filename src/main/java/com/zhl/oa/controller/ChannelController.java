package com.zhl.oa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhl.oa.constant.CmsUrl;
import com.zhl.oa.constant.CmsView;
import com.zhl.oa.model.MyFile;
import com.zhl.oa.model.Notice;
import com.zhl.oa.model.User;
import com.zhl.oa.service.ChannelService;
import com.zhl.oa.service.NoticeService;
import com.zhl.oa.service.OfficialDocumentService;
import com.zhl.oa.service.UserService;
import com.zhl.oa.util.UserUtil;

/**
 * 频道控制器
 * 
 * @author 张宏亮
 * 
 */
@Controller
public class ChannelController {
	@Autowired
	private ChannelService channelService;

	@Autowired
	private NoticeService noticeService;

	@Autowired
	private OfficialDocumentService officialDocumentService;

	@Autowired
	private UserService userService;

	/**
	 * cms首页
	 * 
	 * @return
	 */
	@RequestMapping(value = CmsUrl.CMS_INDEX)
	public String cmsIndex(ModelMap model, HttpServletRequest request) {
		int loginFlag = 1;
		List<Notice> noticeList = noticeService.queryNoticeTopX(10);
		List<MyFile> myFileList = officialDocumentService.queryFileTopX(10);

		UserUtil userUtil = new UserUtil();
		User user = new User();
		HttpSession session = request.getSession();
		if (userUtil.isLogin(request)) {
			user.setUserName(userUtil.getUserName(request));
			user = userService.queryUserByUserName(user.getUserName());

			session.setAttribute("userName", user.getUserName());
			session.setAttribute("id", user.getId());
		} else {
			loginFlag = -1;
		}

		model.addAttribute("noticeList", noticeList);
		model.addAttribute("myFileList", myFileList);
		model.addAttribute("loginFlag", loginFlag);
		return CmsView.CmsIndexView;
	}
}

