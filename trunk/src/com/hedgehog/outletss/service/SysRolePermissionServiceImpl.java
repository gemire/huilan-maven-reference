package com.hedgehog.outletss.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.ehcache.annotations.Cacheable;
import com.googlecode.ehcache.annotations.TriggersRemove;
import com.googlecode.ehcache.annotations.When;
import com.hedgehog.outletss.domain.QueryPara;
import com.hedgehog.outletss.domain.SysRolePermission;
import com.hedgehog.outletss.persistence.SysRolePermissionDao;

@Service("rolePermissionService")
@Transactional(propagation=Propagation.REQUIRED)
public class SysRolePermissionServiceImpl implements SysRolePermissionService{
	
	private SysRolePermissionDao rolePermissionDao;
	
	@Autowired
	public void setRolePermissionDao(SysRolePermissionDao rolePermissionDao) {
		this.rolePermissionDao = rolePermissionDao;
	}
	
	public void deleteByPrimaryKey(Serializable roleId) {
		// TODO Auto-generated method stub
		
	}
	
	public void saveOrUpdate(SysRolePermission record) {
		// TODO Auto-generated method stub
		this.rolePermissionDao.saveOrUpdate(record);
	}
	
	public List<SysRolePermission> selectAllRecord() {
		// TODO Auto-generated method stub
		return this.rolePermissionDao.selectAllRecord();
	}
	
	public SysRolePermission selectByPrimaryKey(Serializable roleId) {
		// TODO Auto-generated method stub
		return this.rolePermissionDao.selectByPrimaryKey(roleId);
	}
	
	public List<SysRolePermission> selectRecordForPage(
			QueryPara<SysRolePermission> qp) {
		// TODO Auto-generated method stub
		return this.rolePermissionDao.selectRecordForPage(qp);
	}
	

}
