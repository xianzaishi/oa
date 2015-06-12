package com.zhl.oa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhl.oa.dto.AddressDto;
import com.zhl.oa.model.Address;

/**
 * 通讯录Dao
 * 
 * @author 张宏亮
 * 
 */
@Repository
public class AddressListDao extends BaseDao{
	/**
	 * 新增
	 * 
	 * @param address
	 */
	public void add(Address address) {
		getSqlMapClientTemplate().insert("address.add", address);
	}

	/**
	 * 分页内容
	 * 
	 * @param start
	 * @param maxResults
	 * @return
	 */
	public List<AddressDto> queryAddressListForPage(int start, int maxResults) {
		return (List<AddressDto>) getSqlMapClientTemplate().queryForList("address.queryAddressDtoList", start, maxResults);
	}

	/**
	 * 通讯录数
	 * 
	 * @return
	 */
	public int queryAddressCount() {
		return (Integer) getSqlMapClientTemplate().queryForObject("address.queryAddressCount");
	}

	/**
	 * 根据id查询通讯录
	 * 
	 * @param id
	 * @return
	 */
	public Address queryAddressById(int id) {
		return (Address) getSqlMapClientTemplate().queryForObject("address.queryAddressById", id);
	}

	/**
	 * 根据id删除通讯录
	 * 
	 * @param ids
	 *            List<Integer>
	 */
	public void deleteAddressById(List<Integer> ids) {
		getSqlMapClientTemplate().delete("address.deleteAddressById", ids);
	}

	/**
	 * 模糊搜索内容
	 * 
	 * @param keyword
	 * @return
	 */
	public List<AddressDto> queryAddressByKeyword(String keyword, int start, int maxResults) {
		return (List<AddressDto>) getSqlMapClientTemplate().queryForList("address.queryAddressByKeyword", keyword, start, maxResults);
	}

	/**
	 * 查询内容
	 * 
	 * @param id
	 * @return
	 */
	public int keywordSearchResultCount(String keyword) {
		return (Integer) getSqlMapClientTemplate().queryForObject("address.keywordSearchResultCount", keyword);
	}
}
