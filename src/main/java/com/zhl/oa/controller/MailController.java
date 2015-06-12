package com.zhl.oa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhl.oa.constant.CmsUrl;
import com.zhl.oa.constant.CmsView;
import com.zhl.oa.dto.MailDto;
import com.zhl.oa.model.Mail;
import com.zhl.oa.service.UserService;

/**
 * 内部邮件控制器
 * 
 * @author 张宏亮
 * 
 */
@Controller
public class MailController {
	@Autowired
	private UserService userService;

	private final String MAIL_INDEX_URL = "/mail/index/page/1";

	@RequestMapping(value = CmsUrl.MAIL_INDEX)
	public String index(@PathVariable int page, ModelMap model) {
		return CmsView.MailIndexView;
	}

	@RequestMapping(value = CmsUrl.MAIL_ADD)
	public String add(ModelMap model) {
		MailDto mailDto = new MailDto();

		model.addAttribute("mailDto", mailDto);
		return CmsView.MailAddView;
	}

	@RequestMapping(value = CmsUrl.MAIL_ADD_SUBMIT)
	public String addSubmit(MailDto mailDto) {
		Mail mail = new Mail();
		mail.setTitle(mailDto.getTitle());
		mail.setContent(mailDto.getContent());

		// 根据用户名查发件人和收件人的用户id
		String toName = mailDto.getTo();
		String fromName = mailDto.getFrom();
		if (!userService.queryUserByName(toName).isEmpty() || !userService.queryUserByName(fromName).isEmpty()) {
			mail.setFrom(userService.queryUserByName(toName).get(0).getId());
			mail.setTo(userService.queryUserByName(fromName).get(0).getId());
			// TODO 插入数据库
		} else {
			// 用户名不存在

		}

		return "redirect:" + MAIL_INDEX_URL;
	}
}

