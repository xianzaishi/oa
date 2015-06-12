package com.zhl.oa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.zhl.oa.domain.ResourceResult;

@Repository
public class ResourceDao {
	
	private JdbcTemplate jdbcTemplate;
	private static final String FIND_RESOURCE_SQL_ALL = "select a.url, a.type, b.name, a.enable from resources a, role b, resource_role c where a.id = c.resource_id and b.id = c.role_id";
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public ArrayList<ResourceResult> findAll()
	{
		final ArrayList<ResourceResult> rra = new ArrayList<ResourceResult>();
		jdbcTemplate.query(FIND_RESOURCE_SQL_ALL,new RowCallbackHandler(){
			public void processRow(ResultSet rs) throws SQLException{
				ResourceResult rr = new ResourceResult();
				rr.setUrl(rs.getString("url"));
				rr.setType(rs.getString("type"));
				rr.setEnable(rs.getBoolean("enable"));
				rr.setRole(rs.getString("name"));
				rra.add(rr);
			}
		});
		return rra;
	}
	
	
}
