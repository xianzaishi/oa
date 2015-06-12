package com.zhl.oa.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhl.oa.dao.AddressListDao;
import com.zhl.oa.dto.AddressDto;
import com.zhl.oa.model.Address;
import com.zhl.oa.service.AddressListService;

/**
 * 通讯录服务层实现类
 * 
 * @author 张宏亮
 * 
 */
@Service
public class AddressListServiceImpl implements AddressListService {

	@Autowired
	private AddressListDao addressListDao;

	/**
	 * 新增
	 * 
	 * @param address
	 */
	public void add(Address address) {
		addressListDao.add(address);
	}

	/**
	 * 分页内容
	 * 
	 * @param start
	 * @param maxResults
	 * @return
	 */
	public List<AddressDto> queryAddressListForPage(int start, int maxResults) {
		return addressListDao.queryAddressListForPage(start, maxResults);
	}

	/**
	 * 通讯录数
	 * 
	 * @return
	 */
	public int queryAddressCount() {
		return addressListDao.queryAddressCount();
	}

	/**
	 * 根据id查询通讯录
	 * 
	 * @param id
	 * @return
	 */
	public Address queryAddressById(int id) {
		return addressListDao.queryAddressById(id);
	}

	/**
	 * 根据id删除通讯录
	 * 
	 * @param ids
	 *            List<Integer>
	 */
	public void deleteAddressById(List<Integer> ids) {
		addressListDao.deleteAddressById(ids);
	}

	/**
	 * 模糊搜索内容
	 * 
	 * @param keyword
	 * @return
	 */
	public List<AddressDto> queryAddressByKeyword(String keyword, int start, int maxResults) {
		return addressListDao.queryAddressByKeyword(keyword, start, maxResults);
	}

	/**
	 * 查询内容
	 * 
	 * @param id
	 * @return
	 */
	public int keywordSearchResultCount(String keyword) {
		return addressListDao.keywordSearchResultCount(keyword);
	}
}
