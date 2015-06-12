package com.zhl.oa.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhl.oa.dao.ChannelDao;
import com.zhl.oa.service.ChannelService;

/**
 * 频道服务层实现类
 * 
 * @author 张宏亮
 * 
 */
@Service
public class ChannelServiceImpl implements ChannelService {

	@Autowired
	private ChannelDao channelDao;

}
