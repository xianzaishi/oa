package com.zhl.oa.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.zhl.oa.constant.CmsUrl;
import com.zhl.oa.constant.CmsView;
import com.zhl.oa.model.DeptFile;
import com.zhl.oa.model.DeptFolder;
import com.zhl.oa.model.MyFile;
import com.zhl.oa.service.OfficialDocumentService;

/**
 * 单位文件控制器
 * 
 * @author 张宏亮
 * 
 */
@Controller
public class OfficialDocumentController {
	@Autowired
	private OfficialDocumentService officialDocumentService;

	private final String DEPT_FOLDER_INDEX_URL = "/cms/official/document/page/1";

	/**
	 * 单位文件
	 * 
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = CmsUrl.CMS_OFFICIAL_DOCUMENT)
	public String officalDocument(@PathVariable int page, ModelMap model) {

		List<DeptFolder> deptFolderList = officialDocumentService.queryDeptForPage((page - 1) * 20, 20);
		int count = officialDocumentService.queryDeptCount();

		model.addAttribute("deptFolderList", deptFolderList);
		model.addAttribute("count", count);
		model.addAttribute("page", page);

		return CmsView.OfficialDocumentView;
	}

	/**
	 * 添加部门文件夹
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = CmsUrl.CMS_OFFICIAL_DOCUMENT_ADD)
	public String addDeptFolder(ModelMap model) {
		DeptFolder deptFolder = new DeptFolder();
		model.addAttribute("deptFolder", deptFolder);
		return CmsView.OfficialDocumentAddView;
	}

	/**
	 * 添加部门文件夹提交
	 * 
	 * @param deptFolder
	 * @return
	 */
	@RequestMapping(value = CmsUrl.CMS_OFFICIAL_DOCUMENT_ADD_SUBMIT)
	public String addDeptFolderSubmit(DeptFolder deptFolder) {
		officialDocumentService.insertDeptFolder(deptFolder);
		return "redirect:" + DEPT_FOLDER_INDEX_URL;
	}

	/**
	 * 编辑部门文件夹
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = CmsUrl.CMS_OFFICIAL_DOCUMENT_EDIT)
	public String editDeptFolder(@PathVariable int id, ModelMap model) {
		DeptFolder deptFolder = officialDocumentService.queryDeptFolderById(id);
		model.addAttribute("deptFolder", deptFolder);
		return CmsView.OfficialDocumentEditView;
	}

	/**
	 * 编辑部门文件夹提交
	 * 
	 * @param deptFolder
	 * @return
	 */
	@RequestMapping(value = CmsUrl.CMS_OFFICIAL_DOCUMENT_EDIT_SUBMIT)
	public String editDeptFolderSubmit(DeptFolder deptFolder) {
		officialDocumentService.editDeptFolder(deptFolder);
		return "redirect:" + DEPT_FOLDER_INDEX_URL;
	}

	/**
	 * 删除部门文件夹
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = CmsUrl.CMS_OFFICIAL_DOCUMENT_DELETE)
	public String deleteDeptFolder(@PathVariable List<Integer> ids) {
		officialDocumentService.deleteDeptFodlerById(ids);
		return "redirect:" + DEPT_FOLDER_INDEX_URL;
	}

	/**
	 * 部门文件
	 * 
	 * @param id
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = CmsUrl.CMS_OFFICIAL_DOCUMENT_FILE)
	public String deptFile(@PathVariable int id, @PathVariable int page, ModelMap model) {
		List<DeptFile> deptFilerList = officialDocumentService.queryDeptFileForPage(id, (page - 1) * 20, 20);
		int count = officialDocumentService.queryDeptFileCount();

		model.addAttribute("deptFilerList", deptFilerList);
		model.addAttribute("count", count);
		model.addAttribute("page", page);
		model.addAttribute("folderId", id);

		return CmsView.OfficialDocumentFileView;
	}

	/**
	 * 新增文件
	 * 
	 * @param folderId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = CmsUrl.CMS_OFFICIAL_DOCUMENT_FILE_ADD)
	public String addFile(@PathVariable int folderId, ModelMap model) {
		model.addAttribute("folderId", folderId);
		return CmsView.OfficialDocumentFileAddView;
	}

	/**
	 * 部门文件上传
	 * 
	 * @param request
	 * @param folderId
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value = CmsUrl.CMS_OFFICIAL_DOCUMENT_FILE_UPLOAD, method = RequestMethod.POST)
	public String fileUpload(HttpServletRequest request, int folderId) throws IllegalStateException, IOException {
		HttpSession session = request.getSession();
		String fileName = "";
		String path = "";
		// 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		// 检查form中是否有enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request)) {
			// 将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator iter = multiRequest.getFileNames();

			while (iter.hasNext()) {
				// 一次遍历所有文件
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					// 创建上传路径
					SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/ddHHmmss");
					String webRoot = request.getSession().getServletContext().getRealPath("");
					String pagePath = "/files/" + dateformat.format(new Date()); // 用于返回显示图片
					String logoPathDir = webRoot + pagePath;
					File logoSaveFile = new File(logoPathDir);
					if (!logoSaveFile.exists()) {
						logoSaveFile.mkdirs();
					}
					fileName = file.getOriginalFilename();
					path = logoPathDir + fileName;
					// 上传
					file.transferTo(new File(path));
				}

			}

		}

		MyFile myFile = new MyFile();
		myFile.setFileName(fileName);
		myFile.setPath(path);
		int fileId = officialDocumentService.addFile(myFile);

		DeptFile deptFile = new DeptFile();
		deptFile.setFileId(fileId);
		deptFile.setFolderId(folderId);
		deptFile.setCreateDate(new Date());
		deptFile.setTitle(fileName);
		deptFile.setCreator(session.getAttribute("userName").toString());
		officialDocumentService.addDeptFile(deptFile);
		return "redirect:" + "/cms/official/dept/folder/id/" + folderId + "/page/1";
	}

	/**
	 * 部门文件下载
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = CmsUrl.CMS_OFFICIAL_DOCUMENT_FILE_DOWNLOAD)
	public ResponseEntity<byte[]> fileDownload(@PathVariable int id, ModelMap model) throws IOException {
		DeptFile deptFile = officialDocumentService.queryDeptFileById(id);
		MyFile myFile = officialDocumentService.queryFileById(deptFile.getFileId());

		String path = myFile.getPath();
		HttpHeaders headers = new HttpHeaders();
		String fileName = new String(myFile.getFileName().getBytes("UTF-8"), "iso-8859-1");// 为了解决中文名称乱码问题
		fileName = URLEncoder.encode(fileName, "iso-8859-1");// 为了解决中文名称乱码问题
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(path)), headers, HttpStatus.OK);
	}

	/**
	 * 删除文件
	 * 
	 * @param ids
	 * @param folderId
	 * @return
	 */
	@RequestMapping(value = CmsUrl.CMS_OFFICIAL_DOCUMENT_FILE_DELETE)
	public String deleteFile(@PathVariable LinkedList<Integer> ids, @PathVariable int folderId) {
		officialDocumentService.deleteFileById(ids);
		return "redirect:" + "/cms/official/dept/folder/id/" + folderId + "/page/1";
	}
}

