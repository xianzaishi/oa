package com.zhl.oa.constant;

public class CmsUrl {
	public static final String CMS_BASE = "/cms";

	/**
	 * cms首页
	 */
	public static final String CMS_INDEX = CMS_BASE + "/index";

	/**
	 * 单位公告
	 */
	public static final String CMS_NOTICE = CMS_BASE + "/notice/page/{page}";

	/**
	 * 添加通知页面
	 */
	public static final String CMS_NOTICE_ADD = CMS_BASE + "/notice/add";

	/**
	 * 添加通知
	 */
	public static final String CMS_NOTICE_ADD_SUBMIT = CMS_BASE + "/notice/add/submit";

	/**
	 * 删除通知
	 */
	public static final String CMS_NOTICE_DELETE = CMS_BASE + "/notice/delete/ids/{ids}";

	/**
	 * 编辑通知页面
	 */
	public static final String CMS_NOTICE_EDIT = CMS_BASE + "/notice/edit/id/{id}";

	/**
	 * 编辑通知
	 */
	public static final String CMS_NOTICE_EDIT_SUBMIT = CMS_BASE + "/notice/edit/submit";

	/**
	 * 搜索内容
	 */
	public static final String CMS_CONTENT_SEARCH = CMS_BASE + "/content/search/keyword/{keyword}/page/{page}";

	/**
	 * 内容预览
	 */
	public static final String CMS_CONTENT_PREVIEW = CMS_BASE + "/notice/preview/id/{id}";

	/**
	 * 单位文件
	 */
	public static final String CMS_OFFICIAL_DOCUMENT = CMS_BASE + "/official/document/page/{page}";

	/**
	 * 添加部门文件夹
	 */
	public static final String CMS_OFFICIAL_DOCUMENT_ADD = CMS_BASE + "/official/dept/add";

	/**
	 * 添加部门文件夹提交
	 */
	public static final String CMS_OFFICIAL_DOCUMENT_ADD_SUBMIT = CMS_BASE + "/official/dept/add/submit";

	/**
	 * 编辑部门文件夹
	 */
	public static final String CMS_OFFICIAL_DOCUMENT_EDIT = CMS_BASE + "/official/dept/edit/id/{id}";

	/**
	 * 编辑部门文件夹提交
	 */
	public static final String CMS_OFFICIAL_DOCUMENT_EDIT_SUBMIT = CMS_BASE + "/official/dept/edit";

	/**
	 * 删除部门文件夹
	 */
	public static final String CMS_OFFICIAL_DOCUMENT_DELETE = CMS_BASE + "/official/dept/delete/ids/{ids}";

	/**
	 * 部门文件
	 */
	public static final String CMS_OFFICIAL_DOCUMENT_FILE = CMS_BASE + "/official/dept/folder/id/{id}/page/{page}";

	/**
	 * 添加部门文件
	 */
	public static final String CMS_OFFICIAL_DOCUMENT_FILE_ADD = CMS_BASE + "/official/dept/file/add/{folderId}";

	/**
	 * 上传文件
	 */
	public static final String CMS_OFFICIAL_DOCUMENT_FILE_UPLOAD = CMS_BASE + "/official/dept/file/add";

	/**
	 * 文件下载
	 */
	public static final String CMS_OFFICIAL_DOCUMENT_FILE_DOWNLOAD = CMS_BASE + "/official/dept/file/download/id/{id}";

	/**
	 * 删除文件
	 */
	public static final String CMS_OFFICIAL_DOCUMENT_FILE_DELETE = CMS_BASE + "/official/document/delete/folderId/{folderId}/ids/{ids}";

	// *****************************************通讯录**************************************
	public static final String ADDRESSLIST_BASE = "/addresslist";

	/**
	 * 主页
	 */
	public static final String ADDRESSLIST_INDEX = ADDRESSLIST_BASE + "/index/page/{page}";

	/**
	 * 新增通讯录页面
	 */
	public static final String ADDRESSLIST_ADD = ADDRESSLIST_BASE + "/add";

	/**
	 * 新增通讯录提交
	 */
	public static final String ADDRESSLIST_ADD_SUBMIT = ADDRESSLIST_BASE + "/add/submit";

	/**
	 * 编辑通讯录页面
	 */
	public static final String ADDRESSLIST_EDIT = ADDRESSLIST_BASE + "/addresslist/edit/id/{id}";

	/**
	 * 删除通讯录
	 */
	public static final String ADDRESSLIST_DELETE = ADDRESSLIST_BASE + "/delete/ids/{ids}";

	/**
	 * 搜索
	 */
	public static final String ADDRESSLIST_SEARCH = ADDRESSLIST_BASE + "/search/keyword/{keyword}/page/{page}";

	// *****************************************内部邮件**************************************
	public static final String MAIL_BASE = "/mail";

	/**
	 * 主页
	 */
	public static final String MAIL_INDEX = MAIL_BASE + "/index/page/{page}";

	/**
	 * 添加邮件页面
	 */
	public static final String MAIL_ADD = MAIL_BASE + "/add";

	/**
	 * 添加邮件页面提交
	 */
	public static final String MAIL_ADD_SUBMIT = MAIL_BASE + "/add/submit";
}
