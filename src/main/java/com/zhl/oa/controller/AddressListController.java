package com.zhl.oa.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhl.oa.constant.CmsUrl;
import com.zhl.oa.constant.CmsView;
import com.zhl.oa.dto.AddressDto;
import com.zhl.oa.model.Address;
import com.zhl.oa.model.Department;
import com.zhl.oa.service.AddressListService;
import com.zhl.oa.service.DeptService;

/**
 * 通讯录控制器
 * 
 * @author 张宏亮
 * 
 */
@Controller
public class AddressListController {
	@Autowired
	private AddressListService addressListService;

	@Autowired
	private DeptService deptService;

	private final String ADDRESS_INDEX_URL = "/addresslist/index/page/1";

	/**
	 * 主页
	 * 
	 * @return
	 */
	@RequestMapping(value = CmsUrl.ADDRESSLIST_INDEX)
	public String index(@PathVariable int page, ModelMap model) {
		List<AddressDto> addressList = addressListService.queryAddressListForPage((page - 1) * 20, 20);
		int count = addressListService.queryAddressCount();

		model.addAttribute("addressList", addressList);
		model.addAttribute("count", count);
		model.addAttribute("page", page);
		return CmsView.AddressListIndexView;
	}

	/**
	 * 新增通讯录页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = CmsUrl.ADDRESSLIST_ADD)
	public String add(ModelMap model) {
		List<Department> deptList = new LinkedList<Department>();
		deptList = deptService.queryDept();

		model.addAttribute("deptList", deptList);
		return CmsView.AddressListAddView;
	}

	/**
	 * 新增通讯录页面 提交
	 * 
	 * @param name
	 * @param mobile
	 * @param deptOpn
	 * @return
	 */
	@RequestMapping(value = CmsUrl.ADDRESSLIST_ADD_SUBMIT, method = RequestMethod.POST)
	public String addSubmit(String name, String mobile, int deptOpn) {
		Address address = new Address();
		address.setName(name);
		address.setMobile(mobile);
		address.setDeptId(deptOpn);

		addressListService.add(address);
		return "redirect:" + ADDRESS_INDEX_URL;
	}

	/**
	 * 删除通讯录
	 * 
	 * @param ids
	 *            List<Integer>
	 * @return
	 */
	@RequestMapping(value = CmsUrl.ADDRESSLIST_DELETE)
	public String delete(@PathVariable List<Integer> ids) {
		addressListService.deleteAddressById(ids);
		return "redirect:" + ADDRESS_INDEX_URL;
	}

	/**
	 * 搜索
	 * 
	 * @param keyword
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = CmsUrl.ADDRESSLIST_SEARCH)
	public String search(@PathVariable String keyword, @PathVariable int page, ModelMap model) {
		List<AddressDto> addressList = addressListService.queryAddressByKeyword(keyword, (page - 1) * 20, 20);
		int count = addressListService.keywordSearchResultCount(keyword);

		model.addAttribute("addressList", addressList);
		model.addAttribute("count", count);
		model.addAttribute("page", page);
		return CmsView.AddressListSearchView;
	}

}
