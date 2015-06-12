package com.zhl.oa.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntPathRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;
import org.springframework.util.Assert;

import com.zhl.oa.dao.ResourceDao;
import com.zhl.oa.domain.ResourceResult;

public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	protected final Log logger = LogFactory.getLog(getClass());

	private final Map<RequestMatcher, Collection<ConfigAttribute>> requestMap = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();

	private ResourceDao resourceDao;

	// ~ Constructors
	// ===================================================================================================

    /**
	 * Sets the internal request map from the supplied map. The key elements
	 * should be of type {@link RequestMatcher}, which. The path stored in the
	 * key will depend on the type of the supplied UrlMatcher.
	 * 
	 * @param requestMap
	 *            order-preserving map of request definitions to attribute lists
	 */
	public MyFilterInvocationSecurityMetadataSource() {
		super();

	}

	public MyFilterInvocationSecurityMetadataSource(ResourceDao resourceDao) {
		super();
		this.resourceDao = resourceDao;
		Assert.notNull(resourceDao);
		loadRequestMap();
	}

	// ~ Methods
	// ========================================================================================================

    public ResourceDao getResourceDao() {
		return resourceDao;
	}

	private void loadRequestMap() {
		List<ResourceResult> resList = resourceDao.findAll();
		for (ResourceResult res : resList) {
			if (!res.getEnable()) {
				continue;
			}
			AntPathRequestMatcher aprm = new AntPathRequestMatcher(res.getUrl());
			if (requestMap.containsKey(aprm)) {
				SecurityConfig sc = new SecurityConfig(res.getRole());
				Collection<ConfigAttribute> collect = requestMap.get(aprm);
				collect.add(sc);
			} else {
				Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
				SecurityConfig sc = new SecurityConfig(res.getRole());
				configAttributes.add(sc);
				requestMap.put(aprm, configAttributes);
			}
		}
		return;
	}

	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
		loadRequestMap();
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		/*
		 * loadRequestMap(); Set<ConfigAttribute> allAttributes = new
		 * HashSet<ConfigAttribute>();
		 * 
		 * for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry :
		 * requestMap.entrySet()) { allAttributes.addAll(entry.getValue()); }
		 * 
		 * return allAttributes;
		 */
		return null;
	}

    public Collection<ConfigAttribute> getAttributes(Object object) {
		final HttpServletRequest request = ((FilterInvocation) object).getRequest();
		for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {
			if (entry.getKey().matches(request)) {
				return entry.getValue();
			}
		}
		return null;
	}

    public boolean supports(Class<?> clazz) {
		return true;
	}
}
