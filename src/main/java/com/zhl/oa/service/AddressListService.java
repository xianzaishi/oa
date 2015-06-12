package com.zhl.oa.service;

import java.util.List;

import com.zhl.oa.dto.AddressDto;
import com.zhl.oa.model.Address;

/**
 * 通讯录服务层接口
 * 
 * @author 张宏亮
 * 
 */
public interface AddressListService {
	/**
	 * 新增
	 * 
	 * @param address
	 */
	public void add(Address address);

	/**
	 * 分页内容
	 * 
	 * @param start
	 * @param maxResults
	 * @return
	 */
	public List<AddressDto> queryAddressListForPage(int start, int maxResults);

	/**
	 * 通讯录数
	 * 
	 * @return
	 */
	public int queryAddressCount();

	/**
	 * 根据id查询通讯录
	 * 
	 * @param id
	 * @return
	 */
	public Address queryAddressById(int id);

	/**
	 * 根据id删除通讯录
	 * 
	 * @param ids
	 *            List<Integer>
	 */
	public void deleteAddressById(List<Integer> ids);

	/**
	 * 模糊搜索内容
	 * 
	 * @param keyword
	 * @return
	 */
	public List<AddressDto> queryAddressByKeyword(String keyword, int start, int maxResults);

	/**
	 * 查询内容
	 * 
	 * @param id
	 * @return
	 */
	public int keywordSearchResultCount(String keyword);
}
